package hash;

import hash.HashLinear;
import java.util.Scanner;

public class HashTableLinear {
	public static void main(String[] args) {
		HashLinear tab = new HashLinear(7);
		Scanner le = new Scanner(System.in);
		double item;

		System.out
				.println("\n*******************************************************");
		System.out
				.println("Tabela HASH com tratamento de colisoes Linear (7 itens reais - double)");
		System.out
				.print("*********************************************************************");
		for (int i = 0; i < 7; i++) {
			System.out.print("\n\nInserindo elemento " + (i + 1));
			System.out.print(" - Forneca valor real: ");
			item = le.nextDouble();
			tab.insere(item);
		}

		System.out.print("\n\nBuscando campo\n>>> Forneca o item: ");
		item = le.nextDouble();
		if (tab.busca(item) != -1)
			System.out.print("Item encontrado na posicao " + tab.busca(item));
		else
			System.out.print("Item nao encontrado");

		System.out.print("\n\nApagando campo\n>>> Forneca o item: ");
		item = le.nextDouble();
		tab.apaga(item);

		System.out.print("\n\nImprimindo conteudo");
		tab.imprime();

		System.out.println("\n");
	}

}
