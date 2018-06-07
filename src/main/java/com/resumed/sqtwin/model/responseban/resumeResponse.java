package com.resumed.sqtwin.model.responseban;

import java.util.List;

/**
 * @auther Super
 * @data 2018/4/18 0018
 * @time 下午 17:10
 */
public class resumeResponse {
    private List<ItemBean> mResume;

    public List<ItemBean> getmResume() {
        return mResume;
    }

    public void setmResume(List<ItemBean> mResume) {
        this.mResume = mResume;
    }

    public static class ItemBean {
        private String TypeName;
        private String TypeNum;
        private Object mList;

        public String getTypeName() {
            return TypeName;
        }

        public void setTypeName(String typeName) {
            TypeName = typeName;
        }

        public String getTypeNum() {
            return TypeNum;
        }

        public void setTypeNum(String typeNum) {
            TypeNum = typeNum;
        }

        public Object getmList() {
            return mList;
        }

        public void setmList(Object mList) {
            this.mList = mList;
        }
    }


}
