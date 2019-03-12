#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "valida.h"

<<<<<<< HEAD
=======
#define _GNU_SOURCE
#define _SVID_SOURCE //-->nao dar warning na compilaçao
>>>>>>> 0782ca14c2cd87178c1742a7256aefd45f84a46a

char** lArray( char* path, int max, int (*valida) (char, ...) ){
	char** array = 
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

