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
    private static HashMap<String,Cliente> clientes = new HashMap<String,Cliente>();
    
    private static HashMap<String,Funcionario> funcionarios = new HashMap<String,Funcionario>();
    
    public static void main(String[] args) {
        
        /*Olá amiguinhos*/
        
        /* Olá zoobomafoo*/
        JanelaInicial teste = new JanelaInicial();
        teste.setSize(340, 150);
        teste.setLocationRelativeTo(null);
        teste.setResizable(true);
        teste.setVisible(true);
    }
    
    public static boolean addCliente(Cliente cliente)
    {
        clientes.put(cliente.cpf, cliente);
        System.out.println("YAY! Cliente");
        System.out.println(clientes.size());
        System.out.println(cliente.cpf);
        return true;
    }
    
    public static void mostraClientesTerminal()
    {
        int i=0;
        while (i<clientes.size())
        {
            Cliente acliente= clientes.get(i);
            i++;
            System.out.println(acliente.cpf);
        }
    }
    
    public static boolean verifyCpfCadastro(String cpf)
    {
        return clientes.containsKey(cpf);
    }
    
    public static Cliente cpfCadastrado(String cpf)
    {
        return clientes.get(cpf);
    }
    
    public static boolean addFuncionario(Funcionario funcionario)
    {
        funcionarios.put(funcionario.nMatricula, funcionario);
        System.out.println("YAY! Funcionario");
        System.out.println(funcionarios.size());
        System.out.println(funcionario.nMatricula);
        return true;
    }
    
    public static boolean verifyNMatCadastro(String nMat)
    {
        return funcionarios.containsKey(nMat);
    }
    
    public static Funcionario nMatCadastrado(String nMat)
    {
        return funcionarios.get(nMat);
    }
}
