#include "../include/catalogo_clientes.h"

#include "../include/arrayd.h"


struct clientes{
	Array tabela_clientes[26];
};

// Função que lê as primeiras letras de uma string e as transforma num numero
int letra(char string[], int nLetras){
	return string[0] - 65;
}

// Função que transforma uma substring num numero
int num(char string[], int index){
	return atoi(string+index);
}

//função que valida um id de um cliente
int validaCliente(char * id){
	int r = 0;
			if(isupper(id[0]))	
				if(('1'<=id[1]) && (id[1]<='5'))
					for(int n = 2; n < 4; n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}
	return r;
}

// Função que insere um index, de tipologia Cliente, numa estrutura de dados
void insert_Cliente(Array clientes[26], char id[]){

	int n = num(id,1), l = letra(id,1);
	insert_valor(clientes[l], n);
}

// Função que verifica se um id existe na estrutura
int search_C(Clientes clientes, char id[]){
	
	int n = num(id,1), l = letra(id,1);
	return procura_binaria(clientes->tabela_clientes[l], 0, clientes->tabela_clientes[l]->inUse, n) + 1; // 0 quando nao existe, indice + 1 quando existe
}

// Função que imprime num ficheiro por ordem dos elementos
int fprint_clientes(FILE* fp, int l1, Array clientes){
	char letra = l1 + 65;
	int num = 0;
	for(int i = 0; i < clientes->inUse; i++){
		fprintf(fp, "%c%d\r\n", letra, clientes->valor[i]);
		num++;
	}

	return num;
}

// Faz load de um ficheiro no array RETORNA QUANTO ESCREVEU NO ARRAY (para a função wrfile)
int loadArray_Clientes(Array clientes[26], char* path){
	char linha[7];
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
      	printf("Error! You tried to read an empty file.");   
     	return 0;             
    }

	while( fgets(linha, 6, file) ){
		if(validaCliente(linha)){
			insert_Cliente(clientes, linha);
			i++;
		}
	}

	return i;
}

// Função que escreve as tabelas num ficheiro
int  wrFileC (Array clientes[26], char* path){
	int num = 0;
	FILE* fp = fopen(path, "w+");

	if(fp == NULL){
		printf("Error! Couldn't find file point to write Clientes");
		return 0;
	}

	else
		for(int letra = 0; letra < 26; letra++)
			num += fprint_clientes(fp, letra, clientes[letra]);

	fclose(fp);	

	return num;
}

// Função que inicializa as estruturas, escreve na posição 0 e 1 do array
Clientes init_Clientes(int* num){

	Array clientes[26];
	for (int i = 0; i < 26; i++)
		clientes[i] = malloc(sizeof(Array));

	num[0] = loadArray_Clientes(clientes,"Clientes.txt");
	num[1] = wrFileC(clientes, "Clientes_SortedArrayD.txt");

	Clientes estrutura = malloc(sizeof(Clientes));
	for (int k = 0; k < 26; k++)
		estrutura->tabela_clientes[k] = clientes[k];

	return estrutura;
}
