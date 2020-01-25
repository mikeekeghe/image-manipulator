/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagemanipulator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author mike
 */
public class ImageManipulator extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Started!");

                //1. Create ArrayList of TargetNames  for Output folders
                ArrayList<String> TargetNameslist = new ArrayList<String>();
                TargetNameslist.add("Acne");
                TargetNameslist.add("Lesion");
                TargetNameslist.add("Dermatitis");
                TargetNameslist.add("Bullous");
                TargetNameslist.add("Bacteria");
                TargetNameslist.add("Eczema");
                TargetNameslist.add("Melanoma");
                TargetNameslist.add("Nail");
                TargetNameslist.add("Psoriasis");
                TargetNameslist.add("Bites");
                TargetNameslist.add("Tumor");
                TargetNameslist.add("Funga");
                TargetNameslist.add("Vasculitis");
                TargetNameslist.add("Vir");
                TargetNameslist.add("Keratosis");
                TargetNameslist.add("Herpes");
                TargetNameslist.add("Rosacea");

                //2. create Output folders with folder names as TargetNames in arrayList
                for (String temp : TargetNameslist) {
                    System.out.println("output/" + temp);

                    File file = new File(temp);
                    //Creating the directory
                    boolean bool = file.mkdir();
                    if (bool) {
                        System.out.println("Directory created successfully");
                    } else {
                        System.out.println("Sorry couldn’t create specified directory");
                    }
                }

                //3. Scan file names in input source folder
                try (Stream<Path> walk = Files.walk(Paths.get("/home/mike/Documents/SPECIAL_PROJECTS/SkinLine_Project/DermanetNZ/dermnetnz.org/assets/Uploads"))) {

                    List<String> result = walk.map(x -> x.toString())
                            .filter(f -> f.endsWith(".jpg")).collect(Collectors.toList());

                    result.forEach(System.out::println);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                //4. loop through content
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Image Manupulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
