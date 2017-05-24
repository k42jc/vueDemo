### SpringMVC+Mybatis+Vue.js example


**运行演示步骤：**

前提：maven环境

1. `git clone xxx` clone当前项目到本机任意目录
2. 在命令行进入项目目录(与pom.xml同级目录)
3. 执行`mvn jetty:run`命令，使用jetty插件运行项目，项目加载过程中会加载好供演示的数据结构
4. 待项目启动完成，打开浏览器，输入：`http://localhost:8080`

down...

### 简介
1. 因为vue.js完全可以作为页面模板使用，所以考虑后把html与后台接口完全隔离，后台通过restful接口提供数据/接受请求，页面使用vue-source通信

2. 项目配置了mybatisGenerate与对应的maven插件，可直接使用 `mvn mybatis-generator:generate -e` 命令生成dao、mapper、entity

3. 为演示方便，使用H2 database，每次启动程序都会重置演示数据。
项目中配置了对应的Maven插件，使用 `mvn exec:java` 即可在浏览器登录查看当前项目的数据
