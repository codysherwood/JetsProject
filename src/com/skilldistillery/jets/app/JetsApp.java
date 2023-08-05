package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entities.AirField;

public class JetsApp {
	private AirField theAirfield = new AirField();
	java.util.Scanner kb = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		app.run();

	}

	public void run() {
		startMenu();
		userSelection();
	}

	public void startMenu() {
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("================ Menu ================");
		System.out.println("|                                    |");
		System.out.println("|1. List fleet                       |");
		System.out.println("|2. Fly all jets                     |");
		System.out.println("|3. View fastest jet                 |");
		System.out.println("|4. View jet with the longest range  |");
		System.out.println("|5. Load all Cargo jets              |");
		System.out.println("|6. Dogfight                         |");
		System.out.println("|7. Add a jet to Fleet               |");
		System.out.println("|8. Remove a jet from Fleet          |");
		System.out.println("|9. Quit                             |");
		System.out.println("|                                    |");
		System.out.println("======================================");
	}

	public void userSelection() {
		boolean keepRunning = true;
		while (keepRunning) {
			int numChoice = kb.nextInt();

			switch (numChoice) {
			case 1:
				theAirfield.listFleet();
				break;
			case 2:
				theAirfield.flyAllJets();
				break;
			case 3:
				theAirfield.viewFastestJet();
				break;
			case 4:
				theAirfield.viewLongestRangedJet();
				break;
			case 5:
				theAirfield.LoadAllCargoJets();
				break;
			case 6:
				theAirfield.Dogfight();
				break;
			case 7:
				theAirfield.AddJetToFleet(kb);
				break;
			case 8:
				theAirfield.RemoveJetFromFleet(kb);
				break;
			case 9:
				keepRunning = false;
				System.out.println("Have a great day!");
				break;
			default:
				System.out.println("Invalid selection");
			}
		}
	}
}
