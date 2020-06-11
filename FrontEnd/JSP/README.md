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

# Jquery 사용하기
## CDN 등록하기
* Jquery CDN 가져오기(아래쪽에 구글CDN 선택) : https://jquery.com/download/
* 3.x snippet에 있는 script를 복사하여 jsp 파일에 붙여넣기 
    ```<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>```
## Jquery 자동완성 플러그인 설치 (Eclipse, STS 사용자)
* 툴 상단의 Help -> Install New Software... -> Work with에 ```http://oss.opensagres.fr/tern.repository/1.2.0/``` 복붙 한 뒤 Embedded, IDE, Tooling 선택 후 next 및 finish
* 재시작 Alert가 나올때 까지 종료하지 않고 기다리기
* 재시작 후 적용시키고 싶은 프로젝트 우클릭 -> Configure -> Convert to Tern Project -> jquery, jquery extension 클릭
## on click 사용법
    ```
    <body>
    <input type="button" value="회원가입" id="signup">
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        $("#signup").on("click", function() {
            console.log("회원가입");
        })
    </script>
    ```