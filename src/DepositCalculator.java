import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate/ 12), 12 * depositPeriod);
        return roundPercentage(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundPercentage(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundPercentage(double percent, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(percent * ScaLe) / ScaLe;
    }

    void printMenu() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outcome = 0;
        if (action == 1) {
            outcome = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outcome = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outcome);
    }

    public static void main(String[] args) {
       DepositCalculator depositCalculator =  new DepositCalculator();
           depositCalculator.printMenu();
    }
}
