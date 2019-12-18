package heroes;

public final class HeroFactory {
    public Hero makeNewHero(final String type, final int x, final int y) {
        if (type.equals("K")) {
            return new Knight(x, y);
        }
        if (type.equals("P")) {
            return new Pyromancer(x, y);
        }
        if (type.equals("R")) {
            return new Rogue(x, y);
        }
        if (type.equals("W")) {
            return new Wizard(x, y);
        }
        return null;
    }
}
