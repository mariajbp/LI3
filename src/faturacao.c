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

//determinar tipo de produto N ou P ou NULL
int typeNPNULL(char* code, Faturacao f)
{

}

//determinar nº total de vendas tipo N por mes
int totalN()
{

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