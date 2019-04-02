#ifndef __CATALOGO_CLIENTES_H__
#define __CATALOGO_CLIENTES_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "tree.h"

/**
 * Função que valida um id de um cliente
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int validaCliente(char * id);

/**
 * Função que insere um index, de tipologia Cliente, numa estrutura de dados
 * @param estrutura a inserir o index, index a inserir
 */
void insert_Cliente(Tree clientes[26][599], char id[]);

/**
 * Função que, aplicando a Hash Funtion, verifica se uma posição da hashtable existe
 * @param string index, estrutura de pesquiza
 * @param 1 se existir, 0 se não existir
 */
int search_C(Tree clientes[26][599], char id[]);

/**
 * Função que imprime a arvore correspondente numa posição da tabela
 * @param file pointer, primeira letra, segunda letra, a arvore e um numero que vai retornar
 * @param o numero de elementos impressos no ficheiro
 */
int fprint_clientes(FILE* fp, int l1, Tree arvore);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int loadHash_Clientes(Tree clientes[26][599], char* path);

/**
 * Função que escreve os dados válidos num ficheiro (Clientes)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int wrFileC (Tree clientes[26][599], char* path);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int create_clientes(Tree cat_Clientes[26][599], char* path);

/**
 * Função que inicializa a estrutura
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void init_Clientes(int* num, Tree clientes[26][599]);

#endif
