import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
	static Contact c = new Contact(); 
	static Map<String, Contact> addressBook = new HashMap<String, Contact>();
	public static void main(String[] args) {
		boolean running = true; 
		while(running) {
			System.out.println("What would you like to do?");
			System.out.println("1: Add a contact, 2: Search for a contact, 3: Remove a contact, 4: Edit a contact, 5 Quit");
			Scanner input = new Scanner(System.in);
			int number = input.nextInt();
			if (number == 1) { // adds a contact
				addContact(); 
			}
			if (number == 2) { // searches for contacts
				searchContact(); 
			}
			if (number == 3) {//
				removeContact(); 
			}
			if (number == 4) {
				editContact();
			}
			if (number == 5) {
				running = false;
				System.out.println("Goodbye");
			}
			if (number <=0 || number >=6) {
				System.out.println("Please enter a vaid number");
				System.out.println("1: Add a contact, 2: Search for a contact, 3: Remove a contact, 4: Edit a contact, 5 Quit");
			}

		}
	}

	public static void addContact() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first name of the contact");
		String fName = input.nextLine();
		System.out.println("Enter the last name of the contact");
		String lName = input.nextLine();
		System.out.println("Enter the phone number of the contact");
		String phone = input.nextLine();

		Contact c = new Contact(fName,lName,phone);
		addressBook.put(c.getKey(), c); 
		System.out.println("Contact added!");
	}
	public static void searchContact() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter search: " );
		String searchVal = input.nextLine();
		Boolean found = false;
		for (String key : addressBook.keySet()){
			if (key.contains(searchVal)){
				System.out.println(addressBook.get(key) + "\n");
				found = true;
			}
		}
		if (!found)
			System.out.println("No Contact was found...");
	}

	public static void removeContact() {
		System.out.println("Which contact would you like to remove?");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter search: " );
		String searchVal = input.nextLine();
		Boolean found = false;
		for (String key : addressBook.keySet()){
			if (key.contains(searchVal)){
				c = addressBook.get(key);
				found = true;
				break; 
			}
		}
		if (!found)
			System.out.println("No Contact was found...");
		else {
			System.out.println("Is this the contact you want to delete? " + c.toString());
			System.out.println("Type 1 to delete, or Type 2 to cancel");
			int number = input.nextInt();
			if(number==1) {
				addressBook.remove(c.getKey(),c);
				System.out.println("Contact has been deleted");
			}
			else {
				System.out.println("Contact has not been deleted");
			}
		}
	}
	public static void editContact() {
		System.out.println("Which contact would you like to edit?");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter search: " );
		String searchVal = input.nextLine();
		Boolean found = false;
		for (String key : addressBook.keySet()){
			if (key.contains(searchVal)){
				c = addressBook.get(key);
				found = true;
				break; 
			}
		}
		if (!found)
			System.out.println("No Contact was found...");
		else {
			System.out.println("Is this the contact you want to edit? " + c.toString());
			System.out.println("Type 1 to edit first name, Type 2 to edit last name, Type 3 to edit phonenumber, or Type 4 to cancel");
			int number = input.nextInt();
			if(number==1) {
				Scanner name = new Scanner(System.in);
				addressBook.remove(c.getKey(),c);
				String templName = c.getlName();
				String tempPhone = c.getPhone(); 
				System.out.println("Enter new first name");
				String tempFname = name.nextLine();
				Contact newc =  new Contact(tempFname,templName,tempPhone); 
				addressBook.put(newc.getKey(), newc);
				System.out.println("Contact has been edited");
			}
			if (number == 2) {
				Scanner name = new Scanner(System.in);
				addressBook.remove(c.getKey(),c);
				String tempFName = c.getfName();
				String tempPhone = c.getPhone(); 
				System.out.println("Enter new last name");
				String tempLname = name.nextLine();
				Contact newc =  new Contact(tempFName,tempLname,tempPhone);
				addressBook.put(newc.getKey(), newc);
				System.out.println("Contact has been edited");
			}
			if (number == 3) {
				Scanner name = new Scanner(System.in);
				addressBook.remove(c.getKey(),c);
				String tempFName = c.getfName();
				String tempLname = c.getlName();
				System.out.println("Enter new phone number");
				String tempPhone = name.nextLine();
				Contact newc =  new Contact(tempFName,tempLname,tempPhone);
				addressBook.put(newc.getKey(), newc);
				System.out.println("Contact has been edited");
			}
			else if (number <1 || number >3) {
				System.out.println("Contact has not been edited");
			}
		}
	}
}