FLAGS = -std=c99 -Wall
SOURCES = charType.c
OBJECTS = charType.o
EXEBIN = charType

all: $(EXEBIN)

$(EXEBIN) : $(OBJECTS)
		gcc -o $(EXEBIN) $(OBJECTS)
		valgrind --leak-check=full charType charType.c outfile
$(OBJECTS) : $(SOURCES)
		gcc -c $(FLAGS) $(SOURCES)

clean :
		rm -f outfile  $(EXEBIN) $(OBJECTS)

