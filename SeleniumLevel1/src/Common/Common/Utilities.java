package Common.Common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilities {
  public static String getProjectPath(){
    return "E:\\mon_hoc_tren_truong\\KiemThuPhanMem\\SeleniumLevel1";
  }

  public static String generalRandomString(){
    return "";
  }

  public static String generalRandomEmail(){
    return "";
  }

  public static String getDate(){
    LocalDate currentDate = LocalDate.now().plusDays(4);
    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("M/d/yyyy");
    String DateReal= currentDate.format(formatter);
    return DateReal;
  }





}
