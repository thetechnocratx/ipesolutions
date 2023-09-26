//  Create an interface named Polygon. It has a default method getSides() and an abstract 
// method getArea().create two classes Rectangle and Square that implement Polygon. The 
// Rectangle class provides the implementation of the getArea() method and overrides the 
// getSides() method. the Square class only provides the implementation of the getArea() method.
// while calling the getSides() method using the Rectangle object, the overridden method is called.
// However, in the case of the Square object, the default method is called.

interface Polygon {
    void getArea();

    default void getSides() {
        System.out.println("I can get sides of polygon.");
    }
}

class Rectangle implements Polygon {
    public void getArea() {
        int length = 6;
        int breadth = 5;
        int area = length * breadth;
        System.out.println("The area of the rectangle is " + area);
    }

    public void getSides() {
        System.out.println("I have 4 sides.");
    }
}

class Square implements Polygon {
    public void getArea() {
        int length = 5;
        int area = length * length;
        System.out.println("The area of the square is " + area);
    }
}

class MainQ_41 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.getArea();
        r1.getSides();

        Square s1 = new Square();
        s1.getArea();
    }
}
