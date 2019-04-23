#include "../include/filial.h"

/////////////////////////////////////////////////
//// 				query_4					////
///////////////////////////////////////////////

Strings comprados_Filial(char* path, int f){
	char linha[32];
	char *tokens[7];
	Strings s = create_Strings();

	FILE* file = fopen(path , "r");
	if(file == NULL){
		printf("Error! You tried to read an empty file.");
		fclose(file);
		exit(1);
	}

	while(fgets(linha, 31, file)){
		toktok(linha,tokens);
		if(f == atoi(tokens[6]))
			string_append(s,tokens[0]);
	}

	fclose(file);

	return s;
}

Strings naoComprado(char* path, Strings comprados){
	char linha[7];
	Strings ncomprado = create_Strings();

	FILE* file = fopen(path , "r");
	if(file == NULL){
		printf("Error! You tried to read an empty file.");
		fclose(file);
		exit(1);
	}

	while(fgets(linha, 7, file)){
		for(int i = 0; i < comprados->inUse; i++)
			if(!strcmp(linha,comprados->string[i]))
				string_append(ncomprado,linha);
	}

	fclose(file);

	return ncomprado;
}

/////////////////////////////////////////////////
//// 				query_5					////
///////////////////////////////////////////////

// Função que realiza procura por filial numa Strings
int procura_cliente(Strings s[3], char* cl){
	int r = 0;
	
	for (int i = 0; i < s[0]->inUse; i++)
			if(!strcmp(s[0]->string[i],cl))
				r = 1;

	if(r){
		for (int i = 0; i < s[1]->inUse; i++)
			if(!strcmp(s[1]->string[i],cl))
				r = 2;
		if(r == 2){
			for (int i = 0; i < s[2]->inUse; i++)
				if(!strcmp(s[2]->string[i],cl))
					r = 3;
		}
	}

	return r;
}

// Função que realiza insercao por filial numa Strings
void insert_stringF(Strings s[3], char* c, int f){

	if(f == 1){
		isFull_S(s[0]);
		s[0]->string[s[0]->inUse++] = sdup(c);
	}

	if(f == 2){
		isFull_S(s[1]);
		s[1]->string[s[1]->inUse++] = sdup(c);
	}

	if(f == 3){
		isFull_S(s[2]);
		s[2]->string[s[2]->inUse++] = sdup(c);
	}
}

int le_Clientes(char* path, Strings s){
	char linha[6];
	FILE* fp = fopen(path, "r");

	int i = 0;

	if(fp == NULL){
		printf("Error! Tried to read an empty file.\n");
		fclose(fp);
		return 0;
	}

	while(fgets(linha, 6, fp) ){
		string_append(s, linha);
		i++;
	}
	
	fclose(fp);

	return i;
}

//Lê os clientes válidos para um array
int le_Vendas(char* path, Strings s[3]){
	char linha[32], *tokens[7];
	FILE* fp = fopen(path, "r");

	int i = 0, f = 4;

	if(fp == NULL){
		printf("Error! Tried to read an empty file.\n");
		fclose(fp);
		return 0;
	}
	
	while(fgets(linha, 32, fp) ){
		toktok(linha,tokens);
		f = atoi(tokens[6]);
		insert_stringF(s,tokens[4],f);
		i++;
	}

	fclose(fp);
	
	return i;
}

void filter_CF(Strings f[3], Strings clientes, Strings f1){
	for (int i = 0; i < clientes->inUse; i++){
		if(procura_cliente(f, clientes->string[i]) == 3){
			string_append(f1,clientes->string[i]);
		}
	}
}

/////////////////////////////////////////////////
//// 				query_9					////
///////////////////////////////////////////////

//determinar as vendas de um produto numa filial
Strings getVendasProdFilial(char* path, char* code, int f){
	char* original = malloc(sizeof(char)*31);
	char linha[32], *tokens[7];
	Strings s = create_Strings();
	FILE* file = fopen(path , "r");

	if(file == NULL){
		printf("Error! You tried to read an empty file.");
		fclose(file);
		exit(1);
	}

	while(fgets(linha, 31, file)){
		strcpy(original, linha);

		toktok(linha,tokens);
		if(!strcmp(code, tokens[0]))
			if(f == atoi(tokens[6]))
				string_append(s,original);
	}
	
	fclose(file);

	free(original);
	
	return s;
}

/////////////////////////////////////////////////
//// 				query_10				////
///////////////////////////////////////////////

//get vendas de 1 cliente num determinado mes
Strings_Unidades CinM_comprou(char* path, char* code, int mes){
	char linha[32], *tokens[7];
	char *prod = malloc(sizeof(char*)*10);
	int m = 0, u = 0;
	Strings_Unidades s = create_StringsU();
	
	FILE* file = fopen(path , "r");

	if(file == NULL){
		printf("Error! You tried to read an empty file.");
		fclose(file);
		exit(1);
	}

	while(fgets(linha, 31, file)){
		toktok(linha,tokens);
		m = atoi(tokens[5]);
		if(!strcmp(code, tokens[4]) && m == mes){
			u = atoi(tokens[2]);
			sprintf(prod,"%s", tokens[0]);
			insert_string(s,prod,u);
		}
	}

	fclose(file);

	return s;
}

//self explain
void cria_listaProdutos(char* path, char* ccode, int mes){
	
	clock_t start, end;
	double cpu_time_used;
	start = clock();

	Strings_Unidades s = CinM_comprou(path,ccode,mes);

	for(int i = 0; i < s->inUse; i++)
		printf("\t%s", s->string[i]);

	end = clock();
	cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

	printf("demorou %f segundos\n", cpu_time_used );
}