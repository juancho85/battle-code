package com.jds.battlecode.dates;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Weeks;
import org.joda.time.Years;

public class ElapsedDates {

	DateTime lowerBound;
	DateTime upperBound;

	public ElapsedDates(DateTime lowerBound, DateTime upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public void executeLogic() {
		int d = Days.daysBetween(lowerBound, upperBound).getDays();
		int w = Weeks.weeksBetween(lowerBound, upperBound).getWeeks();
		int m = Months.monthsBetween(lowerBound, upperBound).getMonths();
		int y = Years.yearsBetween(lowerBound, upperBound).getYears();
		System.out.printf("Years: %d, Months: %d, Weeks: %d, Days: %d%n", y, m % 12, w % 52, d - (w*7));
	}

}
