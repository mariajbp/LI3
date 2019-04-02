#include "../include/catalogoProdutos.h"


//função que valida um id de um produto
int validaProduto(char * id){
	int r = 0;
			if(isupper(id[0]) && isupper(id[1]))						//Se os dois primeiros carateres sao maiusculas 								
				if(('1'<=id[2]) && (id[2]<='9'))						//Se a 3ª posição é entre 1 e 9
					for(int n = 3; n < 5; n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}
	return r;
}

// Função que dado uma string (valor), devolve uma posição (index, hash key)
void hF_Produtos(int index[], char value[]){
	int s = 0, c = 0;
	for(int i = 2; i < strlen(value); i++){
		s = value[i]; c+=s; c*=s;
	}

	c = abs(c % 151);

	index[0] = value[0] - 65;
	index[1] = value[1] - 65;
	//printf("\tHASH__%c%c%d\n", value[0], value[1], c );
	index[2] = c;
}

// Função que insere um index, de tipologia Produto, numa estrutura de dados
void insert_Produto(Tree produtos[26][26][151], char id[]){
	int index[3]; index[0] = 0, index[1] = 0, index[2] = 0;
	int nID = num(id,2);
	hF_Produtos(index, id);

	insert_tree(produtos[index[0]][index[1]][index[2]] , nID);
}

// Função que, aplicando a Hash Funtion, verifica se uma posição da Treetable existe
int search_P(Tree produtos[26][26][151], char id[]){
	int r = 0, nID = num(id,2);
	int index[3]; index[0] = 0, index[1] = 0, index[2] = 0;
	hF_Produtos(index,id);

	r = search_tree(produtos[index[0]][index[1]][index[2]], nID);

	return r;
}

// Função que imprime uma arvore por ordem dos elementos
int fprint_produtos(FILE* fp, int l1, int l2, Tree arvore){
	char pL = l1+'A', sL = l2+'A'; 
	int num = 0;

	if(arvore){
		num += fprint_produtos(fp,l1,l2,esq(arvore));
		if(valor(arvore) > 1){
			fprintf(fp,"%c%c%d\r\n", pL, sL,valor(arvore));
			num++;
		}
		num += fprint_produtos(fp,l1,l2,dir(arvore));
	}

	return num; // retorna o num de elementos que printou
}

int loadHash_Produtos(Tree	produtos[26][26][151], char* path){
	char linha[7];
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
    	printf("Error! You tried to read an empty file.");   
    	return 0;             
    }
	while( fgets(linha, 7, file) ){
		if(validaProduto(linha)){
			insert_Produto(produtos,linha);
			i++;
		}
	}

	return i;
}

//Função que escreve um cubo de Trees num ficheiro
int wrFileP (Tree produtos[26][26][151], char* path){
	int r = 0;
	FILE* fp = fopen(path, "w+");
	
	if(fp == NULL){
		printf("Error! Couldn't find file point to write Produtos");
		return 0;
	}

	for(int l1 = 0; l1 < 26; l1++)
		for(int l2 = 0; l2 < 26; l2++)
			for(int h = 0; h < 151; h++)
				r += fprint_produtos(fp,l1,l2,produtos[l1][l2][h]);

	fclose(fp);

	return r;
}


int create_produtos(Tree produtos[26][26][151], char* path){
	char linha[6];
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
    	printf("Error! You tried to read an empty file.");   
    	return 0;             
    }

	while( fgets(linha, 6, file) ){
		insert_Produto(produtos,linha);
		i++;
	}

	return i;
}


void destroyCP(Tree cat_Produtos[26][26][151]){
	free(cat_Produtos);
}

//Função que inicializa as estruturas, escreve na posição 2 e 3 do array
void init_Produtos(int* num, Tree produtos[26][26][151]){

	for (int i = 0; i < 26; i++)
		for (int j = 0; j < 26; j++)
			for(int k = 0; k < 151; k++)
				produtos[i][j][k] = create_nodo(1);
	
	num[2] = loadHash_Produtos(produtos,"../Produtos.txt");
	num[3] = wrFileP(produtos, "../ProdutosVálidos.txt");
}
