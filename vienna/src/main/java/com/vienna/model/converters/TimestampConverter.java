package com.vienna.model.converters;

import org.joda.time.DateTime;
import org.jooq.Converter;

import java.sql.Timestamp;

public class TimestampConverter implements Converter<Timestamp, DateTime> {
    /**
     * 数据库 -> model
     *
     * @param dataObject
     * @return
     */
    @Override
    public DateTime from(Timestamp dataObject) {
        if(dataObject == null) {
            return null;
        }
        return new DateTime(dataObject.getTime());
    }

    /**
     * model -> 数据库
     *
     * @param userObject
     * @return
     */
    @Override
    public Timestamp to(DateTime userObject) {
        if(userObject == null) {
            return null;
        }
        return new Timestamp(userObject.getMillis());
    }

    /**
     * 数据库中的类型
     *
     * @return
     */
    @Override
    public Class<Timestamp> fromType() {
        return Timestamp.class;
    }

    /**
     * model中的类型
     *
     * @return
     */
    @Override
    public Class<DateTime> toType() {
        return DateTime.class;
    }
}