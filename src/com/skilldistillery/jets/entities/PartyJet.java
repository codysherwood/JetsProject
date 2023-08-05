package com.skilldistillery.jets.entities;

public class PartyJet extends Jet implements LetUsParty {
	public PartyJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void party(){
	}
}
