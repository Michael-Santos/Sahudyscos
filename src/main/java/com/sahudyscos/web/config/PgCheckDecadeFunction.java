package com.sahudyscos.web.config;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.BooleanType;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PgCheckDecadeFunction implements SQLFunction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public Type getReturnType(Type columnType, Mapping mapping)
            throws QueryException {
        return new BooleanType();
    }

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return false;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public String render(Type type, List args, SessionFactoryImplementor factory) throws QueryException {
        if (args == null || (args.size() != 2)) {
            throw new IllegalArgumentException("Invalid number of parameters");
        }

        String dateField = (String) args.get(0);
        String searchString = (String) args.get(1);

        logger.info(dateField);
        logger.info(searchString);
        return String.format("%s BETWEEN to_date(%s, 'YYYY-mm-DD') AND to_date(%s, 'YYYY-mm-DD') + interval '9 years'", dateField, searchString, searchString);
    }
}