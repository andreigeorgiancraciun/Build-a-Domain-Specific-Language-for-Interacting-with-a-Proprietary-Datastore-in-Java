package com.javalab.querycomponents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Map<String, String> sort = new HashMap<>();
    private int limit = 10;

    public void addSortCondition(String field, String order) {
        this.sort.put(field, order);
    }
}
