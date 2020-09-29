import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    public static void main(String[] args) {

        String base = "rbtjr0614!";

        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            System.out.println(hexString);

        } catch(Exception ex){
            throw new RuntimeException(ex);
        }

    }



}