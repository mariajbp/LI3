#include "vendas.h"
#include <stdlib.h>
#include <string.h>

struct venda{
  char pcode[7];
  double price;
  int units;
  char np;
  char clcode[6];
  int month;
  int filial;
 };
 
VENDA createVenda(char* pc, double price, int units, char np, char* clc, int month, int filial){
 	VENDA v = (VENDA) malloc(sizeof (VENDA) );
 	strcpy( (v->pcode), pc);
 	v->price = price;
 	v->units = units;
 	v->np = np;
 	strcpy( (v->clcode), clc);
 	v->month = month;
 	v->filial = filial;
 	return v;
}

 

char* getPcode(VENDA v)
 {
 	return v->pcode;
}

 
double getPrice(VENDA v)
 {
 	return v->price;
}

 
int getUnits(VENDA v)
 {
 	return v->units;
}

 
char getNP(VENDA v)
 {
	return v->np;
}

 
char* getCLcode(VENDA v){

 	return v->clcode;

}

 
int getMonth(VENDA v){

 	return v->month;

}

int getFilial(VENDA v){

 	return v->filial;
}

void destroyVenda(VENDA v)
{
  free(v);
}












