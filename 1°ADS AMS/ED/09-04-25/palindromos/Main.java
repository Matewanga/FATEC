import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Palindromo palindromo = new Palindromo();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Verifique um palíndromo: ");
            String texto = scanner.next();
            System.out.println(palindromo.verificarPalindromo(texto));
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
}