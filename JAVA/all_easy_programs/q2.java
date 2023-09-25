abstract class Shape {
    float dim1, dim2, radius;

    abstract float area();
}

class Triangle extends Shape {
    Triangle(float d1, float d2) {
        dim1 = d1;
        dim2 = d2;
    }

    float area() {
        System.out.println("Area of Triangle is ");
        return (dim1 * dim2) / 2;
    }
}

class Rectangle extends Shape {
    Rectangle(float d1, float d2) {
        dim1 = d1;
        dim2 = d2;
    }

    float area() {
        System.out.println("Area of Rectangle is ");
        return dim1 * dim2;
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

class Q_32 {
    public static void main(String arg[]) {
        Triangle t = new Triangle(4.3f, 5.3f);
        Rectangle r = new Rectangle(2.4f, 4.2f);
        Circle c = new Circle(10.5f);

        System.out.println(t.area());
        System.out.println(r.area());
        System.out.println(c.area());

    }
}
