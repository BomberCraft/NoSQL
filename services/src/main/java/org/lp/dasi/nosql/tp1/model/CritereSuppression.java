package org.lp.dasi.nosql.tp1.model;

import java.util.Date;

import org.lp.dasi.nosql.tp1.model.enumeration.MotifSuppression;

public class CritereSuppression {
	private Date date;
	private MotifSuppression motif;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MotifSuppression getMotif() {
		return motif;
	}

	public void setMotif(MotifSuppression motif) {
		this.motif = motif;
	}

}
