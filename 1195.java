import java.util.concurrent.Semaphore;

class FizzBuzz {
    private int n;
    private Semaphore sem_f, sem_b, sem_fb, sem_n;

    public FizzBuzz(int n) {
        this.n = n;
        sem_f = new Semaphore(0);
        sem_b = new Semaphore(0);
        sem_fb = new Semaphore(0);
        sem_n = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 != 0) {
                sem_f.acquire();
                printFizz.run();
                sem_n.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i = 1; i <= n; i++) {
            if(i % 3 != 0 && i % 5 == 0) {
                sem_b.acquire();
                printBuzz.run();
                sem_n.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                sem_fb.acquire();
                printFizzBuzz.run();
                sem_n.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i++) {
            sem_n.acquire();
            if(i % 15 == 0) {
                sem_fb.release();
            } else if(i % 3 == 0) {
                sem_f.release();
            } else if(i % 5 == 0) {
                sem_b.release();
            } else {
                printNumber.accept(i);
                sem_n.release();
            }
        }
    }
}
