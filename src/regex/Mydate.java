package regex;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.*;
import java.time.format.*;
//		5.日期类。
public class Mydate {

	public static void main(String[] args) {
//		使用java8的日期时间包获取当前系统时间，并以各种格式加以显示
		LocalDateTime time=LocalDateTime.now();
		System.out.println(time);
		System.out.println(time.format
				(DateTimeFormatter.ofLocalizedDateTime
						(FormatStyle.SHORT,FormatStyle.SHORT)));
		System.out.println(time.format
				(DateTimeFormatter.ofLocalizedDateTime
						(FormatStyle.MEDIUM,FormatStyle.MEDIUM)));
		System.out.println(time.format
				(DateTimeFormatter.ofLocalizedDateTime
						(FormatStyle.FULL,FormatStyle.LONG)));
//		使用java8的日期时间包获取当前系统时间，并修改这个时间（分别修改年份、月份、天、小时），然后打印结果
	
		System.out.println("年份加3:  "+time.plusYears(3).format
				(DateTimeFormatter.ofLocalizedDateTime
						(FormatStyle.MEDIUM,FormatStyle.MEDIUM)));
		System.out.println("月份减4:  "+time.plusMonths(-4).format
				(DateTimeFormatter.ofLocalizedDateTime
						(FormatStyle.MEDIUM,FormatStyle.MEDIUM)));
		System.out.println("天数加20:  "+time.plusDays(20).format
				(DateTimeFormatter.ofLocalizedDateTime
						(FormatStyle.MEDIUM,FormatStyle.MEDIUM)));
		System.out.println("小时加20:  "+time.plusHours(20).format
				(DateTimeFormatter.ofLocalizedDateTime
						(FormatStyle.MEDIUM,FormatStyle.MEDIUM)));
//		从控制台输入一个yyyy-MM-dd（年月日）格式的日期字符串，再将这个日期加上七天，再用FormatStyle.MEDIUM格式输出这个日期。
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("请输入:");
			String s=br.readLine();
			LocalDate myDate=LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			System.out.println("日期加7天："+myDate.plusDays(7).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
