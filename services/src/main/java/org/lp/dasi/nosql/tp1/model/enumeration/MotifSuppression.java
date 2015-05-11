package org.lp.dasi.nosql.tp1.model.enumeration;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "motif")
public enum MotifSuppression {
	licenciement("Licenciement"),
	demission("Démission"),
	deces("Décés"),
	ascension("Ascension");

	private String description;

	private MotifSuppression(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}
}
