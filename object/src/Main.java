public class Main {
    public static void main(String[] args) {

        Students[] infStudent = new Students[5];

        infStudent[0] = new Students("Aman", "Amanov", "Java", "no", 24);
        infStudent[0].preview();
        infStudent[1] = new Students("Aibek", "Esenov", "Java", "yes", 27);
        infStudent[1].preview();
        infStudent[2] = new Students("Akyl", "Aibekov", "Java", "yes", 35);
        infStudent[2].preview();
        infStudent[3] = new Students("Nurbek", "Amanov", "Java", "no", 18);
        infStudent[3].preview();
        infStudent[4] = new Students("Esen", "Aibekov", "Java", "yes", 21);
        infStudent[4].preview();

    }
}