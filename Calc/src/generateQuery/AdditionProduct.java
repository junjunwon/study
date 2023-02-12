package generateQuery;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdditionProduct {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long inventory, price;
    private String addName;
    private long productId;

    public void makeOneBoxQuery(int index) {
        StringBuilder sb = new StringBuilder();

        createdAt = generateRandomDateTime(createdAt);
        updatedAt = createdAt.plusMonths(getNumberFromOneToTen());
        addName = "멀티비타민 체험팩 - ";
        productId = index;

        //한박스
        inventory = getInventory();
        price = getPrice();
        sb.append("INSERT INTO additional_product(add_name, inventory, price, created_at, updated_at, product_id) VALUES ('")
                .append(addName)
                .append(price +"원'")
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
