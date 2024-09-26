package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Ludoman extends Hero {
    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.DICE_ROLL);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int die1 = RPG_Game.random.nextInt(6) + 1;
        int die2 = RPG_Game.random.nextInt(6) + 1;

        System.out.println(this.getName() + " rolled: " + die1 + " and " + die2);

        if (die1 == die2) {

            int damageToBoss = die1 * die2;
            boss.setHealth(boss.getHealth() - damageToBoss);
            System.out.println("Ludoman dealt " + damageToBoss + " damage to the boss!");
        } else {

            Hero randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
            while (randomHero == this || randomHero.getHealth() <= 0) {
                randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
            }
            int damageToHero = die1 + die2;
            randomHero.setHealth(randomHero.getHealth() - damageToHero);
            System.out.println("Ludoman dealt " + damageToHero + " damage to " + randomHero.getName() + "!");
        }
    }
}
