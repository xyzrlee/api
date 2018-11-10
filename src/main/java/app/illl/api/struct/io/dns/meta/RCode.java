package app.illl.api.struct.io.dns.meta;

public class RCode {

    private RCode() {
    }

    public static final Integer NOERROR = 0;
    public static final Integer FORMERR = 1;
    public static final Integer SERVFAIL = 2;
    public static final Integer NXDOMAIN = 3;
    public static final Integer NOTIMP = 4;
    public static final Integer REFUSED = 5;
    public static final Integer YXDOMAIN = 6;
    public static final Integer YXRRSET = 7;
    public static final Integer NXRRSET = 8;
    public static final Integer NOTAUTH = 9;
    public static final Integer NOTZONE = 10;
    public static final Integer BADVERS = 16;
    public static final Integer BADSIG = 16;
    public static final Integer BADKEY = 17;
    public static final Integer BADTIME = 18;
    public static final Integer BADMODE = 19;
    public static final Integer BADNAME = 20;
    public static final Integer BADALG = 21;
    public static final Integer BADTRUNC = 22;
    public static final Integer BADCOOKIE = 23;
}
