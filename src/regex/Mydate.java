package regex;
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
		
		
//		�ӿ���̨����һ��yyyy-MM-dd�������գ���ʽ�������ַ������ٽ�������ڼ������죬����FormatStyle.MEDIUM��ʽ���������ڡ�
		
	}

}
