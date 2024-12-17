import java.util.*;
abstract class Account{
    protected int acc_no;
    protected int balance;
    private String type;
    protected Customer customer;
    Account(Customer customer,int acc_no,int balance,String type){
        this.acc_no = acc_no;
        this.balance = balance;
        this.type = type;
        this.customer = customer;
    }
    public int getAccNo(){
        return acc_no;
    }
    public int getBalance() {
        return balance;
    }
    public String getCustomer() {
        return customer.toString();
    }

    public void debitAmount(int amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public void creditAmount(int amount) {
        balance += amount;
    }

}
class SavingsAccount extends Account{
    private int minBal;
    SavingsAccount(Customer customer,int acc_no,int balance,int minBal){
        super(customer,acc_no,balance,"sb");
        this.minBal = minBal;
    }
    

}
class CurrentAccount extends Account{
    private int interestRate;
    CurrentAccount(int accNo, int balance, int interestRate,  Customer customer) {
        super(customer, accNo, balance,"cb");
        this.interestRate = interestRate;
    }
}
class Customer{
    private String name;
    private int cust_id;
    private long phone;
    Customer(String name,int cust_id, long phone){
        this.name = name;
        this.cust_id = cust_id;
        this.phone = phone;
    }
    public int getCustId(){
        return cust_id;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        return "Customer ID: " + cust_id + ", Name: " + name + ", Phone: " + phone;
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Manoj Kumar V",1,8754253549l);
        @SuppressWarnings("deprecation")
        Account account = new SavingsAccount(customer1,1234,50000,2000);
        System.out.println(account.getCustomer());
    }
}
