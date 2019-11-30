package com.PasswordManager;

public class Encryptor {

    //BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

    public Encryptor() {
        //textEncryptor.setPassword("Jack");
        return;
    }

//    public String encryptPassword(String passwordToEncrypt) {
//        String encryptedPassword = textEncryptor.encrypt(passwordToEncrypt);
//        return encryptedPassword;
//    }
//
//    public String decryptHash(String hashtoDecrpyt) {
//        String decryptedPassword = textEncryptor.decrypt(hashtoDecrpyt);
//        return decryptedPassword;
//    }

    public static String encrypt(String strClearText,String strKey) throws Exception{
        String strData="";

//        try {
//            SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
//            Cipher cipher=Cipher.getInstance("Blowfish");
//            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
//            byte[] encrypted=cipher.doFinal(strClearText.getBytes());
//            strData=new String(encrypted);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception(e);
//        }
        return strClearText;
    }

    public static String decrypt(String strEncrypted,String strKey) throws Exception{
        String strData="";

//        try {
//            SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
//            Cipher cipher=Cipher.getInstance("Blowfish");
//            cipher.init(Cipher.DECRYPT_MODE, skeyspec);
//            byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
//            strData=new String(decrypted);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception(e);
//        }
        return strEncrypted;
    }

}
