shiro主要有三大功能模块：
1. Subject：主体，一般指用户。
2. SecurityManager：安全管理器，管理所有Subject，可以配合内部安全组件。(类似于SpringMVC中的DispatcherServlet)
3. Realms：用于进行权限信息的验证，一般需要自己实现。
