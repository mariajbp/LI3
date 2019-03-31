#ifndef __CATALOGO_PRODUTOS_H__
#define __CATALOGO_PRODUTOS_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "tree.h"

/**
 * Função que valida um id de um produto
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int validaProduto(char * id);

/**
 * Função que insere um index, de tipologia Produto, numa estrutura de dados
 * @param estrutura a inserir o index, index a inserir
 */
void insert_Produto(Tree produtos[26][26][151], char id[]);

/**
 * Função que, aplicando a Tree funtion, verifica se uma posição da hashtable existe
 * @param string index, estrutura de pesquiza
 * @param 1 se existir, 0 se não existir
 */
int search_P(Tree produtos[26][26][151], char id[]);

/**
 * Função que imprime a arvore correspondente numa posição da tabela
 * @param file pointer, primeira letra, segunda letra, a arvore e um numero que vai retornar
 * @param o numero de elementos impressos no ficheiro
 */
int fprint_produtos(FILE* fp, int l1, int l2, Tree arvore);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int loadHash_Produtos(Tree produtos[26][26][151], char* path, int max);

/**
 * Função que escreve os dados válidos num ficheiro (Clientes)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int wrFileP (Tree produtos[26][26][151], char* path);

/**
 * Função que escreve os dados válidos num ficheiro (Clientes)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int create_produtos(Tree cat_Produtos[26][26][151], char* path);

/**
 * Função que inicializa as estruturas
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void init_Produtos(int* num);

#endif
