package src;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CollectionQueue implements Runnable {
	// this data type allows the list to be modified while it is being iterated
	// through, used because of the scenario where more customers can join the
	// collection queue
	private ConcurrentLinkedQueue<ParcelClaim> queue;

	public CollectionQueue() {
		queue = new ConcurrentLinkedQueue<ParcelClaim>();
	}

	public synchronized ConcurrentLinkedQueue<ParcelClaim> getQueue() {
		return queue;
	}

	public void addParcelClaimToQueue(ParcelClaim p) {
		queue.add(p);
	}

	public void removeParcelClaimFromQueue(ParcelClaim p) {
		queue.remove(p);
	}

	public ParcelClaim getCurrentParcelClaimToProcess() {
		return queue.poll(); //this removes the first item on the queue and returns it
	}

	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void run() {
		try {
			// add new claims after all initial claims has been processed, TBD later
			Thread.sleep(15000);
			System.out.println("Now adding new claims");
			DataHandler dh = new DataHandler("./sample_c.csv");

			Scanner customerFile = dh.getCustomersFilePath();

			while (dh.readNextLine(customerFile)) {
				Customer c = dh.createCustomer(dh.getLineInFile());
				if (c != null) {
					CustomerList.addCustomer(c);
				}

				ParcelClaim pc = dh.createParcelClaim(dh.getLineInFile());
				this.addParcelClaimToQueue(pc);
				System.out.println("claim added - " + dh.getLineInFile());

				// wait for a random time before adding next customer claim to queue
				int waitTime = new Random().nextInt(10);
				Thread.sleep(waitTime * 1000);
			}
			customerFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
