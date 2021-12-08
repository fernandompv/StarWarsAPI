package com.project.StarWar.Config;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.type.StandardBasicTypes;

import java.sql.Types;

public class CustomDialect extends H2Dialect{
    public CustomDialect() {
        super();
        registerHibernateType(Types.DECIMAL, StandardBasicTypes.BIG_DECIMAL.getName());
        registerHibernateType(-1, StandardBasicTypes.STRING.getName());
    }
}
