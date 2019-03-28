#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../include/hash.h"


struct tree{
	int head;
	struct tree *esq, *dir;
};

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

// Função que elimina um index, de tipologia Cliente, da estrutura de dados
void delete_Cliente(hash* table[], char id[]){
	int index[2]; index[0] = 0; index[1] = 0;
	hF_Clientes(index,id);
	int nID = num(id,1);

	delete_tree(table[index[0]][index[1]], nID);
}

// Função que elimina um index, de tipologia Produto, da estrutura de dados
void delete_Produto(hash** table[], char id[]){
	int index[3]; index[0] = 0, index[1] = 0, index[2] = 0;
	hF_Produtos(index,id);
	int nID = num(id,2);

	delete_tree(table[index[0]][index[1]][index[2]], nID);
}

// Função que insere um index, de tipologia Cliente, numa estrutura de dados
void insert_Cliente(hash* table[], char id[]){
	int index[2]; index[0] = 0, index[1] = 0;
	int nID = num(id,1);
	hF_Clientes(index, id);

	insere_tree(table[index[0]][index[1]] , nID);
}

// Função que insere um index, de tipologia Produto, numa estrutura de dados
void insert_Produto(hash** table[], char id[]){
	int index[3]; index[0] = 0, index[1] = 0, index[2] = 0;
	int nID = num(id,2);
	hF_Produtos(index, id);

	insere_tree(table[index[0]][index[1]][index[2]] , nID);
}

// Função que, aplicando a hash funtion, verifica se uma posição da hashtable existe
int search_C(char id[], hash* table[]){
	int r = 0, nID = num(id,1);
	int index[2]; index[0] = 0, index[1] = 0;
	hF_Produtos(index,id);

	r = search_tree(table[index[0]][index[1]], nID);
	
	return r;
}

// Função que, aplicando a hash funtion, verifica se uma posição da hashtable existe
int search_P(char id[], hash** table[]){
	int r = 0, nID = num(id,2);
	int index[3]; index[0] = 0, index[1] = 0, index[2] = 0;
	hF_Produtos(index,id);

	r = search_tree(table[index[0]][index[1]][index[2]], nID);

	return r;
}

//
int fprint_hC(FILE* fp, int l1, hash table, int num){
	char pL = l1+'A';

	if(!table) return num;
	else{
		if(table->esq){
			fprint_hC(fp,l1,table->esq,num);
			fprintf(fp, "%c%d\n", pL, table->head);
			num++;
		}
		else{
			fprint_hC(fp,l1,table->dir,num);
			fprintf(fp, "%c%d\n", pL, table->head);
			num++;
		}
	}

	return num;
}

//
int fprint_hP(FILE* fp, int l1, int l2, hash table, int num){
	char pL = l1+'A', sL = l1+'A'; 

	if(!table) return num;
	else{
		if(table->esq){
			fprint_hP(fp,l1,l2,table->esq,num);
			fprintf(fp, "%c%c%d\n", pL, sL, table->head);
			num++;
		}
		else{
			fprint_hP(fp,l1,l2,table->dir,num);
			fprintf(fp, "%c%c%d\n", pL, sL, table->head);
			num++;
		}
	}

	return num;
}
