package homework4;

public class ABC {
    private final Object monitor = new Object();
    private final int PRINT_COUNT = 3;
    private char currentChar = 65;

    public void A() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    while (currentChar != 65) {
                        monitor.wait();
                    }
                    System.out.print("A");
                    currentChar = 66;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void B() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    while (currentChar != 66) {
                        monitor.wait();
                    }
                    System.out.print("B");
                    currentChar = 67;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void C() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < PRINT_COUNT; i++) {
                    while(currentChar != 67){
                        monitor.wait();
                    }
                    System.out.print("C");
                    currentChar = 65;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

