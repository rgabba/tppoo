/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servesystem;

import static java.sql.Types.NULL;
import java.util.*;
import java.io.*;

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
    
    private static HashMap<Integer,Solicitacao> solicitacoes = new HashMap<Integer,Solicitacao>(); //não aceita tipo primitivo como chave, mas o casting é feito automaticamente
    
    public static void main(String[] args) {
        JanelaInicial teste = new JanelaInicial();
        teste.setSize(340, 150);
        teste.setLocationRelativeTo(null);
        teste.setResizable(true);
        teste.setVisible(true);
        carregarBanco();
    }
    
    private static void carregarBanco()
    {
        try {
        ObjectInputStream carregarClientes = new ObjectInputStream(new FileInputStream("/ListaClientes.dat"));
        ObjectInputStream carregarFuncionarios = new ObjectInputStream(new FileInputStream("/ListaFuncionarios.dat"));
        ObjectInputStream carregarSolicitacoes = new ObjectInputStream(new FileInputStream("/ListaSolicitacoes.dat"));
        clientes = (HashMap<String,Cliente>)carregarClientes.readObject();
        carregarClientes.close();
        funcionarios = (HashMap<String,Funcionario>)carregarFuncionarios.readObject(); //carrega os arquivos para os HashMaps declarados lá em cima
        carregarFuncionarios.close();
        solicitacoes = (HashMap<Integer,Solicitacao>)carregarSolicitacoes.readObject();
        carregarSolicitacoes.close();
        }
        catch(IOException e) {
            System.out.println("ERRO DE LEITURA DO BANCO DE DADOS (IOException)");
        }
        catch(ClassNotFoundException e) {
            System.out.println("ERRO DE LEITURA DO BANCO DE DADOS (ClassNotFoundException)");
        }
    }
    
    private static void salvarBanco()
    {
        try {
            ObjectOutputStream salvarClientes = new ObjectOutputStream(new FileOutputStream("ListaClientes.dat"));
            ObjectOutputStream salvarFuncionarios = new ObjectOutputStream(new FileOutputStream("ListaFuncionarios.dat"));
            ObjectOutputStream salvarSolicitacoes = new ObjectOutputStream(new FileOutputStream("ListaSolicitacoes.dat"));
            if(!clientes.isEmpty()) salvarClientes.writeObject(clientes);
            salvarClientes.close();
            if(!funcionarios.isEmpty()) salvarFuncionarios.writeObject(funcionarios); //salva todos os HashMaps nos arquivos
            salvarFuncionarios.close();
            if(!solicitacoes.isEmpty()) salvarSolicitacoes.writeObject(solicitacoes);
            salvarSolicitacoes.close();
        }
        catch(IOException e) {
            System.out.println("ERRO NA GRAVAÇÃO DO BANCO DE DADOS (IOException)");
        }
    }
    
    public static boolean addCliente(Cliente cliente)
    {
        clientes.put(cliente.cpf, cliente);
        System.out.println("YAY! Cliente");
        System.out.println(clientes.size());
        System.out.println(cliente.cpf);
        salvarBanco();
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
        salvarBanco();
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
    
    public static boolean addSolicitacao(Solicitacao solicitacao)
    {
        solicitacoes.put(solicitacao.id, solicitacao);
        System.out.println("YAY! Solicitacao");
        System.out.println(solicitacoes.size());
        System.out.println(solicitacao.id);
        salvarBanco();
        return true;
    }
}
