#ifndef __VALIDA_H__
#define __VALIDA_H__

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include "hash.h"

/**
 * Função que valida um id de um produto
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int validaProduto(char * id);

/**
 * Função que valida um id de um cliente
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int validaCliente(char * id);

/**
 * Função que valida um id de uma venda
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int validaVenda(char* linha, Tree*** produtos, Tree** clientes);

/**
 * Função que dado uma linha e um array, preenche o array com tokens da linha e devolve o número de campos
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int toktok(char * linha, char** tokens);

#endif
