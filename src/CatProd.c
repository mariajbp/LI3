#include "../include/catprod.h"
#include "../include/produtos.h"
#include "../include/file.h"


struct catprod
{
	struct CAT_PROD* l;
 	struct CAT_PROD* r;
 	PRODUTOS* p; //ELEMENTO A RECEBER
};
	


CAT_PROD create_catprod(hash** table, char* path)
{
	char* linha = " ";
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL)
	{
      	printf("Error! You tried to read an empty file.");   
     	exit(1);             
    }

	while(fgets(linha, 6, file))
	{
		insert_Produto(table,linha);
	}

	fclose(file);
	return i;
}


//GETS 

void destroyCP(CAT_PROD cp)
{
	free(cp);
}