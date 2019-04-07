#include "../include/catalogo_produtos.h"
#include "../include/catalogo_clientes.h"
#include "../include/vendas.h"
#include "../include/IO.h"
#include <time.h>



//Main do projeto
int main(){
	
	print_menu();

	if(escolhe_Query() == -1)
		return 0;
	  
	return 0;
}
