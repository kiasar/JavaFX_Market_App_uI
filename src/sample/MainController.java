package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Made by Peyman on 7/7/2019.
 */
public class MainController implements Initializable {

    public HBox hBoxGoods;
    public Button buttGoods;
    public ChoiceBox<String> choiceGoods;
    public Spinner<Integer> spinnerGoods;
    public Button buttClearGoods;
    public VBox vBoxGoods;
    public ScrollPane scrollGoods;
    public HBox hBoxSell;
    public ToggleGroup radioSell;
    public ChoiceBox<String> choiceSell;
    public Spinner<Double> spinSell;
    public HBox hBoxSettle;
    public ChoiceBox<String> choiceSettle;
    public TextField textNameItem;
    public TextField textGroupItem;
    public ChoiceBox<String> choiceSalesmanItem;
    public Button imagePicker;
    public Spinner<Double> spinItem;
    public DatePicker dateStartOff;
    public DatePicker dateEndOff;
    public Spinner<Double> spinStartOff;
    public Spinner<Double> spinEndOff;
    public ChoiceBox<String> choiceItemOff;
    public Spinner<Double> spinAmountOff;
    public Spinner<Double> spinPercentOff;
    public TableView tableCharts;
    public DatePicker dateStartChart;
    public DatePicker dateEndChart;
    public ToggleGroup radioReport;
    public RadioButton radioCostAndBenefit;
    public TextField textNameCustomer;
    public TextField textLastNameICustomer;
    public TextField textEmailCustomer;
    public TextField textPhoneCustomer;
    public TextField textNameSalesman;
    public TextField textOfficialNameSalesman;
    public TextField textEmailSalesman;
    public TextField textPhoneSalesman;
    public TextField textNameCashier;
    public TextField textUserNameCashier;
    public TextField textPssCashier;
    public Tab tabManager;
    private File imageFile;
    private ArrayList<String> listOfOrders = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hBoxGoods.setSpacing(30);
        hBoxSell.setSpacing(30);
        hBoxSettle.setSpacing(30);

