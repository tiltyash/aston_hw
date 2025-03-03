class Cat extends Animal {
    private static int catCount = 0;
    private int portion;
    private boolean isFull;

    public Cat(String name, int portion) {
        super(name);
        this.portion = portion;
        catCount++;
        this.isFull = false;
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean isFull() {
        return isFull;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println("Кот " + name + " не сможет пробежать более 200 метров");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать");
    }

    public void eat(Bowl bowl) {
        if (bowl.eatFood(portion)) {
            this.isFull = true;
            System.out.println(name + " теперь сытый");
        } else {
            System.out.println("В миске не хватило еды");
        }
    }
}
