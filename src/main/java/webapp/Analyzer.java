package webapp;

public class Analyzer {
	
	public String analyze(String humidity) {
		
		int value = Integer.valueOf(humidity);
		
		if(value > 50) {
			return "Kasvisi ei tarvitse vettä vielä useaan päivään";
		} if(value >= 45 && value <= 50) {
			return "Kasvisi tarvitsee vettää muutaman päivän sisällä";
		} if(value < 45 && value >= 40) {
			return "Kasvisi tarvitsee vettä heti!";
		}
		return "Mittari taitaa näyttää virheellistä lukemaa. Mittarin lukema " + humidity + "%.";
		
	}
}
