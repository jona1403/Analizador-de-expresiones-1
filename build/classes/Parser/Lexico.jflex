package Parser;
import java_cup.runtime.Symbol; 
import App.AppFrame;
%% 
%class Lexico
%public 
%line 
%char 
%cup 
%unicode

%init{ 
    yyline = 1; 
    yychar = 1; 
%init} 

BLANCOS=[ \r\t]+
D=[0-9]+
DD=[0-9]+("."[  |0-9]+)?
LETR = [A-Za-z0-9]
ID =   [A-Za-z0-9_]+
RCONCOMA = [\!-\}](","[\!-\}])*
T = \"([^\"])*\"
CMUL = \<\!([^\"])*\!\>
CUL = (\/)(\/)(.)*
SEP = (\%)(\%)
SL = (\\)(n)
CS = (\\)(\')
CD = (\\)(\")
CONCAT = (\.) 


%%

"CONJ" {return new Symbol(sym.CONJ,yyline,yychar,yytext());} 
":" {return new Symbol(sym.DOSPT,yyline,yychar,yytext());}
";" {return new Symbol(sym.PTCOMA,yyline,yychar,yytext());}
"->" {return new Symbol(sym.ASIGN,yyline,yychar,yytext());}
"{" {return new Symbol(sym.LLAVEIZQ,yyline,yychar,yytext());}
"}" {return new Symbol(sym.LLAVEDER,yyline,yychar,yytext());}
"|" {return new Symbol(sym.DISYUNCION,yyline,yychar,yytext());}
"*" {return new Symbol(sym.KLEEN,yyline,yychar,yytext());}
"+" {return new Symbol(sym.CERRADURAMAS,yyline,yychar,yytext());}
"?" {return new Symbol(sym.CERRADURAINTER,yyline,yychar,yytext());}
"~" {return new Symbol(sym.HASTA,yyline,yychar,yytext());}
\n {yychar=1;}

{BLANCOS} {} 
{LETR} {return new Symbol(sym.SIMBOLO,yyline,yychar, yytext());}
{ID} {return new Symbol(sym.IDENTIFICADOR,yyline,yychar,yytext());}

{D} {return new Symbol(sym.ENTERO,yyline,yychar, yytext());} 

{DD} {return new Symbol(sym.DECIMAL,yyline,yychar, yytext());}

{T} {return new Symbol(sym.TODOS,yyline,yychar, yytext());} 

{SEP} {return new Symbol(sym.SEPARADOR,yyline,yychar, yytext());}

{SL} {return new Symbol(sym.RESALTOLINEA,yyline,yychar, yytext());}
{CS} {return new Symbol(sym.RECOMILLASIMPLE,yyline,yychar, yytext());}
{CD} {return new Symbol(sym.RECOMILLASDOBLES,yyline,yychar, yytext());}
{CONCAT} {return new Symbol(sym.CONCATENACION,yyline,yychar, yytext());}
{RCONCOMA} {return new Symbol(sym.RRCONCOMA,yyline,yychar, yytext());}

{CUL} {}
 
{CMUL} {}


. {
    AppFrame.tbErrores.setError(AppFrame.contadorErrores++, "Léxico", "No se esperaba "+yytext(), yyline, yychar);
    /*System.out.println("Este es un error lexico: "+yytext()+
    ", en la linea: "+yyline+", en la columna: "+yychar);*/
}

