package src;

import java.io.*;
import java.util.Scanner;

/**
 * this class is used to create new objects from parameters or field values from
 * csv files, and adds to their respective lists
 * 
 * @author Airat YUsuff 22831467
 *
 */
public class DataHandler {

	private String lineInFile;
	private Scanner customersFile;
	private Scanner parcelsFile;
	private int lineCount = 0;

	public DataHandler(String parcelsFilePath, String customersFilePath) throws FileNotFoundException {
		File file = new File(parcelsFilePath);
		parcelsFile = new Scanner(file);

		// one line
		customersFile = new Scanner(new File(customersFilePath));
		
	}

	/**
	 * reads each line from the file and save to string
	 * 
	 * @return boolean whether there is a next line available to read
	 * @throws IOException
	 */
	public boolean readNextLine(Scanner currentFile) throws IOException {
		boolean lineRead;
		lineRead = currentFile.hasNext();
		
		System.out.println(lineRead);

		if (lineRead) {
			lineInFile = currentFile.nextLine();
			lineCount++;
		}
		else System.out.println("here??");
		return lineRead;
	}

	/**
	 * reads every line of the csv file and creates properties with each line
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
//	public void importAllParcels(parcelList pList) throws IOException, Exception {
//		while (readNextLine(parcelsFile)) {
//			Parcel pc = createParcel(lineInFile);
//			pList
//		}
//		parcelsFile.close();
//	}
//
//	/**
//	 * create a new parcel using field values from a line read from the csv file,
//	 * and add to parcel list
//	 * 
//	 * @param lineInFile comma_separated fields in the current line
//	 * @throws Exception
//	 */
//	public Parcel createParcel(String lineInFile) throws Exception {
//		if (lineCount > 1) {
//			String[] fields = lineInFile.split(",");
//
//			// attempt to validate the fields in the csv file
//			Parcel pc = new Parcel(fields[0], fields[1], fields[2], fields[3]);
//			return pc;
//
//		}
//	}

	/**
	 * reads every line of the csv file and creates customers with each line
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
	public void importAllCustomers(CustomerList cList) throws IOException, Exception {
		while (readNextLine(customersFile)) {
			Customer c = createCustomer(lineInFile);
			cList.addCustomer(c);
			
		}
		customersFile.close();
	}

	/**
	 * create a new customer using field values from a line read from the csv file,
	 * and add to the list
	 * 
	 * @param lineInFile comma_separated fields in the current line
	 * @throws Exception
	 */
	public Customer createCustomer(String lineInFile) throws Exception {
			String[] fields = lineInFile.split(",");
			
			Customer c = new Customer(fields[1], lineCount);
			System.out.println(c.getName());
			
			return c;
	}


}
