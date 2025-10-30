#include <stdio.h>

void trocaReferencia(int *a, int *b){
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
    printf("Dentro: %d e %d\n", *a, *b);
}

void trocaValor(int a, int b){
    int temp;
    temp = a;
    a = b;
    b = temp;
    printf("Dentro: %d e %d\n", a, b);
}

int main()
{
    int x1 = 2;
    int y1 = 3;
    printf("TROCA POR REFERENCIA\n");
    printf("Antes: %d e %d\n", x1, y1);
    trocaReferencia(&x1,&y1);
    printf("Depois: %d e %d\n", x1, y1);
    
    
    int x2 = 4;
    int y2 = 5;
    printf("TROCA POR VALOR\n");
    printf("Antes: %d e %d\n", x2, y2);
    trocaValor(x2,y2);
    printf("Depois: %d e %d\n", x2, y2);
    
    return 0;
}