package cn.ws.tools.phone;

import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

import java.util.Locale;
/**
    代码示例
*/
public class PhoneUtil {
 
 
    private static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
 
    private static PhoneNumberToCarrierMapper carrierMapper = PhoneNumberToCarrierMapper.getInstance();
 
    private static PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();

    public static void main(String[] args) {
        System.out.println(PhoneUtil.checkPhoneNumber("6002800272",91));
    }
    /**
     * 根据国家代码和手机号  判断手机号是否有效
     * @param phoneNumber
     * @param countryCode
     * @return
     */
    public static boolean checkPhoneNumber(String phoneNumber, Integer countryCode){

        try {
            long phone = Long.parseLong(phoneNumber);
            PhoneNumber pn = new PhoneNumber();
            pn.setCountryCode(countryCode);
            pn.setNationalNumber(phone);
            return phoneNumberUtil.isValidNumber(pn);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 根据国家代码和手机号  判断手机运营商
     * @date 2017-4-26 上午11:30:18
     * @param phoneNumber
     * @param countryCode
     * @return
     */
    public static String getCarrier(String phoneNumber, Integer countryCode){
 
        long phone = Long.parseLong(phoneNumber);
 
        PhoneNumber pn = new PhoneNumber();
        pn.setCountryCode(countryCode);
        pn.setNationalNumber(phone);
        //返回结果只有英文，自己转成成中文
        String carrierEn = carrierMapper.getNameForNumber(pn, Locale.ENGLISH);
        String carrierZh = "";
        carrierZh += geocoder.getDescriptionForNumber(pn, Locale.CHINESE);
        switch (carrierEn) {
        case "China Mobile":
            carrierZh += "移动";
            break;
        case "China Unicom":
            carrierZh += "联通";
            break;
        case "China Telecom":
            carrierZh += "电信";
            break;
        default:
            break;
        }
        return carrierZh;
    }
 
 
    /**
     * 
    * @Description: 根据国家代码和手机号  手机归属地
    * @date 2017-4-26 上午11:33:18
    * @param phoneNumber
    * @param countryCode
    * @return    参数
     */
    public static String getGeo(String phoneNumber, Integer countryCode){
 
        long phone = Long.parseLong(phoneNumber);
 
        PhoneNumber pn = new PhoneNumber();
        pn.setCountryCode(countryCode);
        pn.setNationalNumber(phone);
 
        return geocoder.getDescriptionForNumber(pn, Locale.CHINESE);
 
    }
 

 
}