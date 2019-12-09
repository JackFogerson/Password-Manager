package com.PasswordManager;

import org.jasypt.util.text.BasicTextEncryptor;


/**
 * @title	Encryptor
 * @author 	Nick Fulton, Jack Fogerson, Jack Gisel
 * @desc	Encrypts passwords
 */
public class Encryptor {
    public Encryptor() {
    }

    // Encrypt method taking the HASH String and the Password
    public String encrypt(String strToBeEncrypted, String key) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(key);
        String myEncryptedText = textEncryptor.encrypt(strToBeEncrypted);
        return myEncryptedText;
    }
    // Encrypt method taking the HASH String and the HASHED Password
    public String decrypt(String strToBeDecrypted, String key) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(key);
        String password = textEncryptor.decrypt(strToBeDecrypted);
        return password;
    }
}
