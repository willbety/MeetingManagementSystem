/*
 * This file is generated by jOOQ.
 */
package com.example.demo.tables.records;


import com.example.demo.tables.TMeeting;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TMeetingRecord extends UpdatableRecordImpl<TMeetingRecord> implements Record7<Integer, String, String, String, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>li.t_meeting.id</code>.
     */
    public TMeetingRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>li.t_meeting.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>li.t_meeting.meet_name</code>.
     */
    public TMeetingRecord setMeetName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>li.t_meeting.meet_name</code>.
     */
    public String getMeetName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>li.t_meeting.meet_due</code>.
     */
    public TMeetingRecord setMeetDue(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>li.t_meeting.meet_due</code>.
     */
    public String getMeetDue() {
        return (String) get(2);
    }

    /**
     * Setter for <code>li.t_meeting.meetroom_name</code>.
     */
    public TMeetingRecord setMeetroomName(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>li.t_meeting.meetroom_name</code>.
     */
    public String getMeetroomName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>li.t_meeting.meet_dev</code>.
     */
    public TMeetingRecord setMeetDev(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>li.t_meeting.meet_dev</code>.
     */
    public String getMeetDev() {
        return (String) get(4);
    }

    /**
     * Setter for <code>li.t_meeting.meet_start</code>.
     */
    public TMeetingRecord setMeetStart(LocalDateTime value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>li.t_meeting.meet_start</code>.
     */
    public LocalDateTime getMeetStart() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>li.t_meeting.meet_end</code>.
     */
    public TMeetingRecord setMeetEnd(LocalDateTime value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>li.t_meeting.meet_end</code>.
     */
    public LocalDateTime getMeetEnd() {
        return (LocalDateTime) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, String, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Integer, String, String, String, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TMeeting.T_MEETING.ID;
    }

    @Override
    public Field<String> field2() {
        return TMeeting.T_MEETING.MEET_NAME;
    }

    @Override
    public Field<String> field3() {
        return TMeeting.T_MEETING.MEET_DUE;
    }

    @Override
    public Field<String> field4() {
        return TMeeting.T_MEETING.MEETROOM_NAME;
    }

    @Override
    public Field<String> field5() {
        return TMeeting.T_MEETING.MEET_DEV;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return TMeeting.T_MEETING.MEET_START;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return TMeeting.T_MEETING.MEET_END;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getMeetName();
    }

    @Override
    public String component3() {
        return getMeetDue();
    }

    @Override
    public String component4() {
        return getMeetroomName();
    }

    @Override
    public String component5() {
        return getMeetDev();
    }

    @Override
    public LocalDateTime component6() {
        return getMeetStart();
    }

    @Override
    public LocalDateTime component7() {
        return getMeetEnd();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getMeetName();
    }

    @Override
    public String value3() {
        return getMeetDue();
    }

    @Override
    public String value4() {
        return getMeetroomName();
    }

    @Override
    public String value5() {
        return getMeetDev();
    }

    @Override
    public LocalDateTime value6() {
        return getMeetStart();
    }

    @Override
    public LocalDateTime value7() {
        return getMeetEnd();
    }

    @Override
    public TMeetingRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TMeetingRecord value2(String value) {
        setMeetName(value);
        return this;
    }

    @Override
    public TMeetingRecord value3(String value) {
        setMeetDue(value);
        return this;
    }

    @Override
    public TMeetingRecord value4(String value) {
        setMeetroomName(value);
        return this;
    }

    @Override
    public TMeetingRecord value5(String value) {
        setMeetDev(value);
        return this;
    }

    @Override
    public TMeetingRecord value6(LocalDateTime value) {
        setMeetStart(value);
        return this;
    }

    @Override
    public TMeetingRecord value7(LocalDateTime value) {
        setMeetEnd(value);
        return this;
    }

    @Override
    public TMeetingRecord values(Integer value1, String value2, String value3, String value4, String value5, LocalDateTime value6, LocalDateTime value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TMeetingRecord
     */
    public TMeetingRecord() {
        super(TMeeting.T_MEETING);
    }

    /**
     * Create a detached, initialised TMeetingRecord
     */
    public TMeetingRecord(Integer id, String meetName, String meetDue, String meetroomName, String meetDev, LocalDateTime meetStart, LocalDateTime meetEnd) {
        super(TMeeting.T_MEETING);

        setId(id);
        setMeetName(meetName);
        setMeetDue(meetDue);
        setMeetroomName(meetroomName);
        setMeetDev(meetDev);
        setMeetStart(meetStart);
        setMeetEnd(meetEnd);
    }
}
