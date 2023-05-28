package generateQuery;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProductOption {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long inventory, price;
    private String name;
    private long productId;

    public void makeOneBoxQuery(int index) {
        StringBuilder sb = new StringBuilder();

        createdAt = generateRandomDateTime(createdAt);
        updatedAt = createdAt.plusMonths(getNumberFromOneToTen());
        name = "1박스(기본)";
        productId = index;

        //한박스
        inventory = getInventory();
        price = 0;
        sb.append("INSERT INTO product_option(name, inventory, price, created_at, updated_at, product_id) VALUES ('")
                .append(name + "'")
//                .append(price +"원'")
                .append(",")
                .append(inventory)
                .append(",")
                .append(price)
                .append(",")
                .append("'" + getLocalDatetimeFormat(createdAt) + "'")
                .append(",")
                .append("'" + getLocalDatetimeFormat(updatedAt) + "'")
                .append(",")
                .append(productId)
                .append(");");

        System.out.println(sb);
    }

    public void makeTwoBoxAndDiscountQuery(int index, int discountPercent) {
        StringBuilder sb = new StringBuilder();

        createdAt = generateRandomDateTime(createdAt);
        updatedAt = createdAt.plusMonths(getNumberFromOneToTen());
        name = "2박스";
        productId = index;

        //한박스
        inventory = getInventory();
        price = (long) (getPrice() * (discountPercent * 0.01));
        sb.append("INSERT INTO product_option(name, inventory, price, created_at, updated_at, product_id) VALUES ('")
                .append(name +"'")
//                .append("("+discountPercent+"%할인) - ")
//                .append(price +"원'")
                .append(",")
                .append(inventory)
                .append(",")
                .append(price)
                .append(",")
                .append("'" + getLocalDatetimeFormat(createdAt) + "'")
                .append(",")
                .append("'" + getLocalDatetimeFormat(updatedAt) + "'")
                .append(",")
                .append(productId)
                .append(");");

        System.out.println(sb);
    }

    public long getInventory() {
        return (long) ((Math.random() * 899) + 10);
    }
    public long getPrice() {
        return (long) ((Math.random() * 899) + 10_000);
    }

    public long getNumberFromOneToTen() {
        return (long) ((Math.random() * 10) + 1);
    }

    private String getLocalDatetimeFormat(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    private LocalDateTime generateRandomDateTime(LocalDateTime time) {
        return LocalDateTime.now()
                .plusYears(getNumberFromOneToTen())
                .plusMonths(getNumberFromOneToTen())
                .plusDays(getNumberFromOneToTen())
                .plusHours(getNumberFromOneToTen())
                .plusMinutes(getNumberFromOneToTen());


    }
}
