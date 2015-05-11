package org.lp.dasi.nosql.tp1.service;

import java.util.List;

import org.lp.dasi.nosql.tp1.model.CritereSuppression;
import org.lp.dasi.nosql.tp1.model.Employe;
import org.lp.dasi.nosql.tp1.model.Statistique;

public interface EmployeService {

	List<Employe> getAllEmployes();

	Long saveNewEmploye(Employe employe);

	Employe getEmployeByNum(Long numeroEmp);

	void updateEmploye(Employe employe);

	void deleteEmploye(Long numeroEmp, CritereSuppression motif);

	Statistique getStatistiquesEmployes();

}
