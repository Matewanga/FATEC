#include <stdio.h>

typedef struct {
    int x,y;
} ponto;

void imprime(ponto p){
    printf("x = %d\n", p.x);
    printf("y = %d\n", p.y);
}

int main()
{
    ponto p1 = {10,20};
    imprime(p1);

    return 0;
}