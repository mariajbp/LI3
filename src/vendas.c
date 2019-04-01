#include "../include/vendas.h"
#include <assert.h>


struct venda{
  char pcode[7];
  double price;
  int units;
  char* np;
  char clcode[6];
  int month;
  int filial;
 };

//Tokenize, devolve o i e preenche o array tokens
int toktok(char * linha, char** tokens){
	char* tok = NULL;
	tok = strtok(linha, " ");
	int i = 1;

    while(tok){															// verificar a quantidade de sub strings na linha
    	if(i <= 7)
    		tokens[i] = strdup(tok);
        tok = strtok(NULL," ");
        i++;
    } 
    return i;
}

//função que valida um id de uma venda
int validaVenda(char* linha, Tree produtos[26][26][151], Tree clientes[26][307]){
	int r = 0, i = 0;
	char** tokens = (char**)malloc(7*sizeof(char*));
			printf("\tEntrei na validaVenda\n");
	i = toktok(linha, tokens);
			printf("Começar a validar\n");
	assert(i == 8);
	if(i == 8){														// se tokens tiver 7 posicoes, estas devem ser testadas
		if( search_P(produtos, tokens[0]) ){	
			if( atof(tokens[1]) <= 999.99 && atof(tokens[1]) >= 0.0 ){			// atof(str) converte a str para float, pertence a string.h
				if( atoi(tokens[2]) <= 200 && atoi(tokens[2]) >= 1 ){			// atoi(str) converte a str para int, pertence a string.h
					if( strcmp(tokens[3], "N") || strcmp(tokens[3], "P") ){	
						if( search_C(clientes, tokens[4]) ){	
							if( atoi(tokens[5]) <= 12 && atoi(tokens[5]) >= 1 ){	
								if( atoi(tokens[6]) <= 3 && atoi(tokens[6]) >= 1 ){	 // validar a filial
									r = 1;
								}
							}
						}
					}
				}
			}
		}
	}
	return r;
}

//
int loadstruct_Vendas( Venda* estrutura, char* path, Tree produtos[26][26][151], Tree clientes[26][307]){
	char linha[32];
	int i = 0;
	//char** tokens = (char**)malloc(7*sizeof(char*));
	//toktok(linha,tokens);
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
      	printf("Error! You tried to read an empty file.");   
     	exit(1);             
    }

	while( fgets(linha, 32, file) ){
		if(validaVenda(linha, produtos, clientes)){printf("entrou\n");
			//createVenda(tokens);
			i++;
		}
	}
	
	fclose(file);	

	return i;
}

//
int wrFileV (Venda* table, char* path){
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
void init_Vendas(int* num, Tree tProdutos[26][26][151], Tree tClientes[26][307]){
	Venda* sVendas = (Venda*) malloc(sizeof(Venda));

	num[4] = loadstruct_Vendas(sVendas,"../Vendas_1M.txt", tProdutos, tClientes);
	num[5] = wrFileV(sVendas, "../VendasVálidas.txt");
}

//dado o array com tokens, constroi uma Venda
Venda createVenda(char** tokens){
 	Venda v = (Venda) malloc(sizeof (Venda) );
 	strcpy( (v->pcode), tokens[0]);
 	v->price = atof(tokens[1]);
 	v->units = atoi(tokens[2]);
 	strcpy( (v->np), tokens[3]);
 	strcpy( (v->clcode), tokens[4]);
 	v->month = atoi(tokens[5]);
 	v->filial = atoi(tokens[6]);
 	return v;
}

 

char* getPcode(Venda v)
 {
 	return v->pcode;
}

 
double getPrice(Venda v)
 {
 	return v->price;
}

 
int getUnits(Venda v)
 {
 	return v->units;
}

 
char* getNP(Venda v)
 {
	return v->np;
}

 
char* getCLcode(Venda v)
{

 	return v->clcode;
}

 
int getMonth(Venda v)
{

 	return v->month;

}

int getFilial(Venda v)
{

 	return v->filial;
}

void destroyVenda(Venda v)
{
  free(v);
}












