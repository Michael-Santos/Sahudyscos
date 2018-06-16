package com.sahudyscos.web.config;

import org.hibernate.dialect.PostgreSQL95Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.DoubleType;
import org.hibernate.type.ObjectType;

public class  PgFullTextDialect extends PostgreSQL95Dialect {
    
    
    public PgFullTextDialect() {
        super();
        registerFunction("fts", new PgFullTextFunction());
        registerFunction("ts_rank", new StandardSQLFunction("ts_rank", DoubleType.INSTANCE));
        registerFunction("plainto_tsquery", new StandardSQLFunction("to_tsquery", ObjectType.INSTANCE));
        registerFunction("to_tsquery", new StandardSQLFunction("to_tsquery", ObjectType.INSTANCE));
    }
    
}