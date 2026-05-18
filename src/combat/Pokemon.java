package combat;

public abstract class Pokemon implements ICombat{
protected String name;
protected String type;
protected int level;
protected int hp;
protected int atk;
protected int def;
private Move[] moves = new Move[4];

public abstract void attack(Pokemon Opponent);

@Override
public void takeDamage(int damage) {
    this.hp -= damage;
    if (this.hp < 0) {
        this.hp = 0; // Evitamos que la vida sea negativa
    }
    System.out.println(this.name + " recibió " + damage + " puntos de daño. HP restante: " + this.hp);
}
}
