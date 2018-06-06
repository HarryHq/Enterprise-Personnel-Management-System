package com.test;

import java.text.ParseException;

import com.dao.SalaryDao;

public class Test1 {

	public void test1() {
		int page = new SalaryDao().queryAll(1, 10).getPageSize();
		System.out.println(page);
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		// try {
		// Connection connection=JDBCUtils.getConnection();
		// System.out.println(connection);
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		//
		// 测试java.util.Date-->java.sql.Date
		// Date date= new Date();
		// System.out.println(date);
		// System.out.println(date.getTime());
		// java.sql.Date sqldate= new java.sql.Date(date.getTime());
		// System.out.println(sqldate);

		/*
		 * 测试staffDao.add方法
		 */
		// Staff staff=new Staff();
		// staff.setSid("000004");
		// staff.setSname("我是小林啊");
		// staff.setSex("男");
		// staff.setBirthday(new Date());
		// staff.setStirps("苗族");
		// staff.setIdNumber("979743217890809877");
		// staff.setNativePlace("上海");
		// staff.setEducation("博士");
		// staff.setMajor("金融学");
		// staff.setCellphone("13262813125");
		// staff.setEmail("adlfa@qq.com");
		// staff.setDepartment("财务部");
		// staff.setRole("财务总监");
		// staff.setHireDate(new Date());
		// staff.setWorkType("正式员工");
		// staff.setBankCard("6217002710000684874");
		// staff.setWorkBegin(new Date());
		// staff.setWorkEnd(new Date());
		// staff.setTermDate(new Date());
		// staff.setTermReason("回家养猪");
		// staff.set_remark("这个人很皮");
		//
		// StaffService service = new StaffService();
		// service.edit(staff);

		// StaffDao staffDao = new StaffDao();
		// List<Staff> list=staffDao.query(staff);
		// System.out.println(list.toString());
		// staffDao.update(staff);
		// staffDao.add(staff);

		/*
		 * 测试staffDao.findById方法
		 */
		// StaffDao staffDao = new StaffDao();
		// Staff staff=staffDao.findById("000004");
		// System.out.println(staff.toString());

		/*
		 * 测试staffDao.findAll方法
		 */
		// StaffDao staffDao = new StaffDao();
		// List<Staff> staffs=staffDao.findAll();
		// for (Staff staff : staffs) {
		// System.out.println(staff.toString());
		// }

		/*
		 * 测试 string类型日期转换为java.util.Date类型日期
		 */
		// String str = "2013-01-14";
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Date date = null; //初始化date
		// try {
		// date=sdf.parse(str);
		// System.out.println(date);
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// String time = "9:00:00";
		//
		// Calendar calendar = Calendar.getInstance();
		// int year=calendar.get(Calendar.YEAR);
		// int month=calendar.get(Calendar.MONTH);
		// int day = calendar.get(Calendar.DAY_OF_MONTH);
		// System.out.println(year+"年"+month+"月"+day+"日");
		//
		// calendar.set(year, month,day, 9, 0, 0);
		// Date date = calendar.getTime();
		//
		//
		//
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//
		// System.out.println(sdf.format(date));
		//
		// System.out.println(sdf.parse(time).getTime());
		// System.out.println(new Date().getTime());
		//
		// String iString= sdf.format(new Date()).toString();
		////
		// Date date = DateUtils.setClork(18, 30, 0);
		//
		// System.out.println(sdf.format(date));

		// JavaMysql.backup("ham.sql");
		// Properties properties=JavaMysql.getPprVue("prop.properties");
		// System.out.println(properties);
		//
		// InputStream inputStream=new
		// Test1().getClass().getClassLoader().getResourceAsStream("prop.properties");
		// System.out.println(inputStream);
		// System.out.println(SystemInfo.getJavaVersion());

	}

}
