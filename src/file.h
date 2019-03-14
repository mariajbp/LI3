#ifndef __FILE_H__
#define __FILE_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


//Função que valida os dados de um ficheiro e os guarda num array
int loadArray( char** array, char* path, int max, int (*valida) (char, ...) );

//Função que dado um ficheiro conta as linhas
int linecount(char* path);

//Função que escreve os dados válidos num ficheiro (Produtos)
int wrFileP (char** array, int n);

//Função que escreve os dados válidos num ficheiro (Clientes)
int wrFileC (char** array, int n);

//Função que escreve os dados válidos num ficheiro (Vendas)
int wrFileV (char** array, int n);

#endif
