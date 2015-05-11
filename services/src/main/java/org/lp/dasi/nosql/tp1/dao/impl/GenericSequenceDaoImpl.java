package org.lp.dasi.nosql.tp1.dao.impl;

import org.lp.dasi.nosql.tp1.dao.GenericSequenceDao;
import org.lp.dasi.nosql.tp1.model.GenericSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class GenericSequenceDaoImpl implements GenericSequenceDao {

	@Autowired
	private MongoOperations datasource;

	private void initSequence(String key) {
		if (!datasource.collectionExists(GenericSequence.class)) {
			datasource.createCollection(GenericSequence.class);
		}

		Query query = new Query(Criteria.where("_id").is(key));

		if (!datasource.exists(query, GenericSequence.class)) {
			datasource.insert(new GenericSequence(key));
		}
	}

	@Override
	public Long getNextSequenceId(String key) {
		initSequence(key);

		Query query = new Query(Criteria.where("_id").is(key));

		Update update = new Update();
		update.inc("seq", 1);

		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		GenericSequence seqId = datasource.findAndModify(query, update, options, GenericSequence.class);

		return seqId.getSeq();
	}
}
