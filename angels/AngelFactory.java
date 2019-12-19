package angels;

public class AngelFactory {
    public Visitor getAngelVisitor(String type, int x, int y){
        if(type.equals("LifeGiver")){
            return new LifeGiverVisitor(x, y);
        }
        return null;
    }
}
