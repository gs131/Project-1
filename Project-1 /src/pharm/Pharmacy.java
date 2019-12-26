package pharm;

/**
 * Represents one pharmacy's information. The information consists of a city generated id, an owner, the name of the pharmacy,
 * its street address, suite, city, state, zip code, phone number, and a type
 * @author Gaganajit Singh
 *
 */
public class Pharmacy {
	private String id;
	private String owner;
	private String busName;
	private String address;
	private String suite;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String type;
	
	public Pharmacy() {}
	
	public Pharmacy(String id, String owner, String busName, String address, String suite, String city, String state, String zip,
			String phone, String type) {
		super();
		this.id = id;
		this.owner = owner;
		this.busName = busName;
		this.address = address; 
		this.suite = suite;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	/**
	 * This returns true if the business name of a pharmacy
	 * indicates that it is part of a chain. The business
	 * names for chain members all have the format
	 * ChainName Number
	 * For example WALGREENS #02262
	 * so we just test the name of the chain against the first part
	 * of the business name
	 * @param chainName
	 * @return true if the pharmacy is in the chain, false otherwise
	 */
	public Boolean storeInChain(String chainName) {
		return (busName.startsWith(chainName.toUpperCase()));
		
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * returns a formatted string containing the
	 * information about the pharmacy
	 */
	@Override
	public String toString() {
		String newline = System.lineSeparator();
		return "id: " + id + newline + 
				"owner: " + owner + newline +
				"store name: " + busName + newline +
				"address: " + address + newline + 
				 "suite: "+ suite + newline +
				 "city: " + city + ", state: " + state + ", zip: " + zip + newline +
				 "phone: " + phone + newline + "type: " + type;
				
	}

    
}
