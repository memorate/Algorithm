import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.http.HttpUtil;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ExportAvatar {

    final static String destination = "C:\\Users\\ancho\\Desktop\\avatar\\";

    public static void main(String[] args) throws Exception {
        downloadDept();
    }

    static int downloadUser() throws Exception{
        Db db = Db.use();
        List<Entity> list = db.query(userSql(userInitialize()));
        for (Entity entity : list) {
            String uid = (String) entity.get("uid");
            String headPhoto = (String) entity.get("head_photo");
            try {
                download2(uid, headPhoto);
            } catch (Exception e) {
                String log = "download fail.uid = %s.url = %s.";
                System.out.println(String.format(log, uid, headPhoto));
            }
        }
        System.out.println(list);
        return list.size();
    }

    static int downloadDept() throws Exception{
        Db db = Db.use();
        List<Entity> list = db.findAll(Entity.create("muc_dept").set("dept_name_path", deptInitialize()).set("is_removed", 0));
        List<String> deptIdPath = list.stream().map(t -> (String) t.get("dept_id_path")).collect(Collectors.toList());
        List<Entity> allAvatar = new ArrayList<>();
        for (String s : deptIdPath) {
            List<Entity> query = db.query(deptSql(), s + "%");
            allAvatar.addAll(query);
        }
        db.closeConnection(db.getConnection());
        System.out.println("——————————Starting download————————————");
        System.out.println("Estimate download num: " + allAvatar.size());
        AtomicInteger success = new AtomicInteger(), fail = new AtomicInteger();
        List<List<Entity>> downloadList = subList(allAvatar, 200);
        for (List<Entity> item : downloadList) {
            ThreadUtil.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " start downloading!");
                for (Entity entity : item) {
                    String uid = (String) entity.get("uid");
                    String headPhoto = (String) entity.get("head_photo");
                    try {
                        download2(uid, headPhoto);
                    } catch (Exception e) {
                        String log = "download fail.uid = %s.url = %s.";
                        System.out.println(String.format(log, uid, headPhoto));
                        fail.getAndIncrement();
                    }
                    success.getAndIncrement();
                }
            });
        }
        System.out.println("————————————Statistic————————————");
        System.out.println("Total download: " + (success.get() + fail.get()));
        System.out.println("Successful download: " + success);
        System.out.println("Failed download: " + fail);
        System.out.println("———————————————end———————————————");
        return success.get();
    }

    static List<String> userInitialize(){
//        String[] array = {"fanghb","wangjg","huziqiang","xiaomg","zhangxy11","lign",
//                "francoise","btyin","helmut.zodl","guym","wangjl"};
        String[] array = {"funyj", "zhaolei2", "scott", "peter", "avant", "xumf", "macp"};
        return ListUtil.toList(array);
    }

    static List<String> deptInitialize() {
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

    static String userSql(List<String> users){
        String joint = "";
        for (String user : users) {
            joint += "'" + user + "',";
        }
        joint = joint.substring(0, joint.lastIndexOf(','));
        return "select emp.uid, ext.head_photo\n" +
                     "from muc_emp_ext ext,\n" +
                     "     muc_emp emp\n" +
                     "where emp.uid in (" + joint + ") and emp.id = ext.emp_id";
    }

    static String deptSql() {
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

    static void download2(String fileName, String avatarUrl) throws Exception{
        String dir = destination + "%s.jpg";
        URL url = new URL(avatarUrl);
        InputStream inputStream = url.openConnection().getInputStream();
        FileOutputStream out = new FileOutputStream(String.format(dir, fileName));
        int j = 0;
        while ((j = inputStream.read()) != -1) {
            out.write(j);
        }
        inputStream.close();
    }

    static <T> List<List<T>> subList(List<T> list, int step) {
        if (list == null || list.size() == 0 || step < 1) return Collections.emptyList();
        List<List<T>> result = new ArrayList<>();
        for (int i = 0; i < list.size(); ) {
            List<T> subList = list.subList(i, i = Math.min(i + step, list.size()));
            result.add(subList);
        }
        return result;
    }
}
