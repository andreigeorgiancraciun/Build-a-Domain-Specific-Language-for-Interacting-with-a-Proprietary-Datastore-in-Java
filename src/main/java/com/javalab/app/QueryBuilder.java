package com.javalab.app;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javalab.querycomponents.Query;
import com.javalab.querycomponents.Statement;
import com.javalab.querycomponents.Match;
import com.javalab.querycomponents.Must;
import com.javalab.querycomponents.Should;
import com.javalab.querycomponents.NotMatch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QueryBuilder {

    private String jsonQuery;

    public static class Builder {

        Query query;
        Statement statement;

        public Builder() {
            this.query = new Query();
        }

        public Builder statement() {
            this.statement = new Statement();
            this.query.setStatement(statement);
            return this;
        }

        public Builder mustMatch(String key, String val) {
            Match match = new Match(key, val);
            Must must = new Must();
            must.setMatchCondition(match);
            this.statement.addMust(must);
            return this;
        }

        public Builder mustNotMatch(String key, String val) {
            NotMatch notMatch = new NotMatch(key, val);
            Must must = new Must();
            must.setNotMatchCondition(notMatch);
            this.statement.addMust(must);
            return this;
        }

        public Builder shouldMatch(String key, String val) {
            Match match = new Match(key, val);
            Should should = new Should();
            should.setMatchCondition(match);
            this.statement.addShould(should);
            return this;
        }

        public Builder shouldNotMatch(String key, String val) {
            NotMatch nm = new NotMatch(key, val);
            Should should = new Should();
            should.setNotMatchCondition(nm);
            this.statement.addShould(should);
            return this;
        }

        public Builder sort(String field, String order) {
            this.statement.addSortOn(field, order);
            return this;
        }

        public Builder limit(int limit) {
            this.statement.addLimit(limit);
            return this;
        }

        public QueryBuilder build() throws JsonProcessingException {
            QueryBuilder queryBuilderInstance = new QueryBuilder();
            queryBuilderInstance.setJsonQuery(getQueryJson());
            return queryBuilderInstance;
        }

        private String getQueryJson() throws JsonProcessingException {

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            mapper.setSerializationInclusion(Include.NON_NULL);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.query);

        }


    }

}
