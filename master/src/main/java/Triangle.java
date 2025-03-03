class Triangle implements Figure {
    private double side1;
    private double side2;
    private double side3;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double calculateArea() {

        return Math.sqrt(calculatePerimeter() / 2 * (calculatePerimeter() / 2 - side1) * (calculatePerimeter() / 2 -
                side2) * (calculatePerimeter() / 2 - side3));
    }
}
