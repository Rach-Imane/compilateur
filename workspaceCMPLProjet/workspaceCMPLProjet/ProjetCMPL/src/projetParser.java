// $ANTLR 3.5.2 projet.g 2024-04-17 23:46:30
           
	import java.io.IOException;
	import java.io.DataInputStream;
	import java.io.FileInputStream;
	

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class projetParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ID", "INT", "ML_COMMENT", 
		"RC", "WS", "'('", "')'", "'*'", "'+'", "','", "'-'", "':'", "':='", "';'", 
		"'<'", "'<='", "'<>'", "'='", "'>'", "'>='", "'alors'", "'aut'", "'bool'", 
		"'cond'", "'const'", "'debut'", "'def'", "'div'", "'ecrire'", "'ent'", 
		"'et'", "'faire'", "'fait'", "'faux'", "'fcond'", "'fin'", "'fixe'", "'fsi'", 
		"'lire'", "'mod'", "'module'", "'non'", "'ou'", "'proc'", "'programme'", 
		"'ref'", "'si'", "'sinon'", "'ttq'", "'var'", "'vrai'"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int COMMENT=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int ML_COMMENT=7;
	public static final int RC=8;
	public static final int WS=9;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public projetParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public projetParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return projetParser.tokenNames; }
	@Override public String getGrammarFileName() { return "projet.g"; }


		
		 
		// variables globales et methodes utiles a placer ici
		  
		


	// $ANTLR start "unite"
	// projet.g:39:2: unite : ( unitprog EOF | unitmodule EOF );
	public final void unite() throws RecognitionException {
		try {
			// projet.g:39:9: ( unitprog EOF | unitmodule EOF )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==49) ) {
				alt1=1;
			}
			else if ( (LA1_0==45) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// projet.g:39:13: unitprog EOF
					{
					pushFollow(FOLLOW_unitprog_in_unite95);
					unitprog();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite97); 
					PtGen.pt(255);
					PtGen.pt(58);
					}
					break;
				case 2 :
					// projet.g:40:13: unitmodule EOF
					{
					pushFollow(FOLLOW_unitmodule_in_unite116);
					unitmodule();
					state._fsp--;

					match(input,EOF,FOLLOW_EOF_in_unite118); 
					PtGen.pt(255);
					PtGen.pt(58);
					}
					break;

			}
		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unite"



	// $ANTLR start "unitprog"
	// projet.g:43:2: unitprog : 'programme' ident ':' declarations corps ;
	public final void unitprog() throws RecognitionException {
		try {
			// projet.g:44:4: ( 'programme' ident ':' declarations corps )
			// projet.g:44:6: 'programme' ident ':' declarations corps
			{
			match(input,49,FOLLOW_49_in_unitprog142); 
			pushFollow(FOLLOW_ident_in_unitprog144);
			ident();
			state._fsp--;

			match(input,16,FOLLOW_16_in_unitprog146); 
			PtGen.pt(53);
			pushFollow(FOLLOW_declarations_in_unitprog155);
			declarations();
			state._fsp--;

			pushFollow(FOLLOW_corps_in_unitprog164);
			corps();
			state._fsp--;

			 System.out.println("succes, arret de la compilation "); 
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitprog"



	// $ANTLR start "unitmodule"
	// projet.g:49:2: unitmodule : 'module' ident ':' declarations ;
	public final void unitmodule() throws RecognitionException {
		try {
			// projet.g:50:4: ( 'module' ident ':' declarations )
			// projet.g:50:6: 'module' ident ':' declarations
			{
			match(input,45,FOLLOW_45_in_unitmodule183); 
			pushFollow(FOLLOW_ident_in_unitmodule185);
			ident();
			state._fsp--;

			match(input,16,FOLLOW_16_in_unitmodule187); 
			PtGen.pt(54);
			pushFollow(FOLLOW_declarations_in_unitmodule196);
			declarations();
			state._fsp--;

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "unitmodule"



	// $ANTLR start "declarations"
	// projet.g:54:2: declarations : ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? ;
	public final void declarations() throws RecognitionException {
		try {
			// projet.g:55:4: ( ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )? )
			// projet.g:55:6: ( partiedef )? ( partieref )? ( consts )? ( vars )? ( decprocs )?
			{
			// projet.g:55:6: ( partiedef )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==31) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// projet.g:55:6: partiedef
					{
					pushFollow(FOLLOW_partiedef_in_declarations213);
					partiedef();
					state._fsp--;

					}
					break;

			}

			// projet.g:55:17: ( partieref )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==50) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// projet.g:55:17: partieref
					{
					pushFollow(FOLLOW_partieref_in_declarations216);
					partieref();
					state._fsp--;

					}
					break;

			}

			// projet.g:55:28: ( consts )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==29) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// projet.g:55:28: consts
					{
					pushFollow(FOLLOW_consts_in_declarations219);
					consts();
					state._fsp--;

					}
					break;

			}

			// projet.g:55:36: ( vars )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==54) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// projet.g:55:36: vars
					{
					pushFollow(FOLLOW_vars_in_declarations222);
					vars();
					state._fsp--;

					}
					break;

			}

			// projet.g:55:42: ( decprocs )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==48) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// projet.g:55:42: decprocs
					{
					pushFollow(FOLLOW_decprocs_in_declarations225);
					decprocs();
					state._fsp--;

					}
					break;

			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declarations"



	// $ANTLR start "partiedef"
	// projet.g:58:2: partiedef : 'def' ident ( ',' ident )* ptvg ;
	public final void partiedef() throws RecognitionException {
		try {
			// projet.g:59:4: ( 'def' ident ( ',' ident )* ptvg )
			// projet.g:59:6: 'def' ident ( ',' ident )* ptvg
			{
			match(input,31,FOLLOW_31_in_partiedef243); 
			pushFollow(FOLLOW_ident_in_partiedef245);
			ident();
			state._fsp--;

			PtGen.pt(57);
			// projet.g:59:35: ( ',' ident )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==14) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// projet.g:59:36: ',' ident
					{
					match(input,14,FOLLOW_14_in_partiedef251); 
					pushFollow(FOLLOW_ident_in_partiedef253);
					ident();
					state._fsp--;

					PtGen.pt(57);
					}
					break;

				default :
					break loop7;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partiedef260);
			ptvg();
			state._fsp--;

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partiedef"



	// $ANTLR start "partieref"
	// projet.g:62:2: partieref : 'ref' specif ( ',' specif )* ptvg ;
	public final void partieref() throws RecognitionException {
		try {
			// projet.g:62:11: ( 'ref' specif ( ',' specif )* ptvg )
			// projet.g:62:13: 'ref' specif ( ',' specif )* ptvg
			{
			match(input,50,FOLLOW_50_in_partieref273); 
			pushFollow(FOLLOW_specif_in_partieref275);
			specif();
			state._fsp--;

			PtGen.pt(56);
			// projet.g:62:44: ( ',' specif )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==14) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// projet.g:62:45: ',' specif
					{
					match(input,14,FOLLOW_14_in_partieref282); 
					pushFollow(FOLLOW_specif_in_partieref284);
					specif();
					state._fsp--;

					PtGen.pt(56);
					}
					break;

				default :
					break loop8;
				}
			}

			pushFollow(FOLLOW_ptvg_in_partieref291);
			ptvg();
			state._fsp--;

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partieref"



	// $ANTLR start "specif"
	// projet.g:65:2: specif : ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? ;
	public final void specif() throws RecognitionException {
		try {
			// projet.g:65:10: ( ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )? )
			// projet.g:65:12: ident ( 'fixe' '(' type ( ',' type )* ')' )? ( 'mod' '(' type ( ',' type )* ')' )?
			{
			pushFollow(FOLLOW_ident_in_specif307);
			ident();
			state._fsp--;

			// projet.g:65:19: ( 'fixe' '(' type ( ',' type )* ')' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==41) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// projet.g:65:21: 'fixe' '(' type ( ',' type )* ')'
					{
					match(input,41,FOLLOW_41_in_specif312); 
					match(input,10,FOLLOW_10_in_specif314); 
					pushFollow(FOLLOW_type_in_specif316);
					type();
					state._fsp--;

					PtGen.pt(55);
					// projet.g:65:54: ( ',' type )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==14) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// projet.g:65:56: ',' type
							{
							match(input,14,FOLLOW_14_in_specif323); 
							pushFollow(FOLLOW_type_in_specif325);
							type();
							state._fsp--;

							PtGen.pt(55);
							}
							break;

						default :
							break loop9;
						}
					}

					match(input,11,FOLLOW_11_in_specif333); 
					}
					break;

			}

			// projet.g:66:19: ( 'mod' '(' type ( ',' type )* ')' )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==44) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// projet.g:66:21: 'mod' '(' type ( ',' type )* ')'
					{
					match(input,44,FOLLOW_44_in_specif359); 
					match(input,10,FOLLOW_10_in_specif362); 
					pushFollow(FOLLOW_type_in_specif364);
					type();
					state._fsp--;

					PtGen.pt(55);
					// projet.g:66:54: ( ',' type )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==14) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// projet.g:66:56: ',' type
							{
							match(input,14,FOLLOW_14_in_specif371); 
							pushFollow(FOLLOW_type_in_specif373);
							type();
							state._fsp--;

							PtGen.pt(55);
							}
							break;

						default :
							break loop11;
						}
					}

					match(input,11,FOLLOW_11_in_specif381); 
					}
					break;

			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "specif"



	// $ANTLR start "consts"
	// projet.g:69:2: consts : 'const' ( ident '=' valeur ptvg )+ ;
	public final void consts() throws RecognitionException {
		try {
			// projet.g:69:10: ( 'const' ( ident '=' valeur ptvg )+ )
			// projet.g:69:12: 'const' ( ident '=' valeur ptvg )+
			{
			match(input,29,FOLLOW_29_in_consts400); 
			// projet.g:69:21: ( ident '=' valeur ptvg )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==ID) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// projet.g:69:23: ident '=' valeur ptvg
					{
					pushFollow(FOLLOW_ident_in_consts405);
					ident();
					state._fsp--;

					match(input,22,FOLLOW_22_in_consts407); 
					pushFollow(FOLLOW_valeur_in_consts409);
					valeur();
					state._fsp--;

					PtGen.pt(5);
					pushFollow(FOLLOW_ptvg_in_consts414);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "consts"



	// $ANTLR start "vars"
	// projet.g:72:2: vars : 'var' ( type ident ( ',' ident )* ptvg )+ ;
	public final void vars() throws RecognitionException {
		try {
			// projet.g:72:8: ( 'var' ( type ident ( ',' ident )* ptvg )+ )
			// projet.g:72:10: 'var' ( type ident ( ',' ident )* ptvg )+
			{
			match(input,54,FOLLOW_54_in_vars436); 
			// projet.g:72:16: ( type ident ( ',' ident )* ptvg )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==27||LA15_0==34) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// projet.g:72:18: type ident ( ',' ident )* ptvg
					{
					pushFollow(FOLLOW_type_in_vars440);
					type();
					state._fsp--;

					pushFollow(FOLLOW_ident_in_vars442);
					ident();
					state._fsp--;

					PtGen.pt(6);
					// projet.g:72:45: ( ',' ident )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==14) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// projet.g:72:47: ',' ident
							{
							match(input,14,FOLLOW_14_in_vars449); 
							pushFollow(FOLLOW_ident_in_vars451);
							ident();
							state._fsp--;

							PtGen.pt(6);
							}
							break;

						default :
							break loop14;
						}
					}

					pushFollow(FOLLOW_ptvg_in_vars458);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			PtGen.pt(24);
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "vars"



	// $ANTLR start "type"
	// projet.g:75:2: type : ( 'ent' | 'bool' );
	public final void type() throws RecognitionException {
		try {
			// projet.g:75:8: ( 'ent' | 'bool' )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==34) ) {
				alt16=1;
			}
			else if ( (LA16_0==27) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// projet.g:75:10: 'ent'
					{
					match(input,34,FOLLOW_34_in_type478); 
					PtGen.pt(22);
					}
					break;
				case 2 :
					// projet.g:76:10: 'bool'
					{
					match(input,27,FOLLOW_27_in_type492); 
					PtGen.pt(23);
					}
					break;

			}
		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "decprocs"
	// projet.g:79:2: decprocs : ( decproc ptvg )+ ;
	public final void decprocs() throws RecognitionException {
		try {
			// projet.g:79:10: ( ( decproc ptvg )+ )
			// projet.g:79:13: ( decproc ptvg )+
			{
			PtGen.pt(50);
			// projet.g:79:29: ( decproc ptvg )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==48) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// projet.g:79:31: decproc ptvg
					{
					pushFollow(FOLLOW_decproc_in_decprocs512);
					decproc();
					state._fsp--;

					pushFollow(FOLLOW_ptvg_in_decprocs514);
					ptvg();
					state._fsp--;

					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			PtGen.pt(52);
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decprocs"



	// $ANTLR start "decproc"
	// projet.g:82:2: decproc : 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps ;
	public final void decproc() throws RecognitionException {
		try {
			// projet.g:82:10: ( 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps )
			// projet.g:82:13: 'proc' ident ( parfixe )? ( parmod )? ( consts )? ( vars )? corps
			{
			match(input,48,FOLLOW_48_in_decproc534); 
			pushFollow(FOLLOW_ident_in_decproc537);
			ident();
			state._fsp--;

			PtGen.pt(41);
			// projet.g:82:45: ( parfixe )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==41) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// projet.g:82:45: parfixe
					{
					pushFollow(FOLLOW_parfixe_in_decproc543);
					parfixe();
					state._fsp--;

					}
					break;

			}

			// projet.g:82:54: ( parmod )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==44) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// projet.g:82:54: parmod
					{
					pushFollow(FOLLOW_parmod_in_decproc546);
					parmod();
					state._fsp--;

					}
					break;

			}

			PtGen.pt(49);
			// projet.g:82:78: ( consts )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==29) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// projet.g:82:78: consts
					{
					pushFollow(FOLLOW_consts_in_decproc551);
					consts();
					state._fsp--;

					}
					break;

			}

			// projet.g:82:86: ( vars )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==54) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// projet.g:82:86: vars
					{
					pushFollow(FOLLOW_vars_in_decproc554);
					vars();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_corps_in_decproc557);
			corps();
			state._fsp--;

			PtGen.pt(47);
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decproc"



	// $ANTLR start "ptvg"
	// projet.g:85:2: ptvg : ( ';' |);
	public final void ptvg() throws RecognitionException {
		try {
			// projet.g:85:8: ( ';' |)
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==18) ) {
				alt22=1;
			}
			else if ( (LA22_0==EOF||LA22_0==ID||LA22_0==27||(LA22_0 >= 29 && LA22_0 <= 30)||LA22_0==34||LA22_0==48||LA22_0==50||LA22_0==54) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// projet.g:85:10: ';'
					{
					match(input,18,FOLLOW_18_in_ptvg574); 
					}
					break;
				case 2 :
					// projet.g:87:4: 
					{
					}
					break;

			}
		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ptvg"



	// $ANTLR start "corps"
	// projet.g:89:2: corps : 'debut' instructions 'fin' ;
	public final void corps() throws RecognitionException {
		try {
			// projet.g:89:8: ( 'debut' instructions 'fin' )
			// projet.g:89:10: 'debut' instructions 'fin'
			{
			match(input,30,FOLLOW_30_in_corps593); 
			pushFollow(FOLLOW_instructions_in_corps596);
			instructions();
			state._fsp--;

			match(input,40,FOLLOW_40_in_corps598); 
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "corps"



	// $ANTLR start "parfixe"
	// projet.g:92:2: parfixe : 'fixe' '(' pf ( ';' pf )* ')' ;
	public final void parfixe() throws RecognitionException {
		try {
			// projet.g:92:9: ( 'fixe' '(' pf ( ';' pf )* ')' )
			// projet.g:92:11: 'fixe' '(' pf ( ';' pf )* ')'
			{
			match(input,41,FOLLOW_41_in_parfixe612); 
			match(input,10,FOLLOW_10_in_parfixe614); 
			pushFollow(FOLLOW_pf_in_parfixe616);
			pf();
			state._fsp--;

			// projet.g:92:25: ( ';' pf )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==18) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// projet.g:92:27: ';' pf
					{
					match(input,18,FOLLOW_18_in_parfixe620); 
					pushFollow(FOLLOW_pf_in_parfixe622);
					pf();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			match(input,11,FOLLOW_11_in_parfixe626); 
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parfixe"



	// $ANTLR start "pf"
	// projet.g:95:2: pf : type ident ( ',' ident )* ;
	public final void pf() throws RecognitionException {
		try {
			// projet.g:95:6: ( type ident ( ',' ident )* )
			// projet.g:95:8: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pf641);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pf643);
			ident();
			state._fsp--;

			PtGen.pt(42);
			// projet.g:95:35: ( ',' ident )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==14) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// projet.g:95:37: ',' ident
					{
					match(input,14,FOLLOW_14_in_pf649); 
					pushFollow(FOLLOW_ident_in_pf651);
					ident();
					state._fsp--;

					PtGen.pt(42);
					}
					break;

				default :
					break loop24;
				}
			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pf"



	// $ANTLR start "parmod"
	// projet.g:98:2: parmod : 'mod' '(' pm ( ';' pm )* ')' ;
	public final void parmod() throws RecognitionException {
		try {
			// projet.g:98:10: ( 'mod' '(' pm ( ';' pm )* ')' )
			// projet.g:98:12: 'mod' '(' pm ( ';' pm )* ')'
			{
			match(input,44,FOLLOW_44_in_parmod672); 
			match(input,10,FOLLOW_10_in_parmod674); 
			pushFollow(FOLLOW_pm_in_parmod676);
			pm();
			state._fsp--;

			// projet.g:98:25: ( ';' pm )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==18) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// projet.g:98:27: ';' pm
					{
					match(input,18,FOLLOW_18_in_parmod680); 
					pushFollow(FOLLOW_pm_in_parmod682);
					pm();
					state._fsp--;

					}
					break;

				default :
					break loop25;
				}
			}

			match(input,11,FOLLOW_11_in_parmod686); 
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "parmod"



	// $ANTLR start "pm"
	// projet.g:101:2: pm : type ident ( ',' ident )* ;
	public final void pm() throws RecognitionException {
		try {
			// projet.g:101:6: ( type ident ( ',' ident )* )
			// projet.g:101:8: type ident ( ',' ident )*
			{
			pushFollow(FOLLOW_type_in_pm701);
			type();
			state._fsp--;

			pushFollow(FOLLOW_ident_in_pm703);
			ident();
			state._fsp--;

			PtGen.pt(43);
			// projet.g:101:35: ( ',' ident )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==14) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// projet.g:101:37: ',' ident
					{
					match(input,14,FOLLOW_14_in_pm709); 
					pushFollow(FOLLOW_ident_in_pm711);
					ident();
					state._fsp--;

					PtGen.pt(43);
					}
					break;

				default :
					break loop26;
				}
			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pm"



	// $ANTLR start "instructions"
	// projet.g:104:2: instructions : instruction ( ';' instruction )* ;
	public final void instructions() throws RecognitionException {
		try {
			// projet.g:105:4: ( instruction ( ';' instruction )* )
			// projet.g:105:6: instruction ( ';' instruction )*
			{
			pushFollow(FOLLOW_instruction_in_instructions733);
			instruction();
			state._fsp--;

			// projet.g:105:18: ( ';' instruction )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==18) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// projet.g:105:20: ';' instruction
					{
					match(input,18,FOLLOW_18_in_instructions737); 
					pushFollow(FOLLOW_instruction_in_instructions739);
					instruction();
					state._fsp--;

					}
					break;

				default :
					break loop27;
				}
			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instructions"



	// $ANTLR start "instruction"
	// projet.g:108:2: instruction : ( inssi | inscond | boucle | lecture | ecriture | affouappel |);
	public final void instruction() throws RecognitionException {
		try {
			// projet.g:109:4: ( inssi | inscond | boucle | lecture | ecriture | affouappel |)
			int alt28=7;
			switch ( input.LA(1) ) {
			case 51:
				{
				alt28=1;
				}
				break;
			case 28:
				{
				alt28=2;
				}
				break;
			case 53:
				{
				alt28=3;
				}
				break;
			case 43:
				{
				alt28=4;
				}
				break;
			case 33:
				{
				alt28=5;
				}
				break;
			case ID:
				{
				alt28=6;
				}
				break;
			case 14:
			case 18:
			case 26:
			case 37:
			case 39:
			case 40:
			case 42:
			case 52:
				{
				alt28=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// projet.g:109:6: inssi
					{
					pushFollow(FOLLOW_inssi_in_instruction758);
					inssi();
					state._fsp--;

					}
					break;
				case 2 :
					// projet.g:110:6: inscond
					{
					pushFollow(FOLLOW_inscond_in_instruction765);
					inscond();
					state._fsp--;

					}
					break;
				case 3 :
					// projet.g:111:6: boucle
					{
					pushFollow(FOLLOW_boucle_in_instruction772);
					boucle();
					state._fsp--;

					}
					break;
				case 4 :
					// projet.g:112:6: lecture
					{
					pushFollow(FOLLOW_lecture_in_instruction779);
					lecture();
					state._fsp--;

					}
					break;
				case 5 :
					// projet.g:113:6: ecriture
					{
					pushFollow(FOLLOW_ecriture_in_instruction786);
					ecriture();
					state._fsp--;

					}
					break;
				case 6 :
					// projet.g:114:6: affouappel
					{
					pushFollow(FOLLOW_affouappel_in_instruction793);
					affouappel();
					state._fsp--;

					}
					break;
				case 7 :
					// projet.g:116:4: 
					{
					}
					break;

			}
		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instruction"



	// $ANTLR start "inssi"
	// projet.g:118:2: inssi : 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' ;
	public final void inssi() throws RecognitionException {
		try {
			// projet.g:118:8: ( 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi' )
			// projet.g:118:10: 'si' expression 'alors' instructions ( 'sinon' instructions )? 'fsi'
			{
			match(input,51,FOLLOW_51_in_inssi812); 
			pushFollow(FOLLOW_expression_in_inssi815);
			expression();
			state._fsp--;

			PtGen.pt(29);
			match(input,25,FOLLOW_25_in_inssi828); 
			pushFollow(FOLLOW_instructions_in_inssi830);
			instructions();
			state._fsp--;

			// projet.g:119:31: ( 'sinon' instructions )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==52) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// projet.g:119:32: 'sinon' instructions
					{
					match(input,52,FOLLOW_52_in_inssi833); 
					PtGen.pt(30);
					pushFollow(FOLLOW_instructions_in_inssi837);
					instructions();
					state._fsp--;

					}
					break;

			}

			match(input,42,FOLLOW_42_in_inssi841); 
			PtGen.pt(31);
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inssi"



	// $ANTLR start "inscond"
	// projet.g:122:2: inscond : 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' ;
	public final void inscond() throws RecognitionException {
		try {
			// projet.g:122:10: ( 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond' )
			// projet.g:122:12: 'cond' expression ':' instructions ( ',' expression ':' instructions )* ( 'aut' instructions |) 'fcond'
			{
			match(input,28,FOLLOW_28_in_inscond857); 
			pushFollow(FOLLOW_expression_in_inscond860);
			expression();
			state._fsp--;

			PtGen.pt(29);
			match(input,16,FOLLOW_16_in_inscond865); 
			pushFollow(FOLLOW_instructions_in_inscond867);
			instructions();
			state._fsp--;

			PtGen.pt(30);
			// projet.g:123:12: ( ',' expression ':' instructions )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==14) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// projet.g:123:13: ',' expression ':' instructions
					{
					match(input,14,FOLLOW_14_in_inscond883); 
					pushFollow(FOLLOW_expression_in_inscond886);
					expression();
					state._fsp--;

					PtGen.pt(29);
					match(input,16,FOLLOW_16_in_inscond890); 
					pushFollow(FOLLOW_instructions_in_inscond892);
					instructions();
					state._fsp--;

					}
					break;

				default :
					break loop30;
				}
			}

			// projet.g:124:12: ( 'aut' instructions |)
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==26) ) {
				alt31=1;
			}
			else if ( (LA31_0==39) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// projet.g:124:13: 'aut' instructions
					{
					match(input,26,FOLLOW_26_in_inscond910); 
					pushFollow(FOLLOW_instructions_in_inscond913);
					instructions();
					state._fsp--;

					PtGen.pt(37);
					}
					break;
				case 2 :
					// projet.g:124:51: 
					{
					PtGen.pt(38);
					}
					break;

			}

			match(input,39,FOLLOW_39_in_inscond934); 
			PtGen.pt(39);
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inscond"



	// $ANTLR start "boucle"
	// projet.g:128:2: boucle : 'ttq' expression 'faire' instructions 'fait' ;
	public final void boucle() throws RecognitionException {
		try {
			// projet.g:128:10: ( 'ttq' expression 'faire' instructions 'fait' )
			// projet.g:128:12: 'ttq' expression 'faire' instructions 'fait'
			{
			match(input,53,FOLLOW_53_in_boucle952); 
			PtGen.pt(34);
			pushFollow(FOLLOW_expression_in_boucle957);
			expression();
			state._fsp--;

			PtGen.pt(29);
			match(input,36,FOLLOW_36_in_boucle961); 
			pushFollow(FOLLOW_instructions_in_boucle963);
			instructions();
			state._fsp--;

			PtGen.pt(35);
			match(input,37,FOLLOW_37_in_boucle967); 
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "boucle"



	// $ANTLR start "lecture"
	// projet.g:131:2: lecture : 'lire' '(' ident ( ',' ident )* ')' ;
	public final void lecture() throws RecognitionException {
		try {
			// projet.g:131:9: ( 'lire' '(' ident ( ',' ident )* ')' )
			// projet.g:131:11: 'lire' '(' ident ( ',' ident )* ')'
			{
			match(input,43,FOLLOW_43_in_lecture980); 
			match(input,10,FOLLOW_10_in_lecture983); 
			pushFollow(FOLLOW_ident_in_lecture985);
			ident();
			state._fsp--;

			PtGen.pt(40);
			PtGen.pt(27);
			PtGen.pt(32);
			// projet.g:131:78: ( ',' ident )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==14) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// projet.g:131:80: ',' ident
					{
					match(input,14,FOLLOW_14_in_lecture996); 
					pushFollow(FOLLOW_ident_in_lecture998);
					ident();
					state._fsp--;

					PtGen.pt(40);
					PtGen.pt(27);
					PtGen.pt(32);
					}
					break;

				default :
					break loop32;
				}
			}

			match(input,11,FOLLOW_11_in_lecture1009); 
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lecture"



	// $ANTLR start "ecriture"
	// projet.g:134:2: ecriture : 'ecrire' '(' expression ( ',' expression )* ')' ;
	public final void ecriture() throws RecognitionException {
		try {
			// projet.g:134:10: ( 'ecrire' '(' expression ( ',' expression )* ')' )
			// projet.g:134:12: 'ecrire' '(' expression ( ',' expression )* ')'
			{
			match(input,33,FOLLOW_33_in_ecriture1022); 
			match(input,10,FOLLOW_10_in_ecriture1024); 
			pushFollow(FOLLOW_expression_in_ecriture1026);
			expression();
			state._fsp--;

			PtGen.pt(40);
			PtGen.pt(26);
			// projet.g:134:68: ( ',' expression )*
			loop33:
			while (true) {
				int alt33=2;
				int LA33_0 = input.LA(1);
				if ( (LA33_0==14) ) {
					alt33=1;
				}

				switch (alt33) {
				case 1 :
					// projet.g:134:70: ',' expression
					{
					match(input,14,FOLLOW_14_in_ecriture1034); 
					pushFollow(FOLLOW_expression_in_ecriture1036);
					expression();
					state._fsp--;

					PtGen.pt(40);
					PtGen.pt(26);
					}
					break;

				default :
					break loop33;
				}
			}

			match(input,11,FOLLOW_11_in_ecriture1045); 
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ecriture"



	// $ANTLR start "affouappel"
	// projet.g:137:2: affouappel : ident ( ':=' expression | ( effixes ( effmods )? )? ) ;
	public final void affouappel() throws RecognitionException {
		try {
			// projet.g:138:4: ( ident ( ':=' expression | ( effixes ( effmods )? )? ) )
			// projet.g:138:6: ident ( ':=' expression | ( effixes ( effmods )? )? )
			{
			pushFollow(FOLLOW_ident_in_affouappel1063);
			ident();
			state._fsp--;

			PtGen.pt(40);
			// projet.g:138:29: ( ':=' expression | ( effixes ( effmods )? )? )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==17) ) {
				alt36=1;
			}
			else if ( (LA36_0==10||LA36_0==14||LA36_0==18||LA36_0==26||LA36_0==37||(LA36_0 >= 39 && LA36_0 <= 40)||LA36_0==42||LA36_0==52) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// projet.g:138:33: ':=' expression
					{
					PtGen.pt(48);
					match(input,17,FOLLOW_17_in_affouappel1073); 
					pushFollow(FOLLOW_expression_in_affouappel1075);
					expression();
					state._fsp--;

					PtGen.pt(32);
					}
					break;
				case 2 :
					// projet.g:139:16: ( effixes ( effmods )? )?
					{
					PtGen.pt(46);
					// projet.g:139:33: ( effixes ( effmods )? )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==10) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// projet.g:139:34: effixes ( effmods )?
							{
							pushFollow(FOLLOW_effixes_in_affouappel1099);
							effixes();
							state._fsp--;

							PtGen.pt(51);
							// projet.g:139:57: ( effmods )?
							int alt34=2;
							int LA34_0 = input.LA(1);
							if ( (LA34_0==10) ) {
								alt34=1;
							}
							switch (alt34) {
								case 1 :
									// projet.g:139:58: effmods
									{
									pushFollow(FOLLOW_effmods_in_affouappel1103);
									effmods();
									state._fsp--;

									PtGen.pt(51);
									}
									break;

							}

							}
							break;

					}

					PtGen.pt(45);
					}
					break;

			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "affouappel"



	// $ANTLR start "effixes"
	// projet.g:143:2: effixes : '(' ( expression ( ',' expression )* )? ')' ;
	public final void effixes() throws RecognitionException {
		try {
			// projet.g:143:10: ( '(' ( expression ( ',' expression )* )? ')' )
			// projet.g:143:12: '(' ( expression ( ',' expression )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effixes1139); 
			// projet.g:143:16: ( expression ( ',' expression )* )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( ((LA38_0 >= ID && LA38_0 <= INT)||LA38_0==13||LA38_0==15||LA38_0==38||LA38_0==46||LA38_0==55) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// projet.g:143:17: expression ( ',' expression )*
					{
					pushFollow(FOLLOW_expression_in_effixes1142);
					expression();
					state._fsp--;

					// projet.g:143:30: ( ',' expression )*
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==14) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// projet.g:143:31: ',' expression
							{
							match(input,14,FOLLOW_14_in_effixes1147); 
							pushFollow(FOLLOW_expression_in_effixes1149);
							expression();
							state._fsp--;

							}
							break;

						default :
							break loop37;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effixes1157); 
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effixes"



	// $ANTLR start "effmods"
	// projet.g:146:2: effmods : '(' ( ident ( ',' ident )* )? ')' ;
	public final void effmods() throws RecognitionException {
		try {
			// projet.g:146:10: ( '(' ( ident ( ',' ident )* )? ')' )
			// projet.g:146:11: '(' ( ident ( ',' ident )* )? ')'
			{
			match(input,10,FOLLOW_10_in_effmods1170); 
			// projet.g:146:15: ( ident ( ',' ident )* )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==ID) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// projet.g:146:16: ident ( ',' ident )*
					{
					pushFollow(FOLLOW_ident_in_effmods1173);
					ident();
					state._fsp--;

					PtGen.pt(40);
					PtGen.pt(44);
					// projet.g:146:53: ( ',' ident )*
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==14) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// projet.g:146:54: ',' ident
							{
							match(input,14,FOLLOW_14_in_effmods1179); 
							pushFollow(FOLLOW_ident_in_effmods1181);
							ident();
							state._fsp--;

							PtGen.pt(40);
							PtGen.pt(44);
							}
							break;

						default :
							break loop39;
						}
					}

					}
					break;

			}

			match(input,11,FOLLOW_11_in_effmods1191); 
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effmods"



	// $ANTLR start "expression"
	// projet.g:149:2: expression : ( exp1 ) ( 'ou' exp1 )* ;
	public final void expression() throws RecognitionException {
		try {
			// projet.g:149:12: ( ( exp1 ) ( 'ou' exp1 )* )
			// projet.g:149:14: ( exp1 ) ( 'ou' exp1 )*
			{
			// projet.g:149:14: ( exp1 )
			// projet.g:149:15: exp1
			{
			pushFollow(FOLLOW_exp1_in_expression1205);
			exp1();
			state._fsp--;

			}

			// projet.g:149:22: ( 'ou' exp1 )*
			loop41:
			while (true) {
				int alt41=2;
				int LA41_0 = input.LA(1);
				if ( (LA41_0==47) ) {
					alt41=1;
				}

				switch (alt41) {
				case 1 :
					// projet.g:149:23: 'ou' exp1
					{
					PtGen.pt(7);
					match(input,47,FOLLOW_47_in_expression1212); 
					pushFollow(FOLLOW_exp1_in_expression1214);
					exp1();
					state._fsp--;

					PtGen.pt(7);
					PtGen.pt(8);
					}
					break;

				default :
					break loop41;
				}
			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "exp1"
	// projet.g:152:2: exp1 : exp2 ( 'et' exp2 )* ;
	public final void exp1() throws RecognitionException {
		try {
			// projet.g:152:8: ( exp2 ( 'et' exp2 )* )
			// projet.g:152:10: exp2 ( 'et' exp2 )*
			{
			pushFollow(FOLLOW_exp2_in_exp11236);
			exp2();
			state._fsp--;

			// projet.g:152:15: ( 'et' exp2 )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==35) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// projet.g:152:16: 'et' exp2
					{
					match(input,35,FOLLOW_35_in_exp11239); 
					PtGen.pt(7);
					pushFollow(FOLLOW_exp2_in_exp11245);
					exp2();
					state._fsp--;

					PtGen.pt(7);
					PtGen.pt(9);
					}
					break;

				default :
					break loop42;
				}
			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp1"



	// $ANTLR start "exp2"
	// projet.g:155:2: exp2 : ( 'non' exp2 | exp3 );
	public final void exp2() throws RecognitionException {
		try {
			// projet.g:155:8: ( 'non' exp2 | exp3 )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==46) ) {
				alt43=1;
			}
			else if ( ((LA43_0 >= ID && LA43_0 <= INT)||LA43_0==13||LA43_0==15||LA43_0==38||LA43_0==55) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// projet.g:155:10: 'non' exp2
					{
					match(input,46,FOLLOW_46_in_exp21267); 
					pushFollow(FOLLOW_exp2_in_exp21269);
					exp2();
					state._fsp--;

					PtGen.pt(7);
					PtGen.pt(10);
					}
					break;
				case 2 :
					// projet.g:156:6: exp3
					{
					pushFollow(FOLLOW_exp3_in_exp21280);
					exp3();
					state._fsp--;

					}
					break;

			}
		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp2"



	// $ANTLR start "exp3"
	// projet.g:159:2: exp3 : exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? ;
	public final void exp3() throws RecognitionException {
		try {
			// projet.g:159:8: ( exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )? )
			// projet.g:159:10: exp4 ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			{
			pushFollow(FOLLOW_exp4_in_exp31297);
			exp4();
			state._fsp--;

			// projet.g:160:4: ( '=' exp4 | '<>' exp4 | '>' exp4 | '>=' exp4 | '<' exp4 | '<=' exp4 )?
			int alt44=7;
			switch ( input.LA(1) ) {
				case 22:
					{
					alt44=1;
					}
					break;
				case 21:
					{
					alt44=2;
					}
					break;
				case 23:
					{
					alt44=3;
					}
					break;
				case 24:
					{
					alt44=4;
					}
					break;
				case 19:
					{
					alt44=5;
					}
					break;
				case 20:
					{
					alt44=6;
					}
					break;
			}
			switch (alt44) {
				case 1 :
					// projet.g:160:6: '=' exp4
					{
					PtGen.pt(11);
					match(input,22,FOLLOW_22_in_exp31306); 
					pushFollow(FOLLOW_exp4_in_exp31309);
					exp4();
					state._fsp--;

					PtGen.pt(11);
					PtGen.pt(16);
					}
					break;
				case 2 :
					// projet.g:161:5: '<>' exp4
					{
					PtGen.pt(11);
					match(input,21,FOLLOW_21_in_exp31321); 
					pushFollow(FOLLOW_exp4_in_exp31324);
					exp4();
					state._fsp--;

					PtGen.pt(11);
					PtGen.pt(17);
					}
					break;
				case 3 :
					// projet.g:162:5: '>' exp4
					{
					PtGen.pt(11);
					match(input,23,FOLLOW_23_in_exp31336); 
					pushFollow(FOLLOW_exp4_in_exp31340);
					exp4();
					state._fsp--;

					PtGen.pt(11);
					PtGen.pt(14);
					}
					break;
				case 4 :
					// projet.g:163:5: '>=' exp4
					{
					PtGen.pt(11);
					match(input,24,FOLLOW_24_in_exp31352); 
					pushFollow(FOLLOW_exp4_in_exp31355);
					exp4();
					state._fsp--;

					PtGen.pt(11);
					PtGen.pt(15);
					}
					break;
				case 5 :
					// projet.g:164:5: '<' exp4
					{
					PtGen.pt(11);
					match(input,19,FOLLOW_19_in_exp31367); 
					pushFollow(FOLLOW_exp4_in_exp31371);
					exp4();
					state._fsp--;

					PtGen.pt(11);
					PtGen.pt(12);
					}
					break;
				case 6 :
					// projet.g:165:5: '<=' exp4
					{
					PtGen.pt(11);
					match(input,20,FOLLOW_20_in_exp31383); 
					pushFollow(FOLLOW_exp4_in_exp31386);
					exp4();
					state._fsp--;

					PtGen.pt(11);
					PtGen.pt(13);
					}
					break;

			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp3"



	// $ANTLR start "exp4"
	// projet.g:169:2: exp4 : exp5 ( '+' exp5 | '-' exp5 )* ;
	public final void exp4() throws RecognitionException {
		try {
			// projet.g:169:8: ( exp5 ( '+' exp5 | '-' exp5 )* )
			// projet.g:169:10: exp5 ( '+' exp5 | '-' exp5 )*
			{
			pushFollow(FOLLOW_exp5_in_exp41412);
			exp5();
			state._fsp--;

			// projet.g:170:10: ( '+' exp5 | '-' exp5 )*
			loop45:
			while (true) {
				int alt45=3;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==13) ) {
					alt45=1;
				}
				else if ( (LA45_0==15) ) {
					alt45=2;
				}

				switch (alt45) {
				case 1 :
					// projet.g:170:11: '+' exp5
					{
					PtGen.pt(11);
					match(input,13,FOLLOW_13_in_exp41426); 
					pushFollow(FOLLOW_exp5_in_exp41429);
					exp5();
					state._fsp--;

					PtGen.pt(11);
					PtGen.pt(18);
					}
					break;
				case 2 :
					// projet.g:171:11: '-' exp5
					{
					PtGen.pt(11);
					match(input,15,FOLLOW_15_in_exp41447); 
					pushFollow(FOLLOW_exp5_in_exp41450);
					exp5();
					state._fsp--;

					PtGen.pt(11);
					PtGen.pt(19);
					}
					break;

				default :
					break loop45;
				}
			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp4"



	// $ANTLR start "exp5"
	// projet.g:175:2: exp5 : primaire ( '*' primaire | 'div' primaire )* ;
	public final void exp5() throws RecognitionException {
		try {
			// projet.g:175:8: ( primaire ( '*' primaire | 'div' primaire )* )
			// projet.g:175:10: primaire ( '*' primaire | 'div' primaire )*
			{
			pushFollow(FOLLOW_primaire_in_exp51481);
			primaire();
			state._fsp--;

			// projet.g:176:10: ( '*' primaire | 'div' primaire )*
			loop46:
			while (true) {
				int alt46=3;
				int LA46_0 = input.LA(1);
				if ( (LA46_0==12) ) {
					alt46=1;
				}
				else if ( (LA46_0==32) ) {
					alt46=2;
				}

				switch (alt46) {
				case 1 :
					// projet.g:176:13: '*' primaire
					{
					PtGen.pt(11);
					match(input,12,FOLLOW_12_in_exp51498); 
					pushFollow(FOLLOW_primaire_in_exp51502);
					primaire();
					state._fsp--;

					PtGen.pt(11);
					PtGen.pt(20);
					}
					break;
				case 2 :
					// projet.g:177:13: 'div' primaire
					{
					PtGen.pt(11);
					match(input,32,FOLLOW_32_in_exp51521); 
					pushFollow(FOLLOW_primaire_in_exp51524);
					primaire();
					state._fsp--;

					PtGen.pt(11);
					PtGen.pt(21);
					}
					break;

				default :
					break loop46;
				}
			}

			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exp5"



	// $ANTLR start "primaire"
	// projet.g:181:2: primaire : ( valeur | ident );
	public final void primaire() throws RecognitionException {
		try {
			// projet.g:181:10: ( valeur | ident )
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==INT||LA47_0==13||LA47_0==15||LA47_0==38||LA47_0==55) ) {
				alt47=1;
			}
			else if ( (LA47_0==ID) ) {
				alt47=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}

			switch (alt47) {
				case 1 :
					// projet.g:181:12: valeur
					{
					pushFollow(FOLLOW_valeur_in_primaire1553);
					valeur();
					state._fsp--;

					PtGen.pt(25);
					}
					break;
				case 2 :
					// projet.g:182:6: ident
					{
					pushFollow(FOLLOW_ident_in_primaire1562);
					ident();
					state._fsp--;

					PtGen.pt(40);
					PtGen.pt(28);
					}
					break;

			}
		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "primaire"



	// $ANTLR start "valeur"
	// projet.g:185:2: valeur : ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' );
	public final void valeur() throws RecognitionException {
		try {
			// projet.g:185:10: ( nbentier | '+' nbentier | '-' nbentier | 'vrai' | 'faux' )
			int alt48=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt48=1;
				}
				break;
			case 13:
				{
				alt48=2;
				}
				break;
			case 15:
				{
				alt48=3;
				}
				break;
			case 55:
				{
				alt48=4;
				}
				break;
			case 38:
				{
				alt48=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}
			switch (alt48) {
				case 1 :
					// projet.g:185:12: nbentier
					{
					pushFollow(FOLLOW_nbentier_in_valeur1581);
					nbentier();
					state._fsp--;

					PtGen.pt(1);
					}
					break;
				case 2 :
					// projet.g:186:6: '+' nbentier
					{
					match(input,13,FOLLOW_13_in_valeur1590); 
					pushFollow(FOLLOW_nbentier_in_valeur1592);
					nbentier();
					state._fsp--;

					PtGen.pt(1);
					}
					break;
				case 3 :
					// projet.g:187:6: '-' nbentier
					{
					match(input,15,FOLLOW_15_in_valeur1601); 
					pushFollow(FOLLOW_nbentier_in_valeur1603);
					nbentier();
					state._fsp--;

					PtGen.pt(2);
					}
					break;
				case 4 :
					// projet.g:188:6: 'vrai'
					{
					match(input,55,FOLLOW_55_in_valeur1612); 
					PtGen.pt(3);
					}
					break;
				case 5 :
					// projet.g:189:6: 'faux'
					{
					match(input,38,FOLLOW_38_in_valeur1621); 
					PtGen.pt(4);
					}
					break;

			}
		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "valeur"



	// $ANTLR start "nbentier"
	// projet.g:199:2: nbentier : INT ;
	public final void nbentier() throws RecognitionException {
		Token INT1=null;

		try {
			// projet.g:199:12: ( INT )
			// projet.g:199:16: INT
			{
			INT1=(Token)match(input,INT,FOLLOW_INT_in_nbentier1661); 
			 UtilLex.valEnt = Integer.parseInt((INT1!=null?INT1.getText():null));
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "nbentier"



	// $ANTLR start "ident"
	// projet.g:201:2: ident : ID ;
	public final void ident() throws RecognitionException {
		Token ID2=null;

		try {
			// projet.g:201:8: ( ID )
			// projet.g:201:10: ID
			{
			ID2=(Token)match(input,ID,FOLLOW_ID_in_ident1674); 
			 UtilLex.traiterId((ID2!=null?ID2.getText():null)); 
			}

		}

			catch (RecognitionException e) {reportError (e) ; throw e ; }
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ident"

	// Delegated rules



	public static final BitSet FOLLOW_unitprog_in_unite95 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unitmodule_in_unite116 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_unite118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_unitprog142 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitprog144 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitprog146 = new BitSet(new long[]{0x00450000E0000000L});
	public static final BitSet FOLLOW_declarations_in_unitprog155 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_unitprog164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_unitmodule183 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_unitmodule185 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_unitmodule187 = new BitSet(new long[]{0x00450000A0000000L});
	public static final BitSet FOLLOW_declarations_in_unitmodule196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partiedef_in_declarations213 = new BitSet(new long[]{0x0045000020000002L});
	public static final BitSet FOLLOW_partieref_in_declarations216 = new BitSet(new long[]{0x0041000020000002L});
	public static final BitSet FOLLOW_consts_in_declarations219 = new BitSet(new long[]{0x0041000000000002L});
	public static final BitSet FOLLOW_vars_in_declarations222 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_decprocs_in_declarations225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_partiedef243 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef245 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partiedef251 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_partiedef253 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partiedef260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_partieref273 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref275 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_14_in_partieref282 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_specif_in_partieref284 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_ptvg_in_partieref291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_specif307 = new BitSet(new long[]{0x0000120000000002L});
	public static final BitSet FOLLOW_41_in_specif312 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif314 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif316 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif323 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif325 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif333 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_44_in_specif359 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_specif362 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif364 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_specif371 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_specif373 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_specif381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_consts400 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_consts405 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_consts407 = new BitSet(new long[]{0x008000400000A040L});
	public static final BitSet FOLLOW_valeur_in_consts409 = new BitSet(new long[]{0x0000000000040020L});
	public static final BitSet FOLLOW_ptvg_in_consts414 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_54_in_vars436 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_type_in_vars440 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars442 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_14_in_vars449 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_vars451 = new BitSet(new long[]{0x0000000408044000L});
	public static final BitSet FOLLOW_ptvg_in_vars458 = new BitSet(new long[]{0x0000000408000002L});
	public static final BitSet FOLLOW_34_in_type478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_type492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decproc_in_decprocs512 = new BitSet(new long[]{0x0001000000040000L});
	public static final BitSet FOLLOW_ptvg_in_decprocs514 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_48_in_decproc534 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_decproc537 = new BitSet(new long[]{0x0040120060000000L});
	public static final BitSet FOLLOW_parfixe_in_decproc543 = new BitSet(new long[]{0x0040100060000000L});
	public static final BitSet FOLLOW_parmod_in_decproc546 = new BitSet(new long[]{0x0040000060000000L});
	public static final BitSet FOLLOW_consts_in_decproc551 = new BitSet(new long[]{0x0040000040000000L});
	public static final BitSet FOLLOW_vars_in_decproc554 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_corps_in_decproc557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_ptvg574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_corps593 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_corps596 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_corps598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_parfixe612 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parfixe614 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe616 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parfixe620 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pf_in_parfixe622 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parfixe626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pf641 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf643 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pf649 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pf651 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_44_in_parmod672 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_parmod674 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod676 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_18_in_parmod680 = new BitSet(new long[]{0x0000000408000000L});
	public static final BitSet FOLLOW_pm_in_parmod682 = new BitSet(new long[]{0x0000000000040800L});
	public static final BitSet FOLLOW_11_in_parmod686 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_pm701 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm703 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_pm709 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_pm711 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_instruction_in_instructions733 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_instructions737 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instruction_in_instructions739 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_inssi_in_instruction758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inscond_in_instruction765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boucle_in_instruction772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lecture_in_instruction779 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ecriture_in_instruction786 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affouappel_in_instruction793 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_inssi812 = new BitSet(new long[]{0x008040400000A060L});
	public static final BitSet FOLLOW_expression_in_inssi815 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_inssi828 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inssi830 = new BitSet(new long[]{0x0010040000000000L});
	public static final BitSet FOLLOW_52_in_inssi833 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inssi837 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_inssi841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_inscond857 = new BitSet(new long[]{0x008040400000A060L});
	public static final BitSet FOLLOW_expression_in_inscond860 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond865 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond867 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_14_in_inscond883 = new BitSet(new long[]{0x008040400000A060L});
	public static final BitSet FOLLOW_expression_in_inscond886 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_inscond890 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond892 = new BitSet(new long[]{0x0000008004004000L});
	public static final BitSet FOLLOW_26_in_inscond910 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_inscond913 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_inscond934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_boucle952 = new BitSet(new long[]{0x008040400000A060L});
	public static final BitSet FOLLOW_expression_in_boucle957 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_boucle961 = new BitSet(new long[]{0x0028080210040020L});
	public static final BitSet FOLLOW_instructions_in_boucle963 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_boucle967 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_lecture980 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_lecture983 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture985 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_lecture996 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_lecture998 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_lecture1009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_ecriture1022 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_ecriture1024 = new BitSet(new long[]{0x008040400000A060L});
	public static final BitSet FOLLOW_expression_in_ecriture1026 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_ecriture1034 = new BitSet(new long[]{0x008040400000A060L});
	public static final BitSet FOLLOW_expression_in_ecriture1036 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_ecriture1045 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_affouappel1063 = new BitSet(new long[]{0x0000000000020402L});
	public static final BitSet FOLLOW_17_in_affouappel1073 = new BitSet(new long[]{0x008040400000A060L});
	public static final BitSet FOLLOW_expression_in_affouappel1075 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_effixes_in_affouappel1099 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_effmods_in_affouappel1103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effixes1139 = new BitSet(new long[]{0x008040400000A860L});
	public static final BitSet FOLLOW_expression_in_effixes1142 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effixes1147 = new BitSet(new long[]{0x008040400000A060L});
	public static final BitSet FOLLOW_expression_in_effixes1149 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effixes1157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_effmods1170 = new BitSet(new long[]{0x0000000000000820L});
	public static final BitSet FOLLOW_ident_in_effmods1173 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_14_in_effmods1179 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ident_in_effmods1181 = new BitSet(new long[]{0x0000000000004800L});
	public static final BitSet FOLLOW_11_in_effmods1191 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp1_in_expression1205 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_47_in_expression1212 = new BitSet(new long[]{0x008040400000A060L});
	public static final BitSet FOLLOW_exp1_in_expression1214 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_exp2_in_exp11236 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_exp11239 = new BitSet(new long[]{0x008040400000A060L});
	public static final BitSet FOLLOW_exp2_in_exp11245 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_46_in_exp21267 = new BitSet(new long[]{0x008040400000A060L});
	public static final BitSet FOLLOW_exp2_in_exp21269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp3_in_exp21280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp4_in_exp31297 = new BitSet(new long[]{0x0000000001F80002L});
	public static final BitSet FOLLOW_22_in_exp31306 = new BitSet(new long[]{0x008000400000A060L});
	public static final BitSet FOLLOW_exp4_in_exp31309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_exp31321 = new BitSet(new long[]{0x008000400000A060L});
	public static final BitSet FOLLOW_exp4_in_exp31324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_exp31336 = new BitSet(new long[]{0x008000400000A060L});
	public static final BitSet FOLLOW_exp4_in_exp31340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_exp31352 = new BitSet(new long[]{0x008000400000A060L});
	public static final BitSet FOLLOW_exp4_in_exp31355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_exp31367 = new BitSet(new long[]{0x008000400000A060L});
	public static final BitSet FOLLOW_exp4_in_exp31371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_exp31383 = new BitSet(new long[]{0x008000400000A060L});
	public static final BitSet FOLLOW_exp4_in_exp31386 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp5_in_exp41412 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_13_in_exp41426 = new BitSet(new long[]{0x008000400000A060L});
	public static final BitSet FOLLOW_exp5_in_exp41429 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_15_in_exp41447 = new BitSet(new long[]{0x008000400000A060L});
	public static final BitSet FOLLOW_exp5_in_exp41450 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_primaire_in_exp51481 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_12_in_exp51498 = new BitSet(new long[]{0x008000400000A060L});
	public static final BitSet FOLLOW_primaire_in_exp51502 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_32_in_exp51521 = new BitSet(new long[]{0x008000400000A060L});
	public static final BitSet FOLLOW_primaire_in_exp51524 = new BitSet(new long[]{0x0000000100001002L});
	public static final BitSet FOLLOW_valeur_in_primaire1553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_primaire1562 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_nbentier_in_valeur1581 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_valeur1590 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_valeur1601 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_nbentier_in_valeur1603 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_valeur1612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_valeur1621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_nbentier1661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ident1674 = new BitSet(new long[]{0x0000000000000002L});
}
