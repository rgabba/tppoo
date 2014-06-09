/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servesystem;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Raul
 */
public class JanelaInicial extends MainGUI {

    //Manipulador de botões

    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();

    //Botoes para selecionar funcionário ou cliente
    private JButton funcionario = new JButton("Funcionário");
    private JButton cliente = new JButton("Cliente");

    //Rótulos
    private JLabel rotulo = new JLabel("Bem vindo à Serve!");
    private JLabel rotulo2 = new JLabel("Você é um:");

    private JPanel botoes = new JPanel();
    private JPanel rot = new JPanel();
    private JPanel rot2 = new JPanel();

    JanelaInicial() {
        super("Sistema Serve");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLayout(new BoxLayout(container, 1));

        botoes.setLayout(new FlowLayout());
        rot.setLayout(new FlowLayout());
        rot2.setLayout(new FlowLayout());

        cliente.addActionListener(manipuladorbotao);
        funcionario.addActionListener(manipuladorbotao);

        botoes.add(cliente);
        botoes.add(funcionario);
        rot.add(rotulo);
        rot2.add(rotulo2);

        container.add(rot);
        container.add(rot2);
        container.add(botoes);
    }

    private void janFunc() {
        JanelaFuncionario jan_funcionario = new JanelaFuncionario();
        jan_funcionario.setSize(430, 150);
        jan_funcionario.setLocationRelativeTo(null);
        jan_funcionario.setResizable(false);
        jan_funcionario.setVisible(true);
    }

    private void janCliente() {
        JanelaCliente jan_cliente = new JanelaCliente();
        jan_cliente.setSize(430, 150);
        jan_cliente.setLocationRelativeTo(null);
        jan_cliente.setResizable(false);
        jan_cliente.setVisible(true);
    }

    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == funcionario) {
                janFunc();
            }
            if (evento.getSource() == cliente) {
                janCliente();
            }
        }

    }
}
