package heroes;

public final class HeroFactory {
    public Hero makeNewHero(final String type, final int x, final int y, int id) {
        if (type.equals("K")) {
            return new Knight(x, y, id);
        }
        if (type.equals("P")) {
            return new Pyromancer(x, y, id);
        }
        if (type.equals("R")) {
            return new Rogue(x, y, id);
        }
        if (type.equals("W")) {
            return new Wizard(x, y, id);
        }
        return null;
    }
}
