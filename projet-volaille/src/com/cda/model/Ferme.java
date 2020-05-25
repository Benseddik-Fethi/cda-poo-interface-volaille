package com.cda.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.cda.model.abat.Canard;
import com.cda.model.abat.IAbattable;
import com.cda.model.abat.Poulet;
import com.cda.model.abat.VolailleAbattable;
import com.cda.model.nabat.Cygne;
import com.cda.model.nabat.Paon;
import com.cda.model.nabat.VolailleAGarder;

public final class Ferme {
	public static final Ferme LA_FERME = new Ferme();

	public static final int MAX_NB_VOLAILLES = 7;

	private final Map<String, Volaille> volaillesMap;
	private final Set<Volaille> volaillesSet;
	private final Set<Canard> canards;
	private final Set<Poulet> poulets;
	private final Set<Paon> paons;
	private final Set<Cygne> cygnes;	//rajout attribut Set<Cygne>

	private Ferme() {
		this.volaillesMap = new HashMap<>();
		this.volaillesSet = new TreeSet<>(new VolailleComparator());
		this.canards = new TreeSet<>();
		this.poulets = new TreeSet<>();
		this.paons = new TreeSet<>();
		this.cygnes = new TreeSet<>();		//initialisation du TreeSet<Cygne>
	}

	private void ajouterVolaille(Volaille pVolaille) {
		this.volaillesMap.put(pVolaille.getId(), pVolaille);
		this.volaillesSet.add(pVolaille);
	}

	public void ajouterCanard(Canard pCanard) {
		this.canards.add(pCanard);
		this.ajouterVolaille(pCanard);
	}

	public void ajouterPoulet(Poulet pPoulet) {
		this.poulets.add(pPoulet);
		this.ajouterVolaille(pPoulet);
	}

	private void ajouterPaon(Paon pPaon) {
		this.paons.add(pPaon);
		this.ajouterVolaille(pPaon);
	}
	
	private void ajouterCygne(Cygne pCygne) {		//création méthode ajouter cygne
		this.cygnes.add(pCygne);
		this.ajouterVolaille(pCygne);
	}

	public Set<Volaille> getVolailles() {
		return this.volaillesSet;
	}

	public Set<Volaille> getVolailles(boolean pEstAbattable, int pTypeVolaille) {
		if (pEstAbattable && pTypeVolaille == 0) {
			return new TreeSet<Volaille>(this.canards);

		} else if (pEstAbattable && pTypeVolaille == 1) {
			return new TreeSet<Volaille>(this.poulets);

		} else if (!pEstAbattable && pTypeVolaille == 0) {
			return new TreeSet<Volaille>(this.paons);
		
		} else if (!pEstAbattable && pTypeVolaille == 1) {
			return new TreeSet<Volaille>(this.cygnes);
		}
		return new TreeSet<>();
	}//test

	public int getNbVolailles() {
		return this.volaillesSet.size();
	}

	public boolean ajoutPossible(boolean pEstAbattables, int vTypeVolaille) {
		if (pEstAbattables && vTypeVolaille == 0 && canards.size() != Canard.NB_MAX) {
			return true;

		} else if (pEstAbattables && vTypeVolaille == 1 && poulets.size() != Poulet.NB_MAX) {
			return true;

		} else if (!pEstAbattables && vTypeVolaille == 0 && paons.size() != Paon.NB_MAX) {
			return true;
			
		} else if (!pEstAbattables && vTypeVolaille == 1 && cygnes.size() !=Cygne.NB_MAX) {		//rajout de test pour le type cygne
			return true;
		}
		
		return false;
	}
	
