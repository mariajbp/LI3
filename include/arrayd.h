#ifndef __ARRAYD_H__
#define __ARRAYD_H__


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

typedef struct array
{
	int inUse;			//O que está a ser usado
	int freeSpace;		//O que está livre
	int* valor;			// Array de produtos neste caso
} *Array;

//Estrutura Array Dinamico
typedef struct strings
{
	int inUse;			//O que está a ser usado
	int freeSpace;		//O que está livre
	char** string;		// Array de strings
} *Strings;

/**
 * Função que verifica se o Array está cheio, aloca memória se estiver.
 * @param Array
 */
void isFull(Array a);

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

/**
 * Função strdup criada para evitar warnings
 * @param string 
 */
char * sdup(const char *s);

/**
 * Função que liberta a memoria do Array.
 * @param Array
 */
void free_Array(Array a);

/**
 * Função que realiza procura binaria num Array.
 * @param Array, menor posição de procura (index), maior posição de procura (index), valor a procurar
 * @param retorna -1 se não encontrar, 0 se encontrar
 */
int procura_binaria(Array array, int menor_posicao, int maior_posicao, int valor);

/**
 * Função que realiza a inserção ordenada num Array.
 * @param Array, valor a inserir
 */
void insert_valor(Array array, int valor);

/**
 * Função que apaga um valor de um Array.
 * @param Array, numero de elementos do array, valor a apagar
 */
void delete_valor(Array array, int n, int valor);


#endif
