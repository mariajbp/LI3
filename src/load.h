#ifndef __LOAD_H__
#define __LOAD_H__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>



char** lArray( char** array, char* path, int max, int (*valida) (char, ...) );


int linecount(char* path);
#endif