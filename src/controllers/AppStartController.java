package controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
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
	private TableColumn<ParcelClaim, String> parcelId;
	@FXML
	private TableColumn<ParcelClaim, Integer> daysInDepot;
	@FXML
	private TableColumn<ParcelClaim, Double> weight;
	@FXML
	private TableColumn<ParcelClaim, String> dimensions;
	
	ObservableList<ParcelClaim> queue;
	ObservableList<Parcel> parcels;
	

	public void initialize() {
		try {
			DataHandler dh = new DataHandler("./parcels.csv", "./customers.csv");

			CustomerList cList = new CustomerList();
			ParcelList pList = new ParcelList();
			
			//create customers and parcels and add them to their lists
			dh.importAllCustomers(cList);
			
			dh.importAllParcels(pList);
			parcels = FXCollections.observableArrayList(pList.getUncollectedParcels());

			
			//initialise a depot worker with the depot's list of parcels
			DepotWorker worker1 = new DepotWorker(pList);

			//create customer claims/collection queue
			dh.createCollectionQueueForWorker("./customers.csv", worker1);
			queue = FXCollections.observableArrayList(worker1.getCollectionQueue());
			
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
	
	public void onClickStart(ActionEvent e) throws IOException {
		// if currently login, perform login action
		System.out.println("Program should start now");
		
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
		collectionTable.setItems(queue);
	}
	
	public void showParcelsInventory() {
		//update GUI with parcels list		
		parcelId.setCellValueFactory(new PropertyValueFactory<>("parcelId"));
		daysInDepot.setCellValueFactory(new PropertyValueFactory<>("daysInDepot"));
		weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
//		dimensions.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLength() + " " + cellData.getValue().getLastName()));
		allUncollectedParcels.setItems(parcels);
	}
	


}
