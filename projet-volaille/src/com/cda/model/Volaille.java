package com.cda.model;

public abstract class Volaille implements IGeneratriceDId, Comparable<Volaille> {
	protected final String id;
	protected final String typeNom;
	
	public Volaille() {
		this.id = this.idSuivant();
		this.typeNom = this.getTypeNom();
	}

	protected abstract String getTypeNom();

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("%8s, id=%7s",typeNom , id);		//formattage toString
	}
	
	@Override
	public int compareTo(Volaille pAutreVolaille) {
		return this.getId().compareToIgnoreCase(pAutreVolaille.getId());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof Volaille) ) {
			return false;
		}
		return this.getId().equals(((Volaille)obj).getId());
	}
	
}
