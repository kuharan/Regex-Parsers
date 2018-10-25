import java.util.regex.*;

class SyslogParser {
    public static void main(String[] args) {
	String month;
        String day;
        String time;
        String hostname;
        String pname;
        String pid;
        String priority;
        String msg;
        String txt = "Aug 12 12:27:15 hidingIT snapd[4646]: snap \"gnome-calculator\": snap has no updates available";
        String re1 = "((?:Jan(?:uary)?|Feb(?:ruary)?|Mar(?:ch)?|Apr(?:il)?|May|Jun(?:e)?|Jul(?:y)?|Aug(?:ust)?|Sep(?:tember)?|Sept|Oct(?:ober)?|Nov(?:ember)?|Dec(?:ember)?))"; // Month
        String re2 = ".*?"; // Non-greedy match on filler
        String re3 = "((?:(?:[0-2]?\\d{1})|(?:[3][01]{1})))(?![\\d])";	// Day
        String re4 = ".*?";	// Non-greedy match on filler
        String re5 = "((?:(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])):(?:[0-5][0-9])(?::[0-5][0-9])?(?:\\s?(?:am|AM|pm|PM))?)"; // HourMinuteSec
        String re6 = ".*?"; // Non-greedy match on filler
        String re7 = "((?:[a-z][a-z]+))"; // Host Name
        String re8 = ".*?"; // Non-greedy match on filler
        String re9 = "((?:[a-z][a-z]+))"; // Process Name
        String re10 = "(\\[.*?\\])"; // Process ID
        String re11 = ".*?"; // Non-greedy match on filler
        String re12 = "(<[^>]+>)"; // Priority
        String re13 = "\\s"; // Non-greedy match on filler
        String re14 = "(.*)"; // Message

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find()) {
            month = m.group(1);
            day = m.group(2);
            time = m.group(3);
            hostname = m.group(4);
            pname = m.group(5);
            pid = m.group(6);
            priority = m.group(7);
            msg = m.group(8);
            System.out.print("(" + month.toString() + ")" + "(" + day.toString() + ")" + "(" + time.toString() + ")" + "(" + hostname.toString() + ")" + "(" + pname.toString() + ")" + "(" + pid.toString() + ")" + "(" + priority.toString() + ")" + "(" + msg.toString() + ")" + "\n");
        } else {
            p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re13 + re14, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            m = p.matcher(txt);
            if (m.find()) {
                month = m.group(1);
                day = m.group(2);
                time = m.group(3);
                hostname = m.group(4);
                pname = m.group(5);
                pid = m.group(6);
                msg = m.group(7);
                System.out.print("(" + month.toString() + ")" + "(" + day.toString() + ")" + "(" + time.toString() + ")" + "(" + hostname.toString() + ")" + "(" + pname.toString() + ")" + "(" + pid.toString() + ")" + "(" + msg.toString() + ")" + "\n");
            } else {
                p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re13 + re14, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
                m = p.matcher(txt);
                if (m.find()) {
                    month = m.group(1);
                    day = m.group(2);
                    time = m.group(3);
                    hostname = m.group(4);
                    pname = m.group(5);
                    msg = m.group(6);
                    System.out.print("(" + month.toString() + ")" + "(" + day.toString() + ")" + "(" + time.toString() + ")" + "(" + hostname.toString() + ")" + "(" + pname.toString() + ")" + "(" + msg.toString() + ")" + "\n");
                }
            }
        }
   }
}
