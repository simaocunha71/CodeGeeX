import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string "text", return its md5 hash equivalent string with length being 32.
    If "text" is an empty string, return Optional.empty().
    
    >>> stringToMd5("Hello world") == "3e25960a79dbc69b674cd4ec67a72c62"
     */
    public Optional<String> stringToMd5(String text) throws NoSuchAlgorithmException {
        if (text.isEmpty()) return Optional.empty();
        
        try(Key key = KeyGenerator.getInstance("MD5WithRSA").generateKey(BigInteger.valueOf(-1L),
                new SecureRandom());
             SecretKey skey = (SecretKey) key.getEncoded()[0]) { 
            byte[] textData;
            try (DataOutputStream dos = new DataOutputStream()) {
                dos.writeUTF("text");
            } catch (IOException e) {}
            textData = dosToByteArray(dos);
            
            try (DataInputStream dis = new DataInputStream(new ByteArrayInputStream(textData))) { 
                byte[] salt = disToByteArray(dis);
                
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] hashedText = md.digest(salt, textData);
                return String.format("%032x", new BigInteger(1, hashedText));
            } catch (IOException e) {}
        }  
    }
    private static byte[] dosToByteArray(DataInputStream dis) throws IOException {
        try (InputStream in = new ByteArrayInputStream((byte[])dis.readFully())) { //(byte[])dis.read() is a stream, while ByteArrayInputStream is the constructor of InputStream that doesn't take any argument
            return inToByteArray(in);
        } catch (IOException e) {}
        
        throw new IOException("Exception when trying to convert dis to a byte array"); //e has been caught by now
    }
    private static byte[] inToByteArray

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.stringToMd5("Hello world").get().equals("3e25960a79dbc69b674cd4ec67a72c62"),
                s.stringToMd5("").isEmpty(),
                s.stringToMd5("A B C").get().equals("0ef78513b0cb8cef12743f5aeb35f888"),
                s.stringToMd5("password").get().equals("5f4dcc3b5aa765d61d8327deb882cf99")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}