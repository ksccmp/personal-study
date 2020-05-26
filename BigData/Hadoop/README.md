# CentOS 설치
* CentOS 다운로드 사이트 접속 : https://www.centos.org/download
* CentOS Linux DVD ISO 클릭
    <img src="image/centosMain.PNG" width="800px" height="400px" title="CentOS 메인화면" alt="CentOS Main Screen">
* 위에 3개 중 아무거나 클릭하여 설치
    <img src="image/centosInstall.PNG" width="800px" height="400px" title="CentOS 설치" alt="Install CentOS">

# Virtual Box 설치
* Virtual Box 다운로드 사이트 접속 : https://virtualbox.org/wiki/Downloads
* Window hosts 클릭하여 설치
    <img src="image/virtualboxInstall.PNG" width="800px" height="400px" title="Virtual Box 설치" alt="Install Virtual Box">

# Virtual Box에 CentOS 설치 (총 3개의 OS 생성)
## 가상머신 만들기
* Virtual Box 실행시키기
    <img src="image/virtualbox1.PNG" width="800px" height="400px" title="설치 1" alt="Install 1">
* 이름, 머신폴더, 종류, 버전 선택 </br>
    <img src="image/virtualbox2.PNG" width="400px" height="400px" title="설치 2" alt="Install 2">
* 메모리 크기 선택 (Cloudera를 설치 할 OS는 8192MB로 나머지는 1024MB로) </br>
    <img src="image/virtualbox3.PNG" width="400px" height="400px" title="설치 3" alt="Install 3">
* 하드디스크 선택 </br>
    <img src="image/virtualbox4.PNG" width="400px" height="400px" title="설치 4" alt="Install 4">
* 디스크 파일종류 선택 </br>
    <img src="image/virtualbox5.PNG" width="400px" height="400px" title="설치 5" alt="Install 5">
* 할당방식 선택 </br>
    <img src="image/virtualbox6.PNG" width="400px" height="400px" title="설치 6" alt="Install 6">
* 디스크 크기 선택 (모두 40GB로) </br>
    <img src="image/virtualbox7.PNG" width="400px" height="400px" title="설치 7" alt="Install 7">

## 포인팅 장치 셋팅
* 설정에 들어가서 포인팅 장치를 USB 태블릿으로 변경
    <img src="image/mouseSetting.PNG" width="800px" height="400px" title="마우스 세팅" alt="Setting Mouse">

## OS 설치하기
* 설치받은 iso를 등록하여 가상머신 실행시키기 </br>
    <img src="image/os1.PNG" width="400px" height="400px" title="OS 1" alt="OS 1">
* Install CentOS Linux 8 선택
    <img src="image/os2.PNG" width="800px" height="400px" title="OS 2" alt="OS 2">
* 한국어 선택
    <img src="image/os3.PNG" width="800px" height="400px" title="OS 3" alt="OS 3">
* 추가설정 해주기, 우선 KeyBoard 선택
    <img src="image/os4.PNG" width="800px" height="400px" title="OS 4" alt="OS 4">
* 영어(미국) 추가하기
    <img src="image/os5.PNG" width="800px" height="400px" title="OS 5" alt="OS 5">
* 소프트웨어를 선택하여 워크스테이션 선택
    <img src="image/os6.PNG" width="800px" height="400px" title="OS 6" alt="OS 6">
* 네트워크 및 호스트를 선택하여 오른쪽에 이더넷 켜주기
    <img src="image/os7.PNG" width="800px" height="400px" title="OS 7" alt="OS 7">
* 설치 시작을 누른 뒤 Root와 User를 클릭하여 생성하기
    <img src="image/os8.PNG" width="800px" height="400px" title="OS 8" alt="OS 8">
* 업데이트가 완료되면 재부팅 하기
    <img src="image/os9.PNG" width="800px" height="400px" title="OS 9" alt="OS 9">
* 등록한 iso 제거하기
    <img src="image/os10.PNG" width="800px" height="400px" title="OS 10" alt="OS 10">
* 강제 마운트 해제 클릭 </br>
    <img src="image/os11.PNG" width="400px" height="400px" title="OS 11" alt="OS 11">
