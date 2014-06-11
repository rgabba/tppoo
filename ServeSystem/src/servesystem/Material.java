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
public class Material implements java.io.Serializable {

    protected String nome;
    protected double preco;
    protected int quantidade;
    
    Material(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    public double valorFinal() {
        return preco*quantidade*1.05;
    }
    
    @Override
    public String toString() {
        return this.quantidade + " x " + this.nome + " = " + this.valorFinal();
    }

}
