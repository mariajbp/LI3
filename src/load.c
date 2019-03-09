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
