#include "../include/valida.h"
#include "../include/file.h"
#include "../include/vendas.h"


//Main do projeto


int main(){

//hash ** tClientes
//hash ** tProd
//Venda * sales

	int m = maiorLinha("../Clientes.txt");
	loadHash_Clientes(tClientes,"../Clientes.txt", m);
	wrFileC(tClientes, "../ClientesVálidos.txt");

	m = maiorLinha("../Produtos.txt");
	loadHash_Produtos(tProd,"../Produtos.txt", m);
	wrFileP(tProd, "../ProdutosVálidos.txt");

	m = maiorLinha("../Vendas_1M.txt");	
	loadstruct_Vendas(sales,"../Vendas_1M.txt", m, tProd, tClientes);
	wrFileP(tProd, "../VendasVálidas.txt");

	/*Na querie 1 será necessário dar free das hash tables
	  e temos de ter em consideração que não podemos por
	  isto assim na main, precisamos de uma função que 
	  faça isto tudo logo (modularidade/encapsulamento).*/


//contar dados validos

	return 0;
}
