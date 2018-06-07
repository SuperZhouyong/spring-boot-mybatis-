package com.resumed.sqtwin.model.bean;

/**
 * Description: 绝无Bug
 * Data：2018/4/12 0012-下午 13:32
 * Blog：Super简单
 * Author: ZhouYong
 */

public class CheckUser {

    /**
     * status : 1
     * msg : 成功
     * data : {"phone":"17600298095","password":"628909867ab1086d46aaeee49004c391"}
     */

    private int status;
    private String msg;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * phone : 17600298095
         * password : 628909867ab1086d46aaeee49004c391
         */

        private String phone;
        private String password;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
