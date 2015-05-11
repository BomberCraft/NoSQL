package org.lp.dasi.nosql.tp1.dao;

import java.util.Date;
import java.util.List;

import org.lp.dasi.nosql.tp1.model.Employe;
import org.lp.dasi.nosql.tp1.model.Statistique;
import org.lp.dasi.nosql.tp1.model.enumeration.MotifSuppression;

public interface EmployeDao {

	List<Employe> getAll();

	void clearAll();

	Employe getById(String id);

	void deleteById(String id);

	Employe getByNumeroEmploye(Long numeroEmploye);

	void deleteByNumeroEmploye(Long numeroEmploye);

	void save(Employe employe);

	void update(Employe employe);

	void updateSuppression(Long numeroEmp, Date date, MotifSuppression motif);

	Statistique getStatistiques();

}
