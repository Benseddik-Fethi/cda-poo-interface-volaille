package com.cda.model.abat;

public class Poulet extends VolailleAbattable {
	public static final int NB_MAX = 5;
	
	private static int cmpt;
	private static float prixKg = 2;	//initialisation prix au kg
	private static float poidsDAbattage = 3;	//initialisation poids abattage
	
	@Override
	public String idSuivant() {
		return "PO-"+(++cmpt);
	}
	
	public static float getPrixKg() {
		return prixKg;
	}
	
	public static void modifierPrixKg(float pNouveauPrixKg) {
		prixKg = pNouveauPrixKg;
	}
	
	public static float getPoidsDAbattage() {
		return poidsDAbattage;
	}
	
	public static void modifierPoidsDAbattage(float pNouveauPoidsDAbattage) {
		poidsDAbattage = pNouveauPoidsDAbattage;
	}
	
	@Override
	protected String getTypeNom() {
		return "Poulet";
	}

	@Override
	public float getPrixAuKilo() {
		return prixKg;
	}

	@Override
	public float getPoidsAbattage() {	//rajout méthode getpoidsabattable
		return poidsDAbattage;
	}
}
