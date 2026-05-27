package places;

import characters.Leader;
import characters.Trainer;
import java.util.LinkedList;
import java.util.Queue;

public class Gym extends Building {
	private Leader leader;
	private Queue<Trainer> challengers;

	public Gym(String name, Leader leader) {
		this.name = name;
		this.leader = leader;
		this.challengers = new LinkedList<>();
	}

	public void addChallenger(Trainer trainer) {
		this.challengers.add(trainer);
		System.out.println(trainer.getName() + " has entered the queue at " + this.name);
	}

	public String giveBadge() {
		System.out.println("Gym " + this.name + " is awarding the " + this.leader.getBadgeName() + " badge!");
		return this.leader.getBadgeName();
	}

	public void startCombat() {
		if (!this.challengers.isEmpty()) {
			Trainer nextChallenger = this.challengers.poll();
			System.out.println("Starting combat between Leader " + this.leader.getName() + " and Challenger "
					+ nextChallenger.getName());
		} else {
			System.out.println("No challengers remaining in the queue for " + this.name);
		}
	}

	public Leader getLeader() {
		return this.leader;
	}

	public Queue<Trainer> getChallengers() {
		return this.challengers;
	}
}