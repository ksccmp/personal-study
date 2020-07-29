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
* 마우스 우클릭 -> new -> Spring Legacy Project -> Spring MVC Project -> 이름 작성 -> 기본 패키지 설정 (ex) sc.video.chat)
* /src/main/WEB-INF/web.xml에서 <java-version>과 하단의 maven-compiler-plugin의 configuration <source>와<target> 1.8로 변경
* 생성된 프로젝트 우클릭 -> Maven -> Update Project
* 생성된 프로젝트 우클릭 -> Run As -> Run on Server -> 위에서 가져온 Tomcat 클릭한 뒤 Finish 하면 default로 만들어지는 home.jsp가 실행된 창 오픈

# STS에서 Run on Server로 실행되는 브라우저 변경
* STS 상단바의 Window -> Preferences -> 'browser' 검색 -> General의 Web Browser -> Use external web browser 선택 및 실행될 web browser 선택

# pom.xml에 dependency 변경 및 추가 (pom.xml의 내용이 변경되면 항상 Update Project 수행)
* https://mvnrepository.com/ 에 접속하여 검색을 통해 dependency 찾기 가능
* 추가한 dependency
   * spring-jdbc : java에서 DB에 접근할 수 있도록 해줌
   * spring-tx : DB transaction 처리 역할을 수행
   * mysql-connector-java : mysql 연결을 위한 설정
   * mybatis, mybatis-spring : mybatis를 사용하여 java와 mysql을 연동
   * commons-dbcp : DB의 커넥션풀을 생성하여 DB를 사용할 수 있는 환경 제공
   * jackson-databind : JSON구조를 처리해주는 라이브러리
   * lombok : DTO를 효율적으로 설정하게 해주는 라이브러리 (인터넷에 검색하여 따로 추가적인 설치파일 설치하기)
   * springfox-swagger-ui, springfox-swagger2 : 구조화 된 Spring이 잘 동작하는지 확인할 수 있는 환경 제공
* 변경 및 추가를 통한 최종 pom.xml
   ```
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/maven-v4_0_0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <groupId>sc.video</groupId>
      <artifactId>chat</artifactId>
      <name>Spring</name>
      <packaging>war</packaging>
      <version>1.0.0-BUILD-SNAPSHOT</version>
      <properties>
         <!-- Java -->
         <java-version>1.8</java-version>
         
         <!-- Spring -->
         <org.springframework-version>5.2.8.RELEASE</org.springframework-version>
         
         <!-- Aspect -->
         <org.aspectj-version>1.9.6</org.aspectj-version>
         
         <!-- Slf4j -->
         <org.slf4j-version>1.7.5</org.slf4j-version>
      </properties>
      <dependencies>
         <!-- Spring -->
         <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${org.springframework-version}</version>
            <exclusions>
               <!-- Exclude Commons Logging in favor of SLF4j -->
               <exclusion>
                  <groupId>commons-logging</groupId>
                  <artifactId>commons-logging</artifactId>
               </exclusion>
            </exclusions>
         </dependency>
         
         <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${org.springframework-version}</version>
         </dependency>
         
         <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${org.springframework-version}</version>
         </dependency>
         
         <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${org.springframework-version}</version>
         </dependency>
         
         <!-- DB -->
         <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.21</version>
         </dependency>
         
         <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.5</version>
         </dependency>
         
         <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.5</version>
         </dependency>
         
         <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-dbcp2</artifactId>
            <version>2.7.0</version>
         </dependency>
         
         <!-- Binding -->
         <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.11.1</version>
         </dependency>		
         
         <!-- Lombok -->
         <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.12</version>
            <scope>provided</scope>
         </dependency>
         
         <!-- Swagger -->
         <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
         </dependency>
         
         <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
         </dependency>
               
         <!-- AspectJ -->
         <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>${org.aspectj-version}</version>
         </dependency>	
         
         <!-- Logging -->
         <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${org.slf4j-version}</version>
         </dependency>
         <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>jcl-over-slf4j</artifactId>
            <version>${org.slf4j-version}</version>
            <scope>runtime</scope>
         </dependency>
         <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>${org.slf4j-version}</version>
            <scope>runtime</scope>
         </dependency>
         <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.15</version>
            <exclusions>
               <exclusion>
                  <groupId>javax.mail</groupId>
                  <artifactId>mail</artifactId>
               </exclusion>
               <exclusion>
                  <groupId>javax.jms</groupId>
                  <artifactId>jms</artifactId>
               </exclusion>
               <exclusion>
                  <groupId>com.sun.jdmk</groupId>
                  <artifactId>jmxtools</artifactId>
               </exclusion>
               <exclusion>
                  <groupId>com.sun.jmx</groupId>
                  <artifactId>jmxri</artifactId>
               </exclusion>
            </exclusions>
            <scope>runtime</scope>
         </dependency>

         <!-- @Inject -->
         <dependency>
            <groupId>javax.inject</groupId>
            <artifactId>javax.inject</artifactId>
            <version>1</version>
         </dependency>
               
         <!-- Servlet -->
         <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
         </dependency>
         <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
            <scope>provided</scope>
         </dependency>
         <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
         </dependency>
      
         <!-- Test -->
         <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.7</version>
            <scope>test</scope>
         </dependency>        
      </dependencies>
      <build>
         <plugins>
               <plugin>
                  <artifactId>maven-eclipse-plugin</artifactId>
                  <version>2.9</version>
                  <configuration>
                     <additionalProjectnatures>
                           <projectnature>org.springframework.ide.eclipse.core.springnature</projectnature>
                     </additionalProjectnatures>
                     <additionalBuildcommands>
                           <buildcommand>org.springframework.ide.eclipse.core.springbuilder</buildcommand>
                     </additionalBuildcommands>
                     <downloadSources>true</downloadSources>
                     <downloadJavadocs>true</downloadJavadocs>
                  </configuration>
               </plugin>
               <plugin>
                  <groupId>org.apache.maven.plugins</groupId>
                  <artifactId>maven-compiler-plugin</artifactId>
                  <version>2.5.1</version>
                  <configuration>
                     <source>1.8</source>
                     <target>1.8</target>
                     <compilerArgument>-Xlint:all</compilerArgument>
                     <showWarnings>true</showWarnings>
                     <showDeprecation>true</showDeprecation>
                  </configuration>
               </plugin>
               <plugin>
                  <groupId>org.codehaus.mojo</groupId>
                  <artifactId>exec-maven-plugin</artifactId>
                  <version>1.2.1</version>
                  <configuration>
                     <mainClass>org.test.int1.Main</mainClass>
                  </configuration>
               </plugin>
         </plugins>
      </build>
   </project>
   ```

