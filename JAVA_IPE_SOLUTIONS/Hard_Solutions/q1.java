// The abstract Vegetable class has three subclasses named Potato, Brinjal and Tomato. Write 
// an application that demonstrates how to establish this class hierarchy. Declare one instance 
// variable of type String that indicates the color of a vegetable. Create and display instances of 
// these objects. Override the toString() method of Object to return a string with the name of the
// vegetable and its color

abstract class Vegetable {
    public String color;
}

class Potato extends Vegetable {
    public String toString() {
        color = "Brown -skinned Color";
        return "potato -->" + color;
    }
}

class Brinjal extends Vegetable {
    public String toString() {
        color = "purple color";
        return "Brinjal -->" + this.color;
    }
}

class Tomato extends Vegetable {
    public String toString() {
        color = "red color";
        return "Tomato -->" + color;
    }
}

class veg_dis {
    public static void main(String[] args) {
        Potato p = new Potato();
        Brinjal b = new Brinjal();
        Tomato t = new Tomato();
        System.out.println(p);
        System.out.println(b);
        System.out.println(t);
    }
}
