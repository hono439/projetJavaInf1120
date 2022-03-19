
/**
 * Il s'agit de concevoir un petit prototype d'une application d'authentification
 * qui permet de creer des comptes utilisateurs en fournissant un nom d'utilisateur
 * et un mot de passe, et qui permet  a un utilisateur de se connecter a son compte 
 * en fournissant ses informations de connexion (son nom d'utilisateur et son mot de passe)
 *
 * author Ouedraogo Teguawinde Marie Honorine
 * Code Permanent : OUET14629806
 * Date : 2022-03-15
 */
public class GestionComptesUtilisateurs{
    //DECLARATION CONSTANTES

    //message de présentation du logiciel
    public static final String MSG_PRESENTATION = "APPLICATION D'AUTHENTIFICATION" 
        + "PROTOTYPE VERSION 1.0 \n";
    //message pour continuer apres une pause
    public static final String MSG_PAUSE = "Tapez sur <ENTREE> pour revenir au menu...";
    //message entete menu
    public static final String ENTETE_MENU = "====\n" 
        + "MENU\n"
        + "====\n";
    public static final String MENU_PRINCIPAL = "1.Creer un compte \n2." 
        + "S'authentifier \n3."  
        + "Quitter" + "\n";     
    //message de sollicitation du choix menu
    public static final String MSG_SOL_CHOIX = "Entrez votre choix"
        + " au menu : ";
    //message de sollicitation du nom
    public static final String MSG_SOL_NOM = "Entrez le nom d'utilisateur (<ENTREE> " 
        + "pour annuler : ";
    //message d'erreur de la longueur du nom
    public static final String MSG_ERR_NOM = "Erreur, le nom doit contenir entre 3 et "
        + "25 caracteres! Recommencez...";
    //message d'erreur des caracteres du nom
    public static final String MSG_ERR_NOM_CAR = "Erreur, le nom ne doit contenir que des lettres, des chiffres "
        + "ou les caracteres POINT (.) et TRAIT BAS (_). Recommencez...";
    //message d'erreur pour un taux horaire invalide
    public static final String MSG_ERR_CHOIX = "Erreur, choix de menu invalide! Recommencez... ";

    //public static final String MSG_PASSAGE = "Tapez sur <ENTREE> pour revenir au menu...";
    //message de fin du programme
    public static final String MSG_FIN = "Fin normale du programme.";
    //Le chiffre max valide du nom
    public static final int CHIFFRE_MIN = 0;

    //Le chiffre min valide du nom
    public static final int CHIFFRE_MAX = 9;
    //le choix 1 du menu
    public static final String CHOIX_1 = "1";

    //le choix 2 du menu 
    public static final String CHOIX_2 = "2";
    //le choix 3 du menu 
    public static final String CHOIX_3 = "3";

    // METHODES
    /**
     * Provoque l'arret temporaire du programme et demande de taper 
     * ENTER pour continuer.
     * 
     * @param msg le message a afficher
     */
    public static void pause (String msg) {
        System.out.print(msg);
        Clavier.lireFinLigne();
        System.out.println("\n");
    }

    /**
     * Affiche un message de fin du programme.
     * 
     * @param msgFin le message a afficher.
     */
    public static void afficherFinProg (String msgFin) {
        System.out.println(msgFin);
    }

    /**
     * Affiche une breve presentation du logiciel.
     * @param msgPres le message de presentation a afficher
     */

    public static void presentationApplication(String msgPres){
        System.out.println(msgPres);
    }

    /**
     * Presente le menu et demande a l'utilisateur de faire un choix de menu.
     * @param enteteMenu le message qui presente l'entete du menu
     * @param menu le message qui afficher le menu et demande le choix de l'utilisateur
     */

    public static void presentationMenu(String enteteMenu , String menu){
        System.out.println(enteteMenu);
        System.out.println(menu);
    }

    /**
     * Valide un nombre d'heures entre NBR_HR_MIN et NBR_HR_MAX puis retourne le 
     * nombre saisi et valide.
     * @return un nombre d'heures valide saisi par l'utilisateur.
     */
    public static String validerChoixMenu(String msgeSol , String msgeErr) {
        String choix;  //le choix de menu saisi
        boolean compare = true; //comparateur pour valider le choix de l'utilisateur aux diffrents choix du menu  
        //saisir et valider le choix du menu
        System.out.print(msgeSol);
        choix = Clavier.lireString();
        while(choix.equals(CHOIX_1)!= compare && choix.equals(CHOIX_2) != compare && choix.equals(CHOIX_3) != compare){
            System.out.println(msgeErr);
            System.out.print(msgeSol);
            choix = Clavier.lireString();
        }
        return choix;
    }

    public static String validerNom(String msgPause ,String enteteMenu , String menu, String msgSolNom,String msgErreurNom,String msgSolCara) {
        String nom;  //le choix nom saisi  
        char car= '0';
        boolean erreur = false;
        //saisir et valider le nom de l'utilisateur
        do{
            erreur = false;
            System.out.print(msgSolNom );
            nom = Clavier.lireString();
            if(nom.length() == 0){
                System.out.println ("*** OPERATION ANNULEE ! ***");
                pause (MSG_PAUSE);
                presentationMenu(ENTETE_MENU,MENU_PRINCIPAL);
                validerChoixMenu(MSG_SOL_CHOIX,MSG_ERR_CHOIX);
                System.out.print(msgSolNom);
            }else if (nom.length() != 0){
                if(nom.length() < 3 || nom.length() > 25){
                    erreur = true;  
                    System.out.println(msgErreurNom);
                }
                if(!erreur){
                    for(int i = 0; i< nom.length();i++){
                        if(nom.charAt(i) < 97 || nom.charAt(i) >122){
                            if(nom.charAt(i) < 65){
                                if(nom.charAt(i) < 48 || nom.charAt(i)>57){
                                    if(nom.charAt(i)!=46){
                                        erreur=true;
                                    }  
                                } 
                            }else if(nom.charAt(i)!=95){
                                erreur=true;
                            }
                        }
                    }
                    if(erreur){
                        System.out.println(msgSolCara);
                    }
                }
            }
        }while (erreur);
        return nom;
    }

    public static void main (String [] params) {
        //DECLARATION VARIBALES
        boolean fin = false; //compare le choix si c'est different de false on termine le programme
        String choixMenu; // le choix du menu
        String nom; // le nom saisi
        String messagepassage;
        presentationApplication(MSG_PRESENTATION);
        do{
            presentationMenu(ENTETE_MENU,MENU_PRINCIPAL);
            choixMenu = validerChoixMenu(MSG_SOL_CHOIX,MSG_ERR_CHOIX);
            switch (choixMenu ){
                case CHOIX_1:
                    nom = validerNom(MSG_PAUSE,ENTETE_MENU,MENU_PRINCIPAL,MSG_SOL_NOM,MSG_ERR_NOM,MSG_ERR_NOM_CAR);
                    break;
                case CHOIX_2:
                    break;
            }
        }while(choixMenu.equals(CHOIX_3) == fin );
        //afficher la fin du programme
        afficherFinProg(MSG_FIN);
    }

}
