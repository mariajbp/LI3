#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "valida.h"

// função que lê um ficheiro, valida as linhas e carrega essas linhas num array 
char** loadArray( char** array, char* path, const char id, int max, const char* produtos[], const char* clientes[]){
	char * linha = NULL;
	int i = 0;
	FILE* file;
	switch(id){
		case 'c':
			file = fopen(path , "r");
			while( fgets(linha, max, file) ){
				if(validaCliente(linha, 5)){
					array[i] = strdup(linha);
					i++;
				}
			}
			fclose(file);
			break;
		case 'p':
			file = fopen(path , "r");
			while( fgets(linha, max, file) ){
				if(validaProduto(linha, 6)){
					array[i] = strdup(linha);
					i++;
				}
			}
			fclose(file);
			break;
		case 'v':
			file = fopen(path , "r");
			while( fgets(linha, max, file) ){
				if(validaVenda(linha, produtos, clientes)){
					array[i] = strdup(linha);
					i++;
				}
			}
			fclose(file);
			break;
	}
	return array;
}

char** lArray( char** array, char* path, const char id, int max, int (*valida) (char, ...) ){
	char * linha = NULL;
	int i = 0;
	FILE* file;

	file = fopen(path , "r");
	while( fgets(linha, max, file) ){
		if(valida){
			array[i] = strdup(linha);
			i++;
		}
	}
	fclose(file);	

	return array;
}

//max = função de profilling - fazer fora 
int linecount(char* path)
{
	int lines, ch;
	FILE* fp = fopen(path, "r");
	while(!feof(fp))
	{
  		ch = fgetc(fp);
  		if(ch == '\n') lines++;
	}

	fclose(fp);
	return lines;
}
