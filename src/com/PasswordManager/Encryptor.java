package com.PasswordManager;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @title	Encryptor.java
 * @author 	Jack Fogerson, Jack Gisel, Nick Fulton
 * @desc	Encryptor class to handle encryption of passwords
 */

public class Encryptor {
	
	//constructor
    public Encryptor() {
    }

    // Encrypt method taking the HASH String and the Password
    public String encrypt(String toBeEncrypted, String key){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(key);
        String myEncryptedText = textEncryptor.encrypt(toBeEncrypted);
        return myEncryptedText;
    }
    
    // Encrypt method taking the HASH String and the HASHED Password
    public String decrypt(String toBeDecrypted, String key){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(key);
        String password = textEncryptor.decrypt(toBeDecrypted);
        return password;
    }
}
