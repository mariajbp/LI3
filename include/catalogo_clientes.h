#ifndef __CATALOGO_CLIENTES_H__
#define __CATALOGO_CLIENTES_H__


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

typedef struct clientes* Clientes;

// Função que verifica se um id existe na estrutura
int search_C(Clientes c, char id[]);

//Função que inicia uma estrutura clientes
Clientes init_Clientes(int* num);

#endif
