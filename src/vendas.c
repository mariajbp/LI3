#include "../include/vendas.h"


struct venda{
  char pcode[7];
  double price;
  int units;
  char* np;
  char clcode[6];
  int month;
  int filial;
 };

//dado o array com tokens, constroi uma venda
VENDA createVenda(char** tokens){
 	VENDA v = (VENDA) malloc(sizeof (VENDA) );
 	strcpy( (v->pcode), tokens[0]);
 	v->price = atof(tokens[1]);
 	v->units = atoi(tokens[2]);
 	strcpy( (v->np), tokens[3]);
 	strcpy( (v->clcode), tokens[4]);
 	v->month = atoi(tokens[5]);
 	v->filial = atoi(tokens[6]);
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

 
char* getNP(VENDA v)
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












