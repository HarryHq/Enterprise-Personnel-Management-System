package com.test;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

 

public class CheckSoftware {

   /*

    * 遍历注册表，查询MySQL的注册表关联

    */

   public static String check() throws Exception {

      Runtime runtime = Runtime.getRuntime();

      Process process = null;

      process = runtime

            .exec("cmd /c reg query HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\");

      BufferedReader in = new BufferedReader(new InputStreamReader(

            process.getInputStream()));

      String string = null;

      while ((string = in.readLine()) != null) {

         process = runtime.exec("cmd /c reg query " + string

                + " /v DisplayName");

         BufferedReader name = new BufferedReader(new InputStreamReader(

                process.getInputStream()));

         String message = queryValue(string, "DisplayName");

         if (message != null && message.contains("MySQL")) {

            String message2 = queryValue(string, "InstallLocation");

            return message2;

         }

 

      }

      in.close();

      process.destroy();

      return null;

   }

 

   /*

    * 查询出需要的MySQL服务的安装路径

    */

   private static String queryValue(String string, String method)

         throws IOException {

      String pathString = "";

 

      Runtime runtime = Runtime.getRuntime();

      Process process = null;

      BufferedReader br = null;

      process = runtime.exec("cmd /c reg query " + string + " /v " + method);

      br = new BufferedReader(new InputStreamReader(process.getInputStream()));

      br.readLine();

      br.readLine();// 去掉前两行无用信息

      if ((pathString = br.readLine()) != null) {

         pathString = pathString.replaceAll(method + "    REG_SZ    ", ""); // 去掉无用信息

         return pathString;

      }

      return pathString;

   }

}