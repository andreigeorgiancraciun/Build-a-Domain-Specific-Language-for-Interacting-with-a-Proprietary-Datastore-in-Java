package com.javalab.app;


import com.fasterxml.jackson.core.JsonProcessingException;


public class QueryRunner {


    public static void main(String[] args) throws JsonProcessingException {

        QueryRunner newQueryRunner = new QueryRunner();

        System.out.println(newQueryRunner.serializeJson());

    }

    public String serializeJson() throws JsonProcessingException {

        QueryBuilder query = new QueryBuilder.Builder()
                .statement()
                .mustMatch("item ", "milk")
                .mustMatch("state ", "WA")
                .mustMatch("organic", "true")
                .mustNotMatch("manufacturer", "State Farms")
                .shouldMatch("packaging", "carton")
                .shouldNotMatch("weight", "34.5 lbs")
                .sort("warehouse", "asc").limit(12)
                .build();

        return query.getJsonQuery();
    }

}