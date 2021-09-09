/*
 * This file is generated by jOOQ.
 */
package com.example.demo.tables;


import com.example.demo.Keys;
import com.example.demo.Li;
import com.example.demo.tables.records.TMeetroomRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
public class TMeetroom extends TableImpl<TMeetroomRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>li.t_meetroom</code>
     */
    public static final TMeetroom T_MEETROOM = new TMeetroom();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TMeetroomRecord> getRecordType() {
        return TMeetroomRecord.class;
    }

    /**
     * The column <code>li.t_meetroom.id</code>.
     */
    public final TableField<TMeetroomRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>li.t_meetroom.room_name</code>.
     */
    public final TableField<TMeetroomRecord, String> ROOM_NAME = createField(DSL.name("room_name"), SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>li.t_meetroom.root_size</code>.
     */
    public final TableField<TMeetroomRecord, Integer> ROOT_SIZE = createField(DSL.name("root_size"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>li.t_meetroom.room_state</code>.
     */
    public final TableField<TMeetroomRecord, Boolean> ROOM_STATE = createField(DSL.name("room_state"), SQLDataType.BIT.defaultValue(DSL.inline("b'1'", SQLDataType.BIT)), this, "");

    private TMeetroom(Name alias, Table<TMeetroomRecord> aliased) {
        this(alias, aliased, null);
    }

    private TMeetroom(Name alias, Table<TMeetroomRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>li.t_meetroom</code> table reference
     */
    public TMeetroom(String alias) {
        this(DSL.name(alias), T_MEETROOM);
    }

    /**
     * Create an aliased <code>li.t_meetroom</code> table reference
     */
    public TMeetroom(Name alias) {
        this(alias, T_MEETROOM);
    }

    /**
     * Create a <code>li.t_meetroom</code> table reference
     */
    public TMeetroom() {
        this(DSL.name("t_meetroom"), null);
    }

    public <O extends Record> TMeetroom(Table<O> child, ForeignKey<O, TMeetroomRecord> key) {
        super(child, key, T_MEETROOM);
    }

    @Override
    public Schema getSchema() {
        return Li.LI;
    }

    @Override
    public Identity<TMeetroomRecord, Integer> getIdentity() {
        return (Identity<TMeetroomRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TMeetroomRecord> getPrimaryKey() {
        return Keys.KEY_T_MEETROOM_PRIMARY;
    }

    @Override
    public List<UniqueKey<TMeetroomRecord>> getKeys() {
        return Arrays.<UniqueKey<TMeetroomRecord>>asList(Keys.KEY_T_MEETROOM_PRIMARY);
    }

    @Override
    public TMeetroom as(String alias) {
        return new TMeetroom(DSL.name(alias), this);
    }

    @Override
    public TMeetroom as(Name alias) {
        return new TMeetroom(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TMeetroom rename(String name) {
        return new TMeetroom(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TMeetroom rename(Name name) {
        return new TMeetroom(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Integer, Boolean> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
