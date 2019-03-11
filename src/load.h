#ifndef __LOAD_H__
#define __LOAD_H__


char** loadArray( char** array, char* path, const char id, int max, const char* produtos[], const char* clientes[]);


char** lArray( char** array, char* path, int max, int (*valida) (char, ...) );


int linecount(char* path);
#endif