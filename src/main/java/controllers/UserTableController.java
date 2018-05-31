package main.java.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.DatabaseController;
import main.java.models.User;
import main.java.views.UserView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserTableController implements Initializable {

    @FXML private TableView<UserView> usersTable;

    @FXML private TableColumn<UserView, Integer> usersTableId;
    @FXML private TableColumn<UserView, String> usersTableUsername;
    @FXML private TableColumn<UserView, String> usersTablePassword;
    @FXML private TableColumn<UserView, String> usersTableEmail;



    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private TextField emailField;

    @FXML
    protected void addUser(ActionEvent event) {
        /*data.add(new UserView(
                0,
                usernameField.getText(),
                passwordField.getText(),
                emailField.getText()
        ));*/

        try {
            DatabaseController dao = new DatabaseController();
            dao.insertUser(new User(
                    0,
                    usernameField.getText(),
                    passwordField.getText(),
                    emailField.getText()
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        usernameField.setText("");
        passwordField.setText("");
        emailField.setText("");

        refresh();
    }

    private ObservableList<UserView> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usersTableId.setCellValueFactory(new PropertyValueFactory<UserView, Integer>("id"));
        usersTableUsername.setCellValueFactory(new PropertyValueFactory<UserView, String>("username"));
        usersTablePassword.setCellValueFactory(new PropertyValueFactory<UserView, String>("password"));
        usersTableEmail.setCellValueFactory(new PropertyValueFactory<UserView, String>("email"));

        //usersTable.getItems().setAll(fetchUsers());
        data = FXCollections.observableArrayList();
        usersTable.setItems(data);
        refresh();
    }

    private List<UserView> fetchUsers() {
        List<UserView> userViews = null;

        try {
            DatabaseController dao = new DatabaseController();
            userViews = dao.getUserViews();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userViews;
    }

    private void refresh() {
        data.clear();
        data.setAll(fetchUsers());
    }
}