import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/9/23 0023.
 */
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//�������ڸ�ʽ
        System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
    }
}
