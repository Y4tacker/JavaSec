import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.List;

public class MyAgent {
    public static void agentmain(String agentArgs, Instrumentation inst){
        inst.addTransformer(new MyTransformer("E:\\LicenceCrack\\target\\classes\\CrackLicenseTest.class"),true);
        Class[] loadedClass = inst.getAllLoadedClasses();
        for (Class clazz : loadedClass){
            String className = clazz.getName();
            if (inst.isModifiableClass(clazz)){
                if (className.equals("CrackLicenseTest")){
                    try {
                        inst.retransformClasses(clazz);
                    } catch (UnmodifiableClassException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
    public static void main(String[] args) throws Exception {

        int flag = 0;
        while (true) {
            List<VirtualMachineDescriptor> list = VirtualMachine.list();

            for (VirtualMachineDescriptor desc : list) {
                if ("CrackLicenseTest".equals(desc.displayName())) {
                    System.out.println("获取到注入进程ID：" + desc.id() + "，进程名称：" + desc.displayName());
                    VirtualMachine vm = VirtualMachine.attach(desc.id());
                    String agentPath = "E:\\LicenceCrack\\target\\LicenceCrack-1.0-SNAPSHOT.jar";
                    // 注入Agent到目标JVM
                    vm.loadAgent(agentPath);
                    vm.detach();
                    flag = 1;
                    break;
                }
            }
            if (flag==1){
                break;
            }
        }
    }
}
