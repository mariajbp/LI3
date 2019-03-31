#include "../include/catalogoClientes.h"


//função que valida um id de um cliente
int validaCliente(char * id){
	int r = 0;
			if(isupper(id[0]))											//Se a primeiros carateres sao maiusculas 		
				if(('1'<=id[1]) && (id[1]<='5'))						//Se a 2ª posição é entre 1 e 5
					for(int n = 2; n < 4; n++){
						if(isdigit(id[n])) r = 1;
						else return 0;
					}
	return r;
}

// Função que dado uma string (valor), devolve uma posição (index, hash key)
void hF_Clientes(int index[], char value[]){
	int s = 0, c = 0;
	for(int i = 1; i < strlen(value); i++){
		s = value[i]; c+=s; c*=s;
	}

	c = abs(c % 307);

	index[0] = value[0] - 65;
	//printf("\tHASH__%c%d\n", value[0],c % 307);
	index[1] = c;
}

// Função que insere um index, de tipologia Cliente, numa estrutura de dados
void insert_Cliente(Tree clientes[26][307], char id[]){
	int index[2]; index[0] = 0, index[1] = 0;
	int nID = num(id,1);
	hF_Clientes(index, id);

	insert_tree(clientes[index[0]][index[1]] , nID);
}

// Função que, aplicando a Tree funtion, verifica se uma posição da Treetable existe
int search_C(Tree clientes[26][307], char id[]){
	int r = 0, nID = num(id,1);
	int index[2]; index[0] = 0, index[1] = 0;
	hF_Clientes(index,id);

	r = search_tree(clientes[index[0]][index[1]], nID);
	
	return r;
}

// Função que imprime uma arvore por ordem dos elementos
int fprint_clientes(FILE* fp, int l1, Tree arvore){
	char pL = l1+'A';
	int num = 0;

	if(arvore){
		num += fprint_clientes(fp,l1,arvore->esq);
		if(arvore->valor){
			fprintf(fp,"%c%d\r\n", pL, arvore->valor);
			num++;
		}
		num += fprint_clientes(fp,l1,arvore->dir);
	}

	return num;  // retorna o num de elementos que printou
}

//Faz load de um ficheiro no array RETORNA QUANTO ESCREVEU NO ARRAY (para a função wrfile)
int loadHash_Clientes(Tree clientes[26][307], char* path, int max){
	char linha[7];
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
      	printf("Error! You tried to read an empty file.");   
     	return 0;             
    }
	while( fgets(linha, 6, file) ){
		if(validaCliente(linha)){
			insert_Cliente(clientes,linha);
			i++;
		}
	}

	return i;
}

//Função que escreve uma tabela de Trees num ficheiro
int  wrFileC (Tree clientes[26][307], char* path){
	int r = 0, i = 0;
	FILE* fp = fopen(path, "w+");
	
	if(fp == NULL){
		printf("Error! Couldn't find file point to write Clientes");
		return 0;
	}
	
	for(int letra = 0; letra < 26; letra++)
		for(int h = 0; h < 307; h++){
			i = fprint_clientes(fp,letra,clientes[letra][h]);
			r+=i;
		}

	fclose(fp);	

	return r;
}


int create_clientes(Tree cat_Clientes[26][307], char* path){
	char linha[6];
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
    	printf("Error! You tried to read an empty file.");   
    	return 0;             
    }

	while( fgets(linha, 6, file) ){
		insert_Cliente(cat_Clientes,linha);
		i++;
	}

	return i;
}

void destroyCCL(Tree cat_Clientes[26][307]){
	free(cat_Clientes);
}

//Função que inicializa as estruturas, escreve na posição 0 e 1 do array
void init_Clientes(int* num){
	int max = 0;

	Tree tClientes[26][307];
	for (int i = 0; i < 26; i++)
		for (int j = 0; j < 307; j++)
			tClientes[i][j] = malloc(sizeof(Tree));

	num[0] = loadHash_Clientes(tClientes,"../Clientes.txt", max);
	num[1] = wrFileC(tClientes, "../ClientesVálidos.txt");
}