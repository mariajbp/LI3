#include "../include/faturacao.h"
#include "../include/arrayd.h"
#include "../include/vendas.h"


Vendas_inMes loadStructMes(char* path){
	char linha[32];
	int i = 0;
	int mes = 0;
	Vendas_inMes s;
	char* tokens[7];
	FILE* file = fopen(path , "r");
	
	for(i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));

	if(file == NULL){
      	printf("Error! You tried to read an empty file.");
      	fclose(file);	   
     	exit(1);             
    }

	while(fgets(linha, 31, file) )
	{
		toktok(linha,tokens);
		mes = atoi(tokens[5]);
		string_append(s->noMes[mes],linha);
	}
	
	fclose(file);	

	return i;
}

int search_prodV(char* pcode, char* venda)
{
	char* pcode_venda = strtok(venda, " ");
	return !strcmp(pcode,pcode_venda);

}

Strings searchProdMes(char* code, Vendas_inMes vm, int mes)
{
	Strings produtos = malloc(sizeof(Strings));

	for (int i = 0; i < vm->noMes[mes]->inUse; ++i)
	{
		if(search_prodV(code,vm->noMes[mes]->string[i]))
			string_append(produtos, vm->noMes[mes]->string[i]);
	}

	return produtos;
}

int totalFaturado(Strings v)
{
	int faturado = 0;
	char* tokens[7];
	for(int i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));
	
	for (int j = 0; j < v->inUse; j++)
	{
		toktok(tokens,v->string[j]);
		faturado+=tokens[1]*tokens[2];
	}

	return faturado;
}

int* totalFaturadoNP(Strings v, int num[2])
{
	int faturado_N = 0, faturado_P = 0,;
	char* tokens[7];
	for(int i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));
	
	for (int j = 0; j < v->inUse; j++)
	{
		toktok(tokens,v->string[j]);
		if(!strcmp(tokens[3], "N"))
			faturado_N+=tokens[1]*tokens[2];
		if(!strcmp(tokens[3], "P"))
			faturado_P+=tokens[1]*tokens[2];
	}

	num[0] = faturado_N;
	num[1] = faturado_P;

	return num;
}

