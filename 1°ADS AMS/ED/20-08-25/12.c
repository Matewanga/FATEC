#include <stdio.h>
#include <stdlib.h>

int main()
{
    int *p;
    p = (int *) malloc(5 * sizeof(int));
    int i;
    
    for(i = 0; i < 5; i++){
        printf("Digite o valor da posição %d: ", i);
        scanf("%d", &p[i]);
    }
    
    for(i = 0; i < 5; i++){
        printf("Valor na posição %d: %d\n", i, p[i]);
    }

    free(p);
    
    for(i = 0; i < 5; i++){
        printf("Valor na posição após a desalocação %d: %d\n", i, p[i]);
    }
    
    return 0;
}