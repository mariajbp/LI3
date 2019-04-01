#include "../include/catalogoProdutos.h"
#include "../include/catalogoClientes.h"
#include "../include/vendas.h"

void print_menu(){
	printf("\nO sistema de vendas realiza as seguintes tarefas:\n");
	printf("\n\t-> Tarefa_1:  Ler ficheiros (a lista de ficheiros disponivel é \'Produtos.txt\', \'Clientes.txt\', \'Vendas_1M.txt\').\n");
	printf("\n\t-> Tarefa_2:  Determinar a lista de produtos começados por uma Letra à escolha (A...Z).\n");
	printf("\n\t-> Tarefa_3:  Dado um mês e um produto, determinar e apresentar o nº total de registos\n\t   de venda e o total facturado com esse produto nesse mês, tendo em conta a distinção N/P,\n\t   há possibilidade de escolher a apresentação dos resultados dividida por filial.\n");
	printf("\n\t-> Tarefa_4:  Determinar a lista ordenada de produtos que ninguém comprou, e o seu total,\n\t   há possibilidade de escolher a apresentação dos resultados dividida por filial.\n");
	printf("\n\t-> Tarefa_5:  Determinar a lista ordenada de clientes que realizaram compras em todas as filiais.\n");
	printf("\n\t-> Tarefa_6:  Determinar o nº de clientes registados que não realizaram compras.\n\t   Determinar o nº de produtos que ninguém comprou.\n");
	printf("\n\t-> Tarefa_7:  Dado um cliente, criar uma tabela com o nº total de produtos comprados, mês a mês, organizado por filial.\n");
	printf("\n\t-> Tarefa_8:  Dado um intervalo de tempo (de mês __ a mês __):\n\t   Determinar o total de vendas registadas nesse intervalo e o total facturado.\n");
	printf("\n\t-> Tarefa_9:  Dado um produto e uma filial, determinar os clientes e o nº de clientes que o compraram,\n\t   distinguindo a compra entre N e P.\n");
	printf("\n\t-> Tarefa_10: Dado um cliente e um mês, determinar a lista de\n\t   produtos que esse cliente mais comprou, por ordem decrescente.\n");
	printf("\n\t-> Tarefa_11: Criar uma lista dos N produtos mais vendidos em todo o ano,\n\t   indicando o nº total de clientes e o nº total de unidades vendidas, filial a filial.\n");
	printf("\n\t-> Tarefa_12: Dado um cliente, determinar quais os 3 produtos em que gastou mais dinheiro durante o ano.\n\n");
}

int escolhe_Tarefa(){
	int tarefa = 0, r = 0;
	printf("Escolha a tarefa pretendida a realizar [1...12] (para terminar o programa digite 0):   ");
	if(scanf("%d", &tarefa)){

		if(tarefa > 12 || tarefa < 0){
			printf("\n\n\tPara executar uma tarefa é necessário inserir um numero de [1...12]\n\n\tPara terminar o programa digite 0.\n\n");
			escolhe_Tarefa();
		}

		if(!tarefa){
			printf("\n\n\tO programa vai agora terminar.\n\n\n");
			return -1;
		}

		switch(tarefa){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;	
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;	
			case 9:
				break;	
			case 10:
				break;	
			case 11:
				break;	
			case 12:
				break;
		}
	}
	else{
		printf("O programa falhou a ler um inteiro e vai agora terminar.\n");
		return -1;
	}

	return r;
}

//Main do projeto
int main(){
	//int num[6];
	//Tree tProdutos[26][26][151], tClientes[26][307];

	//init_Clientes(num,tClientes);
	//init_Produtos(num,tProdutos);
	//init_Vendas(num,tProdutos,tClientes);

	print_menu();

	if(escolhe_Tarefa() == -1)
		return 0;

	
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
