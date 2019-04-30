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

#endif
