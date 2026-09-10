import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] Menu = {"Ramen", "Sandwich", "Kimbap", "Pasta", "Water", "Soda"};
        double[] Prices = {110.00, 40.00, 99.00, 75.00, 20.00, 30.00};

        int totalQuantity = 0;
        double totalAmountbeforeDeductions = 0.0;

        char studentInput;
        while (true) {
            System.out.print("Are you a student? (Y/N): ");
            studentInput = input.next().charAt(0);
            
            if (studentInput == 'Y' || studentInput == 'y' || studentInput == 'N' || studentInput == 'n') {
                break;
            } else {
                System.out.println("Invalid input! Please enter Y/N only.");
            }
        }
        
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n---------- MENU ----------");
            for (int i =0; i < Menu.length; i++) {
                System.out.printf("%d. %-12s - $%.2f%n", (i +1), Menu[i], Prices[i]);
            }
            System.out.println();

            System.out.print("Enter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            if (itemNumber <1 || itemNumber > Menu.length || quantity < 1 || quantity > 10) {
                System.out.println("Invalid order! Please enter valid item and quantity.");
            } else {
                double itemPrice = Prices[itemNumber - 1];
                double itemSubtotal =  itemPrice * quantity;

                totalQuantity += quantity;
                totalAmountbeforeDeductions += itemSubtotal;

                System.out.printf("Subtotal: $%.2f%n", itemSubtotal);
            }
            System.out.print("\nDo you want to order again? (Y/N): ");
            char continueInput = input.next().charAt(0);

            if (continueInput == 'N' || continueInput == 'n') {
                ordering = false;
            }
        }
        double discountRate = 0.0;

        if ((studentInput == 'Y' || studentInput == 'y') && totalAmountbeforeDeductions >= 500.00) {
            discountRate = 0.15;
        } else if (studentInput == 'Y' || studentInput == 'y') {
            discountRate = 0.10;
        } else if (totalAmountbeforeDeductions >= 500.00) {
            discountRate = 0.05;
        }
        double totalDeduction = totalAmountbeforeDeductions * discountRate;
        double finalAmount = totalAmountbeforeDeductions - totalDeduction;

        System.out.println("============================================");
        System.out.println("              Official Receipt              ");
        System.out.println("============================================");
        System.out.printf("Total quantity of items purchased: %d%n", totalQuantity);
        System.out.printf("Total amount before discounts:     $%.2f%n", totalAmountbeforeDeductions);
        System.out.printf("Total discount:                    $%.2f%n", totalDeduction);
        System.out.printf("Final amount to pay:               $%.2f%n", finalAmount);
        System.out.println("============================================");

        input.close();
    }

}
