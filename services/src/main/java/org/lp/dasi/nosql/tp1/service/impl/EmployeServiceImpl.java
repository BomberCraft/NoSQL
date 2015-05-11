package org.lp.dasi.nosql.tp1.service.impl;

import java.util.List;

import org.lp.dasi.nosql.tp1.dao.EmployeDao;
import org.lp.dasi.nosql.tp1.dao.GenericSequenceDao;
import org.lp.dasi.nosql.tp1.model.CritereSuppression;
import org.lp.dasi.nosql.tp1.model.Employe;
import org.lp.dasi.nosql.tp1.model.Statistique;
import org.lp.dasi.nosql.tp1.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeDao dao;

	@Autowired
	private GenericSequenceDao sequenceDao;

	@Override
	public List<Employe> getAllEmployes() {
		List<Employe> employes = dao.getAll();

		return employes;
	}

	@Override
	public Long saveNewEmploye(Employe employe) {
		Long id = sequenceDao.getNextSequenceId(Employe.TABLE);
		employe.setNumeroEmploye(id);

		dao.save(employe);

		return id;
	}

	@Override
	public Employe getEmployeByNum(Long numeroEmp) {
		Employe employe = dao.getByNumeroEmploye(numeroEmp);

		return employe;
	}

	@Override
	public void updateEmploye(Employe employe) {
		dao.update(employe);

	}

	@Override
	public void deleteEmploye(Long numeroEmp, CritereSuppression critere) {
		dao.updateSuppression(numeroEmp, critere.getDate(), critere.getMotif());
	}

	@Override
	public Statistique getStatistiquesEmployes() {

		return dao.getStatistiques();
	}

}
