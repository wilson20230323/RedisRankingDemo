# Redis Ranking Demo

这是一个使用Spring Boot和Redis实现的排行榜系统。

## 安装

首先，你需要安装和运行一个Redis服务器。然后，更新`src/main/resources/application.properties`中的Redis服务器地址和端口。

然后，运行以下命令安装和运行这个项目：

```bash
mvn clean install
mvn spring-boot:run

```
## 使用

你可以使用以下API来添加分数和获取排行榜：

- POST `/ranking/{user}?score={score}`：为指定的用户添加分数。
- GET `/ranking/top/{topRank}`：获取前`topRank`名的用户和他们的分数。
```
你可以根据你的实际项目修改这个README文件。在你写完后，别忘了将这个文件也添加到Git并提交。
```