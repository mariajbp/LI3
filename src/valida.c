#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include "valida.h"

//função que valida os clientes 
bool isPvalid(char* buff)
{
	int i;
	int total = 0;
	int valid = 0;
	if(buff[6])
	{
		total++;
		return false;
	}
	else if (!isupper(buff[0] && !isupper(buff[1])) // se a primeira e segunda letra do buffer não for maiuscula
	{
		total++:
		return false;
	}
	else 
	{ 	for (i=2; i<6; i++)
		{
				if (!isdigit(buff[i])])
				{
					total++;
					return false;
				}
					total++;
					valid++;
					return true;
				
		}
	} 
}



//função que valida os clientes 
bool isCvalid(char* buff)
{
	int i;
	int total = 0;
	int valid = 0;
	if(buff[5]) // se existir alguma coisa na ultima posição do array
	{
		total++;
		return false;
	}
	else if (!isupper(buff[0]) // se a primeira letra do buffer não é maiuscula
		 {
			total++;
			return false; 
		 }
		 else 
		 { 	for (i=1; i<5; i++)
		 	{
				if (!isdigit(buff[i])])
				{
					total++;
					return false;
				}
				total++;
				valid++;
				return true;

			}
		 }

}

//função que 
isVvalid(char* buff)
{
	if (formatvalid(buff) && tokenvalid(buff)) return true;
}


//função que conta o nº de tokens

bool formatvalid(char* buff)
{
	int count = 0;
	char tok;
	while((tok = strtok(buff, ' ')) != NULL) 
	{
    	count++;
    }
    if (count != 7) return false;
    else return true;

}

//função que valida cada token

bool tokenvalid(char* buff)
{
	char* tok;
	atof(tok) = ftok;
	atoi(tok) = atok;
	tok = strtok(buff, " ");
	if (!searchProd(tok)) return false; ///IMPLEMENTAR A FUNÇÃO QUE PROCURA O CODIGO E CONFIRMA QUE FUNCIONA 
	tok = strtok(NULL, " ");
	if(!(ftok > 0 && ftok < 999.99)) return false; //valida preço
	tok = strtok(NULL, " ");
	if(!(atok >= 1 && atok <= 200)) return false; //valida nº de unidades compradas
	tok = strtok(NULL, " ");
	if(!(strcmp(tok, "N") || strcmp(tok, "P") return false; //valida o tipo da compra
	tok = strtok(NULL, " ");
	if (!searchClient(tok)) return false; //IMPLEMENTAR A FUNÇÃO QUE PROCURA O CLIENTE
	tok = strtok(NULL, " ");
	if(!(atok >=1 && atok <=12)) return false; //valida mês
	tok = strtok(NULL, " ");
	if(!(atok >= 1 && atok <=3)) return false; //valida filial
	return true;
}



















