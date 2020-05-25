package com.cda.model.abat;

public interface IAbattable {
	public float getPoids();
	public void setPoids(float poids);
	public float getPoidsAbattage();	//rajout méthode getpoidsabattable
	public float getPrixAuKilo();
	public float calculerPrix();
}
