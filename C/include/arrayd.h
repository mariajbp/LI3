#ifndef __ARRAYD_H__
#define __ARRAYD_H__


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

//Estrutura Array Dinamico
typedef struct array{
	int inUse;			//O que está a ser usado
	int freeSpace;		//O que está livre
	int* valor;			// Array de produtos neste caso
}*Array;

//Estrutura Strings Dinamica
typedef struct strings{
	int inUse;			//O que está a ser usado
	int freeSpace;		//O que está livre
	char** string;		// Array de strings
}*Strings;

//Estrutura Strings Dinamica
typedef struct strings_u{
	int inUse;			//O que está a ser usado
	int freeSpace;		//O que está livre
	char** string;		// Array de strings
	int* unidades;
}*Strings_Unidades;

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int toktok(char * linha, char** tokens);

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
 * Função que inicia uma estrutura Array
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Array create_Array();


/**
 * Função que inicia uma estrutura Array
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Strings create_Strings();

/**
 * Função que devolve uma string numa dada posição, de uma estrutura do tipo Strings.
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
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

Strings_Unidades create_StringsU();

//Função que verifica se o Array está cheio, aloca memória se estiver
void isFull_SU(Strings_Unidades s);

// Função que realiza a inserção ordenada num Array
void insert_string(Strings_Unidades s, char* c, int u);

#endif
