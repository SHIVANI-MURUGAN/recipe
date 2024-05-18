import java.util.Scanner;
public class AuthenticationSystem {
 public static void main(String[] args) {
 Scanner inputScanner = new Scanner(System.in);
 System.out.println("Enter the message: ");
 String plaintext = inputScanner.next();
 String encryptedText1 = caesarEncrypt(plaintext);
 System.out.println("Caesar Encryption: " + encryptedText1);
 System.out.println("Enter the encryption key: ");
 String encryptionKey = inputScanner.next();
 String encryptedText2 = xorEncryption(encryptedText1, encryptionKey);
 System.out.println("XOR Encryption: " + encryptedText2);
 String decryptedText1 = xorDecryption(encryptedText2, encryptionKey);
 System.out.println("XOR Decryption: " + decryptedText1);
 String decryptedText2 = caesarDecrypt(decryptedText1);
 System.out.println("Decrypted Message: " + decryptedText2);
 }
 private static String caesarDecrypt(String encrypted) {
 int shift = 3; // Caesar shift value
 String decryptedText = "";
 for (int i = 0; i < encrypted.length(); i++) {
 char character = encrypted.charAt(i);

 int asciiValue = (int) character;
 if (Character.isUpperCase(character)) {
 decryptedText += (char) (((asciiValue - shift - 65 + 26) % 26) + 65);
 } else if (Character.isLowerCase(character)) {
 decryptedText += (char) (((asciiValue - shift - 97 + 26) % 26) + 97);
 } else {
 decryptedText += character;
 }
 }
 return decryptedText;
 }
 private static String xorEncryption(String text, String key) {
 String encryptedText = "";
 for (int i = 0, j = 0; i < text.length(); i++, j++) {
 char textChar = text.charAt(i);
 char keyChar = key.charAt(j % key.length());
 int xorResult = performXOR((int) textChar, (int) keyChar);
 encryptedText += (char) xorResult;
 }
 return encryptedText;
 }
 private static String caesarEncrypt(String text) {
 int shift = 3; // Caesar shift value
 String encryptedText = "";
 for (int i = 0; i < text.length(); i++) {
 char character = text.charAt(i);
 int asciiValue = (int) character;

 if (Character.isUpperCase(character)) {
 encryptedText += (char) (((asciiValue + shift - 65) % 26) + 65);
 } else if (Character.isLowerCase(character)) {
 encryptedText += (char) (((asciiValue + shift - 97) % 26) + 97);
 } else {
 encryptedText += character;
 }
 }
 return encryptedText;
 }
 private static String xorDecryption(String encrypted, String key) {
 String decryptedText = "";
 for (int i = 0, j = 0; i < encrypted.length(); i++, j++) {
 char encryptedChar = encrypted.charAt(i);
 char keyChar = key.charAt(j % key.length());
 int xorResult = performXOR((int) encryptedChar, (int) keyChar);
 decryptedText += (char) xorResult;
 }
 return decryptedText;
 }
 public static int performXOR(int x, int y) {
 return x ^ y;
 }
}
