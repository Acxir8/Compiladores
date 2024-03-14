package fes.aragon.profe.jflex;
import static fes.aragon.tareas.tarea08.Tokens.*;
%%
%class Lexico
%type Tokens
L=[a-zA-Z]
D=[0-9]
WHITE=[\t\r\n]
%{
    public String lexema;
%}
%%
{WHITE} {/* NO HACER NADA */}
" " { }
"or" {return OR;}
"and" {return AND;}
"not" {return NOT;}
")" {return CIERREPARENTESIS;}
"(" {return ABREPARENTESIS;}
"true" {return TRUE;}
"false" {return FALSE;}
";" {return PUNTOYCOMA;}
. {return ERROR;}