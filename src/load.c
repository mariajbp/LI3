#define _GNU_SOURCE
#include "valida.h"
#include "load.h"



//Faz load de um ficheiro no array
/*char** lArray( char* path, int max, int (*valida) (char, ...) ){
	char** array = 
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
}*/

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

