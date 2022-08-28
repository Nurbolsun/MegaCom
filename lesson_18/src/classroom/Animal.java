package classroom;

public class Animal {
    private String name;
    private String type;
    private int countPaws;
    private boolean hasTail;

    @Override
    public String toString() {
        return "classroom.Animal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", countPaws=" + countPaws +
                ", hasTail=" + hasTail +
                '}';
    }
}
