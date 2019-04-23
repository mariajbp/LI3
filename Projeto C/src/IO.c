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
	char* r = malloc(sizeof(char*));
	printf("Pretende dar print ao menu? Yes: [y] No: [n]\n");
	scanf("%c", r);

	if(r[0] == 'y'){
		print_menu();
		escolhe_Query();
	}

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
			case 3:
				query_3();
				break;
			case 4:
				query_4();
				break;
			case 5:
				query_5();
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
		}
	}
	else{
		printf("\n\tO programa falhou na leitura de um número.\n");
		escolhe_Query();
	}

	return r;
}


/////////////////////////////////////////////////
//// 				navegador				////
///////////////////////////////////////////////

//Imprime uma Strings
void printPagina(Strings s){

	int numP = 30, pag = 1, index = 0, conta = 0,op;
	
	while(1){

		conta = 0;

		printf("\n\n");
		printf("%s************ Página %d ************%s\n",KBLU,pag, RESET);

		while(conta < numP){
			if(index <= s->inUse){
					printf("%s \t-> %s %d  - %s",KCYN, RESET, index,  s->string[index]);
					conta++;
					index++;
			}
			else break;
		}

		printf("%s**********************************%s\n",KBLU, RESET);
		printf("\n%s[1]%s = Página anterior\n%s[2]%s = Página seguinte\n%s[0]%s = Sair \n",KCYN, RESET,KCYN, RESET,KCYN, RESET);

		scanf("%d", &op );
		if(op == 1){
			if(index >= 0){
				index = index - 2*numP-1;
				if(index < 0) index = 0;
				if(pag > 1) pag--;
			}
		}

		if(op == 2){
			if(index <= s->inUse){
				index++;;
				if(index > s->inUse) index = s->inUse;
				pag++;
			}
		}

		if( op == 0){
			break;
		}	
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

void query_1(){
	int num[6];
	int r = escolhe_file();
	Produtos tProdutos;
	Clientes tClientes;
	Vendas v;

	if(r == 1){
		init_Clientes(num);
		printf("%s\n\tFicheiro lido: %sClientes.txt\n\t%sClientes lidos__%s%d\n\t%sClientes escritos__%s%d\n",KBLU,RESET,KBLU,RESET,num[0],KBLU,RESET,num[1]);
		free(tClientes);
	}
	
	if(r == 2){
		init_Produtos(num);
		printf("%s\n\tFicheiro lido: %sProdutos.txt\n\t%sProdutos lidos__%s%d\n\t%sProdutos escritos__%s%d\n",KBLU,RESET,KBLU,RESET,num[2],KBLU,RESET,num[3]);
		free(tProdutos);
	}

	if (r == 3){
		tClientes = init_Clientes(num);
		tProdutos = init_Produtos(num);
		v = init_Vendas(num,tProdutos,tClientes);
		printf("%s\n\tFicheiro lido: %sVendas_1M.txt\n\t%sVendas lidas__%s%d\n\t%sVendas escritas__%s%d\n",KBLU,RESET,KBLU,RESET,num[4],KBLU,RESET,num[5]);
		free(tClientes);
		free(tProdutos);
		free(v);
	}

	if(r == 4){
		tClientes = init_Clientes(num);
		tProdutos = init_Produtos(num);
		v = init_Vendas(num,tProdutos,tClientes);
		printf("%s\n\tFicheiro lido: %sClientes.txt\n\t%sClientes lidos__%s%d\n\t%sClientes escritos__%s%d\n",KBLU,RESET,KBLU,RESET,num[0],KBLU,RESET,num[1]);
		printf("%s\n\tFicheiro lido: %sProdutos.txt\n\t%sProdutos lidos__%s%d\n\t%sProdutos escritos__%s%d\n",KBLU,RESET,KBLU,RESET,num[2],KBLU,RESET,num[3]);
		printf("%s\n\tFicheiro lido: %sVendas_1M.txt\n\t%sVendas lidas__%s%d\n\t%sVendas escritas__%s%d\n",KBLU,RESET,KBLU,RESET,num[4],KBLU,RESET,num[5]);
		free(tClientes);
		free(tProdutos);
		free(v);
	}
}

/////////////////////////////////////////////////
//// 				query_2					////
///////////////////////////////////////////////

void query_2(){
	int num[6];
	char* letra;
	Produtos p = init_Produtos(num);
	Strings array_imprimir;

	start = clock();
	FILE* file = fopen("Produtos.txt", "r");
	if(file == NULL)
	{
		printf("Error! You tried to read an empty file.");
		fclose(file);
		exit(1);
	}

	while(fgets(linha, 10, file))
	{	
		
		if(linha[0] == letra)
			string_append(s,linha);
		
	}
	fclose(file);

	printPagina(s);

	end = clock();
	cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
	printf("Demorou %f segundos\n", cpu_time_used );
}

/////////////////////////////////////////////////
//// 				query_3					////
///////////////////////////////////////////////

void query_3(){
	clock_t finish, start;
	char* code = malloc(sizeof(char)*7);
	int mes;
	int f;
	Strings s;
	double* num = malloc(sizeof(double)*2);

	printf("%sIndique o codigo do produto: %s\n", KBLU, RESET);
	scanf("%s", code);
	printf("%sIndique mes: %s\n", KBLU, RESET);
	scanf("%d", &mes);

	printf("%sQual o resultado que pretende obter?%s \n Filial 1: [1] Filial 2: [2] Filial 3: [3] Global:[4] \n", KMAG, RESET);
	scanf("%d", &f);
	switch (f)
	{
		case 1:
			s = getVendasProdFM("../VendasValidas.txt",code,mes,f);
			break;
		case 2: 
			s = getVendasProdFM("../VendasValidas.txt",code,mes,f);
			break;
		case 3: 
			s = getVendasProdFM("../VendasValidas.txt",code,mes,f);
			break;
		case 4: 
			s = getvendas_PinM("../VendasValidas.txt",code, mes);
			break;
	}

	start = clock();

	int totalV = s->inUse;
	double totalF = totalFaturado(s);
	totalFaturadoNP(s,num);

	finish = clock();
	
	if(s->inUse == 0) printf("Não foram encontrados resultados, certifique-se que inseriu valores válidos\n");
	else{
		printf("O produto %s foi vendido %d vezes.\n", code, totalV);
		printf("A faturação total deste produto no mês %d foi: %f \n", mes, totalF);
		printf("Faturação total dos produtos com o preço normal: %f \n", num[0]);
		printf("Faturação total dos produtos em desconto: %f \n", num[1]);
	}

	free(s);
	free(code);
	free(num);

	printf("demorou %lu segundos\n", (finish - start));
}

/////////////////////////////////////////////////
//// 				query_4					////
///////////////////////////////////////////////

void query_4(){
	clock_t finish, start;
	Strings c, nc;
	int filial;

	printf("%sQual o resultado que pretende obter?%s \n Filial 1: [1] \n Filial 2: [2] \n Filial 3: [3] \n Global:   [4] \n", KMAG, RESET);
	scanf("%d", &filial);
	
	start = clock();
	switch (filial)
	{
		case 1:
			c = comprados_Filial("../VendasValidas.txt", filial);
				// [DEBGUG] // printf("Comprados: %d\n", c->inUse);
			nc = naoComprado("../ProdutosValidos.txt", c);
			printf("Existem %d produtos que nunca foram comprados.",nc->inUse);
			break;
		case 2: 
			c = comprados_Filial("../VendasValidas.txt", filial);
			nc = naoComprado("../ProdutosValidos.txt", c);
			printf("Existem %d produtos que nunca foram comprados.",nc->inUse);
			break;
		case 3: 
			c = comprados_Filial("../VendasValidas.txt", filial);
			nc = naoComprado("../ProdutosValidos.txt", c);
			printf("Existem %d produtos que nunca foram comprados.",nc->inUse);
			break;
		case 4: 
			//
			break;
	}
	
	finish = clock();
	printf("demorou %lu segundos\n", (finish - start));

	free(c);
	free(nc);
}

/////////////////////////////////////////////////
//// 				query_5					////
///////////////////////////////////////////////

void query_5(){
	clock_t start, end;
	double cpu_time_used;
	start = clock();

	Strings vendas[3];
	for(int i = 0; i < 3; i++)
		vendas[i] = create_Strings();
	
	Strings clientes_v = create_Strings();
	Strings clientes = create_Strings();

	le_Clientes("../ClientesValidos.txt", clientes_v);
	le_Vendas("../VendasValidas.txt", vendas);


	filter_CF(vendas,clientes_v,clientes);
	end = clock();
	cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
	free(clientes_v);
	
	printPagina(clientes);

	free(clientes);

	printf("demorou %f segundos\n", cpu_time_used );
}

/*
void query_6()
{
	printf("%sOs seguintes clientes não realizaram qualquer compra: %s\n", KBLU, RESET);
	//lista de clientes que não fizeram compras
	
	printf("%sOs seguintes produtos nunca foram comprados: %s\n", KBLU, RESET);
	//lista de produtos que não foram comprados
}

*/

/////////////////////////////////////////////////
//// 				query_7					////
///////////////////////////////////////////////
/*
void query_7(){
	char* code;
	printf("%sInsira o código do cliente: %s\n", KMAG, RESET);
	scanf("%s", code);

	Vendas_inMes vM_Cliente = vendas_cliente(ccode, "../VendasValidas.txt");
	nUnidadesCompradas(vM_Cliente, num[12][4]);

	for (int m = 0; m < 12; m++)
		for (int f = 0; f < 4; f++)
			printf("\n\t|_%d_|\n", num[m][f]);
}
*/
/////////////////////////////////////////////////
//// 				query_8					////
///////////////////////////////////////////////

void query_8(){
	int i, f;
	double n[2];
	clock_t start, end;
	double cpu_time_used;
	start = clock();
	
	printf("%sIndique o primeiro número do intervalo que procura: %s\n", KCYN, RESET);
	scanf("%d", &i);
	
	printf("%sIndique o ultimo número do intervalo que procura: %s\n",KCYN, RESET);
	scanf("%d", &f);
	start = clock();
	
	totalV_F("../VendasValidas.txt",i,f, n);

	printf("\n\tTotal de vendas: %d\n\tTotal Faturado: %.4f\n", (int) n[0], n[1] );
	end = clock();
	cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

	printf("demorou %f segundos\n", cpu_time_used );
}

/////////////////////////////////////////////////
//// 				query_9					////
///////////////////////////////////////////////

void query_9(){
	clock_t start, end;
	double cpu_time_used;
	char* tokens[7];
	char* code = malloc(sizeof(char*));
	int f = 0 ;

	printf("%sIndique o codigo do produto: %s\n", KBLU, RESET);
	scanf("%s", code);
	printf("%sIndique o número da filial: %s\n", KBLU, RESET);
	scanf("%d", &f);

	start = clock();

	Strings s = getVendasProdFilial("../VendasValidas.txt", code, f);

	if(s->inUse == 0) printf("Não foi encontrado nenhum resultado\n");
	else{
		for(int i = 0; i < s->inUse; i++){	
			toktok(s->string[i],tokens);
			printf("Cliente: %s    Tipo: %s\n",tokens[4], tokens[3]);
		}
	}

	end = clock();
	cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
	printf("Demorou %f segundos\n", cpu_time_used );

	free(code);
}

/////////////////////////////////////////////////
//// 				query_10				////
///////////////////////////////////////////////

void query_10(){
	char* code = malloc(sizeof(char*));
	int mes;
	clock_t start, end;
	double cpu_time_used;

	printf("%sIndique o mês: %s\n", KBLU, RESET);
	scanf("%d", &mes);
	printf("%sIndique o código do cliente: %s\n", KBLU, RESET);
	scanf("%s", code);
	

	if(mes <= 12 && mes >= 0){
		start = clock();
		
		cria_listaProdutos("../VendasValidas.txt",code,mes);
		
		end = clock();
		cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

		printf("demorou %f segundos\n", cpu_time_used );
	}
}

/////////////////////////////////////////////////
//// 				query_11				////
///////////////////////////////////////////////

/*
void query_11()
{
	int n;
	printf("%sIndique o número de produtos que pretende obter: %s\n", KCYN, RESET);
	scanf("%d", &n);
	//lista de codigos de prods + comprados
	//numero de clientes que compraram
	printf("%d clientes adquiriram os %d produtos\n", ,n);
	//numero de units vendidas
	printf("Foram vendidas %d unidades \n", ,n);
	//filial a filial 
}

/////////////////////////////////////////////////
//// 				query_12				////
///////////////////////////////////////////////

/*
void query_12()
{
	char* code;
	printf("%sIndique o código do cliente: %s\n", KBLU, RESET);
	scanf("%s", &code);
	//codigo dos 3 produtos em que mais gastou

}
*/
