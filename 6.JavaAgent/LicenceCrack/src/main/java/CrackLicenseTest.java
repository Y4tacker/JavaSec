import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class CrackLicenseTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static boolean checkExpiry(String expireDate) {
        try {
            Date date = DATE_FORMAT.parse(expireDate);

            if (new Date().before(date)) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static void main(String[] args) {
        final String expireDate = "2020-10-01 00:00:00";

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String time = "[" + DATE_FORMAT.format(new Date()) + "] ";

                        if (checkExpiry(expireDate)) {
                            System.err.println(time + "Your license has expired, please purchase a new license!");
                        } else {
                            System.out.println(time + "Your authorization is normal and the deadline is:" + expireDate);
                            System.out.println("Cracked successfully:flag{jvavAg1ent1sVe@r1zy}");
                        }

                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}