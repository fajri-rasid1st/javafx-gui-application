package com.cick;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ConvertUnits extends Application {
    Stage stage;
    Scene scene_1, scene_2, scene_3, scene_4, scene_5;
    Image image, image2, image3, image4, image5, image6;
    Text text, text_2;
    ImageView picture, picture2, picture3, picture4, picture5, picture6, picture7, picture8, picture9, picture10;
    Button button1, button2, button3, button4, button5, button6, back, back2, back3, back4;
    GridPane gp, gp2, gp3, gp4, gp5;
    Label label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16;
    TextField textInput, textInput2, textInput3, textInput4, textInput5, textInput6, textInput7, textInput8, textInput9, textInput10, textInput11, textInput12, textInput13, textInput14, textInput15, textInput16;
    Group root_1, root_2, root_3, root_4, root_5;
    ComboBox <String> cb, cb2;
    
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Icon stage
        image = new Image(getClass().getResourceAsStream("1367426107612399140free-yellow-button-measure_units-hi.png"));
        //picture
        image2 = new Image(getClass().getResourceAsStream("titlefont.png"));
        image3 = new Image(getClass().getResourceAsStream("be0aa6f53b4ac58a4a3612d6dc7a7854-stopwatch-timer-icon-by-vexels.png"));
        image4 = new Image(getClass().getResourceAsStream("FAVPNG_yellow-computer-file_Rj40yLFN.png"));
        image5 = new Image(getClass().getResourceAsStream("icon-timbangan-png-4.png"));
        image6 = new Image(getClass().getResourceAsStream("temperature-png-615x440_df94b46b.png"));
        //image 
        picture = new ImageView(); picture2 = new ImageView(); picture3 = new ImageView(); picture4 = new ImageView(); picture5 = new ImageView();
        setImage();
        // Text title
        image3 = new Image(getClass().getResourceAsStream("titlefont2.png"));
        picture6 = new ImageView(); picture7 = new ImageView(); picture8 = new ImageView(); picture9 = new ImageView(); picture10 = new ImageView();
        setText();
        // This is display for Scene 1
        text = new Text();
        text.setText("Select the units you want to convert :");
        text.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        text_2 = new Text();
        text_2.setText("Select unit you want to input :");
        text_2.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        cb = new ComboBox <String> ();
        cb2 = new ComboBox <String> ();

        cb.getItems().addAll(
            "Waktu",
            "Panjang",
            "Berat",
            "Suhu"
        );
        cb.setPromptText("-select units-");
        cb.setMinWidth(280);
        cb.setId("cBox");
        cb.setOnAction(event -> {
            comboBox1(cb, cb2);
        });

        cb2.setPromptText("-select input-");
        cb2.setMinWidth(280);
        cb2.setId("cBox");
        button6 = new Button("Submit");
        button6.setId("big-yellow");
        button6.setMinSize(100, 50);
        button6.setLayoutX(210); button6.setLayoutY(460);
        button6.setOnAction(event -> {
            try {
                String choice_1;
                choice_1 = cb.getValue();
                System.out.println(cb.getValue() + " " + cb2.getValue());
                if (choice_1.equalsIgnoreCase("Waktu")) {
                    stage.setScene(scene_2);
                }
                if (choice_1.equalsIgnoreCase("Panjang")) {
                    stage.setScene(scene_3);
                }
                if (choice_1.equalsIgnoreCase("Berat")) {
                    stage.setScene(scene_4);
                }
                if (choice_1.equalsIgnoreCase("Suhu")) {
                    stage.setScene(scene_5);
                }
            }catch (NullPointerException e) {
                InputWrongAlert.display("Wrong Submit", "Select the unit first!");
            }
        });
        gp2 = new GridPane();
        gp2.setPadding(new Insets(290, 140, 290, 140)); // (vertikal, horizontal)
        gp2.setVgap(10);
        GridPane.setConstraints(text, 0, 0);
        GridPane.setConstraints(cb, 0, 1);
        GridPane.setConstraints(text_2, 0, 2);
        GridPane.setConstraints(cb2, 0, 3);
        gp2.getChildren().addAll(text, cb, text_2, cb2);

        // Scene 2 for Time unit
        label1 = new Label("Detik  :");
        label2 = new Label("Menit :");
        label3 = new Label("Jam    :");
        label4 = new Label("Hari    :");
        textInput = new TextField();
        textInput2 = new TextField();
        textInput3 = new TextField();
        textInput4 = new TextField();
        button1 = new Button("Convert");
        button1.setPrefSize(100, 30);
        button1.setId("convert");
        Button reset = new Button("Reset");
        reset.setId("label");
        reset.setPrefSize(80, 30);
        reset.setLayoutX(345); reset.setLayoutY(492);
        button1.setOnAction(e -> {
            isNumber(textInput);
            isNumber(textInput2);
            isNumber(textInput3);
            isNumber(textInput4);
            if (isNumber(textInput) == false && isNumber(textInput2) == false && isNumber(textInput3) == false && isNumber(textInput4) == false) {
                InputWrongAlert.display("Wrong input", "Please input a correct number !");
            }else {
                if (isNumber(textInput) == true){
                    double second = Double.parseDouble(textInput.getText());
                    double arr [] = {second/60, second/3600, second/86400};
                    TextField arr2[] = {textInput2, textInput3, textInput4};
                    String units [] = {"menit", "jam", "hari"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.4f", arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                    }
                }if (isNumber(textInput2) == true) {
                    double minute = Double.parseDouble(textInput2.getText());
                    double arr [] = {minute*60, minute/60, minute/1440};
                    TextField arr2[] = {textInput, textInput3, textInput4};
                    String units [] = {"detik", "jam", "hari"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.4f", arr[i]);
                            arr2[i].setText(result + " " +  units[i]);
                        }
                    }
                }if (isNumber(textInput3) == true) {
                    double hour = Double.parseDouble(textInput3.getText());
                    double arr [] = {hour*3600, hour*60, hour/24};
                    TextField arr2[] = {textInput, textInput2, textInput4};
                    String units [] = {"detik", "menit", "hari"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.4f", arr[i]);
                            arr2[i].setText(result + " " +  units[i]);
                        }
                    }
                }if (isNumber(textInput4) == true) {
                    double day = Double.parseDouble(textInput4.getText());
                    double arr [] = {day*86400, day*3600, day*24};
                    TextField arr2[] = {textInput, textInput2, textInput3};
                    String units [] = {"detik", "menit", "jam"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.4f", arr[i]);
                            arr2[i].setText(result + " " +  units[i]);
                        }
                    }
                }
            }
        });
        back = new Button("Back");
        back.setId("big-back");
        back.setLayoutX(20); back.setLayoutY(525);
        back.setOnAction(event -> {
            textInput.clear(); textInput2.clear(); textInput3.clear(); textInput4.clear();
            stage.setScene(scene_1);
        });
        gp = new GridPane();
        gp.setPadding(new Insets(300,130,300,130)); //(vertikal, horizontal)
        gp.setVgap(10);
        gp.setHgap(12);
        GridPane.setConstraints(label1, 0, 0);
        GridPane.setConstraints(textInput, 1, 0);
        GridPane.setConstraints(label2, 0, 1);
        GridPane.setConstraints(textInput2, 1, 1);
        GridPane.setConstraints(label3, 0, 2);
        GridPane.setConstraints(textInput3, 1, 2);
        GridPane.setConstraints(label4, 0, 3);
        GridPane.setConstraints(textInput4, 1, 3);
        GridPane.setConstraints(button1, 1, 4);
        gp.getChildren().addAll(label1, label2, label3, label4, textInput, textInput2, textInput3, textInput4, button1, back);
        gp.setId("label");
        reset.setOnAction(e -> {
            textInput.clear();
            textInput2.clear();
            textInput3.clear();
            textInput4.clear();
        });

        // Scene 3 for Range unit
        label5 = new Label("Milimeter   :");
        label6 = new Label("Centimeter :");
        label7 = new Label("Meter \t   :");
        label8 = new Label("Kilometer\t   :");
        textInput5 = new TextField();
        textInput6 = new TextField();
        textInput7 = new TextField();
        textInput8 = new TextField();
        button2 = new Button("Convert");
        button2.setId("convert");
        button2.setPrefSize(100, 30);
        Button reset2 = new Button("Reset");
        reset2.setId("label");
        reset2.setPrefSize(80, 30);
        reset2.setLayoutX(389); reset2.setLayoutY(493);
        button2.setOnAction(e -> {
            isNumber(textInput5);
            isNumber(textInput6);
            isNumber(textInput7);
            isNumber(textInput8);
            if (isNumber(textInput5) == false && isNumber(textInput6) == false && isNumber(textInput7) == false && isNumber(textInput8) == false) {
                InputWrongAlert.display("Wrong input", "Please input a correct number !");
            }else {
                if (isNumber(textInput5) == true){
                    double mm = Double.parseDouble(textInput5.getText());
                    double arr [] = {mm/10, mm/1000, mm/1000000};
                    TextField arr2[] = {textInput6, textInput7, textInput8};
                    String units [] = {"cm", "m", "km"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.6f", arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                    }
                }if (isNumber(textInput6) == true){
                    double cm = Double.parseDouble(textInput6.getText());
                    double arr [] = {cm*10, cm/100, cm/100000};
                    TextField arr2[] = {textInput5, textInput7, textInput8};
                    String units [] = {"mm", "m", "km"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.6f", arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                    }
                }if (isNumber(textInput7) == true){
                    double m = Double.parseDouble(textInput7.getText());
                    double arr [] = {m*1000, m*100, m/1000};
                    TextField arr2[] = {textInput5, textInput6, textInput8};
                    String units [] = {"mm", "cm", "km"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.6f", arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                    }
                }if (isNumber(textInput8) == true){
                    double km = Double.parseDouble(textInput8.getText());
                    double arr [] = {km*1000000, km*100000, km*1000};
                    TextField arr2[] = {textInput5, textInput6, textInput7};
                    String units [] = {"mm", "cm", "m"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.6f", arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                    }
                }
            }
        });
        back2 = new Button("Back");
        back2.setId("big-back");
        back2.setLayoutX(20); back2.setLayoutY(525);
        back2.setOnAction(event -> {
            textInput5.clear(); textInput6.clear(); textInput7.clear(); textInput8.clear();
            stage.setScene(scene_1);
        });
        gp3 = new GridPane();
        gp3.setPadding(new Insets(300,100,300,100)); //(vertikal, horizontal)
        gp3.setVgap(10);
        gp3.setHgap(12);
        GridPane.setConstraints(label5, 0, 0);
        GridPane.setConstraints(textInput5, 1, 0);
        GridPane.setConstraints(label6, 0, 1);
        GridPane.setConstraints(textInput6, 1, 1);
        GridPane.setConstraints(label7, 0, 2);
        GridPane.setConstraints(textInput7, 1, 2);
        GridPane.setConstraints(label8, 0, 3);
        GridPane.setConstraints(textInput8, 1, 3);
        GridPane.setConstraints(button2, 1, 4);
        gp3.getChildren().addAll(label5, label6, label7 , label8, textInput5, textInput6, textInput7, textInput8, button2, back2);
        gp3.setId("label");
        reset2.setOnAction(e -> {
            textInput5.clear();
            textInput6.clear();
            textInput7.clear();
            textInput8.clear();
        });

        // Scene 4 for Weight unit
        label9 = new Label("Miligram  :");
        label10 = new Label("Gram \t:");
        label11 = new Label("Ons \t        :");
        label12 = new Label("Kilogram  :");
        textInput9 = new TextField();
        textInput10 = new TextField();
        textInput11= new TextField();
        textInput12= new TextField();
        button3 = new Button("Convert");
        button3.setPrefSize(100, 30);
        Button reset3 = new Button("Reset");
        button3.setId("convert");
        reset3.setId("label");
        reset3.setPrefSize(80, 30);
        reset3.setLayoutX(370); reset3.setLayoutY(492);
        button3.setOnAction(e -> {
            isNumber(textInput9);
            isNumber(textInput10);
            isNumber(textInput11);
            isNumber(textInput12);
            if (isNumber(textInput9) == false && isNumber(textInput10) == false && isNumber(textInput11) == false && isNumber(textInput12) == false) {
                InputWrongAlert.display("Wrong input", "Please input a correct number !");
            }else {
                if (isNumber(textInput9) == true){
                    double mg = Double.parseDouble(textInput9.getText());
                    double arr [] = {mg/1000, mg/100000, mg/1000000};
                    TextField arr2[] = {textInput10, textInput11, textInput12};
                    String units [] = {"g", "ons", "kg"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.6f", arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                    }
                }if (isNumber(textInput10) == true){
                    double g = Double.parseDouble(textInput10.getText());
                    double arr [] = {g*1000, g/100, g/1000};
                    TextField arr2[] = {textInput9, textInput11, textInput12};
                    String units [] = {"mg", "ons", "kg"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.6f", arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                    }
                }if (isNumber(textInput11) == true){
                    double ons = Double.parseDouble(textInput11.getText());
                    double arr [] = {ons*100000, ons*100, ons/10};
                    TextField arr2[] = {textInput9, textInput10, textInput12};
                    String units [] = {"mg", "g", "kg"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.6f", arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                    }
                }if (isNumber(textInput12) == true){
                    double kg = Double.parseDouble(textInput12.getText());
                    double arr [] = {kg*1000000, kg*1000, kg*10};
                    TextField arr2[] = {textInput9, textInput10, textInput11};
                    String units [] = {"mg", "g", "ons"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.6f", arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                    }
                }
            }
        });
        back3 = new Button("Back");
        back3.setId("big-back");
        back3.setLayoutX(20); back3.setLayoutY(525);
        back3.setOnAction(event -> {
            textInput9.clear(); textInput10.clear(); textInput11.clear(); textInput12.clear();
            stage.setScene(scene_1);
        });
        gp4 = new GridPane();
        gp4.setPadding(new Insets(300,125,300,125)); //(vertikal, horizontal)
        gp4.setVgap(10);
        gp4.setHgap(12);
        GridPane.setConstraints(label9, 0, 0);
        GridPane.setConstraints(textInput9, 1, 0);
        GridPane.setConstraints(label10, 0, 1);
        GridPane.setConstraints(textInput10, 1, 1);
        GridPane.setConstraints(label11, 0, 2);
        GridPane.setConstraints(textInput11, 1, 2);
        GridPane.setConstraints(label12, 0, 3);
        GridPane.setConstraints(textInput12, 1, 3);
        GridPane.setConstraints(button3, 1, 4);
        gp4.getChildren().addAll(label9, label10,label11, label12, textInput9, textInput10, textInput11, textInput12, button3, back3);
        gp4.setId("label");
        reset3.setOnAction(e -> {
            textInput9.clear();
            textInput10.clear();
            textInput11.clear();
            textInput12.clear();
        });

        // Scene 5 for Temperature unit
        label13 = new Label("Celcius \t  :");
        label14 = new Label("Fahrenheit :");
        label15 = new Label("Kelvin \t  :");
        label16 = new Label("Reamur \t  :");
        textInput13 = new TextField();
        textInput14 = new TextField();
        textInput15= new TextField();
        textInput16= new TextField();
        button4 = new Button("Convert");
        button4.setPrefSize(100, 30);
        button4.setId("convert");
        Button reset4 = new Button("Reset");
        reset4.setId("label");
        reset4.setPrefSize(80, 30);
        reset4.setLayoutX(366); reset4.setLayoutY(492);
        button4.setOnAction(e -> {
            isNumber(textInput13);
            isNumber(textInput14);
            isNumber(textInput15);
            isNumber(textInput16);
            if (isNumber(textInput13) == false && isNumber(textInput14) == false && isNumber(textInput15) == false && isNumber(textInput16) == false) {
                InputWrongAlert.display("Wrong input", "Please input a correct number !");
            }else {
                if (isNumber(textInput13) == true){
                    double celcius = Double.parseDouble(textInput13.getText());
                    double arr [] = {((9*celcius)/5)+32 , celcius+273, (4*celcius)/5};
                    TextField arr2[] = {textInput14, textInput15, textInput16};
                    String units [] = {"°F", "K", "°R"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.4f", arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                    }
                }if (isNumber(textInput14) == true) {
                    double fahrenheit = Double.parseDouble(textInput14.getText());
                    double arr [] = {((fahrenheit-32)*5)/9, (((fahrenheit-32)*5)/9)+273, ((fahrenheit-32)*4)/9};
                    TextField arr2[] = {textInput13, textInput15, textInput16};
                    String units [] = {"°C", "K", "°R"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.4f", arr[i]);
                            arr2[i].setText(result + " " +  units[i]);
                        }
                    }
                }if (isNumber(textInput15) == true) {
                    double kelvin = Double.parseDouble(textInput15.getText());
                    double arr [] = {kelvin-273, (((kelvin-273)*9)/5)+32, ((kelvin-273)*4)/5};
                    TextField arr2[] = {textInput13, textInput14, textInput16};
                    String units [] = {"°C", "°F", "°R"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.4f", arr[i]);
                            arr2[i].setText(result + " " +  units[i]);
                        }
                    }
                }if (isNumber(textInput16) == true) {
                    double reamur = Double.parseDouble(textInput16.getText());
                    double arr [] = {(reamur*5)/4, ((reamur*9)/4)+32, ((reamur*5)/4)+273};
                    TextField arr2[] = {textInput13, textInput14, textInput15};
                    String units [] = {"°C", "°F", "K"};
                    for (int i = 0 ; i < 3 ; i++) {
                        if (arr[i] == (int)arr[i]) {
                            String result = String.valueOf((int)arr[i]);
                            arr2[i].setText(result + " " + units[i]);
                        }
                        else {
                            String result = String.format("%.4f", arr[i]);
                            arr2[i].setText(result + " " +  units[i]);
                        }
                    }
                }
            }
        });
        back4 = new Button("Back");
        back4.setId("big-back");
        back4.setLayoutX(20); back4.setLayoutY(525);
        back4.setOnAction(event -> {
            textInput13.clear(); textInput14.clear(); textInput15.clear(); textInput16.clear();
            stage.setScene(scene_1);
        });
        gp5 = new GridPane();
        gp5.setPadding(new Insets(300,115,300,115)); //(vertikal, horizontal)
        gp5.setVgap(10);
        gp5.setHgap(12);
        GridPane.setConstraints(label13, 0, 0);
        GridPane.setConstraints(textInput13, 1, 0);
        GridPane.setConstraints(label14, 0, 1);
        GridPane.setConstraints(textInput14, 1, 1);
        GridPane.setConstraints(label15, 0, 2);
        GridPane.setConstraints(textInput15, 1, 2);
        GridPane.setConstraints(label16, 0, 3);
        GridPane.setConstraints(textInput16, 1, 3);
        GridPane.setConstraints(button4, 1, 4);
        gp5.getChildren().addAll(label13, label14,label15, label16, textInput13, textInput14, textInput15, textInput16, button4, back4);
        gp5.setId("label");
        reset4.setOnAction(e -> {
            textInput13.clear();
            textInput14.clear();
            textInput15.clear();
            textInput16.clear();
        });
        // Group and scene
        root_1 = new Group(gp2, picture6, picture, button6);
        scene_1 = new Scene(root_1, 560, 600);
        scene_1.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene_1.setFill(Paint.valueOf("#a8ffeb"));
        root_2 = new Group(gp, picture7, picture2, back, reset);
        scene_2 = new Scene(root_2, 560, 600);
        scene_2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene_2.setFill(Paint.valueOf("#a8ffeb"));
        root_3 = new Group(gp3, picture8, picture3, back2, reset2);
        scene_3 = new Scene(root_3, 560, 600);
        scene_3.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene_3.setFill(Paint.valueOf("#a8ffeb"));
        root_4 = new Group(gp4, picture9, picture4, back3, reset3);
        scene_4 = new Scene(root_4, 560, 600);
        scene_4.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene_4.setFill(Paint.valueOf("#a8ffeb"));
        root_5 = new Group(gp5, picture10, picture5, back4, reset4);
        scene_5 = new Scene(root_5, 560, 600);
        scene_5.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene_5.setFill(Paint.valueOf("#a8ffeb"));

        // Stage
        stage = primaryStage;
        stage.setTitle("converting units");
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });

                     stage.getIcons().add(image);
        stage.setScene(scene_1);
        stage.show();
    }
    public void closeProgram() {
        boolean condition = ConfirmBox.display("Confirm Exit", "Are you sure want to exit?");
        if (condition) {
            stage.close();
        }
    }
    public boolean isNumber(TextField textInput) {
        try {
            Double number = Double.parseDouble(textInput.getText());
            System.out.println(number);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
    public void comboBox1(ComboBox <String> cb, ComboBox <String> cb2) {
        String choice_1 = cb.getValue();
        if (choice_1.equalsIgnoreCase("Waktu")) {
            cb2.getItems().addAll("Detik", "Menit", "Jam", "Hari");
            cb2.getItems().removeAll("Milimeter", "Centimeter", "Meter", "Kilometer", "Miligram", "Gram", "Kilogram", "Ons", "Celcius", "Fahrenheit", "Kelvin", "Reamur");

        }else if (choice_1.equalsIgnoreCase("Panjang")) {
            cb2.getItems().addAll("Milimeter", "Centimeter", "Meter", "Kilometer");
            cb2.getItems().removeAll("Detik", "Menit", "Jam", "Hari", "Miligram", "Gram", "Kilogram", "Ons", "Celcius", "Fahrenheit", "Kelvin", "Reamur");
        }else if (choice_1.equalsIgnoreCase("Berat")) {
            cb2.getItems().addAll("Miligram", "Gram", "Ons", "Kilogram");
            cb2.getItems().removeAll("Detik", "Menit", "Jam", "Hari", "Milimeter", "Centimeter", "Meter", "Kilometer", "Celcius", "Fahrenheit", "Kelvin", "Reamur");
        }else if (choice_1.equalsIgnoreCase("Suhu")) {
            cb2.getItems().addAll("Celcius", "Fahrenheit", "Kelvin", "Reamur");
            cb2.getItems().removeAll("Detik", "Menit", "Jam", "Hari", "Milimeter", "Centimeter", "Meter", "Kilometer", "Miligram", "Gram", "Kilogram", "Ons");
        }
    }
    public void setImage() {
        picture.setImage(image2);
        picture.setX(230); picture.setY(40);
        picture.setFitHeight(120); picture.setFitWidth(120);
        picture2.setImage(image3);
        picture2.setX(220); picture2.setY(35);
        picture2.setFitHeight(140); picture2.setFitWidth(140);
        picture3.setImage(image4);
        picture3.setX(155); picture3.setY(5);
        picture3.setFitHeight(215); picture3.setFitWidth(250);
        picture4.setImage(image5); 
        picture4.setX(215); picture4.setY(40);
        picture4.setFitHeight(130); picture4.setFitWidth(130);
        picture5.setImage(image6);
        picture5.setX(205); picture5.setY(50);
        picture5.setFitHeight(110); picture5.setFitWidth(165);
    }
    public void setText() {
        picture6.setImage(image3);
        picture6.setX(110); picture6.setY(50);
        picture6.setFitHeight(350); picture6.setFitWidth(350);
        picture7.setImage(image3);
        picture7.setX(110); picture7.setY(50);
        picture7.setFitHeight(350); picture7.setFitWidth(350);
        picture8.setImage(image3);
        picture8.setX(110); picture8.setY(50);
        picture8.setFitHeight(350); picture8.setFitWidth(350);
        picture9.setImage(image3);
        picture9.setX(110); picture9.setY(50);
        picture9.setFitHeight(350); picture9.setFitWidth(350);
        picture10.setImage(image3);
        picture10.setX(110); picture10.setY(50);
        picture10.setFitHeight(350); picture10.setFitWidth(350);
    }
}