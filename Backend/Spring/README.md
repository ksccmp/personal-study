# 개념
* IoC (Inversion of Control) ?
   * ~

* DI (Dependency Injection) ?
   * ~

* Bean ?
   * ~

* MVC pattern ?
   * ~

* MVVM pattern ?
   * ~

* DispatcherServelet ?
   * ~

* DTO ?
   * ~

* Annotation ?
   * ~

* Configuration ?
   * ~

* Repository ?
   * ~

* Service ?
   * ~

# 프로젝트 생성
* STS 설치
* Servers에 Tomcat 가져오기
* 마우스 우클릭 -> new -> Spring Legacy Project -> Simple Spring Web Maven -> 이름 작성 후 생성
* 생성된 프로젝트 우클릭 -> Maven -> Update Project
* 생성된 프로젝트 우클릭 -> Run As -> Run on Server -> 위에서 가져온 Tomcat 클릭한 뒤 Finish 하면 default로 만들어지는 index.jsp가 실행된 창 오픈

# STS에서 Run on Server로 실행되는 브라우저 변경
* STS 상단바의 Window -> Preferences -> 'browser' 검색 -> General의 Web Browser -> Use external web browser 선택 및 실행될 web browser 선택

# pom.xml에 dependency 변경 및 추가 (pom.xml의 내용이 변경되면 항상 Update Project 수행)
* https://mvnrepository.com/ 에 접속하여 검색을 통해 dependency 찾기 가능
* 추가한 dependency
   * spring-jdbc : java에서 DB에 접근할 수 있도록 해줌
   * commons-dbcp : DB의 커넥션풀을 생성하여 DB를 사용할 수 있는 환경 제공
   * mysql-connector-java : mysql 연결을 위한 설정
   * mybatis, mybatis-spring : mybatis를 사용하여 java와 mysql을 연동
   * jackson-databind : JSON구조를 처리해주는 라이브러리
   * lombok : DTO를 효율적으로 설정하게 해주는 라이브러리 (인터넷에 검색하여 따로 추가적인 설치파일 설치하기)
   * springfox-swagger-ui, springfox-swagger2 : 구조화 된 Spring이 잘 동작하는지 확인할 수 있는 환경 제공
* 변경 및 추가를 통한 최종 pom.xml
   ```
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>
   <groupId>org.springframework.samples.service.service</groupId>
   <artifactId>market-place</artifactId>
   <version>0.0.1-SNAPSHOT</version>
   <packaging>war</packaging>
   
      <properties>
      
         <!-- Generic properties -->
         <java.version>1.8</java.version>
         <maven.compiler.source>${java.version}</maven.compiler.source>
         <maven.compiler.target>${java.version}</maven.compiler.target>
         <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
         <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>

         <!-- Spring -->
         <spring-framework.version>5.2.6.RELEASE</spring-framework.version>

         <!-- Logging -->
         <logback.version>1.2.3</logback.version>
         <slf4j.version>1.7.5</slf4j.version>

         <!-- Test -->
         <junit.version>4.13</junit.version>
         
      </properties>
      
      <dependencies>
      
         <!-- Spring MVC -->
         <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring-framework.version}</version>
         </dependency>
         
         <!-- Other Web dependencies -->
         <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
         <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
         </dependency>

         <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
         <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
         </dependency>

         <!-- https://mvnrepository.com/artifact/javax.servlet.jsp/jsp-api -->
         <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
            <scope>provided</scope>
         </dependency>
      
         <!-- Spring and Transactions -->
         <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring-framework.version}</version>
         </dependency>

         <!-- Logging with SLF4J & LogBack -->
         <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j.version}</version>
            <scope>compile</scope>
         </dependency>
         
         <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>${logback.version}</version>
            <scope>runtime</scope>
         </dependency>
         
         <!-- Test Artifacts -->
         <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring-framework.version}</version>
            <scope>test</scope>
         </dependency>
         
         <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
         </dependency>
         
         <!-- Others -->
         <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
         <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring-framework.version}</version>
         </dependency>
         
         <!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
         <dependency>
            <groupId>commons-dbcp</groupId>
            <artifactId>commons-dbcp</artifactId>
            <version>1.4</version>
         </dependency>
         
         <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
         <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.20</version>
         </dependency>
         
         <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
         <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.4</version>
         </dependency>		
         
         <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
         <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.4</version>
         </dependency>
         
         <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
         <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.11.0</version>
         </dependency>
         
         <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
         <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.12</version>
            <scope>provided</scope>
         </dependency>
         
         <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
         <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
         </dependency>
         
         <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
         <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
         </dependency>
         
      </dependencies>	
   </project>
   ```

