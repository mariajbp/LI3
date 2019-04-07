#include "../include/filial.h"

Vendas_filial loadFilial(char* path)
{
	char linha[32];
	int i = 0;
	int f = 0;
	Vendas_filial s;
	char* tokens[7];
	FILE* file = fopen(path , "r");
	
	for(i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));

	if(file == NULL){
      	printf("Error! You tried to read an empty file."); 
      	fclose(file);	  
     	exit(1); 
    }

	while(fgets(linha, 31, file) )
	{
		toktok(linha,tokens);
		f = atoi(tokens[6]);
		string_append(s->filial[f],linha);
	}
	
	fclose(file);	

	return i;
}

int naoHaProd(char* prod, Strings s){
	int r = 1;
	for (int i = 0; i < s->inUse; i++)
	{
		// procurar no array s	
	}
	return r;
}


Strings* naoComprados(Vendas_filial v, char* path)
{
	Strings produtos = malloc(sizeof(Strings));
	for(int k = 0; k < 3; k++)
		Strings pNC[k] = malloc(sizeof(Strings));
	int i = 0;

	while(fgets(linha, 7, file) )
	{
		string_append(produtos->string[i],linha);
		i++;
	}

	for (int i = 0; i < produtos->inUse; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			if(naoHaProd(produtos->string[i],v->filial[j]));
				string_append(pNC[j], produtos->string[i]);
		}
	}

	return pNC; // return produtos nao comprados
}




int haCliente(char* ccode, Strings s){
	int r = 1;
	for (int i = 0; i < s->inUse; i++)
	{
		// procurar no array s	
	}
	return r;
}

Strings compraramTodas(Vendas_filial v, char* path)
{
	Strings clientes = malloc(sizeof(Strings));
	for(int k = 0; k < 3; k++)
		Strings cCT[k] = malloc(sizeof(Strings));
	int i = 0;

	while(fgets(linha, 6, file) )
	{
		string_append(clientes->string[i],linha);
		i++;
	}

	for (int i = 0; i < clientes->inUse; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			if(haCliente(clientes->string[i],v->filial[j]));
				string_append(cCT[j], clientes->string[i]);
		}
	}

	return cCT; // return clientes que compraram tudo
}


void nUnidadesCompradas(char* cliente, Strings m, int num[12][3]){
		
	char* tokens[7];
	int nUC = 0;

	for(i=0; i<7; i++)
		tokens[i] = malloc(sizeof(char*));

	for (int i = 0; i < m->inUse; i++)
	{
		toktok(m->string[i],tokens);
		if(!strcmp(cliente,tokens(4))){
			nUC = tokens[2];
			num[tokens[5]][tokens[6]] += nUC; 
		}
		nUC = 0;
	}
}



