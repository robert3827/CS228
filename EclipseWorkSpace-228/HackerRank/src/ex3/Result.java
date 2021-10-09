package ex3;


class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    String ans;
    String hours = s.substring(0, 2);
    String minutes = s.substring(3,5);
    String seconds = s.substring(6,8);
    String AMPM = s.substring(s.length()-2,s.length());
    
    
//    System.out.println(hours + " " + minutes + " " + seconds + " " + AMPM);
    Integer numHours = Integer.parseInt(hours);
    if(numHours == 12) {
    	if(AMPM.equals("AM")) {
    		hours = "01";
    	}//else its PM so don't change anything (AKA its noon);
    } else {
    	if(AMPM.equals("PM")) {
        	numHours+=12;
        	hours = numHours.toString();
        	
        }
    }
    
    ans=hours;
    ans+=":";
    ans+=minutes;
    ans+=":";
    ans+= seconds;
    return ans;
    }
    public static void main(String[] args) {
		
		System.out.println(timeConversion("07:05:45PM"));
	}
}