# 개발환경 설정 (xml)
## mvc-config.xml 설정
* web 연결과 관련된 설정들을 구성하는 파일 (View ↔ Controller 등)
* 파일위치 : src/main/webapp/WEB-INF/view/
* Controller의 base package 등록 (Controller를 작성할 패키지 이름을 market.place.controller 할 예정)
   ```
   <?xml version="1.0" encoding="UTF-8"?>

   <beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
         http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

      <!-- Uncomment and your base-package here: -->
            <context:component-scan
               base-package="market.place.controller"/>  


      <mvc:annotation-driven />

      <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <!-- Example: a logical view name of 'showMessage' is mapped to '/WEB-INF/jsp/showMessage.jsp' -->
            <property name="prefix" value="/WEB-INF/view/"/> <!-- Controller에서 jsp파일 위치를 src/main/webapp/WEB-INF/view/ 로 판단 -->
            <property name="suffix" value=".jsp"/>
      </bean>

   </beans>
   ```
## application-config.xml 설정
* web 연결과 관련되지 않은 나머지를 구성하는 파일
* 파일위치 : src/main/resources/spring/
* Repository와 Service의 base package 등록 (패키지 이름을 Repository는 market.place.repository, Service는 market.place.service 할 예정)
   ```
   <?xml version="1.0" encoding="UTF-8"?>

   <beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
      
      <!-- Uncomment and add your base-package here: -->
            <context:component-scan
               base-package="market.place.repository, market.place.service"/>  

   </beans>
   ```

## web.xml 설정
* DispatcherServlet, ContextConfigLocation 등을 구성하는 파일
* 파일위치 : src/main/webapp/WEB-INF/view/
* Encoding 설정하기
   ```
   <?xml version="1.0" encoding="ISO-8859-1"?>
   <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xmlns="http://java.sun.com/xml/ns/javaee"
            xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
   http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
            id="WebApp_ID" version="2.5">

      <display-name>market-place</display-name>
      
      <!--
         - Location of the XML file that defines the root application context.
         - Applied by ContextLoaderListener.
      -->
      <context-param>
         <param-name>contextConfigLocation</param-name>
         <param-value>classpath:spring/application-config.xml</param-value>
      </context-param>

      <listener>
         <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
      </listener>
      
      
      <!--
         - Servlet that dispatches request to registered handlers (Controller implementations).
      -->
      <servlet>
         <servlet-name>dispatcherServlet</servlet-name>
         <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
         <init-param>
               <param-name>contextConfigLocation</param-name>
               <param-value>/WEB-INF/mvc-config.xml</param-value>
         </init-param>
         <load-on-startup>1</load-on-startup>
      </servlet>

      <servlet-mapping>
         <servlet-name>dispatcherServlet</servlet-name>
         <url-pattern>/</url-pattern>
      </servlet-mapping>
      
      <filter>
         <filter-name>encodingFilter</filter-name>
         <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
         <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
         </init-param>
      </filter>
      
      <filter-mapping>
         <filter-name>encodingFilter</filter-name>
         <url-pattern>/*</url-pattern>
      </filter-mapping>

   </web-app>
   ```

