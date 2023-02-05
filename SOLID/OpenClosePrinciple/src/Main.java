import controller.PayController;
import request.PayRequest;

public class Main {
    public static void main(String[] args) throws Exception {
        PayRequest request = new PayRequest("transfer");
        PayController controller = new PayController();
        String result = controller.payControl(request);

        System.out.println("result is " + result);
    }
}