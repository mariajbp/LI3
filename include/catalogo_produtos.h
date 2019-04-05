#ifndef __CATALOGO_PRODUTOS_H_
#define __CATALOGO_PRODUTOS_H__


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

typedef struct produtos *Produtos;

// Função que verifica se um id existe na estrutura
int search_P(Produtos p, char id[]);

//Função que inicia uma estrutura produtos
Produtos init_produtos(int* num);

#endif
