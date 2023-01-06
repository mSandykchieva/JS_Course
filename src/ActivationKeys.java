import java.util.Locale;
import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Generate")){
            String [] commandLine = command.split(">>>");
            String currentCommand = commandLine[0];
            switch (currentCommand){
                case "Contains":
                    String givenSubstring = commandLine[1];
                    if(activationKey.contains(givenSubstring)){
                        System.out.printf("%s contains %s",activationKey,givenSubstring);
                    }else{
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(commandLine[2]);
                    int endIndex= Integer.parseInt(commandLine[3]);
                    String upperOrLower = commandLine[1];
                    if(upperOrLower.equals("Upper")){
                        activationKey=activationKey.replace(activationKey.substring(startIndex,endIndex),activationKey.substring(startIndex,endIndex).toUpperCase());
                    }else{
                        activationKey=activationKey.replace(activationKey.substring(startIndex,endIndex),activationKey.substring(startIndex,endIndex).toLowerCase());
                    }
                    System.out.println(activationKey);
                    break;
                case"Slice":
                    startIndex = Integer.parseInt(commandLine[1]);
                    endIndex= Integer.parseInt(commandLine[2]);
                    activationKey=activationKey.replace(activationKey.substring(startIndex,endIndex),"");
                    break;
            }
            command= scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", activationKey);
    }
}

