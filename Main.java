import java.util.*;

public class Main {

	private static boolean goOn = true;
	private static boolean exist = false;
	private static int choice;
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Customer> customers = new ArrayList<>();

	public static void run(){
		while(goOn){
			printMenu();
			switch(input(choice)){
			case 1: addCustomer();
			break;
			case 2: removeCustomer();
			break;
			case 3: viewCustomers();
			break;
			case 4: deposit();
			break;
			case 5: withdrawal();
			break;
			case 6: addPhoneNumberToSpecificCustomer();
			break;
			case 7: displayPhoneNumbersForASpecificCustomer();
			break;
			case 8: addAdress();
			break;
			case 9: displayAdress();
			break;
			case 10: help();
			break;
			case 11: exit();
			break;
			default: wrongInput();
			break;
			}
		}
	}

	public static void printMenu(){
		System.out.println("1. Add customer "
				+ "\n" + "2. Remove customer "
				+ "\n" + "3. Display all customers"
				+ "\n" + "4. Deposit"
				+ "\n" + "5. Withdrawl"
				+ "\n" + "6. Add phonenumber to customer"
				+ "\n" + "7. Display a customers phonenumbers"
				+ "\n" + "8. Add Adress to specific customer"
				+ "\n" + "9. Display adress for specific customer"
				+ "\n" + "10. Help"
				+ "\n" + "11. Quit");
	}

	public static int input(int input){
		input = scanner.nextInt();
		scanner.nextLine();
		return input;
	}
	
	public static void help(){
		System.out.println("Här får du hjälp...");
	}

	public static void exit(){
		goOn = false;
		System.out.println("Programmet avslutas.");
	}

	public static void wrongInput(){
		System.out.println("Felaktigt kommando! Gå till hjälpmenyn genom att välja 10 för mer information om programmet.");
	}

	public static void addCustomer(){
		System.out.println("Customers first name: ");
		String fName = scanner.nextLine();
		System.out.println("Customers sir name: ");
		String sName = scanner.nextLine();
		Customer c = new Customer(sName, fName, 0.0);
		customers.add(c);
	}

	public static void removeCustomer(){
		System.out.println("First name of the customer: ");
		String fName = scanner.nextLine();
		System.out.println("Sir name of the customer: ");
		String sName = scanner.nextLine();
		for(Iterator<Customer> iterator = customers.iterator(); iterator.hasNext();){
			Customer c = iterator.next();
			if(fName.equalsIgnoreCase(c.getFirstName()) && sName.equalsIgnoreCase(c.getSirName())){
				iterator.remove();
				exist = true;
			}
		}

		if(!exist){
			System.out.println("No customer exists with that name.");
		}else{
			exist = false;
		}

	}

	public static void viewCustomers(){
		for(Customer c : customers){
			System.out.println(c);
		}
	}

	public static void deposit(){
		System.out.println("First name of the customer: ");
		String fName = scanner.nextLine();
		System.out.println("Sir name of the customer: ");
		String sName = scanner.nextLine();
		for(Customer c : customers){
			if(fName.equalsIgnoreCase(c.getFirstName()) && sName.equalsIgnoreCase(c.getSirName())){
				System.out.println("How much do you want to deposit?");
				double cash = scanner.nextDouble();
				scanner.nextLine();
				c.setBalance(cash);
				exist = true;
			}
		}

		if(!exist){
			System.out.println("No customer exists with that name.");
		}else{
			exist = false;
		}
	}

	public static void withdrawal(){
		System.out.println("First name of the customer: ");
		String fName = scanner.nextLine();
		System.out.println("Sir name of the customer: ");
		String sName = scanner.nextLine();
		for(Customer c : customers){
			if(fName.equalsIgnoreCase(c.getFirstName()) && sName.equalsIgnoreCase(c.getSirName())){
				System.out.println("How much do you want to withdraw?");
				double cash = scanner.nextDouble();
				scanner.nextLine();
				exist = true;
				if(c.getBalance() >= cash){
					c.setBalance(-cash);
				}else{
					System.out.println("You do not have enough money, you balance is: " + c.getBalance());
				}
			}
		}

		if(!exist){
			System.out.println("No customer exists with that name.");
		}else{
			exist = false;
		}
	}

	public static void addPhoneNumberToSpecificCustomer(){
		System.out.println("First name of the customer: ");
		String fName = scanner.nextLine();
		System.out.println("Sir name of the customer: ");
		String sName = scanner.nextLine();
		for(Customer c : customers){
			if(fName.equalsIgnoreCase(c.getFirstName()) && sName.equalsIgnoreCase(c.getSirName())){
				System.out.println("Area code for the number: ");
				String areaCode = scanner.nextLine();
				System.out.println("The phone number: ");
				String number = scanner.nextLine();
				PhoneNumber p = new PhoneNumber(areaCode, number);
				c.addPhoneNumber(p);
				exist = true;
			}
		}

		if(!exist){
			System.out.println("No customer exists with that name.");
		}else{
			exist = false;
		}
	}

	public static void displayPhoneNumbersForASpecificCustomer(){
		System.out.println("First name of the customer: ");
		String fName = scanner.nextLine();
		System.out.println("Sir name of the customer: ");
		String sName = scanner.nextLine();
		for(Customer c : customers){
			if(fName.equalsIgnoreCase(c.getFirstName()) && sName.equalsIgnoreCase(c.getSirName())){
				c.displayNumbers();
				exist = true;
			}
		}

		if(!exist){
			System.out.println("No customer exists with that name.");
		}else{
			exist = false;
		}
	}

	public static void addAdress(){
		System.out.println("First name of the customer: ");
		String fName = scanner.nextLine();
		System.out.println("Sir name of the customer: ");
		String sName = scanner.nextLine();
		for(Customer c : customers){
			if(fName.equalsIgnoreCase(c.getFirstName()) && sName.equalsIgnoreCase(c.getSirName())){
				System.out.println("Streetname: ");
				String street = scanner.nextLine();
				System.out.println("Streetnumber");
				int streetNumber = scanner.nextInt();
				scanner.nextLine();
				System.out.println("City: ");
				String city = scanner.nextLine();
				System.out.println("Zip code: ");
				int zipCode = scanner.nextInt();
				scanner.nextLine();
				Adress a = new Adress(street, streetNumber, city, zipCode);
				c.setAdress(a);
				exist = true;
			}
		}

		if(!exist){
			System.out.println("No customer exists with that name.");
		}else{
			exist = false;
		}
	}

	public static void displayAdress(){
		System.out.println("First name of the customer: ");
		String fName = scanner.nextLine();
		System.out.println("Sir name of the customer: ");
		String sName = scanner.nextLine();
		for(Customer c : customers){
			if(fName.equalsIgnoreCase(c.getFirstName()) && sName.equalsIgnoreCase(c.getSirName())){
				c.displayAdress();
				exist = true;
			}
		}

		if(!exist){
			System.out.println("No customer exists with that name.");
		}else{
			exist = false;
		}
	}

	public static void main(String[]args){
		run();
	}
}
