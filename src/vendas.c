#include "../include/vendas.h"
#include "../include/arrayd.h"

struct vendas_mes{
	Strings noMes[12];
};

struct vendas_filial{
	Strings filial[3];
};

struct vendas{
	Strings vendas;
};


//função que valida um id de uma venda
int validaVenda(char* linha, Produtos p, Clientes c){
	int r = 0, i = 0;
	char* tokens[7];

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

//Faz load das vendas no array
int loadstruct_Vendas( Strings s, char* path, Produtos p, Clientes c){
	char linha[33], *original = malloc(sizeof(char)*33);
	int i = 0;
	FILE* file = fopen(path , "r");

	if(file == NULL){
		printf("Error! You tried to read an empty file.");
		fclose(file);
		exit(1);
	}

	while( fgets(linha, 32, file) ){
		strcpy(original, linha);

		if(validaVenda(linha, p, c)){
			string_append(s, original);
			i++;
		}
	}
	
	free(original);
	fclose(file);	

	return i;
}

// Função que escreve as vendas num ficheiro
int wrFileV(Strings s, char* path){
	FILE* fp = fopen(path, "w+");
	int i;

	if(fp == NULL){
		printf("Error! Couldn't find file point to write Vendas");
		fclose(fp);
		return 0;
	}
	for(i = 0; i < s->inUse; i++ ){
		fprintf(fp, "%s\n", get_String(s, i));
	}

    fclose(fp);
	return i;
}

// Função que inicializa as estruturas, escreve na posição 4 e 5 do array
Vendas init_Vendas(int* num, Produtos p, Clientes c){
	
	Vendas v = malloc(sizeof(Vendas));
	v->vendas = create_Strings();

	num[4] = loadstruct_Vendas(v->vendas,"../Vendas_1M.txt", p, c);
	num[5] = wrFileV(v->vendas, "../VendasValidas.txt");

	return v;
}