## MySQL, MyBatis 설정
* 참고사이트 : https://mybatis.org/mybatis-3/ko/index.html / http://mybatis.org/spring/ko/getting-started.html
* application-config.xml과 동일한 위치에 jdbc.properties 파일 생성 후 mysql 정보 입력
   ```
   jdbc.driver=com.mysql.cj.jdbc.Driver
   jdbc.url=jdbc:mysql://localhost:3306/marketPlace?serverTimezone=UTC
   jdbc.user=root
   jdbc.password=root
   jdbc.maxPoolSize=20
   ```
* application-config.xml 설정 변경
   ```
   <?xml version="1.0" encoding="UTF-8"?>

   <beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:context="http://www.springframework.org/schema/context"
      xmlns:tx="http://www.springframework.org/schema/tx"
      xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
         http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">
      
      <!-- Uncomment and add your base-package here: -->
            <context:component-scan
               base-package="market.place.repository, market.place.servce"/>
               
      <context:property-placeholder location="classpath:spring/jdbc.properties" /> <!-- jdbc.properties에 등록된 변수 사용하기 위해 가져오기 -->
      
      <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource"> <!-- mysql 연동 bean 등록 -->
         <property name="driverClassName" value="${jdbc.driver}"></property>
         <property name="url" value="${jdbc.url}"></property>
         <property name="username" value="${jdbc.user}"></property>
         <property name="password" value="${jdbc.password}"></property>
      </bean>
      
      <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean"> <!-- mybatis 사용을 위한 sessionFactory bean 등록 -->
         <property name="dataSource" ref="dataSource" />
         <property name="configLocation" value="classpath:spring/mybatis-config.xml" /> <!-- mybatis 설정파일 등록 -->
      </bean>
      
      <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate"> <!-- mybatis 사용을 위한 sqlSession bean 등록 -->
         <constructor-arg index="0" ref="sqlSessionFactory" />
      </bean>
      
      <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager"> <!-- transaction 처리를 위한 bean 등록 -->
         <property name="dataSource" ref="dataSource"></property>
      </bean>
      
      <tx:annotation-driven transaction-manager="transactionManager"/> <!-- 하단 Namespaces 바를 클릭하여 tx 선택해주기 -->
   </beans>
   ```
* mybatis-config.xml 설정
   * 파일위치 : src/main/resources/spring에 xml파일로 생성
   * DTO alias와 사용할 mapper 등록
      ```
      <?xml version="1.0" encoding="UTF-8" ?>
      <!DOCTYPE configuration
      PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
      "http://mybatis.org/dtd/mybatis-3-config.dtd">
      <configuration>
         <typeAliases>
            <typeAlias type="market.place.dto.Product" alias="product"/> <!-- DTO로 market.place.dto 패키지에 Product라는 클래스를 생성 -->
         </typeAliases>
         
         <mappers>
            <mapper resource="spring/mapper/productmapper.xml" /> <!-- src/main/resources/spring에 mapper라는 폴더를 생성하여 그 안에 xml파일 생성 -->
         </mappers>
      </configuration>
      ```
* *mapper.xml 설정
   * namespace 지정 및 sql구문 등록
      ```
      <?xml version="1.0" encoding="UTF-8" ?>
      <!DOCTYPE mapper
      PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
      "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
      <mapper namespace="market.place.product">
         <select id="selectAll" resultType="product">
            select * from product;
         </select>
         
         <insert id="insert" parameterType="product">
            insert into product(userid, name, description, sales, regdate) values (#{userid}, #{name}, #{description}, #{sales}, date_format(#{regdate}, '%Y-%m-%d))
         </insert>
      </mapper>
      ```

# 개발환경 설정 (Class)
## mvc-config.xml 설정
* mvc-config로 지정 할 클래스파일 등록
   ```
   <?xml version="1.0" encoding="UTF-8"?>

   <beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
         http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
         
      <context:annotation-config></context:annotation-config>
      <bean class="market.place.config.MVCConfig"></bean> <!-- market.place.config 패키지에 MVCConfig라는 클래스를 생성 -->
   </beans>
   ```

