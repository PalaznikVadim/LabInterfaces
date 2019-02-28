import Interfaces.IFurniture;

public class Table implements IFurniture {
    private String name;
    private int maxSquare;
    private int minSquare;

    /* публичный параметризованный конструктор, принимающий название объекта Table и занимаемую им площадь*/
    public Table(String name,int square){
        this.name=name;
        this.maxSquare=square;
        this.minSquare=square;
    }

    /*геттер, возвращающий значение св-ва maxSquare */
    public int getMaxSquare(){
        return maxSquare;
    }

    /*геттер, возвращающий значение св-ва minSquare */
    public int getMinSquare() {
        return minSquare;
    }

    /*геттер, возвращающий значение св-ва name */
    public String getName(){
        return name;
    }

    /* метод, предаставляющий информацию о объекте класса Table*/
    @Override
    public void describe() {
        System.out.print("     " + getName());
        System.out.println(" (площадь " + getMinSquare() + " м^2)");
    }
}
