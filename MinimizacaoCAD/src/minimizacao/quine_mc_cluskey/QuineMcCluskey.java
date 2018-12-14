package minimizacao.quine_mc_cluskey;

import TabelaVerdade.TabelaVerdade;
import binario.Binario;

/**
 *
 * @author Micael Popping
 */
public class QuineMcCluskey {
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    private String equacao;
    private String equacaoMinimizada;
    private TabelaVerdade tabelaVerdade;
    private TabelaCombinacoes combinacoes;
    private ListaPrimos primos;
    private TabelaCobertura tabelaCobertura;
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 

    public QuineMcCluskey(int numeroEntradas, String equacao){
        
        setEquacao(equacao);
        setEquacaoMinimizada("none");
        setTabelaVerdade(new TabelaVerdade(numeroEntradas, equacao));
        setCombinacoes(new TabelaCombinacoes(getTabelaVerdade()));
        setPrimos(new ListaPrimos(getCombinacoes(), getTabelaVerdade()));
        setTabelaCobertura(new TabelaCobertura(getTabelaVerdade(), getPrimos()));
        setEquacaoMinimizada(nomearEquacaoMinimizada());
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 

    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=       
    
    private String nomearEquacaoMinimizada(){
        
        String binario = "";
        
        for(int i = 0, limite = getTabelaCobertura().getSolucao().size(); i < limite; i++){
            
            binario += getPrimos().getImplicantes().get(i).getBinario() + ";";
        }
        
        return Binario.converterBianrioLiteral(binario);
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    private void setEquacao(String equacao){
        
        this.equacao = equacao;
    }
    
    private void setEquacaoMinimizada(String equacaoMinimizada){
        
        this.equacaoMinimizada = equacaoMinimizada;
    }
    
    private void setTabelaVerdade(TabelaVerdade tabelaVerdade){
        
        this.tabelaVerdade = tabelaVerdade;
    }
    
    private void setCombinacoes(TabelaCombinacoes combinacoes){
        
        this.combinacoes = combinacoes;
    }
    
    private void setPrimos(ListaPrimos primos){
        
        this.primos = primos;
    }
    
    private void setTabelaCobertura(TabelaCobertura tabelaCobertura){
        
        this.tabelaCobertura = tabelaCobertura;
    }
    
    private String getEquacao(){
        
        return equacao;
    }
    
    private String getEquacaoMinimizada(){
        
        return equacaoMinimizada;
    }
    
    private TabelaVerdade getTabelaVerdade(){
        
        return tabelaVerdade;
    }
    
    private TabelaCombinacoes getCombinacoes(){
        
        return combinacoes;
    }
    
    private ListaPrimos getPrimos(){
        
        return primos;
    }
    
    private TabelaCobertura getTabelaCobertura(){
        
        return tabelaCobertura;
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    @Override
    public String toString(){
        
        return "\n-=-=-= Algoritimo Quine Mc-Cluskey-=-=-=\n\n" +
               getTabelaVerdade() +               
               getCombinacoes() + "\n" +
               getPrimos() + "\n" +
               getTabelaCobertura()+
               "Entrada: " + getEquacao() + Binario.contar(getEquacao()) + "\n\n" +
               "Minimizada: " + getEquacaoMinimizada() + Binario.contar(getEquacaoMinimizada()) + "\n\n" + 
               "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n";
    }
 
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
    
}
