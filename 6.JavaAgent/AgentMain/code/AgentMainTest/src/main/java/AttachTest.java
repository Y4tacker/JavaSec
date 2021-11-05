import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

public class AttachTest {
    // 一个运行 Attach API 的线程子类
// 每隔半秒时间检查一次所有的 Java 虚拟机
    static class AttachThread extends Thread {

        private final List<VirtualMachineDescriptor> listBefore;

        private final String jar;

        AttachThread(String attachJar, List<VirtualMachineDescriptor> vms) {
            listBefore = vms;  // 记录程序启动时的 VM 集合
            jar = attachJar;
        }

        public void run() {
            VirtualMachine vm = null;
            List<VirtualMachineDescriptor> listAfter = null;
            try {
                int count = 0;
                while (true) {
                    listAfter = VirtualMachine.list();
                    for (VirtualMachineDescriptor vmd : listAfter) {

                        if (vmd.displayName().equals("Test")) {
                            System.out.println("进程ID：" + vmd.id() + "，进程名称：" + vmd.displayName());
                            System.out.println("捕捉到Test进程，准备Hook");
                            vm = VirtualMachine.attach(vmd.id());
                            break;
                        }
                    }
                    Thread.sleep(500);
                    count++;
                    if (null != vm || count >= 10) {
                        break;
                    }
                }
                vm.loadAgent(jar);
                vm.detach();
            } catch (Exception e) {

            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new AttachThread("E:\\AgentMainTest\\target\\AgentMainTest-1.0-SNAPSHOT.jar", VirtualMachine.list()).start();
    }
}
