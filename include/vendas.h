#ifndef __VENDAS_H__
#define __VENDAS_H__

#include <stdlib.h>
#include <string.h>

typedef struct venda* VENDA;

 
VENDA createVenda(char** tokens);

 
char* getPcode(VENDA v);


double getPrice(VENDA v);


int getUnits(VENDA v);


char* getNP(VENDA v);


char* getCLcode(VENDA v);


int getMonth(VENDA v);


int getFilial(VENDA v);


void destroyVenda(VENDA v);



#endif