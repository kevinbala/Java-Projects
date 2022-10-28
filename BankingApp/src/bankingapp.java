import java.util.Scanner;


public class bankingapp {
	
	public static void main(String[] args) {
		
		BankAccount obj1 = new BankAccount("Kevin Bala","KB190201B");
		obj1.showMenu();
				
	}

}

class BankAccount{
	
	String CostumerName;
	String CostumerId;
	int Balance;
	int PreviousTransaction;
	
	BankAccount(String cname,String cid)
	{
		CostumerName = cname;
		CostumerId = cid;
	}
	
	void deposit(int ammount)
	{
		
		if(ammount !=0)
		{
			Balance = Balance + ammount;
			PreviousTransaction = ammount;
		}
	}
	
	void withdraw(int ammount)
	{
		if(ammount !=0)
		{
			Balance = Balance - ammount;
			PreviousTransaction = -ammount;
		}
	}
	
	void getPrevioustransaction()
	{
		if(PreviousTransaction > 0)
		{
			System.out.println("Deposited: "+PreviousTransaction);
		}
		else if(PreviousTransaction < 0)
		{
			System.out.println("Withdrawn: "+Math.abs(PreviousTransaction));
			}
		else
		{
			System.out.println("No transaction occured");
		}
	}
	void showMenu()
	{
		char option= '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome " +CostumerName);
		System.out.println("Your ID is " +CostumerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do
		{
			System.out.println("===========================================");
			System.out.println("Enter an option");
			System.out.println("===========================================");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			
			case 'A' :
				System.out.println("-----------------------------------------");
				System.out.println("Balance = "+Balance);
				System.out.println("-----------------------------------------");
				System.out.println("\n");
				break;
			
			case 'B' :
				System.out.println("-----------------------------------------");
				System.out.println("Enter an ammount to deposit:");
				System.out.println("-----------------------------------------");
				int ammount = scanner.nextInt();
				deposit(ammount);
				System.out.println("\n");
				break;
				
			case 'C' :
				System.out.println("-----------------------------------------");
				System.out.println("Enter an ammount to withdraw:");
				System.out.println("-----------------------------------------");
				int ammount2 = scanner.nextInt();
				withdraw(ammount2);
				System.out.println("\n");
				break;
				
			case 'D' :
				System.out.println("-----------------------------------------");
				getPrevioustransaction();
				System.out.println("-----------------------------------------");
				System.out.println("\n");
				break;
				
			case 'E' :
				System.out.println("-----------------------------------------");
				break;
				
				default:
					System.out.println("Invalid option!. Please try again");
					break;
			}
			
		}while(option != 'E');
		
		System.out.println("Thank you for using our bank");
	}
				
					
				
			
			
			
			
			
		
		
		
	}

