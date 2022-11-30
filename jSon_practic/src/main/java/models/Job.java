package models;

public class Job {
    private String companyName;
    private Position position;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Job{" +
                "companyName='" + companyName + '\'' +
                ", position=" + position +
                '}';
    }
}
