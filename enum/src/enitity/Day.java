package enitity;

import enums.Weekend;

public class Day {
    private Weekend weekend;

    public Weekend getWeekend() {
        return weekend;
    }

    public void setWeekend(Weekend weekend) {
        this.weekend = weekend;
    }

    public Day(Weekend weekend) {
        this.weekend = weekend;
    }
}
