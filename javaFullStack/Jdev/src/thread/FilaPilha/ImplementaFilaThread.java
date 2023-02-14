package thread.FilaPilha;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementaFilaThread extends Thread{

    private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

    public static void add(ObjetoFilaThread objetoFilaThread) {
        pilha_fila.add(objetoFilaThread);
    }


    @Override
    public void run() {

        System.out.println("FIla Rodando");

        while (true) {

            Iterator iterator = pilha_fila.iterator();
            synchronized (iterator) { //bloqueia o acesso a essa lista por outros processos,
                // para evitar que outro processo entre na minha lista de threads

                while (iterator.hasNext()) {

                    ObjetoFilaThread processar = (ObjetoFilaThread) iterator.next();

                    // Rotina 1 a processar
                    // Rotina 2 a processar
                    // Rotina 3 a processar
                    // Rotina 4 a processar

                    System.out.println("----------------------------------");
                    System.out.println(processar.getName());
                    System.out.println(processar.getEmail());
                    System.out.println("----------------------------------");

                    iterator.remove();

                    //tempo para descarga de memoria
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        }
    }
}
