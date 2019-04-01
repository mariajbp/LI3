#ifndef __TREE_H__
#define __TREE_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node* Tree;

/**
 * Função que devolve o lado esquerdo de uma arvore
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Tree esq(Tree t);

/**
 * Função que devolve o lado direito de uma arvore
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Tree dir(Tree t);

/**
 * Função que devolve o valor de uma arvore
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int valor(Tree t);

/**
 * Função que devolve a string de uma arvore
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* code(Tree t);

/**
 * Função que escreve os dados válidos num ficheiro (Clientes)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Tree insert_tree(Tree nodo, int val, char* codigo);

/**
 * Função que escreve os dados válidos num ficheiro (Clientes)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int search_tree(Tree arvore, int id);

/**
 * Função que procura um elemento numa arvore binaria 
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int search_treeCode(Tree arvore, char* id);

/**
 * Função que transforma uma substring num numero
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int num(char string[], int index);

#endif
