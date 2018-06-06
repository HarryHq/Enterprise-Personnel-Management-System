package com.test;

import java.io.File;

import java.io.IOException;

import java.io.InputStream;

import java.util.Properties;

 

public class JavaMysql {

   /*

    * 备份数据库 1、读取配置文件 2、启动智能查询Mysql安装目录 3、备份数据库为sql文件

    */
	 private static CheckSoftware c = null;

   public static void backup(String sql) {

 

      Properties pros = getPprVue("prop.properties");

      String username = pros.getProperty("username");

      String password = pros.getProperty("password");

      try {

         System.out.println("MySQL服务安装地址 ："+c.check().toString());

      } catch (Exception e2) {

         e2.printStackTrace();

      }

      String mysqlpaths;

      try {

         mysqlpaths = c.check().toString() + "bin" + "\\";

 

         String databaseName = pros.getProperty("databaseName");

         String address = pros.getProperty("address");

         String sqlpath = pros.getProperty("sql");

         File backupath = new File(sqlpath);

         if (!backupath.exists()) {

            backupath.mkdir();

         }

 

         StringBuffer sb = new StringBuffer();

 

         sb.append(mysqlpaths);

         sb.append("mysqldump ");

         sb.append("--opt ");

         sb.append("-h ");

         sb.append(address);

         sb.append(" ");

         sb.append("--user=");

         sb.append(username);

         sb.append(" ");

         sb.append("--password=");

         sb.append(password);

         sb.append(" ");

         sb.append("--lock-all-tables=true ");

         sb.append("--result-file=");

         sb.append(sqlpath);

         sb.append(sql);

         sb.append(" ");

         sb.append("--default-character-set=utf8 ");

         sb.append(databaseName);

         System.out.println("cmd指令 ："+sb.toString());

         Runtime cmd = Runtime.getRuntime();

         try {

            Process p = cmd.exec(sb.toString());

         } catch (IOException e) {

            e.printStackTrace();

         }

      } catch (Exception e1) {

         e1.printStackTrace();

      }

   }

 

   /*

    * 读取属性文件

    */

   public static Properties getPprVue(String properName) {
      InputStream inputStream = JavaMysql.class.getClassLoader().getResourceAsStream(properName);

      Properties p = new Properties();
      try {

         p.load(inputStream);

         inputStream.close();

      } catch (IOException e) {

         e.printStackTrace();

      }
      return p;
   }

 

   /*

    * 根据备份文件恢复数据库

    */

   public static void load(String filename) throws Exception {

      Properties pros = getPprVue("prop.properties");

      String root = pros.getProperty("jdbc.username");

      String pass = pros.getProperty("jdbc.password");

      String mysqlpaths = c.check().toString() + "bin" + "\\";

      String sqlpath = pros.getProperty("sql");

      String filepath = mysqlpaths + sqlpath + filename; // 备份的路径地址

 

      String stmt1 = mysqlpaths + "mysqladmin -u " + root + " -p" + pass

            + " create finacing"; // -p后面加的是你的密码

      String stmt2 = mysqlpaths + "mysql -u " + root + " -p" + pass

            + " finacing < " + filepath;

      String[] cmd = { "cmd", "/c", stmt2 };

      try {

         Runtime.getRuntime().exec(stmt1);

         Runtime.getRuntime().exec(cmd);

         System.out.println("数据已从 " + filepath + " 导入到数据库中");

      } catch (IOException e) {

         e.printStackTrace();

      }

 

   }
}