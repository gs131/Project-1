package pharm;

import java.io.IOException;
 
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import ui.PharmacyUI;

public class SystemStartup {
    private static final String PHARMFILE = "Drug_Stores_NOLA.csv";
    
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    	PharmacyDB pharmDB;
    	
		pharmDB = loadPharmacies();
			     
			PharmacyUI ui =  new PharmacyUI(pharmDB);
			ui.run();
			in.close();

			System.out.println("bye");	
	}


	private static PharmacyDB loadPharmacies() {
		PharmacyDB pharms = new PharmacyDB();
		
		 try {
		            Reader reader = Files.newBufferedReader(Paths.get(PHARMFILE));
				    CSVParser parser = new CSVParserBuilder().build();
		            CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).withSkipLines(1).build();
		       
		            String[] nextRecord;
		            while ((nextRecord = csvReader.readNext()) != null) {
		                String id = nextRecord[0];
		                String ownerName = nextRecord[1];
		                String busName = nextRecord[2];
		                String addr = nextRecord[3];
		                String suite = nextRecord[4];
		                String city = nextRecord[5];
		                String state = nextRecord[6];
		                String zip = nextRecord[7];
		                String phone = nextRecord[8];
		                String busType = nextRecord[9];
		                
		                Pharmacy pharm = new Pharmacy(id, ownerName, busName, addr, suite, city, state, zip, phone, busType);
		    
		                pharms.add(pharm);
		            }
		        } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
		return pharms;
	}


}
	



