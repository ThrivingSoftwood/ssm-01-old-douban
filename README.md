# SSM 仿写老豆瓣

1. 请注意:由于 spring-mvc.xml 中配置了如下内容,所以需要您将项目的 src/main/webapp/upload中的内容转移到对应的路径下
   ```
   <mvc:resources mapping="/upload/**" location="file://${你的路径}"/>
   ```

2. 请注意:项目前台根路径我本人设置为 `/ssm-01`,如果你想修改成自定义的根路径,请在项目的 API.js 中的 url 修改为相应内容