#ifndef __VALIDA_H__
#define __VALIDA_H__

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

//função que valida um id de um produto
int validaProduto(char * id, int i);

//função que valida um id de um cliente
int validaCliente(char * id, int i);

// função que valida se uma string está no array de strings
int searchID(const char * lista[], const char * id);

//função que valida um id de uma venda
int validaVenda(char* linha, const char* produtos[], const char* clientes[]);


#endif