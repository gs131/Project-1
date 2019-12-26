package ui;

import java.util.Scanner;

/**
 * This is intended to be the top level of a family of
 * menu-based user interfaces
 * @author Gaganajit Singh
 *
 */
public abstract class MenuUI {
		protected Scanner in;

		
		/**
		 * create a MenuGUI object that collaborates
		 * with the HospitalSystem passed in as a parameter
		 * @param system
		 */
		   public MenuUI(){
			  in = new Scanner(System.in);
		   }

		  /**
		   * this method handles all interaction with the user
		   * It repeatedly displays a menu of options, allows
		   * the customer to enter an option, and then displays results
		   * from processing the customer's choice
		   */
		   public abstract void run();
}
