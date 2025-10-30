#include <stdio.h>

int main()
{
    int x = 10;
    int y = 20;
    
    int *px;
    int *py;
    
    px = &x;
    py = &y;
    
    printf("\n x = %d \t y = %d \t px = %p \t *px = %d", x,y,px,*px);
    printf("\n x = %d \t y = %d \t py = %p \t *py = %d", x,y,py,*py);

    *px = 30;
    printf("\n x = %d \t y = %d \t px = %p \t *px = %d", x,y,px,*px);
}