        spinnerGoods.setEditable(true);
        spinnerGoods.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99999, 1));
        spinSell.setEditable(true);
        spinSell.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 99999, 1.00, 0.01));
        spinItem.setEditable(true);
        spinItem.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 99999, 0.00, 0.01));
        spinAmountOff.setEditable(true);
        spinAmountOff.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 99999, 0.00, 0.01));
        spinPercentOff.setEditable(true);
        spinPercentOff.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 100, 0, 0.1));
        spinStartOff.setEditable(true);
        spinStartOff.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 99999, 0.00, 0.01));
        spinEndOff.setEditable(true);
        spinEndOff.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 99999, 0.00, 0.01));

        updateChoiceGoods();
        updateChoiceSalesmen();
        updateChoiceCustomers();
        updateChoiceFactors();

        textPhoneCustomer.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textPhoneCustomer.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        textPhoneSalesman.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textPhoneSalesman.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });


        scrollGoods.setFitToWidth(true);

        choiceSalesmanItem.setDisable(true);
    }

    void ifIsManager(boolean b){
        if (!b){
            radioCostAndBenefit.setDisable(true);
            tabManager.setDisable(true);

        }
    }

    private void updateChoiceFactors() {
        choiceSettle.setItems(FXCollections.observableArrayList(getFactorsIDs()));
        choiceSettle.getSelectionModel().selectFirst();
    }

    private void updateChoiceSalesmen() {
        choiceSell.setItems(FXCollections.observableArrayList(getSalesmanIDs()));
        choiceSell.getSelectionModel().selectFirst();

        choiceSalesmanItem.setItems(FXCollections.observableArrayList(getSalesmanIDs()));
        choiceSalesmanItem.getSelectionModel().selectFirst();
    }

    private void updateChoiceCustomers() {
        choiceSell.setItems(FXCollections.observableArrayList(getCustomersIDs()));
        choiceSell.getSelectionModel().selectFirst();

    }

    private void updateChoiceGoods() {
        choiceGoods.setItems(FXCollections.observableArrayList(getGoodsIDs()));
        choiceGoods.getSelectionModel().selectFirst();

        choiceItemOff.setItems(FXCollections.observableArrayList(getGoodsIDs()));
        choiceItemOff.getSelectionModel().selectFirst();
    }

    private ArrayList<String> getGoodsIDs() {
        // TODO: 7/7/2019
        ArrayList<String> tempArr = new ArrayList<String>();
        tempArr.add("1561");
        tempArr.add("861");
        tempArr.add("4261");
        tempArr.add("sdf61");
        tempArr.add("14984861");
        tempArr.add("41");
        tempArr.add("ikiujiu4261");

        return tempArr;
    }

    private ArrayList<String> getCustomersIDs() {
        // TODO: 7/7/2019
        ArrayList<String> tempArr = new ArrayList<String>();
        tempArr.add("sfdsf561");
        tempArr.add("ifdfv61");

        return tempArr;
    }

    private ArrayList<String> getFactorsIDs() {
        // TODO: 7/7/2019
        ArrayList<String> tempArr = new ArrayList<String>();
        tempArr.add("1981919198191");
        tempArr.add("798498498129");

        return tempArr;
    }

    private ArrayList<String> getSalesmanIDs() {
        // TODO: 7/7/2019
        ArrayList<String> tempArr = new ArrayList<String>();
        tempArr.add("1561");
        tempArr.add("41");
        tempArr.add("45");

        return tempArr;
    }

    public void doButtGoods(ActionEvent actionEvent) {

        String[] goodFeatures = getOrderFeatures(choiceGoods.getValue(), spinnerGoods.getValue());
        vBoxGoods.getChildren().add(makeOffer(goodFeatures[0], goodFeatures[1], goodFeatures[2], goodFeatures[3], goodFeatures[4]));

        listOfOrders.add(choiceGoods.getValue() + ":" + String.valueOf(spinnerGoods.getValue()));

    }

    private String[] getOrderFeatures(String id, Integer quantity) {
        // TODO: 7/7/2019 return String name, String quantity, String off, String price, String imageAddress
        return new String[]{"box", String.valueOf(quantity), "23 %", "1561 $", "imageaddress.png"};
    }

    private HBox makeOffer(String name, String quantity, String off, String price, String imageAddress) {
        HBox pane = new HBox();
        pane.setSpacing(40);
        pane.setAlignment(Pos.CENTER_LEFT);
        pane.setBackground(new Background(new BackgroundFill(
                Color.BURLYWOOD,
                new CornerRadii(30),
                new Insets(2.1))));
        pane.setBorder(new Border(new BorderStroke(Color.BURLYWOOD,
                BorderStrokeStyle.SOLID, new CornerRadii(30), BorderWidths.DEFAULT)));


        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("box.png")));
        try {
            imageView.setImage(new Image(getClass().getResourceAsStream(imageAddress)));
        } catch (Exception e) {
            int _;
        }

        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        pane.getChildren().add(imageView);
