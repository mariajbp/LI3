#ifndef __VENDAS_H__
#define __VENDAS_H__

#include "catalogo_produtos.h"
#include "catalogo_clientes.h"

typedef struct vendas_mes* Vendas_inMes;

typedef struct vendas_filial* Vendas_Filial;

typedef struct vendas* Vendas;

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Vendas init_Vendas(int* num, Produtos p, Clientes c);


/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int toktok(char * linha, char** tokens);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int validaVenda(char* linha, Produtos p, Clientes c);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int loadstruct_Vendas( Strings s, char* path, Produtos p, Clientes c);

#endif
