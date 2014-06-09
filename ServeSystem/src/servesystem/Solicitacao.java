/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servesystem;

import java.util.*; //para usar o tipo Date

/**
 *
 * @author User
 */
public class Solicitacao implements java.io.Serializable {

    static int count = ServeSystem.nSolicitacoes(); //cada instancia de solicitacao atribui o valor de count como um id e acresce ele
    protected int id;
    protected String cpfSolicitante;
    protected String profSolicitado;
    protected String descricaoSolicitacao;
    protected Funcionario tecnicoEncarregado;
    protected float orcamento;
    protected String descricaoOrcamento;
    protected Date dataDeSolicitacao;
    protected int estado;
    /*
     1. Cadastrada – o usuário deu entrada e a solicitação está arquivada. 
     2. Aguardando Orçamento – Algum técnico já abriu a solicitação, mas ainda não completou 
     os dados do orçamento. 
     3. Aguardando Aprovação do Cliente – O técnico completou o orçamento e liberou para 
     aprovação do cliente. 
     4. Aprovada – O cliente já autorizou o serviço. 
     5. Em andamento – O técnico está elaborando o serviço. 
     6. Concluída – O serviço já foi realizado e o cliente já deu o aceite do serviço executado. 
     7. Em cobrança – A fatura de pagamento foi emitida. 
     8. Encerrada – O serviço já foi feito, aprovado e pago. 
     9. Cancelada – A solicitação foi cancelada a pedido ou por ter esgotado a validade do 
     orçamento
     */

    Solicitacao(String cpfSolicitante, String profSolicitado, String descricao) {
        this.cpfSolicitante = cpfSolicitante;
        this.profSolicitado = profSolicitado;
        this.descricaoSolicitacao = descricao;
        this.id = count;
        count++;
        this.dataDeSolicitacao = new Date(); //automaticamente seta a data atual 
        this.estado = 1;
    }
    
    public String estado() {
        String e="";
        switch(this.estado) {
            case 1:
                e = "Cadastrada";
                break;
            case 2:
                e = "Aguardando orçamento";
                break;
            case 3:
                e = "Aguardando aprovação";
                break;
            case 4:
                e = "Aprovada";
                break;
            case 5:
                e = "Em andamento";
                break;
            case 6:
                e = "Concluída";
                break;
            case 7:
                e = "Em cobrança";
                break;
            case 8:
                e = "Encerrada";
                break;
            case 9:
                e = "Cancelada";
                break;
        }
        return e;
    }
    

    public void setTecnico(Funcionario tecnicoEncarregado) { //quando um tecnico orçar o pedido, o programa seta ele como encarregado na instancia da solicitacao
        this.tecnicoEncarregado = tecnicoEncarregado;
    }
    
    @Override
    public String toString() {
        String representacao = this.estado() + " - " + this.descricaoSolicitacao;
       return representacao;
    }

}
