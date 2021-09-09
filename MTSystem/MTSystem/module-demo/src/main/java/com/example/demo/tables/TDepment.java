/*
 * This file is generated by jOOQ.
 */
package com.example.demo.tables;


import com.example.demo.Keys;
import com.example.demo.Li;
import com.example.demo.tables.records.TDepmentRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TDepment extends TableImpl<TDepmentRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>li.t_depment</code>
     */
    public static final TDepment T_DEPMENT = new TDepment();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TDepmentRecord> getRecordType() {
        return TDepmentRecord.class;
    }

    /**
     * The column <code>li.t_depment.dep_id</code>.
     */
    public final TableField<TDepmentRecord, Integer> DEP_ID = createField(DSL.name("dep_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>li.t_depment.dep_name</code>.
     */
    public final TableField<TDepmentRecord, String> DEP_NAME = createField(DSL.name("dep_name"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>li.t_depment.dep_count</code>.
     */
    public final TableField<TDepmentRecord, Integer> DEP_COUNT = createField(DSL.name("dep_count"), SQLDataType.INTEGER, this, "");

    private TDepment(Name alias, Table<TDepmentRecord> aliased) {
        this(alias, aliased, null);
    }

    private TDepment(Name alias, Table<TDepmentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>li.t_depment</code> table reference
     */
    public TDepment(String alias) {
        this(DSL.name(alias), T_DEPMENT);
    }

    /**
     * Create an aliased <code>li.t_depment</code> table reference
     */
    public TDepment(Name alias) {
        this(alias, T_DEPMENT);
    }

    /**
     * Create a <code>li.t_depment</code> table reference
     */
    public TDepment() {
        this(DSL.name("t_depment"), null);
    }

    public <O extends Record> TDepment(Table<O> child, ForeignKey<O, TDepmentRecord> key) {
        super(child, key, T_DEPMENT);
    }

    @Override
    public Schema getSchema() {
        return Li.LI;
    }

    @Override
    public Identity<TDepmentRecord, Integer> getIdentity() {
        return (Identity<TDepmentRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TDepmentRecord> getPrimaryKey() {
        return Keys.KEY_T_DEPMENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<TDepmentRecord>> getKeys() {
        return Arrays.<UniqueKey<TDepmentRecord>>asList(Keys.KEY_T_DEPMENT_PRIMARY, Keys.KEY_T_DEPMENT_T_DEPMENT_DEP_ID_UINDEX);
    }

    @Override
    public TDepment as(String alias) {
        return new TDepment(DSL.name(alias), this);
    }

    @Override
    public TDepment as(Name alias) {
        return new TDepment(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TDepment rename(String name) {
        return new TDepment(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TDepment rename(Name name) {
        return new TDepment(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
