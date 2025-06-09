	// Grammaire du langage PROJET
	// CMPL L3info 
	// Nathalie Girard, Veronique Masson, Laurent Perraudeau
	// il convient d'y inserer les appels a {PtGen.pt(k);}
	// relancer Antlr apres chaque modification et raffraichir le projet Eclipse le cas echeant
	
	// attention l'analyse est poursuivie apres erreur si l'on supprime la clause rulecatch
	
	
	// Rachmaine Imane, Azarqi Camal Khaoula , Pham khan linh
	grammar projet;
	
	options {
	  language=Java; k=1;
	 }
	
	@header {           
	import java.io.IOException;
	import java.io.DataInputStream;
	import java.io.FileInputStream;
	} 
	
	
	// partie syntaxique :  description de la grammaire //
	// les non-terminaux doivent commencer par une minuscule
	
	
	@members {
	
	 
	// variables globales et methodes utiles a placer ici
	  
	}
	// la directive rulecatch permet d'interrompre l'analyse a la premiere erreur de syntaxe
	@rulecatch {
	catch (RecognitionException e) {reportError (e) ; throw e ; }}
	
	
	unite  :   unitprog EOF {PtGen.pt(255);}  {PtGen.pt(58);}
	      |    unitmodule EOF {PtGen.pt(255);}  {PtGen.pt(58);}
	  ;
	  
	unitprog
	  : 'programme' ident ':'{PtGen.pt(53);}
	     declarations 
	     corps { System.out.println("succes, arret de la compilation "); }
	  ;
	
	unitmodule
	  : 'module' ident ':'{PtGen.pt(54);}
	     declarations
	  ;
	
	declarations
	  : partiedef? partieref? consts? vars? decprocs?
	  ;
	
	partiedef
	  : 'def' ident {PtGen.pt(57);}  (',' ident {PtGen.pt(57);} )* ptvg
	  ;
	
	partieref: 'ref' specif {PtGen.pt(56);}   (',' specif {PtGen.pt(56);} )* ptvg 
	  ;
	
	specif  : ident  ( 'fixe' '(' type {PtGen.pt(55);}  ( ',' type {PtGen.pt(55);}  )* ')' )? 
	                 ( 'mod'  '(' type {PtGen.pt(55);}  ( ',' type {PtGen.pt(55);}  )* ')' )? 
	  ;
	
	consts  : 'const'  ( ident '=' valeur {PtGen.pt(5);}  ptvg   )+  
	  ;
	
	vars  : 'var' ( type ident  {PtGen.pt(6);} ( ',' ident {PtGen.pt(6);} )* ptvg )+ {PtGen.pt(24);}
	  ;
	
	type  : 'ent'  {PtGen.pt(22);}
	  |     'bool' {PtGen.pt(23);}
	  ;
	
	decprocs:  {PtGen.pt(50);} ( decproc ptvg )+ {PtGen.pt(52);}
	  ;
	
	decproc :  'proc'  ident  {PtGen.pt(41);}  parfixe? parmod? {PtGen.pt(49);} consts? vars? corps {PtGen.pt(47);}
	  ;
	
	ptvg  : ';'
	  |
	  ;
	
	corps : 'debut'  instructions 'fin' 
	  ;
	
	parfixe: 'fixe' '(' pf ( ';' pf)* ')'
	  ;
	
	pf  : type ident {PtGen.pt(42);} ( ',' ident {PtGen.pt(42);}  )*
	  ;
	
	parmod  : 'mod' '(' pm ( ';' pm)* ')'
	  ;
	
	pm  : type ident {PtGen.pt(43);} ( ',' ident {PtGen.pt(43);} )*
	  ;
	
	instructions
	  : instruction ( ';' instruction)*
	  ;
	
	instruction
	  : inssi
	  | inscond
	  | boucle
	  | lecture
	  | ecriture
	  | affouappel
	  |
	  ;
	
	inssi : 'si'  expression {PtGen.pt(29);}
	        'alors' instructions ('sinon' {PtGen.pt(30);} instructions)? 'fsi' {PtGen.pt(31);}
	  ;
	
	inscond : 'cond'  expression {PtGen.pt(29);}  ':' instructions {PtGen.pt(30);}
	          (','  expression {PtGen.pt(29);} ':' instructions  )*
	          ('aut'  instructions {PtGen.pt(37);} | {PtGen.pt(38);} )
	          'fcond' {PtGen.pt(39);} 
	  ;
	
	boucle  : 'ttq'  {PtGen.pt(34);} expression {PtGen.pt(29);} 'faire' instructions {PtGen.pt(35);} 'fait'
	  ;
	
	lecture: 'lire'  '(' ident {PtGen.pt(40);} {PtGen.pt(27);}  {PtGen.pt(32);} ( ',' ident {PtGen.pt(40);} {PtGen.pt(27);}  {PtGen.pt(32);})* ')'
	  ;
	
	ecriture: 'ecrire' '(' expression {PtGen.pt(40);} {PtGen.pt(26);} ( ',' expression {PtGen.pt(40);} {PtGen.pt(26);} )* ')'
	   ;
	
	affouappel
	  : ident {PtGen.pt(40);}  (   {PtGen.pt(48);}':=' expression  {PtGen.pt(32);}
	            | {PtGen.pt(46);}  (effixes{PtGen.pt(51);} (effmods{PtGen.pt(51);})?)?  {PtGen.pt(45);}
	           )
	  ;
	
	effixes : '(' (expression   (',' expression  )*)? ')'
	  ;
	
	effmods :'(' (ident {PtGen.pt(40);}{PtGen.pt(44);} (',' ident {PtGen.pt(40);}{PtGen.pt(44);} )*)? ')'
	  ;
	
	expression: (exp1)  ({PtGen.pt(7);} 'ou' exp1 {PtGen.pt(7);} {PtGen.pt(8);} )*
	  ;
	
	exp1  : exp2 ('et' {PtGen.pt(7);}   exp2 {PtGen.pt(7);} {PtGen.pt(9);} )*
	  ;
	
	exp2  : 'non' exp2 {PtGen.pt(7);} {PtGen.pt(10);}
	  | exp3  
	  ;
	
	exp3  : exp4
	  ( {PtGen.pt(11);} '='  exp4 {PtGen.pt(11);} {PtGen.pt(16);}
	  |{PtGen.pt(11);} '<>'  exp4 {PtGen.pt(11);} {PtGen.pt(17);}
	  |{PtGen.pt(11);} '>'   exp4 {PtGen.pt(11);} {PtGen.pt(14);}
	  |{PtGen.pt(11);} '>='  exp4 {PtGen.pt(11);} {PtGen.pt(15);}
	  |{PtGen.pt(11);} '<'   exp4 {PtGen.pt(11);} {PtGen.pt(12);}
	  |{PtGen.pt(11);} '<='  exp4 {PtGen.pt(11);} {PtGen.pt(13);}
	  ) ?
	  ;
	
	exp4  : exp5
	        ({PtGen.pt(11);} '+'  exp5 {PtGen.pt(11);} {PtGen.pt(18);}
	        |{PtGen.pt(11);} '-'  exp5 {PtGen.pt(11);} {PtGen.pt(19);}
	        )*
	  ;
	
	exp5  : primaire
	        (  {PtGen.pt(11);}  '*'   primaire {PtGen.pt(11);} {PtGen.pt(20);}
	          |{PtGen.pt(11);}'div'  primaire {PtGen.pt(11);} {PtGen.pt(21);}
	        )*
	  ;
	
	primaire: valeur {PtGen.pt(25);}
	  | ident {PtGen.pt(40);} {PtGen.pt(28);}
	  ;
	
	valeur  : nbentier {PtGen.pt(1);}
	  | '+' nbentier {PtGen.pt(1);}
	  | '-' nbentier {PtGen.pt(2);}
	  | 'vrai' {PtGen.pt(3);}
	  | 'faux' {PtGen.pt(4);}
	  ;
	
	// partie lexicale  : cette partie ne doit pas etre modifiee  //
	// les unites lexicales de ANTLR doivent commencer par une majuscule
	// Attention : ANTLR n'autorise pas certains traitements sur les unites lexicales, 
	// il est alors ncessaire de passer par un non-terminal intermediaire 
	// exemple : pour l'unit lexicale INT, le non-terminal nbentier a du etre introduit
	 
	      
	nbentier  :   INT { UtilLex.valEnt = Integer.parseInt($INT.text);}; // mise a jour de valEnt
	
	ident : ID  { UtilLex.traiterId($ID.text); } ; // mise a jour de numIdCourant
	     // tous les identificateurs seront places dans la table des identificateurs, y compris le nom du programme ou module
	     // (NB: la table des symboles n'est pas geree au niveau lexical mais au niveau du compilateur)
	        
	  
	ID  :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ; 
	     
	// zone purement lexicale //
	
	INT :   '0'..'9'+ ;
	WS  :   (' '|'\t' |'\r')+ {skip();} ; // definition des "blocs d'espaces"
	RC  :   ('\n') {UtilLex.incrementeLigne(); skip() ;} ; // definition d'un unique "passage a la ligne" et comptage des numeros de lignes
	
	COMMENT
	  :  '\{' (.)* '\}' {skip();}   // toute suite de caracteres entouree d'accolades est un commentaire
	  |  '#' ~( '\r' | '\n' )* {skip();}  // tout ce qui suit un caractere diese sur une ligne est un commentaire
	  ;
	
	// commentaires sur plusieurs lignes
	ML_COMMENT    :   '/*' (options {greedy=false;} : .)* '*/' {$channel=HIDDEN;}
	    ;	   
	
	
	
		   
