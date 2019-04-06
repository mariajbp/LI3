#include "../include/IO.h"

void print_menu(){
	printf("\nO sistema de vendas realiza as seguintes tarefas:\n");
	printf("\n\t-> Query 1:  Ler ficheiros (os ficheiros disponiveis para leitura são: \'Produtos.txt\', \'Clientes.txt\', \'Vendas_1M.txt\').\n");
	printf("\n\t-> Query 2:  Determinar a lista de produtos começados por uma Letra à escolha (A...Z).\n");
	printf("\n\t-> Query 3:  Dado um mês e um produto, determinar e apresentar o nº total de registos\n\t   de venda e o total facturado com esse produto nesse mês, tendo em conta a distinção N/P,\n\t   há possibilidade de escolher a apresentação dos resultados dividida por filial.\n");
	printf("\n\t-> Query 4:  Determinar a lista ordenada de produtos que ninguém comprou, e o seu total,\n\t   há possibilidade de escolher a apresentação dos resultados dividida por filial.\n");
	printf("\n\t-> Query 5:  Determinar a lista ordenada de clientes que realizaram compras em todas as filiais.\n");
	printf("\n\t-> Query 6:  Determinar o nº de clientes registados que não realizaram compras.\n\t   Determinar o nº de produtos que ninguém comprou.\n");
	printf("\n\t-> Query 7:  Dado um cliente, criar uma tabela com o nº total de produtos comprados, mês a mês, organizado por filial.\n");
	printf("\n\t-> Query 8:  Dado um intervalo de tempo (de mês __ a mês __):\n\t   Determinar o total de vendas registadas nesse intervalo e o total facturado.\n");
	printf("\n\t-> Query 9:  Dado um produto e uma filial, determinar os clientes e o nº de clientes que o compraram,\n\t   distinguindo a compra entre N e P.\n");
	printf("\n\t-> Query 10: Dado um cliente e um mês, determinar a lista de\n\t   produtos que esse cliente mais comprou, por ordem decrescente.\n");
	printf("\n\t-> Query 11: Criar uma lista dos N produtos mais vendidos em todo o ano,\n\t   indicando o nº total de clientes e o nº total de unidades vendidas, filial a filial.\n");
	printf("\n\t-> Query12: Dado um cliente, determinar os 3 produtos em que gastou mais dinheiro durante o ano.\n\n");
}

int escolhe_Query(){
	int tarefa;
	int r = 0;
	int num[6];
	printf("Escolha o numero da query que pretende executar [1...12] \n Terminar o programa: [0]   ");
	if(scanf("%d", &tarefa)){

		if(tarefa > 12 || tarefa < 0){
			printf("\n\n\tPara executar uma tarefa é necessário inserir um numero de [1...12]\n\n\tPara terminar o programa insira o número 0.\n\n");
			escolhe_Query();
		}

		switch(tarefa)
		{
			case 1:
				query_1(int num[6]); 
				break;
			case 2:
				query_2(int num[6]); 
				break;
			/*case 3:
				/query_3(int mes, char* code, faturacao f);
				break;
			case 4:
				query_4(Faturacao f)
				break;
			case 5:
				break;	
			case 6:
				break;
			case 7:
				query_7(Filial f, char* code);
				break;
			case 8:
				query_8(Faturacao f);
				break;	
			case 9:
				query_9();
				break;	
			case 10:
				query_10();
				break;	
			case 11:
				query_11();
				break;	
			case 12:
				query_12();
				break; */
		}
	}
	else{
		printf("O programa falhou na leitura de um número.\n");
		escolhe_Query();
	}

	return r;
}


int escolhe_file(){
	int r;

	printf("\n\tQue ficheiro pretende ler? Clientes.txt [1], Produtos.txt [2], Vendas_1M.txt [3], todos [4]\n\t->  ");
	scanf("%d", &r);
	
	if(r > 4 || r < 1) printf("\n\t O programa falhou na leitura de um número. [1...3]\n");

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
	Strings array_imprimir;

	printf("Qual a letra inicial (maiúscula) do código que pretende procurar? [A..Z]\n");
	scanf("%s", letra);

	array_imprimir = meteletra(Produtos p, char letra[0]);
	navegador(array_imprimir);
}

int navPag(Strings s)
{
	char* tecla;
	int p;
	printf("Que página pretende imprimir?\n");
	printf("\t Caso pretenda sair use a tecla espaço\n", );
	scanf("%s", tecla);
	while(tecla!=32)
	{
		p = atoi(tecla);
		for(int i = p; i < p+10; i++)
		{
			printf("\t%s\n",s->string[i]);
		}
		p+=10;
	}
	return p;
}

