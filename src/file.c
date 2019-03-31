#define _GNU_SOURCE
#include "../include/valida.h"
#include "../include/file.h"
#include "../include/hash.h"
#include "../include/vendas.h"

//Faz load de um ficheiro no array RETORNA QUANTO ESCREVEU NO ARRAY (para a função wrfile)
int loadHash_Clientes(Tree clientes[27][307], char* path, int max){
	char linha[7];
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
      	printf("Error! You tried to read an empty file.");   
     	exit(1);             
    }
	while( fgets(linha, 7, file) ){
		//printf("%s\n",linha );
		if(validaCliente(linha)){
			insert_Cliente(clientes,linha);
			i++;
		}
	}
	
	fclose(file);	

	return i;
}

int loadHash_Produtos(Tree	produtos[27][27][151], char* path, int max){
	char linha[6];
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
    	printf("Error! You tried to read an empty file.");   
    	exit(1);             
    }
	while( fgets(linha, 6, file) ){
		//printf("%s\n",linha );
		if(validaProduto(linha)){
			insert_Produto(produtos,linha);
			i++;
		}
	}
	
	fclose(file);	

	return i;
}

int loadstruct_Vendas( Venda* estrutura, char* path, int max, Tree produtos[27][27][151], Tree clientes[27][307]){
	char linha[32];
	int i = 0;
	char** tokens = (char**)malloc(7*sizeof(char*));
	toktok(linha,tokens);
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
      	printf("Error! You tried to read an empty file.");   
     	exit(1);             
    }

	while( fgets(linha, 32, file) ){
		if(validaVenda(linha, produtos, clientes)){
			createVenda(tokens);
			i++;
		}
	}
	
	fclose(file);	

	return i;
}

//ADICIONAR AO FILE DAS QUERIES MAYBE
int contaLinhas(char* path){
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

//Função que dado o array com os dados válidos e o tamanho do array, os escreve no ficheiro
int  wrFileC (Tree clientes[27][307], char* path){
	int r = 0, i = 0;
	FILE* fp = fopen(path, "w+");
	
	if(fp == NULL){
		printf("Error! Couldn't find file point to write Clientes");
		return 0;
	}
	
	for(int letra = 0; letra < 27; letra++){
		for(int h = 0; h < 307; h++){
			if(clientes[letra][h]){
				fprint_clientes(fp,letra,clientes[letra][h]);
				i+=r; r++;
			}
		}
	}

	return r;
}

int wrFileP (Tree produtos[27][27][151], char* path){
	int r = 0, i = 0;
	FILE* fp = fopen(path, "w+");
	
	if(fp == NULL){
		printf("Error! Couldn't find file point to write Produtos");
		return 0;
	}

	for(int l1 = 0; l1 < 27; l1++){
		for(int l2 = 0; l2 < 27; l2++){
			for(int h = 0; h < 151; h++){
				if(produtos[l1][l2][h]){
				fprint_produtos(fp,l1,l2,produtos[l1][l2][h]);
				i+=r; r++;
				}
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

// array num tem ints que as funcoes devolvem
void inicializar(int* num){
	int max = 0;

	Tree tClientes[27][307];
	for (int i = 0; i < 27; i++)
		for (int j = 0; j < 307; j++)
			tClientes[i][j] = malloc(sizeof(Tree));

	Tree tProdutos[27][27][151];
	for (int i = 0; i < 27; i++)
		for (int j = 0; j < 27; j++)
			for(int k = 0; k < 151; k++)
				tProdutos[i][j][k] = malloc(sizeof(Tree));

	num[0] = loadHash_Clientes(tClientes,"../Clientes.txt", max);
	num[1] = wrFileC(tClientes, "../ClientesVálidos.txt");

	num[2] = num[1] = loadHash_Produtos(tProdutos,"../Produtos.txt", max);
	num[3] = wrFileP(tProdutos, "../ProdutosVálidos.txt");

	/*Venda* sVendas = (Venda*) malloc(sizeof(Venda));
	printf("ja nao tou a alocar espaco\n");

	num[4] = loadstruct_Vendas(sVendas,"../Vendas_1M.txt", max, tProdutos, tClientes);
	num[5] = wrFileV(sVendas, "../VendasVálidas.txt");*/

}