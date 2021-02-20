CC=gcc
CFLAGS=-O
OBJECTS=main.o

dump_constant_pool: $(OBJECTS)
	$(CC) $(OBJECTS) -o dump_constant_pool

main.o: main.c
	$(CC) -c $(CFLAGS) main.c

clean:
	rm -rf $(OBJECTS) dump_constant_pool
