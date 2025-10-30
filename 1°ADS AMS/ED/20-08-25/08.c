#include <stdio.h>

int main()
{
    int vet[5] = {1,2,3,4,5};
    int *p1 = vet;
    
    int i;
    
    for(i = 0; i < 5; i++){
        printf("%d\n", p1[i]);
    }
    
    return 0;
}