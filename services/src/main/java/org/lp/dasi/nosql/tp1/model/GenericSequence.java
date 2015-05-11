package org.lp.dasi.nosql.tp1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class GenericSequence {

	@Id
	private String id;

	private Long seq;

	public GenericSequence() {
		this(null);
	}

	public GenericSequence(String key) {
		this.id = key;
		seq = 0L;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

}