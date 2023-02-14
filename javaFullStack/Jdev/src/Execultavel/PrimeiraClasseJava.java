package Execultavel;


import Classes.Aluno;
import Classes.Diretor;
import Classes.Disciplina;
import Classes.Secretaria;
import ClassesAuxiliares.FuncaoAutenticacao;
import Constantes.StatusAluno;
import Interfaces.PermitirAcesso;
import exception.ExceptionsProcessarNotas;


import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class PrimeiraClasseJava {
    public static void main(String[] args) throws ExceptionsProcessarNotas {


        String login = JOptionPane.showInputDialog("Informe o login: ");
        String senha = JOptionPane.showInputDialog("Informe sua senha: ");


        PermitirAcesso permitirAcessoSecretaria = (PermitirAcesso) new Secretaria(login, senha);
        PermitirAcesso permitirAcessoDiretor = (PermitirAcesso) new Diretor(login, senha);

        if (new FuncaoAutenticacao(permitirAcessoSecretaria).autenticarLogin() || new FuncaoAutenticacao(permitirAcessoDiretor).autenticarLogin()) {
            showMessageDialog(null, "Matricula do aluno:");

            List<Aluno> alunos = new ArrayList<Aluno>();

            HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

            int nAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantos alunos deseja cadastrar?"));

            for (int qtd = 1; qtd <= nAlunos; qtd++) {

                Aluno aluno1 = new Aluno();

                try {

                    String nome = JOptionPane.showInputDialog("Nome do aluno" + qtd + ": ");
                    int idade = Integer.parseInt(JOptionPane.showInputDialog("idade do aluno " + nome + ": "));
                    String cpf = JOptionPane.showInputDialog("CPF do aluno" + nome + ": ");
                    String dataNascimento = JOptionPane.showInputDialog("Data de nascimento do aluno" + nome + ": ");
                    String nomePai = JOptionPane.showInputDialog("Nome do pai do aluno " + nome + ": ");
                    String nomeMae = JOptionPane.showInputDialog("Nome da mãe do aluno " + nome + ": ");
                    String dataMatricula = JOptionPane.showInputDialog("Data da matricula: ");
                    String serieMatriculado = JOptionPane.showInputDialog("Série Matriculado: ");

                    aluno1.setNome(nome);
                    aluno1.setIdade(idade);
                    aluno1.setNumeroCpf(cpf);
                    aluno1.setDataNascimento(dataNascimento);
                    aluno1.setNomePai(nomePai);
                    aluno1.setNomeMae(nomeMae);
                    aluno1.setDataMatricula(dataMatricula);
                    aluno1.setSerieMatriculado(serieMatriculado);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Infelizmente ocorreu um erro no cadastro do aluno, reinicie a matricula");
                    throw new ExceptionsProcessarNotas("Erro no cadastro do aluno " + e.getMessage());
                }


                System.out.println("Dados do novo aluno");
                System.out.println(aluno1);
                System.out.println("----------------------------------------------------------------------");

                showMessageDialog(null, "Cadastro das notas do aluno");
                int ndisc = Integer.parseInt(JOptionPane.showInputDialog("Quantas disciplinas deseja cadastrar?"));

                for (int pos = 1; pos <= ndisc; pos++) {


                    String nomeDisciplina = JOptionPane.showInputDialog("Qual o nome da disciplina " + pos + "?");
                    Double notaTeste = Double.valueOf(JOptionPane.showInputDialog("Qual a nota do teste de " + nomeDisciplina + "?"));
                    Double notaProva = Double.valueOf(JOptionPane.showInputDialog("Qual a nota da prova de " + nomeDisciplina + "?"));

                    Disciplina disciplina1 = new Disciplina();
                    double[] notas = {notaTeste, notaProva};

                    disciplina1.setNomeDisciplina(nomeDisciplina);
                    disciplina1.setNotasDisciplinas(notas);

                    aluno1.getDisciplinas().add(disciplina1);
                }


                int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
                if (escolha == 0) {

                    int continuarRemovendo = 0;
                    int posicao = 1;
                    while (continuarRemovendo == 0) {
                        String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina que deseja remover (1,2 ou 3)");
                        aluno1.getDisciplinas().remove(Integer.parseInt(disciplinaRemover) - posicao);
                        posicao++;
                        continuarRemovendo = JOptionPane.showConfirmDialog(null, "Deseja Remover outra?");
                    }
                }

                //ADICIONANDO ALUNO NA LISTA
                alunos.add(aluno1);
            }

            maps.put(StatusAluno.APROVADO, new ArrayList<>());
            maps.put(StatusAluno.REPROVADO, new ArrayList<>());
            maps.put(StatusAluno.RECUPERACAO, new ArrayList<>());

            for (Aluno aluno : alunos) {
                if (aluno.getResultado().equalsIgnoreCase(StatusAluno.APROVADO)) {
                    maps.get(StatusAluno.APROVADO).add(aluno);
                } else if (aluno.getResultado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                    maps.get(StatusAluno.RECUPERACAO).add(aluno);

                } else {
                    maps.get(StatusAluno.REPROVADO).add(aluno);
                }
            }

            //PROCURANDO ALUNO NA LISTA
            for (Aluno aluno : alunos) {
                if (aluno.getNome().equalsIgnoreCase("jefferson")) {
                    System.out.println("A média do aluno " + aluno.getNome() + " é " + aluno.getMediaNotas() + "\nO aluno está " + aluno.getResultado());
                    System.out.println("---------------------------------------------------------\n");
                    break;
                }
            }

            //REMOVENDO ALUNO DA LISTA
            int removerAluno = JOptionPane.showConfirmDialog(null, "Deseja remover algum aluno? ");

            if (removerAluno == 0) {
                for (Aluno aluno : alunos) {
                    String nomeAlunoRemover = JOptionPane.showInputDialog("Qual o nome do aluno a remover?");
                    if (aluno.getNome().equalsIgnoreCase("" + nomeAlunoRemover)) {
                        System.out.println("Aluno (" + aluno.getNome() + ") sendo Removido");
                        alunos.remove(aluno);
                        System.out.println("Aluno Removido");
                        break;
                    }
                }
                System.out.println("------------------------------------------------\n");
                System.out.println("Alunos que sobraram na lista");

                for (Aluno aluno : alunos) {
                    System.out.println(aluno.getNome());
                    System.out.println("Suas matérias são: ");

                    for (Disciplina disciplina : aluno.getDisciplinas()) {
                        System.out.println(aluno.getDisciplinas());
                        System.out.println(aluno.getMediaNotas());
                    }

                    System.out.println("------------------------------------------------\n");
                }
            }

            //Mostrando disciplinas e suas notas
            for (Aluno aluno : alunos) {
                System.out.println(aluno.getNome());
                System.out.println("Suas matérias são: ");

                for (Disciplina disciplina : aluno.getDisciplinas()) {
                    System.out.println(aluno.getDisciplinas());
                    System.out.println(aluno.getMediaNotas());
                }
            }
                //MOSTRAR ALUNOS DA LISTA


                System.out.println("Lista dos alunos aprovados:");
                for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
                    System.out.println("Aluno: " + aluno.getNome() + " Resultado = " + aluno.getResultado() + " com média: " + aluno.getMediaNotas());
                }

                System.out.println("Lista dos alunos em recuperação:");
                for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
                    System.out.println("Aluno: " + aluno.getNome() + " Resultado = " + aluno.getResultado() + " com média: " + aluno.getMediaNotas());
                }

                System.out.println("Lista dos alunos reprovados:");
                for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
                    System.out.println("Aluno: " + aluno.getNome() + " Resultado = " + aluno.getResultado() + " com média: " + aluno.getMediaNotas());
                }


            } else{
                showMessageDialog(null, "Usuário não tem permição para acessar o sistema");
            }




            /*
        } catch (NullPointerException f) {
            f.printStackTrace();
            JOptionPane.showMessageDialog(null, "Algo está null"+f.getMessage());
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Um erro de formataçao de numero encontrado \n"+ nfe.getMessage());
        } catch (Exception n){
            n.printStackTrace();
            JOptionPane.showMessageDialog(null, "Um erro não tratado foi encontrado\n INFORMAÇÕES: \n"+ n.getMessage());
        } finally {
            JOptionPane.showMessageDialog(null,"Isso vai sempre aparecer dando erro ou não");

        }*/
    }
}
/*

        1 - NullPointerException:
        Erro numero 1 do Java quer dizer que existe uma variavel ou referencia nula.

        2 - NumberFormatException: 2

        Tentando converter uma string em um numero mas a string estava vazia.

        3 - FileNotFoundException
        Tentando carregar um arquivo mas nao foi encontrado no caminho informado.

        4 - ClassCastException:
        Tentando converter um objeto B para A sendo que nao sao do mesmo tipo ou sem relacao.

        5 - ClassNotFoundException :
        Tentando carregar uma classe sendo que nao foi encontrada.



        OBS: Existem finitas excecdes.*/

