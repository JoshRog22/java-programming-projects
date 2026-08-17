/**
 * @author Joshua Rogers
 * Implements a shift cipher using a numeric rotation key.
 */
public class ShiftCipher extends SubstitutionCipher 
{
    private int key;

    /**
     * Constructor for ShiftCipher class
     * @param initialKey an integer between 0 and 25 to be used as the cipher
     * key
     */
    public ShiftCipher(int initialKey) 
    {
        this.key = initialKey;
    }

    //resets the state of the cipher by doin nothing as ther is no state
    @Override
    public void reset() {}

    /**
    * Encrypts a single plaintext character by performing an alphabetic
    * rotation using the key.
    * @param plainChar the plaintext character to encrypt
    * @return the encrypted character     
    */   
    @Override
    public char encryptChar(char plainChar) 
    {
        return shiftChar(plainChar, this.key);
    }

    /**
    * Decrypts a single ciphertext character by performing an alphabetic rotation
    * using the inverse of the key.
    * @param cipherChar the ciphertext character to decrypt
    * @return the decrypted character     
    */
    @Override
    public char decryptChar(char cipherChar) 
    {
        return shiftChar(cipherChar, 26 - this.key);
    }
}
