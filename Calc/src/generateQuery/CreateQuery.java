package generateQuery;

public class CreateQuery {

    static private StringBuilder sb = new StringBuilder();
    private ProductOption productOption = new ProductOption();
    private AdditionProduct additionProduct = new AdditionProduct();
    public void createProductOptionQuery() {

        for (int i = 1; i <= 100; i++) {
            /**
             * 옵션 상품
             */
            //한박스
            productOption.makeOneBoxQuery(i);
            //두박스 + 20%할인
            productOption.makeTwoBoxAndDiscountQuery(i, 20);

            /**
             * 추가상품
             */
            additionProduct.makeOneBoxQuery(i);
        }
    }
}
