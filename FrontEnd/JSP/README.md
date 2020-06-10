# UTF-8 인코딩 필터 설정 (web.xml에 추가)
    ```
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
    ```

# 초기 시작페이지 설정 (web.xml에 추가)
    ```
    <welcome-file-list>
     	<welcome-file>hello.jsp</welcome-file> <!-- 처음 시작페이지를 hello.jsp 페이지로 설정 -->
     </welcome-file-list>
    ```