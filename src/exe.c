#include "../include/catalogo_produtos.h"
#include "../include/catalogo_clientes.h"
#include "../include/vendas.h"
#include "../include/IO.h"
#include <time.h>



//Main do projeto
int main(){
	int num[6];
	
	print_menu();

	if(escolhe_Tarefa() == -1)
		return 0;

	/*Na querie 1 será necessário dar free das hash tables
	  e temos de ter em consideração que não podemos por
	  isto assim na main, precisamos de uma função que 
	  faça isto tudo logo (modularidade/encapsulamento).*/
	  
	return 0;
}
