#include "interface.h"


//query 1


//query 2

query2(char letra, CAT_PROD produto)
{
	//letra é maiuscula 
	//apresewntar lista e navegar pag a pag
}

//query 3

query3(char* month, char* code, FATURACAO faturacao, FILIAL filial)
{
	//num total de vendas do produto e o total faturado nesse mes 
	//distinguir P e N
	//RES global ou filial a filial
}

//query 4

query4(CAT_PROD produtos, FATURACAO faturacao, FILIAL filial )
{
	//lista ORDENADA de prod que não foram comprados
	//RES global ou filial a filial
}

//query 5
query5(FILIAL filial)
{
	//lista ORDENADA de cod de clientes que compraram nas 3 filiais 
}

//query 6
quer6(FATURACAO faturacao, FILIAL filial, CAT_CL catcl)
{
	//lista de clientes que nunca compraram nada 
	//numero de prods nunca comprados 
}

//query 7
query7(char* code)
{
  //TABELA com nº total de produtos comprados (todas a vendas a esse cliente)
	//organizar por mes, se não comprou fica a 0
	//OUTPUT filial a filial
}

//query 8
query8(?????)
{
	//total de vendas nesse intervalo e total faturado
}

//query 9
query9(char* cod, //uma filial?? por representar)
{
	//nº de clientes que o compraram e  e distinguir N e P
}

//query 10 
query10(char* code, int month)
{
	//lista cod prods que + comrpou (quantidade) por ordem descendente
}

//query 11
query11(FATURACAO faturacao, FILIAL filial)
{
	//N prods mais vendidos indicar o nº de clientes que o compraram  e as unidades que cada filial vendou desse prod 
}
//query 12

QUERY12(char* code)
{

}