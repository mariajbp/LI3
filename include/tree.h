#ifndef __TREE_H__
#define __TREE_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node* Tree;

/**
 * Função que escreve os dados válidos num ficheiro (Clientes)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Tree insert_tree(Tree nodo, int val);

/**
 * Função que escreve os dados válidos num ficheiro (Clientes)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int search_tree(Tree arvore, int id);

/**
 * Função que transforma uma substring num numero
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int num(char string[], int index);

#endif
