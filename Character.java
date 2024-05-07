
public class Character {
    private String name;
    private int health;
    private String specialAbility;

    public Character(String name, int health, String specialAbility) {
        this.name = name;
        this.health = health;
        this.specialAbility = specialAbility;
    }

    public void attack(Character enemy) {
        System.out.println(name + " ataca " + enemy.getName());
        enemy.takeDamage(10);
    }

    public void useSpecialAbility( Character enemy) {
        System.out.println(name + " usa " + specialAbility + " contra " + enemy.getName());
        enemy.takeDamage(20);
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " foi derrotado!");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }
}
