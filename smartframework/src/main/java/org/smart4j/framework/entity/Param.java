package org.smart4j.framework.entity;

import java.util.Map;

public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public long getLong(String name) {
        return (Long) this.paramMap.get(name);
    }

    public Map<String, Object> getMap() {
        return this.paramMap;
    }
}
