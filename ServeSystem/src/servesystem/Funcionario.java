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
public class Funcionario extends Pessoa {
    protected String email;
    protected String cargo;
    protected String nMatricula;
    Funcionario(String nome, String telefone, String email, String cargo) {
        super(nome, telefone);
        this.email = email;
        this.cargo = cargo;
        /*this.nMatricula = INVENTAR ALGUM GERADOR DE CODIGO SEQUENCIAL;*/
    }
    
    
}
