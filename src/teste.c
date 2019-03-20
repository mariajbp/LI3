#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>

int maxLinha(char* path){
	int max = -1;
	int r = 0;
	char buf[50];
	FILE *fp = fopen(path, "r");
		if(fp == NULL){
			printf("Error! Couldn't open the file\n");
			return(-1);}
		while((fgets(buf, 50, fp)) != NULL){
			r = strlen(buf)-1;
		if(max < r) max = r;
	}
	return max;

}

int wrFileC (char** array, int n){
	int r = 0;
	int i = 0;
	FILE* fp = fopen("ClientesValidos.txt", "w+");
	if(fp == NULL){
		printf("Error!");
		r = -1;
	}
	while(i>0 && n > 0){
		i = fprintf(fp,"%s\n", array[i]);
		n--;
	}
	return r;

}

//função que valida um id de um cliente
int validaCliente(char * id, int i){
	int r = 0;
		if(!id[i])														//segue se o id[i] é \0 ou NULL
			if(isupper(id[0]))											//Se a primeiros carateres sao maiusculas 		
				if(('1'<=id[1]) && (id[1]<='5'))						//Se a 2ª posição é entre 1 e 5
					for(int n = 2; n < (i-1); n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}
	return r;
}

//Faz load de um ficheiro no array RETORNA QUANTO ESCREVEU NO ARRAY (para a função wrfile)
int loadArray( char** array, char* path, int max, int (*valida) (char*, int) ){
	char* linha = " ";
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
      		printf("Error! You tried to read an empty file.");   
     		return 1;             
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


int makeCl (char * path){
	char *prod [200000];
	int l = 0;
	int v = 0;

	printf("A validar Clientes...\n");
	//Validar clientes e escrever em ficheiro
	int max = maxLinha("../Clientes.txt");
	int (*vCliente)(char*,int) = validaCliente;
	char* linha; int C = 6;
	l = loadArray(prod, "../Clientes.txt", max, vCliente(linha,C));
	v = wrFileC(prod, l);
		if(v == -1) {
			printf("Error! File not found.\n");
		}
		else printf("Done\n");
	return v;
}

int main(int argc, char const *argv[])
{	int v = 0;
	v = makeCl("../Clientes.txt");
	printf("Done v = %d\n" ,v);
	return 0;
}