/**
 * @author Joshua Rogers
 * Console-based encryption and decryption program supporting
 * shift and Vigenere cipher algorithms.
 */
public class CipherProgram 
{
    /**
     * @param args the command line arguments
     */   
    public static void main(String[] args) 
    {
       
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to Josh Rogers's cipher program!");
        
        while (true) 
        {
            System.out.print("Do you want to [E]ncrypt or [D]ecrypt? ");
            char action = keyboard.next().charAt(0);
            keyboard.nextLine();
            
            System.out.print("Do you want to use a [S]hift cipher or a [V]igenere cipher? ");
            char cipherType = keyboard.next().charAt(0);
            keyboard.nextLine();

            Cipher cipher;
            if (cipherType == 'S' || cipherType == 's') 
            {
                System.out.print("Please enter a number between 0 and 25 to use as a key: ");
                int key = keyboard.nextInt();
                keyboard.nextLine();
                cipher = new ShiftCipher(key);
            } 
                else 
                {
                    System.out.print("Please enter a keyword: ");
                    String keyword = keyboard.nextLine();
                    cipher = new VigenereCipher(keyword);
                }

            System.out.print(action == 'E' || action == 'e' ? "Please enter the plaintext to be encrypted: "
                    : "Please enter the ciphertext to be decrypted: ");
            String text = keyboard.nextLine();
            
            String result = (action == 'E' || action == 'e') ? cipher.encrypt(text) : cipher.decrypt(text);
            System.out.println("The corresponding text is: " + result);
            
            System.out.print("Do you want to continue (Y/N)? ");
            char cont = keyboard.next().charAt(0);
            //scanner.nextLine();
            System.out.println();
            if (cont == 'N' || cont == 'n')
                break;
        }

        System.out.println("Thank you for using Josh Rogers's cipher program.");
    }
}
