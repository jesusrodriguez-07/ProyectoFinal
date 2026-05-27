package combat;

import exceptions.MoveExhaustedException;

public class Move {
	private String name;
	private int power;
	private int pp;
	private int maxPp;

	public Move(String name, int power, int maxPp) {
		this.name = name;
		this.power = power;
		this.maxPp = maxPp;
		this.pp = maxPp;
	}

	public void usePP() throws MoveExhaustedException {
		if (this.pp <= 0) {
			throw new MoveExhaustedException("Move " + this.name + " has no PP left!");
		}
		this.pp--;
	}

	public String getName() {
		return this.name;
	}

	public int getPower() {
		return this.power;
	}

	public int getPp() {
		return this.pp;
	}

	public int getMaxPp() {
		return this.maxPp;
	}
}