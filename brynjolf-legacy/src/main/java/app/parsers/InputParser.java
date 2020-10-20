package app.parsers;

import java.util.Scanner;

public class InputParser {

    public String getInput() {
        System.out.println("Enter the move sequence");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
