#include "../include/catcl.h"
#include "../include/clientes.h"
#include "../include/hash.h"


struct catcl
{
	struct CAT_CL* l;
 	struct CAT_CL* r;
 	CLIENTE* c; //ELEMENTO A RECEBER
};

CAT_CL create_catcl()
{
	FILE* file = fopen("ClientesValidos.txt" , "r");
	if(file == NULL){
      		printf("Error! You tried to read an empty file.");   
     		exit(1);             
    	}

	//ADICIONAR LINHA A LINHA NA ARVORE
	fclose(file);	

}

 void insert(CAT_CL ccl, CLIENTE c)
 {
 	CAT_CL 
 }


//GETS 

void destroyCCL(CAT_CL ccl)
{
	free(ccl);
}