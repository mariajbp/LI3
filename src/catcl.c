#include "../include/catcl.h"
#include "../include/clientes.h"
#include "../include/hash.h"


struct catcl
{
	struct CAT_CL* l;
 	struct CAT_CL* r;
 	char* c; //ELEMENTO A RECEBER
};

CAT_CL create_catcl()
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
		insert_Cliente(hash* table[], char id[]);
	}
	
	fclose(file);	

	return i;	

}


void destroyCCL(CAT_CL ccl)
{
	free(ccl);
}

//implementar nº total de prods que começam por uma letra  q3

