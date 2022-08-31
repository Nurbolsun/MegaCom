package enums;

public enum Elements {
    AU("Золото", 79),
    CU("Медь", 29),
    H("Hellium", 1),
    O("Кислород", 8);

    private String name;
    private int num;

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    Elements(String name, int num) {
        this.name = name;
        this.num = num;


    }
}
