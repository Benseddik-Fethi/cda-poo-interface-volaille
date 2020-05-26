package com.cda.menu.action;

import static com.cda.model.Ferme.LA_FERME;
import static com.cda.tools.Ihm.IHM_INS;

import java.util.Set;

import com.cda.model.Volaille;

final class AfficherPrix extends Action {		//ajout classe afficher prix

	private static final int ID = 8;
	private static final String DESC = "afficher le prix de toutes les volailles";
	
	AfficherPrix() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		float prix = LA_FERME.afficherPrixTotalVolailles();
		IHM_INS.afficher("Le prix total des volailles abattables est de : "+prix+" €");
		return Boolean.TRUE;
	}
}
