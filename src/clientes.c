#include "../include/clientes.h"

struct cliente
{
	char* code;
};

CLIENTE create_cl(char* code)
{
	CLIENTE cl = malloc(sizeof(struct Cliente));
	cl->code = strdup(code);
}

char* get_code(CLIENTE cl)
{
	return cl->code;
}

void free_cl(CLIENTE cl)
{
	free(cl);
}

