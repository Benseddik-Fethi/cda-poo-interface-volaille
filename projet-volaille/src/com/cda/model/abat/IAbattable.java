package com.cda.model.abat;

public interface IAbattable {
	public float getPoids();
	public void setPoids(float poids);
	public float getPoidsAbattage();	//rajout m�thode getpoidsabattable
	public float getPrixAuKilo();
	public float calculerPrix();
}
