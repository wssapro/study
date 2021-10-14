package cn.ws.jdk8.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * <p>
 *
 * </p>
 *
 * @author shun
 * @date 2020-06-28 11:11
 */
public class DBUtils
{
	public static final String URL = "jdbc:mysql://192.168.1.35:3306/rt_ascription?autoReconnect=true&amp;rewriteBatchedStatements=true&amp;useSSL=true";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	// 创建一个数据库连接
	Connection conn = null;
	// 创建预编译语句对象
	PreparedStatement pstm = null;
	Statement stm = null;
	// 创建一个结果集对象
	ResultSet rs = null;

	public static void main(String[] args) throws Exception {

	}
	public static char getRandomChar() {
		return (char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
	}

	/***
	 * 将字符串按固定长度切割成字符子串
	 * @param src 需要切割的字符串
	 * @param length 字符子串的长度
	 * @return 字符子串数组
	 */
	public static String[] splitStringByLength(String src, int length) {
		//检查参数是否合法
		if (null == src||src.equals("")) {
			System.out.println("the string is null");
			return null;
		}

		if (length <= 0) {
			System.out.println("the length < 0");
			return null;
		}

		System.out.println("now split \"" + src + "\" by length " + length);

		int n = (src.length() + length - 1) / length; //获取整个字符串可以被切割成字符子串的个数

		String[] split = new String[n];

		for (int i = 0; i < n; i++) {
			if (i < (n -1)) {
				split[i] = src.substring(i * length, (i + 1) * length);
			} else {
				split[i] = src.substring(i * length);
			}
		}

		return split;
	}

	public static Connection conn(){
		Connection conn = null;
		try
		{
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2. 获得数据库连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	public static void batchOperation(Connection conn, ArrayList<String> sqlArr){
		try
		{
			Statement stm = conn.createStatement();
			conn.setAutoCommit(false);
			for (String sql : sqlArr)
			{
				stm.addBatch(sql);
			}
			stm.executeBatch();
			// 执行完后，手动提交事务
			conn.commit();
			// 在把自动提交打开
			conn.setAutoCommit(true);
		}
		catch (SQLException e)
		{
			try
			{
				// 发生异常，事务回滚！
				if (!conn.isClosed())
				{
					conn.rollback();
					conn.setAutoCommit(true);
				}
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void insert(String sql){
		Connection conn = null;
		try {
			conn = conn();
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void update(String sql){
		Connection conn = null;
		try {
			conn = conn();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static ResultSet select(String sql){
		Connection conn = null;
		try {
			conn = conn();
			Statement stmt = conn.createStatement();
			return stmt.executeQuery(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	public static final ConcurrentMap<String,String> imsiMap;
	static {
		imsiMap = new ConcurrentHashMap<String, String>();
		imsiMap.put("338","JM-1876");
		imsiMap.put("332","VI-1340");
		imsiMap.put("330","PR-1809");
		imsiMap.put("334","MX-52");
		imsiMap.put("748","UY-598");
		imsiMap.put("530","NZ-64");
		imsiMap.put("746","SR-597");
		imsiMap.put("535","GU-1671");
		imsiMap.put("534","MP-1670");
		imsiMap.put("740","EC-593");
		imsiMap.put("539","TO-676");
		imsiMap.put("609","MR-222");
		imsiMap.put("608","SN-221");
		imsiMap.put("537","PG-675");
		imsiMap.put("607","GM-220");
		imsiMap.put("536","NR-674");
		imsiMap.put("606","LY-218");
		imsiMap.put("744","PY-595");
		imsiMap.put("605","TN-216");
		imsiMap.put("604","MA-212");
		imsiMap.put("742","GF-594");
		imsiMap.put("603","DZ-213");
		imsiMap.put("602","EG-20");
		imsiMap.put("202","GR-30");
		imsiMap.put("204","NL-31");
		imsiMap.put("342","BB-1246");
		imsiMap.put("344","AG-1268");
		imsiMap.put("206","BE-32");
		imsiMap.put("346","KY-1345");
		imsiMap.put("208","FR-33");
		imsiMap.put("348","VG-1284");
		imsiMap.put("540","SB-677");
		imsiMap.put("734","VE-58");
		imsiMap.put("542","FJ-679");
		imsiMap.put("736","BO-591");
		imsiMap.put("541","VU-678");
		imsiMap.put("405","IN-91");
		imsiMap.put("544","AS-1684");
		imsiMap.put("738","GY-592");
		imsiMap.put("404","IN-91");
		imsiMap.put("543","WF-681");
		imsiMap.put("340","MQ-596");
		imsiMap.put("546","NC-687");
		imsiMap.put("406","IN-91");
		imsiMap.put("545","KI-686");
		imsiMap.put("401","KZ-7");
		imsiMap.put("548","CK-682");
		imsiMap.put("400","AZ-994");
		imsiMap.put("547","PF-689");
		imsiMap.put("402","BT-975");
		imsiMap.put("549","WS-685");
		imsiMap.put("730","CL-56");
		imsiMap.put("732","CO-57");
		imsiMap.put("212","MC-377");
		imsiMap.put("216","HU-36");
		imsiMap.put("316","US-1");
		imsiMap.put("213","AD-376");
		imsiMap.put("214","ES-34");
		imsiMap.put("314","US-1");
		imsiMap.put("219","HR-385");
		imsiMap.put("315","US-1");
		imsiMap.put("312","US-1");
		imsiMap.put("313","US-1");
		imsiMap.put("218","BA-387");
		imsiMap.put("310","US-1");
		imsiMap.put("311","US-1");
		imsiMap.put("418","IQ-964");
		imsiMap.put("417","SY-963");
		imsiMap.put("416","JO-962");
		imsiMap.put("415","LB-961");
		imsiMap.put("510","ID-62");
		imsiMap.put("623","CF-236");
		imsiMap.put("622","TD-235");
		imsiMap.put("724","BR-55");
		imsiMap.put("621","NG-234");
		imsiMap.put("419","KW-965");
		imsiMap.put("620","GH-233");
		imsiMap.put("722","AR-54");
		imsiMap.put("410","PK-92");
		imsiMap.put("627","GQ-240");
		imsiMap.put("626","ST-239");
		imsiMap.put("625","CV-238");
		imsiMap.put("624","CM-237");
		imsiMap.put("414","MM-95");
		imsiMap.put("413","LK-94");
		imsiMap.put("412","AF-93");
		imsiMap.put("515","PH-63");
		imsiMap.put("629","CG-242");
		imsiMap.put("514","TL-670");
		imsiMap.put("628","GA-241");
		imsiMap.put("220","RS-381");
		imsiMap.put("222","IT-39");
		imsiMap.put("225","VA-379");
		imsiMap.put("226","RO-40");
		imsiMap.put("228","CH-41");
		imsiMap.put("427","QA-974");
		imsiMap.put("716","PE-51");
		imsiMap.put("426","BH-973");
		imsiMap.put("429","NP-977");
		imsiMap.put("428","MN-976");
		imsiMap.put("610","ML-223");
		imsiMap.put("712","CR-506");
		imsiMap.put("520","TH-66");
		imsiMap.put("612","CI-225");
		imsiMap.put("714","PA-507");
		imsiMap.put("611","GN-224");
		imsiMap.put("614","NE-227");
		imsiMap.put("613","BF-226");
		imsiMap.put("421","YE-967");
		imsiMap.put("616","BJ-229");
		imsiMap.put("710","NI-505");
		imsiMap.put("420","SA-966");
		imsiMap.put("615","TG-228");
		imsiMap.put("618","LR-231");
		imsiMap.put("422","OM-968");
		imsiMap.put("525","SG-65");
		imsiMap.put("617","MU-230");
		imsiMap.put("425","PS-970");
		imsiMap.put("528","BN-673");
		imsiMap.put("424","AE-971");
		imsiMap.put("619","SL-232");
		imsiMap.put("436","TJ-992");
		imsiMap.put("434","UZ-998");
		imsiMap.put("431","AE-971");
		imsiMap.put("432","IR-98");
		imsiMap.put("430","AE-971");
		imsiMap.put("704","GT-502");
		imsiMap.put("702","BZ-501");
		imsiMap.put("708","HN-504");
		imsiMap.put("437","KG-996");
		imsiMap.put("706","SV-503");
		imsiMap.put("438","TM-993");
		imsiMap.put("302","CA-1");
		imsiMap.put("308","PM-508");
		imsiMap.put("440","JP-81");
		imsiMap.put("441","JP-81");
		imsiMap.put("450","KR-82");
		imsiMap.put("454","HK-852");
		imsiMap.put("452","VN-84");
		imsiMap.put("457","LA-856");
		imsiMap.put("455","MO-853");
		imsiMap.put("456","KH-855");
		imsiMap.put("555","NU-683");
		imsiMap.put("552","PW-680");
		imsiMap.put("550","FM-691");
		imsiMap.put("551","MH-692");
		imsiMap.put("461","CN-86");
		imsiMap.put("460","CN-86");
		imsiMap.put("466","TW-886");
		imsiMap.put("467","KP-850");
		imsiMap.put("280","CY-357");
		imsiMap.put("284","BG-359");
		imsiMap.put("283","AM-374");
		imsiMap.put("282","GE-995");
		imsiMap.put("288","FO-298");
		imsiMap.put("286","TR-90");
		imsiMap.put("270","LU-352");
		imsiMap.put("272","IE-353");
		imsiMap.put("274","IS-354");
		imsiMap.put("276","AL-355");
		imsiMap.put("278","MT-356");
		imsiMap.put("470","BD-880");
		imsiMap.put("472","MV-960");
		imsiMap.put("294","MK-389");
		imsiMap.put("293","SI-386");
		imsiMap.put("295","LI-423");
		imsiMap.put("290","GL-299");
		imsiMap.put("292","SM-223");
		imsiMap.put("297","ME-382");
		imsiMap.put("646","MG-261");
		imsiMap.put("240","SE-46");
		imsiMap.put("647","RE-262");
		imsiMap.put("648","ZW-263");
		imsiMap.put("649","NA-264");
		imsiMap.put("642","BI-257");
		imsiMap.put("643","MZ-258");
		imsiMap.put("645","ZM-260");
		imsiMap.put("640","TZ-255");
		imsiMap.put("641","UG-256");
		imsiMap.put("244","FI-358");
		imsiMap.put("242","NO-47");
		imsiMap.put("248","EE-372");
		imsiMap.put("247","LV-371");
		imsiMap.put("246","LT-370");
		imsiMap.put("505","AU-61");
		imsiMap.put("639","KE-254");
		imsiMap.put("637","SO-252");
		imsiMap.put("638","DJ-253");
		imsiMap.put("635","RW-250");
		imsiMap.put("636","ET-251");
		imsiMap.put("230","CZ-420");
		imsiMap.put("370","DO-1809");
		imsiMap.put("633","SC-248");
		imsiMap.put("634","SD-249");
		imsiMap.put("372","HT-509");
		imsiMap.put("631","AO-244");
		imsiMap.put("632","GW-245");
		imsiMap.put("502","MY-60");
		imsiMap.put("630","CD-243");
		imsiMap.put("374","TT-1868");
		imsiMap.put("376","TC-1649");
		imsiMap.put("232","AT-43");
		imsiMap.put("231","SK-421");
		imsiMap.put("234","GB-44");
		imsiMap.put("235","GB-44");
		imsiMap.put("238","DK-45");
		imsiMap.put("262","DE-49");
		imsiMap.put("260","PL-48");
		imsiMap.put("362","CW-5999");
		imsiMap.put("360","VC-1784");
		imsiMap.put("366","DM-1767");
		imsiMap.put("365","AI-1264");
		imsiMap.put("364","BS-1242");
		imsiMap.put("363","AW-297");
		imsiMap.put("368","CU-53");
		imsiMap.put("268","PT-351");
		imsiMap.put("266","GI-350");
		imsiMap.put("250","RU-7");
		imsiMap.put("657","ER-291");
		imsiMap.put("750","FK-500");
		imsiMap.put("651","LS-266");
		imsiMap.put("652","BW-267");
		imsiMap.put("650","MW-265");
		imsiMap.put("655","ZA-27");
		imsiMap.put("653","SZ-268");
		imsiMap.put("350","BM-1441");
		imsiMap.put("654","KM-269");
		imsiMap.put("352","GD-1473");
		imsiMap.put("354","MS-1664");
		imsiMap.put("356","KN-1869");
		imsiMap.put("358","LC-1758");
		imsiMap.put("257","BY-375");
		imsiMap.put("259","MD-373");
		imsiMap.put("255","UA-380");
	}
}
class Country{
	String code;
	String english;
	String chinese;
	String abbr;
}