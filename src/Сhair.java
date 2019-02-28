import Interfaces.IFurniture;

/* класс, описывающий кресло*/
public class Сhair implements IFurniture {
    private String name;
    private int minSquare;
    private int maxSquare;

    /* публичный параметризованный конструктор, параметры:
     *                      name - название кресла,
     *                      minSquare - минимальная площадь (сложеное кресло),
     *                      maxSquare - максимальная площадь (разложеное кресло)*/
    public Сhair(String name, int minSquare, int maxSquare){
        this.name=name;
        this.minSquare=minSquare;
        this.maxSquare=maxSquare;
    }

    /*геттер, возвращающий зачение св-ва maxSquare*/
    public int getMaxSquare(){
        return maxSquare;
    }

    /*геттер, возвращающий зачение св-ва maxSquare*/
    public int getMinSquare() {
        return minSquare;
    }

    /*геттер, возвращающий зачение св-ва name*/
    public String getName(){
        return name;
    }

    /*метод, предоставляющий информацию о кресле*/
    public void describe(){
        System.out.print("     " + getName());
        System.out.println(" (площадь от " + getMinSquare() + " м^2 до " + getMaxSquare() + " м^2)");
    }


}
