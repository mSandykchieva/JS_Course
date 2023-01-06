import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        String command = scanner.nextLine();
        while(!command.equals("Done")){
            String [] commandLine = command.split(" ");
            String task = commandLine[0];
            switch (task){
                case "TakeOdd":
                    String newPassword="";
                    for (int i = 1; i < password.length()-1; i+=2) {
                        newPassword+=password.charAt(i);
                    }
                    password=newPassword;
                    System.out.println(password);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(commandLine[1]);
                    int lengthToCut=Integer.parseInt(commandLine[2]);
                    String toReplace = password.substring(startIndex,startIndex+lengthToCut);
                    password=password.replaceAll(toReplace,"");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String target = commandLine[1];
                    String replacement = commandLine[2];

                    if(password.contains(target)){
                        password=password.replace(target,replacement);
                        System.out.println(password);
                    }else{
                        System.out.println("Nothing to replace!");
                    }

                    break;
            }
            command= scanner.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}
