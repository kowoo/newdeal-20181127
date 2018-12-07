package com.eomcs.lms;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// a
@Configuration

// xml 설정에 추가되어 있다면 제거해도 된다.
//@ComponentScan("com.eomcs.lms")
@PropertySource("classpath:/com/eomcs/lms/conf/jdbc.properties")
@MapperScan("com.eomcs.lms.dao")
public class AppConfig {
  
  @Value("${jdbc.driver}") 
  String jdbcDriver;
  
  @Value("${jdbc.url}")
  String jdbcUrl;
  
  @Value("${jdbc.username}")
  String jdbcUserName;
  
  @Value("${jdbc.password}")
  String jdbcPassword;
  
  
  
  @Bean
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(this.jdbcDriver);
    dataSource.setUrl(this.jdbcUrl);
    dataSource.setUsername(this.jdbcUserName);
    dataSource.setPassword(this.jdbcPassword);
    return dataSource;
    
  }
  
  public PlatformTransactionManager transactionManager(
      DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
  
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource, 
      ApplicationContext iocContainer) throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    
    factoryBean.setDataSource(dataSource);
    factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    
    factoryBean.setMapperLocations(iocContainer.getResources(
        "classpath:/com/eomcs/lms/mapper/*Mapper.xml"));
    
    return factoryBean.getObject();
  }

  // Spring WebMVC에 기본으로 설정되어 있는 ViewResolver를
  // InternalResourceViewResolver 로 교체한다.
  // 페이지 컨트롤러가 리턴하는 url 앞 뒤에 설정된 경로를 붙인다.

  // XML에서 ViewResolver 객체를 준비했다면 다음 메서드는 제거한다.
  /*
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver vs =
        new InternalResourceViewResolver();
    vs.setPrefix("/WEB-INF/jsp/");
    vs.setSuffix(".jsp");
    vs.setViewClass(JstlView.class);
    return vs;
  }
  */
  
}
