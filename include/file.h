#ifndef __FILE_H__
#define __FILE_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int loadArray( char** array, char* path, int max, int (*valida) (char, ...) );


/**
 * Função que dado um ficheiro conta as linhas
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int linecount(char* path);

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
