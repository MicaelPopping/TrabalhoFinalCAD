package TabelaVerdade;

import binario.Binario;

/**
 *
 * @author Micael Popping.
 */
public class Linha {
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
    private int indice;
    private String literal;
    private String binario;
    private int numeroUns;
    private boolean valida;
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
    Linha(int indice){
        
        setIndice(indice);
        setNumeroUns(-1);
        setValida(false);
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
    private void setIndice(int indice){
       
        this.indice = indice;
    }
    
    void setLiteral(String literal){
        
        this.literal = literal;
    }
    
    void setBinario(String binario){
        
        this.binario = binario;
        setNumeroUns(Binario.quantidadeBitAlto(binario));
    }
    
    private void setNumeroUns(int numeroUns){
        
        this.numeroUns = numeroUns;
    }
    
    void setValida(boolean valida){
        
        this.valida = valida;
    }
    
    public int getIndice(){
        
        return indice;
    }
    
    public String getLiteral(){
        
        return literal;
    }
    
    public String getBinario(){
        
        return binario;
    }
    
    public int getNumeroUns(){
        
        return numeroUns;
    }
    
    public boolean getValida(){
        
        return valida;
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
    @Override
    public String toString(){
        
        return getIndice() + " | " + getLiteral() + "-" + getBinario() + " | " + getNumeroUns() + " | " + getValida() + ";\n";
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
}
