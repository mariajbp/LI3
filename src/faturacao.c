#include "../include/faturacao.h"
#include "../include/tree.h"

struct faturacao{

	Tree tipo[12][2]; // 0 - N, 1 - P
	Tree null; //árvore só para os nulls (não faz sentido estarem num mês)
	int sizeN, sizeP, sizeNull; // número total de N, P ou NULL 
	int sizeNMes[12][3]; //número de N vendidos por mês por filial
	int sizePMes[12][3]; //número de P vendidos por mês por filial
	int sizeMes[12]; // N + P foram vendidos por mês

};

//Função que dado um código do tipo N, a quantidade vendida, a filial e um mês, o insere na árvore correspondente
int insereN(char* codigo, int n, int fl, int mes, FATURACAO f){
	int r = 0;
	if(mes < 12 && mes > 1){
		insert_tree(f->tipo[mes][0], n, codigo);			//valor = n logo será ordenado pela frequencia com que são comprados
		f->sizeN++;
		f->sizeMes[mes] += n;
		f->sizeNMes[mes][fl] += n; 
	} else r = 1;

	return r;
}

//Função que dado um código do tipo P , a quantidade vendida , a filial e um mês, o insere na árvore correspondente
int insereP(char* codigo, int n, int fl, int mes, FATURACAO f){
	int r = 0;
	if(mes < 12 && mes > 1){
		insert_tree(f->tipo[mes][1], n, codigo);
		f->sizeP++;
		f->sizeMes[mes] += n;
		f->sizePMes[mes][fl] += n;
	}else r = 1;


	return r;
}

//Função que dado um código não vendido (NULL) e um mês, o insere na árvore correspondente
int insereNull(char* codigo, FATURACAO  f){
	int r = 0;
		insert_tree(f->null, 0, codigo);
		f->sizeNull++;
	
	return r;
}


//Função que devolve o número total de vendas num dado mês (N+P)
int totalMes(int mes, FATURACAO  f){
	int v = f->sizeMes[mes];
	return v;
}

/*//determinar a faturacao de vendas tipo N mes
int faturacaoN(){

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
void destroyFac(FATURACAO  f){

	free(f);
}


//determinar tipo de produto N ou P ou NULL
int typeNPNULL(char* code, FATURACAO  f){



}
*/

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