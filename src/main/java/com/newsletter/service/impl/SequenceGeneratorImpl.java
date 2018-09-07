package com.newsletter.service.impl;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.newsletter.model.CustomSequences;
import com.newsletter.service.SequenceGenerator;

@Service
public class SequenceGeneratorImpl implements SequenceGenerator {

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public Long getNextSequence(String seqName) {
		CustomSequences counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("sequence", 1), options().returnNew(true).upsert(true), CustomSequences.class);
		return counter.getSequence();
	}

}
