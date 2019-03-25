#ifndef __FILE_H__
#define __FILE_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "vendas.h"

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int loadHash_Clientes( hash** table, char* path, int max);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int loadHash_Produtos( hash*** table, char* path, int max);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int loadstruct_Vendas( Venda* estrutura, char* path, int max, hash*** produtos, hash** clientes);

/**
 * Função que dado um ficheiro conta as linhas
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int contaLinhas(char* path);

/**
 * Função que dado um ficheiro conta as linhas
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int maiorLinha(char* path);

/**
 * Função que escreve os dados válidos num ficheiro (Produtos)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int wrFileP (char** array, int n);


/**
 * Função que escreve os dados válidos num ficheiro (Clientes)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int wrFileC (char** array, int n);

/**
 * Função que escreve os dados válidos num ficheiro (Vendas)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */int wrFileV (char** array, int n);

#endif
