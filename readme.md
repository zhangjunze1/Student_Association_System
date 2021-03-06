##本项目是学生社团管理系统一个基于Spring Boot + Vue.js构建的一个前后端分离项目框架的后端项目代码部分。
###后端是基于SprintBoot + mybatis-plus + mysql+swagger2的开发框架并使用了阿里云的对象存储OSS。

## 后端技术栈
SpringBoot   
Mybatis plus
Oss 对象存储  
swagger2+knife4j： http://localhost:8085/doc.html
## 功能
#### 管理员功能
1. 管理社团：增加新社团（设置社长）、修改社长、删除社团、社团活动管理（报名活动查询、结束活动查询、活动删除）、社团活动报名者的管理（查看、删除）
2. 成员管理：成员信息管理（成员条件查询、删除）
3. 社团申请：审批社团申请（同意、不同意）
4. 活动审批：审批活动申请（同意、不同意）
5. 个人信息修改：用户名、密码、电话号码、个性签名、性别
6. 系统公告：修改系统公告
#### 社长功能
1. 社团报名：查看社团已有活动、报名社团
2. 社长中心：社团成员管理（条件查询、删除）、审批成员申请社团（同意、不同意）
3. 活动管理：活动管理（新增活动、活动报名通知展示、活动结束通知展示、活动名单（成员管理（审批通过、审批不通过、删除））、新增结束活动通知、报名结束）
4. 我的中心：活动记录、我的社团（活动报名、社团公告）
5. 个人信息修改：用户名、密码、电话号码、个性签名、性别
6. 公告：系统公告、社团公告编辑 
#### 成员功能
1. 社团成立：新增社团等待审批
2. 社团报名：查看社团已有活动、报名社团、活动查询（报名活动、结束通知）
3. 活动记录：活动信息（报名活动、结束通知）
4. 我的社团：社团公告、社团活动（查看报名活动、查看结束通知、申请活动）
5. 个人信息修改：用户名、密码、电话号码、个性签名、性别
6. 系统公告查看
#### 登录、注册功能

### 运行提示
1. cn.edu.shu.xj.ser.config.oss
```javascript
    String endpoint = "............";
    String accessKeyId = "............";
    String accessKeySecret = "............";
    String bucketName = "............";
```
此类中，所属的阿里云的Oss的参数填上自己的（前端有上传图片到阿里云oss的功能）
2. 在application.properties中
+ 运用自己的数据库运行账号密码运行
3. 对应数据库的sql文件 在resources目录下system.sql
+ 管理员 账号：31801087 密码：123123
+ 其中一个社长 账号：123123 密码：123123 （其余用户密码详见数据库）
+ 还有用户（其余用户密码详见数据库）
