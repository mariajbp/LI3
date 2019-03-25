#include "../include/catprod.h"
#include "../include/produtos.h"

struct catprod
{
	struct CAT_PROD* l;
 	struct CAT_PROD* r;
 	PRODUTOS* p; //ELEMENTO A RECEBER
};
	


CAT_PROD create_catprod()
{
	FILE* file = fopen("ProdutosValidos.txt" , "r");
	if(file == NULL){
      		printf("Error! You tried to read an empty file.");   
     		exit(1);             
    	}
    //ADICIONAR LINHA A LINHA NUMA ARVORE
	
	fclose(file);	

}


//GETS 

void destroyCP(CAT_PROD cp)
{
	free(cp);
}