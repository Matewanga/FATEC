public class CarrinhoDeCompras {
    private double frete = 0;
    private double totalAPagar = 0;

    MinhaPrimeiraED carrinho = new MinhaPrimeiraED();

    public void adicionaBebida(Bebida item){
        carrinho.adiciona(item);
        totalAPagar += item.getPreco();
    }

    public void adicionaPizza(Pizza item){
        carrinho.adiciona(item);
        totalAPagar += item.getPreco();
    }

    public double getTotalPagar(){
        return totalAPagar + frete;
    }
}
