package pl.agh.edu.raportex;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	UserInput ui = new UserInput();
		ui.readPath("v0.1");
		int choice = ui.readReportChoice();
    }
}
