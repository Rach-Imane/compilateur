/*********************************************************************************
 * VARIABLES ET METHODES FOURNIES PAR LA CLASSE UtilLex (cf libClass_Projet)     *
 *       complement à l'ANALYSEUR LEXICAL produit par ANTLR                      *
 *                                                                               *
 *                                                                               *
 *   nom du programme compile, sans suffixe : String UtilLex.nomSource           *
 *   ------------------------                                                    *
 *                                                                               *
 *   attributs lexicaux (selon items figurant dans la grammaire):                *
 *   ------------------                                                          *
 *     int UtilLex.valEnt = valeur du dernier nombre entier lu (item nbentier)   *
 *     int UtilLex.numIdCourant = code du dernier identificateur lu (item ident) *
 *                                                                               *
 *                                                                               *
 *   methodes utiles :                                                           *
 *   ---------------                                                             *
 *     void UtilLex.messErr(String m)  affichage de m et arret compilation       *
 *     String UtilLex.chaineIdent(int numId) delivre l'ident de codage numId     *
 *     void afftabSymb()  affiche la table des symboles                          *
 *********************************************************************************/


import java.io.*;

/**
 * classe de mise en oeuvre du compilateur
 * =======================================
 * (verifications semantiques + production du code objet)
 *
 * @author Girard, Masson, Perraudeau
 *
 */

public class PtGen {


	// constantes manipulees par le compilateur
	// ----------------------------------------

	private static final int

			// taille max de la table des symboles
			MAXSYMB=300,

	// codes MAPILE :
	RESERVER=1,EMPILER=2,CONTENUG=3,AFFECTERG=4,OU=5,ET=6,NON=7,INF=8,
			INFEG=9,SUP=10,SUPEG=11,EG=12,DIFF=13,ADD=14,SOUS=15,MUL=16,DIV=17,
			BSIFAUX=18,BINCOND=19,LIRENT=20,LIREBOOL=21,ECRENT=22,ECRBOOL=23,
			ARRET=24,EMPILERADG=25,EMPILERADL=26,CONTENUL=27,AFFECTERL=28,
			APPEL=29,RETOUR=30,

	// codes des valeurs vrai/faux
	VRAI=1, FAUX=0,

	// types permis :
	ENT=1,BOOL=2,NEUTRE=3,

	// categories possibles des identificateurs :
	CONSTANTE=1,VARGLOBALE=2,VARLOCALE=3,PARAMFIXE=4,PARAMMOD=5,PROC=6,
			DEF=7,REF=8,PRIVEE=9,

	//valeurs possible du vecteur de translation
	TRANSDON=1,TRANSCODE=2,REFEXT=3;


	// utilitaires de controle de type
	// -------------------------------
	/**
	 * verification du type entier de l'expression en cours de compilation
	 * (arret de la compilation sinon)
	 */
	private static void verifEnt() {
		if (tCour != ENT)
			UtilLex.messErr("expression entiere attendue");
	}
	/**
	 * verification du type booleen de l'expression en cours de compilation
	 * (arret de la compilation sinon)
	 */
	private static void verifBool() {
		if (tCour != BOOL)
			UtilLex.messErr("expression booleenne attendue");
	}

	// pile pour gerer les chaines de reprise et les branchements en avant
	// -------------------------------------------------------------------

	private static TPileRep pileRep;


	// production du code objet en memoire
	// -----------------------------------

	private static ProgObjet po;


	// COMPILATION SEPAREE
	// -------------------
	//
	/**
	 * modification du vecteur de translation associe au code produit
	 * + incrementation attribut nbTransExt du descripteur
	 *  NB: effectue uniquement si c'est une reference externe ou si on compile un module
	 * @param valeur : TRANSDON, TRANSCODE ou REFEXT
	 */
	private static void modifVecteurTrans(int valeur) {
		if (valeur == REFEXT || desc.getUnite().equals("module")) {
			po.vecteurTrans(valeur);
			desc.incrNbTansExt();
		}
	}
	// descripteur associe a un programme objet (compilation separee)
	private static Descripteur desc;


	// autres variables fournies
	// -------------------------

	// MERCI de renseigner ici un nom pour le trinome, constitue EXCLUSIVEMENT DE LETTRES
	public static String trinome="PRA"; 	//Rachmaine Imane / Azarqi Camal Khaoula / Pham Khan Linh

	private static int tCour; // type de l'expression compilee
	private static int vCour; // sert uniquement lors de la compilation d'une valeur (entiere ou boolenne)
	private static int cmpt; // compter les variables

