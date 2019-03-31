include "../include/faturacao.h"

struct faturacao{
	
	Tree tipo[12][3]; // 0 - N, 1 - P, 2 - NULL
	int sizeN, sizeP, sizeNull;
	int sizeMes[12]; // quantas ha por mes

};

int insere_N(char* id, int mes, Facturacao f){
	int r = 0;



	return r;
}

int insere_P(int mes){
	int r = 0;



	return r;
}

int insere_Null(int mes){
	int r = 0;



	return r;
}
//FATURACAO creat_faturacao()

//GETS 

void destroyFac(Faturacao f){
	free(f);
}

//determinar se um prod é N ou P 

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