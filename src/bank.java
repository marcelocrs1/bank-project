import java.util.Scanner;

public class bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "Marcelo Santos";
        String accountType = "Current Account";
        int agency = 1;
        int account = 5403;
        int digit = 8;
        double balance = 2000;
        double valueOfOperation;
        int option = 0;

        String clientDetails = """
                ----------------------------------------
                CUSTOMER DATA:
                Name: %s
                Account Type: %s
                Agency: %04d   Account number: %05d-%d
                Current balance: R$ %.2f
                ----------------------------------------"""
                .formatted(name, accountType, agency, account, digit, balance);

        String operations = """
                AVAILABLE OPERATIONS:
                [1] Balance
                [2] Deposit
                [3] Withdraw
                [4] Exit
                Type the action: """;

        System.out.println(clientDetails);

        while (option != 4) {
            System.out.println(operations);
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("ACCOUNT BALANCE");
                    System.out.println(String.format("The Balance is: %.2f. €",balance));
                    break;
                case 2:
                    System.out.println("DEPOSIT");
                    System.out.println("Amount to Deposit: ");
                    valueOfOperation = sc.nextDouble();
                    if (valueOfOperation > 0) {
                        balance += valueOfOperation;
                        System.out.println(String.format("Operation Successfully! New Balance is:  %.2f €", balance));
                    } else {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case 3:
                    System.out.println("WITHDRAW");
                    System.out.println("Amount to Withdraw: ");
                    valueOfOperation = sc.nextDouble();
                    if (valueOfOperation <= balance && valueOfOperation > 0) {
                        balance -= valueOfOperation;
                        System.out.println(String.format("Operation Successfully! New Balance is:  %.2f €",balance));
                    } else if (valueOfOperation <= 0) {
                        System.out.println("Invalid Operation!");
                    } else {
                        System.out.println("Not possible do this operation. Insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using our services. See you soon!");
                    break;
                default:
                    System.out.println("Enter a valid option!");
            }
        }
    }
}
