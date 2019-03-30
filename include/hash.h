#ifndef __HASH_H__
#define __HASH_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node* Tree;


/**
 * Função que insere um index, de tipologia Cliente, numa estrutura de dados
 * @param estrutura a inserir o index, index a inserir
 */
void insert_Cliente(Tree* table[], char id[]);

/**
 * Função que insere um index, de tipologia Produto, numa estrutura de dados
 * @param estrutura a inserir o index, index a inserir
 */
void insert_Produto(Tree** table[], char id[]);

/**
 * Função que, aplicando a Tree funtion, verifica se uma posição da hashtable existe
 * @param string index, estrutura de pesquiza
 * @param 1 se existir, 0 se não existir
 */
int search_C(char id[], Tree* table[]);

/**
 * Função que, aplicando a Tree funtion, verifica se uma posição da hashtable existe
 * @param string index, estrutura de pesquiza
 * @param 1 se existir, 0 se não existir
 */
int search_P(char id[], Tree** table[]);

/**
 * Função que imprime a arvore correspondente numa posição da tabela
 * @param file pointer, primeira letra, segunda letra, a arvore e um numero que vai retornar
 * @param o numero de elementos impressos no ficheiro
 */
int fprint_tC(FILE* fp, int l1, Tree arvore);

/**
 * Função que imprime a arvore correspondente numa posição da tabela
 * @param file pointer, primeira letra, segunda letra, a arvore e um numero que vai retornar
 * @param o numero de elementos impressos no ficheiro
 */
int fprint_tP(FILE* fp, int l1, int l2, Tree arvore);


#endif
