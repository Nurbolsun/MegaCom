import enitity.Day;
import enums.Elements;

public class Main {
    public static void main(String[] args) {
        for (Elements iteam:Elements.values() ) {
            System.out.println(iteam.getName() + " Номер элемента в таблице: " + iteam.getNum());
        }
    }
}