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
public class Pessoa {
    //Vamos dar preferencia a chaves protected principalmente em classes com subclasses!
    //chaves private certamente causarão problemas.
    protected String nome;
    protected String telefone;
    Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
}
