package pl.edu.pjwstk.parser;
  
import java_cup.runtime.Symbol;

import static pl.edu.pjwstk.parser.ParserSymbols.*;

%%
%{ 
        private StringBuffer str;

        private Symbol createToken(int id) {
                return createToken(id, yytext());
        }
        
        private Symbol createToken(int id, Object o) {
                return new Symbol(id,o);
        }
        
        public int getPos() {
                return zzMarkedPos;     
        }
%}
 
%public
%class Lexer 
%cup
%line 
%column
%char
%eofval{
        return createToken(EOF);
%eofval}

INTEGER = [0-9]+
BOOLEAN = true|false
IDENTIFIER = [_a-zA-Z][0-9a-zA-Z]*
SPEC_IDENTIFIER = \$index

DOUBLE = [0-9]+\.[0-9]+
STRING = [\"][^\"]*[\"]
CHAR = [\'][^\"][\']
WHITESPACE = [ \t\r\n\v\f]+
LineTerminator = \r|\n|\r\n 
WHITESPACE = {LineTerminator} | [ \t\f]

%state IDENTIFIER13
%%
<YYINITIAL> {
        "+"                                             { return createToken(PLUS); }
        "-"                                             { return createToken(MINUS); }
        "*"                                             { return createToken(MULTIPLY); }
        "/"                                             { return createToken(DIVIDE); }
        "%"                                             { return createToken(MODULO); }
        "=="                                            { return createToken(EQUALS); }
        "!="                                            { return createToken(NOT_EQUALS); }
        "("                                             { return createToken(LEFT_ROUND_BRACKET); }
        ")"                                             { return createToken(RIGHT_ROUND_BRACKET); }  
        "{"                                             { return createToken(LEFT_CURLY_BRACKET); }
        "}"                                             { return createToken(RIGHT_CURLY_BRACKET); }
        "["                                             { return createToken(LEFT_BOX_BRACKET); }
        "]"                                             { return createToken(RIGHT_BOX_BRACKET); }
        ">"                                             { return createToken(MORE); }
        "OR"|"or"|"\|\|"                                { return createToken(OR); }
        "AND"|"and"|"&&"                                { return createToken(AND); }
        "XOR"|"xor"|"^^"                                { return createToken(XOR); }
        "SUM"|"sum"                                     { return createToken(SUM); }
        "AVG"|"avg"                                     { return createToken(AVG); }
        "UNIQUE"|"unique"                               { return createToken(UNIQUE); }
        "UNION"|"union"                                 { return createToken(UNION ); }
        "MIN"|"min"                                     { return createToken(MIN); }
        "MAX"|"max"                                     { return createToken(MAX); }
        "COUNT"|"count"                                 { return createToken(COUNT); }
        "AS"|"as"                                       { return createToken(AS); }
        "GROUP AS"|"group as"                           { return createToken(GROUP_AS); }
        "BAG"|"bag"                                     { return createToken(BAG); }
        "SEQUENCE"|"sequence"                           { return createToken(SEQUENCE); }
        ".."                                            { return createToken(RANGE); }
        "."                                             { return createToken(DOT); }
        "<"                                             { return createToken(LESS); }
        ">"                                            { return createToken(MORE); }
        ">="                                            { return createToken(MORE_OR_EQUAL); }
        "<="                                            { return createToken(LESS_OR_EQUAL); }
        ","                                             { return createToken(COMA); }
        "IN"|"in"                                       { return createToken(IN); }
        "WHERE"|"where"                                 { return createToken(WHERE); }
        "deref"|"DEREF"                                 { return createToken(DEREF); }
        "EXISTS"|"exists"                               { return createToken(EXISTS); }
        "NOT"|"not"|"!"                                 { return createToken(NOT); }
        "MINUS"|"minus"                                 { return createToken(MINUS_FUNCTION); }
        "STRUCT"|"struct"                               { return createToken(STRUCT); }
        "INTERSECT"|"intersect"                         { return createToken(INTERSECT); }
        "JOIN"|"join"                                   { return createToken(JOIN); }
        "ALL"|"all"                                     { return createToken(FORALL); }
        "ANY"|"any"                                     { return createToken(FORANY); }
        "ORDER BY"|"order by"                           { return createToken(ORDER_BY); }
        "ASC"|"asc"                                     { return createToken(GROUPBY_ASC); }
        "DESC"|"desc"                                   { return createToken(GROUPBY_DESC); }
        ";"                                             { return createToken(SEMICOLON); }
        "close by"|"CLOSE BY"                           { return createToken(CLOSE_BY); }
        "foreach"|"FOREACH"                             { return createToken(FOREACH); }
        "new"|"NEW"                                     { return createToken(NEW); }
        ":"                                             { return createToken(COLON); }
        "?"                                             { return createToken(QUESTION_MARK); }
        "INSTANCEOF"|"instanceof"                       { return createToken(INSTANCEOF); }
        "USING"|"using"                                 { return createToken(USING); }

        {WHITESPACE} { }
        {STRING} {return createToken(STRING_LITERAL, yytext().substring(1,yytext().length()-1)) ; }
        {CHAR}   {return createToken(CHAR_LITERAL, yytext().charAt(1)) ; }
        {INTEGER} {
                int val;
                try {
                        val = Integer.parseInt(yytext());
                }
                catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                }
                return createToken(INTEGER_LITERAL, new Integer(val));
        }
        {DOUBLE} {
                double val;
                try {
                        val = Double.parseDouble(yytext());
                }
                catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                }
                return createToken(DOUBLE_LITERAL, new Double(val));
        }
        {BOOLEAN} {
                boolean val;
                try {
                        val = Boolean.parseBoolean(yytext());
                }
                catch (Exception e) {
                        throw new RuntimeException(e.getMessage());
                }
                return createToken(BOOLEAN_LITERAL, new Boolean(val));
        }
        {IDENTIFIER} {
                                Symbol t = createToken(IDENTIFIER,yytext());
                                return t;
                        }
        {SPEC_IDENTIFIER} {
                Symbol t = createToken(IDENTIFIER,yytext());
                return t;
        }
}

/*
<IDENTIFIER> {
        {WHITESPACE} { }
        "ASC"|"asc" {
                yybegin(YYINITIAL);
                return createToken(yyline, yycolumn, zzCurrentPos, GROUPBY_ASC, new SyntaxTreeNode(yytext(), zzCurrentPos));
        } 
        "DESC"|"desc" {
                yybegin(YYINITIAL);
                return createToken(yyline, yycolumn, zzCurrentPos, GROUPBY_DESC, new SyntaxTreeNode(yytext(), zzCurrentPos));
        }
        
        .|\n {
                yypushback(yytext().length()); 
                yybegin(yyline, yycolumn, zzCurrentPos, YYINITIAL); 
        }
}
*/