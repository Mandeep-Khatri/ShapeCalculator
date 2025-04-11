import java.util.Scanner;

interface Shape {
    void getInputs();
    void displayProperties();
}

abstract class Shape2D implements Shape {
    abstract double calculateArea();
    abstract double calculatePerimeter();

    public void displayProperties() {
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}

abstract class Shape3D implements Shape {
    abstract double calculateSurfaceArea();
    abstract double calculateVolume();

    public void displayProperties() {
        System.out.println("Surface Area: " + calculateSurfaceArea());
        System.out.println("Volume: " + calculateVolume());
    }
}

// 2D Shapes

class Circle extends Shape2D {
    double radius;

    public void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        radius = sc.nextDouble();
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape2D {
    double length, width;

    public void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        length = sc.nextDouble();
        System.out.print("Enter width: ");
        width = sc.nextDouble();
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape2D {
    double a, b, c;

    public void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side a: ");
        a = sc.nextDouble();
        System.out.print("Enter side b: ");
        b = sc.nextDouble();
        System.out.print("Enter side c: ");
        c = sc.nextDouble();

        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Invalid triangle! Please restart and enter valid side lengths.");
            a = b = c = 0;
        }
    }

    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double calculatePerimeter() {
        return a + b + c;
    }
}

class Trapezoid extends Shape2D {
    double a, b, side1, side2, height;

    public void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base a: ");
        a = sc.nextDouble();
        System.out.print("Enter base b: ");
        b = sc.nextDouble();
        System.out.print("Enter height: ");
        height = sc.nextDouble();
        System.out.print("Enter side 1: ");
        side1 = sc.nextDouble();
        System.out.print("Enter side 2: ");
        side2 = sc.nextDouble();
    }

    public double calculateArea() {
        return 0.5 * (a + b) * height;
    }

    public double calculatePerimeter() {
        return a + b + side1 + side2;
    }
}

class Pentagon extends Shape2D {
    double side;

    public void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side length: ");
        side = sc.nextDouble();
    }

    public double calculateArea() {
        return (5 * side * side) / (4 * Math.tan(Math.PI / 5));
    }

    public double calculatePerimeter() {
        return 5 * side;
    }
}

class Other2D extends Shape2D {
    public void getInputs() {
        System.out.println("This is a placeholder for a custom 2D shape.");
    }

    public double calculateArea() {
        return 0;
    }

    public double calculatePerimeter() {
        return 0;
    }
}

// 3D Shapes

class Cone extends Shape3D {
    double radius, height;

    public void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        radius = sc.nextDouble();
        System.out.print("Enter height: ");
        height = sc.nextDouble();
    }

    public double calculateSurfaceArea() {
        double slant = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slant);
    }

    public double calculateVolume() {
        return (1.0 / 3) * Math.PI * radius * radius * height;
    }
}

class Cylinder extends Shape3D {
    double radius, height;

    public void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        radius = sc.nextDouble();
        System.out.print("Enter height: ");
        height = sc.nextDouble();
    }

    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    public double calculateVolume() {
        return Math.PI * radius * radius * height;
    }
}

class Pyramid extends Shape3D {
    double base, height;

    public void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base length: ");
        base = sc.nextDouble();
        System.out.print("Enter height: ");
        height = sc.nextDouble();
    }

    public double calculateSurfaceArea() {
        double slant = Math.sqrt((base / 2) * (base / 2) + height * height);
        return base * base + 2 * base * slant;
    }

    public double calculateVolume() {
        return (1.0 / 3) * base * base * height;
    }
}

class Other3D extends Shape3D {
    public void getInputs() {
        System.out.println("This is a placeholder for a custom 3D shape.");
    }

    public double calculateSurfaceArea() {
        return 0;
    }

    public double calculateVolume() {
        return 0;
    }
}

// Main System

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape shape = null;

        System.out.println("Welcome to the Shape Calculator!");
        System.out.println("1. 2-D Shapes");
        System.out.println("2. 3-D Shapes");
        System.out.print("Choose category: ");
        int category = sc.nextInt();

        if (category == 1) {
            System.out.println("A. Circle");
            System.out.println("B. Rectangle");
            System.out.println("C. Triangle");
            System.out.println("D. Trapezoid");
            System.out.println("E. Pentagon");
            System.out.println("F. Others");
            System.out.print("Choose shape: ");
            char choice = sc.next().toUpperCase().charAt(0);

            switch (choice) {
                case 'A': shape = new Circle(); break;
                case 'B': shape = new Rectangle(); break;
                case 'C': shape = new Triangle(); break;
                case 'D': shape = new Trapezoid(); break;
                case 'E': shape = new Pentagon(); break;
                case 'F': shape = new Other2D(); break;
                default: System.out.println("Shape not implemented.");
            }

        } else if (category == 2) {
            System.out.println("A. Cone");
            System.out.println("B. Cylinder");
            System.out.println("C. Pyramid");
            System.out.println("D. Others");
            System.out.print("Choose shape: ");
            char choice = sc.next().toUpperCase().charAt(0);

            switch (choice) {
                case 'A': shape = new Cone(); break;
                case 'B': shape = new Cylinder(); break;
                case 'C': shape = new Pyramid(); break;
                case 'D': shape = new Other3D(); break;
                default: System.out.println("Shape not implemented.");
            }

        } else {
            System.out.println("Invalid category.");
        }

        if (shape != null) {
            shape.getInputs();
            shape.displayProperties();
        }
    }
}