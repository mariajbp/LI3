#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "load.h>"
#include "valida.h"


char **lProd()
{
	static char *codProd[200000];
	char buff[50]
	int i;
	FILE* fp;
	fp = fopen("Produtos.txt", 'r');
	for(i=0; fgets(buff, 50, fp))
	{
		if (isPvalid(buff)) 
		{
			codProd[i] = strdup(buff); //copia a linha do buffer para o array que vai ser passado para o novo ficheiro
		}
	}

	fclose(fp);
	return codProd;
}

//Carregar clientes válidos para um array

char **lCliente()
{
	static char *codCliente[20000];
	char buff[50];
	int i;
	FILE* fc;
	fc = fopen("Clientes.txt", 'r');
	for(i=0; fgets(buff, 50, fc); i++)
	{
		if (isCvalid(buff)) 
		{
			codCliente[i] = strdup(buff); //copia a linha do buffer para o array que vai ser passado para o novo ficheiro
		}
	}

	fclose(fc);
	return codCliente;
}



//Carregar vendas válidas para um array

char **lVendas()
{
	static char *codVenda[1000000];
	char buff[200];
	int i; 
	FILE* fv;
	fv = fopen("Vendas_1M.txt", 'r');
	for(i=0; fgest(buff, 200, fv))
	{
		if (isVvalid(buff))
		{
			codVenda[i] = strdup(buff); //copia a linha do buffer para o array que vai ser passado para o novo ficheiro
		}
	}

	fclose(fv);
	return codVenda;

}
















