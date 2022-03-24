# MVC框架Dao实现
## 项目结构:
src  
├─connection  
├─dao  
│  └─imp  
└─entity

## 笔记:
### 1.mysql接口：
Class.forName(DBDriver)  
DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);

在使用DriverManager时需要声明4个静态常量;
driver：JDBC驱动包
DBURL：url=jdbc:mysql://127.0.0.1:3306/数据库名,jdbc:mysql:是一个规范，必须遵守。
DBUSER: database用户名
DBPASSWORD:database密码

### 2.接口实现
PreparedStatement 对象的 setXxx() 方法来设置这些参数. setXxx() 方法有两个参数，  
第一个参数是要设置的 SQL 语句中的参数的索引(从 1 开始)，第二个是设置的 SQL 语句中的参数的值  
executeUpdate()：返回修改结果
