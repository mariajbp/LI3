#ifndef __CLIENTES_H__
#define __CLIENTES_H__

typedef struct clientes* CLIENTES;

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
CLIENTE create_cl(char* code);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
char* get_code(CLIENTE cl);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void free_cl(CLIENTE cl);



#endif