	public Volaille ajouterVolailleAbattable(int vTypeVolaille, float pPoids) {
		VolailleAbattable vNouvelleVolaille = null;
		if (vTypeVolaille == 0 && canards.size() != Canard.NB_MAX) {
			vNouvelleVolaille = new Canard();
			vNouvelleVolaille.setPoids(pPoids);
			LA_FERME.ajouterCanard((Canard) vNouvelleVolaille);

		} else if (vTypeVolaille == 1 && poulets.size() != Poulet.NB_MAX) {
			vNouvelleVolaille = new Poulet();
			vNouvelleVolaille.setPoids(pPoids);
			LA_FERME.ajouterPoulet((Poulet) vNouvelleVolaille);
		}

		return vNouvelleVolaille;
	}
	
	public Volaille ajouterVolailleAGarder(int vTypeVolaille) {
		Volaille vNouvelleVolaille = null;
		if (vTypeVolaille == 0 && paons.size() != Paon.NB_MAX) {
			vNouvelleVolaille = new Paon();
			LA_FERME.ajouterPaon((Paon) vNouvelleVolaille);
		} else if (vTypeVolaille == 1 && cygnes.size() != Cygne.NB_MAX) {		//rajout du test pour identifier le type de volaille à garder
			vNouvelleVolaille = new Cygne();									//à savoir le cygne.
			LA_FERME.ajouterCygne((Cygne) vNouvelleVolaille);
		}

		return vNouvelleVolaille;
	}

	public VolailleAbattable vendreVolaille(int vTypeVolaille, String vIdVolailleAVendre) {
		VolailleAbattable vVolailleAVendre = null;
		if (this.volaillesMap.containsKey(vIdVolailleAVendre)) {
			Volaille vVolailleAVendreTmp = this.volaillesMap.get(vIdVolailleAVendre);
			if (vVolailleAVendreTmp instanceof VolailleAbattable && 
					((IAbattable) vVolailleAVendreTmp).getPoidsAbattage() <= ((VolailleAbattable) vVolailleAVendreTmp).getPoids()) {	//rajout condition pour tester si la volaille a le poids requis
				boolean vSuppressionReussie = false;
				if (vTypeVolaille == 0 && this.canards.contains(vVolailleAVendreTmp)) {
					vSuppressionReussie = this.canards.remove(vVolailleAVendreTmp);

				} else if (vTypeVolaille == 1 && this.poulets.contains(vVolailleAVendreTmp)) {
					vSuppressionReussie = this.poulets.remove(vVolailleAVendreTmp);
				}
				if(vSuppressionReussie) {
					this.volaillesMap.remove(vIdVolailleAVendre);
					this.volaillesSet.remove(vVolailleAVendreTmp);
					vVolailleAVendre = (VolailleAbattable)vVolailleAVendreTmp;
				}
			}
		} else {
			System.out.println("Aucune volaille à vendre.");
		}
		return vVolailleAVendre;
	}
	
	public VolailleAGarder rendreVolaille(int vTypeVolaille, String vIdVolailleARendre) {
		VolailleAGarder vVolailleARendre = null;
		if (this.volaillesMap.containsKey(vIdVolailleARendre)) {
			Volaille vVolailleARendreTmp = this.volaillesMap.get(vIdVolailleARendre);
			if (vVolailleARendreTmp instanceof VolailleAGarder){	//rajout condition pour tester si la volaille a le poids requis
				boolean vSuppressionReussie = false;
				if (vTypeVolaille == 0 && this.paons.contains(vVolailleARendreTmp)) {
					vSuppressionReussie = this.paons.remove(vVolailleARendreTmp);

				} else if (vTypeVolaille == 1 && this.cygnes.contains(vVolailleARendreTmp)) {
					vSuppressionReussie = this.cygnes.remove(vVolailleARendreTmp);
				}
				if(vSuppressionReussie) {
					this.volaillesMap.remove(vIdVolailleARendre);
					this.volaillesSet.remove(vVolailleARendreTmp);
					vVolailleARendre = (VolailleAGarder)vVolailleARendreTmp;
				}
			}
		} else {
			System.out.println("Aucune volaille à rendre.");
		}
		return vVolailleARendre;
	}
}
