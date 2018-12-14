
import java.util.Scanner;
import minimizacao.Minimizacao;

/**
 * @author Micael Popping
 */
public class ClassePrincipal {
   
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int numeroEntradas;
        String equacao;
        
        System.out.println("Insira a quantidade de entradas da equacao: ");
        numeroEntradas = scanner.nextInt();
        System.out.println("Insira a equacao: ");
        equacao = scanner.next();
                
        Minimizacao.quineMcCluskey(numeroEntradas, equacao);
    }
}
