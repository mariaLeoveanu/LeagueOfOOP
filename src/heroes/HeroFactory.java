package heroes;

public class HeroFactory {
    public Hero makeNewHero(String type, int x, int y){
        if(type.equals("K")){
            return new Knight(x, y);
        }
        if(type.equals("P")){
            return new Pyromancer(x, y);
        }
        if(type.equals("R")){
            return new Rogue(x, y);
        }
        if(type.equals("W")){
            return new Wizard(x, y);
        }
        return null;
    }
}
