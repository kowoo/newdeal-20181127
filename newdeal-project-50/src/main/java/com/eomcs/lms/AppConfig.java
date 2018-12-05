package com.eomcs.lms;

import java.io.InputStream;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.eomcs.lms")
public class AppConfig {
  //최근 사용되는 스프링부트에서는 xml을 사용하지않고 클래스 파일을 사용한다.
  
  //Spring IoC Container에게 이 메서드를 호출하여 리턴 값을 보관하라고 표시한 것.
  // 리턴 값을 저장할 때 사용할 이름을 지정하지 않으면,
  // 메서드 이름으로 저장한다.
  // 그래서 이런 메서드의 이름은 보통 동사로 시작하지 않고 명사로 시작한다. (객체의 이름)
  // createSqlSessionFactory -> sqlSessionFactory
  // annotation 옆에 ("이름") 표기해도 되지만 귀찮잖아? 그래서 @Bean을 씀. 
  //Spring IoC Container에게 패키지 이름을 알려주면 그 패키지를 뒤져서
  //@Component가 붙은 클래스에 대해 인스턴스를 자동으로 생성해준다.
  //@ComponentScan("com.eomcs.lms")
  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    String resource = "com/eomcs/lms/conf/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    return new SqlSessionFactoryBuilder().build(inputStream);
  }
  
  @Bean
  public Scanner keyboard() {
    return new Scanner(System.in);
  }
}
