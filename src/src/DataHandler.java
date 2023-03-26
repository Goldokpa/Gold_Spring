package src;

import java.io.*;
import java.util.List;
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

	public Scanner getParcelsFilePath() {
		return parcelsFile;
	}

	public Scanner getCustomersFilePath() {
		return customersFile;
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

		if (lineRead) {
			lineInFile = currentFile.nextLine();
			lineCount++;
		}
		return lineRead;
	}

	/**
	 * reads every line of the csv file and creates properties with each line
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
	public void importAllParcels(ParcelList pList) throws IOException, Exception {
		// skip header
		parcelsFile.nextLine();

		while (readNextLine(parcelsFile)) {
			Parcel pc = createParcel(lineInFile, pList);
			if (pc != null) {
				pList.addParcel(pc);
			}
		}
//		parcelsFile.close();
	}

	/**
	 * create a new parcel using field values from a line read from the csv file,
	 * and add to parcel list
	 * 
	 * @param lineInFile comma_separated fields in the current line
	 * @throws Exception
	 */
	public Parcel createParcel(String lineInFile, ParcelList pList) throws Exception {
		String[] fields = lineInFile.split(",");

		boolean parcelExists = false;
		for (Parcel parcel : pList.getUncollectedParcels()) {
			if (parcel.getParcelId().equals(fields[0].trim())) {
				parcelExists = true;
				System.out.println("parcel exists");
				break;
			}
		}
		if (!parcelExists) {
			return new Parcel(fields[0], Integer.parseInt(fields[1]), Double.parseDouble(fields[2]), fields[3]);
		}
		return null;
	}

	public void createCollectionQueueForWorker(String customersFilePath, DepotWorker worker)
			throws IOException, Exception {
		File file = new File(customersFilePath);
		customersFile = new Scanner(file);

		// skip header
		customersFile.nextLine();
		
		while (readNextLine(customersFile)) {
			ParcelClaim pc = createParcelClaim(lineInFile);
			worker.addParcelClaimToQueue(pc);
		}
		customersFile.close();
	}

	public ParcelClaim createParcelClaim(String lineInFile) throws Exception {
		String[] fields = lineInFile.split(",");

		ParcelClaim pc = new ParcelClaim(fields[1], fields[2]);
		return pc;
	}

	/**
	 * reads every line of the csv file and creates customers with each line
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
	public void importAllCustomers(CustomerList cList) throws IOException, Exception {
		// skip header
		customersFile.nextLine();
		
		while (readNextLine(customersFile)) {
			Customer c = createCustomer(lineInFile, cList);
			if (c != null) {
				cList.addCustomer(c);
			}

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
	public Customer createCustomer(String lineInFile, CustomerList cList) throws Exception {
		String[] fields = lineInFile.split(",");

		// don't create duplicate customers
		boolean customerExists = false;
		for (Customer cust : cList.getCustomers()) {
			if (cust.getName().equals(fields[1].trim())) {
				customerExists = true;
				break;
			}
		}
		if (!customerExists) {
			return new Customer(fields[1], lineCount);
		}
		return null;
	}

}
