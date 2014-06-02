/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servesystem;

/**
 *
 * @author User
 */
public class Cliente extends Pessoa {
    protected String identidade;
    protected String cpf;
    protected String endereco;
    protected String dataNasc;
    protected String dataCadastro;
    Cliente(String nome, String telefone, String identidade, String cpf, String endereco, String dataNasc, String dataCadastro) {
        super(nome, telefone);
        this.identidade = identidade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
        this.dataCadastro = dataCadastro;
    }
    
}
