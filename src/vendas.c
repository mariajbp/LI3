#include "vendas.h"
#include <stdlib.h>

struct venda
 {
 	char* pcode;
 	double price;
 	int units;
 	char np;
 	char* clcode;
 	int month;
 	int filial;
 };

 
  VENDA createVenda(char* pcode, double price, int units, char np, char* clcode, int month, int filial)
 {
 	VENDA v = (VENDA) malloc(sizeof (struct venda));
 	venda->pcode = pcode;
 	venda->price = price;
 	venda->units = units;
 	venda->np = np;
 	venda->clcode = clcode;
 	venda->month = month;
 	venda->filial = filial;
 	return v;
 }

 



 
  char* getPcode(VENDA v)
 {
 	return venda->pcode;
 }

 
  double getPrice(VENDA v)
 {
 	return venda->price;
 }

 
  int getUnits(VENDA v)
 {
 	return venda->units;

  }

 
  char getNP(VENDA v)
 {
 	return venda->np;
 }

 
  char* getCLcode(VENDA v)
 {
 	return venda->clcode;

  }

 
  int getMonth(VENDA v)
 {
 	return venda->month;

  }

  int getFilial(VENDA v)
 {
 	return venda->filial;
 }

void destroyVenda(VENDA V)
{
  free(v);
}












