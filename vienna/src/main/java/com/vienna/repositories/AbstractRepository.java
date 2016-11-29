package com.vienna.repositories;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tonyhui
 * @since 16/11/29
 */
public abstract class AbstractRepository {
    @Autowired
    protected DSLContext dsl;
}
