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
public class JanelaCadastroCliente extends MainGUI {
    //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField ();
    
    //Caixas de texto
    private JTextField text_nome = new JTextField(30);
    private JTextField text_cpf = new JTextField(11);
    private JTextField text_identidade = new JTextField(10);
    private JTextField text_email = new JTextField(30);
    private JTextField text_telefone = new JTextField(10);
    private JTextField text_endereco = new JTextField(30);
    private JTextField text_dataNasc = new JTextField(10);
    
    //Botoes
    private JButton confirma = new JButton ("Confirma");
    private JButton cancela = new JButton ("Cancela");
    
    //Rótulos
     private JLabel rotulo = new JLabel ("Favor preencher o formulário a seguir para ser cadastrado em nosso sistema:");
     private JLabel rotulo_nome = new JLabel ("Nome:");
     private JLabel rotulo_cpf = new JLabel ("CPF:");
     private JLabel rotulo_identidade = new JLabel ("Identidade:");
     private JLabel rotulo_email = new JLabel ("E-mail: ");
     private JLabel rotulo_telefone = new JLabel ("Tel.: ");
     private JLabel rotulo_endereco = new JLabel ("Endereço: ");
     private JLabel rotulo_dataNasc = new JLabel ("Data de Nasc.: ");
     
     //Painéis
     private JPanel pan_rot = new JPanel();
     private JPanel pan_nome = new JPanel();
     private JPanel pan_cpf = new JPanel();
     private JPanel pan_email =  new JPanel();
     private JPanel pan_endereco =  new JPanel();
     private JPanel pan_telefone =  new JPanel();
     private JPanel pan_bot = new JPanel();
      
     JanelaCadastroCliente (String nome, String cpf)
     {
         super ("Cadastro de cliente");
         text_nome.setText(nome);
         text_cpf.setText(cpf);
         
         text_nome.setEditable(false);
         text_cpf.setEditable(false);
         
         setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
         container.setLayout(new BoxLayout(container, 1));
         
         pan_rot.setLayout (new FlowLayout());
         pan_nome.setLayout (new FlowLayout());
         pan_cpf.setLayout (new FlowLayout());
         pan_email.setLayout (new FlowLayout());
         pan_endereco.setLayout (new FlowLayout());
         pan_telefone.setLayout (new FlowLayout());
         pan_bot.setLayout (new FlowLayout());
         
         pan_rot.add(rotulo);
         pan_nome.add(rotulo_nome);
         pan_nome.add(text_nome);
         pan_cpf.add(rotulo_cpf);
         pan_cpf.add(text_cpf);
         pan_cpf.add(rotulo_identidade);
         pan_cpf.add(text_identidade);
         pan_email.add(rotulo_email);
         pan_email.add(text_email);
         pan_endereco.add(rotulo_endereco);
         pan_endereco.add(text_endereco);
         pan_telefone.add(rotulo_telefone);
         pan_telefone.add(text_telefone);
         pan_telefone.add(rotulo_dataNasc);
         pan_telefone.add(text_dataNasc);
         pan_bot.add (confirma);
         pan_bot.add (cancela);
         
         confirma.addActionListener(manipuladorbotao);
         cancela.addActionListener(manipuladorbotao);
         container.add(pan_rot);
         container.add(pan_nome);
         container.add(pan_cpf);
         container.add(pan_email);
         container.add(pan_endereco);
         container.add(pan_telefone);
         container.add(pan_bot);
         
     }
      
      private class ManipulaButtonField implements ActionListener{
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == confirma)
                {
                    
                    JOptionPane.showMessageDialog(null, "Cadastro concluído.");
                    //!!como vai fazer a gravação de cada instancia? no momento da criação dela aqui ou pelo construtor de Funcionario?
                    dispose();
                }
            if(evento.getSource() == cancela)
                {
                    dispose();
                }
        }
    
    }
}
