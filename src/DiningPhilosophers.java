public class DiningPhilosophers {
    public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        Object[] forks = new Object[numberOfPhilosophers];

        for (int i = 0; i < numberOfPhilosophers; i++) {
            forks[i] = new Object(); // Each fork is an individual lock
        }

        for (int i = 0; i < numberOfPhilosophers; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % numberOfPhilosophers];
            philosophers[i] = new Philosopher(i, leftFork, rightFork);
            philosophers[i].start();//test
        }
    }
}