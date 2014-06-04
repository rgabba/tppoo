/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servesystem;

import static java.sql.Types.NULL;
import java.util.*;

/**
 *
 * @author Raul, eu e o zooboomafoo
 */
public class ServeSystem {

    /**
     * @param args the command line arguments
     */
    private static ArrayList <Cliente> clientes = new ArrayList <Cliente>();
    
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        /*Olá amiguinhos*/
        
        /* Olá zoobomafoo*/
        JanelaInicial teste = new JanelaInicial();
        teste.setSize(340, 150);
        teste.setLocationRelativeTo(null);
        teste.setResizable(true);
        teste.setVisible(true);
    }
    
    public static boolean addcliente(String nome, String telefone, String cpf,String identidade, String email, String endereco, String nascimento)
    {
     Cliente novocliente = new Cliente (nome,telefone,identidade,cpf,endereco,nascimento);
     clientes.add(novocliente);
     System.out.println("YAY!");
     System.out.println(clientes.size());
     System.out.println(novocliente.cpf);
     return true;
    }
    
    public static void mostraclientesterminal()
    {
        int i=0;
        while (i<clientes.size())
        {
            Cliente acliente= clientes.get(i);
            i++;
            System.out.println(acliente.cpf);
        }
    }
    public static boolean verifycpfcadastro(String cpf)
    {
        int i=0;
        while (i<clientes.size())
        {
            if(clientes.get(i).cpf == null ? cpf == null : clientes.get(i).cpf.equals(cpf))
                    return true;
        }
        return false;
    }
    public static Cliente cpfcadastrado(String cpf)
    {
        int i=0;
       while ((clientes.get(i).cpf == null ? cpf != null : !clientes.get(i).cpf.equals(cpf)) && i<clientes.size())
            i++;
       return clientes.get(i);
    }
}
