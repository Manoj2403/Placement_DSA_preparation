
// package Bank Management;
import java.util.*;

class Customer {
    private static int id = 1;
    private int customerId;
    private String customerName;
    private long phoneNo;
    private int age;

    Customer(String name, int age, long phoneNo) {
        this.customerId = id++;
        this.customerName = name;
        this.phoneNo = phoneNo;
        this.age = age;
    }

    public static int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public int getAge() {
        return age;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", phoneNo=" + phoneNo
                + ", age=" + age + "]";
    }

}

class Account {
    private long accNo;
    private Customer customer;
    private String accType;
    private int balance;
    private static Scanner sc = new Scanner(System.in);

    public Account(long accNo, int minBal, String accType) {
        this.accNo = accNo;
        this.balance = minBal;
        this.accType = accType;
    }

    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addCustomer() {
        System.out.println("Enter Customer Details :");
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        // sc.nextLine();
        System.out.print("Enter Age : ");
        int age = sc.nextInt();
        System.out.print("Enter Mobile No : ");
        long phoneNo = sc.nextLong();
        customer = new Customer(name, age, phoneNo);
        System.out.println(customer.getCustomerName() + " Customer Added Successfully..");
    }

    public void updateCustomerName() {
        String oldName = customer.getCustomerName();
        System.out.println("Enter Name to Update : ");
        String newName = sc.nextLine();
        customer.setCustomerName(newName);
        System.out.println(oldName + " name Updated Successfully to " + customer.getCustomerName() + ".");
    }

    public void updatePhoneNo() {
        long oldPhoneNo = customer.getPhoneNo();
        System.out.println("Enter Mobile Number to Update : ");
        long newPhoneNo = sc.nextLong();
        customer.setPhoneNo(newPhoneNo);
        System.out.println(oldPhoneNo + " Mobile Number Updated Successfully to " + customer.getPhoneNo() + ".");
    }

    public boolean checkLimit(int amount) {
        // System.out.println("Enter the Amount : (Between 2000 to 40000) ");
        return amount >= 2000 && amount <= 40000;
    }

    @Override
    public String toString() {

        return "Account No : " + getAccNo() + "\n"
                + "Account Type : " + getAccType() + "\n"
                + "Account Holder Name : " + customer.getCustomerName() + "\n"
                + "Account Balance : " + getBalance() + "\n"
                + "Account Holder Age : " + customer.getAge() + "\n"
                + "Account Holder Phone Number : " + customer.getPhoneNo();

    }

}

class Bank {
    private ArrayList<Account> accountList;
    private long totalAmount;
    private static Scanner sc;

    Bank() {
        accountList = new ArrayList<>();
        sc = new Scanner(System.in);
        totalAmount = 0;
        System.out.println("Bank Object Created Successfully.");
    }

    public void createAccount() {
        System.out.println("Enter Account Details : (AccNo)");
        long accNo = sc.nextLong();
        int minBal = 0;
        while(minBal<2000){
            System.out.println("Enter Mnimum Balance : ");
            minBal = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Enter Account Type : ");
        String accType = sc.nextLine();
        Account account = new Account(accNo, minBal, accType);
        account.addCustomer();
        accountList.add(account);
    }

    public void displayAccount() {
        if(accountList.size()<1)
        {
            System.out.println("No Account Added...");
            return ;
        }
        for (Account account : accountList) {
            System.out.println(account);
            System.out.println("-------------------------------");
        }
    }

    private Account checkAcc(long accNo) {
        for (Account currAccount : accountList) {
            if (currAccount.getAccNo() == accNo) {
                return currAccount;
            }
        }
        return null;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void deposit(long accNo) {
        Account currAccount = checkAcc(accNo);
        if (currAccount != null) {
            System.out.println("😘Welcome " + currAccount.getCustomer().getCustomerName() + "!");
            while (true) {
                System.out.println("Enter the Amount : (Between 2000 to 40000) ");
                int amount = sc.nextInt();
                if (currAccount.checkLimit(amount)) {
                    currAccount.setBalance(currAccount.getBalance() + amount);
                    setTotalAmount(totalAmount + amount);
                    System.out.println(currAccount.getCustomer().getCustomerName()+" - " +currAccount.getAccNo() + " Amount Added Successfully.");
                    System.out.println("Available Balance : "+currAccount.getBalance());
                    break;
                } else {
                    System.out.println("Enter Valid Amount....");
                }
            }
        } else {
            System.out.println("Account Number no Longer Available...");
        }
    }

    public void withdraw(long accNo) {
        Account currAccount = checkAcc(accNo);
        if (currAccount != null) {
            while (true) {
                System.out.println("Enter the Amount : (Between 2000 to 40000) ");
                int amount = sc.nextInt();
                if (currAccount.checkLimit(amount)) {
                    if (currAccount.getBalance() >= amount) {
                        System.out.println(amount + " Amount Withdrawed Successfully to "
                                + currAccount.getCustomer().getCustomerName());
                        currAccount.setBalance(currAccount.getBalance() - amount);
                        setTotalAmount(totalAmount - amount);
                    } else {
                        System.out.println("Available Balance : " + currAccount.getBalance());
                    }
                    break;
                }
            }
            System.out.println(currAccount);
        } else {
            System.out.println("Account No Longer Available...");
        }
    }

}

public class BankManagement {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1-Add Account\n"
                    + "2-Deposit\n"
                    + "3-Withdraw\n"
                    + "4-Display\n"
                    +"5-Exit");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    bank.createAccount();
                    break;

                case 2:
                    System.out.print("Enter Account Number to Deposit: ");
                    long accNoDeposit = sc.nextLong();
                    bank.deposit(accNoDeposit);
                    break;

                case 3: 
                    System.out.print("Enter Account Number to Withdraw: ");
                    long accNoWithdraw = sc.nextLong();
                    bank.withdraw(accNoWithdraw);
                    break;

                case 4: 
                    bank.displayAccount();
                    break;

                case 5: 
                    System.out.println("Thank you for using Bank Management System. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again!");
            }
        }
    }
}