	// TABLE DES SYMBOLES
	// ------------------
	//
	private static EltTabSymb[] tabSymb = new EltTabSymb[MAXSYMB + 1];

	// it = indice de remplissage de tabSymb
	// bc = bloc courant (=1 si le bloc courant est le programme principal)
	private static int it, bc;
	private static int ident, identAffect, indexProcAppel ;

	private static int cmptPara; //compter les paramètres
	
	private static int nbDef , nbRef , adPo ; 
	/**
	 * utilitaire de recherche de l'ident courant (ayant pour code UtilLex.numIdCourant) dans tabSymb
	 *
	 * @param borneInf : recherche de l'indice it vers borneInf (=1 si recherche dans tout tabSymb)
	 * @return : indice de l'ident courant (de code UtilLex.numIdCourant) dans tabSymb (O si absence)
	 */
	private static int presentIdent(int borneInf) {
		int i = it;
		while (i >= borneInf && tabSymb[i].code != UtilLex.numIdCourant)
			i--;
		if (i >= borneInf)
			return i;
		else
			return 0;
	}

	/**
	 * utilitaire de placement des caracteristiques d'un nouvel ident dans tabSymb
	 *
	 * @param code : UtilLex.numIdCourant de l'ident
	 * @param cat : categorie de l'ident parmi CONSTANTE, VARGLOBALE, PROC, etc.
	 * @param type : ENT, BOOL ou NEUTRE
	 * @param info : valeur pour une constante, ad d'exécution pour une variable, etc.
	 */
	private static void placeIdent(int code, int cat, int type, int info) {
		if (it == MAXSYMB)
			UtilLex.messErr("debordement de la table des symboles");
		it = it + 1;
		tabSymb[it] = new EltTabSymb(code, cat, type, info);
	}

	/**
	 *  utilitaire d'affichage de la table des symboles
	 */
	private static void afftabSymb() {
		System.out.println("       code           categorie      type    info");
		System.out.println("      |--------------|--------------|-------|----");
		for (int i = 1; i <= it; i++) {
			if (i == bc) {
				System.out.print("bc=");
				Ecriture.ecrireInt(i, 3);
			} else if (i == it) {
				System.out.print("it=");
				Ecriture.ecrireInt(i, 3);
			} else
				Ecriture.ecrireInt(i, 6);
			if (tabSymb[i] == null)
				System.out.println(" reference NULL");
			else
				System.out.println(" " + tabSymb[i]);
		}
		System.out.println();
	}


	/**
	 *  initialisations A COMPLETER SI BESOIN
	 *  -------------------------------------
	 */
	public static void initialisations() {

		// indices de gestion de la table des symboles
		it = 0;
		bc = 1;

		// pile des reprises pour compilation des branchements en avant
		pileRep = new TPileRep();
		// programme objet = code Mapile de l'unite en cours de compilation
		po = new ProgObjet();
		// COMPILATION SEPAREE: desripteur de l'unite en cours de compilation
		desc = new Descripteur();

		// initialisation necessaire aux attributs lexicaux
		UtilLex.initialisation();

		// initialisation du type de l'expression courante
		tCour = NEUTRE;
		vCour = 0;
		cmpt = 0 ;

		ident = 0 ;
		identAffect = 0;
		cmptPara = 0 ;
		indexProcAppel = 0;
		 
		adPo = 0 ;

	} // initialisations

