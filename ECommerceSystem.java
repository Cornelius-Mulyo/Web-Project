package mulyo;
import java.util.*;

public class ECommerceSystem {

    // Classes representing the entities
    static class Product {
        int id;
        String name;
        double price;
        int quantity;

        Product(int id, String name, double price, int quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    static class Order {
        int id;
        List<Product> products;
        double total;

        Order(int id, List<Product> products) {
            this.id = id;
            this.products = products;
            this.total = calculateTotal();
        }

        private double calculateTotal() {
            return products.stream().mapToDouble(p -> p.price * p.quantity).sum();
        }
    }

    // Inventory and Order Management
    private static Map<Integer, Product> inventory = new HashMap<>();
    private static Map<Integer, Order> orders = new HashMap<>();
    private static int orderCounter = 1;

    // Add product to inventory
    public static void addProductToInventory(Product product) {
        inventory.put(product.id, product);
        System.out.println("Product added: " + product.name);
    }

    // Place an order
    public static void placeOrder(List<Integer> productIds, List<Integer> quantities) {
        if (productIds.size() != quantities.size()) {
            System.out.println("Error: Mismatch in product IDs and quantities.");
            return;
        }

        List<Product> orderedProducts = new ArrayList<>();
        for (int i = 0; i < productIds.size(); i++) {
            Product product = inventory.get(productIds.get(i));
            if (product == null || product.quantity < quantities.get(i)) {
                System.out.println("Error: Product unavailable or insufficient quantity for ID: " + productIds.get(i));
                return;
            }
            Product orderedProduct = new Product(product.id, product.name, product.price, quantities.get(i));
            orderedProducts.add(orderedProduct);
            product.quantity -= quantities.get(i);
        }

        Order order = new Order(orderCounter++, orderedProducts);
        orders.put(order.id, order);
        System.out.println("Order placed successfully! Order ID: " + order.id);
    }

    // Generate order details
    public static void generateOrderDetails(int orderId) {
        Order order = orders.get(orderId);
        if (order == null) {
            System.out.println("Order not found!");
            return;
        }

        System.out.println("Order ID: " + order.id);
        System.out.println("Products:");
        for (Product product : order.products) {
            System.out.println("- " + product.name + " | Quantity: " + product.quantity + " | Price: " + product.price);
        }
        System.out.println("Total: $" + order.total);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample inventory
        addProductToInventory(new Product(1, "Laptop", 1200.00, 10));
        addProductToInventory(new Product(2, "Phone", 800.00, 20));
        addProductToInventory(new Product(3, "Headphones", 50.00, 50));

        System.out.println("Welcome to the E-Commerce System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Place Order");
            System.out.println("2. Generate Order Details");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter number of products to order: ");
                int n = scanner.nextInt();
                List<Integer> productIds = new ArrayList<>();
                List<Integer> quantities = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    System.out.print("Enter Product ID: ");
                    productIds.add(scanner.nextInt());
                    System.out.print("Enter Quantity: ");
                    quantities.add(scanner.nextInt());
                }

                placeOrder(productIds, quantities);
            } else if (choice == 2) {
                System.out.print("Enter Order ID: ");
                int orderId = scanner.nextInt();
                generateOrderDetails(orderId);
            } else if (choice == 3) {
                System.out.println("Exiting system. Thank you!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
        
        // Program by: Cornelius Mulyokela
        // GO HATTERS
    }
}

