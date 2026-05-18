package combat;

public class Bulbasaur extends Pokemon {

    // 1. CONSTRUCTOR: Rellenamos las variables que heredamos de Pokemon
    public Bulbasaur(int level) {
        this.name = "Bulbasaur";
        this.type = "Planta/Veneno";
        this.level = level;
        this.hp = 45 + (level * 3);   // Vida base + extra por nivel
        this.atk = 49 + (level * 2);  // Ataque base + extra por nivel
        this.def = 49 + (level * 2);  // Defensa base + extra por nivel
    }

    // 2. METODO DE ATAQUE: Aquí defines qué pasa cuando Bulbasaur ataca a otro Pokémon
    @Override
    public void attack(Pokemon target) {
        System.out.println(this.name + " usa un ataque contra " + target.name + "!");
        
        // Un cálculo básico de daño (Tu ataque menos la mitad de la defensa del rival)
        int damageRealizado = this.atk - (target.def / 2);
        
        if (damageRealizado <= 0) {
            damageRealizado = 1; // Al menos hace 1 de daño mínimo
        }
        
        // Le ordenamos al objetivo que reciba el daño calculando
        target.takeDamage(damageRealizado);
    }
}