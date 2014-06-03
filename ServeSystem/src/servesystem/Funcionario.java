/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servesystem;

import java.io.*;
import javax.swing.JOptionPane;
import java.util.Random; //usado para atribuicao do nº de matricula

/**
 *
 * @author User
 */
public class Funcionario extends Pessoa {
    protected String email;
    protected String cargo;
    protected String nMatricula;
    private static Random aleatorio = new Random();
    
    public Funcionario(String nome, String telefone, String email, String cargo) {
        super(nome, telefone);
        this.email = email;
        this.cargo = cargo;
        String id = String.valueOf(aleatorio.nextInt(1000000));             //adiciona 0s a esquerda do número gerado
        this.nMatricula = "2014" + ("000000" + id).substring(id.length());  //para completar os 10 caracteres do nMat
    }
    
    public String getMatricula() {
        return this.nMatricula;
    }
    
    /*static Funcionario encontraFuncionario(String nMatricula) { //A IMPLEMENTAR
        Funcionario retornaFuncionario = null;
        try { 
            FileReader leitor = new FileReader("C:\\POO\funcionarios.txt");
            BufferedReader buscaFuncionario = new BufferedReader(leitor);
            String texto = buscaFuncionario.readLine();
            while(texto != null || texto.contentEquals(nMatricula)) {
            
            }
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo de dados");
        }
        return retornaFuncionario;
    }*/
    
}
