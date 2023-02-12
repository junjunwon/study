public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        KakaoPay kakaoPay = new KakaoPay();
        SamsungPay samsungPay = new SamsungPay();
        NaverPay naverPay = new NaverPay();
        System.out.println(kakaoPay.getPayment());
        System.out.println(samsungPay.getPayment());
        System.out.println(naverPay.getPayment());

    }
}