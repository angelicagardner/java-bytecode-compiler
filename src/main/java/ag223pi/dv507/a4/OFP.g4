grammar OFP;

@header {    
    package ag223pi.dv507.a2;
}

////////////////////////////////////////////////
// Syntax Specification ==> Context-free Grammar

program                     :   function*
                                main 
                                function*
                                EOF
                            ;

main                        :   mainDeclaration '{' 
                                (function | statement | expression)*
                                '}'
                            ;

mainDeclaration             :   VOID MAIN '(' ')' ;

function                    :   functionDeclaration '{'
                                (statement | expression)*
                                '}'
                            ;

functionDeclaration         :   (dataType | VOID) id '(' parameters? ')'
                            ;

parameters                  :   (dataType id ','?)+
                            ;

arguments                   :   ((comparisson | calculation | literal | id) ','?)+
                            ;

dataType                    :   INT ('[' calculation? ']')?
                            |   FLOAT ('[' calculation? ']')?
                            |   BOOLEAN 
                            |   CHAR ('[' calculation? ']')?
                            |   STRING
                            ;

id                          :   IDENTIFIER
                            ;

literal                     :   INTEGER_LITERAL  
                            |   FLOAT_LITERAL 
                            |   CHAR_LITERAL
                            |   BOOLEAN_LITERAL
                            |   STRING_LITERAL
                            ;

statement                   :   varDeclaration
                            |   varInitialization
                            |   varAssignment
                            |   printStmt
                            |   whileStmt
                            |   ifStmt elseifStmt* elseStmt?
                            |   returnStmt
                            ;

varDeclaration              :   dataType id ';'
                            ;

varInitialization           :   dataType id ASSIGN (expression | calculation+ | literal | id) ';'
                            ;

varAssignment               :   id ('[' id? ']')? ASSIGN (calculation | literal | id) ';'
                            ;

printStmt                   :   ('println' | 'print') '(' (id | literal | arrayExpression) ')' ';'
                            ;

whileStmt                   :   WHILE '(' comparisson ')' '{' (statement | expression)+ '}'
                            ;

ifStmt                      :   IF '(' (comparisson | functionInvocation | literal | id) ')' '{' (statement | expression)+ '}'
                            |   IF '(' (comparisson | functionInvocation | literal | id) ')' (statement | expression)
                            ;

elseifStmt                  :   ELSE_IF '(' comparisson ')' '{' (statement | expression)+ '}'
                            |   ELSE_IF '(' comparisson ')' (statement | expression)
                            ;

elseStmt                    :   ELSE '{' (statement | expression)+ '}'
                            |   ELSE (statement | expression)
                            ;

returnStmt                  :   RETURN (calculation | expression | comparisson | literal | id) ';'
                            ;

expression                  :   arrayExpression
                            |   functionInvocation
                            ;

arrayExpression             :   NEW dataType
                            |   '{' ((literal | id) ','?)+ '}'
                            |   id '.' 'length'
                            |   id '[' (INTEGER_LITERAL | id | calculation+) ']' (ASSIGN (id | literal) ';')?
                            ;

functionInvocation          :   id '(' arguments? ')'
                            |   id '(' arguments? ')' ';'
                            ;

comparisson                 :   calculation LT calculation
                            |   calculation GT calculation
                            |   calculation EQUAL calculation
                            ;

calculation                 :   '(' calculation ')'
                            |   calculation (MUL | DIV) calculation
                            |   calculation (ADD | SUB) calculation
                            |   arrayExpression
                            |   functionInvocation
                            |   literal
                            |   id
                            ;

//////////////////////////////////////////
// Lexer Specification ==> Regular Expressions 

// Reserved Keywords
BOOLEAN                     :   'bool';
CHAR                        :   'char';
FLOAT                       :   'float';
INT                         :   'int';
IF                          :   'if';
ELSE_IF                     :   'else if';
ELSE                        :   'else';
MAIN                        :   'main';
NEW                         :   'new';
RETURN                      :   'return';
STRING                      :   'string';
VOID                        :   'void';
WHILE                       :   'while';

// OFP has the following binary operators: +,-,*,/,<,>,==
ASSIGN                      :   '=';
GT                          :   '>';
LT                          :   '<';
EQUAL                       :   '==';
ADD                         :   '+';
SUB                         :   '-';
MUL                         :   '*';
DIV                         :   '/';

// Separators
SINGLE_Q                    :   '\'';
DOUBLE_Q                    :   '"';
SEMICOLON                   :   ';';

// Literals
INTEGER_LITERAL             :  (SUB?('1'..'9')+'0'* | '0');
FLOAT_LITERAL               :  (SUB?('0' | ('1'..'9')+('0'..'9')*)'.'('0'..'9')+ | '0.00' | SUB?'0''.''0'*('1'..'9')+'0'*);
BOOLEAN_LITERAL             :  ('true'|'false');
CHAR_LITERAL                :  SINGLE_Q ('a'..'z' | 'A'..'Z' | '\z' | '?') SINGLE_Q;
STRING_LITERAL              :  DOUBLE_Q ('a'..'z' | 'A'..'Z' | '!' | '.' | ',' | ' ' | '?' | '=' | ':' | '(' | ')')+ DOUBLE_Q; // Identifiers can only consist of the letters {a-z} and {A-Z}.

IDENTIFIER                  :  ('a' ..'z'|'A' ..'Z')+;

// Ignore whitespace and comments.
WS                          :   [ \t\r\n]+ -> skip;
LINE_COMMENT                :   '#' ~[\r\n]* -> skip;