package homework4;

class Main {
    public static void main(String[] args) {
        ABC printABC = new ABC();
        Thread t1 = new Thread(() -> printABC.A());
        Thread t2 = new Thread(() -> printABC.B());
        Thread t3 = new Thread(() -> printABC.C());
        t1.start();
        t2.start();
        t3.start();
    }
}
