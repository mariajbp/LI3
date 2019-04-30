#ifndef __FATURACAO_H__
#define __FATURACAO_H__

#include <stdlib.h>
#include <string.h>

#include "arrayd.h"
#include "catalogo_produtos.h"

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Strings meteletra(Produtos p, char l1);

/**
 * Devolve o total faturado tanto N como P
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
double totalFaturado(Strings v);

/**
 * Devolve o total faturado de N e P separados
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void totalFaturadoNP(Strings v, double* num);

/**
 * determinar as vendas de um produto numa filial + mes
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Strings getVendasProdFM(char* path, char* code, int mes, int f);

/**
 * Determina todas as vendas
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Strings getvendas_PinM(char* path, char* code, int mes);

/**
 * calcula o total de vendas (num[0]) e o faturado (num[1])
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void totalV_F(char* path, int inicio, int fim, double n[2]);

#endif
