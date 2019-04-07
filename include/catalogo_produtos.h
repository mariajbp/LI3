#ifndef __CATALOGO_PRODUTOS_H__
#define __CATALOGO_PRODUTOS_H__


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

typedef struct produtos* Produtos;


/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
//Strings meteletra(Produtos p, char l1);

/**
 * Função que verifica se um id existe na estrutura
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int search_P(Produtos p, char id[]);

/**
 * Função que inicia uma estrutura produtos
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Produtos init_Produtos(int num[6]);

#endif
