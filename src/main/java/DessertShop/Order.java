

 package DessertShop;


 import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Order implements Payable {
    private List<DessertItem> order;
    private PayType payMethod;

    public Order() {
        order = new ArrayList<DessertItem>();
        payMethod = PayType.CASH;
    }

    public List<DessertItem> getOrderList() {
        return order;
    }

    public void add(DessertItem item) {
        if (item instanceof Candy) {
            Candy new_candy = (Candy) item;
            for (DessertItem dessert_item : order) {
                if (dessert_item instanceof Candy && new_candy.isSameAs((Candy) dessert_item)) {
                    
                    Candy old_candy = (Candy) dessert_item;
                    double combined_weight = old_candy.getWeight() + new_candy.getWeight();
                    old_candy.setWeight(combined_weight);
                }
            }
        } else if (item instanceof Cookie) {
            Cookie new_cookie = (Cookie) item;
            for (DessertItem dessert_item : order) {
                if (dessert_item instanceof Cookie && new_cookie.isSameAs((Cookie) dessert_item)) {
                    
                    Cookie old_cookie = (Cookie) dessert_item;
                    int combined_quantity = old_cookie.getQuantity() + new_cookie.getQuantity();
                    old_cookie.setQuantity(combined_quantity);
                }
            }
        }
        order.add(item);
        Collections.sort(order);
    }

    public int itemCount() {
        return order.size();
    }

    public double orderCost() {
        double totalCost = 0;
        for (DessertItem item : order) {
            totalCost += item.calculateCost();
        }
        return totalCost;
    }

    public double orderTax() {
        double totalTax = 0;
        for (DessertItem item : order) {
            totalTax += item.calculateTax();
        }
        return totalTax;
    }

    @Override
    public PayType getPayType() {
        return payMethod;
    }

    @Override
    public void setPayType(PayType payType) {
        this.payMethod = payType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        int items = 0;
        double subtotal = 0;
        double tax = 0;
        String line1 = "----------------Receipt---------------";
        System.out.println(line1);
        for (DessertItem item : order) {
            double itemCost = item.calculateCost();
            double itemTax = item.calculateTax();
            System.out.println(item.toString());
            subtotal += itemCost;
            tax += itemTax;
            items++;
        }
        String line = "-----------------------------------------";

        System.out.println(line);
        sb.append(String.format("\n%-25s%d", "Items:", items));
        sb.append(String.format("\n%-25s$%-8.2f", "Subtotal:", subtotal));
        sb.append(String.format("\n%-25s$%-8.2f", "Tax:", tax));
        sb.append(String.format("\n%-25s$%-8.2f", "Total:", subtotal + tax));
        sb.append(String.format("\n \n %s", line));
        sb.append(String.format("\n%-25s%s", "Payment Method:", payMethod));

        return sb.toString();
    }
}