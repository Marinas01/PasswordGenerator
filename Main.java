import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

//this main class is the main view
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    String passwordAnswer="";
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane=new GridPane();
        Label password=new Label();
        Slider passwordLenght=new Slider(10,100,50);
        Label numbers=new Label("do you want numbers in your password ");
        Label characters=new Label("do you want characters in your password ");
        CheckBox numbersInput=new CheckBox();
        CheckBox charactersInput=new CheckBox();
        Button generate=new Button("Generate password");
        Button copy=new Button("Copy password");
        gridPane.getChildren().addAll(password,passwordLenght,numbers,characters,numbersInput,charactersInput,
                                      generate,copy);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        GridPane.setConstraints(password,0,0);
        GridPane.setConstraints(passwordLenght,0,1);
        GridPane.setConstraints(numbers,0,2);
        GridPane.setConstraints(numbersInput,1,2);
        GridPane.setConstraints(characters,0,3);
        GridPane.setConstraints(charactersInput,1,3);
        GridPane.setConstraints(generate,0,4);
        GridPane.setConstraints(copy,1,4);
        gridPane.setAlignment(Pos.CENTER);
        Scene scene=new Scene(gridPane,500,700);
        primaryStage.setScene(scene);
        primaryStage.show();
        passwordLenght.setShowTickLabels(true);
        passwordLenght.setShowTickMarks(true);
        //this action will take your inputs and return the password
        generate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int length=(int)passwordLenght.getValue();
                boolean numbersAnswer=numbersInput.isSelected();
                boolean characterAnswer=charactersInput.isSelected();
                passwordAnswer=Password.generatePassword(length,numbersAnswer,characterAnswer);
                password.setText(passwordAnswer);
            }
        });
        //this action will copy the password to your cliboard
        copy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StringSelection stringSelection=new StringSelection(passwordAnswer);
                Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection,null);
            }
        });
    }
}
