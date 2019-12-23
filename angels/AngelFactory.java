package angels;

public class AngelFactory {
    public Visitor getAngelVisitor(String type, int x, int y){
        if(type.equals("LifeGiver")){
            return new LifeGiverVisitor(x, y);
        }
        if(type.equals("LevelUpAngel")){
            return new LevelUpAngelVisitor(x, y);
        }
        if(type.equals("DamageAngel")){
            return new DamageAngelVisitor(x, y);
        }
        if(type.equals("DarkAngel")){
            return new DarkAngelVisitor(x, y);
        }
        if(type.equals("Dracula")){
            return new DraculaVisitor(x, y);
        }
        if(type.equals("GoodBoy")){
            return new GoodBoyVisitor(x, y);
        }
        if (type.equals("SmallAngel")){
            return new SmallAngelVisitor(x, y);
        }
        if(type.equals("Spawner")){
            return new SpawnerVisitor(x, y);
        }
        if(type.equals("TheDoomer")){
            return new TheDoomerVisitor(x, y);
        }
        if (type.equals("XPAngel")){
            return new XPAngelVisitor(x, y);
        }
        return null;
    }
}
