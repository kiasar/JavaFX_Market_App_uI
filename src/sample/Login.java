package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    public Label label;
    public Button loginButt;
    public TextField usernameText;
    public PasswordField passwordField;

    private Stage primaryStage;

    void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void beClicked(ActionEvent actionEvent) throws IOException {
        String username = usernameText.getText();
        String password = passwordField.getText();
        if (isValid(username,password)){
            primaryStage.setTitle("cashier app");
            primaryStage.setResizable(true);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("workplace.fxml"));
            Parent root = fxmlLoader.load();

            MainController controller = fxmlLoader.getController();
            controller.ifIsManager(isManager(username,password));
            
            primaryStage.setScene(new Scene(root, Screen.getPrimary().getVisualBounds().getWidth(),
                    Screen.getPrimary().getVisualBounds().getHeight()));
            primaryStage.setMaximized(true);
            primaryStage.show();

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "information is not valid", ButtonType.OK);
            alert.showAndWait();
        }

    }

    private boolean isManager(String username, String password) {
        // TODO: 7/8/2019  
        return true;
    }

    private boolean isValid(String username, String password) {
        // TODO: 7/2/2019
        return true;
    }
}