//        ----------------------------------------------------
        Label nameLabel = new Label("Name: " + name + spaceMaker(25 - name.length()));
        Label quaintLabel = new Label("Quantity: " + quantity + spaceMaker(10 - quantity.length()));
        Label offLabel = new Label("Off: " + off + spaceMaker(6 - off.length()));
        Label priceLabel = new Label("price: " + price + spaceMaker(10 - price.length()));

        nameLabel.setStyle("-fx-font-weight: bold");
        offLabel.setStyle("-fx-font-weight: bold");
        quaintLabel.setStyle("-fx-font-weight: bold");
        priceLabel.setStyle("-fx-font-weight: bold");


        pane.getChildren().add(nameLabel);
        pane.getChildren().add(quaintLabel);
        pane.getChildren().add(offLabel);
        pane.getChildren().add(priceLabel);

        return pane;
    }

    private String spaceMaker(Integer integer) {
        StringBuilder outputBuffer = new StringBuilder(integer);
        for (int i = 0; i < integer; i++) {
            outputBuffer.append(" ");
        }
        return outputBuffer.toString();
    }

    public void doClearButtGoods(ActionEvent actionEvent) {
        vBoxGoods.getChildren().clear();
        listOfOrders.clear();
    }

    public void radioBuy(ActionEvent actionEvent) {
        updateChoiceSalesmen();

    }

    public void radioSell(ActionEvent actionEvent) {
        updateChoiceCustomers();
    }

    public void doButtSell(ActionEvent actionEvent) {
        createFactor(listOfOrders, choiceSell.getValue(), ((RadioButton) radioSell.getSelectedToggle()).getText(), spinSell.getValue());
    }

    private void createFactor(ArrayList<String> listOfOrders, String IDcoustomerOrSalesman, String sellOrBuy, Double paid) {
        // TODO: 7/7/2019 listOfOrders is list of strings of "ID:quantity"
    }

    public void doButtSettle(ActionEvent actionEvent) {
        settleTheFactor(choiceSettle.getValue());
    }

    private void settleTheFactor(String factorID) {
        // TODO: 7/7/2019
    }

    public void doButtItem(ActionEvent actionEvent) {
        if (textNameItem.getText() == null || textNameItem.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Name is empty", ButtonType.OK);
            alert.showAndWait();
        } else {
            addNewItem(textNameItem.getText(), textGroupItem.getText(), spinItem.getValue(), choiceSalesmanItem.getValue(), imageFile);
            updateChoiceGoods();
        }
    }

    private void addNewItem(String name, String group, Double price, String SalesmanID, File imageFile) {
        // TODO: 7/8/2019

    }

    public void imageChooser(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select your Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        this.imageFile = fileChooser.showOpenDialog(new Stage());
    }

    public void doAmountOff(ActionEvent actionEvent) {
        if (dateStartOff.getValue() != null && dateEndOff.getValue() != null) {
            makeAmountOff(dateStartOff.getValue(), dateEndOff.getValue(), spinStartOff.getValue(), spinEndOff.getValue(), choiceItemOff.getValue(), spinAmountOff.getValue());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Date is empty", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void makeAmountOff(LocalDate startDate, LocalDate endDate, Double startScore, Double endScore, String ItemID, Double amount) {
        // TODO: 7/8/2019
    }

    public void doPercentOff(ActionEvent actionEvent) {
        if (dateStartOff.getValue() != null && dateEndOff.getValue() != null) {
            makePercentOff(dateStartOff.getValue(), dateEndOff.getValue(), spinStartOff.getValue(), spinEndOff.getValue(), choiceItemOff.getValue(), spinPercentOff.getValue());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Date is empty", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void makePercentOff(LocalDate startDate, LocalDate endDate, Double startScore, Double endScore, String ItemID, Double percent) {
        // TODO: 7/8/2019
    }

    public void doReports(ActionEvent actionEvent) {
        if (dateStartChart.getValue() != null && dateEndChart.getValue() != null) {
            makeTheTable(this.tableCharts, dateStartChart.getValue(), dateEndChart.getValue(), ((RadioButton) radioReport.getSelectedToggle()).getText());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Date is empty", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void makeTheTable(TableView tableCharts, LocalDate startDate, LocalDate endDate, String typeOfReport) {
        // TODO: 7/8/2019
    }

    public void doCreateCustomer(ActionEvent actionEvent) {
        if (textPhoneCustomer.getText().trim().isEmpty() || textEmailCustomer.getText().trim().isEmpty() || textNameCustomer.getText().trim().isEmpty() || textLastNameICustomer.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "fill the information", ButtonType.OK);
            alert.showAndWait();
        } else {
            makeCustomer(textNameCustomer.getText(), textLastNameICustomer.getText(), textEmailCustomer.getText(), textPhoneCustomer.getText());
            updateChoiceCustomers();
        }
    }

    private void makeCustomer(String nameCustomerText, String lastNameICustomerText, String emailCustomerText, String phone) {
        // TODO: 7/8/2019  
    }

    public void doCreateSalesman(ActionEvent actionEvent) {
        if (textPhoneSalesman.getText().trim().isEmpty() || textEmailSalesman.getText().trim().isEmpty() || textNameSalesman.getText().trim().isEmpty() || textOfficialNameSalesman.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "fill the information", ButtonType.OK);
            alert.showAndWait();
        } else {
            makeSalesman(textNameSalesman.getText(), textOfficialNameSalesman.getText(), textEmailSalesman.getText(), textPhoneSalesman.getText());
            updateChoiceSalesmen();
        }
    }

    private void makeSalesman(String nameSalesmanText, String officialNameSalesmanText, String emailSalesmanText, String phoneSalesmanText) {
        // TODO: 7/8/2019  
    }

    public void doCreateCashier(ActionEvent actionEvent) {
        if (textNameCashier.getText().trim().isEmpty() || textPssCashier.getText().trim().isEmpty() || textUserNameCashier.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "fill the information", ButtonType.OK);
            alert.showAndWait();
        } else {
            makeCashier(textNameCashier.getText(), textUserNameCashier.getText(), textPssCashier.getText());
        }

    }

    private void makeCashier(String nameCashierText, String userNameCashierText, String pssCashierText) {
        // TODO: 7/8/2019
    }
}
