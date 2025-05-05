import java.util.Scanner;

public class NumberGame {

    private int num;

    public NumberGame(int n){
        num = n;
    }

    public void play() {
        while (num > 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            System.out.print(num + ", ");
        }
        System.out.println("and done!");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = 10;
        try {
            n = input.nextInt();
        } catch (Exception e) {
            System.out.println("Sorry, I didn't understand that.");
            System.out.println("Using default value 10.");
        }
        NumberGame myGame = new NumberGame(n);
        myGame.play();
        input.close();
    }
}