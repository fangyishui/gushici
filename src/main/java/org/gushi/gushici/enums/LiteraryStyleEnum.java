package org.gushi.gushici.enums;

/**
 * Author: fang
 * Date:   2022-02-28 10:37 星期一
 * Class:  LiteraryStyleEnum
 **/
public enum LiteraryStyleEnum {


    Shi(1,"诗"),
    Ci(2,"词"),
    Ge(3,"歌"),
    Fu(4,"赋");

    private int code;
    private String desc;

    private  LiteraryStyleEnum(int code, String desc) {
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
        for (LiteraryStyleEnum orderStatusEnum : LiteraryStyleEnum.values()){
            if (code.equals(orderStatusEnum.code)){
                return orderStatusEnum.desc;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println( LiteraryStyleEnum.getDescByCode(1));
        System.out.println( LiteraryStyleEnum.Shi.code);
        System.out.println( LiteraryStyleEnum.Shi.desc);
//        System.out.println( LiteraryStyleEnum..Shi.desc);
    }
}
