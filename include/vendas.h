#ifndef __ARRAY_H_
#define __ARRAY_H__

typedef struct vendas_mes* Vendas_inMes;

typedef struct vendas* Vendas;

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Vendas init_Vendas(int* num, Produtos p, Clientes c);

#endif
