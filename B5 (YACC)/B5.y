%{
#include<stdio.h>
void yyerror(char*);
int yylex();
FILE* yyin;
%}

%token NOUN PRONOUN ADJECTIVE VERB ADVERB CONJUNCTION PREPOSITION ARTICLE

%%
sentence: compound { printf("*******COMPOUND SENTENCE*******\n");}
	|
	simple {printf("*******SIMPLE SENTENCE*******\n");}
	;
simple: subject VERB ARTICLE object;

compound: subject VERB ARTICLE object CONJUNCTION subject VERB ARTICLE object| subject VERB ARTICLE object CONJUNCTION ARTICLE object;

subject: NOUN|PRONOUN;

object: NOUN|ADJECTIVE NOUN|ADVERB NOUN|PREPOSITION NOUN;
%%
void yyerror(char *s)
{
printf("ERROR:%s\n",s);
}
int main(int argc,char* argv[])
{
yyin=fopen("input.txt","r");
yyparse();
fclose(yyin);
return 0;
}
