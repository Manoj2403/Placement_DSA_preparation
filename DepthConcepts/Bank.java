class BankAccount{
    String name;
    int amount;
    BankAccount(String name,int amount){
        this.name = name;
        this.amount = amount;
    }
    public synchronized void deposit(int amt){
        this.amount += amt;
        System.out.println(Thread.currentThread().getName()+" Deposited is "+amt);
    }
    public synchronized int withdraw(int amt){
        if(amt>this.amount){
            return 0;
        }
        amount = amount-amt;
        System.out.println(Thread.currentThread().getName()+" withdrawed "+amt);
        return amt;
    }
    public synchronized int getBalance(){
        System.out.println(Thread.currentThread().getName()+" Balance is "+amount);
        return this.amount;
    }
}
class MyThread extends Thread{
    BankAccount bankAccount;
    MyThread(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }
    public void run(){
        bankAccount.withdraw(10000);
        bankAccount.deposit(20000);
        bankAccount.getBalance();
    }
}
public class Bank{
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("Manoj", 1200000);
        MyThread mt1 = new MyThread(bankAccount);
        MyThread mt2 = new MyThread(bankAccount);
        // MyThread mt3 = new MyThread(bankAccount);
        // MyThread mt4 = new MyThread(bankAccount);
        // MyThread mt5 = new MyThread(bankAccount);
        // MyThread mt6 = new MyThread(bankAccount);
        mt1.start();
        mt2.start();
        // mt3.start();
        // mt4.start();
        // mt5.start();
        // mt6.start();

    }
}

/* All the Threads accessing the Single BankAccount
 * synchronized should be used then only current thread get the lock of the object and executes them
 */