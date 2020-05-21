package com.qcblog.util;

import com.qcblog.pojo.CmsContent;

import java.sql.*;

public class CmsContentDaoUtil {
    private Connection conn = null;
    private Statement stmt = null;

    public CmsContentDaoUtil() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://123.206.28.102:3306/qcblogs?"
                    + "user=root&password=qcbyl0&useUnicode=true&characterEncoding=UTF8";
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int add(CmsContent cmsContent) {
        try {
            String sql = "INSERT INTO `qcblogs`.`cms_content` (`id`, `title`, `content` , `url`, `status`, `utime`, `subject`) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cmsContent.getId());
            ps.setString(2, cmsContent.getTitle());
            ps.setString(3,cmsContent.getContent());
            ps.setString(4, cmsContent.getUrl());
            ps.setString(5, cmsContent.getStatus());
            ps.setString(6, cmsContent.getUtime());
            ps.setString(7, cmsContent.getSubject());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


}
