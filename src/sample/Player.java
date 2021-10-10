package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Player  implements Serializable {
    private transient  SimpleStringProperty name;
    private transient  SimpleStringProperty country;
    private transient  SimpleStringProperty age;
    private transient  SimpleStringProperty height;
    private transient  SimpleStringProperty club;
    private transient  SimpleStringProperty position;
    private transient  SimpleStringProperty jersy;
    private transient  SimpleStringProperty salary;
    private transient  SimpleIntegerProperty count;

    public Player(String name, String country, String age , String height, String club, String position, String jersy, String salary) {
        this.name = new SimpleStringProperty(name);
        this.country = new SimpleStringProperty(country);
        this.age = new SimpleStringProperty(age);
        this.height = new SimpleStringProperty(height);
        this.club = new SimpleStringProperty(club);
        this.position = new SimpleStringProperty(position);
        this.jersy = new SimpleStringProperty(jersy);
        this.salary = new SimpleStringProperty(salary);
        this.count = new SimpleIntegerProperty(0);
    }
    public Player(String country, int count){
        this.country = new SimpleStringProperty(country);
        this.count = new SimpleIntegerProperty(count);
        this.name = new SimpleStringProperty("");
        this.age = new SimpleStringProperty("");
        this.height = new SimpleStringProperty("");
        this.club = new SimpleStringProperty("");
        this.position = new SimpleStringProperty("");
        this.jersy = new SimpleStringProperty("");
        this.salary = new SimpleStringProperty("");

    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(getName());
        s.writeUTF(getCountry());
        s.writeUTF(getAge());
        s.writeUTF(getHeight());
        s.writeUTF(getClub());
        s.writeUTF(getJersy());
        s.writeUTF(getSalary());
        s.writeUTF(getPosition());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        name = new SimpleStringProperty(s.readUTF());
        country = new SimpleStringProperty(s.readUTF());
        age = new SimpleStringProperty(s.readUTF());
        height = new SimpleStringProperty(s.readUTF());
        club = new SimpleStringProperty(s.readUTF());
        jersy = new SimpleStringProperty(s.readUTF());
        salary = new SimpleStringProperty(s.readUTF());
        position = new SimpleStringProperty(s.readUTF());
    }

    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public String getCountry() {
        return country.get();
    }
    public void setCountry(String country) {
        this.country.set(country);
    }
    public String getAge() {
        return age.get();
    }
    public void setAge(String age) {
        this.age.set(age);
    }
    public String getHeight() {
        return height.get();
    }
    public void setHeight(String height) {
        this.height.set(height);
    }
    public String getClub() {
        return club.get();
    }
    public SimpleStringProperty clubProperty() {
        return club;
    }
    public void setClub(String club) {
        this.club.set(club);
    }
    public String getPosition() {
        return position.get();
    }
    public SimpleStringProperty positionProperty() {
        return position;
    }
    public void setPosition(String position) {
        this.position.set(position);
    }
    public String getJersy() {
        return jersy.get();
    }
    public SimpleStringProperty jersyProperty() {
        return jersy;
    }
    public void setJersy(String jersy) {
        this.jersy.set(jersy);
    }
    public String getSalary() {
        return salary.get();
    }
    public SimpleStringProperty salaryProperty() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary.set(salary);
    }
    public int getCount() {
        return count.get();
    }
    public void setCount(int count) {
        this.count.set(count);
    }
}
