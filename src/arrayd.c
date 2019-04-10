#include "../include/arrayd.h"


//Tokenize, devolve o i e preenche o array tokens
int toktok(char * linha, char** tokens){
	char* tok = NULL;
	tok = strtok(linha, " ");
	int i = 0;

    for(i = 0; tok; i++){
    	if(i < 7)
    		tokens[i] = sdup(tok);
        tok = strtok(NULL," ");
    }

    return i;
}

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
}

//Função que devolve uma string numa dada posição, de uma estrutura do tipo Strings.
char* get_String(Strings s, int i){
	return s->string[i];
}

//Função que inicia uma estrutura Array
Array create_Array(){
	Array a = malloc(sizeof(Array));
	a->inUse = 0;
	a->freeSpace = 0;
	a->valor = NULL;

	return a;
}

//Função que inicia uma estrutura Array
Strings create_Strings(){
	Strings s = malloc(sizeof(Strings));
	s->inUse = 0;
	s->freeSpace = 0;
	s->string = NULL;
	return s;
}

//Função strdup criada para evitar warnings
char* sdup(const char *s){
	size_t tamanho = strlen (s) + 1;
	void *novo = malloc(tamanho);
	if(novo == NULL)
		return NULL;
	return (char *) memcpy (novo, s, tamanho);
}

//Função que liberta o Array
void free_Array(Array a){
	free(a);
}

// Função que realiza procura binaria num Array
int procura_binaria(Array a, int menor_posicao, int maior_posicao, int v){
	if (maior_posicao < menor_posicao)
		return -1;

	int meio = (menor_posicao + maior_posicao)/2;
	if (v == a->valor[meio])
		return meio;
	if (v > a->valor[meio])
		return procura_binaria(a, (meio + 1), maior_posicao, v);

	return procura_binaria(a, menor_posicao, (meio - 1), v);
}

// Função que realiza a inserção ordenada num Array
void insert_valor(Array a, int valor){
	int i;

	isFull(a);

	for (i = a->inUse - 1; ( i >= 0  && a->valor[i] > valor); i--)
		a->valor[i+1] = a->valor[i];

	a->valor[i+1] = valor;

	a->inUse++;
}

// Função que apaga um valor de um Array
void delete_valor(Array a, int n, int valor){
	int pos = procura_binaria(a, 0, n-1, valor); 
	
	if(pos == -1){ 
		printf("Element not found");
		exit(1);
	}

	int i;
	for(i = pos; i < n; i++)
		a->valor[i] = a->valor[i+1];

	a->inUse--;
}

//Função que inicia uma estrutura Array
Strings_Unidades create_StringsU(){
	Strings_Unidades s = malloc(sizeof(Strings_Unidades));
	s->inUse = 0;
	s->freeSpace = 0;
	s->string = NULL;
	s->unidades = NULL;

	return s;
}

//Função que verifica se o Array está cheio, aloca memória se estiver
void isFull_SU(Strings_Unidades s){

	if(s->inUse >= s->freeSpace){
		s->freeSpace += 1000;
		s->unidades = realloc(s->unidades, sizeof(int*) * s->freeSpace);
		s->string = realloc(s->string, sizeof(char*) * s->freeSpace);
	}
}

// Função que realiza a inserção ordenada num Array
void insert_string(Strings_Unidades s, char* c, int u){
	int i = 0;

	isFull_SU(s);
	for (i = s->inUse - 1; ( i >= 0  && s->unidades[i] < u); i--){
		s->unidades[i+1] = s->unidades[i];
		s->string[i+1] = sdup(s->string[i]);
	}

	s->unidades[i+1] = u;
	s->string[i+1] = sdup(c);
	s->inUse++;
}
