#ifndef __IO_H__
#define __IO_H__

#include <stdlib.h>
#include <string.h>
#include "catalogo_produtos.h"
#include "catalogo_clientes.h"
#include "vendas.h"
#include "arrayd.h"

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void print_menu();

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int escolhe_Query();

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void query_1(int num[6]);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void query_2(int num[6]);

#endif
