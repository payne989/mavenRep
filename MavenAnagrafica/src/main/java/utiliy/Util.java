package utiliy;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Util {

	public static java.sql.Date stringToSQLDate(String data) {

		java.sql.Date date = null;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			java.util.Date parsed = format.parse(data);
			date = new java.sql.Date(parsed.getTime());
		} catch (ParseException e) {

			e.printStackTrace();

		}
		return date;

	}
	public static java.util.Date stringToUtilDate(String data) {

		java.util.Date date = null;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			java.util.Date parsed = format.parse(data);
			date = new java.util.Date(parsed.getTime());
		} catch (ParseException e) {

			e.printStackTrace();

		}
		return date;

	}

}
