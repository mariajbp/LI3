#ifndef __VENDAS_H__
#define __VENDAS_H__

#include <stdlib.h>
#include <string.h>
#include "CatalogoProdutos.h"
#include "CatalogoClientes.h"
#include "tree.h"

typedef struct venda* Venda;

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
int loadstruct_Vendas( Venda* estrutura, char* path, Tree produtos[26][26][151], Tree clientes[26][307]);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int wrFileV (Venda* table, char* path);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void init_Vendas(int* num, Tree tProdutos[26][26][151], Tree tClientes[26][307]);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Venda createVenda(char** tokens);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* getPcode(Venda v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
double getPrice(Venda v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int getUnits(Venda v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* getNP(Venda v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* getCLcode(Venda v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int getMonth(Venda v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int getFilial(Venda v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void destroyVenda(Venda v);



#endif
