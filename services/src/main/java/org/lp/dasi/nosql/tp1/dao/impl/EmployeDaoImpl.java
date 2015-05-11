package org.lp.dasi.nosql.tp1.dao.impl;

import java.util.Date;
import java.util.List;

import org.lp.dasi.nosql.tp1.dao.EmployeDao;
import org.lp.dasi.nosql.tp1.model.Employe;
import org.lp.dasi.nosql.tp1.model.Statistique;
import org.lp.dasi.nosql.tp1.model.enumeration.MotifSuppression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeDaoImpl implements EmployeDao {

	@Autowired
	@Qualifier("mongoTemplate")
	private MongoOperations dataSource;

	@Override
	public List<Employe> getAll() {

		return dataSource.findAll(Employe.class, Employe.TABLE);
	}

	@Override
	public void clearAll() {

		dataSource.dropCollection(Employe.TABLE);
	}

	@Override
	public Employe getById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));

		return dataSource.findOne(query, Employe.class, Employe.TABLE);
	}

	@Override
	public void deleteById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));

		dataSource.findAllAndRemove(query, Employe.class, Employe.TABLE);
	}

	@Override
	public Employe getByNumeroEmploye(Long numeroEmploye) {
		Query query = new Query(Criteria.where("numeroEmploye").is(numeroEmploye));

		return dataSource.findOne(query, Employe.class, Employe.TABLE);
	}

	@Override
	public void deleteByNumeroEmploye(Long numeroEmploye) {
		Query query = new Query(Criteria.where("numeroEmploye").is(numeroEmploye));

		dataSource.findAllAndRemove(query, Employe.class, Employe.TABLE);
	}

	@Override
	public void save(Employe employe) {

		dataSource.save(employe, Employe.TABLE);
	}

	@Override
	public void update(Employe employe) {

		dataSource.save(employe, Employe.TABLE);
	}

	@Override
	public void updateSuppression(Long numeroEmp, Date date, MotifSuppression motif) {
		Query query = new Query(Criteria.where("numeroEmploye").is(numeroEmp));
		Update update = new Update();
		update.set("dateSortie", date);
		update.set("motifSuppression", motif);

		dataSource.updateFirst(query, update, Employe.TABLE);

	}

	@Override
	public Statistique getStatistiques() {
		// TODO Auto-generated method stub
		return null;
	}

}
