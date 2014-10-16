package com.gfs.erm.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.gfs.erm.web.common.WebConstants;

/**
 * This class contain util methods to handler date. 
 */
public final class DateUtil {
	
    /** The basic unit of a day slot used to calc each gantt slot */
    public static final long SLOT_TIME_MILLIS = 86400000;

    /** week slot used to calc each gantt slot */
    public static final long WEEK_SLOT_TIME_MILLIS = 604800000;

    
	/**
	 * The constructor was set to private to avoid instancing creation  
	 */
	private DateUtil(){}
	
	
	/**
	 * Get Current Date/Time
	 */
	public static Timestamp getNow(){
		return new Timestamp(System.currentTimeMillis()); 
	}

	/**
	 * Get Current Date without time information 
	 */	
	public static Timestamp getNowWithoutTime(){
		Timestamp ts = DateUtil.getNow();
		int d = DateUtil.get(ts, Calendar.DATE);
		int m = DateUtil.get(ts, Calendar.MONTH) + 1;
		int y = DateUtil.get(ts, Calendar.YEAR);
		return DateUtil.getDate(d+"", m+"", y+"");
	}
	
	
	/**
	 * Return a string date based on timestamp and a pattern
	 */
	public static String getDate(Timestamp dte, String pattern, Locale loc) {
	    SimpleDateFormat formatter = new SimpleDateFormat(pattern, loc);
	    Date date = new Date(dte.getTime());
	    return formatter.format(date);
	}

	
	public static String getDateTime(Timestamp dte, String pattern) {
	    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	    Date date = new Date(dte.getTime());
	    return formatter.format(date);
	}


