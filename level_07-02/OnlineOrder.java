class Order {
    int orderId;
    String orderDate;
    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    public String getOrderStatus() {
	return "Order " + orderId + " placed on: " + orderDate;
    }
}
class ShippedOrder extends Order {
    String trackingNumber;
    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    public String getOrderStatus() {
	System.out.println("Order " + orderId + " has shipped on: " + orderDate);
        return "Tracking Number: " + trackingNumber;
    }
}
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;
    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    public String getOrderStatus() {
        return "Order " + orderId + " delivered on: " + deliveryDate;
    }
}
public class OnlineOrder {
    public static void main(String[] args) {
        Order order = new Order(101, "2025-02-01");
        ShippedOrder shippedOrder = new ShippedOrder(101, "2025-02-02", "T12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder(101, "2025-02-03", "T67890", "2025-02-07");
        System.out.println(order.getOrderStatus());
        System.out.println(shippedOrder.getOrderStatus());
        System.out.println(deliveredOrder.getOrderStatus());
    }
}
