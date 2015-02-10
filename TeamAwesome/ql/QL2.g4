// Derived from http://json.org

grammar QL;

form
    :   'form' NAME '{' ('\r\n' | '\n' | '\r')* question+ '}' ('\r\n' | '\n' | '\r')*
    ;

question
    :   NAME '{' ('\r\n' | '\n' | '\r')* attribute+ '}' ('\r\n' | '\n' | '\r')*
    ;

attribute
    :   NAME ':' value ('\r\n' | '\n' | '\r') 
    ;

NAME 
    :   [a-zA-Z_][a-zA-Z_0-9]* 
    ;

value
    :   boolean
    |   STRING
    |   NUMBER
    |   question_type
    ;

boolean
    :   'true'
    |   'false'
    ;

STRING :  '"' (ESC | ~["\\])* '"' ;
fragment ESC :   '\\' (["\\/bfnrt]) ;

NUMBER : '-'? '0' | [1-9] [0-9]*  ;

question_type 
    :   'boolean'
    |   'integer' 
    |   'string' 
    ;

WS  :   [ \t]+ -> skip ;
