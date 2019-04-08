#ifndef __FILIAL_H__
#define __FILIAL_H__

#include <stdlib.h>
#include <string.h>

typedef struct nodeF* NodeF;

typedef struct treeF* Treef;

typedef struct filial* Filial;

int naoHaProd(char* prod, Strings s);

Strings* naoComprados(Vendas_filial v, char* path);

int haCliente(char* ccode, Strings s);

Strings compraramTodas(Vendas_filial v, char* path);

void nUnidadesCompradas(char* cliente, Strings m, int num[12][3])

#endif
