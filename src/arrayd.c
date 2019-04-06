#include "../include/arrayd.h"


//Função que verifica se o Array está cheio, aloca memória se estiver
void isFull(Array a){

	if(a->inUse >= a->freeSpace){
		a->freeSpace += 1000;
		a->valor = realloc(a->valor, sizeof(int*) * a->freeSpace);
	}
}

//Função que verifica se o Array está cheio, aloca memória se estiver
void isFull_S(Strings s){

	if(s->inUse >= s->freeSpace){
		s->freeSpace += 100000;
		s->string = realloc(s->string, sizeof(char*) * s->freeSpace);
	}
}

//Função que insere uma string no fim do array Strings (alocando memória se necessário)
void string_append(Strings s, char* c){

	isFull_S(s);
	s->string[s->inUse++] = sdup(c);

	s->inUse++;
}

//Função strdup criada para evitar warnings
char * sdup(const char *s){
	size_t len = strlen (s) + 1;
	void *new = malloc (len);
	if (new == NULL)
		return NULL;
	return (char *) memcpy (new, s, len);
}

//Função que liberta o Array
void free_Array(Array a){
	free(a);
}

// Função que realiza procura binaria num Array
int procura_binaria(Array array, int menor_posicao, int maior_posicao, int valor){
	if (maior_posicao < menor_posicao)
		return -1;

	int meio = (menor_posicao + maior_posicao)/2;
	if (valor == array->valor[meio])
		return meio;
	if (valor > array->valor[meio])
		return procura_binaria(array, (meio + 1), maior_posicao, valor);

	return procura_binaria(array, menor_posicao, (meio - 1), valor);
}

// Função que realiza a inserção ordenada num Array
void insert_valor(Array array, int valor){
	int i;

	isFull(array);

	for (i = array->inUse - 1; ( i >= 0  && array->valor[i] > valor); i--)
		array->valor[i+1] = array->valor[i];

	array->valor[i+1] = valor;

	array->inUse++;
}

// Função que apaga um valor de um Array
void delete_valor(Array array, int n, int valor){
	int pos = procura_binaria(array, 0, n-1, valor); 
	
	if(pos == -1){ 
		printf("Element not found");
		exit(1);
	}

	int i;
	for(i = pos; i < n; i++)
		array->valor[i] = array->valor[i+1];

	array->inUse--;
}