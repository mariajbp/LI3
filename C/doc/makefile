INC = ../include/
OBJ = ../src/


objects = $(OBJ)main.o $(OBJ)IO.o $(OBJ)catalogo_produtos.o $(OBJ)catalogo_clientes.o $(OBJ)vendas.o $(OBJ)faturacao.o $(OBJ)filial.o $(OBJ)arrayd.o
CFLAGS = -g -Wall -ansi -std=c99 -pedantic -O2 
CC = gcc


SGV : $(objects)
	$(CC) $(CFLAGS) -o SGV $(objects) 


main.o : $(INC)main.h $(INC)IO.o $(INC)catalogo_produtos.h $(INC)catalogo_clientes.h $(INC)vendas.h
IO.o : $(INC)IO.h $(INC)catalogo_produtos.h $(INC)catalogo_clientes.h $(INC)vendas.h $(INC)faturacao.h $(INC)filial.h $(INC)arrayd.h
vendas.o : $(INC)vendas.h $(INC)catalogo_produtos.h $(INC)catalogo_clientes.h $(INC)arrayd.h
catalogo_produtos.o : $(INC)catalogo_produtos.h $(INC)arrayd.h
catalogo_clientes.o : $(INC)catalogo_clientes.h $(INC)arrayd.h
faturacao.o : $(INC)faturacao.h $(INC)arrayd.h
filial.o : $(INC)filial.h $(INC)arrayd.h
arrayd.o : $(INC)arrayd.h



.PHONY : clean
clean : 
	rm SGV $(objects)

