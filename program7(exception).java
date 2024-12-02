class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

class Father {
    int fatherAge;


    public Father(int fatherAge) throws WrongAge {
        if (fatherAge < 0) {
            throw new WrongAge("Age cannot be negative for Father!");
        }
        this.fatherAge = fatherAge;
        System.out.println("Father's age is: " + this.fatherAge);
    }
}

class Son extends Father {
    int sonAge;


    public Son(int fatherAge, int sonAge) throws WrongAge, Exception {
        super(fatherAge); 


        if (sonAge >= fatherAge) {
            throw new Exception("Son's age cannot be greater than or equal to Father's age!");
        }
        this.sonAge = sonAge;
        System.out.println("Son's age is: " + this.sonAge);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Son son1 = new Son(40, 40);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Father father1 = new Father(-10);
        } catch (WrongAge e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Father father2 = new Father(45);
            Son son2 = new Son(45, 20);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
