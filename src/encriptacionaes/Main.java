/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptacionaes;

/**
 *
 * @author Renzo
 */
public class Main {

    public static void main(String[] args) {
        UIinicial p = new UIinicial();
        p.setVisible(true);
        
        AESenc aes = new AESenc();
        try {
            System.out.println(aes.encrypt("Texo"));
        } catch (Exception e) {
        }
        
        try {
            System.out.println(aes.decrypt("X1k3u2WyvsptNX6bILG7FA=="));
        } catch (Exception e) {
        }
        
    }
    
}
