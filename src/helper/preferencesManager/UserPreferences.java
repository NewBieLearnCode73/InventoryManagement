/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper.preferencesManager;
import java.util.prefs.Preferences;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.GeneralSecurityException;

/**
 *
 * @author GXA
 */
public class UserPreferences {

    private static final String PREF_NODE = "com/myapp/user";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String SECRET_KEY = "mySecretKey12345"; // 16-byte key for AES

    private Preferences prefs;

    public UserPreferences() {
        prefs = Preferences.userRoot().node(PREF_NODE);
    }

    public void saveLogin(String username, String password) throws GeneralSecurityException {
        prefs.put(USERNAME_KEY, username);
        prefs.put(PASSWORD_KEY, encrypt(password));
    }

    public String[] loadLogin() throws GeneralSecurityException {
        String username = prefs.get(USERNAME_KEY, null);
        String encryptedPassword = prefs.get(PASSWORD_KEY, null);
        if (username != null && encryptedPassword != null) {
            return new String[]{username, decrypt(encryptedPassword)};
        }
        return null;
    }

    private String encrypt(String data) throws GeneralSecurityException {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private String decrypt(String encryptedData) throws GeneralSecurityException {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }

}
