package classroom;

public class Dog {
    private String name;
    private String type;
    private int countPaws;
    private boolean hasTail;

    public int getCountPaws() {
        return countPaws;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setCountPaws(int countPaws) {
        this.countPaws = countPaws;
    }

    public void setHasTail(boolean hasTail) {
        this.hasTail = hasTail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "classroom.Dog{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", countPaws=" + countPaws +
                ", hasTail=" + hasTail +
                '}';
    }
}

