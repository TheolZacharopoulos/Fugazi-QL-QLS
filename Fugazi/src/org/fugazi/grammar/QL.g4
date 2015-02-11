grammar QL;

/**
 * =====================
 * GENERAL DEFINITIONS
 * =====================
 */

// complete form - topmost node
form    : 'form' ID '{' statement* '}';

// statement - can be a question or an if statement
statement   : questionDeclaration
            | ifStatement
            ;

// an if statement˝
// supported form: if(expr){...}
ifStatement : 'if' '(' expression ')' '{' (ifStatement | questionDeclaration)* '}';

// question types
// two supported versions:
// 1. Question expecting user's answer.
// 2. Question (field) value of which is derived from other variables / values.
questionDeclaration : type ID '(' STRING ')' ';'                             # noAssignmentQuestion
                    | type ID '(' STRING ')' '=' expression ';'              # assignmentQuestion
                    ;

// all alowed variable types.
type    : 'bool'        # boolType
        | 'money'       # moneyType
        | 'int'         # intType
        ;
/**
 * =====================
 * Expressions
 * =====================
 */

// this defines what an expression looks like. (logical and numerical)
expression  : op=('+'|'-'|'!') expression                                           # singleExpression
            | expression op=('*' | '/') expression                                  # mulExpression
            | expression op=('+' | '-') expression                                  # addExpression
            | expression op=('>' | '>=' | '<' | '<=' | '==' | '!=') expression      # comparisonExpression
            | expression '&&' expression                                            # logicalAnd
            | expression '||' expression                                            # logicalOr
            | BOOLEAN                                                               # boolean
            | ID                                                                    # identifier
            | NUMBER                                                                # number
            | '(' expression ')'                                                    # parenthesisExpression
            ;

/**
 * =====================
 * LEXER RULES
 * =====================
 */

// identifier definition
// user to identify variable names
ID  :   [a-zA-Z]+;

// Number types, used for numerical statements.
NUMBER : INT | MONEY;

// string definition
STRING :  '"' (ESC | ~["\\])* '"' ;

// boolean value definition
BOOLEAN: ["true"|"false"];

// integer definition
// integer consists of an arbitrary number of digits
INT : DIGIT+ ;

// money definition
// money consists of an arbitrary number of digits, a dot,
// and of an arbitrary number of digits
MONEY : DIGIT+ '.' DIGIT*   // match 1. 39. 3.14159 etc...
      | '.' DIGIT+          // match .1 .14159
      ;

// comment matches anything between /* and */
COMMENT
    :   '/*' .*? '*/'    -> channel(HIDDEN)
    ;

// ignore whitespaces
WS  :   [ \r\t\u000C\n]+ -> channel(HIDDEN)
    ;

// line comment matches anything after // until newline
LINE_COMMENT
    : '//' ~[\r\n]* '\r'? '\n' -> channel(HIDDEN)
    ;

// Fragments
fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;
fragment DIGIT   : [0-9] ; // match single digit