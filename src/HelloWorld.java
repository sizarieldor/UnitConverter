import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class HelloWorld {
    private JPanel rootPanel;
    private JLabel labelTitle;
    private JLabel labelCurrentUnit;
    private JButton button1Length;
    private JButton button5Temperature;
    private JButton button2Area;
    private JButton button6Time;
    private JButton button3Volume;
    private JButton button7Speed;
    private JButton button4Weight;
    private JButton buttonConvert;
    private JComboBox <String> comboBox1;
    private JTextField textField1;
    private JComboBox <String> comboBox2;
    private JTextField textField2;
    private JLabel labelTo;
    private JLabel labelPreviousConversion;



    public HelloWorld() {


        //listeners for gui buttons
        buttonConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double input = Double.parseDouble(textField1.getText());
                String inputUnit = comboBox1.getSelectedItem().toString();
                String outputUnit = comboBox2.getSelectedItem().toString();

                double result = performConversion(currentDimensionOfConversion,inputUnit,outputUnit,input); //call method to calculate

                //format result
                DecimalFormat fmt = new DecimalFormat("#.#####");
                String resultFmtd = fmt.format(result); //this returns a String

                textField2.setText(resultFmtd); //print result in the GUI

                //update last calculation
                previousInput = textField1.getText();
                previousInputUnit = inputUnit;
                previousOutput = textField2.getText();
                previousOutputUnit = outputUnit;
                String previousCalculation = "The previous conversion was: \r\n" + previousInput + " " + previousInputUnit + " equal " + previousOutput + " " + previousOutputUnit;
                //String string = ("The previous calculation was: %s %s equal %s %s");

                labelPreviousConversion.setText(previousCalculation);
            }

        });

        button1Length.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentUnit.setText("Currently converting length"); //update labels
                textField1.setText(""); //empty the text fields
                textField2.setText("");
                currentDimensionOfConversion = "Length";

                ChangeComboBoxLength(); //run method that updates the drop-down menus
            }
        });
        button2Area.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentUnit.setText("Currently converting area");
                currentDimensionOfConversion = "Area";
                textField1.setText(""); //empty the text fields
                textField2.setText("");

                ChangeComboBoxArea();
            }
        });
        button3Volume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentUnit.setText("Currently converting volume");
                currentDimensionOfConversion = "Volume";
                textField1.setText(""); //empty the text fields
                textField2.setText("");

                ChangeComboBoxVolume();
            }
        });
        button4Weight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentUnit.setText("Currently converting weight");
                currentDimensionOfConversion ="Weight";
                textField1.setText(""); //empty the text fields
                textField2.setText("");

                ChangeComboBoxWeight();
            }
        });
        button5Temperature.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentUnit.setText("Currently converting temperature");
                currentDimensionOfConversion ="Temperature";
                textField1.setText(""); //empty the text fields
                textField2.setText("");

                ChangeComboBoxTemperature();
            }
        });
        button6Time.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentUnit.setText("Currently converting time");
                currentDimensionOfConversion ="Time";
                textField1.setText(""); //empty the text fields
                textField2.setText("");

                ChangeComboBoxTime();
            }
        });
        button7Speed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCurrentUnit.setText("Currently converting speed");
                currentDimensionOfConversion ="Speed";
                textField1.setText(""); //empty the text fields
                textField2.setText("");

                ChangeComboBoxSpeed();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Unit Converter");
        frame.setContentPane(new HelloWorld().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(700,400);
        frame.setResizable(false); //yesssssss
        //Dimension MainWindowDimension = new Dimension(500,500); not needed
        //frame.setPreferredSize(MainWindowDimension); not needed

//        frame.setContentPane(new HelloWorld().convertDistancePanel);
//
//        //create a menubar
//        JMenuBar MyMenuBar = new JMenuBar();
//        frame.setJMenuBar(MyMenuBar);
//
//        JMenu Menu = new JMenu("Menu"); //create a menu button
//        MyMenuBar.add(Menu); //add button to menubar
//        //populate menu
//        JMenuItem SelectLength = new JMenuItem("Convert Length");
//        Menu.add(SelectLength);
//
//        JMenuItem SelectTemperature = new JMenuItem("Convert Temperature");
//        Menu.add(SelectTemperature);
//
//        JMenuItem Exit = new JMenuItem("Exit");
//        Menu.add(Exit);
//
//        JMenu About = new JMenu("About..."); //create an About button
//        MyMenuBar.add(About); //add the About button to the menu
//        //populate About menu:
//        JMenuItem MenuAbout = new JMenuItem("About...");
//        About.add(MenuAbout);
//
//        //action listeners for menu buttons
//        SelectLength.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//
//            }
//        });
//
//        SelectTemperature.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        Exit.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

    }

    String[] unitsLength = {"Millimeters" ,"Centimeters","Decimeters","Meters","Kilometers","Inches","Feet","Yards","Miles", "Nautical Miles"};
    String[] unitsArea = {"Millimeters²","Centimeters²","Decimeters²","Meters²","Kilometers²","Inches²","Feet²","Yards²","Miles²", "Acres", "Hectares"};
    String[] unitsVolume ={"Milliliters","Liters","US Pints","US Quarts","US Gallons",
            "GB Pints","GB Quarts","GB Gallons","Oil Barrels",
            "Millimeters³" ,"Centimeters³","Meters³","Kilometers³","Inches³","Feet³","Yards³","Miles³"};
    String[] unitsWeight={"Micrograms", "Milligrams", "Grams", "Kilograms", "Stone", "Metric Tonnes", "Pounds", "Ounces", "Imperial Tons", "US Tons"};
    String[] unitsTemperature={"Degrees Kelvin", "Degrees Celsius", "Degrees Fahrenheit"};
    String[] unitsTime = {"Nanoseconds", "Microseconds", "Milliseconds", "Seconds", "Minutes", "Hours", "Days", "Weeks", "Months", "Calendar years", "Decades", "Centuries"};
    String[] unitsSpeed ={"Meters per second", "Kilometers per second", "Kilometers per hour", "Miles per second", "Miles per hour", "Feet per second", "Knots"};
    //source: AskNumbers.com, Google

    String currentDimensionOfConversion ="";


    public void ChangeComboBoxLength(){
        comboBox1.removeAllItems();
        comboBox2.removeAllItems();
        for (String unit: unitsLength) {
            comboBox1.addItem(unit);
            comboBox2.addItem(unit);
        }
    }

    public void ChangeComboBoxArea(){
        comboBox1.removeAllItems();
        comboBox2.removeAllItems();
        for (String unit: unitsArea) {
            comboBox1.addItem(unit);
            comboBox2.addItem(unit);
        }
    }

    public void ChangeComboBoxVolume(){
        comboBox1.removeAllItems();
        comboBox2.removeAllItems();
        for (String unit: unitsVolume) {
            comboBox1.addItem(unit);
            comboBox2.addItem(unit);
        }
    }
    public void ChangeComboBoxWeight(){
        comboBox1.removeAllItems();
        comboBox2.removeAllItems();
        for (String unit: unitsWeight) {
            comboBox1.addItem(unit);
            comboBox2.addItem(unit);
        }
    }

    public void ChangeComboBoxTemperature(){
        comboBox1.removeAllItems();
        comboBox2.removeAllItems();
        for (String unit: unitsTemperature) {
            comboBox1.addItem(unit);
            comboBox2.addItem(unit);
        }
    }

    public void ChangeComboBoxTime(){
        comboBox1.removeAllItems();
        comboBox2.removeAllItems();
        for (String unit:unitsTime) {
            comboBox1.addItem(unit);
            comboBox2.addItem(unit);

        }
    }

    public void ChangeComboBoxSpeed(){
        comboBox1.removeAllItems();
        comboBox2.removeAllItems();
        for (String unit: unitsSpeed) {
            comboBox1.addItem(unit);
            comboBox2.addItem(unit);
        }
    }

    public double performConversion(String currentUnitOfConversion, String inputUnit, String outputUnit, double input) {
        double outputToDefault = 0.0;
        double output = 0.0;

        //convert input value into meters/meters^2/grams/degrees K/seconds/... - the default SI unit
        //return outputToDefault
        switch (currentUnitOfConversion){
            case "Length": //target unit is Meters -- conversion to default unit
                switch (inputUnit) {
                    case "Millimeters": outputToDefault = input*0.001; break;
                    case "Centimeters": outputToDefault = input*0.01; break;
                    case "Decimeters": outputToDefault=input*0.1; break;
                    case "Meters":outputToDefault=input*1; break;
                    case "Kilometers":outputToDefault = input*1000; break;
                    case "Inches":outputToDefault=input*0.0254; break;
                    case "Feet":outputToDefault=input*0.3048; break;
                    case "Yards":outputToDefault=input*0.9144; break;
                    case "Miles":outputToDefault=input*1609.344; break;
                    case "Nautical Miles": outputToDefault=input*1852; break;
                }
            case "Area": //target unit is Meters^2-- conversion to default unit
                switch(inputUnit){
                    case "Millimeters²": outputToDefault=input*0.000001; break;
                    case "Centimeters²":outputToDefault=input*0.0001; break;
                    case "Decimeters²": outputToDefault=input*0.01; break;
                    case "Meters²":outputToDefault=input*1; break;
                    case "Kilometers²":outputToDefault=input*1000000; break;
                    case "Inches²": outputToDefault=input*0.00064516; break;
                    case "Feet²": outputToDefault=input*0.092903; break;
                    case "Yards²": outputToDefault=input*0.836127; break;
                    case "Miles²": outputToDefault=input*2589988.1103; break;
                    case "Acres": outputToDefault=input*4046.856422; break;
                    case "Hectares":outputToDefault=input*10000; break;
                }
                break;
            case "Volume": //target unit is Meters^3 -- conversion to default unit
                switch (inputUnit){
                    case "Milliliters": outputToDefault=input*0.000001; break;
                    case "Liters":outputToDefault=input*0.001; break;
                    case "US Pints": outputToDefault=input*0.000473176; break;
                    case "US Quarts": outputToDefault=input*0.000946353; break;
                    case "US Gallons": outputToDefault=input*0.00378541; break;
                    case "GB Pints": outputToDefault=input*0.000568261; break;
                    case "GB Quarts": outputToDefault=input*0.00113652; break;
                    case "GB Gallons": outputToDefault=input*0.00454609; break;
                    case "Oil Barrels": outputToDefault=input*0.158987; break;
                    case "Millimeters³": outputToDefault=input*0.000000001; break;
                    case "Centimeters³":outputToDefault=input*0.000001; break;
                    case "Meters³": outputToDefault=input*1; break;
                    case "Kilometers³": outputToDefault=input*1000000000; break;
                    case "Inches³":outputToDefault=input*0.000016387; break;
                    case "Feet³": outputToDefault=input*0.028316736; break;
                    case "Yards³":outputToDefault=input*0.764555; break;
                    case "Miles³": outputToDefault=input*0.000000004168; break;
                }
                break;
            case "Weight": // target unit is Kilograms -- conversion to default unit
                switch (inputUnit){
                    case "Stone": outputToDefault=input*6.35029; break;
                    case "Pounds": outputToDefault=input*0.453592; break;
                    case "Ounces": outputToDefault=input*0.0283495; break;
                    case "Imperial Tons": outputToDefault=input*1016.05; break;
                    case "US Tons": outputToDefault=input*907.185; break;
                    case "Metric Tonnes": outputToDefault=input*1000; break;
                    case "Kilograms": outputToDefault=input*1; break;
                    case "Grams": outputToDefault=input*0.001; break;
                    case "Milligrams": outputToDefault=input*0.000001; break;
                    case "Micrograms": outputToDefault=input*0.000000001; break;
                }
                break;
            case "Temperature": // outputToDefault is in degrees Kelvin -- conversion to default unit
                switch (inputUnit){
                    case "Degrees Kelvin": outputToDefault=input*1; break;
                    case "Degrees Celsius": outputToDefault=input+273.15; break;
                    case "Degrees Fahrenheit": outputToDefault=(input-32)*(5/9.0)+273.15; break;
                }
                break;
            case "Time": // outputToDefault is in seconds -- conversion to default unit
                switch(inputUnit){
                    case "Nanoseconds": outputToDefault=input*0.000000001; break;
                    case "Microseconds": outputToDefault=input*0.000001; break;
                    case "Milliseconds": outputToDefault=input*0.001; break;
                    case "Seconds": outputToDefault=input*1; break;
                    case "Minutes": outputToDefault=input*60; break;
                    case "Hours": outputToDefault=input*3600; break;
                    case "Days": outputToDefault=input*86400; break;
                    case "Weeks": outputToDefault=input*604800; break;
                    case "Months": outputToDefault=input*2628000; break;
                    case "Calendar years": outputToDefault=input*31540000; break;
                    case "Decades":outputToDefault=input*315400000; break;
                    case "Centuries": outputToDefault=input*3154000000.0; break;
                }
                break;
            case "Speed": // outputToDefault is in  meters per second -- conversion to default unit
                switch (inputUnit){
                    case "Meters per second": outputToDefault=input*1; break;
                    case "Kilometers per second": outputToDefault=input*1000; break;
                    case "Kilometers per hour": outputToDefault=input*0.277777778; break;
                    case "Miles per second": outputToDefault=input*1609.34; break;
                    case "Miles per hour": outputToDefault=input*0.44704; break;
                    case "Feet per second": outputToDefault=input*0.3048; break;
                    case "Knots": outputToDefault=input*0.514444; break;
                }
                break;
        }

        //convert outputToDefault from the default SI unit to the unit chosen by the user in comboBox2 (String outputUnit)
        //return double output - the main result
        switch (currentUnitOfConversion){
            case "Length": //default unit is meters -- conversion to output unit
                switch (outputUnit) {
                    case "Millimeters": output = outputToDefault*1000.0; break;
                    case "Centimeters": output = outputToDefault*100.0; break;
                    case "Decimeters": output=outputToDefault*10.0; break;
                    case "Meters":output=outputToDefault*1; break;
                    case "Kilometers":output = outputToDefault*0.001; break;
                    case "Inches":output=outputToDefault*39.370079; break;
                    case "Feet":output=outputToDefault*3.28084; break;
                    case "Yards":output=outputToDefault*1.093613; break;
                    case "Miles":output=outputToDefault*0.0006213710227; break;
                    case "Nautical Miles": output=outputToDefault*0.000539957; break;
                }
            case "Area": //default unit is Meters^2 -- conversion to output unit
                switch(outputUnit){
                    case "Millimeters²": output=outputToDefault*1000000; break;
                    case "Centimeters²": output=outputToDefault*10000; break;
                    case "Decimeters²": output=outputToDefault*100; break;
                    case "Meters²": output=outputToDefault*1; break;
                    case "Kilometers²": output=outputToDefault*0.000001; break;
                    case "Inches²": output=outputToDefault*1550; break;
                    case "Feet²": output=outputToDefault*10.7639; break;
                    case "Yards²": output=outputToDefault*1.19599; break;
                    case "Miles²": output=outputToDefault*0.000000386102; break;
                    case "Acres": output=outputToDefault*0.000247105; break;
                    case "Hectares": output=outputToDefault*0.0001; break;
                }
                break;
            case "Volume": //default unit is Meters^3 -- conversion to output unit
                switch (outputUnit){
                    case "Milliliters": output=outputToDefault*1000000; break;
                    case "Liters": output=outputToDefault*1000; break;
                    case "US Pints": output=outputToDefault*2113.38; break;
                    case "US Quarts": output=outputToDefault*1056.69; break;
                    case "US Gallons": output=outputToDefault*264.172; break;
                    case "GB Pints": output=outputToDefault*1759.75; break;
                    case "GB Quarts": output=outputToDefault*879.877; break;
                    case "GB Gallons": output=outputToDefault*219.969; break;
                    case "Oil Barrels": output=outputToDefault*6.28981; break;
                    case "Millimeters³":output=outputToDefault*1000000000; break;
                    case "Centimeters³":output=outputToDefault*1000000; break;
                    case "Meters³": output=outputToDefault*1; break;
                    case "Kilometers³": output=outputToDefault*0.000000001; break;
                    case "Inches³": output=outputToDefault*61023.7; break;
                    case "Feet³": output=outputToDefault*35.3147; break;
                    case "Yards³": output=outputToDefault*1.30795; break;
                    case "Miles³": output=outputToDefault*0.000000000239913; break;
                }
                break;
            case "Weight": // default unit is Kilograms -- conversion to output unit
                switch (outputUnit){
                    case "Stone": output=outputToDefault*0.157473; break;
                    case "Pounds": output=outputToDefault*2.20462; break;
                    case "Ounces": output=outputToDefault*35.274; break;
                    case "Imperial Tons": output=outputToDefault*0.000984207; break;
                    case "US Tons": output=outputToDefault*0.00110231; break;
                    case "Metric Tonnes": output=outputToDefault*0.001; break;
                    case "Kilograms": output=outputToDefault*1; break;
                    case "Grams": output=outputToDefault*1000; break;
                    case "Milligrams": output=outputToDefault*1000000; break;
                    case "Micrograms": output=outputToDefault*1000000000; break;
                }
                break;
            case "Temperature": //default unit is kelvin -- conversion to output unit
                switch (outputUnit){
                    case "Degrees Kelvin": output=outputToDefault*1.0;  break;
                    case "Degrees Celsius": output=outputToDefault-273.15; break;
                    case "Degrees Fahrenheit":output=(outputToDefault-273.15)*(9.0/5)+32; break;
                }
                break;
            case "Time": //default unit is second -- conversion to output unit
                switch (outputUnit){
                    case "Nanoseconds": output=outputToDefault*1000000000; break;
                    case "Microseconds":output=outputToDefault*1000000; break;
                    case "Milliseconds": output=outputToDefault*1000; break;
                    case "Seconds": output=outputToDefault*1; break;
                    case "Minutes": output=outputToDefault*0.016666667; break;
                    case "Hours": output=outputToDefault*0.000277778; break;
                    case "Days": output=outputToDefault*0.000011574; break;
                    case "Weeks": output=outputToDefault*0.0000016534; break;
                    case "Months": output=outputToDefault*0.00000038052; break;
                    case "Calendar years": output=outputToDefault*0.00000003171; break;
                    case "Decades": output=outputToDefault*0.000000003171; break;
                    case "Centuries": output=outputToDefault* 0.0000000003171; break;
                }
                break;
            case "Speed": //default unit is meters per second -- conversion to output unit
                switch (outputUnit){
                    case "Meters per second": output=outputToDefault*1; break;
                    case "Kilometers per second": output=outputToDefault*0.001; break;
                    case "Kilometers per hour": output=outputToDefault*3.6; break;
                    case "Miles per second": output=outputToDefault*0.000621371; break;
                    case "Miles per hour": output=outputToDefault*2.23694; break;
                    case "Feet per second": output=outputToDefault*3.28084; break;
                    case "Knots": output=outputToDefault*1.94384; break;
                }
                break;
        }
        return output;
    }

    //used in displaying the user's previous calculation
    String previousInputUnit ="";
    String previousInput = "";
    String previousOutputUnit="";
    String previousOutput = "";

    private void createUIComponents() {
        // TODO: place custom component creation code here
        labelTitle.setSize(500,500);
    }
}

//TODO export and upload to Github