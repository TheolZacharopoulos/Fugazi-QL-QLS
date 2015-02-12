/**
 * QL GRAMMAR
 */
grammar QL;

@header{
	import java.util.*;
}

prog	: form+ EOF ;

form	: 'form' ID '{' quest* stat* '}' ;

quest locals[List<String> decls = new ArrayList<String>()]	
		: 'question' STRING '=' QuestionLiteral '{' decl+ stat* expr* '}' ;

stat : value								
	 | ifStat								
	 | ID '=' expr ';'
	 ;

decl : ID ':' primitiveType ';' {
	if (!$quest::decls.contains($ID.text)){$quest::decls.add($ID.text);}
	else {System.err.println("Declaration exists: " + $ID.text);}
};

expr		: expr EXP<assoc=right> expr 														#Exp
			| expr (MUL | DIV) expr		 	  													#MulDiv
			| expr (ADD | SUB) expr																#AddSub
			| expr (LESS |LESS_EQUAL | GREATER | GREATER_EQUAL) expr							#LessGreater
			| expr ('==' | '!=') expr															#Equal_NotEqual
			| expr '&&' expr																	#LogAnd
			| expr '||' expr																	#LogOr
			| '(' expr ')'																		#Par
			| literal																			#ExprLit
			;
			
ifStat		: 'if' '(' expr ')' '{' quest* stat* decl* '}'
			| 'if' '(' expr ')' '{' stat '}' 'else' '(' quest* stat* decl* ')';

value		: ID '.' 'value' '=' expr ';' ;	

literal		: BooleanLiteral
			| NumberLiteral
			| ID
			;

QuestionLiteral	: 'OrdinaryQuestion'
				| 'ComputableQuestion'
				;
	
BooleanLiteral 	: 'true'
				| 'false'
				;

NumberLiteral	: (INT | ('(-'INT')'))
				| (FLOAT | ('(-'FLOAT')'))
				| (CURRENCY | ('(-'CURRENCY')'))
				;

primitiveType	: 'boolean'
				| 'float'
				| 'currency'
				| 'string'
				;

WS			: (' ' | NL | '\t') -> skip;

ID			: ID_LETTER (ID_LETTER | INT)* ;

/* It gets form, if etc as an identifier and not as keywords */

ID_LETTER	: 'a'..'z' | 'A'..'Z' | '_' ;

INT			: '0' | [1-9] [0-9]*  ;	// We cannot use [0-9]+ because this would mean that 01 + 3 would be acceptable

FLOAT		: INT+ '.' INT*	// How to set the precision to for instance 4? That it returns a value of this precision
			| '.' INT+;

CURRENCY	: FLOAT;

STRING 		: '"'	(ESC|.)*? '"';
fragment
ESC			: '\\' | '\\\\' ;

LINE_COMMENT: '//' .*? '\n' -> skip;	// Single line comments
COMMENT		: '/*' .*? '*/' -> skip;	// Multi line comments

/* KEYWORDS - TOKENS */ 

MUL			: '*' ;
DIV			: '/' ;
ADD			: '+' ;
SUB			: '-' ;
LP			: '(' ;
RP			: ')' ;
LC			: '{' ;
RC			: '}' ;
LESS		: '<' ;
LESS_EQUAL 	: '<=';
GREATER		: '>' ;
GREATER_EQUAL 	: '>=';
EQUAL  		: '==';
LOG_AND		: '&&';
LOG_OR		: '||';
NOT_EQUAL	: '!=';
NL			: '\r'? '\n';
EXP			: '^' ;

/* semantic actions - next to the production rules, and then call the constructor */
/* create a class that implements the visitor - because ANTLR generates only visitor interface */
/* the listener ->  */