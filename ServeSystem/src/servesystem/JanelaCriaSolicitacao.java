/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servesystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class JanelaCriaSolicitacao extends MainGUI {
    
    private Cliente clienteAtual;

    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();

    //Caixas de texto
    private JTextField text_nome = new JTextField(30);
    private JTextArea text_descricao = new JTextArea(4,28);
    private JTextField text_solicitado = new JTextField(15);
    JScrollPane scrollPane = new JScrollPane(text_descricao); 

    //Botoes
    private JButton confirma = new JButton("Confirma");
    private JButton cancela = new JButton("Cancela");

    //Rótulos
    private JLabel rotulo = new JLabel("Favor preencher os campos para sua solicitação:");
    private JLabel rotulo_nome = new JLabel("Nome:");
    private JLabel rotulo_descricao = new JLabel("Descrição:");
    private JLabel rotulo_solicitado = new JLabel("Profissionais solicitados:");

    //Painéis
    private JPanel pan_rot = new JPanel();
    private JPanel pan_nome = new JPanel();
    private JPanel pan_descricao = new JPanel();
    private JPanel pan_solicitado = new JPanel();
    private JPanel pan_bot = new JPanel();

    JanelaCriaSolicitacao(Cliente cliente) {
        super("Cadastro de Solicitação");
        clienteAtual = cliente;
        text_nome.setText(cliente.getNome());
        text_nome.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        container.setLayout(new BoxLayout(container, 1));
        

        pan_rot.setLayout(new FlowLayout());
        pan_nome.setLayout(new FlowLayout());
        pan_solicitado.setLayout(new FlowLayout());
        pan_descricao.setLayout(new FlowLayout());
        pan_bot.setLayout(new FlowLayout());

        pan_rot.add(rotulo);
        pan_nome.add(rotulo_nome);
        pan_nome.add(text_nome);
        pan_descricao.add(rotulo_descricao);
        pan_descricao.add(text_descricao);
        pan_descricao.add(scrollPane);
        pan_solicitado.add(rotulo_solicitado);
        pan_solicitado.add(text_solicitado);
        pan_bot.add(confirma);
        pan_bot.add(cancela);

        confirma.addActionListener(manipuladorbotao);
        cancela.addActionListener(manipuladorbotao);
        container.add(pan_rot);
        container.add(pan_nome);
        container.add(pan_descricao);
        container.add(pan_solicitado);
        container.add(pan_bot);

    }

    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == confirma) {
                String descricao = text_descricao.getText();
                String solicitado = text_solicitado.getText();
                Solicitacao solicitacao = new Solicitacao(clienteAtual.cpf, solicitado, descricao);
                boolean confirm = ServeSystem.addSolicitacao(solicitacao);
                if (confirm == true) {
                    JOptionPane.showMessageDialog(null, "Cadastro concluído.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente, tente novamente");
                }
                dispose();
            }
            if (evento.getSource() == cancela) {
                dispose();
            }
        }

    }
}
