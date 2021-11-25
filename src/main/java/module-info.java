module com.example.f21comp1011assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires okhttp3;
    requires com.google.gson;
    requires json.simple;
    requires unirest.java;


    opens com.example.f21comp1011assignment2 to javafx.fxml, com.google.gson;
    exports com.example.f21comp1011assignment2;
    exports com.example.f21comp1011assignment2.Controllers;
    opens com.example.f21comp1011assignment2.Controllers to javafx.fxml, com.google.gson;
    exports com.example.f21comp1011assignment2.Models;
    opens com.example.f21comp1011assignment2.Models to javafx.fxml, com.google.gson;
}