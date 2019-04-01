#include "../include/vendas.h"
#include <string.h>
#include <assert.h>

struct tree_vendas{
	char produto[6], cliente[5], tipo[1];
	float preco;
	int unidades, filial, mes;

	struct tree_vendas *dir, *esq;
};


char * sdup(const char *s){
	size_t len = strlen (s) + 1;
	void *new = malloc (len);
	if (new == NULL)
		return NULL;
	return (char *) memcpy (new, s, len);
}

//Tokenize, devolve o i e preenche o array tokens
int toktok(char * linha, char** tokens){
	char* tok = NULL;
	tok = strtok(linha, " ");
	int i = 0;

    for(i = 0; tok; i++){
    	if(i < 7)
    		tokens[i] = sdup(tok);
        tok = strtok(NULL," ");
    }
    return i;
}

//função que valida um id de uma venda
int validaVenda(char* linha, Tree produtos[26][26][151], Tree clientes[26][307]){
	int r = 0, i = 0;
	char* tokens[7];
	
	for(i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));

	i = toktok(linha, tokens);
	if(i == 7)													// se tokens tiver 7 posicoes, estas devem ser testadas
		if( search_P(produtos, tokens[0]) )	
			if( atof(tokens[1]) <= 999.99 && atof(tokens[1]) >= 0.0 )		// atof(str) converte a str para float, pertence a string.h
				if( atoi(tokens[2]) <= 200 && atoi(tokens[2]) >= 1 )		// atoi(str) converte a str para int, pertence a string.h
					if( !strcmp(tokens[3], "N") || !strcmp(tokens[3], "P") )	
						if( search_C(clientes, tokens[4]) )	
							if( atoi(tokens[5]) <= 12 && atoi(tokens[5]) >= 1 )	
								if( atoi(tokens[6]) <= 3 && atoi(tokens[6]) >= 1 )	 // validar a filial
									r = 1;
	return r;
}

//
int loadstruct_Vendas( Tree_Vendas vendas, char* path, Tree produtos[26][26][151], Tree clientes[26][307]){
	char linha[32];
	int i = 0;
	char* tokens[7];
	FILE* file = fopen(path , "r");
	
	for(i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));

	toktok(linha,tokens);

	if(file == NULL){
      	printf("Error! You tried to read an empty file.");   
     	exit(1);             
    }

	while( fgets(linha, 31, file) ){
		if(validaVenda(linha, produtos, clientes)){
			//vendas = createVenda(tokens);
			i++;
		}
	}
	
	fclose(file);	

	return i;
}

//
int wrFileV (Tree_Vendas vendas, char* path){
	int r = 0;
	FILE* fp = fopen(path, "w+");
	
	if(fp == NULL){
		printf("Error! Couldn't find file point to write Vendas");
		return 0;
	}

	// print struct vendas

	return r;
}

//
void init_Vendas(Tree_Vendas vendas, int* num, Tree tProdutos[26][26][151], Tree tClientes[26][307]){
	vendas = malloc(sizeof(Tree_Vendas));
	
	num[4] = loadstruct_Vendas(vendas,"../Vendas_1M.txt", tProdutos, tClientes);
	num[5] = wrFileV(vendas, "../VendasVálidas.txt");
}

//dado o array com tokens, constroi uma Venda
Tree_Vendas createVenda(char** tokens){
	Tree_Vendas v = malloc(sizeof(Tree_Vendas));

	strcpy( (v->produto), tokens[0]);
 	v->preco = atof(tokens[1]);
 	v->unidades = atoi(tokens[2]);
 	strcpy( (v->tipo), tokens[3]);
 	strcpy( (v->cliente), tokens[4]);
 	v->mes = atoi(tokens[5]);
	v->filial = atoi(tokens[6]);

	v->esq = NULL;
	v->dir = NULL;

 	return v;
}

char* getPcode(Tree_Vendas v){
 	return v->produto;
}

 
double getPrice(Tree_Vendas v){
 	return v->preco;
}

 
int getUnits(Tree_Vendas v){
 	return v->unidades;
}

 
char* getNP(Tree_Vendas v){
	return v->tipo;
}

 
char* getCLcode(Tree_Vendas v){
 	return v->cliente;
}

 
int getMonth(Tree_Vendas v){

 	return v->mes;
}

int getFilial(Tree_Vendas v){

 	return v->filial;
}

void destroyVenda(Tree_Vendas v){
  free(v);
}


