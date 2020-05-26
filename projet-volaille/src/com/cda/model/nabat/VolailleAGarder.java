package com.cda.model.nabat;

import java.time.LocalDateTime;
import com.cda.model.Volaille;
import com.cda.tools.Utils;

public abstract class VolailleAGarder extends Volaille implements IAGarder {
	
	protected final LocalDateTime dateDAccueil;
	
	public VolailleAGarder() {
		this.dateDAccueil = LocalDateTime.now();
	}

	public LocalDateTime getDateDAccueil() {
		return dateDAccueil;
	}
	
	@Override
	public String toString() {	//rajout du toString pour les volailles à garder
		return super.toString() 
				+ String.format(", date=%5s",
						Utils.formaterDate(this.dateDAccueil));
	}
}
