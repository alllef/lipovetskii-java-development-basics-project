public class Subscriber {

    private String name;
    private String surname;
    private String fatherName;
    private String address;
    private int innerCitySpeakingTime;
    private int outerCitySpeakingTime;

    public Subscriber(String name, String surname, String fatherName, String address, int innerCitySpeakingTime, int outerCitySpeakingTime) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.address = address;
        this.innerCitySpeakingTime = innerCitySpeakingTime;
        this.outerCitySpeakingTime = outerCitySpeakingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getInnerCitySpeakingTime() {
        return innerCitySpeakingTime;
    }

    public void setInnerCitySpeakingTime(int innerCitySpeakingTime) {
        this.innerCitySpeakingTime = innerCitySpeakingTime;
    }

    public int getOuterCitySpeakingTime() {
        return outerCitySpeakingTime;
    }

    public void setOuterCitySpeakingTime(int outerCitySpeakingTime) {
        this.outerCitySpeakingTime = outerCitySpeakingTime;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", address='" + address + '\'' +
                ", innerCitySpeakingTime=" + innerCitySpeakingTime +
                ", outerCitySpeakingTime=" + outerCitySpeakingTime +
                '}';
    }


    @Override
    public boolean equals(Object object) {

        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;


        Subscriber otherSubscriber = (Subscriber) object;

        boolean nameEquals = (name == null && otherSubscriber.getName() == null) || (name.equals(otherSubscriber.getName()));
        boolean surnameEquals = (surname == null && otherSubscriber.getSurname() == null) || (surname.equals(otherSubscriber.getSurname()));
        boolean fatherNameEquals = (fatherName == null && otherSubscriber.getFatherName() == null) || (fatherName.equals(otherSubscriber.getFatherName()));
        boolean innerCitySpeakingTimeEquals = (innerCitySpeakingTime == otherSubscriber.getInnerCitySpeakingTime());
        boolean outerCitySpeakingTimeEquals = (outerCitySpeakingTime == otherSubscriber.getOuterCitySpeakingTime());
        return nameEquals && surnameEquals && fatherNameEquals && innerCitySpeakingTimeEquals && outerCitySpeakingTimeEquals;

    }


}
