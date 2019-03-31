INC = ../include/
OBJ = ../src/

objects = $(OBJ)exe.o $(OBJ)catalogoClientes.o $(OBJ)catalogoProdutos.o $(OBJ)tree.o
CFLAGS = -g -Wall -ansi -std=c99 -pedantic -O2 
CC = gcc


SVG : $(objects)
	$(CC) $(CFLAGS) -o SVG $(objects) 

exe.o : $(INC)catalogoProdutos.h $(INC)catalogoClientes.h
catalogoClientes.o : $(INC)catalogoClientes.h $(INC)tree.h 
catalogoProdutos.o : $(INC)catalogoProdutos.h $(INC)tree.h 
tree.o : $(INC)tree.h





.PHONY : clean
clean : 
	rm SVG $(objects)



