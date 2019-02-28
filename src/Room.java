import Exceptoin.WrongIlluminanceException;
import Exceptoin.WrongSpaceException;
import Interfaces.IAdded;
import Interfaces.IFurniture;
import Interfaces.ILight;

import java.util.ArrayList;
import java.util.List;

/* класс, описывающий комнату*/
public class Room {
    private String name;
    private int square;
    private int summMinSquare;
    private int summMaxSquare;
    private int summLight;
    private int minLight;
    private int maxLight;
    private int countWindow;
    private List<IFurniture> furniture;
    private List<ILight> bulbs;


    /* публичный параметризованный конструктор, принимающий параметры:
    *                           name - название комнаты,
    *                           square - площадь комнаты,
    *                           countWindow - количество окон в комнате*/
    public Room(String name, int square, int countWindow) {
        this.name = name;
        this.square = square;
        summMinSquare = 0;
        summMaxSquare=0;
        this.countWindow = countWindow;
        minLight = 300;
        maxLight = 4000;
        summLight = countWindow * 700;
        furniture = new ArrayList<IFurniture>();
        bulbs=new ArrayList<ILight>();
    }



    /* метод, добавляющий мебель и лампочки в комнату */
    public void add(IAdded added) throws WrongSpaceException,WrongIlluminanceException {
        if(added instanceof IFurniture) {
            if (((square * 0.7) >= (summMinSquare + ((IFurniture)added).getMinSquare())) && ((square * 0.7) >= (summMaxSquare + ((IFurniture)added).getMaxSquare()))) {
                furniture.add((IFurniture)added);
                summMinSquare += ((IFurniture)added).getMinSquare();
                summMaxSquare += ((IFurniture)added).getMaxSquare();
            }
            else {
                throw new WrongSpaceException("Площадь " + this.name + " будет занята более чем 70%, если добавить " + added.getName()+"(square="+((IFurniture) added).getMinSquare()+")");
            }
        }
        else if(added instanceof ILight){
            if((summLight+((ILight)added).getLight()>=minLight)&&(summLight+((ILight)added).getLight()<=maxLight)){
                bulbs.add(((ILight)added));
                summLight+=((ILight)added).getLight();
            }
            else{
                throw new WrongIlluminanceException("Освещенность "+this.name+" будет находиться вне границ 300..4000, " +
                        "если добавить лампочку со значением countLight="+((ILight)added).getLight()+
                        "\n(summLight="+summLight+")");
            }
        }
    }


    /* метод, предоставляющий информацию о комнате*/
    public void describe() {
        System.out.print("    Освещенность=" + getSummLight() + " ( " + getCountWindow() + " окна по 700лк");

        if (bulbs.size() != 0) {
            System.out.print("\n" + "      лампочки ");
        }

        for (ILight added : bulbs) {
            System.out.print(added.getLight() + " ");
        }
        System.out.println(")");
        System.out.print("    Площадь=" + getSquare());
        if (getSummMaxSquare() != 0) {
            System.out.print("  м^2( занято ");
            if (getSummMaxSquare() == getSummMinSquare()) {
                System.out.print(getSummMaxSquare());
            } else {
                System.out.println(getSummMinSquare() + "-" + getSummMaxSquare() + "м^2, гарантировано свободно " +
                        (getSquare() - getSummMaxSquare()) + "м^2 или " + (100 * getSummMaxSquare() / getSquare())
                        + "% площади)");
            }
        } else {
            System.out.println(" (свободно 100%)");
        }

        if (furniture.size() != 0) {
             System.out.println("    Мебель:");
             for (IFurniture added : furniture) {
                 added.describe();
             }
        }
        else {
            System.out.println("    Мебели нет");
        }
    }

    /* геттер, возвращающий значение св-ва name*/
    public String getName() {
        return name;
    }
    private int getSquare (){
        return square;
    }
    private int getCountWindow(){
        return countWindow;
    }
    private int getSummLight(){
        return summLight;
    }
    private int getSummMaxSquare(){
        return summMaxSquare;
    }
    private int getSummMinSquare(){
        return summMinSquare;
    }
}


