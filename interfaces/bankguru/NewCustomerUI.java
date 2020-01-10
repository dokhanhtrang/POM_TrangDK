package bankguru;

public class NewCustomerUI {
	public static final String CLICKOUT_LBL = "//p[@class='heading3']";
	public static final String CUSTOMERNAME_TXT = "//input[@name='name']";
	public static final String CUSTOMERNAME_BLANK_TXT = "//label[contains(text(),'Customer name must not be blank')]";
	public static final String CUSTOMERNAME_NUMBERIC_TXT = "//label[contains(text(),'Numbers are not allowed')]";
	public static final String CUSTOMERNAME_SCHAR_TXT = "//label[contains(text(),'Special characters are not allowed')]";
	public static final String CUSTOMERNAME_SPACEF_TXT = "//label[contains(text(),'First character can not have space')]";
	public static final String GENDER_MALE_RADIO = "//input[@value='m']";
	public static final String GENDER_FEMALE_RADIO = "//input[@value='f']";
	public static final String DATE_OF_BIRTH_TXT = "//input[@id='dob']";
	public static final String ADDRESS_TXT = "//textarea[@name ='addr']";
	public static final String CITY_TXT = "//input[@name ='city']";
	public static final String STATE_TXT = "//input[@name ='state']";
	public static final String PIN_TXT = "//input[@name ='pinno']";
	public static final String MOBILE_PHONE_TXT = "//input[@name ='telephoneno']";
	public static final String EMAIL_TXT = "//input[@name ='emailid']";
	public static final String PASSWORD_TXT = "//input[@name ='password']";
	public static final String SUBMIT_BTN = "//input[@name ='sub']";
	public static final String RESET_BTN = "//input[@name ='res']";
	public static final String CUSTOMER_ID_LBL ="//td[contains(text(),'Customer ID')]//following-sibling::td";

}
