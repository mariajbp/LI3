#include "../include/faturacao.h"
#include "../include/vendas.h"

/////////////////////////////////////////////////
//// 				query_2					////
///////////////////////////////////////////////

Strings meteletra(Produtos p, char l1){
	int a = l1 - 65;
	int index = a*26;
	char prod[7];
	Strings tudo = malloc(sizeof(Strings));

	for(int i = index; i < (index+26); i++)
		for(char l2 = 'A'; l2 <= 'Z'; l2++)
			for(int j = 0; j < getUse(p, i); j++){
				sprintf(prod,"%c%c%d",l1,l2,getValor(p,i,j));
				tudo->string[i] = sdup(prod);
			}

	return tudo;
}

/////////////////////////////////////////////////
//// 				query_3					////
///////////////////////////////////////////////

//Devolve o total faturado tanto N como P
double totalFaturado(Strings v){
	double faturado = 0;
	char *tokens[7];
	
	for (int j = 0; j < v->inUse; j++){
		toktok(v->string[j], tokens);
		faturado+=atof(tokens[1])*atof(tokens[2]);
	}
	
	return faturado;
}

//Devolve o total faturado de N e P separados
void totalFaturadoNP(Strings v, double* num){
	double faturado_N = 0, faturado_P = 0;
	char* tokens[7];
	
	for (int j = 0; j < v->inUse; j++){
		toktok(v->string[j], tokens);
		if(!strcmp(tokens[3], "N"))
			faturado_N+=atof(tokens[1])*atof(tokens[2]);
		if(!strcmp(tokens[3], "P"))
			faturado_P+=atof(tokens[1])*atof(tokens[2]);
	}

	num[0] = faturado_N;
	num[1] = faturado_P;
}

//determinar as vendas de um produto numa filial + mes
Strings getVendasProdFM(char* path, char* code, int mes, int f){
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

		if( !(strcmp(code, tokens[0])) )
			if(mes == atoi(tokens[5]) && f == atoi(tokens[6]))
				string_append(s, original);
	}

	fclose(file);

	free(original);

	return s;
}

//Determinda todas as vendas 
Strings getvendas_PinM(char* path, char* code, int mes){
	char* original = malloc(sizeof(char)*31);
	Strings s = create_Strings();
	char linha[31], *tokens[7];

	FILE* file = fopen(path , "r");
	if(file == NULL)
	{
		printf("Error! You tried to read an empty file.");
		fclose(file);
		exit(1);
	}
	while(fgets(linha, 31, file))
	{	
		strcpy(original, linha);
	
		toktok(linha,tokens);
		if( !(strcmp(code, tokens[0])) ){
			if(mes == atoi(tokens[5]))
			{
				string_append(s, original);
				
			}
		}	
	}

	fclose(file);

	free(original);

	return s;
}

/////////////////////////////////////////////////
//// 				query_8					////
///////////////////////////////////////////////

// calcula o total de vendas (num[0]) e o faturado (num[1])
void totalV_F(char* path, int inicio, int fim, double n[2]){

	char linha[32], *tokens[7];
	FILE* file = fopen(path , "r");
	int m = 0, t = 0;
	double f = 0;

	if(file == NULL){
		printf("Error! You tried to read an empty file.");
		fclose(file);
		exit(1);
	}

	while( fgets(linha, 31, file) ){
		toktok(linha,tokens);
		m = atoi(tokens[5]);
		if(m <= fim && m >= inicio){
			f += atof(tokens[1]) * atof(tokens[2]);
			t++;
		}
	}
	
	fclose(file);
	n[0] = t / 2;
	n[1] = f / 2;
}