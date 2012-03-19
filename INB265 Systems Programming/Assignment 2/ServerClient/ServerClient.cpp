#include <stdio.h>
 
typedef struct {
	char *name;
	char *country;
	int innings;
	int runs;
	int nout;	
	int hscore;
	int hscorenout;
} player;


int main() {
	FILE *f;
	f = fopen("batting.txt","w");
	fprintf(f,"Hello");
	fclose(f);
	return 0;
}