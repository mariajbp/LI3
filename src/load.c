#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "valida.h"


char** lArray( char** array, char* path, int max, int (*valida) (char, ...) ){
	char * linha = NULL;
	int i = 0;
	FILE* file;

	file = fopen(path , "r");
	if(file == NULL)
    {
      printf("Error!");   
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

//max = função de profilling - fazer fora 

int proffiling()
{
	
}


//ADICIONAR AO FILE DAS QUERIES MAYBE
int linecount(char* path)
{
	int lines, ch;
	FILE* fp = fopen(path, "r");
	if(fp == NULL)
    {
      printf("Error!");   
      exit(1);             
    }
	while(!feof(fp))
	{
  		ch = fgetc(fp);
  		if(ch == '\n') lines++;
	}

	fclose(fp);
	return lines;
}

