#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>


//função que valida os clientes 
int validaC(char* buff)	
{
	int i;
	int total = 0;
	int valid = 0;
	if(buff[5]) // se existir alguma coisa na ultima posição do array
	{
		total++;
		return  // ??????
	}
	else if (!isupper(buff[0]) // se a primeira letra do buffer não é maiuscula
		 {
			total++;
			return; //????
		 }
		 else 
		 { 	for (i=1; i<5; i++){
				if (isdigit(buff[i])])
				{
					//então é valida - adicionar a um array
				}
				total++;
				valid++;

			}

	     }
