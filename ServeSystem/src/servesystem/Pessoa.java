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
public class Pessoa implements java.io.Serializable {
    //Vamos dar preferencia a chaves protected principalmente em classes com subclasses!
    //chaves private certamente causarão problemas.
    protected String nome;
    protected String telefone;
    
    Pessoa(String nome)
    {
        this.nome=nome;
    }
    
    Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
    protected static boolean CPFVerify(String str_cpf)
    {
        //Converte a string cpf para vetor de inteiros
        char[] tmp = str_cpf.toCharArray();
        int cpf[]=new int[11];                       
        for (int aux=0;aux<11;aux++){
            cpf[aux]=Character.getNumericValue(tmp[aux]);
        }
        return TestaDigitos(cpf);
    }
     private static boolean TestaDigitos (int cpf[]){
           
           if (cpf[9]==CalculaDigitoX(cpf) && cpf[10]==CalculaDigitoY(cpf)){
               return true;
           }
           return false;
       }
       //Calcula DigitoX
      private static int CalculaDigitoX (int cpf[]){
            int soma=0, resto;
            int DigitoX;
            for (int aux=0;aux<9;aux++){
		soma+=cpf[aux]*(10-aux);
		}
		resto=soma%11;
		if (resto==1 || resto==0){
			DigitoX=0;
		}
		else{
			DigitoX = 11-resto;
		}
		return DigitoX;
       }
       //Calcula DigitoY
       private static int CalculaDigitoY(int cpf[]){
                int X=CalculaDigitoX(cpf);
		int soma=(2*X);
                int resto;
		int DigitoY;
		for (int aux=0;aux<9;aux++){
			soma+=cpf[aux]*(11-aux);
		}
		resto=soma%11;
		if (resto==1 || resto==0){
			DigitoY =0;
		}
		else{
			DigitoY = 11-resto;
		}
		return DigitoY;
	}
    
}
