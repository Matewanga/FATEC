public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        Pizza p1 = new Pizza("mussarela", 50);
        Pizza p2 = new Pizza("marquerita", 40);
        Pizza p3 = new Pizza("portuguesa", 60);
        Pizza p4 = new Pizza("frango", 40);

        Bebida b1 = new Bebida("Coca cola", 12.00);
        Bebida b2 = new Bebida("Agua", 8.00);
        Bebida b3 = new Bebida("sprite", 10.00);
        Bebida b4 = new Bebida("Coca cola", 12.00);

        carrinho.adicionaPizza(p1);
        carrinho.adicionaPizza(p2);
        carrinho.adicionaPizza(p3);
        carrinho.adicionaPizza(p4);

        carrinho.adicionaBebida(b1);
        carrinho.adicionaBebida(b2);
        carrinho.adicionaBebida(b3);
        carrinho.adicionaBebida(b4);

        System.out.println("Total a pagar: " + carrinho.getTotalPagar());
    }
}
