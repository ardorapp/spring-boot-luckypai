# Lucky PAI 简介
Lucky PAI 是一套用于解决区块链数字货币的红包应用系统<br/> 

- 用户功能：账户管理、红包管理、发红包、抢红包 等
- 支持币种：PAI
- 授权登录：微信、QQ
- 系统功能：权限管理、菜单管理、用户管理，系统设置、实时日志，实时监控，以及登录用户修改密码等<br/>

## 技术栈<br/> 
java后端：SpringBoot + Thymeleaf + WebSocket + Spring Security + SpringData-Jpa + MySql<br/> 
基础技能：JDK1.8、docker、SpringBoot1.5.10、zookeeper3.4.6、kafka_2.11、redis-2.8.4

## 开发环境
- 基础环境 <br/>
    Mac Os 10.14.6+、JDK1.8+、IntelliJ IDEA
- Docker <br/>
    docker 安装：https://docs.docker.com/  <br/>
    
    创建一个网段提供给 Lucky PAI 中各个容器专用: <br/>
    `docker network create --subnet=172.20.0.0/24 luckypai_net`
    
- Mysql <br/>
    获取镜像:<br/>
    `docker pull mysql:latest` <br/>
    启动Mysql服务：<br/>
    `docker run -d --name luckypai_mysql -p 3306:3306 -v /Users/docker/luckypai/mysql/data:/var/lib/mysql -v /Users/docker/luckypai/mysql/mysql.d:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=abc123456 --network=luckypai_net --ip 172.20.0.11 mysql`
    
- Mysql 管理面板(phpmyadmin) <br/>
    获取镜像:<br/>
    `docker pull phpmyadmin/phpmyadmin` <br/>
    启动 phpmyadmin 服务：<br/>
    `docker run -d  --name luckypai_myadmin -p 8283:80 -e PMA_HOST=172.20.0.11 -e PMA_PORT=3306 --network=luckypai_net --ip 172.20.0.12 phpmyadmin/phpmyadmin` <br/>
    登录Mysql管理面板：<br/>
    [http://127.0.0.1:8283](http://127.0.0.1:8283) <br/>
    用户名:root 密码:abc123456 <br/>
    创建数据库:luckypai 字符集:utf8_genaral_ci <br/>
    初始化数据库表结构，数据库脚本位于  src/main/resource/sql/luckypai.sql
    
- Redis <br/>
    获取镜像:<br/>
        `docker pull docker.io/redis` <br/>
    启动 redis 服务：<br/>
        `docker run -d  --name luckypai_redis  -p 6379:6379 -v /Users/docker/luckypai/redis/conf:/conf -v /Users/docker/luckypai/redis/data:/data  --network=luckypai_net --ip 172.20.0.13  redis redis-server /conf/redis.conf` <br/>
    **备注:需要将src/resources/redis/conf/redis.conf 拷贝至 /Users/docker/luckypai/redis/conf/redis.conf 再重启redis服务。**
- Zookeeper <br/>
    获取镜像:<br/>
        `docker pull wurstmeister/zookeeper` <br/>
    启动 zookeeper 服务：<br/>
        `docker run -d --name luckypai_zookeeper -p 2181:2181 --restart=always --network=luckypai_net --ip 172.20.0.14 wurstmeister/zookeeper` <br/>
- Kafka <br/>
    获取镜像:<br/>
        `docker pull wurstmeister/kafka` <br/>
    启动 kafka 服务：<br/>
        `docker run -d --name luckypai_kafka -p 9092:9092 --link luckypai_zookeeper --env KAFKA_ZOOKEEPER_CONNECT=luckypai_zookeeper:2181 --env KAFKA_ADVERTISED_HOST_NAME=127.0.0.1 --env KAFKA_ADVERTISED_PORT=9092 --restart=always  --network=luckypai_net --ip 172.20.0.15 wurstmeister/kafka` <br/>
- Kafka-manager <br/>
   获取镜像:<br/>
       `docker pull sheepkiller/kafka-manager` <br/>
   启动 kafka-manager 服务：<br/> 
       `docker run -d --name luckypai_kafka-manager --link luckypai_zookeeper:luckypai_zookeeper --link luckypai_kafka:luckypai_kafka -p 9001:9000 --restart=always --env ZK_HOSTS=luckypai_zookeeper:2181 --network=luckypai_net --ip 172.20.0.16 sheepkiller/kafka-manager` <br/>
   访问 kafka-manager 控制面板：<br/> 
   [http://127.0.0.1:9001](http://127.0.0.1:9001) <br/>
   
- ActiveMQ <br/>
   获取镜像:<br/>
       `docker pull webcenter/activemq` <br/>
   启动 ActiveMQ 服务：<br/> 
       `docker run -d --name luckypai_activemq -p 61616:61616 -p 8161:8161 --network=luckypai_net --ip 172.20.0.17 webcenter/activemq` <br/>
   访问 Manage ActiveMQ 控制面板：<br/> 
   [http://127.0.0.1:8161/](http://127.0.0.1:8161/)  点击Manage ActiveMQ broker使用默认账号/密码：admin/admin<br/>
    
## 启动说明

- 启动前 请配置 application.properties 中相关redis、zk以及kafka相关地址。

- 配置完成，运行Application中的main方法，访问 http://localhost:8080/luckypai/swagger-ui.html 进行API测试。

- 红包首页：[http://localhost:8080/luckypai/index.shtml](http://localhost:8080/luckypai/index.shtml) ，部分功能待完成。


#FAQ:
##运行时报错
- 报错：java.sql.SQLException: Unable to load authentication plugin 'caching_sha2_password'. <br/>
    *可能是数据库版本和项目中依赖的mysql驱动版本不一致，需要设置 pom.xml
     <dependency>
     	<groupId>mysql</groupId>
     	<artifactId>mysql-connector-java</artifactId>
     	<version>8.0.21</version>
     </dependency>
     中的<version>8.0.21</version> 为实际安装的版本。*

