package org.lp.dasi.nosql.tp1.model;

import java.math.BigDecimal;

public class Statistique {

	private BigDecimal salaireMoy;
	private BigDecimal salaireMin;
	private BigDecimal salaireMax;

	public BigDecimal getSalaireMoy() {
		return salaireMoy;
	}

	public void setSalaireMoy(BigDecimal salaireMoy) {
		this.salaireMoy = salaireMoy;
	}

	public BigDecimal getSalaireMin() {
		return salaireMin;
	}

	public void setSalaireMin(BigDecimal salaireMin) {
		this.salaireMin = salaireMin;
	}

	public BigDecimal getSalaireMax() {
		return salaireMax;
	}

	public void setSalaireMax(BigDecimal salaireMax) {
		this.salaireMax = salaireMax;
	}

}
