#include "../include/catalogoProdutos.h"
#include "../include/catalogoClientes.h"
#include "../include/vendas.h"
#include "../include/IO.h"
#include <time.h>



//Main do projeto
int main(){
	int num[6];

	Tree_Vendas vendas;
	Tree tProdutos[26][26][151], tClientes[26][307];

	
	print_menu();

	if(escolhe_Tarefa(num, vendas, tProdutos,tClientes) == -1)
		return 0;

	/*Na querie 1 será necessário dar free das hash tables
	  e temos de ter em consideração que não podemos por
	  isto assim na main, precisamos de uma função que 
	  faça isto tudo logo (modularidade/encapsulamento).*/
	  
	return 0;
}
