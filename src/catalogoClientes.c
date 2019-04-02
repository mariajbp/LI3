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

	c = abs(c % 599);

	index[0] = value[0] - 65;
	//printf("\tHASH__%c%d\n", value[0],c );
	index[1] = c;
}

// Função que insere um index, de tipologia Cliente, numa estrutura de dados
void insert_Cliente(Tree clientes[26][599], char id[]){
	int index[2]; index[0] = 0, index[1] = 0;
	int nID = num(id,1);
	hF_Clientes(index, id);

	insert_tree(clientes[index[0]][index[1]] , nID);
}

// Função que, aplicando a Hash Funtion, verifica se uma posição da Treetable existe
int search_C(Tree clientes[26][599], char id[]){
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
		num += fprint_clientes(fp,l1,esq(arvore));
		if(valor(arvore) > 1){
			fprintf(fp,"%c%d\r\n", pL,valor(arvore));
			num++;
		}
		num += fprint_clientes(fp,l1,dir(arvore));
	}

	return num;  // retorna o num de elementos que printou
}

//Faz load de um ficheiro no array RETORNA QUANTO ESCREVEU NO ARRAY (para a função wrfile)
int loadHash_Clientes(Tree clientes[26][599], char* path){
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
int  wrFileC (Tree clientes[26][599], char* path){
	int r = 0;
	FILE* fp = fopen(path, "w+");
	
	if(fp == NULL){
		printf("Error! Couldn't find file point to write Clientes");
		return 0;
	}
	
	for(int letra = 0; letra < 26; letra++)
		for(int h = 0; h < 599; h++)
			r += fprint_clientes(fp,letra,clientes[letra][h]);

	fclose(fp);	

	return r;
}


int create_clientes(Tree clientes[26][599], char* path){
	char linha[6];
	int i = 0;
	FILE* file = fopen(path , "r");
	
	if(file == NULL){
    	printf("Error! You tried to read an empty file.");   
    	return 0;             
    }

	while( fgets(linha, 6, file) ){
		insert_Cliente(clientes,linha);
		i++;
	}

	return i;
}

void destroyCCL(Tree cat_Clientes[26][599]){
	free(cat_Clientes);
}

//Função que inicializa as estruturas, escreve na posição 0 e 1 do array
void init_Clientes(int* num, Tree clientes[26][599]){

	for (int i = 0; i < 26; i++)
		for (int j = 0; j < 599; j++)
			clientes[i][j] = create_nodo(1);

	num[0] = loadHash_Clientes(clientes,"../Clientes.txt");
	num[1] = wrFileC(clientes, "../ClientesVálidos.txt");
}