#include <stdio.h>

int main()
{
    int *p, x = 10;
    p = &x;
    printf("Conteúdo apontado por p: %d\n", *p);
    
    *p = (*p) + 1;
    printf("Conteúdo apontado por p: %d\n", *p);
    
    *p = (*p) * 10;
    printf("Conteúdo apontado por p: %d\n", *p);
    
    return 0;
}