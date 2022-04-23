package com.mms.common.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@PropertySource("classpath:/application.properties")
public class DataSourceConfig {
    @Autowired
    ApplicationContext applicationContext;

    @Value("${mybatis.mapper-location}")
    private String mapper;
    @Value("${mybatis.config-location}")
    private String mybatisConfig;

    /**
     * method application.properties의 hikari 셋팅을 기준으로 Config Bean 생성
     * @param
     * @return [com.zaxxer.hikari.HikariConfig] - Hikari Config 파일
     * @throws
     */
    @Bean(name="hikariConfig")
    @Primary //Multiple DB 설정시 주 DB
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig(){
        return new HikariConfig();
    }

    /**
     * method Data Soource Bean 생성
     * @param
     * @return [javax.sql.DataSource] - Data Source
     * @throws
     */
    @Bean(name="dataSource")
    @Primary
    public DataSource dataSource(){
        return new HikariDataSource(hikariConfig());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfigLocation(applicationContext.getResource(mybatisConfig));
        bean.setMapperLocations(applicationContext.getResources(mapper));
        bean.setTypeAliases(new Class<?>[] { Map.class});
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    @Bean(name="sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
