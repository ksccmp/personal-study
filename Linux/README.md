# MySQL 설치
## 기본설정
* yum update (좀 오래걸림...)
  ```
  sudo yum update (ubuntu는 yum대신 apt)
  ```
* mysql 필수파일 설치 (차례대로 수행)
  ```
  wget http://repo.mysql.com/yum/mysql-5.7-community/el/7/x86_64/mysql-community-common-5.7.20-1.el7.x86_64.rpm
  wget http://repo.mysql.com/yum/mysql-5.7-community/el/7/x86_64/mysql-community-libs-5.7.20-1.el7.x86_64.rpm
  wget http://repo.mysql.com/yum/mysql-5.7-community/el/7/x86_64/mysql-community-client-5.7.20-1.el7.x86_64.rpm
  wget http://repo.mysql.com/yum/mysql-5.7-community/el/7/x86_64/mysql-community-server-5.7.20-1.el7.x86_64.rpm
  ```
* mysql 시작
  ```
  sudo service mysqld start
  ```
* mysql 상태보기
  ```
  sudo service mysqld status
  ```
* mysql 접속
  ```
  mysql -u root -p (비밀번호가 없으니 비밀번호 입력시 Enter) (안될 경우 grep 'temporary password' /var/log/mysqld.log에서 임시비밀번호 확인)
  ```
* 설정 추가
  ```
  vi /etc/my.cnf
  ```
  ```
  [client] 
  default-character-set = utf8 

  [mysql] 
  default-character-set=utf8 
  
  [mysqld] 
  datadir=/var/lib/mysql 
  socket=/var/lib/mysql/mysql.sock 
  character-set-server=utf8 
  collation-server=utf8_general_ci 
  init_connect=SET collation_connection = utf8_general_ci 
  init_connect=SET NAMES utf8 
  character-set-client-handshake = FALSE 
  skip-character-set-client-handshake 
  
  [mysqldump]
  default-character-set=utf8
  ```
* 방화벽 오픈
  ```
  firewall-cmd --zone=public --add-port=3306/tcp --permanent
  firewall-cmd --reload
  ```
* 원격접속 허용
  ```
  sudo service mysqld start
  ```
  ```
  GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION; (에러 날 경우 CREATE USER 'root'@'%' IDENTIFIED BY 'root'; 수행 후 다시 실행) => centos에서 접속할 때는 비밀번호가 없고, 원격에서 접속할 때는 비밀번호 root
  ```
# NGINX 설치
## 기본설정
* centos yum 저장소에 외부저장소 추가 (yum 저장소에 nginx가 없기 떄문)
  ```
  vi /etc/yum.repos.d/nginx.repo
  ```
  ```
  [nginx]
  name=nginx repo
  baseurl=http://nginx.org/packages/centos/7/$basearch/
  gpgcheck=0
  enabled=1
  ```
* ngnix 설치
  ```
  yum -y install nginx
  ```
* nginx 시작
  ```
  sudo systemctl start nginx
  ```
* nginx 종료
  ```
  sudo systemctl stop nginx
  ```
* nginx 상태보기
  ```
  sudo systemctl status nginx
  ```
* 방화벽 오픈
  ```
  firewall-cmd --zone=public --add-port=80/tcp --permanent
  firewall-cmd --reload
  ```
* nginx.conf 수정
  ```
  vi /etc/nginx/nginx.conf
  ```
  ```
  nginx.conf 내용.....
  ```
## SSL 적용
* 저장위치 이동
  ```
  cd /etc/nginx/
  mkdir ssl
  cd /etc/nginx/ssl
  ```
* 개인키 생성
  ```
  openssl genrsa -out server.key 2048
  ```
* 공용키 생성
  ```
  openssl rsa -in server.key -pubout -out serverPublic.key
  ```
* CSR(인증요청서) 생성
  ```
  openssl req -new -key server.key -out server.csr
  ```
* CA 개인키 생성
  ```
  openssl genrsa -out CA.key 2048
  ```
* CA CSR 생성
  ```
  openssl req -x509 -new -nodes -key CA.key -days 3650 -out CA.pem
  ```
* CRT(인증서) 생성
  ```
  openssl x509 -req -in server.csr -CA CA.pem -CAkey CA.key -CAcreateserial -out server.crt -days 3650
  ```
* 방화벽 오픈
  ```
  firewall-cmd --zone=public --add-port=443/tcp --permanent
  firewall-cmd --reload
  ```
* nginx.conf 수정
  ```
  vi /etc/nginx/nginx.conf
  ```
  ```
  nginx.conf 내용.....
  ```
## Front 파일 배포
  * 폴더 생성
  ```
  cd /home/{계정} ex) /home/mynode
  mkdir {저장할 위치 만들기} ex) mkdir video_chat / cd video_chat / mkdir frontend / cd frontend / mkdir typescript
  ```
  * 저장위치까지 관련된 모든 폴더 chmod 755로 설정
  ```
  cd /
  chmod -R 777 home
  ```
  * 저장 폴더 chcon 적용
  ```
  cd {저장 폴더 전 위치} ex) cd /home/mynode/video_chat/frontend
  chcon -R -t httpd_sys_content_t typescript
  ```
  * 적용 확인
  ```
  cd typescript
  ls -lZd
  ```
# Tomcat 설치
## 기본설정
* openjdk 설치
  ```
  yum install java-1.8.0-openjdk
  yum install java-1.8.0-openjdk-devel
  ```
* 심볼릭 링크 설정
  ```
  cd /usr/lib/jvm
  ln -s java-1.8.0-openjdk-1.8.0.262.b10-0.el8_2.x86_64/ jdk
  ```
