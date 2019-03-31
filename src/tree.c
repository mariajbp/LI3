 // retorna o num de elementos que printou#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../include/tree.h"


// Função que imprime uma arvore por ordem dos elementos
int print_tree(Tree arvore){
	int num = 0;
	if(arvore){
		num += print_tree(arvore->esq);
		printf("%d\n", arvore->valor); num++;
		num += print_tree(arvore->dir);
	}

	return num;
}

// Função que indica o maior de dois números
int max(int a, int b){ 
    return (a > b)? a : b;
}

// Função que indica a altura de uma arvore
int altura(Tree a){
    return (a == NULL)? 0 : a->altura;
}

// Função que cria um Nodo novo da arvore, ou até mesmo uma arvore nova, com um dado valor
Tree create_nodo(int valor){
    Tree nodo = (Tree) malloc(sizeof(struct node));

    nodo->valor = valor;
    nodo->esq = NULL;
    nodo->dir = NULL;
    nodo->altura = 1;
    
    return nodo;
}

// Função que balança a arvore para a direita
Tree rotate_dir(Tree y){
    Tree x = y->esq;
    Tree T2 = x->dir;

    x->dir = y;
    y->esq = T2;

    y->altura = max(altura(y->esq), altura(y->dir))+1;
    x->altura = max(altura(x->esq), altura(x->dir))+1;

    return x; 
}
  
// Função que balança a arvore para a esquerda
Tree rotate_esq(Tree x){ 
    Tree y = x->dir;
    Tree T2 = y->esq;

    y->esq = x;
    x->dir = T2;

    x->altura = max(altura(x->esq), altura(x->dir))+1;
    y->altura = max(altura(y->esq), altura(y->dir))+1;

    return y;
}

// Função que indica a diferença do balanceamento da arvore
int difBalance(Tree a){
    return (a == NULL)? 0 : altura(a->esq) - altura(a->dir);
} 

// Função que devolve o valor minimo de uma arvore
Tree valorMinimo(Tree h){
	Tree r = h;
	while(r->esq) r = r->esq;

	return r;
}

// Função que recursivamente insere um valor numa AVL
Tree insert_tree(Tree nodo, int val){
	int balance;
    if(nodo == NULL) {
    	return(create_nodo(val));
    }
    //printf("\thouve colisao\n\tvalor_%d\n\n", nodo->valor);

    if(val < nodo->valor) nodo->esq = insert_tree(nodo->esq, val);
    else
    	if(val > nodo->valor) nodo->dir = insert_tree(nodo->dir, val);
    	else return nodo;

    nodo->altura = 1 + max(altura(nodo->esq),altura(nodo->dir));
    balance = difBalance(nodo);

    if(balance > 1 && val < nodo->esq->valor)
        return rotate_dir(nodo);

    if(balance < -1 && val > nodo->dir->valor)
        return rotate_esq(nodo);

    if(balance > 1 && val > nodo->esq->valor){ 
        nodo->esq = rotate_esq(nodo->esq);
        return rotate_dir(nodo);
    }

    if(balance < -1 && val < nodo->dir->valor){
        nodo->dir = rotate_dir(nodo->dir);
        return rotate_esq(nodo);
    }

    return nodo;
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

// Função que transforma uma substring num numero
int num(char string[], int index){
	return atoi(string+index);
}


/* The constructed AVL Tree would be 
		30 
	   /  \ 
	 20   40 
    /  \     \ 
   10  25    50 
*/
