#include <stdio.h>

int main()
{
    int *p, *p1, x = 10;
    float y = 20.0;
    
    p = &x;
    printf("Conteúdo apontado por p: %d\n", *p);
    
    p1 = p;
    printf("Conteúdo apontado por p1: %d\n", *p1);
    
    p = &y;
    printf("Conteúdo apontado por p: %d\n", *p);
    printf("Conteúdo apontado por p: %f\n", *p);
    printf("Conteúdo apontado por p: %f\n", *((float *)p));
    
    return 0;
}