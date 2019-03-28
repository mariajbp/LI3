#ifndef __HASH_H__
#define __HASH_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct tree* hash;

void init_hC(hash** tClientes);

void init_hP(hash*** tProdutos);

/**
 * Função que elimina um index, de tipologia Cliente, da estrutura de dados
 * @param estrutura onde se vai apagar o index, index a apagar
 */
void delete_Cliente(hash* table[], char id[]);

/**
 * Função que elimina um index, de tipologia Produto, da estrutura de dados
 * @param estrutura onde se vai apagar o index, index a apagar
 */
void delete_Produto(hash** table[], char id[]);

/**
 * Função que insere um index, de tipologia Cliente, numa estrutura de dados
 * @param estrutura a inserir o index, index a inserir
 */
void insert_Cliente(hash* table[], char id[]);

/**
 * Função que insere um index, de tipologia Produto, numa estrutura de dados
 * @param estrutura a inserir o index, index a inserir
 */
void insert_Produto(hash** table[], char id[]);

/**
 * Função que, aplicando a hash funtion, verifica se uma posição da hashtable existe
 * @param string index, estrutura de pesquiza
 * @param 1 se existir, 0 se não existir
 */
int search_C(char id[], hash* table[]);

/**
 * Função que, aplicando a hash funtion, verifica se uma posição da hashtable existe
 * @param string index, estrutura de pesquiza
 * @param 1 se existir, 0 se não existir
 */
int search_P(char id[], hash** table[]);

/**
 * Função que imprime a arvore correspondente numa posição da tabela
 * @param file pointer, primeira letra, segunda letra, a arvore e um numero que vai retornar
 * @param o numero de elementos impressos no ficheiro
 */
int fprint_hC(FILE* fp, int l1, hash table, int num);

/**
 * Função que imprime a arvore correspondente numa posição da tabela
 * @param file pointer, primeira letra, segunda letra, a arvore e um numero que vai retornar
 * @param o numero de elementos impressos no ficheiro
 */
 int fprint_hP(FILE* fp, int l1, int l2, hash table, int num);


#endif
