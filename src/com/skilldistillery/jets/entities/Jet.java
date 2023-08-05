package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.setSpeed(speed);
		this.setRange(range);
		this.price = price;
	}

	@Override
	public String toString() {
		return "Jet [model=" + model + ", speed=" + getSpeed() + ", range=" + getRange() + ", price=" + price + "]";
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void fly() {
		double hoursOfFlight = range / speed;
		System.out.println(" can zip around for " + hoursOfFlight + " hours!");
	}
}
