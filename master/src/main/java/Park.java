import java.util.ArrayList;

public class Park {
    public class Attraction {
        String name;
        String openingHours;
        float price;

        public Attraction(String name, String openingHours, float price) {
            this.name = name;
            this.openingHours = openingHours;
            this.price = price;
        }

        public void printAttractionInformation() {
            System.out.println("===========");
            System.out.println("Название аттракциона: " + name);
            System.out.println("Рабочие часы: " + openingHours);
            System.out.println("Цена: " + price);
            System.out.println("===========");
        }
    }

        ArrayList<Attraction> attractionsList = new ArrayList<>();

        public void addAttraction(String name, String openingHours, float price) {
            attractionsList.add(new Attraction(name, openingHours, price));
        }

        public void showAttractions() {
            System.out.println("\n");
            if (attractionsList.isEmpty()) {
                System.out.println("Нужно посторить зиккурат");
            } else {
                for (Attraction attraction : attractionsList) {
                    attraction.printAttractionInformation();
                }
            }
        }

        public void showAttractionsCount() {
            System.out.println("Количество аттракционов: " + attractionsList.size());
        }
}
