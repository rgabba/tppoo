/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servesystem;

import java.util.*;
import java.io.*;
import com.google.common.collect.HashMultimap;

/**
 *
 * @author Raul, eu e o zooboomafoo
 */
public class ServeSystem {

    /**
     * @param args the command line arguments
     */
    private static Map<String, Cliente> clientes = new HashMap<>();

    private static Map<String, Funcionario> funcionarios = new HashMap<>();

    private static HashMultimap<String, Solicitacao> solicitacoes = HashMultimap.create();

    //tive que arrumar esse outro tipo de dados hashmultimap pra salvar varias solicitações associadas a um cliente

    public static void main(String[] args) {
        JanelaInicial teste = new JanelaInicial();
        teste.setSize(340, 150);
        teste.setLocationRelativeTo(null);
        teste.setResizable(false);
        teste.setVisible(true);
        carregarBanco();
    }

    private static void carregarBanco() {
        try {
            ObjectInputStream carregarClientes = new ObjectInputStream(new FileInputStream("ListaClientes.dat"));
            clientes = (HashMap<String, Cliente>) carregarClientes.readObject();
            carregarClientes.close();
            ObjectInputStream carregarFuncionarios = new ObjectInputStream(new FileInputStream("ListaFuncionarios.dat"));
            funcionarios = (HashMap<String, Funcionario>) carregarFuncionarios.readObject();
            carregarFuncionarios.close();
            ObjectInputStream carregarSolicitacoes = new ObjectInputStream(new FileInputStream("ListaSolicitacoes.dat"));
            solicitacoes = (HashMultimap<String, Solicitacao>) carregarSolicitacoes.readObject();
            carregarSolicitacoes.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void salvarBanco() {
        try {
            ObjectOutputStream salvarClientes = new ObjectOutputStream(new FileOutputStream("ListaClientes.dat"));
            if (!clientes.isEmpty()) {
                salvarClientes.writeObject(clientes);
            }
            salvarClientes.close();
            ObjectOutputStream salvarFuncionarios = new ObjectOutputStream(new FileOutputStream("ListaFuncionarios.dat"));
            if (!funcionarios.isEmpty()) {
                salvarFuncionarios.writeObject(funcionarios); //salva todos os HashMaps nos arquivos
            }
            salvarFuncionarios.close();
            ObjectOutputStream salvarSolicitacoes = new ObjectOutputStream(new FileOutputStream("ListaSolicitacoes.dat"));
            if (!solicitacoes.isEmpty()) {
                salvarSolicitacoes.writeObject(solicitacoes);
            }
            salvarSolicitacoes.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean addCliente(Cliente cliente) {
        clientes.put(cliente.cpf, cliente);
        System.out.println("YAY! Cliente");
        System.out.println(clientes.size());
        System.out.println(cliente.cpf);
        salvarBanco();
        return true;
    }

    public static void mostraClientesTerminal() {
        int i = 0;
        while (i < clientes.size()) {
            Cliente acliente = clientes.get(i);
            i++;
            System.out.println(acliente.cpf);
        }
    }

    public static boolean verifyCpfCadastro(String cpf) {
        return clientes.containsKey(cpf);
    }

    public static Cliente cpfCadastrado(String cpf) {
        return clientes.get(cpf);
    }

    public static boolean addFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.nMatricula, funcionario);
        System.out.println("YAY! Funcionario");
        System.out.println(funcionarios.size());
        System.out.println(funcionario.nMatricula);
        salvarBanco();
        return true;
    }

    public static boolean verifyNMatCadastro(String nMat) {
        return funcionarios.containsKey(nMat);
    }

    public static Funcionario nMatCadastrado(String nMat) {
        return funcionarios.get(nMat);
    }

    public static boolean addSolicitacao(Solicitacao solicitacao) {
        solicitacoes.put(solicitacao.cpfSolicitante, solicitacao);
        System.out.println("YAY! Solicitacao");
        System.out.println(solicitacoes.size());
        System.out.println(solicitacao.id);
        salvarBanco();
        return true;
    }

    public static Set<Solicitacao> listaSolicitacoesCliente(String cpf) {
        return solicitacoes.get(cpf);
    }
    public static Set<Solicitacao> listaSolicitacoesFuncionario(String cargo) {
        Set<Solicitacao> lista = new HashSet<>();
        Iterator it = solicitacoes.values().iterator();
        while(it.hasNext()) {
            Solicitacao solicitacao = (Solicitacao)it.next();
            if(solicitacao.profSolicitado.contains(cargo))
             lista.add(solicitacao);
        }
        return lista;
    }

    public static int nSolicitacoes() {
        return solicitacoes.size();
    }

}
