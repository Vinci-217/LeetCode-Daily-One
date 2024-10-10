class FooBar {
    private int n;

    private ReentrantLock lock = new ReentrantLock();
    private boolean flag = true;
    private Condition condition = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n;) {
            lock.lock();
            try {
                if (!flag) {
                    condition.await();
                }
                printFoo.run();
                flag = false;
                i++;
                condition.signal();

            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n;) {

            // printBar.run() outputs "bar". Do not change or remove this line.

            lock.lock();
            try {
                if (flag) {
                    condition.await();
                }
                printBar.run();
                flag = true;
                i++;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}