* MVCConfig 클래스 작성
   ```
   package market.place.config;

   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.ComponentScan;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.servlet.ViewResolver;
   import org.springframework.web.servlet.config.annotation.EnableWebMvc;
   import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
   import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
   import org.springframework.web.servlet.view.InternalResourceViewResolver;

   @Configuration
   @EnableWebMvc
   @ComponentScan(basePackages= {"market.place.controller", "market.place.config"})
   public class MVCConfig implements WebMvcConfigurer {
      
      @Override
      public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/"); // swagger 등록
         registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
      }
      
      @Bean
      public ViewResolver viewResolver() {
         InternalResourceViewResolver vr = new InternalResourceViewResolver();
         vr.setPrefix("/"); // Controller에서 jsp파일 위치를 src/main/webapp/ 로 판단
         vr.setSuffix(".jsp");
         return vr;
      }
   }
   ```
## application-config.xml 설정
* application-config로 지정 할 클래스파일 등록
   ```
   <?xml version="1.0" encoding="UTF-8"?>

   <beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:context="http://www.springframework.org/schema/context"
      xmlns:tx="http://www.springframework.org/schema/tx"
      xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
         http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">
      
      <context:annotation-config></context:annotation-config>
      <bean class="market.place.config.ApplicationConfig"></bean>
   </beans>
   ```
* ApplicationConfig 클래스 작성
   ```
   package market.place.config;

   import org.springframework.context.annotation.ComponentScan;
   import org.springframework.context.annotation.Configuration;

   @Configuration
   @ComponentScan(basePackages= {"market.place.repository", "market.place.service"})
   public class ApplicationConfig {

   }
   ```

## web.xml 설정
* 위의 xml 방식과 동일

## MySQL, MyBatis 설정
* 참고사이트 : https://mybatis.org/mybatis-3/ko/index.html / http://mybatis.org/spring/ko/getting-started.html
* ApplicationConfig 클래스 변경
   ```
   package market.place.config;

   import org.apache.commons.dbcp.BasicDataSource;
   import org.mybatis.spring.SqlSessionFactoryBean;
   import org.mybatis.spring.SqlSessionTemplate;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.ComponentScan;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
   import org.springframework.jdbc.datasource.DataSourceTransactionManager;
   import org.springframework.transaction.PlatformTransactionManager;
   import org.springframework.transaction.annotation.EnableTransactionManagement;

   @Configuration
   @ComponentScan(basePackages= {"market.place.repository", "market.place.service"})
   @EnableTransactionManagement
   public class ApplicationConfig {
      
      @Bean
      public BasicDataSource dataSource() { // mysql연동
         BasicDataSource dataSource = new BasicDataSource();
         dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
         dataSource.setUrl("jdbc:mysql://localhost:3306/marketPlace?serverTimezone=UTC");
         dataSource.setUsername("root");
         dataSource.setPassword("root");
         return dataSource;
      }
      
      @Bean
      public SqlSessionFactoryBean sqlSessionFactory() throws Exception { // mybatis 연동을 위한 SqlSessionFactory
         SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
         sqlSessionFactory.setDataSource(dataSource());
         sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:spring/mybatis-config.xml")); // mybatis-config 등록
         return sqlSessionFactory;
      }
      
      @Bean
      public SqlSessionTemplate sqlSession(SqlSessionFactoryBean sqlsessionFactory) throws Exception { // mybatis 연동을 위한 sqlSession
         return new SqlSessionTemplate(sqlsessionFactory.getObject());
      }
      
      @Bean
      public PlatformTransactionManager transactionManager() { // Transaction 처리를 위한 설정
         DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
         transactionManager.setDataSource(dataSource());
         return transactionManager;
      }
   }
   ```
* mybatis-config.xml 설정
   * 위의 xml 방식과 동일
* *mapper.xml 설정
   * 위의 xml 방식과 동일