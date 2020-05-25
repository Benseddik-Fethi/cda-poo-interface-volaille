package com.cda.menu.action;

import static com.cda.model.Ferme.LA_FERME;
import static com.cda.tools.Ihm.IHM_INS;

import java.util.Set;

import com.cda.model.Volaille;
import com.cda.model.abat.VolailleAbattable;

final class RendreVolaille extends Action {

	private static final int ID = 7;		//incrémentation du numéro du menu
	private static final String DESC = "rendre une volaille";
	
	RendreVolaille() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		IHM_INS.afficher("choisissez un type de volaille :");
		IHM_INS.afficher("\t0)- Cygne");	// cygne
		IHM_INS.afficher("\t1)- Paon");		// paon
		
		int vTypeVolaille = IHM_INS.lireEntier();
		
		IHM_INS.afficher("saisissez l'id de la volaille à vendre parmis :");
		Set<Volaille> vVolailles = LA_FERME.getVolailles(false,vTypeVolaille);		//passe premier paramètre en false car non abattable
		for (Volaille vVolaille : vVolailles) {
			IHM_INS.afficher(vVolaille.toString());
		}
		
		String vIdVolailleAVendre = IHM_INS.lireMot();
		VolailleAbattable vVolailleVendue = LA_FERME.vendreVolaille(vTypeVolaille,vIdVolailleAVendre);
		if(vVolailleVendue == null) {
			IHM_INS.afficher("> erreur lors de la vente");
		} else {
			IHM_INS.afficher("> voici la volaille vendue "+vVolailleVendue);
		}
		
		return Boolean.TRUE;
	}

}
