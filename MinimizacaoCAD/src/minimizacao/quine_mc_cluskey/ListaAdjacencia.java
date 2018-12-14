/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimizacao.quine_mc_cluskey;

import binario.Binario;
import java.util.ArrayList;

/**
 *
 * @author Micael Popping
 */
class ListaAdjacencia {
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    private ArrayList<ArrayList<Mintermo>> grupos;
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
    
    ListaAdjacencia(int tamanho){
        
        setGrupos(new ArrayList<>());
        
        for(int i = 0; i < tamanho; i++)           
          getGrupos().add(new ArrayList<>());
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 

    void inserir(Mintermo mintermo, int numeroUns){
        
        //getGrupos().get(numeroUns -1 ).add(mintermo);
        getGrupos().get(numeroUns ).add(mintermo);
    }
    
    void inserir(Mintermo mintermo){
        
        int indice = Binario.quantidadeBitAlto(mintermo.getBinario());
        
        if(!possui(indice, mintermo.getBinario()))
            getGrupos().get(indice).add(mintermo);
    }
    
    ListaAdjacencia gerarProxima(){
        
        ListaAdjacencia novaLista = new ListaAdjacencia(getGrupos().size() - 1);
        String auxiliar;
        boolean inseri = false;
        
        for(int i = 0, limite1 = getGrupos().size() - 1; i < limite1; i++){ 
            for(int j = 0, limite2 = getGrupos().get(i).size(); j < limite2; j++){
                for(int k = 0, limite3 = getGrupos().get(i+1).size(); k < limite3; k++){
                    
                    if((auxiliar = Binario.analisar(getGrupos().get(i).get(j).getBinario(), getGrupos().get(i+1).get(k).getBinario())) != null){
                        
                        inseri = true;
                        getGrupos().get(i).get(j).setUsado(true);
                        getGrupos().get(i+1).get(k).setUsado(true);
                        novaLista.inserir(new Mintermo(auxiliar, false));
                    }
                }  
            }
        }
        
        if(inseri)
            return novaLista;
        return null;
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=       
    
    private boolean possui(int indice, String binario){
        
        for(int i = 0, limite = getGrupos().get(indice).size(); i < limite; i++)         
            if(binario.equals(getGrupos().get(indice).get(i).getBinario()))
                return true;
        
        return false;
    }
    
    void encontrarPrimos(ArrayList<Primo> primos){
        
       for(int i = 0, limite1 = getGrupos().size(); i < limite1; i++){
           for(int j = 0, limite2 = getGrupos().get(i).size(); j < limite2; j++){
               
                if(!getGrupos().get(i).get(j).getUsado()){
                    
                    primos.add(new Primo(getGrupos().get(i).get(j).getBinario()));
                }
                    
           }
       }
    }
    
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    private void setGrupos(ArrayList<ArrayList<Mintermo>> grupos){
        
        this.grupos = grupos;
    }
    
    private ArrayList<ArrayList<Mintermo>> getGrupos(){
        
        return grupos;
    }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=    

    @Override
    public String toString(){
        
        String resultado = "";
        
        for(int i = 0, limite1 = getGrupos().size(); i < limite1; i++){
        
            resultado += "Grupo: " + i + "\n";
            for(int j = 0, limite2 = getGrupos().get(i).size(); j < limite2; j++){
                
                resultado += getGrupos().get(i).get(j);
            }
            resultado += "\n";
        }
        
        return resultado;
    }
 
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 
    
}
