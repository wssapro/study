package cn.ws.tools.phone;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

import java.util.Locale;


/**
 * @author shun
 * @date 2021-04-20 19:41
 */
public class Phone {


	public static void main(String[] args) {
		// 输入的号码
		String swissNumberStr = "15951679087";
		// 初始化
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		try {
			Phonenumber.PhoneNumber swissNumberProto = phoneUtil.parse(swissNumberStr, "CH");
			System.out.println(swissNumberProto);


			PhoneNumberOfflineGeocoder phoneNumberOfflineGeocoder = PhoneNumberOfflineGeocoder.getInstance();
			String language ="CN";
			Phonenumber.PhoneNumber referencePhonenumber = null;
			referencePhonenumber = phoneUtil.parse(swissNumberStr, language);
			String referenceRegion = phoneNumberOfflineGeocoder.getDescriptionForNumber(referencePhonenumber,Locale.CHINA);
			System.out.println("111");

		}
		catch (NumberParseException e) {
			System.err.println("NumberParseException was thrown: " + e.toString());
		}

	}

}
