/*
 * This file is generated by jOOQ.
 */
package com.example.demo.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TDepment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer depId;
    private String  depName;
    private Integer depCount;

    public TDepment() {}

    public TDepment(TDepment value) {
        this.depId = value.depId;
        this.depName = value.depName;
        this.depCount = value.depCount;
    }

    public TDepment(
        Integer depId,
        String  depName,
        Integer depCount
    ) {
        this.depId = depId;
        this.depName = depName;
        this.depCount = depCount;
    }

    /**
     * Getter for <code>li.t_depment.dep_id</code>.
     */
    public Integer getDepId() {
        return this.depId;
    }

    /**
     * Setter for <code>li.t_depment.dep_id</code>.
     */
    public TDepment setDepId(Integer depId) {
        this.depId = depId;
        return this;
    }

    /**
     * Getter for <code>li.t_depment.dep_name</code>.
     */
    public String getDepName() {
        return this.depName;
    }

    /**
     * Setter for <code>li.t_depment.dep_name</code>.
     */
    public TDepment setDepName(String depName) {
        this.depName = depName;
        return this;
    }

    /**
     * Getter for <code>li.t_depment.dep_count</code>.
     */
    public Integer getDepCount() {
        return this.depCount;
    }

    /**
     * Setter for <code>li.t_depment.dep_count</code>.
     */
    public TDepment setDepCount(Integer depCount) {
        this.depCount = depCount;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TDepment (");

        sb.append(depId);
        sb.append(", ").append(depName);
        sb.append(", ").append(depCount);

        sb.append(")");
        return sb.toString();
    }
}
