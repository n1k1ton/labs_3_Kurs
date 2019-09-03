import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Client {
    private Set<Car> cars;
    private String name;
    private String surname;
    private String login;
    public static Set<Client> clients=new HashSet<>();

    public Client(String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        cars=new HashSet<>();
        clients.add(this);
    }

    @Override
    public String toString() {
        return name+" "+surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return login.equals(client.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
    public void addClientsCar(String model,String number)
    {
        cars.add(new Car(model,number,this));
    }

    public Set<Car> getCars() {
        return cars;
    }
    public Car getCar(String number1)
    {
        Car res=null;
        for(Car car:cars)
        {
            if(car.getNumber().equals(number1)){
                res=car;break;}

            else
                res=null;
        }
        return res;
    }
}