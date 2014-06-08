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
public class Cliente extends Pessoa implements java.io.Serializable { //serializable para poder salvar em arquivo
    protected String identidade;
    protected String cpf;
    protected String endereco;
    protected String email;
    protected String dataNasc;
    protected String dataCadastro;
    
    Cliente(String nome, String telefone, String identidade, String cpf, String endereco, String email, String dataNasc) {
        super(nome, telefone);
        this.identidade = identidade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
    }
    
    Cliente encontraCliente(String cpf) {
        return ServeSystem.cpfCadastrado(cpf);
    }
    
}
