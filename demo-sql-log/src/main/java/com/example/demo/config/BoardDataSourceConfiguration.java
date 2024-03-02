package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(sqlSessionFactoryRef = "boardSqlSessionFactory")
public class BoardDataSourceConfiguration {
    @Primary
    @Bean(name = "boardDataSource")
    @ConfigurationProperties(prefix = "spring.board.datasource")
    public DataSource boardDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "boardSqlSessionFactory")
    public SqlSessionFactory boardSqlSessionFactory(@Qualifier("boardDataSource") DataSource boardDataSource,
                                                    ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(boardDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mappers/board/**/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "boardSqlSessionTemplate")
    public SqlSessionTemplate boardSqlSessionTemplate(@Qualifier("boardSqlSessionFactory") SqlSessionFactory boardSqlSessionFactory) {
        return new SqlSessionTemplate(boardSqlSessionFactory);
    }
}
