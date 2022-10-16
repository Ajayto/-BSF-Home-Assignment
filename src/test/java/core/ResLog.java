package core;

/**
 * @class ResLog
 * @author Giuseppe.Lipari
 * @description Results Logging Class to print and log the print statements
 * and results to console
 */
public class ResLog {
	public static final String ANSI_RESET 	= "\u001B[0m";
	public static final String ANSI_BLACK 	= "\u001B[30m";
	public static final String ANSI_RED 	= "\u001B[31m";
	public static final String ANSI_GREEN 	= "\u001B[32m";
	public static final String ANSI_YELLOW 	= "\u001B[33m";
	public static final String ANSI_BLUE 	= "\u001B[34m";
	public static final String ANSI_PURPLE 	= "\u001B[35m";
	public static final String ANSI_CYAN 	= "\u001B[36m";
	public static final String ANSI_WHITE 	= "\u001B[37m";
	
	/**@function printLine() 
	 * @description Print a newline in console 
	 */
	public void printLine() {
		System.out.println();
	}
	/**@function logPass() 
	 * @description Print a Log Pass Result to console with "QAPass: " added to string to 
	 * denote its a QA pass statement in green color
	 * @param inPass pass string to print
	 */
	public void logPass(String inPass) {
		System.out.println(ANSI_GREEN + "QAPass: " + inPass + ANSI_RESET);
	}
	
	/**@function logFail() 
	 * @description Print a Log Fail Result to console with "QAFail: " added to string to 
	 * denote its a QA fail statement in red color
	 * @param inFail fail string to print
	 */
	public void logFail(String inFail) {
		System.err.println(ANSI_RED + "QAFail: " + inFail + ANSI_RESET);
	}

	/**@function logWarning() 
	 * @description Print a Log Warning Result to console with "QAWARNING: " added to string to 
	 * denote its a QA warning statement in red color
	 * @param inWarning Warning string to print
	 */
	public void logWarning(String inWarning) {
		System.err.println(ANSI_PURPLE + "QAWarning: " + inWarning + ANSI_RESET);
	}
	
	/**@function print()
	 * @description Print a string to console "QA: " added to string to 
	 * denote its a QA print statement in cyan color
	 * @param inPrint string to print
	 */
	public void print(String inPrint) {
		System.out.println(ANSI_CYAN + "QA: " + inPrint + ANSI_RESET);
	}

	/**@function printObject()
	 * @description Print a object to console "QA: " added to string to 
	 * denote its a QA print statement in cyan color
	 * @param inPrint object to print
	 */
	public void printObject(Object inObject) {
		System.out.println(ANSI_CYAN + "QA: " + inObject + ANSI_RESET);
	}}
