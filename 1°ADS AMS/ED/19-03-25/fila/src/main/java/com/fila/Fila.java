package com.fila;

/**
 *
 * @author nickolss
 */
public class Fila {
    private Object vetor[];
    private int inicio, fim;
    
    public Fila(){
        this.vetor = new Object[1000];
        this.inicio = 0;
        this.fim = this.inicio;
    }
    
    public Fila(int maxTam){
        this.vetor = new Object[maxTam];
        this.inicio = 0;
        this.fim = this.inicio;
    }
    
    public void enqueue(Object valor) throws Exception {
        if((this.fim + 1) > this.vetor.length) {
            throw new Exception("Erro: A fila esta cheia");
        }
        this.vetor[this.fim] = valor;
        this.fim++;
    }
    
    public Object dequeue() throws Exception{
        if (this.vazia()){
            throw new Exception("Erro: A fila esta vazia");
        }
        
        Object valor = this.vetor[this.inicio];
        this.inicio = (this.inicio + 1) % this.vetor.length;
        return valor;
    }
    
    public boolean vazia(){
        return this.inicio == this.fim;
    }
    
    public void imprime(){
        for(int i=this.inicio; i!=this.fim; i++){
            System.out.print(this.vetor[i].toString() + " | ");
        }
    }
}
