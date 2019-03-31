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
int loadHash_Clientes(Tree clientes[27][307], char* path, int max);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int loadHash_Produtos(Tree produtos[27][27][151], char* path, int max);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int loadstruct_Vendas( Venda* estrutura, char* path, int max, Tree produtos[27][27][151], Tree clientes[27][307]);

/**
 * Função que dado um ficheiro conta as linhas
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int contaLinhas(char* path);

/**
 * Função que escreve os dados válidos num ficheiro (Clientes)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int wrFileC (Tree clientes[27][307], char* path);

/**
 * Função que escreve os dados válidos num ficheiro (Produtos)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int wrFileP (Tree produtos[27][27][151], char* path);

/**
 * Função que escreve os dados válidos num ficheiro (Vendas)
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int wrFileV (Venda* table, char* path);

/**
 * Função que inicializa as estruturas
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void inicializar(int* num);
#endif
