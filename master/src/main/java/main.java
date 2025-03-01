public class main {
    public static void main(String[] args) {
        Good[] GoodsArr = new Good[5];

        GoodsArr[0] = new Good("Беленькая", "01.01.2025", "Полный расколбас", "Россия", 100f, true);
        GoodsArr[1] = new Good("Охота крепкое", "01.02.2025", "Полный расколбас", "Россия", 30f, true);
        GoodsArr[2] = new Good("Сервелат Русский богатырь", "20.02.2025", "Полный расколбас", "Россия", 120f, true);
        GoodsArr[3] = new Good("Хлеб Бородинский", "01.03.2025", "Обжора", "Америка", 25f, false);
        GoodsArr[4] = new Good("Сыр Маасдам", "25.02.2025", "Cheese Gmbh", "Голландия", 250f, false);
        GoodsArr[3].printGoodInformation();
        GoodsArr[1].printGoodInformation();

        Park park = new Park();
        park.showAttractionsCount();
        park.showAttractions();
        park.addAttraction("Ромашка", "9:00 - 21:00", 100f);
        park.showAttractions();
        park.showAttractionsCount();
    }
}
