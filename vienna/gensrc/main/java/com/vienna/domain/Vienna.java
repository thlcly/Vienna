/**
 * This class is generated by jOOQ
 */
package com.vienna.domain;


import com.vienna.domain.tables.TQuestion;
import com.vienna.domain.tables.TType;
import com.vienna.domain.tables.TUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Vienna extends SchemaImpl {

    private static final long serialVersionUID = -453872615;

    /**
     * The reference instance of <code>vienna</code>
     */
    public static final Vienna VIENNA = new Vienna();

    /**
     * The table <code>vienna.t_question</code>.
     */
    public final TQuestion T_QUESTION = com.vienna.domain.tables.TQuestion.T_QUESTION;

    /**
     * The table <code>vienna.t_type</code>.
     */
    public final TType T_TYPE = com.vienna.domain.tables.TType.T_TYPE;

    /**
     * The table <code>vienna.t_user</code>.
     */
    public final TUser T_USER = com.vienna.domain.tables.TUser.T_USER;

    /**
     * No further instances allowed
     */
    private Vienna() {
        super("vienna", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            TQuestion.T_QUESTION,
            TType.T_TYPE,
            TUser.T_USER);
    }
}
