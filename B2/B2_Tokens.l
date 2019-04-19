%{
   /*Lexical analysis phase of a compiler*/
%}

WS [ \n\t]+
DIGIT [0-9]
NUMBER {DIGIT}+|{DIGIT}"."{DIGIT}+
LETTER [A-Za-z]
SYMBOL "_"
IDENTIFIER {LETTER}({LETTER}|{DIGIT}|{SYMBOL})*
ACCESS "public"|"private"|"protected"|""
CONDITIONAL "if"|"else"|"else if"|"switch"|"case"
ITERATIVE "for"|"while"|"do"
REL_OP ">"|"<"|">="|"<="|"=="
ARITH_OP "+"|"-"|"/"|"*"|"%"
LOG_OP "&&"|"||"|"!="
UNARY_OP "++"|"--"
KEYWORD "class"|"static"|"try"|"catch"|"throw"|"throws"|"main"
DATATYPE "int"|"double"|"float"|"String"|"char"|"void"
FUNCTION {ACCESS}{DATATYPE}{IDENTIFIER}"("({DATATYPE}{IDENTIFIER})*")"
IMPORT "import"[^\n]*";"
COMMENT "/*"[^\n]*"*/"|"//".*\n
PRINT_STMT "System.out.print"|"System.out.println"
SC ";"

%%
{WS} ;
{COMMENT} ;
{NUMBER} {printf("%s \t\t\t==> NUMBER\n", yytext);}
{PRINT_STMT} {printf("%s \t==> PRINT STATEMENT\n", yytext);}
{ACCESS} {printf("%s \t\t\t==> ACCESS SPECIFIER\n", yytext);}
{CONDITIONAL} {printf("%s \t\t\t==> CONDITIONAL STATEMENT\n", yytext);}
{ITERATIVE} {printf("%s \t\t\t==> ITERATIVE STATEMENT\n", yytext);}
{REL_OP} {printf("%s \t\t\t==> RELATIONAL OPERATOR\n", yytext);}
{ARITH_OP} {printf("%s \t\t\t==> ARITHMETIC OPERATER\n", yytext);}
{UNARY_OP} {printf("%s \t\t\t==> UNARY OPERATOR\n", yytext);}
{DATATYPE} {printf("%s \t\t\t==> DATA TYPE\n", yytext);}
{FUNCTION} {printf("%s \t\t\t==> FUNCTION\n", yytext);}
{IMPORT} {printf("%s \t==> IMPORT STATEMENT\n", yytext);}
{KEYWORD} {printf("%s \t\t\t==> KEYWORD\n", yytext);}
{LOG_OP} {printf("%s \t\t\t==> LOGICAL OPERATOR\n", yytext);}
{SC} {printf("%s \t\t\t==> SEMI-COLON\n", yytext);}
{IDENTIFIER} {printf("%s \t\t\t==> IDENTIFIER\n", yytext);}
"=" {printf("%s \t\t\t==> ASSIGNMENT OPERATOR\n", yytext);}
"}" {printf("%s \t\t\t==> END BLOCK\n", yytext);}
"{" {printf("%s \t\t\t==> OPEN BLOCK\n", yytext);}
"(" {printf("%s \t\t\t==> OPEN PARENTHESIS\n", yytext);}
")" {printf("%s \t\t\t==> CLOSE PARENTHESIS\n", yytext);}
. ;
%%

main()
{
	extern FILE *yyin;
	yyin = fopen("input", "r");
	yylex();
	fclose(yyin);
}
int yywrap()
{
	return 1;
}