* 시스템 전원 끄기를 클릭하여 종료하기 </br>
    <img src="image/os12.PNG" width="400px" height="400px" title="OS 12" alt="OS 12">
* 다시 실행을 시킨 뒤 License Information 클릭
    <img src="image/os13.PNG" width="800px" height="400px" title="OS 13" alt="OS 13">
* 약관에 동의한 뒤 완료 클릭
    <img src="image/os14.PNG" width="800px" height="400px" title="OS 14" alt="OS 14">
* 설정완료 클릭
    <img src="image/os15.PNG" width="800px" height="400px" title="OS 15" alt="OS 15">
* 등록한 계정 클릭
    <img src="image/os16.PNG" width="800px" height="400px" title="OS 16" alt="OS 16">
* 등록한 비밀번호 입력
    <img src="image/os17.PNG" width="800px" height="400px" title="OS 17" alt="OS 17">
* 등록한 언어 확인 후 다음 클릭
    <img src="image/os18.PNG" width="800px" height="400px" title="OS 18" alt="OS 18">
* 가운데 껄로 입력기 선택 후 다음 클릭
    <img src="image/os19.PNG" width="800px" height="400px" title="OS 19" alt="OS 19">
* 위치 정보 서비스 여부 선택 후 다음 (저 같은 경우는 해제)
    <img src="image/os20.PNG" width="800px" height="400px" title="OS 20" alt="OS 20">
* 연결하고 싶은 계정 연결 (저 같은 경우는 건너뛰기)
    <img src="image/os21.PNG" width="800px" height="400px" title="OS 21" alt="OS 21">
* CentOS Linux 시작 클릭
    <img src="image/os22.PNG" width="800px" height="400px" title="OS 22" alt="OS 22">
* 필요한 경우 읽고 필요없을 경우 오른쪽 상단의 X를 클릭하면 메인화면 등장하며 설치 완료
    <img src="image/os23.PNG" width="800px" height="400px" title="OS 23" alt="OS 23">

# 고정 IP 등록 (터미널에서 수행)
* root계정으로 접속 </br>
    ```su - root``` 입력 후 등록한 비밀번호 입력
* 네트워크 설정 폴더로 이동 </br>
    ```cd /etc/sysconfig/network-scripts```
* 설정 파일 텍스트 열기 (파일 이름이 다를 수도 있음) </br>
    ```vi ifcfg-enp0s3```
* 텍스트 파일 변경하기 </br>
    ```
    TYPE="Ethernet"
    PROXY_METHOD="none"
    BROWSER_ONLY="no"
    #BOOTPROTO="dhcp" --> 변경
    DEFROUTE="yes"
    IPV4_FAILURE_FATAL="no"
    #IPV6INIT="yes" --> 변경
    #IPV6_AUTOCONF="yes" --> 변경
    #IPV6_DEFROUTE="yes" --> 변경
    #IPV6_FAILURE_FATAL="no" --> 변경
    #IPV6_ADDR_GEN_MODE="stable-privacy" --> 변경
    NAME="enp0s3"
    UUID="a63b84el-lb4e-48b3-al87-d3360b0f9025"
    DEVICE="enp0s3"
    ONBOOT="yes"

    BOOTPROTO="static" --> 추가
    IPADDR="192.168.0.121" --> 추가
    NETMASK="255.255.255.0" --> 추가
    GATEWAY="192.168.0.1" --> 추가
    DNS1="168.126.63.1" --> 추가
    DNS2="168.126.63.2" --> 추가
    ```
* 네트워크 재시작하기 </br>
    ```systemctl restart network```
* 네트워크 재시작이 에러 날 경우 </br>
    ```systemctl is-active network``` --> 동작하는지 확인
    active가 아닐 경우 ```yum install network-scripts``` 로 설치
* 재시작을 해서 ip 변경이 일어나지 않을 경우 centOS 종료 후 다시 시작하기

# HostName 영구적으로 변경하기 (터미널에서 수행)
* ```hostnamectl status```를 입력하면 정보 확인 가능, default로 localhost.localdomain 되어 있음
* ```hostnamectl set-hostname {host명}```을 입력하면 root계정 정보 입력 후 변경