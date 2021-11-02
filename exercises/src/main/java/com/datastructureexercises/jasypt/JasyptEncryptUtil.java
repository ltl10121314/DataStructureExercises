package com.datastructureexercises.jasypt;

import org.jasypt.util.text.BasicTextEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liutianlong
 */
public class JasyptEncryptUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JasyptEncryptUtil.class);

    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)，注意要与 配置文件中设置jasypt.encryptor.password相同
        String salt = "bonc_dig";
        //需要加密的数据
        String data = "password";
        textEncryptor.setPassword(salt);
        //加密数据
        String value = textEncryptor.encrypt(data);
        //加密的结果直接放入 application.yml中，注意加密后的数据要用按照 ENC(valaue) 的样式
        LOGGER.info("加密结果：" + value);
        //解密数据
//        String value_s = textEncryptor.decrypt("heheh");
//        System.out.println(value_s);
//        JSONArray jsonArray = new JSONArray();

    }
}
