#include "../include/catalogo_produtos.h"
#include "../include/arrayd.h"

struct produtos{
	Array tabela_produtos[676];
};

int getUse(Produtos p, int i){
	return p->tabela_produtos[i]->inUse;
}

int getValor(Produtos p, int i, int j){
	return p->tabela_produtos[i]->valor[j];
}

// Função que lê as primeiras letras de uma string e as transforma num numero
int letra_produto(char string[]){
	return ((string[0] - 65) * 26) + (string[1] - 65);
}

// Função que transforma uma substring num numero
int num_produto(char string[], int index){
	return atoi(string+index);
}

//função que valida um id de um produto
int validaProduto(char * id){
	int r = 0;
	if(isupper(id[0]) && isupper(id[1]))							
		if(('1'<=id[2]) && (id[2]<='9'))
			for(int n = 3; n < 5; n++){
				if(isdigit(id[n])) r = 1;
				else return 0;
			}
	return r;
}

// Função que insere um index, de tipologia Cliente, numa estrutura de dados
void insert_Produto(Array produtos[676], char id[]){

	int n = num_produto(id,2), l = letra_produto(id);
	insert_valor(produtos[l], n);
}

// Função que verifica se um id existe na estrutura
int search_P(Produtos produtos, char id[]){
	
	int n = num_produto(id,2), l = letra_produto(id);
	return (procura_binaria(produtos->tabela_produtos[l], 0, produtos->tabela_produtos[l]->inUse, n) + 1); // 0 quando nao existe, indice + 1 quando existe
}

// Função que imprime num ficheiro por ordem dos elementos
int fprint_produtos(FILE* fp, int i, Array produtos){
	char l1 = ((i - (i%26))/26) + 65, l2 = (i % 26) + 65 ;

	int num = 0;
	for(int i = 0; i < produtos->inUse; i++){
		fprintf(fp, "%c%c%d\r\n", l1, l2, produtos->valor[i]);
		num++;
	}

	return num;
}

// Faz load de um ficheiro no array RETORNA QUANTO ESCREVEU NO ARRAY (para a função wrfile)
int loadArray_produtos(Array produtos[676], char* path){
	char linha[7];
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
	  	printf("Error! You tried to read an empty file.");   
		return 0;
	}

	while( fgets(linha, 7, file) ){
		if(validaProduto(linha)){
			insert_Produto(produtos, linha);
			i++;
		}
	}

	return i;
}

// Função que escreve as tabelas num ficheiro
int  wrFileP (Array produtos[676], char* path){
	int num = 0;
	FILE* fp = fopen(path, "w+");

	if(fp == NULL){
		printf("Error! Couldn't find file point to write produtos");
		return 0;
	}

	else
		for(int letra = 0; letra < 676; letra++)
			num += fprint_produtos(fp, letra, produtos[letra]);

	fclose(fp);	

	return num;
}

// Função que inicializa as estruturas, escreve na posição 2 e 3 do array
Produtos init_Produtos(int num[6]){

	Produtos p = malloc(sizeof(Produtos));
	for (int i = 0; i < 676; i++)
		p->tabela_produtos[i] = malloc(sizeof(Array));
	for (int j = 0; j < 676; j++)
		p->tabela_produtos[j] = create_Array();

	num[2] = loadArray_produtos(p->tabela_produtos,"../Produtos.txt");
	num[3] = wrFileP(p->tabela_produtos, "../ProdutosValidos.txt");

	return p;
}
