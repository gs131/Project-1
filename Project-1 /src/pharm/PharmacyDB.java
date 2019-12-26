package pharm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * A collection of pharmacies
 * @author Gaganajit Singh
 *
 */
public class PharmacyDB {
	private HashMap<String, Pharmacy> pharmMap = new HashMap<String, Pharmacy>();

	/**
	 * add a pharmacy to the hash map.
	 * The key is the pharmacy id. 
	 * If the pharmacy key is already present
	 * in the hash map, do not add the pharmacy
	 * @param pharm
	 */
	public void add(Pharmacy pharm)  {	
		pharmMap.putIfAbsent(pharm.getId(), pharm);
	}
	

	  /**
	    * return the pharmacy by its id
	    * This will return null if the pharmacy does not exist
	    * @param id
	    * @return the associated pharmacy
	    */
	   public Pharmacy getPharmById(String id) {
		   return pharmMap.get(id);
	   }
	   
	   /**
	    * returns true if the id passed in the parameter
	    * is a key on the hash map, in other words, if
	    * the pharmacy is in the hash map
	    * @param id
	    * @return true if the pharmacy associated with the
	    * id is in the collection, false otherwise
	    */
	   public Boolean containsId(String id) {
		   return pharmMap.containsKey(id);
	   }
	   
	   /**
	    * return a list of pharmacies sorted by name
	    */
	   public List<Pharmacy> getPharmaciesSortedOnName() {
		  ArrayList<Pharmacy> pharmList= new ArrayList<Pharmacy>(pharmMap.values());
		   Collections.sort(pharmList, (Pharmacy p1, Pharmacy p2)-> p1.getBusName().compareTo(p2.getBusName()));
	       return pharmList;
	   }
	   
	   /**
	    * return a list of pharmacies with the same chain name
	    * This will ignore the pharmacy number. For example, all
	    * pharmacies that are part of Walgreens will be returned
	    * If a pharmacy is not part of a chain, just that pharmacy is returned
	    */
	   public List<Pharmacy> getPharmaciesByName(String chainName) {
		  
		   ArrayList<Pharmacy> pharms = new ArrayList<Pharmacy>();
		   for (Pharmacy pharm : pharmMap.values()) {
			    if (pharm.storeInChain(chainName))
			    		pharms.add(pharm);
			}
		   return pharms;
	   }
	   
	   /**
	    * returns a list of pharmacies in the zip code passed
	    * in the parameter
	    * @param zip code
	    * @return list of pharmacies in the zip code
	    */
	   public List<Pharmacy> getPharmaciesByZip(String zip){
		   ArrayList<Pharmacy> pharms = new ArrayList<Pharmacy>();
		   for (Pharmacy pharm : pharmMap.values()) {
			    if (pharm.getZip().contentEquals(zip))
			    		pharms.add(pharm);
			}
		   return pharms;
	   }
	   
	   public int howManyStoresInAChain(String chainName) {
		   int total=0;
		   for (Pharmacy pharm : pharmMap.values()) {
			    if (pharm.storeInChain(chainName))
			    		total++;
			}
		   return total;
	   }
}
