#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <load.h>


char **lProd()
{
	static char *codProd[200000];
	char buff[50]
	int i;
	FILE* fp;
	fp = fopen("Produtos.txt", 'r');
	for(i=0; fgets(buff, 50, fp))
	{
		// if (validaP(buff))
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
	for(i=0; fgets(buff, 50, fc))
	{
		// if (validaP(buff)) {codCliente[i++] = strdup(buff);}
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
		//if (ValidaV(buff))...
	}

	fclose(fv);
	return codVenda;

}
















