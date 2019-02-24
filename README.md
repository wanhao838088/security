## 本项目是maven多模块项目，结构如下:
* security-admin模块
 开发后台管理
 
* security-api模块
 开发android、ios、h5应用等接口
 
* security-app模块
 api模块的依赖，处理无session类的安全认证
 
* security-browser模块
 admin模块的依赖，处理浏览器类的安全认证
 
* security-core模块
 提供项目公共的依赖库、工具类等
 
* security-vue模块
 使用Vue.js编写的前台SPA应用，使用api模块提供Api

### 一、security-vue
使用vue、vuex、better-scroll、mint-ui作为主要依赖，编写的前台应用。
支持手机号登录和账号密码登录，登录成功后返回token，在请求头中携带token，完成请求
需要登录的url。

