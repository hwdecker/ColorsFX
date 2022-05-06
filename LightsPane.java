import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import java.io.File;
import javafx.scene.media.AudioClip;

public class LightsPane extends GridPane
{
    private Label rememberLabel, arrayCount, countLabel, gameDescription;
    private Button redButton, greenButton, yellowButton, blueButton, newGameButton, rememberGameButton, endGameButton;
    private HBox hbButtons, hbCount, hbColors;
    private File red, green, yellow, blue;
    private AudioClip redSound, greenSound, yellowSound, blueSound;
    private int [] selectedColors = new int[8];
    private int count = 0;
    
    public LightsPane()
    {
        /*----------------------------------------------------
         * Creation of the font object and all 4 buttons. The 
         * buttons are set as disabled and they are given their 
         * appropriate colors with the setStyle method and 
         * hex value.
         * ---------------------------------------------------
         */
        
        Font font = new Font (18);
        
        redButton = new Button("RED");
        redButton.setOnAction(this::recordColors);
        redButton.setStyle("-fx-background-color: #CC0000");
        redButton.setDisable(true);
        
        greenButton = new Button("GREEN");
        greenButton.setOnAction(this::recordColors);
        greenButton.setStyle("-fx-background-color: #009900");
        greenButton.setDisable(true);        
        
        yellowButton = new Button("YELLOW");
        yellowButton.setOnAction(this::recordColors);
        yellowButton.setStyle("-fx-background-color: #FFFF00");
        yellowButton.setDisable(true);
        
        blueButton = new Button("BLUE");
        blueButton.setOnAction(this::recordColors);
        blueButton.setStyle("-fx-background-color: #0066CC");
        blueButton.setDisable(true);

        /*---------------------------------------------------
         * Three more buttons are made that call the process 
         * buttons method with the setOnAction method. All buttons 
         * are placed into HBoxes for alignment purposes.
         * --------------------------------------------------
         */
        
        HBox hbColors = new HBox(redButton, greenButton, yellowButton, blueButton);
        hbColors.setAlignment(Pos.CENTER);
        hbColors.setSpacing(10);
        
        newGameButton = new Button("New Game");
        newGameButton.setOnAction(this::processButtons);
        
        rememberGameButton = new Button("Remember Game");
        rememberGameButton.setOnAction(this::processButtons);
        rememberGameButton.setDisable(true);
        
        endGameButton = new Button("End Game");
        endGameButton.setOnAction(this::processButtons);
        
        HBox hbButtons = new HBox(newGameButton, rememberGameButton, endGameButton);
        hbButtons.setAlignment(Pos.CENTER);
        hbButtons.setSpacing(10);
                
        countLabel = new Label("Colors Clicked: ");
        countLabel.setFont(font);
        arrayCount = new Label("-");
        arrayCount.setFont(font);
        HBox hbCount = new HBox(countLabel, arrayCount);
        
        gameDescription = new Label("");
        gameDescription.setFont(font);
        
        rememberLabel = new Label("");           
        
        /*---------------------------------------------
         * Four file objects are created with the sound's
         * file name. These objects are placed in four 
         * AudioClip objects and use the toURI method 
         * to get the exact file path of the sound 
         * files.
         * ---------------------------------------------
         */
        
        red = new File("Red.wav");
        green = new File("Green.wav");
        yellow = new File("Yellow.wav");
        blue = new File("Blue.wav");
        
        redSound = new AudioClip(red.toURI().toString());
        greenSound = new AudioClip(green.toURI().toString());
        yellowSound = new AudioClip(yellow.toURI().toString());
        blueSound = new AudioClip(blue.toURI().toString());
        
        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(20);        
        
        add(gameDescription, 0, 0, 1, 1);
        add(hbCount, 0, 1, 1, 1);
        add(hbColors, 0, 2, 1, 1);
        add(rememberLabel, 0, 3, 1, 1);
        add(hbButtons, 0, 4, 1, 1);        
        
    }
        
    /*----------------------------------------------
     * This method uses a counter to go through each 
     * array element and change them to 0, 1, 2, or 3
     * depending on what button is pressed. The gui counter 
     * text is then updated every if statement.
     * ---------------------------------------------
     */
    
    public void recordColors(ActionEvent buttonEvent)
    {   
        if (buttonEvent.getSource() == redButton)
        {
            selectedColors[count] = 0;
            redSound.play();
            count++;
            arrayCount.setText("" + count);
            
        }
            
        else if (buttonEvent.getSource() == greenButton)
        {
            selectedColors[count] = 1;
            greenSound.play();
            count++;
            arrayCount.setText("" + count);
            
        }
            
        else if (buttonEvent.getSource() == yellowButton)
        {
            selectedColors[count] = 2;
            yellowSound.play();
            count++;
            arrayCount.setText("" + count);
            
        }
            
        else if (buttonEvent.getSource() == blueButton)
        {
            selectedColors[count] = 3;
            blueSound.play();
            count++;
            arrayCount.setText("" + count);
            
        }
        
        if (count == selectedColors.length)
        {
            rememberGameButton.setDisable(false);
            redButton.setDisable(true);
            greenButton.setDisable(true);
            yellowButton.setDisable(true);
            blueButton.setDisable(true);
            newGameButton.setDisable(false);
            count = 0;
            
        }
       
    }        
 
    /*-----------------------------------------------
     * This method processes the other three buttons.
     * If the newGameButton is selected the first if 
     * statement body will enable all the color buttons 
     * and disable the new game button. The rememberLabel 
     * and arrayCount labels are then reset.
     * ----------------------------------------------
     */
    
    public void processButtons(ActionEvent buttonEvent)
    {
        if (buttonEvent.getSource() == newGameButton)
        {
            redButton.setDisable(false);
            greenButton.setDisable(false);
            yellowButton.setDisable(false);
            blueButton.setDisable(false);
            newGameButton.setDisable(true);
            arrayCount.setText("" + count);
            rememberLabel.setText("");
            gameDescription.setText("Click 8 color buttons, one at a time.");
            
        }

        /*------------------------------------------------
         * This else if statement looks to see if the 
         * rememberGameButton is selected. If so, a string 
         * variable called list is made as well as a for loop 
         * that goes through each array element. If the array 
         * elements match their associated color number the list 
         * concatenates a the correct color. The list is then 
         * used in the setText method to change the rememberLabel
         * description.
         * -----------------------------------------------
         */
        
        else if (buttonEvent.getSource() == rememberGameButton)
        {
            String list = "";
            
            for (int i = 0; i < selectedColors.length; i++)
            {
                if (selectedColors[i] == 0)
                {
                    list = list + "Red ";
                    
                }
                
                else if (selectedColors[i] == 1)
                {
                    list = list + "Green ";
                    
                }
                
                else if (selectedColors[i] == 2)
                {
                    list = list + "Yellow ";
                    
                }
                else if (selectedColors[i] == 3)
                {
                    list = list + "Blue ";
                    
                }           
            }                                   
            rememberLabel.setText(list);
            
        }
        
        else
        {
            System.exit(0);
            
        }
    }            
        
}
