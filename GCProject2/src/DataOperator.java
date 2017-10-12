import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DataOperator {
	public static void main(String[] args) throws IOException {
		String datePattern = "\\d{2}/\\d{2}/\\d{4}";
		String firstInput = " ";
		String secondInput = " ";

		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input first date(MM/DD/YYYY)");
		// obtain first user date input
		firstInput = reader.readLine();
		System.out.println("Input second date(MM/DD/YYYY)");
		// obtain second date input
		secondInput = reader.readLine();
		if (!firstInput.matches(datePattern) && !secondInput.matches(datePattern)) {
			System.out.print("Please try again with appropriate date format");
		}
		final LocalDate firstDate = LocalDate.parse(firstInput, formatter);
		final LocalDate secondDate = LocalDate.parse(secondInput, formatter);
		final long days = ChronoUnit.DAYS.between(firstDate, secondDate);
		System.out.println("There are " + days + " day(s)" + " between " + firstInput + " and " + secondInput);
	}
}
