class Cat {

    String name;
    int age;
    static int counter;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
        if (counter > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        return counter;
    }

//    public static void main(String[] args) {
//        Cat cat1 = new Cat("Cat1" , 1);
//        Cat cat2 = new Cat("Cat2" , 1);
//        Cat cat3 = new Cat("Cat3" , 1);
//        Cat cat4 = new Cat("Cat4" , 1);
//        Cat cat5 = new Cat("Cat5" , 1);
//        Cat cat6 = new Cat("Cat6" , 1);
//        Cat cat7 = new Cat("Cat7" , 1);
//        System.out.println(getNumberOfCats());
//    }
}