int navSetas(Strings s) //left was 75, right was 77 
{
	int p;
	char pag;
	char tecla;

	printf("Caso queira imprimir a página anterior/seguinte utilize as setas para navegar?\n");
	while(tecla!=32)
	{	
		if(p<=0) p=0;
		scanf("%s", &tecla);
		if(tecla == 77)
		{
			for(int i = p; i < p+10; i++)
			{
				printf("\t%s\n",s->string[i]);
			}
			p+=10;
		}
		if(tecla == 75)
		{
			for(int i = p - 10 ; i < p; i++)
			{
				printf("\t%s\n",s->string[i]);
			}
		}
	}
	return p;
}

void navegador(Strings s)
{
	int op;
	printf("Pretende escolher a página ou navegar com as setas? \n Escolher página: [1] Navegar com as setas: [2]\n");
	scanf("%d", &op);
	while(p!=32) //spacebar to end program
	{
		if (p==1) navPag(Strings s);
		if (p==2) navSetas(Strings s);
	}
}

/**
void query_3(int mes, char* code, faturacao f)
{
	//numero de vendas deste prod
	int r;
	printf("Qual o resultado que pretende obter? \n Filial 1: [1] Filial 2: [2] Filial 3: [3] Global:[4] \n");
	scanf("%d", &r);
	switch (r)
	{
		case 1:
			break;
		case 2: 
			break;
		case 3: 
			break;
		case 4: 
			break;
	}
	printf("O produto %s foi vendido .... vezes.\n", code);
	printf("A faturação total deste produto no mês %d foi: %f \n", mes, );
	printf("Faturação total dos produtos com o preço normal: \n");
	printf("Faturação total dos produtos em desconto: \n");
	
}
*/


void query_4(Faturacao f)
{
	int r;
	printf("Qual o resultado que deseja obter? \n Filial 1: [1] Filial 2: [2] Filial 3: [3] Global:[4] \n");
	scanf("%d", &r);
	switch (r)
	{
		case 1:
			break;
		case 2: 
			break;
		case 3: 
			break;
		case 4: 
			break;
	}

	//dar print à lista

} 

/**

void query_5(Filial f)
{
	//lista de codigo de clientes que compraram em todas as filiais
}

void query_6(Catalogo_Clientes cl, Catalogo_Produtos cp, Filial f)
{
	//lista de clientes que não fizeram compras
	//lista de produtos que não foram comprados
}

**/

void query_7(	)
{
	char* code;
	printf("Insira o código do cliente\n");
	scanf("%s", &code);
	//nUnidadesCompradas(code, Strings m, num[12][3])
}

/**

void query_8(Faturacao f)
{
	int i, f;
	printf("Indique o primeiro número do intervalo a procurar: \n");
	scanf("%d", &i);
	printf("Indique o ultimo número do intervalo a procurar: \n");
	scanf("%d", &f);
}

void query_9()
{
	char* code;
	printf("Indique o código do produto que procura: \n");
	scanf("%s", &code);
	int f;
	printf("Indique a filial em que pretende procurar: \n");
	scanf("%d", &f);
	//printar os numeros dos clientes que o compraram
	printf("Númmero total de clientes que compraram o produto com o preço normal: %d \n", );
	printf("Númmero total de clientes que compraram o produto em promoção: %d \n", );
}

void query_10()
{
	char* code;
	printf("Indique o código do cliente que procura: \n");
	scanf("%s", &code);
	int m;
	printf("Indique a o número do mês: \n");
	scanf("%d", &m);
	//lista de codigos  dos produtos + comprados por quantidade -> ordem descendente
 
}

void query_11()
{
	int n;
	printf("Indique o número de produtos que quer obter: \n");
	scanf("%d", &n);
	//lista de codigos de prods + comprados
	//numero de clientes que compraram
	printf("%d clientes adquiriram os %d produtos\n", ,n);
	//numero de units vendidas
	printf("Foram vendidas %d unidades \n", ,n);
	//filial a filial 
}

void query_12()
{
	char* code;
	printf("Indique o código do cliente: \n");
	scanf("%s", &code);
	//codigo dos 3 produtos em que mais gastou

}

*/

void toprintornottoprint()
{
	char* r = 0;
	printf("Pretende dar print ao menu? Yes: [y] No: [n]\n");
	scanf("%c", r);

	if(r[0] == 'y')
		print_menu();

	if(r[0] == 'n'){
		printf("Escolha a opção que pretende inicar [1...12]\n");
		escolhe_Query();
	}
}


void divisao(int num, int i)
{
	int f;
	char* tokens[7];
	if (num == 1)
	{
		f = atoi(tokens[6]);
		if(f == 1) printf("%s", tokens[i]);
	}
	if (num == 2)
	{
		f = atoi(tokens[6]);
		if(f == 2) printf("%s", tokens[i]);
		
	}
	if (num == 3)
	{
		f = atoi(tokens[6]);
		if(f == 3) printf("%s", tokens[i]);
		
	}
	if (num == 4)
	{
		
	}
}
