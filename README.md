# shop
ssh+mysql online shopping mall
#ssm+mysql的网上商城系统
  ssm+mysql的网上商城系统，说明的网站[运行说明](http://blog.csdn.net/qq_31726419/article/details/79492608)
****
	
|Author|浪的飞起|
|---|---
|E-mail|zhng1456@163.com


****

##FAQ

mysql设置为端口3308,用户名root,密码mysql
前台入口:http://localhost:8080/sheji_3/InitController/initIndex.do

后台入口:http://localhost:8080/sheji_3/admin/index.jsp

访问出错如下:**请将jdk1.8更换为jdk1.6!**

Context initialization failed
java.lang.IllegalArgumentException
	at org.springframework.asm.ClassReader.<init>(Unknown Source)
	at org.springframework.asm.ClassReader.<init>(Unknown Source)
	at org.springframework.asm.ClassReader.<init>(Unknown Source)
	at org.springframework.core.type.classreading.SimpleMetadataReader.<init>(SimpleMetadataReader.java:52)
	at org.springframework.core.type.classreading.SimpleMetadataReaderFactory.getMetadataReader(SimpleMetadataReaderFactory.java:80)
    ...............