package lang.ast; // The generated scanner will belong to the package lang.ast

import lang.ast.LangParser.Terminals; // The terminals are implicitly defined in the parser
import lang.ast.LangParser.SyntaxError;

%%

// define the signature for the generated scanner
%public
%final
%class LangScanner
%extends beaver.Scanner

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol 
%function nextToken 

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}

// macros
WhiteSpace = [ ] | \t | \f | \n | \r
ID = [a-zA-Z][a-zA-Z0-9]*
Numeral = ([1-9][0-9]*|0)("." [0-9]*[1-9])?
Comment = "//"[^\n]*\n

%%

// discard whitespace information
{WhiteSpace}  { }
{Comment} { }

// token definitions
"int"         { return sym(Terminals.INT); }
"("	      { return sym(Terminals.LPAR); }
")"	      { return sym(Terminals.RPAR); }
"{"	      { return sym(Terminals.LBRA); }
"}"	      { return sym(Terminals.RBRA); }
"+"	      { return sym(Terminals.ADD); }
"*"	      { return sym(Terminals.MUL); }
"-"	      { return sym(Terminals.SUB); }
"/"	      { return sym(Terminals.DIV); }
"%"	      { return sym(Terminals.MOD); }
"<"	      { return sym(Terminals.LE); }
">"           { return sym(Terminals.GE); }
"=="	      { return sym(Terminals.EQUALS); }
"!="	      { return sym(Terminals.NOT); }
"<="	      { return sym(Terminals.LEQ); }
">="	      { return sym(Terminals.GEQ); }
"="	      { return sym(Terminals.ASSIGN); }
";"	      { return sym(Terminals.SEMICOLON); }
","	      { return sym(Terminals.COMMA); }
"while"       { return sym(Terminals.WHILE); }
"if"          { return sym(Terminals.IF); }
"else"        { return sym(Terminals.ELSE); }
"return"      { return sym(Terminals.RETURN); }	
{ID}          { return sym(Terminals.ID); }
{Numeral}     { return sym(Terminals.NUMERAL);}
<<EOF>>       { return sym(Terminals.EOF); }

/* error fallback */
[^]           { throw new SyntaxError("Illegal character <"+yytext()+">"); }
