import java.util.Scanner;

class Conversation implements Chatbot {

  // Attributes 
  int numrounds;
  String inputString;

  /**
   * Constructor 
   */
  public Conversation() {

  }


  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {

    // Print welcome and ask for the number of rounds
    System.out.println("Welcome to Java Conversation");
    System.out.println("How many rounds?");
    
    //get number of rounds
    Scanner input = new Scanner(System.in);
    int numrounds = input.nextInt();
    System.out.println(numrounds);
    System.out.println("Hi there! What's on your mind?");

    //start the conversation
    for (int i = 0; i < numrounds; i++) {
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

  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = inputString; 
    if (inputString.contains(".")) {
      returnString =  inputString.replace(".", "?");
    }
    if (inputString.contains("I am")) {
      returnString =  inputString.replace("I am", "Are you");
    } if (inputString.contains("I")) {
      returnString =  inputString.replace("I", "you");
    }
    if (inputString.contains("me")) {
      returnString =  inputString.replace("me", "you");
    }
    if (inputString.contains("am")) {
      returnString =  inputString.replace("am", "are");
    }
    if (inputString.contains("you")) {
      returnString =  inputString.replace("you", "I");
    }
    if (inputString.contains("my")) {
      returnString =  inputString.replace("my", "your");
    }
    if (inputString.contains("your")) {
      returnString =  inputString.replace("your", "my");
    }
    if (!(inputString.contains("I") || inputString.contains("me") || 
      inputString.contains("am") || inputString.contains("you") || 
      inputString.contains("my") || inputString.contains("your"))) {
      returnString = "Mmm-hm.";
    return returnString;
    }
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}