package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Client;
import entidades.Order;
import entidades.OrderItem;
import entidades.Product;
import enums.OrderStatus;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		
		System.out.print("Email: ");
		String clentEmail = sc.next();
		
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date clientbDate = sdf.parse(sc.next());
		
		Client client = new Client(clientName, clentEmail, clientbDate);
		System.out.println();

		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many itens to this order: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("Order summary");
		System.out.println(order.toString());
		
		sc.close();
	}

}
