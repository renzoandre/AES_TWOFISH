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
        
        byte[] keyValue = new byte[]{'e', 's', 't', 'a', 'e', 's', 'l', 'a', 'c', 'l', 'a', 'v', 'e', 'p', 'u', 'e'};
        AESenc aes = new AESenc(keyValue);
        try {
            System.out.println(aes.encrypt("Texo"));
        } catch (Exception e) {
        }
        
        try {
            System.out.println(aes.decrypt("NAZmmsEDJOmy3riDflL3otS0MtmdiFF2p3oK3XI6kP3Eaz5cAGAmB6Tbhnv7iTScHbJhZRQJNv8fuNVIRAskxIre3HghhImtOPxs0buIHyRaXSN6GdVveVNW9Dt8FIgwkjZw/dShMD0d/sW/WlEfPvsUpR25JiXi0lXY4eo3JIMtf0Omr2K0fmIaG6VcyfZq90xn/VZSfMEKrnwXodMGsjnD6oC1kQ1piqfIMzNyFRpc+T48Awh2IKDQ4km2iLICI0nwObEi9z1tmYZBEVHmztH75AnbEoav3ByTCoCOotlV5va7YmCb1vKn5UrKI3eVOxcMZE6fVfFrPLrzqa5QBWSb35QEPhjt5sdzN1FESfo="));
        } catch (Exception e) {
        }
        
    }
    
}
