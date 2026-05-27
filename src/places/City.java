package places;

import characters.Leader;
import java.util.ArrayList;
import java.util.List;

public class City {
	private String name;
	private List<Building> buildings;
	private Leader leader;

	public City(String name, Leader leader) {
		this.name = name;
		this.leader = leader;
		this.buildings = new ArrayList<>();
	}

	public void addBuilding(Building building) {
		this.buildings.add(building);
		System.out.println("Building " + building.getName() + " has been added to the city of " + this.name);
	}

	public String getName() {
		return this.name;
	}

	public List<Building> getBuildings() {
		return this.buildings;
	}

	public Leader getLeader() {
		return this.leader;
	}
}