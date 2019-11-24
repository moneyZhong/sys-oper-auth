shiro主要有三大功能模块：
1. Subject：主体，一般指用户。
2. SecurityManager：安全管理器，管理所有Subject，可以配合内部安全组件。(类似于SpringMVC中的DispatcherServlet)
3. Realms：用于进行权限信息的验证，一般需要自己实现。


shiro 接入



MAC MAVEN 环境变量设置
vi ~/.profile
MAVEN_HOME=/Users/user/workspace/software/apache-maven-3.5.3
export MAVEN_HOME
export PATH=$MAVEN_HOME/bin:$PATH
source .profile 


通过maven 命令查看某个jar对应的pom.xml配置
mvn dependency:tree -Dverbose -Dincludes=com.fasterxml.jackson.core:jackson-annotations
dependency:tree 表示树状显示，还可以dependency:list
-Dverbose 表示可以显示所有的引用，包括因为多次引用重复而忽略的

