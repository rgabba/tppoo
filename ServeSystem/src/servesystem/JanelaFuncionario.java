
package servesystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JanelaFuncionario extends MainGUI {

    //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();

    //Caixas mostradoras de tempo
    private JTextField text_nMat = new JTextField(30);

    //Botoes para extender bateria e alterar hora
    private JButton confirma = new JButton("Confirma");
    private JButton cancela = new JButton("Cancela");
    private JButton cadastro = new JButton("Cadastrar");

    //Rótulos
    private JLabel rotulo_nMat = new JLabel("Numero de Matricula:");

    //Painéis
    private JPanel pan_nMat = new JPanel();
    private JPanel pan_bot = new JPanel();

    JanelaFuncionario() {
        super("Bem vindo à Serve!");
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        container.setLayout(new BoxLayout(container, 1));

        pan_nMat.setLayout(new FlowLayout());
        pan_bot.setLayout(new FlowLayout());

        pan_nMat.add(rotulo_nMat);
        pan_nMat.add(text_nMat);
        pan_bot.add(confirma);
        pan_bot.add(cadastro);
        pan_bot.add(cancela);

        confirma.addActionListener(manipuladorbotao);
        cancela.addActionListener(manipuladorbotao);
        cadastro.addActionListener(manipuladorbotao);
        container.add(pan_nMat);
        container.add(pan_bot);
    }

    private void janCadastroFunc() {
        JanelaCadastroFunc jan_cadastroFunc = new JanelaCadastroFunc();
        jan_cadastroFunc.setSize(530, 200);
        jan_cadastroFunc.setLocationRelativeTo(null);
        jan_cadastroFunc.setResizable(false);
        jan_cadastroFunc.setVisible(true);
    }

    private void janSolicitacoesFunc(Funcionario funcionario) {
        JanelaSolicitacoesFunc jan_solicitacoesFunc = new JanelaSolicitacoesFunc(funcionario);
        jan_solicitacoesFunc.setSize(430, 200);
        jan_solicitacoesFunc.setLocationRelativeTo(null);
        jan_solicitacoesFunc.setResizable(true);
        jan_solicitacoesFunc.setVisible(true);
    }

    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == confirma) {
                if (ServeSystem.verifyNMatCadastro(text_nMat.getText())) {
                    Funcionario funcionarioAtual = ServeSystem.nMatCadastrado(text_nMat.getText());
                    JOptionPane.showMessageDialog(null, "Bem vindo " + funcionarioAtual.nome + "!");
                    janSolicitacoesFunc(funcionarioAtual);
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionário não cadastrado, favor tentar novamente.");
                    text_nMat.setText("");
                }
            }
            if (evento.getSource() == cancela) {
                dispose();
            }
            if (evento.getSource() == cadastro) {
                janCadastroFunc();
            }
        }

    }

}
