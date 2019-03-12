objects = valida.o vendas.o load.o
CFLAGS = -g -Wall -ansi -std=c99 -pedantic -O2
CC = gcc



SVG : $(objects)
	$(CC) $(CFLAGS) -o SVG $(objects) 


valida.o :  valida.h
vendas.o : vendas.h
load.o : load.h valida.h




.PHONY : clean
clean : 
	rm SVG $(objects)


