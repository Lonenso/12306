## 总览
JAVAEE 期末大作业，实现类似12306的火车订票系统，要求利用ssh框架开发
## 功能要求
**系统管理**

* 用户管理：用户可根据用户名，密码登陆。
* 站点管理：包括站点名称，站点距离等。
* 车次管理：包括火车车次名称，出发时间，中间站点，中间站点停留时间，达到时间，各站点之间车价，提供等级（二等、一等、特等、硬座、软座等）等

** 基本业务 **
* 普通查询（(对于存在直达车次)给定出发点，终点，出发时间，返回符合要求的火车票）
* 高级查询（（对于不存在直达车次）提供中转站）

## 技术要求
* 必须采用SSH/SpringMVC来完成主要的功能。
* Structs的标签可以不采用。
* Hibernate部分可以采取模板里的自动生成模式，也可以自行编写映射文件。
* Spring采用的注入方式可根据项目实际情况而定。
* 数据库可以采用mysql或者sqlserver等。
* 表单前端处理需要有js来完成部分功能。
* 数据库可以根据自己需要设计，数据内容可自行添加，满足演示要求即可。
* 目录结构必须按照规范要求。
* 车次站点以 数据结构（图） 建模

## 项目结构

├─lib
├─out
├─src
│  │  beans.xml
│  │  hibernate.cfg.xml
│  │  StationEntity.hbm.xml
│  │  struts.xml
│  │  TrainEntity.hbm.xml
│  │  UserEntity.hbm.xml
│  │  
│  ├─action
│  │      advancedAction.java
│  │      deletestationMAction.java
│  │      deletetrainMAction.java
│  │      deleteuserMAction.java
│  │      findAction.java
│  │      loginAction.java
│  │      newstationMAction.java
│  │      newtrainMAction.java
│  │      newuserMAction.java
│  │      registAction.java
│  │      
│  ├─dao
│  │      StationDAO.java
│  │      TrainDAO.java
│  │      UserDAO.java
│  │      
│  ├─model
│  │      advancedRecord.java
│  │      HibernateUtil.java
│  │      Record.java
│  │      StationEntity.java
│  │      TrainEntity.java
│  │      UserEntity.java
│  │      
│  ├─service
│  │      ManagerService.java
│  │      queryService.java
│  │      
│  └─Test
│          advancedActionTest.java
│          findActionTest.java
│          loginActionTest.java
│          StationDAOTest.java
│          TrainDAOTest.java
│          UserDAOTest.java
│          
└─web
    │  advancedQuery.jsp
    │  fail.jsp
    │  index.jsp
    │  loginfail.jsp
    │  Newfail.jsp
    │  Query.jsp
    │  SimpleQuery.jsp
    │  
    ├─Manager
    │      manage.jsp
    │      NewStation.jsp
    │      NewTrains.jsp
    │      NewUser.jsp
    │      StationManage.jsp
    │      TrainsManage.jsp
    │      UserManage.jsp
    │      
    ├─static
    │  ├─css
    │  │      query_style.css
    │  │      style.css
    │  │      
    │  ├─images
    │  │      2.jpg
    │  │      code.bmp
    │  │      default.jpg
    │  │      login_background.jpg
    │  │      logo.jpg
    │  │      pwd-icons-new.png
    │  │      
    │  └─script
    │          jquery-1.7.2.js
    │          Station.js
    │          
    ├─User
    │      login.jsp
    │      regist.jsp
    │      
    └─WEB-INF
            web.xml



## Require Lib
	spring-beans-4.3.13.RELEASE.jar
	spring-context-4.3.13.RELEASE.jar
	spring-context-support-4.3.13.RELEASE.jar
	spring-core-4.3.13.RELEASE.jar
	spring-expression-4.3.13.RELEASE.jar
	spring-instrument-4.3.13.RELEASE.jar
	spring-instrument-tomcat-4.3.13.RELEASE.jar
	spring-jdbc-4.3.13.RELEASE.jar
	spring-jms-4.3.13.RELEASE.jar
	spring-messaging-4.3.13.RELEASE.jar
	spring-orm-4.3.13.RELEASE.jar
	spring-oxm-4.3.13.RELEASE.jar
	spring-test-4.3.13.RELEASE.jar
	spring-tx-4.3.13.RELEASE.jar
	spring-web-4.3.13.RELEASE.jar
	spring-webmvc-4.3.13.RELEASE.jar
	spring-webmvc-portlet-4.3.13.RELEASE.jar
	spring-websocket-4.3.13.RELEASE.jar
	spring-ws.jar
	struts2-core.jar
	struts2-spring-plugin-2.3.1.2.jar
	antlr-2.7.7.jar
	aopalliance-1.0.jar
	classmate-1.3.0.jar
	commons-dbcp-1.2.jar
	commons-fileupload.jar
	commons-io.jar
	commons-lang.jar
	commons-logging-1.2.jar
	commons-pool.jar
	dom4j-1.6.1.jar
	freemarker.jar
	hibernate-commons-annotations-5.0.1.Final.jar
	hibernate-core-5.2.12.Final.jar
	hibernate-jpa-2.1-api-1.0.0.Final.jar
	jandex-2.0.3.Final.jar
	javassist-3.20.0-GA.jar
	jboss-logging-3.3.0.Final.jar
	jboss-transaction-api_1.2_spec-1.0.1.Final.jar
	junit-4.10.jar
	log4j.jar
	mysql-connector-java-5.1.44-bin.jar
	ognl.jar
	spring-aop-4.3.13.RELEASE.jar
	spring-aspects-4.3.13.RELEASE.jar

## 查询实现
1.接收参数：

	出发日期：date
	起始站点：src
	目的站点：dst

返回值：

	车次数据：Record
 
必须得到起始站点在目标日期可搭乘的列车车次，所以首先得到站点在哪些车次上，并根据到达站点的时间间隔修正目标日期得到发车日期，再去查询发车日期存在的车次，再根据起始点和终点以及车次编号，在站点表中查询是否存在同一车次可以满足直达。
2.转车中，对于现在的高铁／动车中不存在转两次以上的车，我们这里就针对这样的情况做出处理。对于超过24小时的转车等待时间认为是不可取的。
3. 对于不满足直达的查询，以src->stop---接续/等待---->stop->dst的结构来查询。
1.接收参数：
出发日期：date
	起始站点：src
	目的站点：dst
返回值：
	车次数据：advancedRecord 包括两条Record
 
首先根据用户给定的出发日期，同简单查询一样，对出发日期进行时间间隔修正得到发车日期，然后找到每个车次中起始站点之后的所有站点，再利用得到的这些站点和用户给出的终点进行直通查询，最后给出结果。
