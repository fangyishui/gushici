package org.gushi.gushici;

import javax.xml.bind.annotation.XmlElement;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
/**
 * Author: fang
 * Date:   2022-02-23 14:12 星期三
 * Class:  GenerateSqlFromEntityUtil
 **/
public class GenerateSqlFromEntityUtil {

    public static void main(String[] a) {
        // 实体类的位置
        Class klass =org.gushi.gushici.domain.AuthorInfo.class;
        // 生成的sql语句的位置
        String outputPath = "D:/outSql/AuthorInfo.txt";
        generateTableSql(klass, outputPath, null);
        System.out.println("生成结束");
    }

    public static void writeFile(String content, String outputPath) {
        File file = new File(outputPath);
        System.out.println("文件路径: " + file.getAbsolutePath());
        // 输出文件的路径
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter out = null;

        try {
            // 如果文件存在，就删除
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            fos = new FileOutputStream(file, true);
            osw = new OutputStreamWriter(fos);
            out = new BufferedWriter(osw);
            out.write(content);
            // 清空缓冲流，把缓冲流里的文本数据写入到目标文件里
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void generateTableSql(Class obj, String outputPath, String tableName) {
        // tableName 如果是 null，就用类名做表名
        if (tableName == null || tableName.equals("")) {
            tableName = obj.getName();
            tableName = tableName.substring(tableName.lastIndexOf(".") + 1);
        }
        // 表名用大写字母
        tableName = tableName.toUpperCase();

        Field[] fields = obj.getDeclaredFields();
        Object param;
        String column;

        StringBuilder sb = new StringBuilder();

        sb.append("drop table if exists ").append(tableName).append(";\r\n");

        sb.append("\r\n");

        sb.append("create table ").append(tableName).append("(\r\n");

        System.out.println(tableName);

        boolean firstId = true;

        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];

            column = f.getName();

            System.out.println(column + ", " + f.getType().getSimpleName());

            param = f.getType();
            sb.append(column); // 一般第一个是主键

            if (param instanceof Integer) {
                sb.append(" INTEGER ");
            } else {
                // 注意：根据需要，自行修改 varchar 的长度。这里设定为长度等于 50
                int length = 50;
                sb.append(" VARCHAR(" + length + ")");
            }

            if (firstId == true) {
                sb.append(" PRIMARY KEY ");
                firstId = false;
            }

            // 获取字段中包含 fieldMeta 的注解

            // 获取属性的所有注释
            Annotation[] allAnnotations = f.getAnnotations();

            XmlElement xmlElement = null;
            Class annotationType = null;

            for (Annotation an : allAnnotations) {
                sb.append(" COMMIT '");
                xmlElement = (XmlElement) an;
                annotationType = an.annotationType();
                param = ((XmlElement) an).name();
                System.out.println("属性 " + f.getName() + " ----- 的注释类型有: " + param);
                sb.append(param).append("'");
            }

            if (i != fields.length - 1) { // 最后一个属性后面不加逗号
                sb.append(", ");
            }

            sb.append("\n");
        }

        String sql = sb.toString();

        sql = sb.substring(0, sql.length() - 1) + "\n) " + "ENGINE = INNODB DEFAULT CHARSET = utf8;";

        writeFile(sql, outputPath);
    }
}
