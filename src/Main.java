import Exceptoin.WrongIlluminanceException;
import Exceptoin.WrongSpaceException;

public class Main {

    public static void main(String[] args) {
        Building building=new Building("Здание 1");
        try {
        building.addRoom("Комната 1",100,3);
        building.addRoom("Комната 2",5,2);
        building.getRoom("Комната 1").add(new Bulb(150));
        building.getRoom("Комната 1").add(new Bulb(200));
        building.getRoom("Комната 1").add(new Table("Стол письменный",30));
        building.getRoom("Комната 1").add(new Сhair("Кресло мягкое и пушистое",1,2));
        building.describe();
            //
        }
        catch(WrongSpaceException ex){
            System.out.println(ex.getMessage());
        }
        catch(WrongIlluminanceException ex){
            System.out.println(ex.getMessage());
        }


    }
}
