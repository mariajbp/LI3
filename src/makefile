objects = valida.o vendas.o load.o
CFLAGS = -g -Wall -ansi -std=c99 -pedantic -O2
CC = gcc

.PHONY : clean

SVG : $(objects)
	$(CC) $(CFLAGS) -o SVG $(objects) 

vendas.o : vendas.c vendas.h
	$(CC) $(CFLAGS) vendas.c 

load.o : load.c load.h valida.h
	$(CC) $(CFLAGS) load.c load.h valida.h

valida.o : valida.c valida.h
	$(CC) $(CFLAGS) valida.c valida.h


clean : 
	rm SVG $(objects)


