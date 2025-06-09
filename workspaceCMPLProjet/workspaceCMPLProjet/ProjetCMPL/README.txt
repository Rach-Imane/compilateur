Fichiers de test fournis pour le Projet compilateur

Les fichiers de tests fournis correspondent à des programmes en langage Projet (donc suffixés par .pro) que votre compilateur doit compiler.

Tests compilation des déclarations et expressions:
	fichier DeclExp-T1.pro : teste un certain nombre de déclarations et expressions
	fichiers DeclExp-Err1.pro à DeclExp-Err5.pro: testent un certain nombre d'erreurs (un type d'erreur par fichier)

Autres tests de compilation:
	fichiers polyPxx-exoyy.pro: exercice yy, page xx du poly de TP
	fichiers polyPxx-exempleyy.pro: exemple (DONT VOUS AVEZ LA SOLUTION dans le poly), page xx du poly de TP 
	fichiers polyPxx-exempleyy.genENS et fichiers polyPxx-exempleyy.objENS: solutions des exemples précédents
	NB: suffixes .gen et .obj modifies en .genENS et .objENS pour que votre compilateur ne les ecrase pas!
	fichiers TDexoxx.pro: exo xx (de la partie C) du TD (DONT VOUS AVEZ LA SOLUTION dans le TD)
RQ: la solution s'entend ici comme le code mnémonique obtenu après compilation.

ATTENTION: l'ensemble des fichiers fournis ne sont que des exemples de programmes à compiler 
et ne permettent pas de tester l'ensemble des possibilités.
En particulier, aucun programme erroné n'est fourni (à part pour les déclarations/expressions).
C'EST A VOUS DE COMPLETER L'ENSEMBLE DES PROGRAMMES A COMPILER (par exemple en créant des variantes
des programmes proposés).

Trinome : Rachmaine Imane / Azarqi Camal Khaoula / Pham khan linh

Ce qui fonctionne : 

- Le calcul du descripteur est bien réalisé et correct, et il renvoie les bonnes valeurs pour tous ses attributs.
- TabSymb est bien rempli comme il se doit, y compris pour les lignes après la déclaration des procédures (définies comme référencées ou privées)
- La phase 1 de l'édition de liens fonctionne très bien, sans erreurs, 
et renvoie les valeurs attendues pour les tables TRANSDON, TRANSCODE et ADFINALE.

 Difficultés Rencontrées :
 
- L'une des difficultés rencontrées a été la résolution du bincond.
  On ne dépilait pas correctement sur la pile de reprise, ce qui faisait qu'à chaque modification,
  l'argument 0 (passé en premier) de bincond était toujours utilisé.
- Au début, nous exécutions des bincond avant la déclaration de CHAQUE procédure,
 ce qui faisait que l'exécution passait directement au code principal sans déclarer les procédures.
- En raison de contraintes de temps et de la complexité de la tâche,
 on n'a pas pu complètement mettre en œuvre et déboguer la phase de liaison et de concaténation de code