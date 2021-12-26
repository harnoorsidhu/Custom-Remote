package As4.lkj.ass4;

/**
 * ACS-3913 Assignment 4
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Stack;
import java.io.*;

public class RemoteControlApp extends Application{
    private Label[] labels;                             
    RemoteControl remoteControl;

    /** Loads and sets up the remote control */
    public void loadRemote(){
        Light kitchenLight = new Light("Living Room");
        Stereo stereo = new Stereo("Bedroom");
        CeilingFan fan = new CeilingFan("Bathroom");
        Hottub tub = new Hottub("Mittra di Motar te");
        
        HottubOnCommand tubOn= new HottubOnCommand(tub);
        HottubOffCommand tubOff = new HottubOffCommand(tub);
        
        CeilingFanLowCommand fanLow= new CeilingFanLowCommand(fan);
        CeilingFanMediumCommand fanMid= new CeilingFanMediumCommand(fan);
        CeilingFanOffCommand fanoff= new  CeilingFanOffCommand(fan);
       
        LightOnCommand kitchenLightOn = 
            new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = 
            new LightOffCommand(kitchenLight);
            
        StereoOnWithRadioCommand stereoOnWithRadio =
            new StereoOnWithRadioCommand(stereo);
        StereoOnWithCDCommand stereoOnWithCD =
            new StereoOnWithCDCommand(stereo);
        StereoOffCommand  stereoOff =
            new StereoOffCommand(stereo);
            
        MacroCommand macro = new MacroCommand(kitchenLightOn,stereoOnWithCD,fanLow);
         MacroOffCommand macroOff = new MacroOffCommand(kitchenLightOff,stereoOff,fanoff);
        
        setRemoteCommand(0, kitchenLightOn, kitchenLightOff, "L.R Light");
        setRemoteCommand(1, stereoOnWithCD, stereoOff, "StereoCD");
        setRemoteCommand(2, stereoOnWithRadio, stereoOff, "StereoRadio");
        setRemoteCommand(3,fanMid,fanoff,"Ceiling Fan Mid");
        setRemoteCommand(4,fanLow,fanoff,"Ceiling Fan Low");
        setRemoteCommand(5,tubOn,tubOff,"Hottub");
        setRemoteCommand(6,macro,macroOff,"Macro");
        

        System.out.println("\n------ Remote Control App Sim -------\n");
    }

    /** Sets the command and label text */
    private void setRemoteCommand(int slot, Command onCommand, Command offCommand, 
    String description){
        remoteControl.setCommand(slot, onCommand, offCommand);
        labels[slot].setText(description);                 
    }

    /** The main entry point for the application **/
    public void start(Stage stage) throws FileNotFoundException,IOException {       
        Configuration f= Configuration.getInstance();
        final int NUM_COMMANDS = f.getOptions();
        final int REMOTE_HEIGHT = f.getHeight();
        final int REMOTE_WIDTH = 250;

        remoteControl = new RemoteControl();

        // Create the buttons and labels
        Label onLabel = new Label("on");
        Label offLabel = new Label("off");
        labels = new Label[NUM_COMMANDS];
        Button[] onButtons = new Button[NUM_COMMANDS];  
        Button[] offButtons = new Button[NUM_COMMANDS];
        Button undoButton = new Button("UNDO");
        Button redoButton = new Button("REDO");     

        for (int i=0; i<NUM_COMMANDS; i++){
            onButtons[i] = new Button(" ");
            offButtons[i] = new Button(" ");  
            labels[i] = new Label("no command");
        }

        // Create a new grid pane 
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(230, 400);
        pane.setVgap(20);
        pane.setHgap(10);

        // Set actions on the buttons using lambda expressions
        
        for (int i=0; i<NUM_COMMANDS; i++){
            final int I = i;
             
            onButtons[i].setOnAction((ActionEvent event) -> {
                    remoteControl.onButtonWasPushed(I);
                });
            
            offButtons[i].setOnAction((ActionEvent event) -> {
                    remoteControl.offButtonWasPushed(I);
                });
                
        }
       
        // Set actions on the buttons using method reference
        undoButton.setOnAction(this::undoButtonClick);
        redoButton.setOnAction(this::redoButtonClick);
        

        // Add the buttons and labels into the pane
        pane.add(onLabel, 1, 0);
        pane.setHalignment(onLabel, HPos.CENTER);
        pane.add(offLabel, 2, 0);
        pane.setHalignment(offLabel, HPos.CENTER);
        for (int i=0; i<NUM_COMMANDS; i++){
            pane.add(labels[i], 0, i+1);
            labels[i].setMinWidth(100);
            pane.add(onButtons[i], 1, i+1);
            pane.add(offButtons[i], 2, i+1);
            pane.setHalignment(onButtons[i], HPos.CENTER);
            pane.setHalignment(offButtons[i], HPos.CENTER);
        }
        pane.add(undoButton, 1, NUM_COMMANDS + 1);
        pane.add(redoButton, 2, NUM_COMMANDS + 1); 

        // Set the pane to a scene and stage, show stage
        Scene scene = new Scene(pane, 250,400);
        stage.setTitle("Command Remote");
        stage.setScene(scene);
        stage.show();

        // Load the remote
        loadRemote();
    }

    /** Executes when the undoButton is clicked */
    private void undoButtonClick(ActionEvent event) {
        // enter code here...
        try{
        remoteControl.undoButtonWasPushed();}
        catch(IOException e){}
    }

    /** Executes when the redoButton is clicked */
    private void redoButtonClick(ActionEvent event){
        // enter code here...
        try{
        remoteControl.redoButtonWasPushed();
    }
    catch(IOException e){}
    }

    /** Executes when the application stops */
    public void stop() throws IOException{
        Logger log= Logger.getInstance();
        log.getFile().close();
        
        
    }
}
