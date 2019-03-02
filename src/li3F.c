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
int validaProduto(const char * id, int i){
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
int validaCliente(const char * id, int i){
	int r = 0;
	if(strlen(id) == i){
		if(!id[i] || (id[i] == ' '))											//segue se o id[i] é \0 ou NULL, ou se for um espaço
			
			if((id[0] <= 'Z') && (id[0] >= 'A'))										//Se a primeiros carateres sao maiusculas 								
			
				if(('1'<=id[1]) && (id[1]<='5'))										//Se a 2ª posição é entre 1 e 5
			
					for(int n = 2; n < (i-1); n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}			
	}
	return r;
}

//função que valida um id de uma venda
int validaVendas(char* linha, int i, const char* produtos[], const char* clientes[]){						//Se i for > 31, descarta logo
	int r = 0; // s[10];
	char* tok = NULL;

	if(i<=31){											//a posicao final do linha tem de ser \0 ou Null
		tok = strtok(linha, " ");
		if( searchID(produtos , tok) ){
			tok = strtok(NULL, " ");

			if( atof(tok) <= 999.99 && atof(tok) >= 0.0 ){		// atof(str) converte a str para float, pertence a string.h
				tok = strtok(NULL, " ");

				if( atoi(tok) <= 200 && atoi(tok) >= 1 ){		// atoi(str) converte a str para int, pertence a string.h
					tok = strtok(NULL, " ");

					if( strcmp(tok, "N") || strcmp(tok, "P") ){
						tok = strtok(NULL, " ");

						if( searchID(clientes , tok) ){
							tok = strtok(NULL, " ");

							if( atoi(tok) <= 12 && atoi(tok) >= 1 ){
								tok = strtok(NULL, " ");

								if( atoi(tok) <= 3 && atoi(tok) >= 1 ) // validar a filial
											return 1;}}}}}}
	}
	return r;
}

int main(){
	char a[] = "F2916";																	//testes
	char b[] = "DV1294";																//testes
	char c[] = "KR1583 77.72 128 P L4891 2 1";
	int r[30];

	printf("valida A deve dar 1(A é cliente) e 0, da - %d %d\n", validaCliente(a,5), validaProduto(a,6) );
	printf("valida B deve dar 0 e 1(B é produto), da - %d %d\n", validaCliente(b,5), validaProduto(b,6) );
	printf("deve dar 6 = %d\ndeve dar 1 = %d\n", num(findSpace(c,r)), validaVendas(c,31) );
	return 0;
}
