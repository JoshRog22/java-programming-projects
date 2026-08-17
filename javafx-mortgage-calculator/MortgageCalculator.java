import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

/**
 * @author Joshua Rogers
 * JavaFX mortgage calculator that estimates periodic loan payments
 * and displays a simple house graphic.
 */
public class MortgageCalculator extends Application
{
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10,10,10,10));
        
        //top title
        root.setTop(new Label("Mortgage Payment Calculator"));
        
        //set bottom results
        Label lblResults = new Label ("");
        root.setBottom(lblResults);
        
        //set center inputs
        GridPane center = new GridPane();
        center.setVgap(5);
        center.setHgap(5);
        
        //loan Amount
        center.add(new Label("Loan Amount:"), 0, 0);
        TextField txtLoanAmount = new TextField("0");
        txtLoanAmount.setPrefWidth(100);
        center.add(txtLoanAmount, 1, 0);
        
        //annual Interest Rate amount
        center.add(new Label("Annual Interest Rate"), 0, 1);
        TextField txtIntRate = new TextField("3");
        txtIntRate.setPrefWidth(100);
        center.add(txtIntRate, 1, 1);
        
        //loan Term
        center.add(new Label("No of Years(Loan Term)"), 0, 2);
        TextField txtLoanTerm = new TextField("30");
        txtLoanTerm.setPrefWidth(100);
        center.add(txtLoanTerm, 1, 2);
        
        //no. of payments per year
        center.add(new Label("Payments Per Year"), 0, 3);
        TextField txtPaymentsPerYear = new TextField("12");
        txtPaymentsPerYear.setPrefWidth(100);
        center.add(txtPaymentsPerYear, 1, 3);  
        
        //calculate Button
        Button calculateButton = new Button("Calculate");
        center.add(calculateButton, 1, 4);
        
        root.setCenter(center);
        
        //calculate Button Action
        calculateButton.setOnAction(event -> {
            try
            {
                double principal = Double.parseDouble(txtLoanAmount.getText());
                double annualInterestRate = Double.parseDouble(txtIntRate.getText());
                int loanTermYears = Integer.parseInt(txtLoanTerm.getText());
                int paymentsPerYear = Integer.parseInt(txtPaymentsPerYear.getText());  
                double ratePerPeriod = (annualInterestRate / 100) / paymentsPerYear;
                double numberOfPayments = loanTermYears * paymentsPerYear;
                
                double payment = (principal * ratePerPeriod * Math.pow(1 + ratePerPeriod, numberOfPayments)) 
                                / (Math.pow(1 + ratePerPeriod, numberOfPayments) - 1);//formula for payments
                
                lblResults.setText(String.format("The Monthly Payment is %.2f", payment));//payment line that will only go 2 decimal places
            }
            
            catch (NumberFormatException e)
            {
                lblResults.setText("Invalid Input. Please enter numbers");//output so the user knows to only put numbers
            }
        });
        
        //canvas for the house drawing
        Canvas canvas = new Canvas(150, 150);
        drawHouse(canvas.getGraphicsContext2D());
        root.setRight(canvas);//setRight method
        
        //set the scene
        Scene scene = new Scene(root, 500, 250);
        primaryStage.setTitle("Mortgage Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();       
    }


    //draws house with windows and a door.
    private void drawHouse(GraphicsContext gc) {
        //background
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 150, 150);

        //house base
        gc.setFill(Color.SADDLEBROWN);
        gc.fillRect(40, 60, 70, 70);

        //roof
        gc.setFill(Color.DARKGRAY);
        gc.fillPolygon(new double[]{30, 75, 120}, new double[]{60, 20, 60}, 3);

        //chimney
        gc.setFill(Color.ORANGE);
        gc.fillRect(90, 25, 10, 25);

        //door
        gc.setFill(Color.ORANGE);
        gc.fillRect(65, 100, 20, 30);

        //door window
        gc.setFill(Color.DEEPSKYBLUE);
        gc.fillOval(69, 105, 12, 12);

        //windows
        drawWindow(gc, 45, 70);//top left window
        drawWindow(gc, 90, 70);//top right window
        drawWindow(gc, 45, 105);//bottom left window
        drawWindow(gc, 90, 105);//bottom right window
        drawWindow(gc, 67, 70);//top middle window
    }

    //draws windows for the coordinates above
    private void drawWindow(GraphicsContext gc, double x, double y) {
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(x, y, 15, 15);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, 15, 15);
    }
}
    
