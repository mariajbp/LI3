#include "../include/IO.h"

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
	int tarefa, r = 0;
	int num[6];

	printf("Escolha a tarefa pretendida a realizar [1...12] (para terminar o programa digite 0):   ");
	if(scanf("%d", &tarefa)){

		if(tarefa > 12 || tarefa < 0){
			printf("\n\n\tPara executar uma tarefa é necessário inserir um numero de [1...12]\n\n\tPara terminar o programa digite 0.\n\n");
			escolhe_Tarefa();
		}

		switch(tarefa){
			case 1:
				query_1(num); 
				break;
			case 2:
				query_2(num);
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
		escolhe_Tarefa();
	}

	return r;
}


int qual_ficheiro(){
	int r;

	printf("\n\tQue ficheiro quer ler? Clientes.txt [1], Produtos.txt [2], Vendas_1M.txt [3], todos [4]\n\t->  ");
	scanf("%d", &r);
	
	if(r > 4 || r < 1) printf("\n\tO programa falhou a ler um inteiro de [1...3]\n");

	return r;
}

void query_1(int num[6]){
	int r = qual_ficheiro();
	Produtos tProdutos;
	Clientes tClientes;

	if(r == 1){
		init_Clientes(num);
		printf("\n\tFicheiro lido: Clientes.txt\n\tClientes lidos__%d\n\tClientes escritos__%d\n", num[0],num[1]);
	}
	
	if(r == 2){
		init_Produtos(num);
		printf("\n\tFicheiro lido: Produtos.txt\n\tProdutos lidos__%d\n\tProdutos escritos__%d\n", num[2],num[3]);
	}

	if (r == 3){
		Clientes clientes = init_Clientes(num);
		Produtos produtos = init_Produtos(num);
		init_Vendas(num,produtos,clientes);
		printf("\n\tFicheiro lido: Vendas_1M.txt\n\tVendas lidas__%d\n\tVendas escritas__%d\n", num[4],num[5]);
	}

	if(r == 4){
		tClientes = init_Clientes(num);
		tProdutos = init_Produtos(num);
		init_Vendas(num,tProdutos,tClientes);
		printf("\n\tFicheiro lido: Clientes.txt\n\tClientes lidos__%d\n\tClientes escritos__%d\n", num[0],num[1]);
		printf("\n\tFicheiro lido: Produtos.txt\n\tProdutos lidos__%d\n\tProdutos escritos__%d\n", num[2],num[3]);
		printf("\n\tFicheiro lido: Vendas_1M.txt\n\tVendas lidas__%d\n\tVendas escritas__%d\n", num[4],num[5]);
	}
}

void query_2(int num[6]){
	char* letra;
	int r;
	Produtos p = init_Produtos(num);

	printf("Qual a letra inicial (maiúscula) do código que pretende procurar? [A..Z]\n");
	scanf("%s", letra);
	r = letra  - 65;
	arrayLetra(p, letra); //função que devolva o array de letras 
	// navegador do array letra
}

void query_3()
{

}

void query_4()
{

} 

void query_5()
{

}

void query_6()
{

}

void query_7()
{

}

void query_8()
{

}

void query_9()
{

}

void query_10()
{

}

void query_11()
{

}

void query_12()
{

}

void toprintornottoprint()
{
	char* r;
	printf("Pretende dar print ao menu? Yes: [y] No: [n]\n");
	scanf("%c", &r);

	if(r == 'y')
		print_menu();

	if(r == 'n')
	{
		printf("Escolha a opção que pretende inicar [1...12]\n");
		escolhe_Tarefa();
	}
}
