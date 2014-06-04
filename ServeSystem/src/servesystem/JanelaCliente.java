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
 * @author Raul
 */
public class JanelaCliente extends MainGUI {
     //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField ();
    
    //Caixas mostradoras de tempo
    private JTextField text_nome = new JTextField(30);
    private JTextField text_cpf = new JTextField(9);
    
    //Botoes para extender bateria e alterar hora
    private JButton confirma = new JButton ("Confirma");
    private JButton cancela = new JButton ("Cancela");
    
    //Rótulos
     private JLabel rotulo_nome = new JLabel ("Nome:");
     private JLabel rotulo_cpf = new JLabel ("CPF: ");
     
     //Painéis
     private JPanel pan_nome = new JPanel();
     private JPanel pan_cpf =  new JPanel();
     private JPanel pan_bot = new JPanel();
      
     JanelaCliente () {
         super ("Bem vindo à Serve!");
         setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
         container.setLayout(new BoxLayout(container, 1));
         
         pan_nome.setLayout (new FlowLayout());
         pan_cpf.setLayout (new FlowLayout());
         pan_bot.setLayout (new FlowLayout());
         
         pan_nome.add(rotulo_nome);
         pan_nome.add(text_nome);
         pan_cpf.add(rotulo_cpf);
         pan_cpf.add(text_cpf);
         pan_bot.add (confirma);
         pan_bot.add (cancela);
         
         confirma.addActionListener(manipuladorbotao);
         cancela.addActionListener(manipuladorbotao);
         container.add(pan_nome);
         container.add(pan_cpf);
         container.add(pan_bot);
         
     }
     
     private void janCadastroCliente(String nome, String cpf) {
        JanelaCadastroCliente jan_cadastroCliente = new JanelaCadastroCliente(nome, cpf);
        jan_cadastroCliente.setSize(530, 250);
        jan_cadastroCliente.setLocationRelativeTo(null);
        jan_cadastroCliente.setResizable(false);
        jan_cadastroCliente.setVisible(true); 
    }
      
      private class ManipulaButtonField implements ActionListener{
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == confirma)
                {
                    if (Pessoa.CPFVerify(text_cpf.getText())==false)
                    {
                        JOptionPane.showMessageDialog(null, "O CPF " + text_cpf.getText() +" é inválido, tente novamente");
                    }
                    else
                    {
                        //if(tánobanco) login;
                            /*Verifica se está no banco de dados, se sim, carrega, se não adiciona*/
                        /*else*/ 
                        JOptionPane.showMessageDialog(null, "Cliente não cadastrado, por favor preencha o formulário a seguir.");
                        janCadastroCliente(text_nome.getText(), text_cpf.getText());
                    }
                }
            if(evento.getSource() == cancela)
                {
                    dispose();
                }
        }
    
    }
    
}
