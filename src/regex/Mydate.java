package regex;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.*;
import java.time.format.*;
//		5.�����ࡣ
public class Mydate {

	public static void main(String[] args) {
//		ʹ��java8������ʱ�����ȡ��ǰϵͳʱ�䣬���Ը��ָ�ʽ������ʾ
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
//		ʹ��java8������ʱ�����ȡ��ǰϵͳʱ�䣬���޸����ʱ�䣨�ֱ��޸���ݡ��·ݡ��졢Сʱ����Ȼ���ӡ���
	
		System.out.println("��ݼ�3:  "+time.plusYears(3).format
				(DateTimeFormatter.ofLocalizedDateTime
						(FormatStyle.MEDIUM,FormatStyle.MEDIUM)));
		System.out.println("�·ݼ�4:  "+time.plusMonths(-4).format
				(DateTimeFormatter.ofLocalizedDateTime
						(FormatStyle.MEDIUM,FormatStyle.MEDIUM)));
		System.out.println("������20:  "+time.plusDays(20).format
				(DateTimeFormatter.ofLocalizedDateTime
						(FormatStyle.MEDIUM,FormatStyle.MEDIUM)));
		System.out.println("Сʱ��20:  "+time.plusHours(20).format
				(DateTimeFormatter.ofLocalizedDateTime
						(FormatStyle.MEDIUM,FormatStyle.MEDIUM)));
//		�ӿ���̨����һ��yyyy-MM-dd�������գ���ʽ�������ַ������ٽ�������ڼ������죬����FormatStyle.MEDIUM��ʽ���������ڡ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("������:");
			String s=br.readLine();
			LocalDate myDate=LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			System.out.println("���ڼ�7�죺"+myDate.plusDays(7).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
