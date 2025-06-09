import java.io.*;
//TODO : Renseigner le champs auteur : Rachmaine Imane / Azarqi Camal Khaoula / Pham Khan Linh
/**
 *
 * @author XXX, YYY, ZZZ
 * @version 2024
 *
 */
 class EltDef {
    // nomProc = nom de la procedure definie en DEF
    public String nomProc;
    // adPo = adresse de debut de code de cette procedure
    // nbParam =  nombre de parametres de cette procedure
    public int adPo, nbParam;

    public EltDef(String nomProc, int adPo, int nbParam) {
        this.nomProc = nomProc;
        this.adPo = adPo;
        this.nbParam = nbParam;
    }
}

/**  classe interne EltRef definissant
 * 	 le type de chaque element de la table des references externes tabRef
 */

class EltRef {
    // nomProc = nom de la procedure definie en REF
    public String nomProc;
    //  nbParam =  nombre de parametres de cette procedure
    public int nbParam;

    public EltRef(String nomProc, int nbParam) {
        this.nomProc = nomProc;
        this.nbParam = nbParam;
    }
}

public class Edl {

    // nombre max de modules, taille max d'un code objet d'une unite
    static final int MAXMOD = 5, MAXOBJ = 1000;
    // nombres max de references externes (REF) et de points d'entree (DEF)
    // pour une unite
    private static final int MAXREF = 10, MAXDEF = 10;

    // typologie des erreurs
    private static final int FATALE = 0, NONFATALE = 1;

    // valeurs possibles du vecteur de translation
    private static final int TRANSDON=1,TRANSCODE=2,REFEXT=3;

    // table de tous les descripteurs concernes par l'edl
    static Descripteur[] tabDesc = new Descripteur[MAXMOD + 1];
    static int[] transDon = new int[MAXMOD + 1];
    static int[] transCode = new int[MAXMOD + 1];
    static EltDef[] dicoDef = new EltDef[(MAXMOD+1)*MAXDEF];
    static int[][] adFinale = new int[MAXMOD+1][MAXREF];
   static int[] vTrans = new int[MAXOBJ+1];
    static int ipo, nMod, nbErr;
    static String nomProg;


    // utilitaire de traitement des erreurs
    // ------------------------------------
    static void erreur(int te, String m) {
        System.out.println(m);
        if (te == FATALE) {
            System.out.println("ABANDON DE L'EDITION DE LIENS");
            System.exit(1);
        }
        nbErr = nbErr + 1;
    }

    // utilitaire de remplissage de la table des descripteurs tabDesc
    // --------------------------------------------------------------
    static void lireDescripteurs() {
        String s;
        System.out.println("les noms doivent etre fournis sans suffixe");
        System.out.print("nom du programme : ");
        s = Lecture.lireString();
        tabDesc[0] = new Descripteur();
        tabDesc[0].lireDesc(s);
        if (!tabDesc[0].getUnite().equals("programme"))
            erreur(FATALE, "programme attendu");
        nomProg = s;

        nMod = 0;
        while (!s.equals("") && nMod < MAXMOD) {
            System.out.print("nom de module " + (nMod + 1)
                    + " (RC si termine) ");
            s = Lecture.lireString();
            if (!s.equals("")) {
                nMod = nMod + 1;
                tabDesc[nMod] = new Descripteur();
                tabDesc[nMod].lireDesc(s);

                if (!tabDesc[nMod].getUnite().equals("module"))
                    erreur(FATALE, "module attendu");
            }
        }
    }

