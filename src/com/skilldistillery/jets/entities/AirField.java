package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {

	private List<Jet> jetsList = new ArrayList<>();

	public AirField() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {

				String[] seperatedLine = line.split(",");
				String typeOfJet = seperatedLine[0];
				String model = seperatedLine[1];
				double speed = Double.parseDouble(seperatedLine[2]);
				int range = Integer.parseInt(seperatedLine[3]);
				long price = Long.parseLong(seperatedLine[4]);

				if (typeOfJet.equals("CargoPlane")) {
					Jet cargoJet = new CargoPlane(model, speed, range, price);
					jetsList.add(cargoJet);
				}
				if (typeOfJet.equals("FighterJet")) {
					Jet fighterJet = new FighterJet(model, speed, range, price);
					jetsList.add(fighterJet);
				}
				if (typeOfJet.equals("PartyJet")) {
					Jet partyJet = new PartyJet(model, speed, range, price);
					jetsList.add(partyJet);
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void listFleet() {
		for (Jet jet : jetsList) {
			System.out.println(jet);
		}
	}

	public void flyAllJets() {
		for (Jet jet : jetsList) {
			System.out.println(jet);
			jet.fly();
		}
	}

	public void viewFastestJet() {
		double thisJetsSpeed = 0, fastestJetsSpeed = 0;
		Jet fastestJet = null;
		for (Jet jet : jetsList) {
			thisJetsSpeed = jet.getSpeed();
			if (fastestJetsSpeed < thisJetsSpeed) {
				fastestJetsSpeed = thisJetsSpeed;
				fastestJet = jet;
			}
		}
		System.out.println("Fastest Jet: " + fastestJet);
	}

	public void viewLongestRangedJet() {
		double thisJetsRange = 0, longestJetsRange = 0;
		Jet longestRangedJet = null;
		for (Jet jet : jetsList) {
			thisJetsRange = jet.getRange();
			if (longestJetsRange < thisJetsRange) {
				longestJetsRange = thisJetsRange;
				longestRangedJet = jet;
			}
		}
		System.out.println("Longest Ranged Jet: " + longestRangedJet);
	}

	public void LoadAllCargoJets() {
		for (Jet jet : jetsList) {
			if (jet instanceof CargoPlane) {
				System.out.println(jet);
				((CargoPlane) jet).loadCargo();
			}
		}
	}

	public void Dogfight() {
		for (Jet jet : jetsList) {
			if (jet instanceof FighterJet) {
				System.out.println(jet);
				((FighterJet) jet).fight();
			}
		}
	}

	public void AddJetToFleet(Scanner kb) {
		System.out.println("Please enter the Jets model");
		kb.nextLine();
		String model = kb.nextLine();
		System.out.println("Please enter the Jets speed");
		double speed = kb.nextDouble();
		kb.nextLine();
		System.out.println("Please enter the Jets range");
		int range = kb.nextInt();
		kb.nextLine();
		System.out.println("Please enter the Jets price");
		long price = kb.nextLong();
		kb.nextLine();
		Jet partyJet = new PartyJet(model, speed, range, price);
		jetsList.add(partyJet);
		System.out.println(partyJet + " has been added to the fleet");
	}

	public void RemoveJetFromFleet(Scanner kb) {
		System.out.println("Which jet would you like to remove?");
		int counter = 1;
		for (Jet jet : jetsList) {
			System.out.println(counter + ": " + jet);
			counter++;
		}
		int userInput = kb.nextInt();
		kb.nextLine();
		System.out.println("You removed number " + userInput + ". Here are the remaining jets:");
		jetsList.remove(userInput - 1);
		for (Jet jet : jetsList) {
			System.out.println(jet);
		}
	}
}
