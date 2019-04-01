INC = ../include/
OBJ = ../src/

objects = $(OBJ)exe.o $(OBJ)IO.o $(OBJ)catalogoProdutos.o $(OBJ)catalogoClientes.o $(OBJ)vendas.o $(OBJ)tree.o
CFLAGS = -g -Wall -ansi -std=c99 -pedantic -O2 
CC = gcc


SGV : $(objects)
	$(CC) $(CFLAGS) -o SGV $(objects) 


exe.o : $(INC)IO.o $(INC)catalogoProdutos.h $(INC)catalogoClientes.h $(INC)vendas.h
IO.o : $(INC)IO.h $(INC)catalogoProdutos.h $(INC)catalogoClientes.h $(INC)vendas.h $(INC)tree.h
vendas.o : $(INC)vendas.h $(INC)catalogoProdutos.h $(INC)catalogoClientes.h $(INC)tree.h
catalogoProdutos.o : $(INC)catalogoProdutos.h $(INC)tree.h
catalogoClientes.o : $(INC)catalogoClientes.h $(INC)tree.h
tree.o : $(INC)tree.h



.PHONY : clean
clean : 
	rm SGV $(objects)

