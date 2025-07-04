package com.example.kfc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class AdditionalSqlLoader {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ResourceLoader resourceLoader;
}