# 개발환경 설정 (xml)
## servlet-context.xml 설정
* web 연결과 관련된 설정들을 구성하는 파일 (View ↔ Controller 등)
* 파일위치 : src/main/webapp/WEB-INF/spring/appServlet
* Controller의 base package 등록 (패키지 이름을 Controller에 sc.video.chat.controller 사용 예정)
   ```
   <?xml version="1.0" encoding="UTF-8"?>
   <beans:beans xmlns="http://www.springframework.org/schema/mvc"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:beans="http://www.springframework.org/schema/beans"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd
         http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

      <!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
      
      <!-- Enables the Spring MVC @Controller programming model -->
      <annotation-driven />

      <!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
      <resources mapping="/resources/**" location="/resources/" />

      <!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
      <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
         <beans:property name="prefix" value="/WEB-INF/views/" />
         <beans:property name="suffix" value=".jsp" />
      </beans:bean>
      
      <context:component-scan base-package="sc.video.chat.controller" />
   </beans:beans>
   ```
## root-context.xml 설정
* web 연결과 관련되지 않은 나머지를 구성하는 파일
* 파일위치 : src/main/WEB-INF/spring
* 하단 바의 Namespaces에서 context 클릭
* Repository와 Service의 base package 등록 (패키지 이름을 Repository는 sc.video.chat.repository, Service는 sc.video.chat.service 할 예정)
   ```
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:tx="http://www.springframework.org/schema/tx"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
         http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">
      
      <!-- Uncomment and add your base-package here: -->
            <context:component-scan
               base-package="sc.video.chat.repository, sc.video.chat.service"/>  

   </beans>
   ```

