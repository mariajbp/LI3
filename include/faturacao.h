#ifndef __FATURACAO_H__
#define __FATURACAO_H__

#include <stdlib.h>
#include <string.h>

typedef struct faturacao* FATURACAO;

//Função que dado um código do tipo N, a quantidade vendida , a filial e um mês, o insere na árvore correspondente
int insereN(char* code, int n, int fl, int mes, FATURACAO  f);

//Função que dado um código do tipo P , a quantidade vendida, a filial e um mês, o insere na árvore correspondente
int insereP(char* code, int n, int fl, int mes, FATURACAO  f);

//Função que dado um código não vendido (NULL) e um mês, o insere na árvore correspondente
int insereNull(char* code, FATURACAO f);

//Função que devolve o número total de vendas num dado mês (N+P)
int totalMes(int mes, FATURACAO  f);

int search_prodV(char* pcode, char* venda);

Strings searchProdMes(char* code, Vendas_inMes vm, int mes);


int totalFaturado(Strings v);


int* totalFaturadoNP(Strings v, int num[2]);



#endif
