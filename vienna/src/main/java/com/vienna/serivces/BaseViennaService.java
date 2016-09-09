package com.vienna.serivces;

import com.vienna.question.domain.Tables;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tonyhui
 * @since 16/9/9
 */
public abstract class BaseViennaService extends Tables {
    @Autowired
    protected DSLContext dsl;
}
