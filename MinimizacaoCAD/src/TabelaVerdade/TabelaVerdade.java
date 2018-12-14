package TabelaVerdade;

import binario.Binario;
import java.util.ArrayList;

/**
 *
 * @author Micael Popping
 */
public class TabelaVerdade {

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    
    private ArrayList<Linha> linhas;
    private int numeroEntradas;
    private String equacao;
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
    public TabelaVerdade(int numeroEntradas, String equacao){
        
        setLinhas(new ArrayList<>());
        setEquacao(equacao);
        setNumeroEntradas(numeroEntradas);
        
        for(int i = 0, limite = (int) Math.pow(2, numeroEntradas); i < limite; i++)           
            getLinhas().add(new Linha(i)); 
        
        inserirEquacao();
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
    public Linha getLinha(int indice){
        
        return getLinhas().get(indice);
    }
    
    public int getNumeroLinhas(){
        
        return (int) Math.pow(2, getNumeroEntradas());
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

    private void inserirEquacao(){
        
        String auxiliar = getEquacao();
        int i;
        
        while(true){
        
            if((i = auxiliar.indexOf('+')) == -1){
                
                adicionarEntrada(auxiliar.trim());
                break;
            }
            
            adicionarEntrada(auxiliar.substring(0, i).trim());
            auxiliar = auxiliar.substring(i + 1, auxiliar.length());
        }
    }
    
    private void adicionarEntrada(String literal){
            
        String binario = Binario.converterLiteralBinario(getNumeroEntradas(), literal);
        int indice = Binario.calcular(binario);
        
        getLinhas().get(indice).setLiteral(literal);
        getLinhas().get(indice).setBinario(binario);
        getLinhas().get(indice).setValida(true);
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    
    
    private void setLinhas(ArrayList<Linha> linhas){
        
        this.linhas = linhas;
    }
    
    private void setNumeroEntradas(int numeroEntradas){
        
        this.numeroEntradas = numeroEntradas;
    }
    
    private void setEquacao(String equacao){
        
        this.equacao = equacao;
    }
    
    private ArrayList<Linha> getLinhas(){
        
        return linhas;
    }
    
    public int getNumeroEntradas(){
        
        return numeroEntradas;
    }
    
    private String getEquacao(){
        
        return equacao;
    }
    
 //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
    @Override
    public String toString(){
        
        String resultado = "-=-=-=-=-=-=-=Tabela Verdade-=-=-=-=-=-=-=\n\n";
        
        for(int i = 0, limite = getLinhas().size(); i < limite; i++)
            if(getLinhas().get(i).getValida())
                resultado += getLinhas().get(i).toString();
        
        return resultado += "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n\n" ;
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
}
