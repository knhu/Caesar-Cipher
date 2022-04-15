/**
* This program will encode a piece of text using a similar method of a
* Caesar Cipher
* This includes moving the ltters to a different leter specified by the
* user in a specific loop, and then the user will input a message to be
* encoded
* The program will encode the message, print it out, then print out the
* original message (decoded)
*
* Authors: Matthew Gloriani and Kevin Nhu
*
* Project #1
*
* Date Last Modified: February 18, 2021
*
*/
// import all needed utilities
import java.util.*;
public class proj1{
  public static void main(String[] args){
    // infinite loop that runs system until user says not to run anymore
    while(true){
      cipher(args);
      Scanner input = new Scanner(System.in);
      System.out.print("Do you want to run the program again (y for yes and n for no)?: ");

      String decision = input.nextLine();
      System.out.println();
      if (decision.charAt(0) == 'n'){
          return; // exits out of the class

      }
   }
}
  public static void cipher(String[] args){
    // Reading user input&#39;s numbers
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter the individual key values (positive or negative ";
      + "integers, one after another in the same line with a 
      + "blank between two values): ");

    String line = kb.nextLine();
    System.out.println();
    System.out.println("Enter a string to be encoded: ");
    String message = kb.nextLine();
    System.out.println();
    // splitting the message string into individual characters
    // then turns them into ASCII values (32-126)
    char charTokens[] = new char[message.length()];
    charTokens = message.toCharArray();
    int intTokens[] = new int[message.length()];
    for(int i = 0; i &lt; message.length(); i++){
    intTokens[i] = (int) charTokens[i];
    }
    // separating the numbers from each other in the string and
    // making them into integers
    String[] stringNumbers = line.split(" ");
    int numbers[] = new int[stringNumbers.length];
    int compare[] = new int[stringNumbers.length];
    // Checks to see if the user&#39;s inputs are valid
    try{
      for(int i = 0; i < stringNumbers.length; i++){
        compare[i] = Integer.parseInt(stringNumbers[i]);
      }
    }
    // Handles exception if invalid inputs are entered
    catch(NumberFormatException e) {
      System.out.println("Invalid key values. Please input ints only for the first line.");
      cipher(args);
      return;
    }
    // if the user's input is valid, will use the numbers array to do the
    // math
    for (int i = 0; i &lt; stringNumbers.length; i++) {
      numbers[i] = Integer.parseInt(stringNumbers[i]);
    }
    // encoding the message string
    int encoded[] = new int[message.length()];
    int counter = 0; // Counter needed to go through the numbers
    for (int i = 0; i < message.length(); i++){
      if(counter == stringNumbers.length){
        counter = 0; // the wrap around for the numbers[]
      }
      // adding because we are encoding
      encoded[i] = intTokens[i] + numbers[counter];
      if (encoded[i] < 32){
        encoded[i] += 95;
      }
      else if (encoded[i] > 126){
        encoded[i] -= 95;
      }
      counter++;
  }
  char charEncoded[] = new char[message.length()];
  System.out.println(&quot;The encoded message:&quot;);
  for (int k = 0; k < encoded.length; k++){
    charEncoded[k] = (char)encoded[k];
    System.out.print(charEncoded[k]);
  }
  System.out.println("\n");

  // decoding the encoded message string
  int intDecoded[] = new int[message.length()];
  counter = 0;
  for (int i = 0; i < message.length(); i++) {
    if(counter == stringNumbers.length){
      counter = 0;
    }
    // subtracting because we are decoding
    intDecoded[i] = encoded[i] - numbers[counter];
    if (intDecoded[i] < 32){
      intDecoded[i] += 95;
    }
    else if (intDecoded[i] &gt; 126){
      intDecoded[i] -= 95;
    }
    counter++;
  }
  char charDecoded[] = new char[message.length()];
  System.out.println(&quot;The decoded message:&quot;);
  for (int l = 0; l < intDecoded.length; l++){
    charDecoded[l] = (char)intDecoded[l];
    System.out.print(charDecoded[l]);
  }
  System.out.println("\n");
  }
}