* 설정파일 수정
  ```
  vi /etc/profile
  ```
  ```
  JAVA_HOME=/usr/lib/jvm/jdk -- 추가
  PATH=$PATH:$JAVA_HOME/bin -- 추가
  CLASSPATH=$JAVA_HOME/jre/lib:$JAVA_HOME/lib/tools.jar -- 추가

  export JAVA_HOME PATH CLASSPATH -- 추가

  pathmunge () {
  ...
  ```
* 적용 및 테스트
  ```
  source /etc/profile
  echo $JAVA_HOME
  echo $PATH
  echo $CLASSPATH
  ```
* tomcat 설치
  ```
  cd /usr/local
  wget http://archive.apache.org/dist/tomcat/tomcat-8/v8.5.27/bin/apache-tomcat-8.5.27.tar.gz
  tar xvfz apache-tomcat-8.5.27.tar.gz
  ```
* 심볼릭 링크 설정
  ```
  ln -s apache-tomcat-8.5.27/ tomcat
  ```
* 설정파일 수정
  ```
  vi /etc/profile
  ```
  ```
  JAVA_HOME=/usr/lib/jvm/jdk
  JRE_HOME=/usr/lib/jvm/jdk -- 추가
  CATALINA_HOME=/usr/local/tomcat -- 추가
  PATH=$PATH:$JAVA_HOME/bin:$CATALINA_HOME/bin -- 변경
  CLASSPATH=$JAVA_HOME/jre/lib:$JAVA_HOME/lib/tools.jar:$CATALINA_HOME/lib/jsp-api.jar:$CATALINA_HOME/lib/servlet-api.jar -- 변경

  export JAVA_HOME PATH CLASSPATH CATALINA_HOME JRE_HOME -- 변경

  pathmunge () {
  ...
  ```
* 적용 및 테스트
  ```
  source /etc/profile
  echo $JRE_HOME
  echo $CATALINA_HOME
  ```
* tomcat 실행
  ```
  /usr/local/tomcat/bin/startup.sh
  ```
* tomcat 중지
  ```
  /usr/local/tomcat/bin/shutdown.sh
  ```
* tomcat 실행확인
  ```
  netstat -an | grep 8080
  ```
* 방화벽 오픈
  ```
  firewall-cmd --zone=public --add-port=8080/tcp --permanent
  firewall-cmd --reload
  ```
* 파일권한 설정
  ```
  cd /usr/local/tomcat
  chmod -R 755 webapps
  chcon -R -t httpd_sys_content_t webapps
  ```
* 무슨설정인지는 모르겠지만 이것도 실행
  ```
  setsebool -P httpd_can_network_connect 1
  ```
* 정상동작 확인
  ```
  /usr/local/tomcat/bin/startup.sh
  ```
  ```
  localhost:8080 접속
  ```
## Back 파일 배포
* webapps로 이동
  ```
  cd /usr/local/tomcat/webapps
  ```
* 해당위치에 war파일을 FTP로 옮겨서 톰캣 재시작하면 war파일이 자동으로 풀림 (ex) videochat.war를 옮기면 재시작 시 videochat 폴더가 생김)
* nginx.conf 수정
  ```
  vi /etc/nginx/nginx.conf
  ```
  ```
  nginx.conf 내용.....
  ```
* Front에서 Back 접근방법
  ```
  const axiosAPI: AxiosInstance = axios.create({
      // baseURL: 'http://localhost:8080/videochat', // axios 사용할 때 path앞에 baseURL이 항상 추가
      baseURL: 'https://ksccmp.iptime.org/videochat', // 배포
  });
  ```
# Node 서버 배포
## 기본설정
* nodejs 설치
  ```
  yum -y install nodejs
  ```
* 저장위치 생성 후 FTP로 node 파일 옮기기 (보통 git을 통해 파일을 가져옴)
  ```
  cd /usr/local/
  mkdir socket
  cd socket
  ```
* 방화벽 오픈
  ```
  firewall-cmd --zone=public --add-port=4000/tcp --permanent
  firewall-cmd --reload
  ```
* 파일 권한 설정
  ```
  cd /usr/local/
  chmod -R 755 socket
  chcon -R -t httpd_sys_content_t socket
  ```
* nginx.conf 수정
  ```
  vi /etc/nginx/nginx.conf
  ```
  ```
  nginx.conf 내용.....
  ```
* node서버 시작
  ```
  node /usr/local/socket/index.js
  ```
* socket서버에 https 적용
  ```
  const app = require('express')();
  const fs = require('fs'); // 배포

  app.use(function (request, response, next) {
      response.setHeader('Content-Type', 'application/json');
      response.setHeader('Access-Control-Allow-Origin', '*');
      response.setHeader('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');
      next();
  });

  // const server = require('http').createServer(app); // 로컬
  const server = require('https').createServer(
      {
          key: fs.readFileSync('/etc/nginx/ssl/server.key'),
          cert: fs.readFileSync('/etc/nginx/ssl/server.crt'),
          ca: fs.readFileSync('/etc/nginx/ssl/CA.pem'),
      },
      app,
  ); // 배포
  const port = 4000;
  const socketIO = require('socket.io')(server);
  ```
* client에서 https적용된 socket 불러오기
  ```
  // const connect: SocketIOClient.Socket = SocketIO.connect('http://localhost:4000'); // 로컬
  const connect: SocketIOClient.Socket = SocketIO.connect('https://ksccmp.iptime.org/', { secure: true }); // 배포
  ```