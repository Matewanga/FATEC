public class Palindromo {

    public boolean verificarPalindromo(String texto) throws Exception {
        Stack pilha = new Stack(texto.length());
        Stack pilhaInvertida = new Stack(texto.length());
        Stack pilhaAuxiliar = new Stack(texto.length());

        for (int i = 0; i < texto.length(); i++) {
            pilha.push(texto.charAt(i));

            // Cria uma pilha auxiliar com o mesmo conteúdo da pilha original
            pilhaAuxiliar.push(texto.charAt(i));
        }

        for (int i = 0; i < texto.length(); i++) {
            pilhaInvertida.push(pilha.pop());
        }

        for (int i = 0; i < pilhaAuxiliar.size(); i++) {
            if (pilhaInvertida.pop() != pilhaAuxiliar.pop()) {
                return false;
            }
        }


        return true;
    }
}
