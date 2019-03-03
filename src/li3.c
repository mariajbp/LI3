#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>



//função que valida os produtos
int validaP(char* buff){
	int i;
	int total = 0;
	int valid = 0;
	if(buff[6]) // se existir alguma coisa na ultima posição do array
	{
		total++;
		return  // ??????
	}
	else if (!isupper(buff[0]) && !isupper(buff[1]) // se as duas primeiras letras do buffer  não são maiusculas
		 {
			total++;
			return; //????
		 }
		 else 
		 { 	for (i=2; i<6; i++){
				if (isdigit(buff[i])])
				{
					//então é valida ou seja adiconar a um array
				}
				total++;
			}

	     }

// O TOTAL VALIDO VAI SER SIZEOF(ARRAYCOMVALIDOS)

//função que valida os clientes 

int validaC(char* buff )	     

int main () {
	openFileP();
	return 0;
}





