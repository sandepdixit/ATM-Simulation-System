import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Aggregates from transaction
public class Account 
{

	private double balance;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();


	public Account()
	{
		balance = 0;
		transactions = new ArrayList<Transaction>();
	}

	public double getBalance() 
   {
		return balance;
	}
	
	public void deposit(double amount) throws IOException {
	 //  FileWriter fw=new FileWriter("C:\\Users\\dell\\IdeaProjects\\ATM simulation system\\src\\bank.txt");

      balance += amount;
		//fw.write((int) balance);
      transactions.add(new Transaction(amount, "Deposit"));
   }
   
   public void withdraw(double amount)
   {
      if(amount>balance)
         System.out.println("Insufficient funds in account.");
      else
      {
         balance -= amount;
         transactions.add(new Transaction(amount, "Withdrawal"));
      }
   }

	public void printTransactionHistory()
	{
      System.out.println("There have been transactions.\nLatest transaction: ");
	}
	
	public String showTransactionLogs()
	{
		String list = "";
		for (Transaction transactions: transactions)
		{
			list = list + transactions.getSummaryLine() + "\n";
		}
		
		return list;
	}

}
