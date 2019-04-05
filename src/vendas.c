#include "../include/vendas.h"
#include "../include/arrayd.h"

struct vendas_mes{
	Strings vendas_inMes[12];
};

struct vendas{
	Strings vendas;
};

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
int validaVenda(char* linha, Produtos p, Clientes c){
	int r = 0, i = 0;
	char* tokens[7];
	
	for(i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));

	i = toktok(linha, tokens);
	if(i == 7)													// se tokens tiver 7 posicoes, estas devem ser testadas
		if( search_P(p, tokens[0]) )	
			if( atof(tokens[1]) <= 999.99 && atof(tokens[1]) >= 0.0 )		// atof(str) converte a str para float, pertence a string.h
				if( atoi(tokens[2]) <= 200 && atoi(tokens[2]) >= 1 )		// atoi(str) converte a str para int, pertence a string.h
					if( !strcmp(tokens[3], "N") || !strcmp(tokens[3], "P") )	
						if( search_C(c, tokens[4]) )	
							if( atoi(tokens[5]) <= 12 && atoi(tokens[5]) >= 1 )	
								if( atoi(tokens[6]) <= 3 && atoi(tokens[6]) >= 1 )	 // validar a filial
									r = 1;
	return r;
}

//Faz load de uma venda no array
int loadstruct_Vendas( Strings s, char* path, Produtos p, Clientes c){
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
		if(validaVenda(linha, p, c)){
			string_append(s, linha);
			i++;
		}
	}
	
	fclose(file);	

	return i;
}

// Função que escreve as vendas num ficheiro
int wrFileV (Strings s, char* path){
	int r = 0;
	FILE* fp = fopen(path, "w+");
	int i;

	if(fp == NULL){
		printf("Error! Couldn't find file point to write Vendas");
		return 0;
	}
	for(i = 0; i < s->inUse; i++ )
		fprintf(fp, "%s\n", s->string[i]);

	return r;
}

// Função que inicializa as estruturas, escreve na posição 4 e 5 do array
Vendas init_Vendas(int* num, Produtos p, Clientes c){
	
	Strings s = malloc(sizeof(Strings));

	num[4] = loadstruct_Vendas(s,"../Vendas_1M.txt", p, c);
	num[5] = wrFileV(s, "../VendasVálidas.txt");
	
	Vendas estrutura = malloc(sizeof(Vendas));
	estrutura->vendas = s;

	return estrutura;
}
