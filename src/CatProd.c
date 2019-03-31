#include "../include/catprod.h"
#include "../include/produtos.h"
#include "../include/file.h"


int create_catprod(Tree cat_Produtos[26][26][151], char* path)
{
	char linha[6];
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL)
	{
    	printf("Error! You tried to read an empty file.");   
    	exit(1);             
    }

	while( fgets(linha, 6, file) )
	{
			insert_Produto(cat_Produtos,linha);
			i++;
	}
	
	fclose(file);	

	return i;
}


//GETS 

void destroyCP(Tree cat_Produtos[26][26][151])
{
	free(cat_Produtos);
}
