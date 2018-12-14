package minimizacao.quine_mc_cluskey;

import java.util.ArrayList;

/**
 *
 * @author Micael Popping
 */
class Primo {
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    private String binario;
    private ArrayList<Integer> implicados;
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
    
    Primo(String binario){
        
        setBinario(binario);
        setImplicados(new ArrayList<>());
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 

    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=       
    
    void inserirImplicado(int linha){
        
        getImplicados().add(new Integer(linha));
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    private void setBinario(String binario){
        
        this.binario = binario;
    }
    
    private void setImplicados(ArrayList<Integer> implicados){
        
        this.implicados = implicados;
    }
    
    String getBinario(){
        
        return binario;
    }
    
    ArrayList<Integer> getImplicados(){
        
        return implicados;
    }
            

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    @Override
    public String toString(){
        
        String resultado = binario + " | ";
        
        for(int i = 0, limite = getImplicados().size(); i < limite; i++)
            resultado += getImplicados().get(i) + " -> " ;
        
        return resultado += "\\\n"; 
    }
 
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
    
}
