class Animal {
    protected String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) {
        if (distance == 0) {
            System.out.println("Хорошо стоим...");
        } else if (distance < 0) {
            System.out.println("Только вперед!");
        } else {
            System.out.println(name + " пробежал " + distance + " метров");
        }
    }

    public void swim(int distance) {
        if (distance == 0) {
            System.out.println("Я буёк");
        } else if (distance < 0) {
            System.out.println("Только вперед!");
        } else {
        System.out.println(name + " проплыл " + distance + " метров");
        }
    }
}
