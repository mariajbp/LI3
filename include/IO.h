#ifndef __IO_H__
#define __IO_H__

#include <stdlib.h>
#include <string.h>
#include "CatalogoProdutos.h"
#include "CatalogoClientes.h"
#include "vendas.h"
#include "tree.h"

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
int escolhe_Tarefa(int* num, Tree_Vendas vendas, Tree tProdutos[26][26][151], Tree tClientes[26][307]);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void Tarefa_1(Tree_Vendas vendas,int* num, Tree tProdutos[26][26][151], Tree tClientes[26][307]);


#endif
