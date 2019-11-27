package heroes;

public class Rogue extends Hero {
    Rogue(int x, int y) {
        super(x, y);
        hp = 600;
        maxHP = 600;
    }

    @Override
    public void attack(Hero hero, char[][] map) {

    }
}
