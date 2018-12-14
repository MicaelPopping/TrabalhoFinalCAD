package binario;

/**
 *
 * @author Micael Popping.
 */
public class Binario {
    
    public static int calcular(String binario){
        
        int resultado = 0, limite = binario.length();
        
        for(int i = limite - 1, expoente = 0; expoente < limite; i--, expoente++){
            
            if(binario.charAt(i) == '1'){
                
                resultado += Math.pow(2, expoente);
            }
        }
        
        return resultado;
    }
    
    public static String converterLiteralBinario(int numeroEntradas, String literal){
        
        String resultado = "";
        
        for(int i = 0, limite = literal.length(); i < limite; i++){
            
            if(literal.charAt(i) == '!'){
                
                resultado += "0";
                i++;
            }else
                resultado += "1";
        }
        
        return resultado;
    }
    
    public static String converterBianrioLiteral(String binario){
        
        char entrada = 'a', letraBinario;
        String resultado = "";
        
        for(int i = 0, limite = binario.length()-1; i < limite; i++){
            
            letraBinario= binario.charAt(i);
            
            if(letraBinario == '0'){
                
                resultado += "!" + entrada;
                entrada++;
            }else 
            if(letraBinario == '1'){
                
                resultado += entrada;
                entrada++;
            }else
            if(letraBinario == '_'){
                
                entrada++;
            }else
            if(letraBinario == ';'){
                
                resultado += " + ";
                entrada = 'a';
            }
        }
         
        return resultado;
    }
    
    public static int quantidadeBitAlto(String binario){
        
        int quantidade = 0;
        
        for(int i = 0, limite = binario.length(); i < limite; i++){
            
            if(binario.charAt(i) == '1')
                quantidade++;
        }
        
        return quantidade;
    }
    
    public static String analisar(String binario1, String binario2){
        
        String resultado = "";
        int diferentes = 0;
        
        if(binario1.length() != binario2.length())
            return null;
        
        for(int i = 0, limite = binario1.length(); i < limite; i++){
            
            if(binario1.charAt(i) == binario2.charAt(i)){
                
                resultado += binario1.charAt(i);
            }else{
                
                diferentes++;
                
                if(diferentes > 1)
                    return null;
                
                resultado += "_";
            }                
        }
        
        return resultado;
    }
    
    public static boolean verificar(String binario1, String binario2){
        
        if(binario1.length() != binario2.length())
            return false;
        
        for(int i = 0, limite = binario1.length(); i < limite; i++){
            
            if((binario1.charAt(i) != '_') && (binario2.charAt(i) != '_')){
                
                if(binario1.charAt(i) != binario2.charAt(i))
                    return false;
            } 
        }

        return true;
    }
    
    public static String contar(String entrada){
       
        char atual;
        int caracter = 0, negacao = 0, ou = 0; 
        
        for(int i = 0, limite = entrada.length(); i < limite; i++){
            
            atual = entrada.charAt(i);
            
            if(atual == '+')
                ou++;
            else 
            if(atual == '!')
                negacao++;
            else
            if(Character.isAlphabetic(atual)){
                
                caracter++;
            }
        }
        
        return " | literais: " + caracter + " | Negacoes: " + negacao + " | Ou: " + ou;
    }
    
}

 
