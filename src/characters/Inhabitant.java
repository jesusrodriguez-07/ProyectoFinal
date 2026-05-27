package characters;

public abstract class Inhabitant {
	protected String name;

	public Inhabitant() {
	}

	public abstract void interact();

	public String getName() {
		return this.name;
	}
}