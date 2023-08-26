import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class ClientServerPractice {
	
	public static final MessageHolder messageHolder = new MessageHolder();
	public static final Semaphore semaphore = new Semaphore(1);
	
	public static void main(String[] args) {
		
	
		Thread clientThread = new Thread(new Client());
		Thread serverThread = new Thread(new Server());
		
		clientThread.start();
		
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		serverThread.start();
	}
	
	static class Server implements Runnable
	{
		public void run()
		{
			try {
				semaphore.acquire();
				System.out.println("---------------");
				
				String message = messageHolder.getMessage();
				
				System.out.println("Server Recieved Message = "+message);
				
				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static class Client implements Runnable
	{
		public void run()
		{
			Scanner sc = new Scanner(System.in);
			
			try {
				semaphore.acquire();
				System.out.println("Enter a Message : ");
				String message = sc.nextLine();
				
				messageHolder.setMessage(message);
				
				System.out.println("Message Sent to Server!");
				
				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	static class MessageHolder
	{
		private String message ;
		
		synchronized void setMessage(String message)
		{
			this.message = message;
		}
		
		synchronized String getMessage()
		{
			return message;
		}
	}
}
