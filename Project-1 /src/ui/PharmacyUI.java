package ui;

import java.util.List;

import pharm.Pharmacy;
import pharm.PharmacyDB;

public class PharmacyUI extends MenuUI {
	private PharmacyDB pharmDB;
	/**
	 * create a PharmacyUI object that collaborates
	 * with the PharmacyDB passed in as a parameter
	 * @param system
	 */
	   public PharmacyUI(PharmacyDB pharmDB){
         this.pharmDB=pharmDB;
	   }
	   
	   /**
		   * this method handles all interaction with the user
		   * It repeatedly displays a menu of options, allows
		   * the customer to enter an option, and then displays results
		   * from processing the user's choice
		   */
		   public void run()
		   {		
			   String command = readCommand();

			      while (!command.equalsIgnoreCase("QUIT")){
			    	  switch (command) {
			    	  case "LIST":
			    	      listSortedPharmacies();
			    		  break;		    	  
			    	  case "LIST2":
			    		  listPharmaciesInChain();
			    		  break;
			    	  case "DISP":
			    	      displayPharmacyById();
			    		  break;
			    	  case "NUMINCHAIN": 
			    		  displayNumPharmaciesInChain();
			    		  
			    		  break;
			    	  case "LISTBYZIP":
			    		  displayPharmaciesInZip();
			  
			    		  break;
			    	  case "ADD":
			    		  Boolean ret = addPharmacy();
			    		  if (ret)
			    			  System.out.println("pharmacy was added");
			    		  else
			    			  System.out.println("pharmacy is already in the system");
			  
			    		  break;
			    	  default:
			    		  System.out.println("Invalid command");
			    	  }

			         command = readCommand();
			      }
			    System.out.println("Bye!");		   
			   in.close();
			   }
		   
		   private  void listSortedPharmacies() {
			   List<Pharmacy>pharms = pharmDB.getPharmaciesSortedOnName();
	    		 for (Pharmacy pharm : pharms) {
	    			 System.out.println(pharm.toString());
	    		 }
		   }
		   
		   private void listPharmaciesInChain() {
			   System.out.println("Enter the chain name");
	    		  String chainName = in.nextLine();
	    		  List<Pharmacy>pharms = pharmDB.getPharmaciesByName(chainName);
		    	  for (Pharmacy pharm : pharms) {
		    			 System.out.println(pharm.toString());
		    		 }
		   }
		   
		   private void displayPharmacyById() {
			      System.out.println("Enter the id");
	    	      String id = in.nextLine();
	    	      Pharmacy pharm = pharmDB.getPharmById(id);
	    	      System.out.println(pharm.toString());
		   }
		   
		   private void displayNumPharmaciesInChain() {
			   System.out.println("Enter the chain name");
	    		  String chainName = in.nextLine();
	              int num = pharmDB.howManyStoresInAChain(chainName);
	              System.out.println("There are " + num + "stores in the " + chainName + " chain");
		   }
		   
		   private void displayPharmaciesInZip() {
		  		  System.out.println("Enter a zip code");
	    		  String zip = in.nextLine();
	    		  List<Pharmacy>pharms = pharmDB.getPharmaciesByZip(zip);
		    	  for (Pharmacy pharm : pharms) {
		    			 System.out.println(pharm.toString());
		    		 }
		   }
		   
		   private Boolean addPharmacy() {
			   System.out.println("Enter pharmacy information");
			   System.out.println("id: ");
			   String id = in.nextLine();
			   System.out.println("owner name: ");
			   String ownerName = in.nextLine();
			   System.out.println("store name: ");
			   String storeName = in.nextLine();
			   System.out.println("address: ");
			   String address  = in.nextLine();
			   System.out.println("suite: ");
			   String suite = in.nextLine();
			   System.out.println("city: ");
			   String city = in.nextLine();
			   System.out.println("state: ");
			   String state = in.nextLine();
			   System.out.println("zip: ");
			   String zip = in.nextLine();
			   System.out.println("phone: ");
			   String phone = in.nextLine();
			   System.out.println("business type: ");
			   String busType = in.nextLine();
			   
			   Pharmacy pharm = new Pharmacy(id, ownerName, storeName, 
					   address, suite, city, state, zip, phone, busType);
			   if (pharmDB.containsId(id))
				   return false;
			   else {
			       pharmDB.add(pharm);
			       return true;
			   }
		   }
			private String readCommand() {
				   System.out.println();
				   System.out.println( "Please enter a command" );
				   System.out.println("LIST: Show all pharmacies sorted by name");
				   System.out.println("LIST2: Show by name. If you enter the name of a chain, it will display all stores in the chain");
				   System.out.println("DISP: Find and display a pharmacy by its id");
				   System.out.println("NUMINCHAIN: Display the number of stores in a chain");
				   System.out.println("LISTBYZIP: Show all pharmacies in a zip code");
				   System.out.println("ADD: Add a pharmacy to the DB");
				   System.out.println("QUIT: quit");
			       System.out.println(">>>>>>");     
			       String command = in.nextLine().toUpperCase();
			       return command;
		}
		   
}
