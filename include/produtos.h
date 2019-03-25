#ifndef __PRODUTOS_H__
#define __PRODUTOS_H__

typedef struct profutos* PRODUTOS;

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
PRODUTO create_prod(char* code);

 /**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* get_code(PRODUTO p);


/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void free_cl(PRODUTO p);


#endif
