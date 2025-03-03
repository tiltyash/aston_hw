class Bowl {
    private int availableFood = 0;

    public int getAvailableFood() {
        return availableFood;
    }

    public Bowl(int availableFood) {
        this.availableFood = availableFood;
    }

    public boolean eatFood(int portion) {
        if (availableFood >= portion) {
            availableFood -= portion;
            return true;
        } else {
            return false;
        }
    }

    public void addFood(int amount) {
        availableFood += amount;
        System.out.println("В миску добавлено " + amount + " еды. В миске: " + availableFood);
    }
}
