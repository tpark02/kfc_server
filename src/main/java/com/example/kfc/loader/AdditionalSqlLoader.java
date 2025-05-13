package com.example.kfc.loader;

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

//    @PostConstruct
//    public void loadExtraSql() throws Exception {
//        Resource resource = resourceLoader.getResource("classpath:extra-data.sql");
//        try (Connection conn = dataSource.getConnection()) {
//            ScriptUtils.executeSqlScript(conn, resource);
//        }
//    }
}
