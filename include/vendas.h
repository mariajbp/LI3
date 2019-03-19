#ifndef __VENDAS_H__
#define __VENDAS_H__

#include <stdlib.h>
#include <string.h>


typedef struct venda* VENDA;

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
VENDA createVenda(char** tokens);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* getPcode(VENDA v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
double getPrice(VENDA v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int getUnits(VENDA v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* getNP(VENDA v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* getCLcode(VENDA v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int getMonth(VENDA v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int getFilial(VENDA v);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void destroyVenda(VENDA v);



#endif