import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.http.HttpUtil;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ExportAvatar {
    public static void main(String[] args) throws SQLException {
        Db db = Db.use();
        List<Entity> list = db.findAll(Entity.create("muc_dept").set("dept_name_path", dept()).set("is_removed", 0));
        List<String> deptIdPath = list.stream().map(t -> (String) t.get("dept_id_path")).collect(Collectors.toList());
        List<Entity> result = new ArrayList<>();
        for (String s : deptIdPath) {
            List<Entity> query = db.query(sql(), s + "%");
            result.addAll(query);
        }
        db.closeConnection(db.getConnection());
        System.out.println("——————————Starting download————————————");
        System.out.println("Estimate download num: " + result.size());
        int success = 0;
        AtomicInteger fail = new AtomicInteger();
        Set<String> exclude = new HashSet<>();
        for (Entity entity : result) {
            String uid = (String) entity.get("uid");
            String headPhoto = (String) entity.get("head_photo");
            exclude.add(uid);
            ThreadUtil.execute(()-> {
                try {
                    download2(uid, headPhoto);
                } catch (Exception e) {
                    String log = "download fail.uid = %s.url = %s.";
                    System.out.println(String.format(log, uid, headPhoto));
                    fail.getAndIncrement();
                }
            });
            success++;
        }
        System.out.println("————————————Statistic————————————");
        System.out.println("Total download: " + (success + fail.get()));
        System.out.println("Truly total: " + exclude.size());
        System.out.println("Successful download: " + success);
        System.out.println("Failed download: " + fail);
        System.out.println("————————end————————");
    }

    static List<String> dept() {
        List<String> dept = new ArrayList<>();
        dept.add("美的_美的集团_家用空调事业部");
        dept.add("美的_美的集团_生活电器事业部");
        dept.add("美的_美的集团_中央空调事业部");
        dept.add("美的_美的集团_厨房和热水事业部");
        dept.add("美的_美的集团_IOT事业部");
        dept.add("美的_美的集团_中央研究院");
        dept.add("美的_美的集团_制造技术研究院");
        return dept;
    }

    static String sql() {
        return "with a as (select emp.id, emp.uid " +
                          "from muc_dept dept, " +
                               "muc_emp_dept_rel dept_rel, " +
                               "muc_emp emp " +
                          "where dept.id = dept_rel.dept_id " +
                            "and emp.id = dept_rel.emp_id " +
                            "and dept.dept_id_path like ? " +
                            "and emp_status = 2 " +
                            "and `rank` >= 13) " +
                "select distinct a.uid, b.head_photo " +
                "from muc_emp_ext b " +
                          "right join a on a.id = b.emp_id " +
                "where b.head_photo is not null;";
    }

    static void download(String fileName, String url) {
        String dir = "C:\\Users\\ancho\\Desktop\\avatar\\%s.jpg";
        HttpUtil.downloadFile(url, String.format(dir, fileName));
    }

    static void download2(String fileName, String url) throws Exception{
        String dir = "C:\\Users\\ancho\\Desktop\\avatar\\%s.jpg";
        URL url1 = new URL(url);
        URLConnection uc = url1.openConnection();
        InputStream inputStream = uc.getInputStream();
        FileOutputStream out = new FileOutputStream(String.format(dir, fileName));
        int j = 0;
        while ((j = inputStream.read()) != -1) {
            out.write(j);
        }
        inputStream.close();
    }
}
