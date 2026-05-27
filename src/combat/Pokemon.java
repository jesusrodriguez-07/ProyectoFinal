package combat;

import exceptions.MoveExhaustedException;
import exceptions.PokemonFaintedException;

public abstract class Pokemon implements ICombat {
	protected String name;
	protected String type;
	protected int level;
	protected int hp;
	protected int maxHp;
	protected int atk;
	protected int def;
	protected int xp = 0;
	protected int maxXp = 100;
	private Move[] moves = new Move[4];

	public Pokemon() {
	}

	public void gainXp(int amount) {
		this.xp += amount;
		System.out.println(this.name + " gained " + amount + " XP!");

		while (this.xp >= this.maxXp) {
			this.xp -= this.maxXp;
			this.level++;
			this.maxHp += 5;
			this.hp = this.maxHp;
			this.atk += 2;
			this.def += 2;
			this.maxXp = (int) (this.maxXp * 1.5);
			System.out.println(this.name + " leveled up! It is now Level " + this.level + "!");
		}
	}

	@Override
	public void takeDamage(int damage) {
		this.hp -= damage;
		if (this.hp < 0) {
			this.hp = 0;
		}
		System.out.println(this.name + " took " + damage + " damage. Current HP: " + this.hp + "/" + this.maxHp);
	}

	public void heal(int amount) {
		System.out.println("Applying heal of " + amount + " HP to " + this.name);
		this.hp += amount;
		if (this.hp > this.maxHp) {
			this.hp = this.maxHp;
			System.out.println(this.name + " has been fully healed!");
		} else {
			System.out.println(this.name + " recovered health!");
		}
	}

	@Override
	public abstract void attack(Pokemon target, int moveIndex) throws MoveExhaustedException, PokemonFaintedException;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public int getLevel() {
		return this.level;
	}

	public int getHp() {
		return this.hp;
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public int getAtk() {
		return this.atk;
	}

	public int getDef() {
		return this.def;
	}

	public int getXp() {
		return this.xp;
	}

	public int getMaxXp() {
		return this.maxXp;
	}

	public Move[] getMoves() {
		return this.moves;
	}

	public void setMove(int index, Move move) {
		if (index >= 0 && index < 4) {
			this.moves[index] = move;
		}
	}
}