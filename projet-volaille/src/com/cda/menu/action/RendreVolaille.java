package com.cda.menu.action;

import static com.cda.model.Ferme.LA_FERME;
import static com.cda.tools.Ihm.IHM_INS;

import java.util.Set;

import com.cda.model.Volaille;
import com.cda.model.abat.VolailleAbattable;
import com.cda.model.nabat.VolailleAGarder;

final class RendreVolaille extends Action {

	private static final int ID = 7;		//incrémentation du numéro du menu
	private static final String DESC = "rendre une volaille";
	
	RendreVolaille() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		IHM_INS.afficher("choisissez un type de volaille :");
		IHM_INS.afficher("\t0)- Paon");	// paon	
		IHM_INS.afficher("\t1)- Cygne");// cygne
		int vTypeVolaille = IHM_INS.lireEntier();
		
		IHM_INS.afficher("saisissez l'id de la volaille à vendre parmis :");
		Set<Volaille> vVolailles = LA_FERME.getVolailles(false,vTypeVolaille);		//passe premier paramètre en false car non abattable
		for (Volaille vVolaille : vVolailles) {
			IHM_INS.afficher(vVolaille.toString());
		}
		
		String vIdVolailleARendre = IHM_INS.lireMot();
		VolailleAGarder vVolailleRendue = LA_FERME.rendreVolaille(vTypeVolaille,vIdVolailleARendre);// Modification appel methode RendreVolaille
		if(vVolailleRendue == null) {
			IHM_INS.afficher("> erreur lors de la restitution");
		} else {
			IHM_INS.afficher("> voici la volaille rendue "+vVolailleRendue);
		}
		
		return Boolean.TRUE;
	}

}
