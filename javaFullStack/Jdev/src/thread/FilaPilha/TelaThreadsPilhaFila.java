package thread.FilaPilha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaThreadsPilhaFila extends JDialog {

    private JPanel jPanel = new JPanel(new GridBagLayout()); //Painel de componentes


    private JLabel descThread1 = new JLabel("nome"); //Descrição do Tempo do pomodoro
    private JTextField columThread1 = new JTextField();

    private JLabel descThread2 = new JLabel("email");
    private JTextField columThread2 = new JTextField();

    private JButton botaoComecar = new JButton("Add lista");
    private JButton botaoParar = new JButton("Parar");

    private ImplementaFilaThread fila = new ImplementaFilaThread();


    public TelaThreadsPilhaFila() {
        setTitle("Lista de threads");

        setSize(new Dimension(210, 200));
        setLocationRelativeTo(null);
        setResizable(false);



        GridBagConstraints gridBagConstraints = new GridBagConstraints(); // Controla o posicionamento dos componentes
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(2,2,5,5);
        gridBagConstraints.anchor = gridBagConstraints.WEST;


        descThread1.setPreferredSize( new Dimension(300, 25));
        jPanel.add(descThread1, gridBagConstraints);

        columThread1.setPreferredSize(new Dimension(207, 25));
        gridBagConstraints.gridy ++;
        columThread1.setEditable(true);
        jPanel.add(columThread1, gridBagConstraints);


        descThread2.setPreferredSize( new Dimension(300, 25));
        gridBagConstraints.gridy ++;
        jPanel.add(descThread2, gridBagConstraints);

        columThread2.setPreferredSize(new Dimension(207, 25));
        gridBagConstraints.gridy ++;
        columThread2.setEditable(true);
        jPanel.add(columThread2, gridBagConstraints);


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

                if (fila == null) {
                    fila = new ImplementaFilaThread();
                    fila.start();
                }

                for (int i =0; i<100; i++) {
                    ObjetoFilaThread filaThread = new ObjetoFilaThread();
                    filaThread.setName(columThread1.getText());
                    filaThread.setEmail(columThread2.getText()+ i);
                    fila.add(filaThread);
                }
            }
        });

        botaoParar.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fila.stop();
                fila = null;

            }
        }));


        fila.start();
        add(jPanel, BorderLayout.WEST);

        setVisible(true);
    }
}

