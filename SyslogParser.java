import java.util.regex.*;

class SyslogParser {
    public static void main(String[] args) {
	String txt = "Aug 12 12:27:15 hidingIT snapd[4646]: snap \"gnome-calculator\": snap has no updates available";
        String re1 = "((?:Jan(?:uary)?|Feb(?:ruary)?|Mar(?:ch)?|Apr(?:il)?|May|Jun(?:e)?|Jul(?:y)?|Aug(?:ust)?|Sep(?:tember)?|Sept|Oct(?:ober)?|Nov(?:ember)?|Dec(?:ember)?))"; // Month
        String re2 = ".*?"; // Non-greedy match on filler
        String re3 = "((?:(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])):(?:[0-5][0-9])(?::[0-5][0-9])?(?:\\s?(?:am|AM|pm|PM))?)"; // HourMinuteSec
        String re4 = ".*?"; // Non-greedy match on filler
        String re5 = "((?:[a-z][a-z]+))"; // Host Name
        String re6 = ".*?"; // Non-greedy match on filler
        String re7 = "((?:[a-z][a-z]+))"; // Process Name
        String re8 = "(\\[.*?\\])"; // Process ID
        String re9 = ".*?"; // Non-greedy match on filler
        String re10 = "(<[^>]+>)"; // Priority
        String re11 = "\\s"; // Non-greedy match on filler
        String re12 = "(.*)"; // Message

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find()) {
            String month = m.group(1);
            String time = m.group(2);
            String hostname = m.group(3);
            String pname = m.group(4);
            String pid = m.group(5);
            String priority = m.group(6);
            String msg = m.group(7);
            System.out.print("(" + month.toString() + ")" + "(" + time.toString() + ")" + "(" + hostname.toString() + ")" + "(" + pname.toString() + ")" + "(" + pid.toString() + ")" + "(" + priority.toString() + ")" + "(" + msg.toString() + ")" + "\n");
        } else {
            p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re11 + re12, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            m = p.matcher(txt);
            if (m.find()) {
                String month = m.group(1);
                String time = m.group(2);
                String hostname = m.group(3);
                String pname = m.group(4);
                String pid = m.group(5);
                String msg = m.group(6);
                System.out.print("(" + month.toString() + ")" + "(" + time.toString() + ")" + "(" + hostname.toString() + ")" + "(" + pname.toString() + ")" + "(" + pid.toString() + ")" + "(" + msg.toString() + ")" + "\n");
            } else {
                p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re11 + re12, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
                m = p.matcher(txt);
                if (m.find()) {
                    String month = m.group(1);
                    String time = m.group(2);
                    String hostname = m.group(3);
                    String pname = m.group(4);
                    String msg = m.group(5);
                    System.out.print("(" + month.toString() + ")" + "(" + time.toString() + ")" + "(" + hostname.toString() + ")" + "(" + pname.toString() + ")" + "(" + msg.toString() + ")" + "\n");
                }
            }
        }
    }
}
