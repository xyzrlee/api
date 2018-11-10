package app.illl.api.struct.io.dns.meta;

import java.util.HashMap;
import java.util.Map;

public enum RRType {

    A(1, "A"),
    NS(2, "NS"),
    MD(3, "MD"),
    MF(4, "MF"),
    CNAME(5, "CNAME"),
    SOA(6, "SOA"),
    MB(7, "MB"),
    MG(8, "MG"),
    MR(9, "MR"),
    NULL(10, "NULL"),
    WKS(11, "WKS"),
    PTR(12, "PTR"),
    HINFO(13, "HINFO"),
    MINFO(14, "MINFO"),
    MX(15, "MX"),
    TXT(16, "TXT"),
    RP(17, "RP"),
    AFSDB(18, "AFSDB"),
    X25(19, "X25"),
    ISDN(20, "ISDN"),
    RT(21, "RT"),
    NSAP(22, "NSAP"),
    NSAPPTR(23, "NSAPPTR"),
    SIG(24, "SIG"),
    KEY(25, "KEY"),
    PX(26, "PX"),
    GPOS(27, "GPOS"),
    AAAA(28, "AAAA"),
    LOC(29, "LOC"),
    NXT(30, "NXT"),
    EID(31, "EID"),
    NIMLOC(32, "NIMLOC"),
    SRV(33, "SRV"),
    ATMA(34, "ATMA"),
    NAPTR(35, "NAPTR"),
    KX(36, "KX"),
    CERT(37, "CERT"),
    A6(38, "A6"),
    DNAME(39, "DNAME"),
    SINK(40, "SINK"),
    OPT(41, "OPT"),
    APL(42, "APL"),
    DS(43, "DS"),
    SSHFP(44, "SSHFP"),
    IPSECKEY(45, "IPSECKEY"),
    RRSIG(46, "RRSIG"),
    NSEC(47, "NSEC"),
    DNSKEY(48, "DNSKEY"),
    DHCID(49, "DHCID"),
    NSEC3(50, "NSEC3"),
    NSEC3PARAM(51, "NSEC3PARAM"),
    TLSA(52, "TLSA"),
    SMIMEA(53, "SMIMEA"),
    HIP(55, "HIP"),
    NINFO(56, "NINFO"),
    RKEY(57, "RKEY"),
    TALINK(58, "TALINK"),
    CDS(59, "CDS"),
    CDNSKEY(60, "CDNSKEY"),
    OPENPGPKEY(61, "OPENPGPKEY"),
    CSYNC(62, "CSYNC"),
    SPF(99, "SPF"),
    UINFO(100, "UINFO"),
    UID(101, "UID"),
    GID(102, "GID"),
    UNSPEC(103, "UNSPEC"),
    NID(104, "NID"),
    L32(105, "L32"),
    L64(106, "L64"),
    LP(107, "LP"),
    EUI48(108, "EUI48"),
    EUI64(109, "EUI64"),
    TKEY(249, "TKEY"),
    TSIG(250, "TSIG"),
    IXFR(251, "IXFR"),
    AXFR(252, "AXFR"),
    MAILB(253, "MAILB"),
    MAILA(254, "MAILA"),
    ANY(255, "ANY"),
    URI(256, "URI"),
    CAA(257, "CAA"),
    AVC(258, "AVC"),
    DOA(259, "DOA"),
    TA(32768, "TA"),
    DLV(32769, "DLV"),
    ;

    private static final Map<String, RRType> NAME_MAP = new HashMap<>();
    private static final Map<Integer, RRType> VALUE_MAP = new HashMap<>();

    static {
        for (RRType rrType : RRType.values()) {
            NAME_MAP.put(rrType.getName(), rrType);
            VALUE_MAP.put(rrType.getValue(), rrType);
        }
    }

    public static RRType queryByName(String name) {
        return NAME_MAP.get(name);
    }

    public static RRType queryByValue(Integer value) {
        return VALUE_MAP.get(value);
    }

    private String name;
    private Integer value;

    RRType(Integer value, String name) {
        this.setName(name);
        this.setValue(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
