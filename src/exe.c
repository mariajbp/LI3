#include "../include/valida.h"
#include "../include/file.h"
#include "../include/vendas.h"

//Main do projeto


int main(){
	char a[] = "F2916", b[] = "DV1294";
	const char *pp[] = {"KR1583", "DV1294", "FF2916"};
	const char *cc[] = {"L4891"};
	char c[] = "KR1583 77.72 128 P L4891 2 1";
	char c2[] = "KR1583 77.72 128 P L4892 2 ";

	printf("\nVALIDA CLIENTE/PRODUTO\n\n");
	printf("valida A deve dar 1 e 0, da - %d %d\n", validaCliente(a,5), validaProduto(a,6) );
	printf("valida B deve dar 0 e 1, da - %d %d\n", validaCliente(b,5), validaProduto(b,6) );
	
	printf("\nVALIDA VENDAS\n\n");
	printf("\ndeve dar 1 = %d\n", validaVenda(c , pp, cc ) );
	printf("\ndeve dar 0 = %d\n", validaVenda(c2, pp, cc ) );
	return 0;
}