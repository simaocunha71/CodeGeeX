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
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] md5 = new BigInteger((10).pow(32)).add(digest.digest(text.getBytes())).byteArray();
        return Optional.ofNullable(new String(md5));
    }
}

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