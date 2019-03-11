
#ifndef vendas_h
#define vendas_h


typedef struct venda * VENDA;

/**
 * o que faz 
 * @param  
 * @returns uma Venda
 */

VENDA createVenda();


/**
 * Retorna o código do cliente
 * @param 
 * @returns o código do cliente
 */
char* getPcode(VENDA v);

/**
 * Retorna o preço de um produto
 * @param  
 * @returns o preço de um produto
 */
double getPrice(VENDA v)

/**
 * o que faz
 * @param  
 * @returns o nº de unidades vendidas
 */
int getUnits(VENDA v)


/**
 * o que faz
 * @param  
 * @returns o tipo de venda (Promoção ou Normal)
 */
char getNP(VENDA  v)


 /**
 * o que faz
 * @param  
 * @returns o código do cliente
 */
char* getCLcode(VENDA v)


/**
 * o que faz
 * @param  
 * @returns o mês da venda
 */
int getMonth(VENDA v)

/**
 * o que faz
 * @param  
 * @returns o nº da filial onde foi efetuada a comprada
 */
int getFilial(VENDA v)



/**
 * o que faz
 * @param  
 * @returns 
 */


/**
 * o que faz
 * @param  
 * @returns 
 */





#endif