#ifndef __VENDAS_H__
#define __VENDAS_H__

#include <stdlib.h>
#include <string.h>
#include "CatalogoProdutos.h"
#include "CatalogoClientes.h"
#include "tree.h"

typedef struct tree_vendas* Tree_Vendas;

/**
 * Tokenize, devolve o i e preenche o array tokens
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int toktok(char * linha, char** tokens);

/**
 * Função que valida um id de uma venda
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int validaVenda(char* linha, Tree produtos[26][26][151], Tree clientes[26][307]);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int loadstruct_Vendas(Tree_Vendas estrutura, char* path, Tree produtos[26][26][151], Tree clientes[26][307]);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int wrFileV (Tree_Vendas table, char* path);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void init_Vendas(Tree_Vendas vendas, int* num, Tree tProdutos[26][26][151], Tree tClientes[26][307]);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Tree_Vendas createVenda(char** tokens);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* getPcode(Tree_Vendas v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
double getPrice(Tree_Vendas v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int getUnits(Tree_Vendas v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* getNP(Tree_Vendas v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* getCLcode(Tree_Vendas v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int getMonth(Tree_Vendas v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int getFilial(Tree_Vendas v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void destroyVenda(Tree_Vendas v);


#endif
