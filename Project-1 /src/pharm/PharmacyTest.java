package pharm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PharmacyTest {


	
  @Test
  void testStoreInChain() {
		Pharmacy pharm = new Pharmacy();
		pharm.setId("69997");
		pharm.setBusName("WALGREENS #16395");
		pharm.setAddress("2000 CANAL ST");
		assertTrue(pharm.storeInChain("WALGREENS"));
  }
  
  @Test
  void testStoreInChain2() {
		Pharmacy pharm = new Pharmacy();
		pharm.setId("69948");
		pharm.setBusName("CVS/PHARMACY #10559");
		pharm.setAddress("939 GIROD ST");
		assertTrue(pharm.storeInChain("CVS"));
}
  
  @Test
  void testStoreInChain3() {
		Pharmacy pharm = new Pharmacy();
		pharm.setId("69938");
		pharm.setBusName("CRESCENT CITY PHARMACY");
		pharm.setAddress("2240 SIMON BOLIVAR AVE");
		assertTrue(pharm.storeInChain("CRESCENT CITY PHARMACY"));
}
  
  @Test
  void testStoreInChain4() {
		Pharmacy pharm = new Pharmacy();
		pharm.setId("69938");
		pharm.setBusName("CRESCENT CITY PHARMACY");
		pharm.setAddress("2240 SIMON BOLIVAR AVE");
		assertFalse(pharm.storeInChain("PHARMACY"));
}
}
