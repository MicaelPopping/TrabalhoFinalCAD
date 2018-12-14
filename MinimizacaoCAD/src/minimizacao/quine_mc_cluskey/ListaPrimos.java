/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimizacao.quine_mc_cluskey;

import TabelaVerdade.TabelaVerdade;
import binario.Binario;
import java.util.ArrayList;

/**
 *
 * @author Micael Popping
 */
public class ListaPrimos {
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

   ArrayList<Primo> implicantes;
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
    
     ListaPrimos(TabelaCombinacoes tabelaCombinacoes, TabelaVerdade tabelaVerdade){
         
         setImplicantes(tabelaCombinacoes.encontrarPrimos());
         
         for(int i = 0, limite1 = implicantes.size(); i < limite1; i++){
            for(int j = 0, limite2 = tabelaVerdade.getNumeroLinhas(); j < limite2; j++){
             
                if(tabelaVerdade.getLinha(j).getValida())
                    if(Binario.verificar(implicantes.get(i).getBinario(), tabelaVerdade.getLinha(j).getBinario()))                   
                        implicantes.get(i).inserirImplicado(tabelaVerdade.getLinha(j).getIndice());
                
                    
            } 
         }
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 

    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=       

     private void setImplicantes(ArrayList<Primo> implicantes){
         
         this.implicantes = implicantes;
     }

     ArrayList<Primo> getImplicantes(){
         
         return implicantes;
     }
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
     
   @Override
     public String toString(){
         
         String resultado = "-=-=-=-=-=-=-=-=-= Primos -=-=-=-=-=-=-=-=-=\n\n";
         
         for(int i = 0, limite = getImplicantes().size(); i < limite; i++)
             resultado += getImplicantes().get(i);
         
         return resultado + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
     }
     
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=   
  
}
