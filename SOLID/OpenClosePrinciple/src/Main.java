import controller.PayController;
import request.PayRequest;

public class Main {
    public static void main(String[] args) throws Exception {
        PayRequest request = new PayRequest("transfer");
        PayController controller = new PayController();
        String result = controller.payControl(request);

        System.out.println("result is " + result);
    }

    Collection<Object> foodMakers = applicaitionContext.getBeans~~(.class).values
    해시맵에 담아서 매번 꺼내쓰는 방식.

    for(FoodMaker foodMaker : foodMakers ) {
        if(foodMakermap.put(foodMaker.getMenu(), foodMaker) != null) {
            throw new IllegalAccessException()
        }
    }
}