	public static String getDateTime(Timestamp dte, String pattern, Locale loc) {
	    SimpleDateFormat formatter = new SimpleDateFormat(pattern, loc);
	    Date date = new Date(dte.getTime());
	    return formatter.format(date);
	}

	
	public static Timestamp getDateTime(String strDate, String pattern, Locale loc) {
	    Timestamp tm = null;
	    SimpleDateFormat sdf = new SimpleDateFormat(pattern, loc); 
		try {	    
		    Date date = sdf.parse(strDate);
		    tm = new Timestamp(date.getTime());
		} catch (ParseException e) {
			tm = null;
		} 
		return tm;
	}

		
	public static Timestamp getDate(Timestamp ts, boolean isInitial){
	    Timestamp response = null;
	    if (ts!=null) {
	    	Calendar c = Calendar.getInstance();
	    	c.setTimeInMillis(ts.getTime());
	        if (isInitial){
	            response = getDateTime(get(ts, Calendar.DATE)+"", get(ts, Calendar.MONTH)+"", get(ts, Calendar.YEAR)+"", "0", "0", "0");
	        } else {
	            response = getDateTime(get(ts, Calendar.DATE)+"", get(ts, Calendar.MONTH)+"", get(ts, Calendar.YEAR)+"", "23", "59", "59");
	        }	    	
	    }
        return response;
	}

	
	/**
	 * Return a timestamp corresponding the arguments
	 */
	public static Timestamp getDate(String day, String month, String year){
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.MONTH, Integer.parseInt(month)-1);
	    c.set(Calendar.YEAR, Integer.parseInt(year));
	    c.set(Calendar.DATE, Integer.parseInt(day));
	    c.set(Calendar.HOUR_OF_DAY, 0);
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
	    c.set(Calendar.MILLISECOND, 0);
	    return new Timestamp(c.getTimeInMillis());	    
	}

	
	/**
	 * Return a timestamp corresponding the arguments
	 */
	public static Timestamp getDateTime(String day, String month, String year, 
	        						String hour, String minute, String second){
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.DATE, Integer.parseInt(day));
	    c.set(Calendar.MONTH, Integer.parseInt(month));
	    c.set(Calendar.YEAR, Integer.parseInt(year));
	    c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
	    c.set(Calendar.MINUTE, Integer.parseInt(minute));
	    c.set(Calendar.SECOND, Integer.parseInt(second));
	    c.set(Calendar.MILLISECOND, 0);
	    return new Timestamp(c.getTimeInMillis());	    
	}
	
	/**
	 * Return a string date and time based on timestamp 
	 */
	public static String getDateTime(Timestamp dte, Locale userLocale, int dateFormat, int timeFormat){
	    DateFormat dtf = DateFormat.getDateTimeInstance(dateFormat, timeFormat, userLocale);
	    return dtf.format(new Date(dte.getTime()));
	}
	
	
	/**
	 * Calculate the number of slots between two dates
	 */
	public static int getSlotBetweenDates(Timestamp iniDate, Timestamp finalDate){
	    return getSlotBetweenDates(iniDate, finalDate, SLOT_TIME_MILLIS, false);
	}

	
	/**
	 * Calculate the number of slots between two dates
	 */	
	public static int getSlotBetweenDates(Timestamp iniDate, Timestamp finalDate, long slotSizeInMillis, boolean considerCeil){
	    int response = 0;
	    if (finalDate.after(iniDate)){
	        long diff = (finalDate.getTime() - iniDate.getTime());
	        double val = (diff / slotSizeInMillis);
	        if (considerCeil) {
	        	val = Math.ceil(((double)diff / (double)slotSizeInMillis));	
	        }
	        response = (int)(val);
	    }
	    return response;
	}
	
	
	/**
	 * Increment/Decrement a timestamp using a type and number.<br> 
	 * The Type argument should be used the constants of Calendar object (ex: Calendar.MONTH, Calendar.WEEK_OF_MONTH, etc). 
	 */
	public static Timestamp getChangedDate(Timestamp iniDate, int incType, int number){
	    Calendar c = Calendar.getInstance();
	    c.setTimeInMillis(iniDate.getTime());
	    c.add(incType, number);
	    return new Timestamp(c.getTimeInMillis());
	}
	
	
	public static int get(Timestamp ts, int type) {
	    int response = -1;
	    Calendar c = Calendar.getInstance();
	    if (ts!=null && type>0 && type<=17){
	    	c.setTimeInMillis(ts.getTime());
	    	response = c.get(type);		    	
	    } else {
	        response = -1;
	    }
	    return response;
	}
	
	public static java.sql.Date getSqlDate(String date1) {
        java.sql.Date sqlDate = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat(WebConstants.DATE_FORMAT);
            java.util.Date parseDate = formater.parse(date1);
            sqlDate = new java.sql.Date(parseDate.getTime());
        } catch(Exception ex) {
        }
        return sqlDate;
    }
    public static java.util.Date getUtilDate(String date1) {
        java.util.Date parseDate = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat(WebConstants.DATE_FORMAT);
            parseDate = formater.parse(date1);

        } catch(Exception ex) {
        }
        return parseDate;
    }
    
    public static java.util.Date getCsvDate(String date1) {
        java.util.Date parseDate = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat(WebConstants.DISPLAY_CAL_CONVERT_DATE_FORMAT);
            parseDate = formater.parse(date1);

        } catch(Exception ex) {
        }
        return parseDate;
    }
    
    public static Timestamp incrementCurrentDateByDays(Integer numberOfDays) {
    	
    	//get current date
    	Timestamp incrementDate = getCurrentTimestamp();
    	
    	long secondsInADay =   (new Long("86400000")).longValue();//24 * 60 * 60 * 1000
         try {
        	 int days = numberOfDays.intValue();
        	 long numofDaysMS = secondsInADay * days;
        	 incrementDate.setTime(incrementDate.getTime() + numofDaysMS);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    
        return incrementDate;
    	
    }
    
     public static Timestamp incrementCurrentDateByHours(Integer numberOfHours) {
    	
    	//get current date
    	Timestamp incrementDate = getCurrentTimestamp();
    	
    	long secondsInAnHour =   (new Long("3600000")).longValue();  // 60 * 60 * 1000
         try {
        	 int hours = numberOfHours.intValue();
        	 long numofDaysMS = secondsInAnHour * hours;
        	 incrementDate.setTime(incrementDate.getTime() + numofDaysMS);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    
        return incrementDate;
    	
    }
    public static String formatDate(String date1) {
        String fdate ="";
        try {
        	SimpleDateFormat formater = new SimpleDateFormat(WebConstants.DATE_FORMAT);
            Date parseDate = formater.parse(date1);
            fdate = formater.format(parseDate);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return fdate;
    }
    
    public static String viewFormatDate(String dt1) {
    	String fdate ="";
    	try {
    		SimpleDateFormat formater = new SimpleDateFormat(WebConstants.DISPLAY_CAL_CONVERT_DATE_FORMAT);
    		Date parseDate = formater.parse(dt1);
    		fdate = formater.format(parseDate);
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return fdate;
    }

    public static String formatMysqlDate(String date1) {
        String fdate ="";
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            Date parseDate = formater.parse(date1);
            formater = new SimpleDateFormat("dd MMM yyyy");
            fdate = formater.format(parseDate);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return fdate;
    }

    public static Date changeMysqlDate(String date1) {
        Date parseDate = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            parseDate = formater.parse(date1);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return parseDate;
    }
    
    public static Timestamp convertTimestamp(String date, String format) {
    	Timestamp parseTime = null;
    	try {
    		parseTime = new Timestamp(convertDate(date, format).getTime());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return parseTime;
    }
    
    public static Date convertDate(String date, String format) {
    	Date parseDate = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat(format);
            parseDate = formater.parse(date);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return parseDate;
    }
    
    
    public static Date convertDate(String sdate) {
    	Date parseDate = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            parseDate = formater.parse(sdate);
            System.out.println("Date: " + parseDate);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return parseDate;
    }
    public static Date csvConvertDate(String csvdate) {
    	Date parseDate = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            csvdate =  dateFormatted(csvdate);
            parseDate = formater.parse(csvdate);
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return parseDate;
    }
    public static Date convertTimestamp(String sdate) {
    	Date parseDate = null;
        if(sdate == null || sdate.equalsIgnoreCase("") || sdate.equalsIgnoreCase("0")){
        	parseDate= new Date();
        }else {
	    	try {
	    		
	    		parseDate=new Date(Long.valueOf(sdate));
	            //System.out.println("Date: " + parseDate);
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        }
        }
        return parseDate;
    }
    
    public static Timestamp convertToTimestamp(String date) {
    	Timestamp currentTimestamp = null;
        
    	Date parseDate = null;
        try {
            SimpleDateFormat formater = new SimpleDateFormat(WebConstants.DATE_FORMAT);
            parseDate = formater.parse(date);
            currentTimestamp = new Timestamp(parseDate.getTime());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return currentTimestamp;
    }

    public static String formatDate(Date date1) {
        String fdate = "";
        SimpleDateFormat formater=null;
        try {
            formater = new SimpleDateFormat(WebConstants.DISPLAY_DATE_FORMAT);
            fdate = formater.format(date1);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return fdate;
    }
    
    public static String formatDate(Date date, String format) {
    	if(date == null || format == null || format.equalsIgnoreCase("")) {
    		return null;	
    	}
        String fdate = "";
        try {
            SimpleDateFormat formater = new SimpleDateFormat(format);
            fdate = formater.format(date);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return fdate;
    }
    
    public static String formatDate(Calendar cal, String format) {
    	String sDate = "";
    	
    	if(cal == null || format == null || format.equalsIgnoreCase("")) {
    		return null;	
    	}
        try {
        	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        	sDate = dateFormat.format(cal.getTime());
        	
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return sDate;
    }
    
    public static String formatDate(Timestamp time, String format) {
    	if(time == null || format == null || "".equalsIgnoreCase(format)) {
    		return null;	
    	} else return formatDate(new Date(time.getTime()), format);
    }
    
    public static String formatDate(Timestamp time) {
    	if(time == null) {
    		return null;	
    	} else return formatDate(new Date(time.getTime()), WebConstants.DATE_FORMAT);
    }
    
    public static Timestamp getCurrentTimestamp() {
    	Timestamp currentTimestamp = null;
        
        try {
        	
        	Calendar calendar = Calendar.getInstance();     
	        java.util.Date now = calendar.getTime();
	        currentTimestamp = new Timestamp(now.getTime());
           
        } catch(Exception ex) {
        }
        return currentTimestamp;
    }
    public static Date getFirstDayofMonth(){
    	Date nowDate = new Date();
    	Calendar c = Calendar.getInstance();
        c.setTime(nowDate);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        return nextDate;
    }
    public static Date getLastDayofMonth(){
    	Date nowDate = new Date();
    	Calendar c = Calendar.getInstance();
        c.setTime(nowDate);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DATE, c.getMaximum(Calendar.DATE));
        Date nextDate = c.getTime();
        return nextDate;
    }
    public static Date getFirstDayofYear(){
    	Date nowDate = new Date();
    	Calendar c = Calendar.getInstance();
        c.setTime(nowDate);
        c.set(Calendar.MONTH, 1);
        c.set(Calendar.DATE, 1);
        Date nextDate = c.getTime();
        return nextDate;
    }
    public static Date getLastDayofYear(){
    	Date nowDate = new Date();
    	Calendar c = Calendar.getInstance();
        c.setTime(nowDate);
        c.set(Calendar.MONTH, 12);
        c.set(Calendar.DATE, c.getMaximum(Calendar.DATE));
        Date nextDate = c.getTime();
        return nextDate;
    }
    public static Date addDays(Date nowDate, int day){
    	
    	Calendar c = Calendar.getInstance();
        c.setTime(nowDate);
        c.add(Calendar.DATE, day);
         Date nextDate = c.getTime();
        return nextDate;
    }
    public static Date subtractDays(Date nowDate, int day){
    	
    	Calendar c = Calendar.getInstance();
        c.setTime(nowDate);
        c.add(Calendar.DATE, - day);
         Date nextDate = c.getTime();
        return nextDate;
    }
    
    public static String dateFormatted(String text){
    	if ((text.charAt(2) == '/' && text.charAt(5) == '/') || (text.charAt(2) == '.' && text.charAt(5) == '.') || (text.charAt(2) == '-' && text.charAt(5) == '-'))
    	    {
    	        text = text.substring(0, 2) + "/" + text.substring(3, 5) + "/" + text.substring(6);
    	    }
    	
    	return text;
    }
    public static Integer dateDifference(Date fromDate, Date toDate){
    	Long day = toDate.getTime() - fromDate.getTime();
		Long days = day / (24 * 60 * 60 * 1000);
        return days.intValue();
    } 
}
