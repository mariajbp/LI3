INC = ../include/
OBJ = ../src/

objects = $(OBJ)exe.o $(OBJ)catalogoProdutos.o $(OBJ)catalogoClientes.o $(OBJ)tree.o
CFLAGS = -g -Wall -ansi -std=c99 -pedantic -O2 
CC = gcc


SVG : $(objects)
	$(CC) $(CFLAGS) -o SVG $(objects) 

exe.o : $(INC)catalogoProdutos.h $(INC)catalogoClientes.h
catalogoProdutos.o : $(INC)catalogoProdutos.h $(INC)tree.h
catalogoClientes.o : $(INC)catalogoClientes.h $(INC)tree.h  
tree.o : $(INC)tree.h





.PHONY : clean
clean : 
	rm SVG $(objects)



