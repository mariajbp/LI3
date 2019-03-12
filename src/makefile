objects = valida.o load.o vendas.o
CFLAGS = -g -Wall -ansi -std=c99 -pedantic -O2
CC = gcc

.PHONY : clean

SVG : $(objects)
	$(CC) $(CFLAGS) -o SVG $(objects) 

load.o : load.c load.h valida.h
	$(CC) $(CFLAGS) load.c load.h valida.h

valida.o : valida.c valida.h
	$(CC) $(CFLAGS) valida.c valida.h

vendas.o : vendas.c vendas.h
	$(CC) $(CFLAGS) vendas.c 

clean : 
	rm SVG $(objects)


