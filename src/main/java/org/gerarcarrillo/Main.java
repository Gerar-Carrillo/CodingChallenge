package org.gerarcarrillo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how

            String originalString = "";

            EncriptionTool aesEncryptionDecryption = new EncriptionTool();
            String encryptedString = aesEncryptionDecryption.encrypt(originalString);
            String decryptedString = aesEncryptionDecryption.decrypt(encryptedString);

            System.out.println(originalString);
            System.out.println(encryptedString);
            System.out.println(decryptedString);
        }
        }

