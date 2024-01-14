import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static double calculateMortgage(
        int principal,
        float annualInterest,
        byte years
    ){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal * (
                (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1)
        );

        return mortgage;
    }
    public static LoanDetails getInputs(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal (1K - 1M): ");
        int principal = scanner.nextInt();

        while (principal < 1000 || principal > 1_000_000){
            System.out.println("Enter a number between 1,000 and 1,000,000");
            System.out.print("Principal (1K - 1M): ");
            principal = scanner.nextInt();
        }

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();

        while(annualInterest < 0 || annualInterest > 30){
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
        }

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        while(years < 0 || years > 30){
            System.out.println("Enter a value between 1 and 30");
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
        }

        return new LoanDetails(principal, annualInterest, years);
    }
    public static void main(String[] args) {
        LoanDetails loanDetails = getInputs();
        double mortgage = calculateMortgage(
                loanDetails.getPrincipal(),
                loanDetails.getAnnualInterest(),
                loanDetails.getYears()
        );

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String formatedMortgage = currency.format(mortgage);

        System.out.println(formatedMortgage);
    }
}