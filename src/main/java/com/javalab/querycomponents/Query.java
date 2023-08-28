package com.javalab.querycomponents;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonRootName(value = "query")
@JsonSubTypes({
  @JsonSubTypes.Type(value=Statement.class, name = "Bool")
})
public class Query {
	
	private Statement statement;

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	} 
	
	// No Changes needed in this class.

}