    static String[] tabProg = new String[MAXMOD+1]; // tab des programmes
    static void constMap() {
        // f2 = fichier executable .map construit
        OutputStream f2 = Ecriture.ouvrir(nomProg + ".map");
        if (f2 == null)
            erreur(FATALE, "creation du fichier " + nomProg
                    + ".map impossible");
        // pour construire le code concatene de toutes les unités
        int[] po = new int[(nMod + 1) * MAXOBJ + 1];
        //TODO : ... A COMPLETER ...
        //
        //Concatener les fichier .obj
        for(int i = 0; i < tabDesc.length; i++){
            InputStream f = Lecture.ouvrir(tabProg[i] + ".obj");
        }


        Ecriture.fermer(f2);

        // creation du fichier en mnemonique correspondant
        Mnemo.creerFichier(ipo, po, nomProg + ".ima");
    }

    public static void main(String argv[]) {
        System.out.println("EDITEUR DE LIENS / PROJET LICENCE");
        System.out.println("---------------------------------");
        System.out.println("");
        nbErr = 0;

        // Phase 1 de l'edition de liens
        // -----------------------------
        lireDescripteurs();
       
        
        //table de décalage transDon
        System.out.println("Table transDon: ");
        if(tabDesc[0].getUnite().equals("programme")){
            transDon[0] = 0;
        }
        if(tabDesc[nMod].getUnite().equals("module")){
            for(int i = 0; i <= nMod; i++){
                transDon[i + 1] = transDon[i] + tabDesc[i].getTailleGlobaux();
                System.out.println(transDon[i] + " ");
            }
        }

        //table de décalage transCode
        System.out.println("\n Table transCode:");
        if(tabDesc[0].getUnite().equals("programme")){
            transCode[0] = 0;
        }
        if(tabDesc[nMod].getUnite().equals("module")){
            for(int i = 0; i <= nMod; i++){
                transCode[i+1] = transCode[i] + tabDesc[i].getTailleCode();
                System.out.println(transCode[i] + " ");
            }
        }

        //Dictionnaire des points d'entrée dicoDef( union des tabDef)
        int indice = 1 ;
        System.out.println("\n Table dicoDef:");
        dicoDef[indice] = new EltDef(null, tabDesc[nMod].getTailleCode(),0);
                for(int j = 1; j <= nMod; j++){
                    for(int i = 1; i <= tabDesc[j].getNbDef(); i++) {
                        dicoDef[indice] = new EltDef(tabDesc[j].getDefNomProc(i),0,0);
                        dicoDef[indice].adPo += tabDesc[j].getDefAdPo(i) +  transCode[j];
                        dicoDef[indice].nbParam = tabDesc[j].getDefNbParam(i);
                        indice++;
                    }
                }
        indice = 1;
        while (dicoDef[indice] != null){
            System.out.println( indice  + " (" + dicoDef[indice].nomProc + ", " + dicoDef[indice].adPo + ", " + dicoDef[indice].nbParam + ")");
            indice++;
        }

        //Table de résolution des références ext adFinales
         System.out.println("\n Table adFinale:");

        for(int i = 0; i <= nMod; i++){
            if (tabDesc[i].getNbRef() > 0) { // Si nbRef = 0, ça ne sert à rien de parcourir tabRef
                for(int j = 1; j <= tabDesc[i].getNbRef(); j++) {
                    String nomProc = tabDesc[i].getRefNomProc(j);
                    int nbParam = tabDesc[i].getRefNbParam(j);

                    // parcourir dicoDef pour comparer avec les valeurs dans tabRef
                    for (int k = 1; k <= dicoDef.length; k++){
                        if (nomProc.equals(dicoDef[k].nomProc) && nbParam == dicoDef[k].nbParam){
                            adFinale[i][j] = dicoDef[k].adPo;
                            System.out.print(adFinale[i][j] + " | ");
                            break;
                        }
                    }
                }
            }
            else {System.out.print("\nvide");}
        }
        System.out.println("");

        if (nbErr > 0) {
            System.out.println("programme executable non produit");
            System.exit(1);
        }







        // Phase 2 de l'edition de liens
        // -----------------------------
        constMap();				//TODO : ... A COMPLETER ...

        System.out.println("Edition de liens terminee");
    }
}