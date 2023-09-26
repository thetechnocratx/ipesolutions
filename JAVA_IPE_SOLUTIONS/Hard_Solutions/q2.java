//  The Transport interface declares a deliver() method. The abstract class Animal is the 
// superclass of the Tiger, Camel, Deer and Donkey classes. The Transport interface is 
// implemented by the Camel and Donkey classes. Write a test program that initialize an array of 
// four Animal objects. If the object implements the Transport interface, the deliver() method is 
// invoked.

interface transport {
    void deliver();
}

abstract class animal {
    String name;

    public abstract void show_detail();

    public void display() {
    }
}

class tiger extends animal {
    tiger() {
        name = "tiger";
    }

    public void show_detail() {
        System.out.println("This is the " + name + " Object!");
    }

    public void display() {
        show_detail();
    }
}

class camel extends animal implements transport {

    camel() {
        name = "camel";
    }

    public void show_detail() {
        System.out.println("This is the " + name + " Object!");
    }

    public void deliver() {
        System.out.println("This animal is harmless and can be used for transport!");
    }

    public void display() {
        show_detail();
        deliver();
    }

}

class deer extends animal {

    deer() {
        name = "deer";
    }

    public void show_detail() {
        System.out.println("This is the " + name + " Object!");
    }

    public void display() {
        show_detail();
    }

}

class donkey extends animal implements transport {

    donkey() {
        name = "donkey";
    }

    public void show_detail() {
        System.out.println("This is the " + name + " Object!");
    }

    public void deliver() {
        System.out.println("This animal is harmless and can be used for transport!");
    }

    public void display() {
        show_detail();
        deliver();
    }
}

public class q2 {
    public static void main(String args[]) {
        animal a1[] = new animal[4];

        tiger t = new tiger();
        donkey don = new donkey();
        deer de = new deer();
        camel c = new camel();

        a1[0] = t;
        a1[0].display();
        a1[1] = don;
        a1[1].display();
        a1[2] = de;
        a1[2].display();
        a1[3] = c;
        a1[3].display();

    }

}