## web.xml 설정
* DispatcherServlet, ContextConfigLocation 등을 구성하는 파일
* 파일위치 : src/main/webapp/WEB-INF
* Encoding 설정하기
   ```
   <?xml version="1.0" encoding="UTF-8"?>
   <web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://java.sun.com/xml/ns/javaee https://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">

      <!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
      <context-param>
         <param-name>contextConfigLocation</param-name>
         <param-value>/WEB-INF/spring/root-context.xml</param-value>
      </context-param>
      
      <!-- Creates the Spring Container shared by all Servlets and Filters -->
      <listener>
         <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
      </listener>

      <!-- Processes application requests -->
      <servlet>
         <servlet-name>appServlet</servlet-name>
         <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
         <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
         </init-param>
         <load-on-startup>1</load-on-startup>
      </servlet>
         
      <servlet-mapping>
         <servlet-name>appServlet</servlet-name>
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
* src/main/resources에 jdbc.properties 파일 생성 후 mysql 정보 입력
   ```
   jdbc.driver=com.mysql.cj.jdbc.Driver
   jdbc.url=jdbc:mysql://localhost:3306/videochat?serverTimezone=UTC
   jdbc.user=root
   jdbc.password=root
   jdbc.maxPoolSize=20
   ```
* root-context.xml 설정 변경
   ```
   <?xml version="1.0" encoding="UTF-8"?>
      <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:tx="http://www.springframework.org/schema/tx"
         xmlns:context="http://www.springframework.org/schema/context"
         xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
            http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">
         
         <!-- Uncomment and add your base-package here: -->
               <context:component-scan
                  base-package="sc.video.chat.repository, sc.video.chat.service"/>  
               
      <context:property-placeholder location="classpath:jdbc.properties" /> <!-- jdbc.properties에 등록된 변수 사용하기 위해 가져오기 -->
      
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
            <typeAlias type="sc.video.chat.dto.User" alias="user"/> <!-- DTO로 sc.video.chat.dto 패키지에 User라는 클래스를 생성 -->
         </typeAliases>
         
         <mappers>
            <mapper resource="mapper/usermapper.xml"/>  <!-- src/main/resources에 mapper라는 폴더를 생성하여 그 안에 xml파일 생성 -->
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
      <mapper namespace="sc.video.chat.usermapper">
         <insert id="insert" parameterType="user">
            insert into user(name, age) values (#{name}, #{age}) 
         </insert>
      </mapper>
      ```

# 개발환경 설정 (Class)
## servlet-context.xml 설정
* servlet-context로 지정 할 클래스파일 등록
   ```
   <?xml version="1.0" encoding="UTF-8"?>
   <beans:beans xmlns="http://www.springframework.org/schema/mvc"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:beans="http://www.springframework.org/schema/beans"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd
         http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
         
      <context:annotation-config></context:annotation-config>
      <beans:bean class="sc.video.chat.config.ServletContext"></beans:bean>

   </beans:beans>
   ```

* ServletContext 클래스 작성
   ```
   package sc.video.chat.config;

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
   @ComponentScan(basePackages = {"sc.video.chat.controller", "sc.video.chat.config"})
   public class ServletContext implements WebMvcConfigurer {
      
      @Override
      public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/"); // swagger 등록
         registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/"); // swagger 등록
         registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
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
## root-context.xml 설정
* root-context로 지정 할 클래스파일 등록
   ```
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:tx="http://www.springframework.org/schema/tx"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
         http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">
      
      <context:annotation-config></context:annotation-config>
      <bean class="sc.video.chat.config.RootContext"></bean>	
   </beans>
   ```
* RootContext 클래스 작성
   ```
   package sc.video.chat.config;

   import org.springframework.context.annotation.ComponentScan;
   import org.springframework.context.annotation.Configuration;

   @Configuration
   @ComponentScan(basePackages = {"sc.video.chat.repository", "sc.video.chat.service"})
   public class RootContext {

   }
   ```

## web.xml 설정
* 위의 xml 방식과 동일

## MySQL, MyBatis 설정
* 참고사이트 : https://mybatis.org/mybatis-3/ko/index.html / http://mybatis.org/spring/ko/getting-started.html
* RootContext 클래스 변경
   ```
   package sc.video.chat.config;

   import org.apache.commons.dbcp2.BasicDataSource;
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
   @ComponentScan(basePackages = {"sc.video.chat.repository", "sc.video.chat.service"})
   @EnableTransactionManagement
   public class RootContext {
      
      @Bean
      public BasicDataSource dataSource() { // mysql연동
         BasicDataSource dataSource = new BasicDataSource();
         dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
         dataSource.setUrl("jdbc:mysql://localhost:3306/videochat?serverTimezone=UTC");
         dataSource.setUsername("root");
         dataSource.setPassword("root");
         return dataSource;
      }
      
      @Bean
      public SqlSessionFactoryBean sqlSessionFactory() throws Exception { // mybatis 연동을 위한 SqlSessionFactory
         SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
         sqlSessionFactory.setDataSource(dataSource());
         sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml")); // mybatis-config 등록
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

## Swagger 설정
* ApplicationConfig, MVCConfig와 같은 패키지에 SwaggerConfig 클래스 생성
* Title, Description, Version을 정하여 클래스파일 작성
   ```
   package sc.video.chat.config;

   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;

   import springfox.documentation.builders.ApiInfoBuilder;
   import springfox.documentation.builders.PathSelectors;
   import springfox.documentation.builders.RequestHandlerSelectors;
   import springfox.documentation.service.ApiInfo;
   import springfox.documentation.spi.DocumentationType;
   import springfox.documentation.spring.web.plugins.Docket;
   import springfox.documentation.swagger2.annotations.EnableSwagger2;

   @Configuration
   @EnableSwagger2
   public class SwaggerConfig {
      
      private ApiInfo metadata() {
         return new ApiInfoBuilder().title("video-chat").description("we can communication in video").version("1.0").build();
      }

      @Bean
      public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
               .paths(PathSelectors.any()).build().apiInfo(metadata());
      }
   }
   ```

# Mybatis log 설정
* src/main/resources/logback.xml에 코드 작성
   ```
   <!-- Application Loggers -->
   <logger name="${basepackage 이름}"> --> ex) <logger name="market.place">
      <level value="debug" />
   </logger>
   ```