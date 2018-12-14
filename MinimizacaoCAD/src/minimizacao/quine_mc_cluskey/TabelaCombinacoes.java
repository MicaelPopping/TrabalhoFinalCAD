package minimizacao.quine_mc_cluskey;

import TabelaVerdade.TabelaVerdade;
import TabelaVerdade.Linha;
import java.util.ArrayList;

/**
 *
 * @author Micael Popping
 */
class TabelaCombinacoes {
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    private ArrayList<ListaAdjacencia> combinacoes;
    private final int NIVEL_MAXIMO;
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
    
    TabelaCombinacoes(TabelaVerdade tabelaVerdade){
        
        setCombinacoes(new ArrayList<>());
        //NIVEL_MAXIMO = tabelaVerdade.getNumeroEntradas();
        NIVEL_MAXIMO = tabelaVerdade.getNumeroEntradas() + 1;
        
        gerar(tabelaVerdade);
        gerar();
        
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 

    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=       
    
    private void gerar(TabelaVerdade tabelaVerdade){ //Inicial
        
        Mintermo mintermo;
        Linha linha;
        
        novaCombinacao();
        
        for(int i = 0, limite = tabelaVerdade.getNumeroLinhas(); i < limite ; i++){
            
            linha = tabelaVerdade.getLinha(i);
            
            if(linha.getValida()){               
                mintermo = new Mintermo(linha.getBinario(), false); 
                
                getCombinacoes().get(0).inserir(mintermo, linha.getNumeroUns());
            }
        }       
    }
    
    private void gerar(){
        
        int i = 0;
        ListaAdjacencia novaLista;
        
        while(true){
            
            if(i == getCombinacoes().size())
                break;
            
            if((novaLista = getCombinacoes().get(i).gerarProxima()) != null)
                 getCombinacoes().add(novaLista);
                                  
            i++;
        }
    }
    
    private void novaCombinacao(){
        
        getCombinacoes().add(new ListaAdjacencia(NIVEL_MAXIMO - getCombinacoes().size()));
    } 
    
    ArrayList<Primo> encontrarPrimos(){
        
        ArrayList<Primo> primos = new ArrayList<>();

        for(int i = 0; i < getCombinacoes().size(); i++){
            
            getCombinacoes().get(i).encontrarPrimos(primos);
        }
        
        return primos; 
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    private void setCombinacoes(ArrayList<ListaAdjacencia> combinacoes){
     
        this.combinacoes = combinacoes;
    }
    
    private ArrayList<ListaAdjacencia> getCombinacoes(){
        
        return combinacoes;
    }    

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    @Override
    public String toString(){
        
        String resultado = "-=-=-=-=-=-=-=-= Combinacoes -=-=-=-=-=-=-=-=\n\n";
        
        for(int i = 0, limite = getCombinacoes().size(); i < limite; i++){
            
            resultado += "Combinacao " + (i+1) + "---------------------------------\n";
            
            resultado += getCombinacoes().get(i) + "\n";
            resultado += "---------------------------------------------\n";
        }
        
        return resultado += "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
    }
}
