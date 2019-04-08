#include "../include/IO.h"

#define RESET  "\x1B[0m"
#define KRED  "\x1B[31m"
#define KGRN  "\x1B[32m"
#define KYEL  "\x1B[33m"
#define KBLU  "\x1B[34m"
#define KMAG  "\x1B[35m"
#define KCYN  "\x1B[36m"
#define KWHT  "\x1B[37m"


void toprintornottoprint(){
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

void print_menu(){
	printf("%s\n************************************************** Sistema de Gestão de Vendas ************************************************** %s\n", KCYN, RESET);
	printf("%s\n\t->%s Query 1:  Ler ficheiros (os ficheiros disponiveis para leitura são: \'Produtos.txt\', \'Clientes.txt\', \'Vendas_1M.txt\').\n", KCYN, RESET);
	printf("%s\n\t->%s Query 2:  Determinar a lista de produtos começados por uma Letra à escolha (A...Z).\n" , KCYN, RESET);
	printf("%s\n\t->%s Query 3:  Dado um mês e um produto, determinar e apresentar o nº total de registos\n\t   de venda e o total facturado com esse produto nesse mês, tendo em conta a distinção N/P,\n\t   há possibilidade de escolher a apresentação dos resultados dividida por filial.\n" , KCYN, RESET);
	printf("%s\n\t->%s Query 4:  Determinar a lista ordenada de produtos que ninguém comprou, e o seu total,\n\t   há possibilidade de escolher a apresentação dos resultados dividida por filial.\n", KCYN, RESET);
	printf("%s\n\t->%s Query 5:  Determinar a lista ordenada de clientes que realizaram compras em todas as filiais.\n", KCYN, RESET);
	printf("%s\n\t->%s Query 6:  Determinar o nº de clientes registados que não realizaram compras.\n\t   Determinar o nº de produtos que ninguém comprou.\n", KCYN, RESET);
	printf("%s\n\t->%s Query 7:  Dado um cliente, criar uma tabela com o nº total de produtos comprados, mês a mês, organizado por filial.\n", KCYN, RESET);
	printf("%s\n\t->%s Query 8:  Dado um intervalo de tempo (de mês __ a mês __):\n\t   Determinar o total de vendas registadas nesse intervalo e o total facturado.\n", KCYN, RESET);
	printf("%s\n\t->%s Query 9:  Dado um produto e uma filial, determinar os clientes e o nº de clientes que o compraram,\n\t   distinguindo a compra entre N e P.\n", KCYN, RESET);
	printf("%s\n\t->%s Query 10: Dado um cliente e um mês, determinar a lista de\n\t   produtos que esse cliente mais comprou, por ordem decrescente.\n", KCYN, RESET);
	printf("%s\n\t->%s Query 11: Criar uma lista dos N produtos mais vendidos em todo o ano,\n\t   indicando o nº total de clientes e o nº total de unidades vendidas, filial a filial.\n", KCYN, RESET);
	printf("%s\n\t->%s Query12: Dado um cliente, determinar os 3 produtos em que gastou mais dinheiro durante o ano.\n\n", KCYN, RESET);
	printf("%s********************************************************************************************************************************* %s\n", KCYN, RESET);
}

int escolhe_Query(){
	int tarefa;
	int r = 0;
	int num[6];
	printf("Escolha o numero da query que pretende executar [1...12]\n\tTerminar o programa: [0]   ");
	if(scanf("%d", &tarefa)){

		if(tarefa > 12 || tarefa < 0){
			printf("\n\n\tPara executar uma tarefa é necessário inserir um numero de [1...12]\n\n\tPara terminar o programa insira o número 0.\n\n");
			escolhe_Query();
		}

		switch(tarefa)
		{
			case 1:
				query_1(); 
				break;
			case 2:
				query_2(); 
				break;
			/*case 3:
				query_3();
				break;
			case 4:
				query_4()
				break;
			case 5:
				break;	
			case 6:
				break;
			case 7:
				query_7();
				break;
			case 8:
				query_8();
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
		printf("\n\tO programa falhou na leitura de um número.\n");
		escolhe_Query();
	}

	return r;
}

void divFilial1(Strings v, int i)
{
	int f;
	char* tokens[7];
	for(int i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));

	for (int j = 0; j < v->inUse; j++)
		{
			toktok(tokens,v->string[j]);
			f = atoi(tokens[6]);
			if (f == 1)
				printf("%s \n",tokens[i]);
		}
}


void divFilial2(Strings v, int i)
{
	int f;
	char* tokens[7];
	for(int i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));
	
	for (int j = 0; j < v->inUse; j++)
		{
			toktok(tokens,v->string[j]);
			f = atoi(tokens[6]);
			if (f == 2)
				printf("%s \n",tokens[i]);
		}
}


void divFilial3(Strings v, int i)
{
	int f;
	char* tokens[7];
	for(int i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));
	
	for (int j = 0; j < v->inUse; j++)
		{
			toktok(tokens,v->string[j]);
			f = atoi(tokens[6]);
			if (f == 3)
				printf("%s \n", tokens[i]);
		}
}

void global(Strings v, int i)
{
	char* tokens[7];
	for(int i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));
	for (int j = 0; j < v->inUse; j++)
		{
			toktok(tokens,v->string[j]);
			printf("%s \n", tokens[i]);
		}

}


/////////////////////////////////////////////////
//// 				query_1					////
///////////////////////////////////////////////

int escolhe_file(){
	int r;

	printf("\n\tQue ficheiro pretende ler? Clientes.txt [1], Produtos.txt [2], Vendas_1M.txt [3], todos [4]\n\t->  ");
	scanf("%d", &r);
	
	if(r > 4 || r < 1) printf("\n\tO programa falhou na leitura de um número. [1...3]\n");

	return r;
}

void query_1(int num[6]){
	clock_t start,finish;
	int r = escolhe_file();
	Produtos tProdutos;
	Clientes tClientes;
	Vendas v;

	if(r == 1){
		start = clock();
		init_Clientes(num);
		printf("%s\n\tFicheiro lido: %sClientes.txt\n\t%sClientes lidos__%s%d\n\t%sClientes escritos__%s%d\n",KBLU,RESET,KBLU,RESET,num[0],KBLU,RESET,num[1]);
		finish = clock();
		printf("demorou %lu segundos\n", (finish - start));
		free(tClientes);
	}
	
	if(r == 2){
		start = clock();
		init_Produtos(num);
		printf("%s\n\tFicheiro lido: %sProdutos.txt\n\t%sProdutos lidos__%s%d\n\t%sProdutos escritos__%s%d\n",KBLU,RESET,KBLU,RESET,num[2],KBLU,RESET,num[3]);
		
		free(tProdutos);
	}

	if (r == 3){
		start = clock();
		tClientes = init_Clientes(num);
		tProdutos = init_Produtos(num);
		v = init_Vendas(num,tProdutos,tClientes);
		printf("%s\n\tFicheiro lido: %sVendas_1M.txt\n\t%sVendas lidas__%s%d\n\t%sVendas escritas__%s%d\n",KBLU,RESET,KBLU,RESET,num[4],KBLU,RESET,num[5]);
		finish = clock();
		printf("demorou %lu segundos\n", (finish - start));
		free(tClientes);
		free(tProdutos);
		free(v);
	}

	if(r == 4){
		start = clock();
		tClientes = init_Clientes(num);
		tProdutos = init_Produtos(num);
		v = init_Vendas(num,tProdutos,tClientes);
		printf("%s\n\tFicheiro lido: %sClientes.txt\n\t%sClientes lidos__%s%d\n\t%sClientes escritos__%s%d\n",KBLU,RESET,KBLU,RESET,num[0],KBLU,RESET,num[1]);
		printf("%s\n\tFicheiro lido: %sProdutos.txt\n\t%sProdutos lidos__%s%d\n\t%sProdutos escritos__%s%d\n",KBLU,RESET,KBLU,RESET,num[2],KBLU,RESET,num[3]);
		printf("%s\n\tFicheiro lido: %sVendas_1M.txt\n\t%sVendas lidas__%s%d\n\t%sVendas escritas__%s%d\n",KBLU,RESET,KBLU,RESET,num[4],KBLU,RESET,num[5]);
		finish = clock();
		printf("demorou %lu segundos\n", (finish - start));
		free(tClientes);
		free(tProdutos);
		free(v);
	}
}
/**
/////////////////////////////////////////////////
//// 				query_2					////
///////////////////////////////////////////////

int navPag(Strings s){
	char tecla;
	int p;
	printf("%sQue página pretende imprimir?%s\n", KCYN, RESET);
	printf("\t%sCaso pretenda sair use a tecla espaço%s\n",KBLU,RESET);
	scanf("%s", &tecla);
	while(tecla!=32){
		p = tecla - 48;
		for(int i = p; i < p+10; i++){
			printf("\t%s\n",s->string[i]);
		}
		p+=10;
	}

	return p;
}

int navSetas(Strings s){
	int p;
	char tecla;

	printf("Caso queira imprimir a página anterior/seguinte utilize as setas para navegar?\n");
	while(tecla!=32){
		if(p<=0) p=0;
		scanf("%s", &tecla); //left was 75, right was 77 
		if(tecla == 77){
			for(int i = p; i < p+10; i++){
				printf("\t%s\n",s->string[i]);
			}
			p+=10;
		}
		if(tecla == 75){
			for(int i = p - 10 ; i < p; i++){
				printf("\t%s\n",s->string[i]);
			}
		}
	}

	return p;
}

void navegador(Strings s){
	int op;
	printf("Pretende %sescolher a página%s ou %snavegar com as setas%s? \n Escolher página: %s[1]%s Navegar com as setas: %s[2]%s\n", KBLU,RESET,KCYN,RESET,KBLU,RESET,KCYN,RESET);
	scanf("%d", &op); //spacebar to end program
	while(op!=32){
		if (op==1) navPag(s);
		if (op==2) navSetas(s);
	}
}

void query_2(int num[6]){
	clock_t finish, start;
	char* letra;
	Produtos p = init_Produtos(num);
	Strings a_imprimir;

	printf("%sQual a letra inicial (maiúscula) do código que pretende procurar? [A..Z]%s\n", KMAG, RESET);
	scanf("%s", letra);

	start = clock();
	a_imprimir = meteletra(p, letra[0]);
	navegador(a_imprimir);
	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));

	//dar free
	
}
*/

/////////////////////////////////////////////////
//// 				query_3					////
///////////////////////////////////////////////
/*
void query_3(num[6])
{
	int r;
	clock_t finish, start;
	int mes;
	char* code;
	Vendas nv;
	Printf("Indique o mês a determinar: \n")
	scanf("%d", &mes);
	printf("Indique o codigo do produto: \n", );
	scanf("%s", &code);

	printf("%sQual o resultado que pretende obter?%s \n Filial 1: [1] Filial 2: [2] Filial 3: [3] Global:[4] \n", KMAG, RESET);
	scanf("%d", &r);
	switch (r)
	{
		case 1:
			nv = divFilial1(v,1);
			free(v);
			break;
		case 2: 
			nv = divFilial2(v,1);
			free(v);
			break;
		case 3: 
			nv = divFilial3(v,1);
			free(v);
			break;
		case 4: 
			nv = global();
			free(v);
			break;
	}

	start = clock();

	double totalF = totalFaturado(nv);
	double totalN = totalFaturadoNP(nv, num[1]);
	double totalP = totalFaturadoNP(nv, num[2]);
	double totalV = totalVendasProd(nv, code);

	printf("O produto %s foi vendido %f vezes.\n", code, totalV);
	printf("A faturação total deste produto no mês %d foi: %f \n", mes, totalF);
	printf("Faturação total dos produtos com o preço normal: %f \n", totalN);
	printf("Faturação total dos produtos em desconto: %f \n", totalP);

	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));

	free(nv);
}

*/
/////////////////////////////////////////////////
//// 				query_4					////
///////////////////////////////////////////////
/**

void query_4(num[6])
{
	int r;
	clock_t finish, start;
	Produtos p = init_Produtos(num);
	Vendas v = init_Vendas(fucking argumentos);
	Vendas nv;
	printf("%sQual o resultado que pretende obter?%s \n Filial 1: [1] Filial 2: [2] Filial 3: [3] Global:[4] \n", KBLU,RESET);
	scanf("%d", &r);
	switch (r)
	{
		case 1:
			nv = divFilial1(v,1);
			free(v);
			break;
		case 2: 
			nv = divFilial2(v,1);
			free(v);
			break;
		case 3: 
			nv = divFilial3(v,1);
			free(v);
			break;
		case 4: 
			nv = global();
			free(v);
			break;
	}

	start = clock();
	Strings res = naoComprados(nv, "Produtos.txt"); ??
	

	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));
	free(nv);
} 
*/


/////////////////////////////////////////////////
//// 				query_5					////
///////////////////////////////////////////////

/*
void query_5()
{
	clock_t finish, start;
	start = clock();
	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));
	//lista de codigo de clientes que compraram em todas as filiais
}
*/

/////////////////////////////////////////////////
//// 				query_6					////
///////////////////////////////////////////////

/*
void query_6()
{
	clock_t finish, start;
	printf("%sOs seguintes clientes não realizaram qualquer compra: %s\n", KBLU, RESET);
	//lista de clientes que não fizeram compras
	start = clock();
	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));
	
	printf("%sOs seguintes produtos nunca foram comprados: %s\n", KBLU, RESET);
	//lista de produtos que não foram comprados
}
*/


/////////////////////////////////////////////////
//// 				query_7					////
///////////////////////////////////////////////

/*
void query_7(	)
{
	char* code;
	printf("%sInsira o código do cliente: %s\n", KMAG, RESET);
	scanf("%s", &code);
	//nUnidadesCompradas(code, Strings m, num[12][3])
	start = clock();
	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));
}

/////////////////////////////////////////////////
//// 				query_8					////
///////////////////////////////////////////////

/*
void query_8(Faturacao f)
{
	int i, f;
	printf("%sIndique o primeiro número do intervalo que procura: %s\n", KCYN, RESET);
	scanf("%d", &i);
	printf("%sIndique o ultimo número do intervalo que procura: %s\n",KCYN, RESET);
	scanf("%d", &f);
	start = clock();
	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));
}

/////////////////////////////////////////////////
//// 				query_9					////
///////////////////////////////////////////////

/*
void query_9()
{
	char* code;
	printf("%sIndique o código do produto que procura: %s\n", KCYN, RESET);
	scanf("%s", &code);
	int f;
	printf("%sIndique a filial em que pretende procurar: %s\n" KMAG, RESET);
	scanf("%d", &f);
	//printar os numeros dos clientes que o compraram
	printf("%s\tNúmmero total de clientes que compraram o produto com o preço normal: %s%d \n", KCYN, RESET);
	printf("%s\tNúmmero total de clientes que compraram o produto em promoção: %s %d \n", KMAG, RESET);
	start = clock();
	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));
}

/////////////////////////////////////////////////
//// 				query_10				////
///////////////////////////////////////////////

/*
void query_10()
{
	char* code;
	printf("%sIndique o código do cliente que procura: %s\n", KBLU, RESET);
	scanf("%s", &code);
	int m;
	printf("%sIndique a o número do mês: %s\n", KMAG, RESET);
	scanf("%d", &m);
	//lista de codigos  dos produtos + comprados por quantidade -> ordem descendente
	start = clock();
	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));
 
}
*/

/////////////////////////////////////////////////
//// 				query_11				////
///////////////////////////////////////////////
/*
void query_11()
{
	int n;
	clock_t start, finish;
	printf("%sIndique o número de produtos que pretende obter: %s\n", KCYN, RESET);
	scanf("%d", &n);

	printf("%sQual o resultado que pretende obter?%s \n Filial 1: [1] Filial 2: [2] Filial 3: [3] Global:[4] \n", KMAG, RESET);
	scanf("%d", &r);
	switch (r)
	{
		case 1:
			nv = divFilial1(v,1);
			free(v);
			break;
		case 2: 
			nv = divFilial2(v,1);
			free(v);
			break;
		case 3: 
			nv = divFilial3(v,1);
			free(v);
			break;
		case 4: 
			nv = global();
			free(v);
			break;
	}
	start = clock();

	//lista de codigos de prods + comprados
	printf("%d clientes adquiriram os %d produtos\n", ,n);
	printf("Foram vendidas %d unidades \n", ,n);


	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));
}
*/

/////////////////////////////////////////////////
//// 				query_12				////
///////////////////////////////////////////////



void query_12()
{
	clock_t start, finish;
	char* code;
	char* maisComprados[3];
	printf("%sIndique o código do cliente: %s\n", KBLU, RESET);
	scanf("%s", &code);
	start = clock();
	

	//codigo que realmente importa


	printf("Os 3 produtos em que mais gastou dinheiro foram: \n\t %s\t%s\t%s\t ", maisComprados[1], maisComprados[2], maisComprados[3]);
	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));
}


