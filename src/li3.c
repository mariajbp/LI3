#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* openFile()
{
	FILE *fptr;
	char* buff = malloc(sizeof(char)*1024);
	fptr = fopen("/Users/mariapires/Desktop/pli3/Produtos.txt", "r");
	fgets(buff, 7, fptr);
	fclose (fptr);
	printf("%s\n", buff );
	return buff;
} 

//if (maria doesnt know what to do)
//s	laptop = doesallthework();

