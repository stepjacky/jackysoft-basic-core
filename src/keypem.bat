keytool -genkeypair -keysize 1024 -alias herong_key -keypass keypass -keystore herong.jks -storepass jkspass
keytool -exportcert -alias herong_key -keypass keypass -keystore herong.jks -storepass jkspass -file keytool_crt.der
keytool -exportcert -alias herong_key -keypass keypass -keystore herong.jks -storepass jkspass -rfc -file keytool_crt.pem



