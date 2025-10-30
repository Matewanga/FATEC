package com.fila;

/**
 *
 * @author nickolss
 */
public class Main {

    public static void main(String[] args) {
        try {
            Fila f1 = new Fila();
            f1.enqueue("elm1");
            f1.enqueue("elm2");
            f1.enqueue("elm3");
            f1.enqueue("elm4");
            f1.enqueue("elm5");
            f1.imprime();

            System.out.println();

            System.out.print(f1.dequeue());

            System.out.println();

            f1.imprime();
        } catch (Exception e) {
        }
    }
}
