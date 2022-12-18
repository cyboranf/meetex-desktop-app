package com.example.MeetexApp;


import com.example.MeetexApp.config.JavafxApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeetexAppApplication {

	public static void main(String[] args) {
			Application.launch(JavafxApplication.class, args);

	}
}
