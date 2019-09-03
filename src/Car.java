import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Car {
    private String model;
    private String number;
    private Client owner;


    public static final Comparator<Car> COMPARE_BY_MODEL = new Comparator<Car>() {
        @Override
        public int compare(Car model1, Car model2) {
            return model1.getModel().compareTo(model2.getModel());
        }
    };

    public static final Comparator<Car> COMPARE_BY_NUMBER = new Comparator<Car>() {
        @Override
        public int compare(Car model1, Car model2) {
            return model1.getNumber().compareTo(model2.getNumber());
        }
    };



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number.equals(car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public Car(String model, String number, Client owner) {
        this.model=model;
        this.number=number;
        this.owner=owner;
    }
    public Car(){}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Модель:"+model+","+" Номер:"+number+" ";
    }

}
