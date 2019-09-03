import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class CarPark {
    private Set<Car> cars = new HashSet<Car>();
    private Map<Car, Map<LocalDateTime, LocalDateTime>> journal = new HashMap<>();

    public CarPark() {
    }

    public void inOut(Car car, LocalDateTime dateTime) {
        int flag = 0;
        if (this.journal.get(car) == null) {
            Map<LocalDateTime, LocalDateTime> temp = new TreeMap<>();
            temp.put(dateTime, null);
            this.journal.put(car, temp);
            cars.add(car);
        } else {
            for (Map.Entry<LocalDateTime, LocalDateTime> temp1 : this.journal.get(car).entrySet()) {
                if (temp1.getValue() == null) {
                    this.journal.get(car).put(temp1.getKey(), dateTime);
                    flag++;
                    break;
                }
            }
            if (flag == 0) {
                journal.get(car).put(dateTime, null);
            }
        }
    }

    public void GetCars() {
        for (Car carsParking : cars) {
            System.out.println(carsParking.toString() + " Владелец:" + carsParking.getOwner().toString());
        }
    }

    public void GetClientInfo(Client client) {
        System.out.println(client.toString());
        System.out.println("Машини:");
        for (Car clientCar : client.getCars()) {
            if (client.getCars().isEmpty())
                System.out.println("Машин нет");
            else {
                System.out.println(clientCar.toString());
                if (this.journal.get(clientCar) != null) {
                    for (Map.Entry<LocalDateTime, LocalDateTime> e : journal.get(clientCar).entrySet()) {
                        if (e.getValue() == null)
                            System.out.println("      C " + e.getKey().toString() + " до " + "Еще в парке;");
                        else
                            System.out.println("      C " + e.getKey().toString() + " до " + e.getValue().toString());
                    }
                }
                else
                    System.out.println("Машина никогда не была в парке!!!");
            }
        }
    }

    public void GetCarInfo(Car car)
    {
        System.out.println(car.toString()+"\n"+"Владелец:"+car.getOwner().toString());
        for(Map.Entry<LocalDateTime,LocalDateTime>temp:journal.get(car).entrySet())
        {
            if (temp.getValue() == null)
                System.out.println("      C " + temp.getKey().toString() + " до " + "Еще в парке;");
            else
                System.out.println("      C " + temp.getKey().toString() + " до " + temp.getValue().toString());
        }
    }

    public float CountPrice(Client client, LocalDateTime start, LocalDateTime end, float rate)
    {
        float price=0;
        for(Map.Entry<Car,Map<LocalDateTime,LocalDateTime>> temp:journal.entrySet())
        {
            if(start.isBefore(end))
            {
                for(Car car:client.getCars())
                {
                    if(temp.getKey()==car)
                    {
                        for(Map.Entry<LocalDateTime,LocalDateTime> temp2:temp.getValue().entrySet())
                        {
                            if(temp2.getValue()!=null)
                            {
                                Duration dur=Duration.between(temp2.getValue(),temp2.getKey());
                                price+=dur.toMinutes();
                            }

                        }
                    }
                }
            }
        }
        return Math.abs(price/60*rate);
    }

    public void GetSortedCars(Comparator<Car> COMPARE)
    {
        ArrayList<Car> carsSort=new ArrayList<>(cars);
        Collections.sort(carsSort,COMPARE);
        System.out.println(carsSort.toString());
    }


}
