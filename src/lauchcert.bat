cls 
echo %java_home%
rem please set the env JAVA_HOME before run this bat file 
rem delete alia tomcat if it is existed 
keytool -delete -alias mytomcat -keystore %JAVA_HOME%/jre/lib/security/cacerts -storepass changeit 
keytool -delete -alias mytomcat -storepass changeit 
rem list all alias in the cacerts 
rem keytool -list -keystore %JAVA_HOME%/jre/lib/security/cacerts -storepass changeit 
rem generator a key 默认生成的证书 在   user.dir/ .keystore 
keytool -genkey -keyalg RSA -alias mytomcat -dname "cn=test.qinghua.com" -validity 60 -storepass changeit
rem export the key 
keytool -export -alias mytomcat -file %JAVA_HOME%/jre/lib/security/mytomcat.crt -storepass changeit 
rem import into trust cacerts 
keytool -import -alias mytomcat -file %JAVA_HOME%/jre/lib/security/mytomcat.crt -keystore %java_home%/jre/lib/security/cacerts -storepass changeit 
rem list all alias in the cacerts 
keytool -list -keystore %JAVA_HOME%/jre/lib/security/cacerts -storepass changeit 
