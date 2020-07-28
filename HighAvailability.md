# 高可用性
高可用性配置是 Lucky PAI 系统为能良好服务于不同地区和的用户体验而部署于分布式网络的文档<br/> 

## 部署架构说明
- 基础系统 <br/>
    ubuntu 18.04
- Docker <br/>
    docker 安装：https://docs.docker.com/
- Mysql 集群 <br/>
    安装镜像:<br/>
    `docker pull percona/percona-xtradb-cluster` <br/>
    重命名镜像（方便使用）：<br/>
    `docker tag docker.io/percona/percona-xtradb-cluster pxc`
    创建一个网段docker network create
    `docker network create --subnet=172.18.0.0/24 net1`
    
- PhpMyadmin <br/>
    docker pull phpmyadmin/phpmyadmin
- Redis 集群<br/>
    
- Zookeeper <br/>

- Kafka 集群<br/>

- PAI Coin 集群<br/>
