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

//dado o array com tokens, constroi uma Venda
Venda createVenda(char** tokens){
 	Venda v = (Venda) malloc(sizeof (Venda) );
 	strcpy( (v->pcode), tokens[0]);
 	v->price = atof(tokens[1]);
 	v->units = atoi(tokens[2]);
 	strcpy( (v->np), tokens[3]);
 	strcpy( (v->clcode), tokens[4]);
 	v->month = atoi(tokens[5]);
 	v->filial = atoi(tokens[6]);
 	return v;
}

 

char* getPcode(Venda v)
 {
 	return v->pcode;
}

 
double getPrice(Venda v)
 {
 	return v->price;
}

 
int getUnits(Venda v)
 {
 	return v->units;
}

 
char* getNP(Venda v)
 {
	return v->np;
}

 
char* getCLcode(Venda v){

 	return v->clcode;

}

 
int getMonth(Venda v){

 	return v->month;

}

int getFilial(Venda v){

 	return v->filial;
}

void destroyVenda(Venda v)
{
  free(v);
}












