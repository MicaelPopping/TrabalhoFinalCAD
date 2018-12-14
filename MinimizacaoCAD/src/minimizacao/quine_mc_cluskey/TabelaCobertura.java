package minimizacao.quine_mc_cluskey;

import TabelaVerdade.TabelaVerdade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Micael Popping
 */
public class TabelaCobertura {

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    private HashMap<Integer,ImplicantesPrimos> tabela;
    private ArrayList<Integer> primosObrigatorios;
    private ArrayList<Integer> solucao;
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
    
    TabelaCobertura(TabelaVerdade tabelaVerdade, ListaPrimos primos){
        
        setTabela(montar(tabelaVerdade));
        preencher(primos);
        setPrimosObrigatorios(encontrarObrigatorios());
        setSolucao(gerarSolucao(primos.getImplicantes().size()));
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 

    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=       
    
    private HashMap<Integer, ImplicantesPrimos> montar(TabelaVerdade tabelaVerdade){
        
        HashMap<Integer, ImplicantesPrimos> tabela = new HashMap<>();
        
        for(int i = 0, limite = tabelaVerdade.getNumeroLinhas(); i < limite; i++){
            
            if(tabelaVerdade.getLinha(i).getValida()){
                
                tabela.put(new Integer(tabelaVerdade.getLinha(i).getIndice()), new ImplicantesPrimos());
            }
        }
        
        return tabela;
    }
    
    private void preencher(ListaPrimos primos){
        
        ImplicantesPrimos auxiliar;
        
        for(int i = 0, limite1 = primos.getImplicantes().size(); i < limite1; i++){
            for(int j = 0, limite2 = primos.getImplicantes().get(i).getImplicados().size(); j < limite2; j++){
                
                auxiliar = getTabela().get(primos.getImplicantes().get(i).getImplicados().get(j));
                auxiliar.inserir(new Integer(i));
            }
        }
    }
    
    private ArrayList<Integer> encontrarObrigatorios(){
        
       ArrayList<Integer> primosObrigatorios = new ArrayList<>();
       ImplicantesPrimos auxiliar;
       
       for(Integer key : getTabela().keySet()){
           
           auxiliar = getTabela().get(key);
           
           if(auxiliar.getImplicantesPrimos().size() == 1){
               
               if(!contem(primosObrigatorios, auxiliar.getImplicantesPrimos().get(0)))
                   primosObrigatorios.add(auxiliar.getImplicantesPrimos().get(0));
           }
       }
        
       return primosObrigatorios;
    }
    
    private boolean contem(ArrayList<Integer> lista, Integer inteiro){
        
        for(int i = 0, limite = lista.size(); i < limite; i++){
            
            if(lista.get(i).equals(inteiro))
                return true;
        }
        
        return false;
    }
    
    private boolean verificarSolucao(ArrayList<Integer> solucao){
        
        ImplicantesPrimos auxiliar;
        boolean encontrou = false;
        
        
        for(Integer key : getTabela().keySet()){
            
            auxiliar = getTabela().get(key);
            encontrou = false;
            
            for(int i = 0, limite = auxiliar.getImplicantesPrimos().size(); i < limite; i++){
                
                if(contem(solucao, auxiliar.getImplicantesPrimos().get(i))){
                    
                    encontrou = true;
                    break;
                }
            }
            
            if(!encontrou)
                return false;
        }
        
        return true;
    }
    
    private ArrayList<Integer> gerarSolucao(int quantidadePrimos){
        
        ArrayList<Integer> solucao = getPrimosObrigatorios();
        Random gerador = new Random();
        int tentativas, tamanhoSolucao, primo;       
        
        if(verificarSolucao(solucao))    
            return solucao;
        
        while(true){ 
            
            tamanhoSolucao = gerador.nextInt(quantidadePrimos - getPrimosObrigatorios().size()) + getPrimosObrigatorios().size()+1;           
            System.out.println(quantidadePrimos + " >= " + tamanhoSolucao + " > " + getPrimosObrigatorios().size());
            
            solucao = new ArrayList<>();  
            
            for(int i = 0, limite = getPrimosObrigatorios().size(); i < limite; i++)
                solucao.add(getPrimosObrigatorios().get(i)); 
            
            tentativas = 0;
            
            while(solucao.size() < tamanhoSolucao && tentativas < 10){
                    
                primo = gerador.nextInt(quantidadePrimos);
                    
                if(!contem(solucao, primo))                       
                    solucao.add(primo);
                
                tentativas++;
            }
            
            if(verificarSolucao(solucao))
                break;
        }
        
        return solucao;
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    private void setTabela(HashMap<Integer, ImplicantesPrimos> tabela){
        
        this.tabela = tabela;
    }
    
    private void setPrimosObrigatorios(ArrayList<Integer> primosObrigatorios){
        
        this.primosObrigatorios = primosObrigatorios;
    }
    
    private void setSolucao(ArrayList<Integer> solucoes){
        
        this.solucao = solucoes;
    }
    
    HashMap<Integer, ImplicantesPrimos> getTabela(){
        
        return tabela;
    }
    
    private ArrayList<Integer> getPrimosObrigatorios(){
        
        return primosObrigatorios;
    }
    
    ArrayList<Integer> getSolucao(){
        
        return solucao;
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    @Override
    public String toString(){
        
        String resultado = "-=-=-=-=-=-= Tabela de Cobertura -=-=-=-=-=-=\n\n";
        
        resultado += "Implicante : Primo\n" ;
        
        for(Integer key : getTabela().keySet())
            
            resultado += key + " : " + getTabela().get(key);    
        
        return resultado += "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n";
    }
 
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
}
