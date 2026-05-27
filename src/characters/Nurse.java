package characters;

import combat.Pokemon;

public class Nurse extends Inhabitant {
	public Nurse(String name) {
		this.name = name;
	}

	@Override
	public void interact() {
		System.out.println("Nurse " + this.name + " welcomes you to the Pokemon Center. I can heal your team.");
	}

	public void healTeam(Trainer trainer) {
		System.out.println("Nurse " + this.name + " is healing " + trainer.getName() + "'s Pokemon team...");
		for (Pokemon pokemon : trainer.getTeam()) {
			pokemon.heal(pokemon.getMaxHp());
		}
		System.out.println("All Pokemon in " + trainer.getName() + "'s team have been fully restored!");
	}
}