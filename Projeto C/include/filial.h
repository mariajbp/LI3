#ifndef __FILIAL_H__
#define __FILIAL_H__

#include <stdlib.h>
#include <string.h>
#include "arrayd.h"
#include <time.h>


/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Strings comprados_Filial(char* path, int f);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Strings naoComprado(char* path, Strings comprados);

/**
 * Função que realiza procura por filial numa Strings
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int procura_cliente(Strings s[3], char* cl);

/**
 * Função que realiza insercao por filial numa Strings
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void insert_stringF(Strings s[3], char* c, int f);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int le_Clientes(char* path, Strings s);

/**
 * Lê os clientes válidos para um array
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
int le_Vendas(char* path, Strings s[3]);

/**
 * O QUE FAZ
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
void filter_CF(Strings f[3], Strings clientes, Strings f1);


/**
 * determinar as vendas de um produto numa filial
 * @param O QUE RECEBE
 * @param O QUE RETORNA
 */
Strings getVendasProdFilial(char* path, char* code, int f);

/**
 * Funcao que recolhe as vendas de um cliente num determinado mes
 * @param ficheiro vendas, codigo de produto e o mes
 * @param estrutura com produtos
 */
Strings_Unidades CinM_comprou(char* path, char* code, int mes);

/**
 * Cria a lista de produtos comprados por um cliente num mes
 * @param ficheiro vendas, codigo de produto e o mes
 */
void cria_listaProdutos(char* path, char* ccode, int mes);

#endif
