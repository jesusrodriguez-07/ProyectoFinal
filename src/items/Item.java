package items;

import combat.Pokemon;

public abstract class Item implements IUsable {
	protected String name;
	protected String description;

	public Item() {
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return this.name;
	}
}