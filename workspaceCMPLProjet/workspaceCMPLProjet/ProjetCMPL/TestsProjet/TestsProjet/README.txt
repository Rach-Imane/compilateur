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




 État Actuel du Projet (V1) : 
 
- Analyse Lexicale et Syntaxique: Implémentée avec succès via ANTLR pour le langage PROJET. Capable de reconnaître la structure des programmes PROJET, y compris les expressions arithmétiques et les instructions de base.
- Génération de Code : 
    - Déclarations et Expressions: La génération de code pour les déclarations de variables et les expressions simples.
    - Instructions de Base : La lecture, l'écriture et l'affectation sont prises en charge et génèrent du code exécutable par la machine virtuelle MAPILE.
    - Structures de Contrôle : La compilation des instructions `si`, `tant que` et `cond`. La gestion des sauts conditionnels nousa tracasé un peu .

 Difficultés Rencontrées :
- Génération de Code pour les Structures de Contrôle : Trouver la meilleure stratégie pour la génération de code pour les instructions conditionnelles et les boucles a nécessité un effort et une compréhension profonde, surtout pour optimiser l'usage de la pile.

 
