#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_BUFF 255

//função que abre e valida um ficheiro
char* openFileP()
{
	FILE *fptr;
	char* buff = malloc(sizeof(char)*MAX_BUFF); 
	fptr = fopen("/Users/mariapires/Desktop/li3/Produtos.txt", "r");
	while(fgets(buff, MAX_BUFF, fptr))
	{
		
	}

	fclose (fptr);

	return buff;
}

//função que valida os produtos
int validaP(char * buff){
	if(!buff[7])													//Se no buff[7] é o \0 ou seja NULL
		if((buff[0] && buff[1])<=90 && 65<=(buff[0] && buff[1]))   //Se os dois primeiros carateres sao maiusculas 								
			if(49<=buff[2] && buff[2]<=57)							//Se a 3ª posição é entre 1 e 9
				for(int i = 3; i < 7;)
}

int main () {
	openFileP();
	return 0;
}