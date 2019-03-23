INC = ../include/
OBJ = ../src/

objects = $(OBJ)exe.o $(OBJ)valida.o $(OBJ)vendas.o $(OBJ)file.o $(OBJ)hash.o
CFLAGS = -g -Wall -ansi -std=c99 -pedantic -O2 
CC = gcc




SVG : $(objects)
	$(CC) $(CFLAGS) -o SVG $(objects) 

exe.o : $(INC)valida.h $(INC)vendas.h $(INC)file.h
valida.o : $(INC)valida.h $(INC)hash.h
vendas.o : $(INC)vendas.h
file.o : $(INC)file.h $(INC)valida.h
hash.o : $(INC)hash.h





.PHONY : clean
clean : 
	rm SVG $(objects)

