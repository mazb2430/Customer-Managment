
public class PhoneNumber {
	private String areaCode;
	private String number;
	
	public PhoneNumber(String areaCode, String number){
		this.areaCode = areaCode;
		this.number = number;
	}
	
	public String getAreaCode(){
		return areaCode;
	}
	
	public String getNumber(){
		return number;
	}
	
	public String toString(){
		return areaCode + "-" + number;
	}
}
