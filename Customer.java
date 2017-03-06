import java.util.ArrayList;

public class Customer {

	private String sirName;
	private String firstName;
	private double balance;
	private Adress adress;
	private ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();

	public Customer(String sName, String fName, double balance){
		this.sirName = sName;
		this.firstName = fName;
		this.balance = balance;
	}

	public String getSirName(){
		return sirName;
	}

	public String getFirstName(){
		return firstName;
	}

	public double getBalance(){
		return balance;
	}

	public void setBalance(double b){
		balance += b;
	}

	public void setAdress(Adress a){
		adress = a;
	}

	public void addPhoneNumber(PhoneNumber phoneNumber){
		phoneNumbers.add(phoneNumber);
	}

	public void displayNumbers(){
		for(PhoneNumber p : phoneNumbers){
			System.out.println(p);
		}
	}

	public void displayAdress(){
		if(adress != null)
			System.out.println(adress);
		else
			System.out.println("No adress available.");
	}

	public String toString(){
		return sirName + ", " + firstName;
	}

}
