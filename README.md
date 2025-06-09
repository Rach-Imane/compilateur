# ProjetCMPL - Compilateur Pédagogique

## Description

ProjetCMPL est un compilateur pédagogique développé en Java, implémentant les phases classiques d'un compilateur : analyse lexicale, analyse syntaxique, génération de code intermédiaire et édition de liens. Ce projet démontre une compréhension approfondie des concepts fondamentaux de la compilation et de l'implémentation de langages de programmation.

## Compétences Techniques Démontrées

- **Analyse Lexicale et Syntaxique**
  - Utilisation d'ANTLR pour la génération d'analyseurs
  - Implémentation d'une grammaire pour un langage de programmation
  - Gestion des erreurs de syntaxe

- **Gestion de la Table des Symboles**
  - Implémentation d'une table de symboles efficace
  - Gestion des portées et des déclarations
  - Support des procédures et des variables

- **Génération de Code**
  - Production de code intermédiaire
  - Gestion des adresses et des références
  - Optimisation basique du code généré

- **Édition de Liens**
  - Résolution des références externes
  - Gestion des tables de translation
  - Concaténation de code objet

## Technologies Utilisées

- Java
- ANTLR 3.5.2
- Eclipse IDE
- Git pour le contrôle de version

## Points Forts du Projet

- Architecture modulaire et extensible
- Gestion robuste des erreurs
- Documentation complète du code
- Tests unitaires pour valider les fonctionnalités
- Support de multiples cas d'utilisation

## Installation

1. **Prérequis :**
   - Java (JDK 8 ou supérieur)
   - Eclipse IDE
   - ANTLR 3.5.2

2. **Installation dans Eclipse :**
   - File > Import > General > Existing Projects into Workspace
   - Sélectionnez le dossier racine du projet
   - Vérifiez que le fichier `antlr-3.5.2-complete.jar` est dans le classpath

## Utilisation

1. **Compilation d'un programme source :**
   - Dans Eclipse, exécutez `projet.java`
   - Entrez le nom du fichier source à compiler
   - Le compilateur génère les fichiers intermédiaires

2. **Édition de liens :**
   - Exécutez `Edl.java` pour l'édition de liens
   - Suivez les instructions pour lier les modules

## Structure du Projet

- `src/` : Code source Java
  - Analyseurs lexicaux et syntaxiques
  - Générateurs de code
  - Gestionnaires de symboles
  - Éditeur de liens
- `*.pro` : Fichiers source du langage Projet
- `*.obj`, `*.gen` : Fichiers générés


## Réalisations

- Implémentation complète d'un compilateur pédagogique
- Support de multiples fonctionnalités de langage
- Gestion efficace des erreurs et des cas limites
- Documentation technique détaillée

## Compétences Développées

- Conception de compilateurs
- Programmation Java avancée
- Utilisation d'outils de génération de code
- Gestion de projet en équipe
- Documentation technique

## Fonctionnalités

- Analyse lexicale et syntaxique de fichiers `.pro`
- Génération de code intermédiaire
- Calcul et gestion des descripteurs de modules
- Remplissage correct de la table des symboles
- Phase 1 de l'édition de liens (tables TRANSDON, TRANSCODE, ADFINALE)
- Fichiers de tests fournis pour valider le compilateur

## Limitations connues

- La phase de concaténation et de liaison finale du code n'est pas totalement finalisée.
- Certains aspects avancés de l'édition de liens restent à compléter.

## Tests

Des fichiers de tests sont fournis dans le dossier `ProjetCMPL` :
- `DeclExp-T1.pro`, `DeclExp-Err*.pro` : tests de déclarations et d'erreurs
- `polyPxx-exoyy.pro` : exercices du polycopié
- `TDexoxx.pro` : exercices du TD

## Remarques

- Le projet fonctionne bien pour la plupart des cas de compilation et d'édition de liens de base.
- Pour des cas avancés ou la phase finale de liaison, des compléments sont à prévoir.
- Le projet est configuré pour fonctionner dans Eclipse, ce qui facilite le développement et le débogage.
