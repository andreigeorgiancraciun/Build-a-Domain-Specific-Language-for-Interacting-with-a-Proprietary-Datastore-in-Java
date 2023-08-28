package com.javalab.querycomponents;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@JsonRootName(value = "statement")
@Getter
@Setter
public class Statement{
	
	private List<Must> must;
	private List<Should> should;
	private Result result;


	public Statement() {
		must = new ArrayList<>();
		should = new ArrayList<>();
		result = new Result();

	}

	public void addMust(Must m) {
		this.must.add(m);
	}

	public void addShould(Should s) {
		this.should.add(s);
	}

	public void addSortOn(String field, String order) {
		this.result.addSortCondition(field, order);
	}

	public void addLimit(int limitCondition) {
		this.result.setLimit(limitCondition);
	}
}
