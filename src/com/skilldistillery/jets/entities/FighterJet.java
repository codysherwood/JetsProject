package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {
	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void fight() {
		System.out.println(" goes pew pew pew pop");
		System.out.println("and woosh zip zoom ");
		System.out.println(" also bang bang bang boom");
	}

}
