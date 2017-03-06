
public class Adress {
	
	String street;
	int streetNumber;
	String city;
	int zipCode;
	
	public Adress(String street, int streetNumber, String city, int zipCode){
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public String toString(){
		return street + " " + streetNumber + "\n" + 
	zipCode + " " + city;
	}
}
