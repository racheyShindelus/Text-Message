/*
 Name:Rachel Shindelus
 Date: 10/31/2022
 Description:This program is able to encrypt and decrypt a given message using an inputed code
 Self grade:  I believe I should recieve 100% on this assignment as I have completed all the required aspects of the assignment and it compiles properly with the desired output. 
 */
import java.util.*;

public class  EncryptShindelusAttempt2   {/* NO CODE HERE */}  

class MessageDecryptEncrypt   {
   public static void main(String[] args) {
      getMessage();     // Calls method
   }  // End Main
//*************************************************************************************
   public static void getMessage( )  {
     Scanner ui = new Scanner(System.in);          // Creates a scanner object
     for (int i = 1; i <= 20; i++)  {              // Creates a for loop to display 20 times
      displayMenu();                               // Displays the menu
      char encryptOrDecrypt = ui.next().charAt(0); // Get users input of e / d and store in variable
      if (encryptOrDecrypt == 'e' || encryptOrDecrypt == 'E' || encryptOrDecrypt == 'd' || encryptOrDecrypt == 'D') {}   // Determine if user input is d, D, e, or E
      else  {                                      // Continue if input is invalid and get correct input
         System.out.println("Invalid Input");      
         boolean invalid = true;
         while (invalid == true) {
            System.out.println("Re-enter your input: ");
            encryptOrDecrypt = ui.next().charAt(0);
            if (encryptOrDecrypt == 'e' || encryptOrDecrypt == 'E' || encryptOrDecrypt == 'd' || encryptOrDecrypt == 'D')  
               invalid = false;
            }  // End while loop
      }  // End else statment
      System.out.print("Enter your message: ");    // Prompt user to enter a message
      ui.nextLine();                               // User input of message
      String enteredMessage = ui.nextLine();       // Store message as a variable
      System.out.print("Enter a key: ");           // Prompt user to enter a key
      int enteredKey = ui.nextInt();               // Store key as a variable
      while (!(enteredKey > 0))   {                // Make sure input is positive. If not, continue loop until proper input is given
         System.out.print("Invalid Input, re-enter your key: ");              
         enteredKey = ui.nextInt(); 
      }  // End While loop
      if (encryptOrDecrypt == 'e' ||encryptOrDecrypt == 'E')
         encryptMessage(enteredMessage, enteredKey);
      else
         decryptMessage(enteredMessage, enteredKey);
     }   // End for loop
   }  // End getMessage();
   
	/*Returns a new string with the letters of the given string shifted forward or backward by the amount equal to the given key. */
   public static String encryptMessage(String s, int key)    {        
   	s = s.toUpperCase();                      // Convert to uppercase
      String encryptedMessage = "";             // Variable to store encrypted message as a String
      for (int i = 0; i < s.length(); i++)   { // For loop for the length of the message s
         char letter = s.charAt(i);
         if (letter == ' ')
            letter = '#';
         else  {
           if (letter >= 'A' || letter <= 'Z')  {
            letter = (char)(letter + (char)key);
           }   // End of if
         }  // End of else
      encryptedMessage += letter;                  // Add the letter to the string encryptedMessage
      }  // End of for loop
      System.out.println(encryptedMessage);
      return encryptedMessage;                     // Return the encrypted message
   }  // End encryptMessage()
   
   /* decrypts the encrypted string using the same key value. */
   public static String decryptMessage(String s, int key)    {
      String decryptedMessage = "";             // Variable to store decrypted message as a String
      for (int i = 0; i < s.length(); i++)   {  // For loop for the length of the message s
         
         char letter = s.charAt(i);
         if (letter == '#')
            letter = ' ';
         else  {
           int ascii = (int)letter;                // New variable to hold ASCII value of the letter
           if (letter >= 'A' || letter <= 'Z')  {
               ascii = ascii - key;                // Subtract the key value from the ASCII value
               letter = (char)ascii;               // Convert the ASCII value back to a char in the letter variable
          }   // End of if
         }  // End of else
      decryptedMessage += letter;                  // Add the letter to the string decryptedMessage
      }  // End of for loop    
      System.out.println(decryptedMessage);       	
      return decryptedMessage;                  // Return decrypted message
   }  // End decryptMessage()
   
   /*This method displays a menu for the user to choose the option.*/
   public static void displayMenu()   {   // Prints the menu
   for (int i = 0; i < 52; i++)
      System.out.print("*");
   System.out.println(" ");
   System.out.println("Enter either \" E \" or  \" e \" to ENCRYPT the message: ");
   System.out.println("Enter either \" D \" or  \" d \" to DECRYPT the message: ");
   for (int i = 0; i < 52; i++)
      System.out.print("*");
   System.out.println(" ");
   }  // End displayMenu()
}  // End Class MessageDecryptEncrypt