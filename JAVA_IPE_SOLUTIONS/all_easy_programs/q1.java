abstract class Shape {
    float dim1, radius;

    abstract float area();
}

class Square extends Shape {
    Square(float d1) {
        dim1 = d1;
    }

    float area() {
        System.out.println("Area of Square is ");
        return dim1 * dim1;
    }
}

class Circle extends Shape {
    Circle(float d1) {
        radius = d1;
    }

    float area() {
        System.out.println("Area of Circle is ");
        return 3.14f * radius * radius;
    }
}

class q1 {
    public static void main(String arg[]) {
        Square s = new Square(2.4f);
        Circle c = new Circle(10.5f);

        System.out.println(s.area());
        System.out.println(c.area());

    }
}
