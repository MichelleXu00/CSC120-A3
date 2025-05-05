import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Conversation implements Chatbot {

  // Attributes 
  int numRounds;
  String inputString;
  String response;
  String randomResponse;
  String [] words;
  ArrayList<String> transcript;
  String intro;
  /**
   * Constructor 
   */
  public Conversation() {
    this.transcript = new ArrayList<String> ();
  }


  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {

    // Print welcome and ask for the number of rounds
    intro = "Welcome to Java Conversation!\nHow many rounds?";
    System.out.println(intro);

    
    //get number of rounds
    Scanner input = new Scanner(System.in);
    int numRounds = input.nextInt();
    input.nextLine();
    System.out.println("Hi there! What's on your mind?");
    
    //start the conversation
    for (int i = 0; i < numRounds; i++) {
      String inputString = input.nextLine();
      System.out.println(respond(inputString));
    }

    System.out.println("See ya!");
    input.close();
    }
    


  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    transcript.add(intro);
    transcript.add(Integer.toString(numRounds));
    transcript.add(inputString);
    transcript.add(respond(inputString));
    for (String line:transcript) {
      System.out.println(line);
    }
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    if (inputString == null) {
      throw new RuntimeException("inputString is null -- no response generated");
    }
    ArrayList<String> rResponse = new ArrayList<>();
    rResponse.add("Mmm-hm");
    rResponse.add("I don't know");
    rResponse.add("Nice to hear that");
    rResponse.add("Sounds good");
    int randint = new Random().nextInt(rResponse.size());
    randomResponse = rResponse.get(randint);
    words = inputString.split(" ");
    response = "";
    boolean hasMirror = false;
    for (String w:words) {
      if (w.equals("I")) {
        response +=" " + "you";
        hasMirror = true;
      } else if (w.equals(".")) {
        response +=" " + "?";
        hasMirror = true;
      } else if (w.equals("me")) {
        response +=" " + "you";
        hasMirror = true;
      } else if (w.equals("am")) {
        response +=" " + "are";
        hasMirror = true;
      } else if (w.equals("you")) {
        response +=" " + "I";
        hasMirror = true;
      } else if (w.equals("my")) {
        response +=" " + "your";
        hasMirror = true;
      } else if (w.equals("your")) {
        response +=" " + "my";
        hasMirror = true;
      } else {
        response += " " + w.replace(".","?");
      }
    } if (!hasMirror) {
      transcript.add(randomResponse);
      return randomResponse;
    } transcript.add(response);
    return response.strip();
  }
  

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
  }
}