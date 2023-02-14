package thread;
import javax.swing.*;

public class ThreadAula {
    public static void main(String[] args) throws InterruptedException {

        Thread threadEmail = new Thread(thread1);
        Thread threadContagem = new Thread(thread2);

        threadEmail.start();
        threadContagem.start();

        JOptionPane.showMessageDialog(null, "Isso foi Execultado enquanto o outro está execultando");
    }

    private static Runnable thread1 = new Thread() {
        public void run() {
            for (int i=9; i>=0;i--) {
                System.out.println("Envia um email a cada 1 segundo (Faltam: "+i+")");
                try {
                    Thread.sleep(1000);

                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private static Runnable thread2 = new Thread() {
        public void run() {
            for (int i=0; i<10;i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);

                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
