#include <stdio.h>

int main()
{
    int *p = 0x5DC;
    printf("p = Hexadecimal: %p Decimal: %d\n", p,p);
    
    p++;
    printf("p = Hexadecimal: %p Decimal: %d\n", p,p);
    
    p += 15;
    printf("p = Hexadecimal: %p Decimal: %d\n", p,p);
    
    p -= 2;
    printf("p = Hexadecimal: %p Decimal: %d\n", p,p);
    
    return 0;
}