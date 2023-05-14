class Philosopher extends Thread {
    private int id;
    private Object leftFork;
    private Object rightFork;

    public Philosopher(int id, Object leftFork, Object rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() {
        try {
            System.out.println("Philosopher " + id + " is thinking");
            Thread.sleep((int) (Math.random() * 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        synchronized (leftFork) {
            System.out.println("Philosopher " + id + " picked up left fork");
            synchronized (rightFork) {
                System.out.println("Philosopher " + id + " picked up right fork and is eating");
                try {
                    Thread.sleep((int) (Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Philosopher " + id + " finished eating");
            }
            System.out.println("Philosopher " + id + " put down right fork");
        }
        System.out.println("Philosopher " + id + " put down left fork");
    }
//test
    public void run() {
        while (true) {
            think();
            eat();
        }
    }
}
