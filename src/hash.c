#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct tree{
	int head;
	struct tree *esq, *dir;
}*hash;

// Função que insere um elemento numa arvore binaria
hash insere_tree(hash arvore, int id){
	if(arvore == NULL){
		arvore = malloc(sizeof(struct tree));
		arvore->head = id;
		arvore->esq = arvore->dir = NULL;
	}
	else{
		if(id < arvore->head) arvore->esq = insere_tree(arvore->esq, id);
		else arvore->dir = insere_tree(arvore->dir, id);
	}
	
	return arvore;
}

// Função que procura um elemento numa arvore binaria
int search_tree(hash arvore, int id){
	int r;
	if(arvore == NULL) r = 0;
	else{
		if(id == arvore->head) r = 1;
		else{
			if(id < arvore->head) r = search_tree(arvore->esq, id);
			else r = search_tree(arvore->dir, id);
		}
	}

	return r;
}

//
hash valorMinimo(hash h){
	hash r = h;
	while(r->esq) r = r->esq;

	return r;
}

// Função que apaga um elemento numa arvore binaria
hash delete_tree(hash arvore, int id){ 
    if (arvore == NULL) return arvore;

    if (id < arvore->head) 
    	arvore->esq = delete_tree(arvore->esq, id); 
    else
    	if (id > arvore->head)
        	arvore->dir = delete_tree(arvore->dir, id); 
    	else { 
        	if (arvore->esq == NULL){ 
            	hash temp = arvore->dir; 
            	free(arvore); 
            	return temp; 
			} 
        	else if (arvore->dir == NULL){ 
            	hash temp = arvore->esq; 
            	free(arvore); 
            	return temp; 
        }

        hash temp = valorMinimo(arvore->dir); 
        arvore->head = temp->head; 
        arvore->dir = delete_tree(arvore->dir, temp->head); 
    }

    return arvore; 
} 

//
int num(char string[], int index){
	int r = 0, power = 1;
	for(int i = strlen(string); i!=index; i--){
		r+= string[i] * power;
		power = power*10;
	}

	return r;
}

// Função que dado uma string (valor), devolve uma posição (index, hash key)
void hF_Clientes(int index[], char value[]){
	int s = 0, c = 0;
	for(int i = 1; i < strlen(value); i++){
		s = value[i]; c+=s; c*=s;
	}

	index[0] = value[0] - 65;
	index[1] = c % 307;
}

// Função que dado uma string (valor), devolve uma posição (index, hash key)
void hF_Produtos(int index[], char value[]){
	int s = 0, c = 0;
	for(int i = 2; i < strlen(value); i++){
		s = value[i]; c+=s; c*=s;
	}

	index[0] = value[0] - 65;
	index[1] = value[0] - 65;	
	index[2] = c % 151;
}

// Função que elimina um index de uma hashtable
void delete_Cliente(hash* table[], char id[]){
	int index[2]; index[0] = 0; index[1] = 0;
	hF_Clientes(index,id);
	int nID = num(id,1);

	delete_tree(table[index[0]][index[1]], nID);
}

void delete_Produtos(hash** table[], char id[]){
	int index[3]; index[0] = 0, index[1] = 0, index[2] = 0;
	hF_Produtos(index,id);
	int nID = num(id,2);

	delete_tree(table[index[0]][index[1]][index[2]], nID);
}

// Função que insere uma string numa hash table
void insert_Cliente(hash* table[], char id[]){
	int index[2]; index[0] = 0, index[1] = 0;
	int nID = num(id,1);
	hF_Clientes(index, id);

	insere_tree(table[index[0]][index[1]] , nID);
}

// Função que insere uma string numa hash table
void insert_Produtos(hash** table[], char id[]){
	int index[3]; index[0] = 0, index[1] = 0, index[2] = 0;
	int nID = num(id,2);
	hF_Produtos(index, id);

	insere_tree(table[index[0]][index[1]][index[2]] , nID);
}

// Função que, aplicando a hash funtion, verifica se uma posição da hashtable existe
int search_C(char id[], hash* table[]){
	int r = 0, i = id[0], j = id[1];
	int nID = num(id,1);
	r = search_tree(table[i][j], nID);
	
	return r;
}

// Função que, aplicando a hash funtion, verifica se uma posição da hashtable existe
int search_P(char id[], hash** table[]){
	int r = 0, i = id[0], j = id[1], z = id[2];
	int nID = num(id,2);
	r = search_tree(table[i][j][z], nID);

	return r;
}

//
void print_hC(char** table){
	for(int letra = 0; letra <= 27; letra++){
		for(int posHash = 0; posHash <= 307; posHash++){
			printf("_%d.cl.%d_%d\n", letra, posHash, table[letra][posHash]);
		} printf("\n\n\n");
	} 
}

//
void print_hP(char*** table){
	for(int letra = 0; letra <= 27; letra++){
		for(int letra2 = 0; letra2 < 27; letra2++){
			for(int posHash = 0; posHash <= 151; posHash++){
				printf("_%d.%d.%d.clc_%d\t", letra, letra2, posHash, table[letra][letra2][posHash]);
			} printf("??_\n");
		} printf("\n\n\n");
	}
}

// 
int main(){


	return 0;
}