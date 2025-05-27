package Ulties;

public class PropertyManager {

	// URL_L&D
    //   Wize integration testing

	public static String getURL_LnD = "https://wize-integration-tekdev.azurewebsites.net/"; 

	// Account Login
	public static String EmailUser1 = "inte-abayomi.saka@tek-experts.com";
	public static String EmailAdmin1 = "inte-olajumoke.adetunji@tek-experts.com";
	public static String EmailAdmin = "inte-olajumoke.adetunji@tek-experts.com";
	public static String EmailUser = "inte-abayomi.saka@tek-experts.com";
	public static String PASSWORD="Wize-1234";
	public static String fullNameAdmin1 = "Olajumoke Rashidat Adetunji";
	public static String primaryPosition = "NGA0581 Team Manager";
	public static String EmailLan = "lan.hoang-thi@wize-solutions.com";
	public static String EmailTuan = "tuan.do-anh@wize-solutions.com";
	
	public String getURL_LnD() {
		return getURL_LnD;
	}
	
	public void loadData() {
            TestLogger.info("You are using data in PropertyManager");
	}

}
