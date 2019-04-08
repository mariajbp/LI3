#ifndef __CATALOGO_PRODUTOS_H__
#define __CATALOGO_PRODUTOS_H__


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "arrayd.h"

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

Strings meteletra(Produtos p, char l1);

int totalVendasProd(Strings v, char* p);

int letra_produto(char string[]);

int num_produto(char string[], int index);

int validaProduto(char * id);

void insert_Produto(TAD_Array produtos[676], char id[]);

int fprint_produtos(FILE* fp, int i, TAD_Array produtos);




#endif
