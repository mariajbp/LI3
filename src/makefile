objects = valida.o load.o vendas.o
CFLAGS = -g -Wall
CC = gcc

.PHONY : clean

SVG : $(objects)
	$(CC) $(CFLAGS) -o SVG $(objects) 

valida.o : valida.c valida.h
	$(CC) $(CFLAGS) valida.c

load.o : load.c load.h valida.h
	$(CC) $(CFLAGS) load.c

vendas.o : vendas.c vendas.h
	$(CC) $(CFLAGS) vendas.c

clean : 
	rm SVG $(objects)


