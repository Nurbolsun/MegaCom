public class Guitar {
    String color;
    int Stringcount ;
    int[] tensions = new int[6];

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStringcount() {
        return Stringcount;
    }

    public void setStringcount(int stringcount) {
        Stringcount = stringcount;
    }

    void tune(){
        tensions[0-5] = 5;
    }
    void play(){
        System.out.println("Oh, the misery\n" +
                "Everybody wants to be my enemy\n" +
                "Spare the sympathy\n" +
                "Everybody wants to be my enemy");
        unsettle();
    }
    private void unsettle(){

    }
}

