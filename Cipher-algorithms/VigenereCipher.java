/**
 * @author Joshua Rogers
 * Implements a Vigener cipher using a repeating keyword.
 */
public class VigenereCipher extends SubstitutionCipher
{
    private String keyword;
    private int kwPos;

    /**
     * Constructor that will allow a keyword to be accepted
     * @param initialKeyword
     */
    public VigenereCipher(String initialKeyword) 
    {
        this.keyword = initialKeyword;
        this.kwPos = 0;
    }

    //reset the state of the cipher by setting the keyword position to zero
    @Override
    public void reset() 
    {
        kwPos = 0;
    }

    /**
     * Encrypts a single plaintext character by performing an alphabetic rotation
     * using the appropriate keyword character
     * @param plainChar the plaintext character to encrypt
     * @return the encrypted character
     */
    @Override
    public char encryptChar(char plainChar) 
    {
        char keyChar = keyword.charAt(kwPos);
        if (alphabetic(plainChar)) 
        {
            kwPos = (kwPos + 1) % keyword.length();
        }
        int keyNum = getKeyNum(keyChar);
        return keyNum >= 0 ? shiftChar(plainChar, keyNum) : plainChar;
    }

    /**
     * Decrypts a single ciphertext character by performing an alphabetic rotation
     * using the inverse of the appropriate keyword character
     * @param cipherChar the ciphertext character to decrypt
     * @return the decrypted character
     */
    @Override
    public char decryptChar(char cipherChar) 
    {
        char keyChar = keyword.charAt(kwPos);
        if (alphabetic(cipherChar)) 
        {
            kwPos = (kwPos + 1) % keyword.length();
        }
        int keyNum = getKeyNum(keyChar);
        return keyNum >= 0 ? shiftChar(cipherChar, 26 - keyNum) : cipherChar;
    }
}
