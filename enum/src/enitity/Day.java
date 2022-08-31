package enitity;

import enums.Elements;

public class Day {
    private Elements weekend;

    public Elements getWeekend() {
        return weekend;
    }

    public void setWeekend(Elements weekend) {
        this.weekend = weekend;
    }

    public Day(Elements weekend) {
        this.weekend = weekend;
    }
}
