#include <stdio.h>

int main()
{
    int *p = 0x3F8;
    int *p1 = 1500;
    
    printf("Endereço em p: %p\n", p);
    printf("Endereço em p1: %p\n", p1);
    
    return 0;
}