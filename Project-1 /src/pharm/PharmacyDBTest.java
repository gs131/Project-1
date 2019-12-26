package pharm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PharmacyDBTest {
    private PharmacyDB pharmDB;
    private Pharmacy pharm1;
    private Pharmacy pharm2;
    private Pharmacy pharm3;
    
	@BeforeEach
	void setUp() throws Exception {
		pharmDB = new PharmacyDB();
		pharm1=new Pharmacy("1","owner1","CVS1","addr1","", "city1","state1",
	    		"111111", "111-1111","pharmacy");
	    pharm2=new Pharmacy("2","owner2","CVS2","addr2","22", "city2","state2",
	    		"22222", "222-2222","pharmacy");
	    pharm3=new Pharmacy("3","owner3","CVS3","addr3","3", "city3","state3",
	    		"333333", "333-3333","pharmacy");
	    pharmDB.add(pharm2);
	    pharmDB.add(pharm1);
	    pharmDB.add(pharm3);
	}


	@Test
	void testGetPharmById() {
		Pharmacy pharm = pharmDB.getPharmById("2");
		assertEquals("owner2", pharm.getOwner());
		assertEquals("CVS2", pharm.getBusName());
		assertEquals("addr2", pharm.getAddress());
		assertEquals("22", pharm.getSuite());
		assertEquals("city2", pharm.getCity());
		assertEquals("state2", pharm.getState());
		assertEquals("22222", pharm.getZip());
		assertEquals("222-2222", pharm.getPhone());
		assertEquals("pharmacy", pharm.getType());
	}
	
	@Test
	void testGetPharmByBadId() {
		Pharmacy pharm = pharmDB.getPharmById("6");
	    assertNull(pharm);
	}

	@Test
	void testContainsId() {
		assertTrue(pharmDB.containsId("2"));
		assertFalse(pharmDB.containsId("6"));
	}

	@Test
	void testGetPharmaciesSortedOnName() {
		List<Pharmacy> sorted = pharmDB.getPharmaciesSortedOnName();
		assertEquals("CVS1", sorted.get(0).getBusName());
		assertEquals("CVS2", sorted.get(1).getBusName());
		assertEquals("CVS3", sorted.get(2).getBusName());
	}

	@Test
	void testGetPharmaciesByChainName() {
		 Pharmacy pharm=new Pharmacy("4","owner3","JOE'S DRUGS","addr4","4", "city4","state4",
		    		"44444", "444-4444","pharmacy");
		 pharmDB.add(pharm);
		List<Pharmacy> pharms = pharmDB.getPharmaciesByName("CVS");
		assertEquals(3, pharms.size());
	}
	
	@Test
	void testGetPharmaciesByNonChainName() {
		 Pharmacy pharm=new Pharmacy("4","owner3","JOE'S DRUGS","addr4","4", "city4","state4",
		    		"44444", "444-4444","pharmacy");
		 pharmDB.add(pharm);
		List<Pharmacy> pharms = pharmDB.getPharmaciesByName("JOE'S DRUGS");
		assertEquals(1, pharms.size());
		assertEquals("4", pharms.get(0).getId());
	}
	
	@Test
	void testGetPharmaciesByBadName() {
		List<Pharmacy> pharms = pharmDB.getPharmaciesByName("WALGREENS");
		assertEquals(0, pharms.size());
	}

	@Test
	void testGetPharmaciesByZip() {
		List<Pharmacy> pharms = pharmDB.getPharmaciesByZip("111111");
		assertEquals(1, pharms.size());
		assertEquals("1", pharms.get(0).getId());
	}
	
	@Test
	void testGetPharmaciesByBadZip() {
		List<Pharmacy> pharms = pharmDB.getPharmaciesByZip("77777");
		assertEquals(0, pharms.size());
	}

	@Test
	void testHowManyStoresInAChain() {
		 Pharmacy pharm=new Pharmacy("4","owner3","JOE'S DRUGS","addr4","4", "city4","state4",
		    		"44444", "444-4444","pharmacy");
		 pharmDB.add(pharm);
		assertEquals(3, pharmDB.howManyStoresInAChain("CVS"));
	}

}
