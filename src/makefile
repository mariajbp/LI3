objects = exe.o valida.o vendas.o file.o
CFLAGS = -g -Wall -ansi -std=c99 -pedantic -O2
CC = gcc



SVG : $(objects)
	$(CC) $(CFLAGS) -o SVG $(objects) 

exe.o : valida.h vendas.h file.h
valida.o :  valida.h
vendas.o : vendas.h
file.o : file.h valida.h




.PHONY : clean
clean : 
	rm SVG $(objects)


