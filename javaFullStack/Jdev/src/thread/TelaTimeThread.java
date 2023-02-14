package thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TelaTimeThread extends JDialog {

    private JPanel jPanel = new JPanel(new GridBagLayout()); //Painel de componentes


    private JLabel descTimePomodoro = new JLabel("Atualizando cada 1s"); //Descrição do Tempo do pomodoro
    private JTextField timePomodoro = new JTextField();

    private JLabel descTimeDiario = new JLabel("Atualizando cada 2s");
    private JTextField timeDiario = new JTextField();

    private JLabel descTimeSemanal = new JLabel("Atualizando cada 3s");
    private JTextField timeSemanal = new JTextField();

    private JLabel descTimeMensal = new JLabel("Atualizando cada 4s");
    private JTextField timeMensal = new JTextField();

    private JButton botaoComecar = new JButton("Começar");
    private JButton botaoParar = new JButton("Parar");

    private Runnable thread1 = new Runnable() {
        @Override
        public void run() {
            while (true) {
                timePomodoro.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").
                        format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    };

    private Runnable thread2 = new Runnable() {
        @Override
        public void run() {
            while (true) {
                timeDiario.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").
                        format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };
    private Runnable thread3 = new Runnable() {
        @Override
        public void run() {
            while (true) {
                timeSemanal.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").
                        format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    };

    private Runnable thread4 = new Runnable() {
        @Override
        public void run() {
            while (true) {
                timeMensal.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").
                        format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };


    private Thread timeThread1;
    private Thread timeThread2;
    private Thread timeThread3;
    private Thread timeThread4;

    public TelaTimeThread() {
        setTitle("Relogio multi thread");

        setSize(new Dimension(210, 335));
        setLocationRelativeTo(null);
        setResizable(false);
        //Primeira parte do cronometro

        GridBagConstraints gridBagConstraints = new GridBagConstraints(); // Controla o posicionamento dos componentes
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(2,2,5,5);
        gridBagConstraints.anchor = gridBagConstraints.WEST;


        descTimePomodoro.setPreferredSize( new Dimension(300, 25));
        jPanel.add(descTimePomodoro, gridBagConstraints);

        timePomodoro.setPreferredSize(new Dimension(207, 25));
        gridBagConstraints.gridy ++;
        timePomodoro.setEditable(false);
        jPanel.add(timePomodoro, gridBagConstraints);


        descTimeDiario.setPreferredSize( new Dimension(300, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(descTimeDiario, gridBagConstraints);

        timeDiario.setPreferredSize(new Dimension(207, 25));
        gridBagConstraints.gridy ++;
        timeDiario.setEditable(false);
        jPanel.add(timeDiario, gridBagConstraints);


        descTimeSemanal.setPreferredSize( new Dimension(300, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(descTimeSemanal, gridBagConstraints);

        timeSemanal.setPreferredSize(new Dimension(207, 25));
        gridBagConstraints.gridy ++;
        timeSemanal.setEditable(false);
        jPanel.add(timeSemanal, gridBagConstraints);


        descTimeMensal.setPreferredSize( new Dimension(300, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(descTimeMensal, gridBagConstraints);

        timeMensal.setPreferredSize(new Dimension(207, 25));
        gridBagConstraints.gridy ++;
        timeMensal.setEditable(false);
        jPanel.add(timeMensal, gridBagConstraints);


        gridBagConstraints.gridwidth = 1;
        botaoComecar.setPreferredSize(new Dimension(100, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(botaoComecar, gridBagConstraints);

        botaoParar.setPreferredSize(new Dimension(100, 25));
        gridBagConstraints.gridx ++;
        jPanel.add(botaoParar, gridBagConstraints);


        botaoComecar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                timeThread1 = new Thread(thread1);
                timeThread1.start();

                timeThread2 = new Thread(thread2);
                timeThread2.start();

                timeThread3 = new Thread(thread3);
                timeThread3.start();

                timeThread4 = new Thread(thread4);
                timeThread4.start();

                botaoComecar.setEnabled(false);
                botaoParar.setEnabled(true);

            }
        });

        botaoParar.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeThread1.stop();
                timeThread2.stop();
                timeThread3.stop();
                timeThread4.stop();

                botaoComecar.setEnabled(true);
                botaoParar.setEnabled(false);
            }

        }));



        botaoParar.setEnabled(false);
        add(jPanel, BorderLayout.WEST);

        setVisible(true);
    }

}
