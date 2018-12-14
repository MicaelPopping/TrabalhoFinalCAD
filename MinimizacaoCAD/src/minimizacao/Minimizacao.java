/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimizacao;

import minimizacao.quine_mc_cluskey.QuineMcCluskey;

/**
 * @author Micael Popping.
 */
public class Minimizacao {
    
    /**
     * Algoritimo que minimiza equaçoes de 2 niveis.
     * @param numeroEntradas, quantidade de entradas.
     * @param equacao, equação que deve ser minimizada.
     */
    public static void quineMcCluskey(int numeroEntradas, String equacao){
        
        QuineMcCluskey minimizacao = new QuineMcCluskey(numeroEntradas, equacao);
        
        System.out.println(minimizacao);
    }
}
