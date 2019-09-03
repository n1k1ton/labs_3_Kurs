import java.time.LocalDateTime;
import java.util.*;

public class Main {



    public static void main(String[] args) {
        LocalDateTime dateTime;
        CarPark park = new CarPark();
        Client Nikita = new Client("Nikita", "Bolyak", "Nikita");
        Nikita.addClientsCar("Azda", "1234we");
        Nikita.addClientsCar("Bogdan", "BE8230AE");
        Nikita.addClientsCar("Audi", "BE4080FA");
        park.inOut(Nikita.getCar("1234we"),LocalDateTime.of(2019,3,3,10,10));
        park.inOut(Nikita.getCar("1234we"),LocalDateTime.of(2019,3,4,10,10));
        park.inOut(Nikita.getCar("BE8230AE"),LocalDateTime.of(2019,3,4,10,10));
        park.inOut(Nikita.getCar("BE4080FA"),LocalDateTime.of(2019,3,5,10,10));
        park.GetSortedCars(Car.COMPARE_BY_MODEL);
        //park.GetCars();
        /*ArrayList<Car> carsSort=new ArrayList<>(Nikita.getCars());
        Collections.sort(carsSort,Car.COMPARE_BY_MODEL);
        System.out.println(carsSort.toString());*/


        /*ArrayList<String> array=new ArrayList<String>();
        array.add("A");
        array.add("B");
        array.add("G");
        array.add("E");
        array.add("D");
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"one");
        map.put(3,"three");
        map.put(10,"ten");
        map.put(6,"six");
        map.put(2,"two");
        Collections.sort(array,alphabet);
        System.out.println(array.toString());*/

    }

}
