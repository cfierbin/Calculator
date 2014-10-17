package application;

import javax.annotation.PostConstruct;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

public class CalculatorController{

	@FXML
	private TextField number1TextField;
	
	@FXML
	private TextField number2TextField;
	
	@FXML
	private TextField sumTextField;
	
	@FXML
	private TextField difTextField;
	
	@FXML
	private TextField multTextField;
	
	@FXML
	private TextField divTextField;
	
//	private NumberBinding sum, dif, mult, div;
	private DoubleProperty num1, num2, suma, dif, mult, div;
	
	@PostConstruct
	@FXML
	private void initialize(){
		
		num1 = new SimpleDoubleProperty(1);
	    num2 = new SimpleDoubleProperty(2);
	    
	    suma = new SimpleDoubleProperty();
	    dif = new SimpleDoubleProperty();
	    mult = new SimpleDoubleProperty();
	    div = new SimpleDoubleProperty();
	    
		suma.bind(num1.add(num2));
		dif.bind(num1.subtract(num2));
		mult.bind(num1.multiply(num2));
		div.bind(num1.divide(num2));
		
		StringConverter<? extends Number> converter =  new DoubleStringConverter();
		
		Bindings.bindBidirectional(number1TextField.textProperty(), num1, (StringConverter<Number>)converter);
		Bindings.bindBidirectional(number2TextField.textProperty(), num2, (StringConverter<Number>)converter);
		
		Bindings.bindBidirectional(sumTextField.textProperty(), suma, (StringConverter<Number>)converter);
		Bindings.bindBidirectional(difTextField.textProperty(), dif, (StringConverter<Number>)converter);
		Bindings.bindBidirectional(multTextField.textProperty(), mult, (StringConverter<Number>)converter);
		Bindings.bindBidirectional(divTextField.textProperty(), div, (StringConverter<Number>)converter);


	}

	
}
