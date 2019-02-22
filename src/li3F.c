#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

char* openFile(char* path, int val){

	FILE *fileTR; // file to read
	char* buff = malloc(sizeof(char)*31); 												// 31 é o valor max de uma compra, a estrutura maior
	fileTR = fopen(path, "r");
	while(1){																			// not actual code, ainda ta a ser feito
		fgets(buff, val, fileTR);
	}

	fclose(fileTR);
	return buff;
}

//função que valida um id de um produto
int validaProduto(char * id, int i){
	int r = 0;
	if(strlen(id) == i){
		if(!id[i] || (id[i] == ' '))													//segue se o id[i] é \0 ou NULL, ou se for um espaço
			if((id[0]<='Z') && (id[1]<='Z') && (id[0] >= 'A') && (id[1] >= 'A'))  		//Se os dois primeiros carateres sao maiusculas 								
				if(('1'<=id[2]) && (id[2]<='9'))										//Se a 3ª posição é entre 1 e 9
					for(int n = 3; n < (i-1); n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}			
	}
	return r;
}

//função que valida um id de um cliente
int validaCliente(char * id, int i){
	int r = 0;
	if(strlen(id) == i){
		if(!id[i] || (id[i] == ' '))													//segue se o id[i] é \0 ou NULL, ou se for um espaço
			if((id[0] <= 'Z') && (id[0] >= 'A'))										//Se a primeiros carateres sao maiusculas 								
				if(('1'<=id[1]) && (id[1]<='5'))										//Se a 2ª posição é entre 1 e 5
					for(int n = 2; n < (i-1); n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}			
	}
	return r;
}

/* função que valida um id de uma venda
int validaVendas(char * linha, int i){
	if(!id[i])
		if(validaCliente(linha, 6))
	return 1;
}


	validar vendas implica
		validar produto
		validar preço (0.0 ... 999.99)
		validar num unidades (1...200)
		validar N P
		validar cliente 
		validar mês (1...12)
		validar filial (1,2,3)
*/

int main(){
	char a[] = "F2916";																	//testes
	char b[] = "DV1294";																//testes

	printf("valida A deve dar 1(A é cliente) e 0, da - %d %d\n", validaCliente(a,5), validaProduto(a,6) );
	printf("valida B deve dar 0 e 1(B é produto), da - %d %d\n", validaCliente(b,5), validaProduto(b,6) );
	return 0;
}
