import Interfaces.ILight;
/* класс, описывающиий Лампочку*/
public class Bulb implements ILight {
    private int countLight;

    /* публичный конструктор с параметром, */
    public Bulb(int countLight){
        this.countLight=countLight;
    }
    /* геттер, возвращающий значение свойства countLight*/
    @Override
    public int getLight(){
        return countLight;
    }


    @Override
    public String getName() {

        return "";
    }

    @Override
    public void describe() {

    }
}
