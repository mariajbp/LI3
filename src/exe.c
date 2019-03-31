#include "../include/valida.h"
#include "../include/file.h"
#include "../include/vendas.h"


//Main do projeto


int main(){

	int num[6];
	inicializar(num);

	printf("\n\n\tClientes lidos__%d\n\tClientes escritos__%d", num[0],num[1]);

	printf("\n\n\tProtudos lidos__%d\n\tProdutos escritos__%d", num[2],num[3]);

	/*Na querie 1 será necessário dar free das hash tables
	  e temos de ter em consideração que não podemos por
	  isto assim na main, precisamos de uma função que 
	  faça isto tudo logo (modularidade/encapsulamento).*/


//contar dados validos

	return 0;
}
