package characters;

public class Leader extends Inhabitant {
	private String badgeName;

	public Leader(String name, String badgeName) {
		this.name = name;
		this.badgeName = badgeName;
	}

	@Override
	public void interact() {
		System.out.println("Gym Leader " + this.name + " welcomes you to the Gym. Prepare to fight for the "
				+ this.badgeName + " Badge!");
	}

	public void rewardBadge(Trainer trainer) {
		int currentMedals = trainer.getMedals();
		trainer.setMedals(currentMedals + 1);
		System.out.println("Gym Leader " + this.name + " rewarded " + trainer.getName() + " with the " + this.badgeName
				+ " Badge!");
	}

	public String getBadgeName() {
		return this.badgeName;
	}
}