include "../include/faturacao.h"

struct faturacao
{
	
	Tree tipo[12][3]; // 0 - N, 1 - P, 2 - NULL
	int sizeN, sizeP, sizeNull;
	int sizeMes[12]; // quantas ha por mes

};

void creat_faturacao()
{
	
}

int insere_N(char* code, int mes, Facturacao f)
{
	int r = 0;
	insert_tree(faturacao->tipo[mes][0], num(code,1))


	return r;
}

int insere_P(char* code, int mes, Facturacao f)
{
	int r = 0;
	insert_tree(faturacao->tipo[mes][1], num(code,1))


	return r;
}

int insere_Null(char* code, int mes, Facturacao f)
{
	int r = 0;
	insert_tree(faturacao->tipo[mes][2], num(code,1))

	return r;
}


void destroyFac(Faturacao f)
{
	free(f);
}

//determinar se um prod é N ou P 
char* typeNPNULL(char* code, Faturacao f)
{

}

//determinar nº de vendas de N total
int totalN()
{

}

//determinar nº de vendas de P total
int totalP()
{

}

//determinar nº de vendas de NULL total
int totalNULL()
{

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