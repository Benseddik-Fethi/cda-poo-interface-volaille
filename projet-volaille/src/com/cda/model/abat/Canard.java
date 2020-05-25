package com.cda.model.abat;

public class Canard extends VolailleAbattable {
	public static final int NB_MAX = 4;
	
	private static int cmpt;
	private static float prixKg = 3;	//initialisation prix au kg
	private static float poidsDAbattage = 4;	//initialisation poids abattage
	
	@Override
	public String idSuivant() {
		return "CA-"+(++cmpt);
	}

	public static float getPrixKg() {
		return prixKg;
	}
	
	public static void modifierPrixKg(float pNouveauPrixKg) {
		prixKg = pNouveauPrixKg;
	}
	
	public static float getPoidsDAbattage() {	//rajout méthode getpoidsabattable
		return poidsDAbattage;
	}
	
	public float getPoidsAbattage() {
		return poidsDAbattage;
	}	
	
	public static void modifierPoidsDAbattage(float pNouveauPoidsDAbattage) {
		poidsDAbattage = pNouveauPoidsDAbattage;
	}

	@Override
	protected String getTypeNom() {
		return "Canard";
	}
	
	@Override
	public float getPrixAuKilo() {
		return prixKg;
	}
}
