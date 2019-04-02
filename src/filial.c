#include "../include/filial.h"

//Estrutura que contém toda a informação sobre uma compra
typedef compra
{
	int mes;
	char* tipo;
	int preco;
	int quant;

}*Compra;


//Estrutura que associa todas as compras de um certo produto a um cliente
typedef struct nodeF
{
	char* codeC;	 //codigo
	Compra* compras;  //array de vendas

	struct nodeF *esq, *dir;

}*NodeF;


//Árvore de todos os produtos e respetivas informações (Filial)
typedef struct treeF
{
	NodeF prod[];

}*TreeF;


//Estrutura que junta todas as filiais
struct filial
{
	TreeF filial1;
	TreeF filial2;
	TreeF filial3
	
}*Filial;


//Função que cria uma compra
Compra createCompra(int m, char* t, int p, int q)
{	Compra c = malloc(sizeof(struct compra*));

	c->mes = m;
	c->tipo = t;
	c->preco = p;
	c->quant = q;

	return c;
}

//Função que cria um NodeF
NodeF createNodeF(char* c, Compra c)
{	NodeF n = malloc(sizeof(struct nodef*));

	n->codeC = c;
	n->compras = c;

	return n;
	
}

//Função que cria uma TreeF
TreeF  createTreeF(NodeF n)							//FIXME pls	
{	TreeF f = malloc(sizeof(struct treeF*));


}

Filial creat_filial()
{
	Filial f1 = Filial malloc(sizeof(struct Filial));
	Filial f2 = Filial malloc(sizeof(struct Filial));
	Filial f3 = Filial malloc(sizeof(struct Filial));
}

void destroyNodeF(Filial f)
{
	free(f);
}

void destroyTreef(Filial f)
{
	free(f);
}

void destroyFilial(Filial f)
{
	free(f);
}


//dado um produto saber quais os clientes que o compraram
char* compradoPor(char* code, Filial f)
{

}

//dado um cliente saber quantos units comprou de um produto 
int unitsCompradasCL(char* cliente, char* produto, filial f)
{

}

//dado um cliente procurar todos os prods que comprou 
char* darnomeaestafunçao(char* code, Filial f)
{

}

//query 5: lista de clientes que compraram em todas as filiais comparar not sure how to do it

//query 6: nº de clientes que não fizeram compras




