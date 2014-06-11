/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servesystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author User
 */
public class JanelaOrcamento extends MainGUI {

    Solicitacao solicitacaoAtual;
    
    private java.util.List<Material> lista = new java.util.ArrayList<>();
    
    //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();
    
    //Caixas de texto
    private JTextField text_horas = new JTextField(4);
    private JTextField text_custoH = new JTextField(5);
    private JTextField text_prod = new JTextField(15);
    private JTextField text_quant = new JTextField(4);
    private JTextField text_preco = new JTextField(5);

    //Botoes
    private JButton add = new JButton("Adicionar Produto");
    private JButton confirma = new JButton("Confirma");
    private JButton cancela = new JButton("Cancela");

    //Rótulos
    private JLabel rotulo_horas = new JLabel("Horas necessárias:");
    private JLabel rotulo_custoH = new JLabel("Custo da hora:");
    private JLabel rotulo_prod = new JLabel("Produto:");
    private JLabel rotulo_quant = new JLabel("Quantidade:");
    private JLabel rotulo_preco = new JLabel("Preço:");

    //Painéis
    private JPanel pan_horas = new JPanel();
    private JPanel pan_prod = new JPanel();
    private JPanel pan_prod2 = new JPanel();
    private JPanel pan_bot1 = new JPanel();
    private JPanel pan_bot = new JPanel();

    JanelaOrcamento(Solicitacao solicitacaoAtual) {
        super("Solicitacao " + solicitacaoAtual.id);
        this.solicitacaoAtual = solicitacaoAtual;
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        container.setLayout(new BoxLayout(container, 1));
        

        pan_horas.setLayout(new FlowLayout());
        pan_prod.setLayout(new FlowLayout());
        pan_prod2.setLayout(new FlowLayout());
        pan_bot1.setLayout(new FlowLayout());
        pan_bot.setLayout(new FlowLayout());

        pan_horas.add(rotulo_horas);
        pan_horas.add(text_horas);
        pan_horas.add(rotulo_custoH);
        pan_horas.add(text_custoH);
        pan_prod.add(rotulo_prod);
        pan_prod.add(text_prod);
        pan_prod2.add(rotulo_quant);
        pan_prod2.add(text_quant);
        pan_prod2.add(rotulo_preco);
        pan_prod2.add(text_preco);
        pan_bot1.add(add);
        pan_bot.add(confirma);
        pan_bot.add(cancela);
        
        confirma.addActionListener(manipuladorbotao);
        cancela.addActionListener(manipuladorbotao);
        add.addActionListener(manipuladorbotao);
        container.add(pan_horas);
        container.add(pan_prod);
        container.add(pan_prod2);
        container.add(pan_bot1);
        container.add(pan_bot);
    }
    
    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == confirma) {
                lista.add(new Material("Hora de trabalho", 
                        Double.parseDouble(text_custoH.getText()), 
                        Integer.parseInt(text_horas.getText())));
                solicitacaoAtual.setMateriais(lista);
                JOptionPane.showMessageDialog(null, "Orçamento concluído.");
                dispose();
            }
            if (evento.getSource() == cancela) {
                dispose();
            }
            if (evento.getSource() == add) {
                lista.add(new Material(
                        text_prod.getText(),
                        Double.parseDouble(text_preco.getText()), 
                        Integer.parseInt(text_quant.getText())));
                text_prod.setText("");
                text_preco.setText("");
                text_quant.setText("");
            }
        }

    }
}

