
package servesystem;

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

    String getNome() {
        return this.nome;
    }

}
