#define _GNU_SOURCE
#include "valida.h"
#include "load.h"



//Faz load de um ficheiro no array
char** loadArray( char** array, char* path, int max, int (*valida) (char, ...) ){
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

	return array;
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