	/**
	 *  code des points de generation A COMPLETER
	 *  -----------------------------------------
	 * @param numGen : numero du point de generation a executer
	 */
	public static void pt(int numGen) {

		switch (numGen) {
			case 0:
				initialisations();
				break;
				
			//VALEUR
			case 1 :
				tCour = ENT;
				vCour = UtilLex.valEnt;
				break;
			case 2 :
				tCour = ENT;
				vCour = (-1) * (UtilLex.valEnt);
				break;

			case 3 :
				tCour = BOOL;
				vCour = VRAI;
				break;

			case 4 :
				tCour = BOOL;
				vCour = FAUX;
				break;

			//CONSTS
			case 5 :
				placeIdent(UtilLex.numIdCourant, CONSTANTE, tCour ,vCour);
				break;
			//VARGLOBALE / VARLOCALE
			case 6 :
				if(presentIdent(1)==0) {
					if(bc> 1){
					placeIdent(UtilLex.numIdCourant, VARLOCALE, tCour ,cmpt);
					cmpt++;
					} else {
						placeIdent(UtilLex.numIdCourant, VARGLOBALE, tCour ,cmpt);
						cmpt ++;
					}
				}else
					UtilLex.messErr("variable déja déclarée");
				break;
				
			//OU
			case 7:
				verifBool();
				break;
			case 8 :
				po.produire(OU);
				break;

			//ET
			case 9 :
				po.produire(ET);
				break;

			//NON
			case 10 :
				po.produire(NON);
				break;

			// INF
			case 11 :
				verifEnt();
				break;
			case 12 :
				po.produire(INF);
				tCour = BOOL ;
				break;

			//INFEG
			case 13 :
				po.produire(INFEG);
				tCour = BOOL ;
				break;

			//SUP
			case 14 :
				po.produire(SUP);
				tCour = BOOL ;
				break;

			//SUPEG
			case 15 :
				po.produire(SUPEG);
				tCour = BOOL ;
				break;

			//EG
			case 16 :
				po.produire(EG);
				tCour = BOOL ;
				break;

			//DIFF
			case 17 :
				po.produire(DIFF);
				tCour = BOOL ;
				break;

			//ADD
			case 18 :
				po.produire(ADD);
				tCour = ENT ; 
				break;

			//SOUS
			case 19 :
				po.produire(SOUS);
				tCour = ENT ; 
				break;

			//MUL
			case 20 :
				po.produire(MUL);
				tCour = ENT ; 
				break;

			//DIV
			case 21 :
				po.produire(DIV);
				tCour = ENT ; 
				break;

			//TYPE
			case 22 :
				tCour = ENT;
				break;

			case 23 :
				tCour = BOOL;
				break;

			//RESERVER
			case 24 :
				if(desc.getUnite().equals("programme")) {
					po.produire(RESERVER);
					if(bc == 1) 
						po.produire(cmpt);
					else 
						po.produire(cmpt-cmptPara-2);
				}
				desc.setTailleGlobaux(cmpt);
				cmpt = 0 ;
				break;

			//EMPILER
			case 25 :
				po.produire(EMPILER);
				po.produire(vCour);
				break;

			//ECRITURE 
			case 26 :
				if( tCour == ENT) {
					po.produire(ECRENT);
				}
				else if( tCour == BOOL) {
					po.produire(ECRBOOL);
				}
				break;

			//LECTURE 
			case 27 :
				EltTabSymb tab = tabSymb[ident];
				
				if(tab.categorie == CONSTANTE) {
					UtilLex.messErr("La constante"+ UtilLex.chaineIdent(UtilLex.numIdCourant)+" ne peut pas etre changé");
				}
				
				switch (tab.type) {
					case ENT:
						po.produire(LIRENT);
						break;
					case BOOL:
						po.produire(LIREBOOL);
						break;
				}
				
				break;

			//CONTENUG - CONTENUL
			case 28 :
				
				EltTabSymb elt = tabSymb[ident];
				
				switch (elt.categorie) {
				
					case CONSTANTE:
						po.produire(EMPILER);
						po.produire(elt.info);
						tCour = elt.type;
						break;
						
					case VARGLOBALE:
						po.produire(CONTENUG);
						po.produire(elt.info);
						tCour = elt.type;
						modifVecteurTrans(TRANSDON);
						break; 
						
					case VARLOCALE,PARAMFIXE:
						po.produire(CONTENUL);
						po.produire(elt.info);
						po.produire(0);
						tCour = elt.type;
						break;
					
					case PARAMMOD:
						po.produire(CONTENUL);
						po.produire(elt.info);
						po.produire(1);
						tCour = elt.type;
						break;
				}
				
				break;

			//SI

			case 29 : //(IF)
				verifBool();
				po.produire(BSIFAUX);
				po.produire(0);
				modifVecteurTrans(TRANSCODE);
				pileRep.empiler(po.getIpo());
				break;

			case 30 : //(ELSE)
				po.modifier(pileRep.depiler(),po.getIpo() + 3 );
				po.produire(BINCOND);
				po.produire(0);
				modifVecteurTrans(TRANSCODE);
				pileRep.empiler(po.getIpo());
				break;

			case 31 : //FSI (Fin_If)
				  po.modifier(pileRep.depiler(),po.getIpo() + 1 );
				break;

			//AFFECTERG - AFFECTERL

			case 32 :
				EltTabSymb t = tabSymb[identAffect];
				afftabSymb();
				if(t.categorie == CONSTANTE) {
					UtilLex.messErr("La constante"+ UtilLex.chaineIdent(UtilLex.numIdCourant)+" ne peut pas etre affecté");
				}
				if(t.type != tCour) {
					UtilLex.messErr("type non conforme");
				}
				
				switch(t.categorie) {
				
					case VARGLOBALE:
						po.produire(AFFECTERG);
						po.produire(t.info);
						modifVecteurTrans(TRANSDON);
						break;
	
					case VARLOCALE:
						po.produire(AFFECTERL);
	
						po.produire(t.info);
	
						po.produire(0);
						break;
	
					case PARAMMOD:
						po.produire(AFFECTERL);
	
						po.produire(t.info);
	
						po.produire(1);
						break;
	
					case PARAMFIXE:
						UtilLex.messErr("Le parametre fixe "+ UtilLex.chaineIdent(UtilLex.numIdCourant)+" ne peut pas etre affecté");
						break;
				
					default :
						UtilLex.messErr("La constante"+ UtilLex.chaineIdent(UtilLex.numIdCourant)+" ne peut pas etre affecté");
				}
				
				break;

			//ARRET
			case 33 :
				po.produire(ARRET);
				break;

			//While
				
			case 34 :
				pileRep.empiler(po.getIpo() + 1);//empiler l'adresse de la condition
				break;
			//Fin de ttq, MAJ de bincond et bsifaux
			case 35 :
				po.modifier(pileRep.depiler(), po.getIpo()+3);
				po.produire(BINCOND);
				po.produire(pileRep.depiler());
				pileRep.empiler(po.getIpo());
				
				modifVecteurTrans(TRANSCODE);
				break;

			//COND
			//aut
			case 37 :
				int bsifaux = pileRep.depiler();
				po.produire(BINCOND);
				po.produire(pileRep.depiler());
				modifVecteurTrans(TRANSCODE);
				po.modifier(bsifaux, po.getIpo() + 1);
				pileRep.empiler(po.getIpo());
				break;

			//cas aut null :
			case 38 :
				po.modifier(pileRep.depiler(), po.getIpo()+1);
				break;

			// (fcond)
			case 39 :
				int lastBincond = pileRep.depiler();
				int tmp = po.getElt(lastBincond);
				//System.out.println("test");
				while(tmp != 0) {
					po.modifier(lastBincond, po.getIpo()+1);
					lastBincond = tmp ;
					tmp =po.getElt(lastBincond);

				}
				po.modifier(lastBincond, po.getIpo() + 1);
				break;

			//Check un ident étant déclaré
			case 40 :
				if(presentIdent(1) == 0){
					afftabSymb();
					//System.out.println(UtilLex.chaineIdent(UtilLex.numIdCourant));
					UtilLex.messErr("ident non déclarée" );
				}
				else {
					ident = presentIdent(1);
				}
			 break;
			 
			//PROC + PRIVEE
			case 41 :
				if(presentIdent(1) != 0) {
					afftabSymb();
					UtilLex.messErr("procédure déja déclarée");
				}
				else { 
				 placeIdent(UtilLex.numIdCourant, PROC, NEUTRE, po.getIpo()+1);
				 
				 String identproc = UtilLex.chaineIdent(UtilLex.numIdCourant) ;// nom de la proc
				 indexProcAppel = desc.presentDef(identproc);// index de la proc dans tabdef
				 //int i = desc.presentDef(identproc) ;
				 if(desc.presentDef(identproc) == 0 ) {
					  placeIdent(-1, PRIVEE, NEUTRE, -1);
				 }
				 else {
					  placeIdent(-1, DEF, NEUTRE, -1);
				 }
				 bc = it +1 ;
				 
				 adPo = po.getIpo() + 1 ;
				 desc.modifDefAdPo(indexProcAppel, adPo);
				 //desc.modifDefNbParam(i, cmptPara);
				 cmptPara = 0;

				}
				break;
			//PARAMFIXE
			case 42:
				placeIdent(UtilLex.numIdCourant, PARAMFIXE, tCour ,cmptPara );
				cmptPara ++ ;
				break;
			//PARAMMOD
			case 43:
				placeIdent(UtilLex.numIdCourant, PARAMMOD, tCour ,cmptPara );
				cmptPara ++ ;
				break;
			
			//EMPILERADG - EMPILERADL
			case 44 :
				EltTabSymb loc = tabSymb[ident];
				
				switch(loc.categorie) {
					case VARGLOBALE: 
						po.produire(EMPILERADG);
						po.produire(loc.info);
						modifVecteurTrans(TRANSDON);
						break;
					case VARLOCALE:
						po.produire(EMPILERADL);
						po.produire(loc.info);
						po.produire(0);
						break;
					case PARAMMOD:
						po.produire(EMPILERADL);
						po.produire(loc.info);
						po.produire(1);
						break;
					default :
						afftabSymb();
						System.out.println(loc.info);
						System.out.println(loc.categorie);
						UtilLex.messErr("ERREUR");
						break;
				}
				
				break ; 
				
			 //APPEL
			 case 46 :
				 indexProcAppel = presentIdent(1);
				 if (indexProcAppel ==0 || (0 != indexProcAppel && tabSymb[indexProcAppel].categorie != PROC))
					 UtilLex.messErr(" proc n'est pas déclarée");
			 	break;
			 
			 case 45 :
				 po.produire(APPEL);
				 po.produire(tabSymb[indexProcAppel].info);
				 switch (tabSymb[indexProcAppel+1].categorie) {
					case REF: {
						modifVecteurTrans(REFEXT);
						break;
					}
					default:
						modifVecteurTrans(TRANSCODE);
						break;
					}
				 po.produire(tabSymb[indexProcAppel+1].info);
				 break;
				 
			 //FIN DE PROC-RETOUR
			 case 47:
					
				 	po.produire(RETOUR);
					cmptPara = tabSymb[bc-1].info;
					desc.modifDefNbParam(indexProcAppel, cmptPara);
					po.produire(cmptPara);			
					it = bc +cmptPara-1 ;
					int i = it;
					while(tabSymb[i].categorie == PARAMFIXE || tabSymb[i].categorie == PARAMMOD) {
						tabSymb[i].code = -1 ;
						i--;
					}
					bc=1;
					//afftabSymb();
				    

					break;
					
			 case 48 :
				identAffect = ident;
				 break;
				
			 case 49 : 
				 tabSymb[bc-1].info = cmptPara;
				 cmpt = cmptPara + 2;
				 break;
				 
			 case 50:
				 if(desc.getUnite().equals("programme")) {
					  po.produire(BINCOND);
					  po.produire(0);
					  modifVecteurTrans(TRANSCODE);
				 }
				 pileRep.empiler(po.getIpo());
				 break;
				 
			 case 51:
				 cmpt++;
				 break;
				 
			 case 52:
				 int idepil=pileRep.depiler();
				 po.modifier(idepil, po.getIpo()+1);
				 System.out.println(po.getElt(idepil));
				 
				 break;
				  
				 
			//Programme	 
			case 53:
				desc.setUnite("programme");
				
				break;
			//Module
			case 54 : 
				desc.setUnite("module");

				break;
				
			// tabRef
			case 55 :
				cmptPara ++;
				break ;
			case 56 : 
				int idproc = UtilLex.numIdCourant ;
				String identproc = UtilLex.chaineIdent(idproc) ;
				int in = desc.presentRef(identproc) ;
				if(presentIdent(1) == 0 ) {
					desc.ajoutRef(identproc);
					desc.modifRefNbParam( in , cmptPara);
					
					 placeIdent(idproc, PROC, NEUTRE, desc.getNbRef());
					 placeIdent(-1, REF, NEUTRE, cmptPara);
					// bc = it +1 ;
				}else {
					UtilLex.messErr("ref deja declarée");
				}
				cmptPara = 0 ;
				break ; 
				
		
			//tabDef 
			case 57 : 
				if(presentIdent(1)==0) {
					desc.ajoutDef(UtilLex.chaineIdent(UtilLex.numIdCourant));
				}else {
					UtilLex.messErr("procédure déja définie");
				}
				break ;
				
			//descripteur	
			case 58 :
				desc = new Descripteur();
				nbDef = 0;
				nbRef = 0 ;	
				cmpt = 0 ;
				
				break ;
				
			// tabSymbRef 
			case 59 :
				 placeIdent(UtilLex.numIdCourant, PROC, NEUTRE, po.getIpo()+1);
				 placeIdent(-1, REF, NEUTRE, desc.getRefNbParam(UtilLex.numIdCourant));
				 bc = it +1 ;
				
				break ;
				
			
				
			case 255 :
				if(desc.getUnite().equals("programme")) {
					po.produire(ARRET);
				}
				System.out.println(desc.getUnite());
				desc.setTailleCode(po.getIpo());
				afftabSymb();
				po.constGen();
				po.constObj();
				desc.ecrireDesc( UtilLex.nomSource);
				break;

				
				

			default:
				System.out.println("Point de generation non prevu dans votre liste");
				break;

		}
	}
}








