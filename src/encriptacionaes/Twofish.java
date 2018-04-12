
package encriptacionaes;

import javax.crypto.spec.*;
import java.security.*;
import javax.crypto.*;
//import iaik.security.cipher.Twofish;
import iaik.security.provider.IAIK;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
  
public  class Twofish       
{
    public static void main(String []args){
        try {
            System.out.println(encrypt("ni idea", "algo"));
        } catch (Exception e) {
        }
        
    }
   public static String encrypt(String str,String code) throws NoSuchProviderException {
       String ot="";
            try {
                // generate key
                KeyGenerator keyGen = KeyGenerator.getInstance("Twofish", "ECB");
                SecretKey secretKey = keyGen.generateKey();
                // get Cipher and init it for encryption
                Cipher cipher = Cipher.getInstance("Twofish/CBC/PKCS5Padding", "IAIK");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte data[]=str.getBytes();
                // encrypt data
                byte[] cipherText = cipher.doFinal(data);
                // get the initialization vector from the cipher
                byte[] ivBytes = cipher.getIV();
                IvParameterSpec iv = new IvParameterSpec(ivBytes);
     
                // raw key material (usually the key will be securely stored/transmitted)
                byte[] keyBytes = secretKey.getEncoded();
                // create a SecretKeySpec from key material
                SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "Twofish");
                // get Cipher and init it for encryption
                cipher = Cipher.getInstance("Twofish/CBC/PKCS5Padding", "IAIK");
                cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
                byte[] plainText = cipher.doFinal(cipherText);
                ot = new String(plainText);
		System.out.println("Decrypted Text : "+ot);
 
            }
            catch(Exception e){
                System.out.println(e);
            }
 
            return ot;
                
        }
     static public byte[] encrypt(byte[] hashedKey, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchProviderException,
            InvalidKeyException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, IOException {

        Cipher cipher = Cipher.getInstance("Twofish/ECB/PKCS5Padding", "IAIK");
        SecretKeySpec secretKeySpec = new SecretKeySpec(hashedKey,"TWOFISH");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] outPut = cipher.doFinal(privateKey.getEncoded());
        return outPut;
    }

    static public byte[] decrypt(byte[] privateKey, byte[] hashedPW) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        SecretKeySpec secretKeySpec = new SecretKeySpec(hashedPW,"TWOFISH");
        Cipher cipher = Cipher.getInstance("Twofish/ECB/PKCS5Padding", "IAIK");
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
        byte[] outPut = cipher.doFinal(privateKey);
        return  outPut;
    }
       
}