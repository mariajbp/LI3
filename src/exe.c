#include "../include/valida.h"
#include "../include/file.h"
#include "../include/vendas.h"


//Main do projeto


int main(){

	int num[6];
	inicializar(num);

	printf("\n\tClientes lidos__%d\n\tClientes escritos__%d\n", num[0],num[1]);

	printf("\n\tProtudos lidos__%d\n\tProdutos escritos__%d\n", num[2],num[3]);

	//printf("\n\tVendas lidas__%d\n\tVendas escritas__%d\n", num[4],num[5]);

	char venda1[] = {"ZXD1419 362.44 157 P D2212 4 3"};

	/*Na querie 1 será necessário dar free das hash tables
	  e temos de ter em consideração que não podemos por
	  isto assim na main, precisamos de uma função que 
	  faça isto tudo logo (modularidade/encapsulamento).*/


	return 0;
}
