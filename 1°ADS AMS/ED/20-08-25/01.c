#include <stdio.h>

int main()
{
    int x,y = 10;
    double r;
    
    printf("Digite um número: ");
    scanf("%d", &x);
    
    r = x / y;
    
    printf("\nResultado da divisão de %d por %d = %.2lf", x, y, r);

    return 0;
}