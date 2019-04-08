#ifndef __ARRAYD_H__
#define __ARRAYD_H__


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

typedef struct TAD_Array{
	int inUse;			//O que está a ser usado
	int freeSpace;		//O que está livre
	int* valor;			// Array de produtos neste caso
}*Array;

//Estrutura Array Dinamico
typedef struct strings{
	int inUse;			//O que está a ser usado
	int freeSpace;		//O que está livre
	char** string;		// Array de strings
}*Strings;

/**
 * Função que verifica se o Array está cheio, aloca memória se estiver.
 * @param Array
 */
void isFull(TAD_Array a);

/**
 * Função que verifica se o Array está cheio, aloca memória se estiver.
 * @param Strings
 */
void isFull_S(Strings s);

/**
 * Função que insere uma string no fim do array strings, alocando memoria se necessario.
 * @param Strings
 */
void string_append(Strings s, char* c);

//Função que inicia uma estrutura Array
Array create_Array();

//Função que inicia uma estrutura Array
Strings create_Strings();

//Função que devolve uma string numa dada posição, de uma estrutura do tipo Strings.
char* get_String(Strings s, int i);

/**
 * Função strdup criada para evitar warnings
 * @param string 
 */
char * sdup(const char *s);

/**
 * Função que liberta a memoria do Array.
 * @param Array
 */
void free_Array(TAD_Array a);

/**
 * Função que realiza procura binaria num Array.
 * @param Array, menor posição de procura (index), maior posição de procura (index), valor a procurar
 * @param retorna -1 se não encontrar, 0 se encontrar
 */
int procura_binaria(TAD_Array a, int menor_posicao, int maior_posicao, int valor);

/**
 * Função que realiza a inserção ordenada num Array.
 * @param Array, valor a inserir
 */
void insert_valor(TAD_Array a, int valor);

/**
 * Função que apaga um valor de um Array.
 * @param Array, numero de elementos do array, valor a apagar
 */
void delete_valor(TAD_Array a, int n, int valor);


#endif
