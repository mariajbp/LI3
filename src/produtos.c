#include "../include/produtos.h"

struct produto
{
	char* code;
};

PRODUTO create_prod(char* code)
{
	PRODUTO p = malloc(sizeof(struct Produto));
	prod->code = strdup(code);
}

char* get_code(PRODUTO p)
{
	return p->code;
}

void free_cl(PRODUTO p)
{
	free(p);
}