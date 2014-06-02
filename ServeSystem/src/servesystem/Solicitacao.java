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
public class Solicitacao {
    static int count = 0; //cada instancia de solicitacao atribui o valor de count como um id e acresce ele
    protected int id;
    protected Cliente solicitante;
    protected String profSolicitado;
    protected String descricao;
    protected Funcionario tecnicoEncarregado;
    protected String orcamento;
    protected Date dataDeSolicitacao;
    /*implementar alguma variável de estado para a solicitação seguindo o que tá no pdf:
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
    Solicitacao(Cliente solicitante, String profSolicitado, String descricao) {
        this.solicitante = solicitante;
        this.profSolicitado = profSolicitado;
        this.descricao = descricao;
        this.id = count;
        count++;
        this.dataDeSolicitacao = new Date(); //automaticamente seta a data atual 
    }
    void setTecnico(Funcionario tecnicoEncarregado) { //quando um tecnico orçar o pedido, o programa seta ele como encarregado na instancia da solicitacao
        this.tecnicoEncarregado = tecnicoEncarregado;
    }
    
}
