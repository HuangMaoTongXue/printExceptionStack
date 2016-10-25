package printExceptionStack;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by huangmao on 2016/10/25.
 */
public class PrintExceptionStack {
    public static void main(String[] args) {
        try {
            int a=5/0;
        }catch (Exception e){
            String inf=getStackTrace(e);
            System.out.println(inf);
        }
    }

    /**
     * 完整的堆栈信息 * * @param e Exception * @return Full StackTrace
     */
    public static String getStackTrace(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
         //   sw.flush();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }
}
