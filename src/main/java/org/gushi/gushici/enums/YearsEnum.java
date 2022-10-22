package org.gushi.gushici.enums;

/**
 * Author: fang
 * Date:   2022-02-19 20:43 星期六
 * Class:  YearsEnum
 * 夏、商、周【西周、东周（春秋、战国）】、秦、汉（西汉、东汉）、三国（魏、蜀、吴）、
 * 晋（西晋、东晋）、五胡十六国、南北朝【南朝（刘宋、萧齐、萧梁、南陈）、北朝（北魏、东魏、西魏、北齐、北周）】、
 * 隋、唐、五代十国【五代（后梁、后唐、后晋、后汉、后周）、
 * 十国（前蜀、后蜀、杨吴、南唐、吴越、闽、马楚、南汉、南平、北汉）】、
 * 宋（北宋、南宋）、辽、西夏、金、元、明、清
 **/
public enum YearsEnum {

    /**
     * 年代枚举
     */
    Xia(1, "夏"),
    Shang(2, "商"),

    Zhou(3, "周"),
    XiZhou(31, "西周"),
    DongZhou(32, "东周"),
    ChunQiu(33, "春秋"),
    ZhanGuo(34, "战国"),

    XianQin(41, "先秦"),
    Qin(4, "秦"),

    Han(5, "汉"),
    XiHan(51, "西汉"),
    DongHan(52, "东汉"),

    SanGuo(6, "三国"),
    Wei(61, "魏"),
    Shu(62, "蜀"),
    Wu(63, "吴"),


    Jin(7,"晋"),
    XiJin(71,"西晋"),
    DongJin(72,"东晋"),

    /**
     * 成汉、前赵、后赵、前凉、北凉、西凉、后凉、南凉、前燕、后燕、南燕、北燕、夏、前秦、西秦、后秦
     */
    ShiLiuGuo(8,"五胡十六国"),

    /**
     * 南北朝
     */
    BeiChao(9,"北朝"),
    NanChao(10,"南朝"),

    Sui(11, "隋"),

    Tang(12, "唐"),

    Song(13, "宋"),
    BeiSong(131, "北宋"),
    NanSong(132, "南宋"),

    Yuan(14, "元"),
    Ming(15, "明"),

    Qing(16, "清"),

    MingGuo(17, "中华民国"),
    GongHeGuo(18, "中华人民共和国");

    private int code;
    private String desc;

    YearsEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByCode(Integer code){
        if (code == null){
            return null;
        }
        for (YearsEnum orderStatusEnum : YearsEnum.values()){
            if (code.equals(orderStatusEnum.code)){
                return orderStatusEnum.desc;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(YearsEnum.BeiSong.desc);


    }
}
