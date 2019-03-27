#define _GNU_SOURCE
#include "../include/valida.h"
#include "../include/file.h"
#include "../include/hash.h"
#include "../include/vendas.h"

//Faz load de um ficheiro no array RETORNA QUANTO ESCREVEU NO ARRAY (para a função wrfile)
int loadHash_Clientes(hash** table, char* path, int max)
{
	char* linha = " ";
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
      	printf("Error! You tried to read an empty file.");   
     	exit(1);             
    }

	while( fgets(linha, max, file) ){
		if(validaCliente(linha,5)){
			insert_Cliente(table,linha);
			i++;
		}
	}
	
	fclose(file);	

	return i;
}

int loadHash_Produtos( hash*** table, char* path, int max)
{
	char* linha = " ";
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
    	printf("Error! You tried to read an empty file.");   
    	exit(1);             
    }

	while( fgets(linha, max, file) ){
		if(validaProduto(linha,6)){
			insert_Produto(table,linha);
			i++;
		}
	}
	
	fclose(file);	

	return i;
}

int loadstruct_Vendas( Venda* estrutura, char* path, int max, hash*** produtos, hash** clientes)
{
	char* linha = " ";
	int i = 0;
	char** tokens = (char**)malloc(7*sizeof(char*));
	toktok(linha,tokens);
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
      	printf("Error! You tried to read an empty file.");   
     	exit(1);             
    }

	while( fgets(linha, max, file) ){
		if(validaVenda(linha, produtos, clientes)){
			createVenda(tokens);
			i++;
		}
	}
	
	fclose(file);	

	return i;
}

//ADICIONAR AO FILE DAS QUERIES MAYBE
int contaLinhas(char* path)
{
	int lines = 0, ch;
	FILE* fp = fopen(path, "r");
	
	if(fp == NULL){
      	printf("Error!");   
      	exit(0);             
    }
	
	while(!feof(fp)){
  		ch = fgetc(fp);
  		if(ch == '\n') lines++;
	}
	
	fclose(fp);
	
	return lines;
}

// calcula o comprimento da maior linha de um ficheiro
int maiorLinha(char* path){
	int max = -1;
	FILE *fp = fopen(path, "r");
	
	if(fp == NULL){
		printf("Error! Couldn't open the file\n");
		return(0);
	}
	
	while(fgetc(fp)){
		for(int temp = 0; fgetc(fp) != '\n'; temp++)
			if(max < temp) max = temp;
	}
	
	return max;
}

//Função que dado o array com os dados válidos e o tamanho do array, os escreve no ficheiro
int  wrFileC (hash** table, char* path){
	int r = 0;
	FILE* fp = fopen(path, "w+");
	
	if(fp == NULL){
		printf("Error! Couldn't find file point to write Clientes");
		return 0;
	}
	
	for(int letra = 0; letra < 27; letra++){
		for(int h = 0; h < 307; h++){
			if(table[letra][h]){
				fprintf(fp, "%s%d\n", letra+65, (table[letra][h])->head);
				r++;
			}
		}
	}

	return r;
}

int wrFileP (hash*** table, char* path){
	int r = 0;
	FILE* fp = fopen(path, "w+");
	
	if(fp == NULL){
		printf("Error! Couldn't find file point to write Produtos");
		return 0;
	}

	for(int l1 = 0; l1 < 27; l1++){
		for(int l2 = 0; l2 < 27; l2++){
			for(int h = 0; h < 151; h++){
				if(table[l1][l2][h]){
				fprintf(fp, "%s%s%d\n", l1+65, l2+65, table[l1][l2][h]->head);
				r++;
				} // formato l1.num.\n
			}
		}
	}

	return r;
}

int wrFileV (Venda* table, char* path){
	int r = 0;
	FILE* fp = fopen(path, "w+");
	
	if(fp == NULL){
		printf("Error! Couldn't find file point to write Vendas");
		return 0;
	}

	// print struct vendas

	return r;
}

