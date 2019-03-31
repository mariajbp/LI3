#include "../include/catcl.h"
#include "../include/clientes.h"
#include "../include/hash.h"


int create_catcl(Tree cat_Clientes[26][307], char* path){
	char linha[6];
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
    	printf("Error! You tried to read an empty file.");   
    	exit(1);             
    }

	while( fgets(linha, 6, file) ){
			insert_Cliente(cat_Clientes,linha);
			i++;
		}
	}
	
	fclose(file);	

	return i;
}



//GETS 

void destroyCCL(Tree cat_Clientes[26][307]){
	free(cat_Clientes);
}
