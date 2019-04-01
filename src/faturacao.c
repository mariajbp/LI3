#include "../include/faturacao.h"
#include "../include/tree.h"

struct faturacao{

	Tree tipo[12][3]; // 0 - N, 1 - P, 2 - NULL
	int sizeN, sizeP, sizeNull; // número total de N, P ou NULL vendidos
	int sizeMes[12]; // quantos produtos foram vendidos por mes

};

//Função que dado um código do tipo N e um mês, o insere na árvore correspondente
int insereN(char* code, int mes, Facturacao f){
	int r = 0;
	if(mes < 12 || mes > 1){
		insert_tree(faturacao->tipo[mes][0], num(code,1));
		f->sizeMes[mes]++;
		f->sizeN++;
		f->tipo[mes][0]->valor[1]++;
	}else r = 1;

	return r;
}

//Função que dado um código do tipo P e um mês, o insere na árvore correspondente
int insereP(char* code, int mes, Facturacao f){
	int r = 0;
	if(mes < 12 || mes > 1){
		insert_tree(faturacao->tipo[mes][1], num(code,1));
		f->sizeMes[mes]++;
		f->sizeP++;
	}else r = 1;


	return r;
}

//Função que dado um código não vendido (NULL) e um mês, o insere na árvore correspondente
int insereNull(char* code, int mes, Facturacao f){
	int r = 0;
	if(mes < 12 || mes > 1){
		insert_tree(faturacao->tipo[mes][2], num(code,1));
		f->sizeMes[mes]++;
		f->sizeNull++;
	}else r = 1;

	return r;
}


//determinar tipo de produto N ou P ou NULL
int typeNPNULL(char* code, Faturacao f){



}

//determinar nº total de vendas tipo N por mes
int totalN(int mes, Faturacao f){
	int v = f->sizeMes[mes];
	return v;
}

//determinar a faturacao de vendas tipo N mes
int faturacaoN()
{

}

//dado um mes apresentar o nº de prods vendidos q4
int totalP()
{

}

//determinar a faturacao de vendas tipo P por mes 
int faturacaoP()
{

}


//determinar nº de vendas de NULL total por mes (query4)
int totalNULL()
{

}

void create_faturacao()
{
	
}

//Função que destrói uma estrutura do tipo Faturacao
void destroyFac(Faturacao f){

	free(f);
}


/*

correr ficheiro vendas, agrupar produtos por N e P ou NULL

separar por filial:
	obter faturação final
	n total de vendas por filiao ou total total

distinguir faturaçao mês a mês


{
	arvore->numero
	arvore->peso
}

*/