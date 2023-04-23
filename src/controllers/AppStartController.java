package controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.ReadOnlyStringWrapper;
import src.CollectionQueue;
import src.CustomerList;
import src.DataHandler;
import src.DepotWorker;
import src.Parcel;
import src.ParcelClaim;
import src.ParcelList;

/**
 * the class controls the home page of the application where the user logs in.
 * Includes user input validation
 * 
 * @author Airat YUsuff 22831467
 *
 */
public class AppStartController {

	@FXML
	private Button startBtn;
	@FXML
	private TableView<ParcelClaim> collectionTable;
	@FXML
	private TableView<Parcel> allUncollectedParcels;
	@FXML
	private TableColumn<ParcelClaim, Integer> sequenceNo;
	@FXML
	private TableColumn<ParcelClaim, String> customerName;
	@FXML
	private TableColumn<ParcelClaim, String> parcelIds;
	@FXML
	private TableColumn<Parcel, String> parcelId;
	@FXML
	private TableColumn<Parcel, Integer> daysInDepot;
	@FXML
	private TableColumn<Parcel, Double> weight;
	@FXML
	private TableColumn<Parcel, String> dimensions;
	
	ObservableList<ParcelClaim> queueView; //for easy updating of the queue view
	ObservableList<Parcel> parcelsView; //for easy updating of the parcels view
	
	private CollectionQueue cQueue;
	private DepotWorker worker1;
	

	public void initialize() {
		try {
			
			DataHandler dh = new DataHandler("./parcels.csv", "./customers.csv");

			new CustomerList();
			new ParcelList();
			cQueue = new CollectionQueue();
			
			//create customers and parcels and add them to their lists
			dh.importAllCustomers();
			
			dh.importAllParcels();
			parcelsView = FXCollections.observableArrayList(ParcelList.getUncollectedParcels());
			
			//create customer claims/collection queue
			dh.createCollectionQueue(cQueue);
			
			queueView = FXCollections.observableArrayList(cQueue.getQueue());

			showCollectionQueue();
			showParcelsInventory();
			
			
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Files may not exist");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startProgramListener(ActionEvent e) throws IOException {
		System.out.println("Program should start now");
		
		//initialise a depot worker with the depot's list of parcels
		worker1 = new DepotWorker(cQueue);
			
		//create thread for worker to start attending to the queue
		new Thread(worker1).start();
		
		//create thread for customers joining the queue after worker has started attending to the queue
		new Thread(cQueue).start();	
		
	}
	
	public void stopProgramListener(ActionEvent e) throws IOException {
		System.out.println("Program should stop now");
		
		// need to figure out how to stop the threads
		
		endProcessing();
	}
	
	public void showCollectionQueue() {
		//update GUI with collection queue list		
		sequenceNo.setCellValueFactory(new PropertyValueFactory<>("sequenceNo"));
		customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
		parcelIds.setCellValueFactory(cellData -> {
		    String[] parcelIds = cellData.getValue().getParcelIds();
		    String joinedParcelIds = String.join(", ", parcelIds);
		    return new ReadOnlyStringWrapper(joinedParcelIds);
		});
		collectionTable.setItems(queueView);
	}
	
	public void showParcelsInventory() {
		//update GUI with parcels list		
		parcelId.setCellValueFactory(new PropertyValueFactory<>("parcelId"));
		daysInDepot.setCellValueFactory(new PropertyValueFactory<>("daysInDepot"));
		weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
		dimensions.setCellValueFactory(cellData -> {
			Parcel item = cellData.getValue();
		    String mergedValue = (int)item.getLength() + " x " + (int)item.getWidth() + " x " + (int)item.getHeight();
		    return new ReadOnlyStringWrapper(mergedValue);
		});
		allUncollectedParcels.setItems(parcelsView);
	}
	
	public void endProcessing() {
		try {
			// print results
			System.out.println("\n\nDone...");

			System.out.println("Number of collected parcels: " + ParcelList.getCollectedParcels().size());
			System.out.println("Number of remaining parcels: " + ParcelList.getUncollectedParcels().size());

			// store results in txt file
			PrintWriter writer = new PrintWriter("output.txt"); // correct dir. path
			writer.print("Depot Worker results \n\n");
			writer.append("Number of collected parcels: " + ParcelList.getCollectedParcels().size() + "\n"); // appends to
																										// the file
			writer.append("Number of remaining parcels: " + ParcelList.getUncollectedParcels().size() + "\n");

			DecimalFormat dpFormatter = new DecimalFormat("0.00");

			double totalFees = 0;
			writer.append("\nCollected Parcels - Collection Fee\n");
			for (Parcel p : ParcelList.getCollectedParcels()) {
				writer.append(p.getParcelId() + " - £" + dpFormatter.format(p.getCollectionFee()) + "\n");
				totalFees += p.getCollectionFee();
			}
			writer.append("\nUncollected Parcels\n");

			for (Parcel p : ParcelList.getUncollectedParcels()) {
				writer.append(p.getParcelId() + "\n");
			}

			writer.append("\nTotal Collection Fee for the day: £" + dpFormatter.format(totalFees) + "\n");

			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Files may not exist");
		}
	}

}
