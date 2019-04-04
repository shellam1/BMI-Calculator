import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.text.DecimalFormat;
public class Calculator {

	protected Shell shell;
	private Text inches;
	private Text feet;
	private Text pounds;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calculator window = new Calculator();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("BMI Calculator");
		
		inches = new Text(shell, SWT.BORDER);
		inches.setBounds(20, 193, 137, 34);
		
		feet = new Text(shell, SWT.BORDER);
		feet.setBounds(20, 120, 137, 34);
		
		pounds = new Text(shell, SWT.BORDER);
		pounds.setBounds(20, 45, 137, 34);
		
		Label lblWeightInPounds = new Label(shell, SWT.NONE);
		lblWeightInPounds.setBounds(20, 10, 121, 20);
		lblWeightInPounds.setText("Weight in pounds");
		
		Label lblHeightInFeet = new Label(shell, SWT.NONE);
		lblHeightInFeet.setBounds(20, 85, 121, 20);
		lblHeightInFeet.setText("Height in feet");
		
		Label lblHeightInInches = new Label(shell, SWT.NONE);
		lblHeightInInches.setBounds(20, 167, 121, 20);
		lblHeightInInches.setText("Height in inches");
		
		Label answerlabel = new Label(shell, SWT.NONE);
		answerlabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		answerlabel.setBounds(238, 119, 167, 31);
		answerlabel.setText("Your BMI is :");

		
		Button clickCalc = new Button(shell, SWT.NONE);
		clickCalc.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int numWeight;
				int numHeight;
				int numFeet;
				int numInches;
				double bodyMassIndex;
				
				try {
					numWeight = Integer.parseInt(pounds.getText());
					numFeet = Integer.parseInt(feet.getText());
					numInches = Integer.parseInt(inches.getText());
					
					numWeight *= 703;
					numHeight = (numFeet * 12) + numInches;
			
			}
				catch (Exception exc)
				{
					MessageDialog.openError(shell,"Error", "bad input");
					return;
				}
				DecimalFormat df = new DecimalFormat("###.##");
				
				bodyMassIndex = numWeight / (Math.pow(numHeight, 2));
				answerlabel.setText("Your BMI is : " + df.format(bodyMassIndex));
			}
		});
		clickCalc.setToolTipText("Caluclate BMI");
		clickCalc.setBounds(261, 43, 90, 30);
		clickCalc.setText("Calculate");
		

	}
}
