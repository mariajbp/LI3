#include "../include/catalogoProdutos.h"
#include "../include/catalogoClientes.h"
#include "../include/vendas.h"

void print_menu(){
	printf("\n\tO sistema de vendas realiza as seguintes tarefas:\n");
	printf("\n\t\t-> Tarefa_1: Ler ficheiros (a lista de ficheiros disponivel é \'Produtos.txt\', \'Clientes.txt\', \'Vendas_1M.txt\').\n");
	printf("\n\t\t-> Tarefa_2: Determinar a lista de produtos começados por uma Letra à escolha (A...Z).\n");
	printf("\n\t\t-> Tarefa_3: Dado um mês e um produto, determinar e apresentar o nº total de registos\n\t\t   de venda e o total facturado com esse produto nesse mês, tendo em conta a distinção N/P,\n\t\t   há possibilidade de escolher a apresentação dos resultados dividida por filial.\n");
	printf("\n\t\t-> Tarefa_4: Determinar a lista ordenada de produtos que ninguém comprou, e o seu total,\n\t\t   há possibilidade de escolher a apresentação dos resultados dividida por filial.\n");
	printf("\n\t\t-> Tarefa_5: \n");
	printf("\n\t\t-> Tarefa_6: \n");
}

//Main do projeto
int main(){
	//int num[6];
	//Tree tProdutos[26][26][151], tClientes[26][307];

	//init_Clientes(num,tClientes);
	//init_Produtos(num,tProdutos);
	//init_Vendas(num,tProdutos,tClientes);

	print_menu();
	
	//printf("\n\tClientes lidos__%d\n\tClientes escritos__%d\n", num[0],num[1]);

	//printf("\n\tProdutos lidos__%d\n\tProdutos escritos__%d\n", num[2],num[3]);

	//printf("\n\tVendas lidas__%d\n\tVendas escritas__%d\n", num[4],num[5]);




	//char venda1[] = {"ZXD1419 362.44 157 P D2212 4 3"};

	/*Na querie 1 será necessário dar free das hash tables
	  e temos de ter em consideração que não podemos por
	  isto assim na main, precisamos de uma função que 
	  faça isto tudo logo (modularidade/encapsulamento).*/
	  
	return 0;
}
