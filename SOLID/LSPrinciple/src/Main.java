import wrongWay.service.BankingService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome To LSPrinciple!");

        BankingService bankingService = new BankingService();

        String result = bankingService.goodRequestwithdraw();
        System.out.println("goodRequestwithdraw is " + result);
        bankingService.badRequestwithdraw();
    }
}