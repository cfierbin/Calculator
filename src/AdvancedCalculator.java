

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Cristina
 */
public class AdvancedCalculator extends Application {
	
    TextField displayField = new TextField();
    
	//public API

	public String getDisplayFieldValue() {
		return displayField.getText();
	}

	public void setDisplayFieldValue(String val) {
		this.displayField.setText(val);
	}
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	//create calculator engine (mouse event handler)
    	CalculatorEngine calcEngine = new CalculatorEngine(this);
    	
        primaryStage.setTitle("Calculator");
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        Group group = new Group();
        Scene scene = new Scene(group, 390, 230, Color.WHITESMOKE);
        
        GridPane root = new GridPane();        
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10));
        
        Menu edit = new Menu("Edit");
        Menu view = new Menu("View");
        Menu help = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(edit);
        menuBar.getMenus().add(view);
        menuBar.getMenus().add(help);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        
        // display field
        GridPane.setRowSpan(displayField, 1);
        GridPane.setColumnSpan(displayField,2);
        //GridPane.setHalignment(displayField, HPos.RIGHT);
        displayField.setScaleX(1.0);
        displayField.setPrefWidth(350.0);
        
        //first row of cells
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.BASELINE_RIGHT);
        GridPane.setRowSpan(hbox, 1);
        GridPane.setColumnSpan(hbox,2);
        GridPane.setHalignment(hbox, HPos.RIGHT);
        hbox.setScaleX(1.0);
        hbox.setPrefWidth(350.0);
        
        Button backspace = new Button();
        backspace.setText("Backspace");
        backspace.setPrefWidth(90);
        backspace.setOnMouseClicked(calcEngine);
        
        Button ce = new Button();
        ce.setText("CE");
        ce.setPrefWidth(90);
        ce.setOnMouseClicked(calcEngine);
        
        Button c = new Button();
        c.setText("C");
        c.setPrefWidth(90);
        c.setOnMouseClicked(calcEngine);
        
        hbox.getChildren().add(backspace);
        hbox.getChildren().add(ce);
        hbox.getChildren().add(c);
        
        //MC, MR, MS, M+
        
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        //vbox.setAlignment(Pos.BASELINE_RIGHT);
        GridPane.setRowSpan(vbox, 4);
        GridPane.setColumnSpan(vbox,1);
        GridPane.setValignment(vbox, VPos.BOTTOM);
        vbox.setScaleY(1.0);
        //vbox.setPrefWidth(400.0);
        
        Button mc = new Button();
        mc.setText("MC");
        mc.setPrefWidth(50);
        mc.setOnMouseClicked(calcEngine);
        
        Button mr = new Button();
        mr.setText("MR");
        mr.setPrefWidth(50);
        mr.setOnMouseClicked(calcEngine);
        
        Button ms = new Button();
        ms.setText("MS");
        ms.setPrefWidth(50);
        ms.setOnMouseClicked(calcEngine);
        
        Button mPlus = new Button();
        mPlus.setText("M+");
        mPlus.setPrefWidth(50);
        mPlus.setOnMouseClicked(calcEngine);
        
        vbox.getChildren().add(mc);
        vbox.getChildren().add(mr);
        vbox.getChildren().add(ms);
        vbox.getChildren().add(mPlus);
        
        //the rest
        GridPane moreButtons = new GridPane();        
        moreButtons.setHgap(10);
        moreButtons.setVgap(10);
        moreButtons.setPadding(new Insets(0,0,0,15));
        
        Button seven = new Button("7");
        seven.setPrefWidth(50);
        moreButtons.add(seven,0,0);
        seven.setOnMouseClicked(calcEngine);
        
        Button eight = new Button("8");
        eight.setPrefWidth(50);
        moreButtons.add(eight,1,0);
        eight.setOnMouseClicked(calcEngine);
        
        Button nine = new Button("9");
        nine.setPrefWidth(50);
        moreButtons.add(nine,2,0);
        nine.setOnMouseClicked(calcEngine);
        
        Button div = new Button("/");
        div.setPrefWidth(50);
        moreButtons.add(div,3,0);
        div.setOnMouseClicked(calcEngine);
        
        Button sqrt = new Button("sqrt");
        moreButtons.add(sqrt,4,0);
        sqrt.setPrefWidth(50);
        sqrt.setOnMouseClicked(calcEngine);
        
        Button four = new Button("4");
        four.setPrefWidth(50);
        moreButtons.add(four,0,1);
        four.setOnMouseClicked(calcEngine);
        
        Button five = new Button("5");
        five.setPrefWidth(50);
        moreButtons.add(five,1,1);
        five.setOnMouseClicked(calcEngine);
        
        Button six = new Button("6");
        six.setPrefWidth(50);
        moreButtons.add(six,2,1);
        six.setOnMouseClicked(calcEngine);
        
        Button mult = new Button("*");
        mult.setPrefWidth(50);
        moreButtons.add(mult,3,1);
        mult.setOnMouseClicked(calcEngine);
        
        Button mod = new Button("%");
        mod.setPrefWidth(50);
        moreButtons.add(mod,4,1);
        mod.setOnMouseClicked(calcEngine);
        
        Button one = new Button("1");
        one.setPrefWidth(50);
        moreButtons.add(one,0,2);
        one.setOnMouseClicked(calcEngine);
        
        Button two = new Button("2");
        two.setPrefWidth(50);
        moreButtons.add(two,1,2);
        two.setOnMouseClicked(calcEngine);
        
        Button three = new Button("3");
        three.setPrefWidth(50);
        moreButtons.add(three,2,2);
        three.setOnMouseClicked(calcEngine);
        
        Button dot = new Button(".");
        dot.setPrefWidth(50);
        moreButtons.add(dot,3,2);
        dot.setOnMouseClicked(calcEngine);
        
        Button inv = new Button("1/x");
        moreButtons.add(inv,4,2);
        inv.setPrefWidth(50);
        inv.setOnMouseClicked(calcEngine);
        
        Button zero = new Button("0");
        zero.setPrefWidth(50);
        moreButtons.add(zero,0,3);
        zero.setOnMouseClicked(calcEngine);
        
        Button pm = new Button("+/-");
        pm.setPrefWidth(50);
        moreButtons.add(pm,1,3);
        pm.setOnMouseClicked(calcEngine);
        
        Button minus = new Button("-");
        minus.setPrefWidth(50);
        moreButtons.add(minus,2,3);
        minus.setOnMouseClicked(calcEngine);
        
        Button plus = new Button("+");
        plus.setPrefWidth(50);
        moreButtons.add(plus,3,3);
        plus.setOnMouseClicked(calcEngine);
        
        Button egal = new Button("=");
        egal.setPrefWidth(50);
        moreButtons.add(egal,4,3);
        egal.setOnMouseClicked(calcEngine);
        
        //construct interface
        root.add(displayField, 0, 2);
        root.add(hbox, 0, 3);
        root.add(vbox, 0, 4);
        root.add(moreButtons, 1, 4);
        
        group.getChildren().add(menuBar);
        group.getChildren().add(root);
 
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    class CalculatorEngine implements EventHandler<MouseEvent>
    {
    	AdvancedCalculator parent;
    	
    	String firstNumber, operator, secondNumber;
    	double result;
    	
    	CalculatorEngine(AdvancedCalculator parent){
    		this.parent = parent;
    	}
    	  	
    	public void displayDigit(Button clickedButton){
    		String dispFieldText = parent.getDisplayFieldValue();
    		String clickedButtonLabel = clickedButton.getText();
    		parent.setDisplayFieldValue(dispFieldText + clickedButtonLabel);
    	}

		@Override
		public void handle(MouseEvent arg0) {
			Button clickedButton = (Button) arg0.getSource();
			
			switch(clickedButton.getText()){
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "0":
			case ".":
				displayDigit(clickedButton);
				break;
			case "+":
			case "-":
			case "/":
			case "*":
				// store first number and operator in corresponding variables
				firstNumber = parent.getDisplayFieldValue();
				operator = clickedButton.getText();
				// erase the number from the display
				parent.setDisplayFieldValue("");
				//print info on system console
				System.out.println("The first number is: " + firstNumber);
				System.out.println("The operation required is: " + operator);
				break;
			case "=":
				//print info on system console
				System.out.println("The second number is: " + parent.getDisplayFieldValue());
				System.out.println("The operation required is " + operator);
				
				//perform the selected action
				try {	
					if ("+".equals(operator)) {
						result = Double.parseDouble(parent.getDisplayFieldValue()) + Double.parseDouble(firstNumber);
					}
					if ("-".equals(operator)) {
						result =  Double.parseDouble(firstNumber) - Double.parseDouble(parent.getDisplayFieldValue());
					}
					if ("*".equals(operator)) {
						result =  Double.parseDouble(firstNumber) * Double.parseDouble(parent.getDisplayFieldValue());
					}
					if ("/".equals(operator)) {
						result =  Double.parseDouble(firstNumber) / Double.parseDouble(parent.getDisplayFieldValue());
					}
				}
				catch(Exception exception){
						JOptionPane.showMessageDialog(null, "An exception occured!", "Exception", JOptionPane.ERROR_MESSAGE);	
					}			
				//store result in firstNumber
				firstNumber = String.valueOf(result);
				//display the result
				parent.setDisplayFieldValue(firstNumber);
				break;
			case "Backspace":
				JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "CE":
				JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "C":
				JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "MC":
				JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "MR":
				JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "MS":
				JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "M+":
				JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "sqrt":
				JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "%":
				JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "1/x":
				JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "+/-":
				JOptionPane.showMessageDialog(null, "Not yet implemented!", "Not implemented!", JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Undefined action", "Undefined action", JOptionPane.INFORMATION_MESSAGE);;	
			}
			
		}

			
		}
    	
    }
    	

