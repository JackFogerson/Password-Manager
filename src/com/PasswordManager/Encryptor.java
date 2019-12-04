package com.PasswordManager;

import org.jasypt.util.text.BasicTextEncryptor;

public class Encryptor {
    public Encryptor() {
    }

    public String encrypt(String strToBeEncrypted, String key) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(key);
        String myEncryptedText = textEncryptor.encrypt(strToBeEncrypted);
        return myEncryptedText;
    }

    public String decrypt(String strToBeDecrypted, String key) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(key);
        String password = textEncryptor.decrypt(strToBeDecrypted);
        return password;
    }
}
