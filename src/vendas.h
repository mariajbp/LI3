#ifndef __VENDAS_H__
#define __VENDAS_H__

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

 
VENDA createVenda(char* pcode, double price, int units, char np, char* clcode, int month, int filial);

 
char* getPcode(VENDA v);


double getPrice(VENDA v);


int getUnits(VENDA v);


char getNP(VENDA v);


char* getCLcode(VENDA v);


int getMonth(VENDA v);


int getFilial(VENDA v);


void destroyVenda(VENDA V);



#endif