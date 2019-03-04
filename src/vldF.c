#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

//função que valida um id de um produto
int validaProduto(char * id, int i){
	int r = 0;
		if(!id[i])																		//segue se o id[i] é \0 ou NULL, ou se for um espaço
			if(isupper(id[0]) && isupper(id[1]))										//Se os dois primeiros carateres sao maiusculas 								
				if(('1'<=id[2]) && (id[2]<='9'))										//Se a 3ª posição é entre 1 e 9
					for(int n = 3; n < (i-1); n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}			
	return r;
}

//função que valida um id de um cliente
int validaCliente(char * id, int i){
	int r = 0;
		if(!id[i])														//segue se o id[i] é \0 ou NULL, ou se for um espaço
			if(isupper(id[0]))											//Se a primeiros carateres sao maiusculas 		
				if(('1'<=id[1]) && (id[1]<='5'))						//Se a 2ª posição é entre 1 e 5
					for(int n = 2; n < (i-1); n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}			
	return r;
}

// função que valida se uma string está no array de strings
int searchID(const char * lista[], const char * id){
	int r = 0, tamanho = sizeof(*lista)/sizeof(lista[0]);

	for(int i = 0; i <= tamanho; i++){
		if(!strcmp(lista[i], id))
			r = 1;
	}
	return r;
}

//função que valida um id de uma venda
int validaVendas(char* linha, int i, const char* produtos[], const char* clientes[]){
	int r = 0; // s[10];
	char* tok = NULL;

	if(i<=31){													//Se i for > 31, descarta logo
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
	char a[] = "F2916", b[] = "DV1294";
	const char *pp[] = {"KR1583", "DV1294", "FF2916"};
	const char *cc[] = {"L4891"};
	char c[] = "KR1583 77.72 128 P L4891 2 1";

	printf("\nVALIDA CLIENTE/PRODUTO\n\n");
	printf("valida A deve dar 1 e 0, da - %d %d\n", validaCliente(a,5), validaProduto(a,6) );
	printf("valida B deve dar 0 e 1, da - %d %d\n", validaCliente(b,5), validaProduto(b,6) );
	
	printf("\nVALIDA VENDAS\n\n");
	printf("\ndeve dar 1 = %d\n", validaVendas(c,31, pp, cc ) );
	return 0;
}