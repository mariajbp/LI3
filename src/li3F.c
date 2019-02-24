#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <assert.h>

char* openFile(char* path, int val){

	FILE *fileTR; // file to read
	char* buff = malloc(sizeof(char)*31); 								// 31 é o valor max de uma compra, a estrutura maior
	fileTR = fopen(path, "r");
	while(1){											// not actual code, ainda ta a ser feito
		fgets(buff, val, fileTR);
	}

	fclose(fileTR);
	return buff;
}

//função que valida um id de um produto
int validaProduto(char * id, int i){
	int r = 0;
	if(strlen(id) == i){
		if(!id[i] || (id[i] == ' '))								//segue se o id[i] é \0 ou NULL, ou se for um espaço
			if((id[0]<='Z') && (id[1]<='Z') && (id[0] >= 'A') && (id[1] >= 'A'))  		//Se os dois primeiros carateres sao maiusculas 								
				if(('1'<=id[2]) && (id[2]<='9'))					//Se a 3ª posição é entre 1 e 9
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
		if(!id[i] || (id[i] == ' '))									//segue se o id[i] é \0 ou NULL, ou se for um espaço
			
			if((id[0] <= 'Z') && (id[0] >= 'A'))							//Se a primeiros carateres sao maiusculas 								
			
				if(('1'<=id[1]) && (id[1]<='5'))						//Se a 2ª posição é entre 1 e 5
			
					for(int n = 2; n < (i-1); n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}			
	}
	return r;
}

//função que encontra as posicoes em que ha espacos e guarda as num array
int* findSpace(char* string, int *r){
	int num = 0;
	for(int i = 0; i < strlen(string); i++){
		if(string[i] == ' '){
			r[num] = i;
			num++;
		}
	}
	return r;
}

//função que recebe uma string e devolve uma sub string de um inicio a um fim
char* subString(const char* linha, char* sub, int inicio, int fim){
	int tamanho = fim - inicio;
    	for(int i = 0; i < tamanho; i++){
        	sub[i] = linha[inicio+i];
    	}
    return sub;
}

//função que so serve para testar
int num(int* r){
	int n = 0;
	for(int i = 0; i < (int) sizeof(r); i++){
		if(r[i]) n++;
	}
	return n;
}

//função que valida um id de uma venda
int validaVendas(char * linha, int i){
	int r = 0, a, b, s[10];
	char produto[7], cliente[6];
	findSpace(linha,s);
	
	if(!linha[i]){											//a posicao final do linha tem de ser \0 ou Null
		a = 0; b = s[0];
		memset(produto, 0, sizeof(produto));
		subString(linha,produto,a,b);

		if( validaProduto(produto , 6) ){
			a = b + 1; b = s[1];
			if( 1 ){									//validaValor(subString(linha,sub,a,b))
				a = b + 1; b = s[2];
				if( 1 ){								//validaUnidade(subString(linha,sub,a,b))
					if( linha[b + 1] == 'N' || linha[b + 1] == 'P' ){
						a = s[3] + 1 ; b = s[4];
						memset(cliente, 0, sizeof(cliente));
						subString(linha,cliente,a,b);
						
						if( validaCliente(cliente , 5) ){
							if( 1 ) // nao sei validar o mes
								if( 1 ) // validar a filial
											return 1;
						}
					}
				}
			}
		}
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
