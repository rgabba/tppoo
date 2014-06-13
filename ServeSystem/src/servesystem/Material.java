
package servesystem;

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
