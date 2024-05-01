import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hash {
    public static void main(String[] args)throws Exception {
        String password = "incendio"; // Password to hash
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);

        String pass = "incendio";
        MessageDigest hashpass = MessageDigest.getInstance("SHA-256");
        hashpass.update(pass.getBytes());
        byte[] hashvalue = hashpass.digest();
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<hashvalue.length;i++){
            res.append(Integer.toHexString(0xFF & hashvalue[i]));
        }
        System.out.println(res);

    }

    private static String hashPassword(String password) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // Calculate the hash value of the password
            byte[] hashedBytes = md.digest(password.getBytes());
            // Convert the byte array to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
