package heroes;

public class Wizard extends Hero {
    Wizard(int x, int y) {
        super(x, y);
        hp = 400;
        maxHP = 400;
        name = 'W';
    }

    @Override
    public void attack(Hero hero, char[][] map) {

    }
}
