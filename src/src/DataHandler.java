package src;

import java.io.*;
import java.util.Arrays;
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
	private String fileName;

	public DataHandler(String parcelsFilePath, String customersFilePath) throws FileNotFoundException {
		File file = new File(parcelsFilePath);
		parcelsFile = new Scanner(file);

		fileName = customersFilePath;
		// one line
		customersFile = new Scanner(new File(customersFilePath));

	}
	// needed mid program to process new claims
	public DataHandler(String customersFilePath) throws FileNotFoundException {
		fileName = customersFilePath;
		customersFile = new Scanner(new File(customersFilePath));
	}

	public Scanner getParcelsFilePath() {
		return parcelsFile;
	}

	public Scanner getCustomersFilePath() {
		return customersFile;
	}
	
	public String getLineInFile() {
		return lineInFile;
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
	public void importAllParcels() throws IOException, Exception {
		// skip header
		parcelsFile.nextLine();

		while (readNextLine(parcelsFile)) {
			Parcel pc = createParcel(lineInFile);
			if (pc != null) {
				ParcelList.addParcel(pc);
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
	public Parcel createParcel(String lineInFile) throws Exception {
		String[] fields = lineInFile.split(",");

		boolean parcelExists = false;
		for (Parcel parcel : ParcelList.getUncollectedParcels()) {
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

	public void createCollectionQueue(CollectionQueue cq) throws IOException, Exception {
		customersFile = new Scanner(new File(fileName));

		// skip header
		customersFile.nextLine();

		while (readNextLine(customersFile)) {
			ParcelClaim pc = createParcelClaim(lineInFile);
			cq.addParcelClaimToQueue(pc);
		}
		customersFile.close();
	}

	public ParcelClaim createParcelClaim(String lineInFile) throws Exception {
		try {
			ParcelClaim pc;
			String[] fields = lineInFile.split(",");

			if (fields.length > 3) {

				String[] allParcelIds = Arrays.copyOfRange(fields, 2, fields.length);

				// format rows with multiple parcel ids that will have the leading/trailing
				// quotes
				allParcelIds[0] = allParcelIds[0].replace("\"", "");
				allParcelIds[allParcelIds.length - 1] = allParcelIds[allParcelIds.length - 1].replace("\"", "");
				pc = new ParcelClaim(fields[1], allParcelIds);
			} else {
				String[] parcelId = { fields[2] };
				pc = new ParcelClaim(fields[1], parcelId);
			}
			return pc;

		} catch (Exception e) {
			System.out.println("an error occurred");
		}
		return null;

	}

	/**
	 * reads every line of the csv file and creates customers with each line
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
	public void importAllCustomers() throws IOException, Exception {
		// skip header
		customersFile.nextLine();

		while (readNextLine(customersFile)) {
			Customer c = createCustomer(lineInFile);
			if (c != null) {
				CustomerList.addCustomer(c);
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
	public Customer createCustomer(String lineInFile) throws Exception {
		String[] fields = lineInFile.split(",");

		// don't create duplicate customers
		boolean customerExists = false;
		for (Customer cust : CustomerList.getCustomers()) {
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
