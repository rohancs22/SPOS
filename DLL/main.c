#include<stdio.h>
#include"shared.h"
int main(void)
{
    unsigned int a = 6;
    unsigned int b = 2;
    unsigned int add_result = 0;
    unsigned int sub_result = 0;
    unsigned int mult_result = 0;

    add_result = add(a,b);
    sub_result = sub(a,b);
    mult_result = mult(a,b);

    printf("\n The addition is [%u]\n",add_result);
    printf("\n The subtraction is [%u]\n",sub_result);
    printf("\n The multiplication is [%u]\n",mult_result);
    return 0;
}
