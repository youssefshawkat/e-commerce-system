package system;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name,double balance){
        this.name = name;
        this.balance = balance;
    }
    public boolean canAfford(double amount){
        return balance >= amount;
    }
    public void makePayment(double amount){
        System.out.println("Transaction Completed Successfully");
        balance-=amount;
        System.out.println("Remaining Balance : " + balance);
    }
    public double getBalance() { return balance; }
    public String getName() {return name;}
    public void setBalance(double amount){balance = amount;}
    public void setName(String name){this.name = name;}
    
}
