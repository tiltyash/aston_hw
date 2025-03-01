import javax.sound.midi.Soundbank;

public class Good {
    String name;
    String dateOfProduction;
    String manufacturer;
    String countryOfOrigin;
    float price;
    boolean reservationStatus;

    public Good(String name, String dateOfProduction, String manufacturer, String countryOfOrigin, float price, boolean reservationStatus) {
        this.name = name;
        this.dateOfProduction = dateOfProduction;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.reservationStatus = reservationStatus;
    }

    public void printGoodInformation() {
        System.out.println("==============================");
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + dateOfProduction);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Статус бронирования - " + reservationStatus);
        System.out.println("==============================");
    }
}
