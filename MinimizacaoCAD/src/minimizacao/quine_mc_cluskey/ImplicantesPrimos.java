package minimizacao.quine_mc_cluskey;

import java.util.ArrayList;

/**
 *
 * @author Micael Popping
 */
class ImplicantesPrimos {
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    private ArrayList<Integer> implicantesPrimos;
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
    
    ImplicantesPrimos(){
        
        setImplicantesPrimos(new ArrayList<>());
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 

    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=       
    
    void inserir(Integer implicante){
        
       getImplicantesPrimos().add(implicante);
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    void setImplicantesPrimos(ArrayList<Integer> implicantesPrimos){
        
        this.implicantesPrimos = implicantesPrimos;
    }
    
    ArrayList<Integer> getImplicantesPrimos(){
        
        return implicantesPrimos;
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    @Override
    public String toString(){
        
        String resultado = "";
        
        for(int i = 0, limite = getImplicantesPrimos().size(); i < limite; i++){
            resultado += getImplicantesPrimos().get(i) + "-> ";
        }
        
        return resultado + "\\\n";
    }
 
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
    
}
