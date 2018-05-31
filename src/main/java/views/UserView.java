package main.java.views;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import main.java.models.User;

public class UserView {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty username = new SimpleStringProperty();
    private final SimpleStringProperty password = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();

    public UserView(User user){
        this.id.set(user.getId());
        this.username.set(user.getUsername());
        this.password.set(user.getPassword());
        this.email.set(user.getEmail());
    }

    public UserView() {
        this(0, "", "", "");
    }

    public UserView(int id, String username, String password, String email) {
        this.id.set(id);
        this.username.set(username);
        this.password.set(password);
        this.email.set(email);
    }

    public int getId() {
        return id.get();
    }
    public void setId(int id) {
        this.id.set(id);
    }

    public String getUsername() {
        return username.get();
    }
    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }
    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getEmail() {
        return email.get();
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
}