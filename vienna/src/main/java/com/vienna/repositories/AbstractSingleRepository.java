package com.vienna.repositories;

import org.apache.commons.lang3.tuple.Pair;
import org.jooq.Record;
import org.jooq.Table;

/**
 * @author tonyhui
 * @since 16/11/29
 */
public abstract class AbstractSingleRepository<E> extends AbstractRepository{


    /**
     * 抽象实体类必须要知道属性, 留待子类实现
     *
     * @return
     */
    protected abstract Pair<Class<E>, Table> mapping();

    public void insert(E entity) {
        Record record = dsl.newRecord(mapping().getRight());
        record.from(entity);
        dsl.insertInto(mapping().getRight(), record.fields()).execute();
    }
}
