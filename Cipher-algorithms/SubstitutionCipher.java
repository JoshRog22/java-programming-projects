/**
 * @author Joshua Rogers
 * Abstract base class providing shared subsitution-cipher
 * functionality for character shifting and text processing.
 */

//abstract class implementing Cipher interphace
public abstract class SubstitutionCipher implements Cipher
{
    /**
    * Encrypt a single character
    * @param plainChar the plaintext character to encrypt
    * @return the encrypted character
    */
    public abstract char encryptChar(char plainChar);
    
    /**
    * Decrypt a single character
    * @param cipherChar the ciphertext character to decrypt
    * @return the decrypted character
    */
    public abstract char decryptChar(char cipherChar);
    
    /**
    * Reset the state of the cipher
    */ 
    public abstract void reset();

    /**
    * Determine if a character is alphabetic
    * @param ch the character to test
    * @return true if the character is alphabetic and false otherwise.
    */  
    public static boolean alphabetic(char ch) 
    {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    /**
    * Translate a letter into its position in the alphabet
    * @param ch the character to translate
    * @return the translated character or -1 if the character is not a letter
    */
    public static int getKeyNum(char ch) 
    {
        if (ch >= 'A' && ch <= 'Z') return ch - 'A';
        if (ch >= 'a' && ch <= 'z') return ch - 'a';
        return -1;
    }

    /**
    * Perform a rotational alphabetic shift on a character by the given shift 
    * amount
    * @param ch the character to shift
    * @param key the amount to shift the character
    * @return the shifted character or the character unchanged if it is not
    * alphabetic
    */
    public static char shiftChar(char ch, int key) 
    {
        if (ch >= 'A' && ch <= 'Z') return (char) ((ch - 'A' + key) % 26 + 'A');
        if (ch >= 'a' && ch <= 'z') return (char) ((ch - 'a' + key) % 26 + 'a');
        return ch;
    }

    /** Encrypt the given plantext using encryptChar to encrypt each character
    * @param plaintext the plaintext to encrypt
    * @return the encrypted ciphertext
    */
    @Override
    public String encrypt(String plaintext) 
    {
        reset();
        StringBuilder ciphertext = new StringBuilder();
        for (char ch : plaintext.toCharArray()) 
        {
            ciphertext.append(encryptChar(ch));
        }
        
        return ciphertext.toString();
    }

    /** Decrypt the given ciphertext using decryptChar to decrypt each character
    * @param ciphertext the ciphertext to decrypt
    * @return the decrypted plaintext
    */
    @Override
    public String decrypt(String ciphertext) 
    {
        reset();
        StringBuilder plaintext = new StringBuilder();
        for (char ch : ciphertext.toCharArray()) 
        {
            plaintext.append(decryptChar(ch));
        }
        
        return plaintext.toString();
    }
}
