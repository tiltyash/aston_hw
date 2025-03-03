interface Figure {
    default double calculatePerimeter() {
        return 0.0;
    }
    String getFillColor();
    String getBorderColor();
    double calculateArea();
    }
