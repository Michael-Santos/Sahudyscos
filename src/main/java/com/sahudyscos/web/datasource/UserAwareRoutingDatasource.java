package com.sahudyscos.web.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserAwareRoutingDatasource extends AbstractDataSource  {

    private static DataSource admin = DataSourceBuilder.create()
        .url("jdbc:postgresql://localhost:5432/sahudyscos")
        .username("sahudyscos")
        .password("sahudyscos")
        .build();

    private static DataSource user = DataSourceBuilder.create()
        .url("jdbc:postgresql://localhost:5432/sahudyscos")
        .username("sahudyscos_view")
        .password("dummy")
        .build();

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Boolean isAdmin = false;

    @Override
    public Connection getConnection() throws SQLException {
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            isAdmin = false;
            return user.getConnection();
        }
        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if ("ADMIN".equals(auth.getAuthority()) && !isAdmin){
                isAdmin = true;
                return admin.getConnection();
            }
        }
        isAdmin = false;
        return user.getConnection();
    }

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return user.getConnection();
	}
}