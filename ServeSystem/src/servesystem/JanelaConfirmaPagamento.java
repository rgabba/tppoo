
package servesystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JanelaConfirmaPagamento extends MainGUI {

    Solicitacao solicitacaoAtual;
    
    private JTextField text_c1 = new JTextField(20);
    private JTextField text_c2 = new JTextField(15);
    private JTextField text_c3 = new JTextField(20);
    
    //Manipulador de botões
    ManipulaButtonField manipuladorbotao = new ManipulaButtonField();
   
    private JButton confirma = new JButton("Confirmar");
    private JButton cancela = new JButton("Cancelar");

    //Rótulos
    private JLabel rotulo_c1 = new JLabel("Forma de pagamento: ");
    private JLabel rotulo_c2 = new JLabel("Instituição de pagamento: ");
    private JLabel rotulo_c3 = new JLabel("Número do recibo: ");

    //Painéis
    private JPanel pan_c1 = new JPanel();
    private JPanel pan_c2 = new JPanel();
    private JPanel pan_c3 = new JPanel();
    private JPanel pan_bot = new JPanel();

    JanelaConfirmaPagamento(Solicitacao solicitacaoAtual) {
        super("Pagamento da solicitacao " + solicitacaoAtual.id);
        this.solicitacaoAtual = solicitacaoAtual;
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        container.setLayout(new BoxLayout(container, 1));
        
        pan_c1.setLayout(new FlowLayout());
        pan_c2.setLayout(new FlowLayout());
        pan_c3.setLayout(new FlowLayout());
        pan_bot.setLayout(new FlowLayout());

        pan_c1.add(rotulo_c1);
        pan_c1.add(text_c1);
        pan_c2.add(rotulo_c2);
        pan_c2.add(text_c2);
        pan_c3.add(rotulo_c3);
        pan_c3.add(text_c3);
        pan_bot.add(confirma);
        pan_bot.add(cancela);
        
        confirma.addActionListener(manipuladorbotao);
        cancela.addActionListener(manipuladorbotao);
        container.add(pan_c1);
        container.add(pan_c2);
        container.add(pan_c3);
        container.add(pan_bot);
    }
    
    private class ManipulaButtonField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == confirma) {
                if(!text_c1.getText().isEmpty() && !text_c2.getText().isEmpty() && !text_c3.getText().isEmpty()) {
                    solicitacaoAtual.setPagamento(text_c1.getText(),text_c2.getText(),text_c3.getText());
                    solicitacaoAtual.setEstado(7);
                    JOptionPane.showMessageDialog(null, "Dados do pagamento salvos. Agradecemos a preferência!");
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Campo em branco. Favor preenchê-lo.");
                }
            }
            if (evento.getSource() == cancela) {
                dispose();
            }
        }

    }
    
}

