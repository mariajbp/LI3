#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../include/hash.h"


struct tree{
	int valor;
	struct tree *esq, *dir;
};

Tree create_tree(int id){ 
    Tree arvore =  (Tree) malloc(sizeof(struct tree));
    arvore->valor = id; 
    arvore->esq = arvore->dir = NULL;
    return arvore;
} 

// Função que insere um elemento numa arvore binaria
Tree insere_tree(Tree arvore, int id){
	if(arvore == NULL){
		arvore = create_tree(id);
	}
	else{
		if(id < arvore->valor) arvore->esq = insere_tree(arvore->esq, id);
		else arvore->dir = insere_tree(arvore->dir, id);
	}
	
	return arvore;
}

// Função que procura um elemento numa arvore binaria
int search_tree(Tree arvore, int id){
	int r;
	if(arvore == NULL) r = 0;
	else{
		if(id == arvore->valor) r = 1;
		else{
			if(id < arvore->valor) r = search_tree(arvore->esq, id);
			else r = search_tree(arvore->dir, id);
		}
	}

	return r;
}

//
Tree valorMinimo(Tree h){
	Tree r = h;
	while(r->esq) r = r->esq;

	return r;
}

// Função que apaga um elemento numa arvore binaria
Tree delete_tree(Tree arvore, int id){ 
    if (arvore == NULL) return arvore;

    if (id < arvore->valor) 
    	arvore->esq = delete_tree(arvore->esq, id); 
    else
    	if (id > arvore->valor)
        	arvore->dir = delete_tree(arvore->dir, id); 
    	else { 
        	if (arvore->esq == NULL){ 
            	Tree temp = arvore->dir; 
            	free(arvore); 
            	return temp; 
			} 
        	else if (arvore->dir == NULL){ 
            	Tree temp = arvore->esq; 
            	free(arvore); 
            	return temp; 
        }

        Tree temp = valorMinimo(arvore->dir); 
        arvore->valor = temp->valor; 
        arvore->dir = delete_tree(arvore->dir, temp->valor); 
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

Tree** create_hC(Tree** tabela){
	for(int i = 0; i < 27; i++)
		for(int j = 0; j < 301; j++)
			tabela[i][j] = NULL;
	return tabela;
}

Tree*** create_hP(Tree*** cubo){
	for (int i = 0; i < 27; i++)
		for (int j = 0; j < 27; j++)
			for(int k = 0; k < 151; k++)
				cubo[i][j][k] = NULL;
	return cubo;
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
void delete_Cliente(Tree* table[], char id[]){
	int index[2]; index[0] = 0; index[1] = 0;
	hF_Clientes(index,id);
	int nID = num(id,1);

	delete_tree(table[index[0]][index[1]], nID);
}

// Função que elimina um index, de tipologia Produto, da estrutura de dados
void delete_Produto(Tree** table[], char id[]){
	int index[3]; index[0] = 0, index[1] = 0, index[2] = 0;
	hF_Produtos(index,id);
	int nID = num(id,2);

	delete_tree(table[index[0]][index[1]][index[2]], nID);
}

// Função que insere um index, de tipologia Cliente, numa estrutura de dados
void insert_Cliente(Tree* table[], char id[]){
	int index[2]; index[0] = 0, index[1] = 0;
	int nID = num(id,1);
	hF_Clientes(index, id);

	insere_tree(table[index[0]][index[1]] , nID);
	printf("adeus\n");
}

// Função que insere um index, de tipologia Produto, numa estrutura de dados
void insert_Produto(Tree** table[], char id[]){
	int index[3]; index[0] = 0, index[1] = 0, index[2] = 0;
	int nID = num(id,2);
	hF_Produtos(index, id);

	insere_tree(table[index[0]][index[1]][index[2]] , nID);
}

// Função que, aplicando a Tree funtion, verifica se uma posição da Treetable existe
int search_C(char id[], Tree* table[]){
	int r = 0, nID = num(id,1);
	int index[2]; index[0] = 0, index[1] = 0;
	hF_Produtos(index,id);

	r = search_tree(table[index[0]][index[1]], nID);
	
	return r;
}

// Função que, aplicando a Tree funtion, verifica se uma posição da Treetable existe
int search_P(char id[], Tree** table[]){
	int r = 0, nID = num(id,2);
	int index[3]; index[0] = 0, index[1] = 0, index[2] = 0;
	hF_Produtos(index,id);

	r = search_tree(table[index[0]][index[1]][index[2]], nID);

	return r;
}

//
int fprint_hC(FILE* fp, int l1, Tree arvore, int num){
	char pL = l1+'A';

	if(!arvore) return num;
	else{
		if(arvore->esq){
			fprint_hC(fp,l1,arvore->esq,num);
			fprintf(fp, "%c%d\n", pL, arvore->valor);
			num++;
		}
		else{
			fprint_hC(fp,l1,arvore->dir,num);
			fprintf(fp, "%c%d\n", pL, arvore->valor);
			num++;
		}
	}

	return num;
}

//
int fprint_hP(FILE* fp, int l1, int l2, Tree arvore, int num){
	char pL = l1+'A', sL = l1+'A'; 

	if(!arvore) return num;
	else{
		if(arvore->esq){
			fprint_hP(fp,l1,l2,arvore->esq,num);
			fprintf(fp, "%c%c%d\n", pL, sL, arvore->valor);
			num++;
		}
		else if(arvore->dir){
			fprint_hP(fp,l1,l2,arvore->dir,num);
			fprintf(fp, "%c%c%d\n", pL, sL, arvore->valor);
			num++;
		}
	}

	return num;
}
