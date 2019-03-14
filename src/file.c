#define _GNU_SOURCE
#include "../include/valida.h"
#include "../include/file.h"



//Faz load de um ficheiro no array RETORNA QUANTO ESCREVEU NO ARRAY (para a função wrfile)
int loadArray( char** array, char* path, int max, int (*valida) (char, ...) ){
	char * linha = " ";
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
      		printf("Error! You tried to read an empty file.");   
     		exit(1);             
    	}

	while( fgets(linha, max, file) ){
		if(valida){
			array[i] = strdup(linha);
			i++;
		}
	}
	
	fclose(file);	

	return i;
}


//ADICIONAR AO FILE DAS QUERIES MAYBE
int linecount(char* path){
	int lines = 0, ch;
	FILE* fp = fopen(path, "r");
	
	if(fp == NULL){
      		printf("Error!");   
      		exit(1);             
    	}
	
	while(!feof(fp)){
  		ch = fgetc(fp);
  		if(ch == '\n') lines++;
	}
	
	fclose(fp);
	
	return lines;
}

//Função que dado o array com os dados válidos e o tamanho do array, os escreve no ficheiro

int wrFileP (char** array, int n){
	int r = 0;
	int i = 0;
	FILE* fp = fopen("ProdutosValidos.txt", "w+");
	if(fp == NULL){
		printf("Error!");
		r = 1;
	}
	while(i>0 && n > 0){
		i = fprintf(fp,"%s\n", array[i]);
		n--;
	}
	return r;

}

int wrFileC (char** array, int n){
	int r = 0;
	int i = 0;
	FILE* fp = fopen("ClientesValidos.txt", "w+");
	if(fp == NULL){
		printf("Error!");
		r = 1;
	}
	while(i>0 && n > 0){
		i = fprintf(fp,"%s\n", array[i]);
		n--;
	}
	return r;

}

int wrFileV (char** array, int n){
	int r = 0;
	int i = 0;
	FILE* fp = fopen("VendasValidas.txt", "w+");
	if(fp == NULL){
		printf("Error!");
		r = 1;
	}
	while(i>0 && n > 0){
		i = fprintf(fp,"%s\n", array[i]);
		n--;
	}
	return r;

}

