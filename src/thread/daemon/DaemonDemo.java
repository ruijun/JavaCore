package thread.daemon;

/**
 * thread.daemon
 *
 * @author rj-liang
 * @date 2021/3/23 14:49
 */
public class DaemonDemo {
    public static void main(String[] args) {
       Thread daemonThread = new Thread(new Runnable() {
           @Override
           public void run() {
               while (true) {
                   try {
                       System.out.println("i am alive");
                       Thread.sleep(500);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   } finally {
                       System.out.println("finally block");
                   }
               }
           }
       });

       daemonThread.setDaemon(true);
       daemonThread.start();
       try {
           Thread.sleep(800);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
}
