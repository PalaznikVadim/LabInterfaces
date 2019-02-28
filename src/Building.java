import Exceptoin.WrongIlluminanceException;

import java.util.ArrayList;
import java.util.List;

/* класс, описывающий здание*/
public class Building {
    private String name;
    private List<Room> rooms;

/* публичный конструктор с строковым параметром, передающим название здания */
    public Building(String name) {
        this.name = name;
        rooms = new ArrayList<Room>();
    }

    /* метод , добавляющий комнаты в здание. Параметры передающиеся в методе:
     *  nameRoom - название комнаты,
     *  square - площадь комнаты,
     *  ouuntWindow - количество окон в комнате*/
    public void addRoom(String nameRoom, int square, int countWindow) throws WrongIlluminanceException{
            if (!((countWindow*700>4000)||(countWindow*700<300))) {
                rooms.add(new Room(nameRoom, square, countWindow));
            }
            else{
                throw new WrongIlluminanceException("В "+nameRoom+" значение параметра sumLight находиться вне диапозона 400..4000\n " +
                        "sumLight=countWindow*700\n"+
                        "Перепроверьте значение countWindow(countWindow="+ countWindow+")");
            }

    }

    /* метод, возвращающий комнату с таким же именем, что и передоваемый параметр метода */
    public Room getRoom(String nameRoom) {
        Room rm = new Room("", 0, 0);

        for (Room curr : rooms) {
            if (curr.getName().equals(nameRoom)) {
                return curr;
            }
        }
        if (rm.getName().equals(nameRoom)) {
            return rm;
        } else {
            return null;
        }
    }
    /* метод, предоставляющий информацию про объект класса Building*/
    public void describe(){
        System.out.println(name);
        for(Room room:rooms) {
            System.out.println(" " + room.getName());
            room.describe();

        }
    }
}



