package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

//abstract class Account
abstract class Account {
    public abstract float getBalance();
}

//child class DepositeAccount of super-class Account
class DepositeAccount extends Account {
    private String accountNo;
    private float accountBalance;

    //public constructor
    public DepositeAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    //getter getBalance
    public float getBalance() {
        return accountBalance;
    }
}

//child class SavingAccount of super-class Account
class SavingAccount extends Account {
    private String accountNo;
    private float accountBalance;

    //public constructor
    public SavingAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    //getter getBalance()
    public float getBalance() {
        return accountBalance;
    }
}

//child class CompositeAccount of super-class Account
class CompositeAccount extends Account {
    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();


    //getter getBalance()
    public float getBalance() {
        totalBalance = 0;
        for (Account f : accountList) {
            totalBalance = totalBalance + f.getBalance();
        }
        return totalBalance;
    }

    //void method to addAccount
    public void addAccount(Account acc) {
        accountList.add(acc);
    }

    //void method to removeAccount
    public void removeAccount(Account acc) {
        accountList.add(acc);
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        CompositeAccount component = new CompositeAccount();

        //creation different accounts
        component.addAccount(new DepositeAccount("DA001", 100));
        component.addAccount(new DepositeAccount("DA002", 150));
        component.addAccount(new SavingAccount("SA001", 200));

        //print out total balance off account
        float totalBalance = component.getBalance();
        System.out.println("Total Balance : " + totalBalance);
    }
}