/*
package com.resumed.sqtwin.utils;

*/
/**
 * @auther Super
 * @data 2018/4/18 0018
 * @time 下午 16:22
 *//*





import java.util.ArrayList;
import java.util.List;

//import com.sqt.resume_generator.db.DBConnection;

public class IDGenerator {
//    private static DBConnection dbConnection = null;

   */
/* public IDGenerator() {
        super();

        dbConnection = DBConnection.getInstance();
    }*//*


    public int getNewGid() {
        String statement = "insert into web_id values()";
        return dbConnection.executeSQLInsertStatement(statement);
    }



    public int genId() {
        int lastId = 0;
        do {
            lastId = getNewGid();
        } while (isIdInlegal(lastId));

        return lastId;
    }

    */
/**
     *
     * need stop all services to run this function
     * @param total
     * @return
     *//*

    public List<Integer> getIdList(int total){
        List<Integer> gidList = new ArrayList<Integer>();

        int firstGid = this.getMaxGid() + 1;

        int count = 0;
        for(int i = firstGid; i <firstGid + total * 2;i++){
            if(!this.isIdInlegal(i)){
                gidList.add(Integer.valueOf(i));
                count++;

                if(count == total){
                    //Save max gid

                    this.saveMaxGid(i);
                    break;
                }
            }
        }

        return gidList;
    }

    public void saveMaxGid(int maxGid){
        String statement = "insert into web_id values(" + maxGid + ")";
        dbConnection.executeSQLInsertStatement(statement);
    }

    public int getMaxGid(){
        String statement = "select max(id) from web_id";
        List<Object> bList = dbConnection.executeSQLQueryStatement(statement);
        if( bList == null || bList.size() == 0){
            return 1000000;
        }

        Long maxGid = (Long) bList.get(0);
        return maxGid.intValue();
    }

    public boolean isIdInlegal(int id) {
        String idstr = String.valueOf(id);

        int len = idstr.length();
        int base = 1;
        for (int index = 1; index < len; index++) {
            base = base * 10;
        }

        List<Integer> idArray = new ArrayList<Integer>();

        int idInt = id;
        for (int index = 0; index < len; index++) {
            int b = (int) (idInt / base);
            idArray.add(b);

            idInt = idInt - b * base;
            base = base / 10;
        }

        boolean isCon1 = true; //  1111122
        boolean isCon2 = true; //  2111112
        boolean isCon3 = true; //  2211111
        boolean isCon4 = true; //  1234522
        boolean isCon5 = true; //  5432122
        boolean isCon6 = true; //  1112345
        boolean isCon7 = true; //  1154321
        for (int index = 0; index < len - 1; index++) {
            //1
            if (index < len - 3) {
                if (getValue(index, idArray) != getValue(index + 1, idArray))
                    isCon1 = false;
            }

            //2
            if (index > 0 && index < len - 2) {
                if (getValue(index, idArray) != getValue(index + 1, idArray))
                    isCon2 = false;
            }

            //3
            if (index > 1) {
                if (getValue(index, idArray) != getValue(index + 1, idArray))
                    isCon3 = false;
            }

            //4
            if (index < len - 3) {
                if ((getValue(index + 1, idArray) - getValue(index, idArray)) != 1)
                    isCon4 = false;
            }

            //5
            if (index < len - 3) {
                if ((getValue(index, idArray) - getValue(index + 1, idArray)) != 1)
                    isCon5 = false;
            }

            //6
            if (index > 1) {
                if ((getValue(index + 1, idArray) - getValue(index, idArray)) != 1)
                    isCon6 = false;
            }

            //7
            if (index > 1) {
                if ((getValue(index, idArray) - getValue(index + 1, idArray)) != 1)
                    isCon7 = false;
            }
        }

        return isCon1 || isCon2 || isCon3 || isCon4 || isCon5 || isCon6 || isCon7;
    }

    public int getValue(int index, List<Integer> idArray) {
        return idArray.get(index).intValue();
    }

    public static void main(String[] args) {

		*/
/*String webDatabaseIP = DataManagerPropertiesParser.getInstance().getString("web_db_ip", "localhost");
		int webDatabasePort = DataManagerPropertiesParser.getInstance().getInt("web_db_port", 3306);
		String webDatabaseName = DataManagerPropertiesParser.getInstance().getString("web_db_name", "sqtdb");
		String webDatabaseUsername = DataManagerPropertiesParser.getInstance().getString("web_db_username", "root");
		String webDatabasePassword = DataManagerPropertiesParser.getInstance().getString("web_db_passwd", "sa");
		DBConnection webDbConnection = DBConnection.getInstance();
		boolean ret = webDbConnection.initDB("jdbc:mysql://" + webDatabaseIP + ":" + webDatabasePort + "/"
				+ webDatabaseName + "?useUnicode=true&characterEncoding=UTF-8", webDatabaseUsername,
				webDatabasePassword);
		if (ret == false) {
			System.out.println("Error: Web DB Init Fail");
			return;
		}

		IDGenerator g = new IDGenerator();
		System.out.println(g.genId());*//*


    }

}

*/
