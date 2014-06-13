
package servesystem;

import java.util.Random; //usado para atribuicao do nº de matricula

public class Funcionario extends Pessoa implements java.io.Serializable { //serializable para poder salvar em arquivo

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

    Funcionario encontraFuncionario(String nMatricula) {
        return ServeSystem.nMatCadastrado(nMatricula);
    }

    String getCargo() {
        return this.cargo;
    }

}
