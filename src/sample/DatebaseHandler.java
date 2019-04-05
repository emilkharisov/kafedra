package sample;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.sql.*;
public class DatebaseHandler extends Configs {
    public String show_lastname ="Фамилия";
    public String  show_firstname ="Имя";
    public String  show_thirdname="Отчество";
    public String show_dolzhnost="Должность";
    public String show_uchstpen="                  Учебная степень";
    public String show_uchzvanie="Учебное звание";
    public String show_adres="Адрес";
    public String show_telephone="Телефон";
    public String show_obrazovanie="Образование";
    public String show_god="Год рождения";
    public String show_image ="C:\\Users\\arina\\IdeaProjects\\kafedra_assoi\\src\\sample\\pictures\\avatar.png";
    boolean error_show =false;
    /////////////////////////////////////////////////////////
    public String show_result_nazvanie;
    public String show_result_avtoru;
    public String show_result_str;
    public String show_result_tip;
    public String show_result_god;
    public String show_result_izdatel;
    public boolean exit = false;
    Connection dbConnection;


    public Connection getDbConnection(String Name) throws ClassNotFoundException,SQLException {
        String connectionString = "jdbc:mysql://"+ dbHost + ":" + dbPort + "/" + Name + "?" + "useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            if (dbConnection==null || !dbConnection.isClosed()) {
                System.out.println("Соединение с БД установлено");
                dbConnection = DriverManager.getConnection(connectionString,"root", "1234");
            }
        }
        catch ( SQLException e) {
            System.out.println("Не  установлено");
        }
        return dbConnection;
    }
    public   void add_info(String lastname,String firstname,String thirdname,String dolzhnost,String uchstpen,String uchzvanie,String adres,String telephone,String obrazovanie,String god,String path_image)
    {
        String insert = "INSERT INTO "+ Const.USER_TABLE +"("+ Const.USERS_LASTNAME + "," + Const.USERS_FIRSTNAME +
                "," + Const.USERS_THIRDNAME + "," + Const.USERS_DOLZHNOST + "," + Const.USERS_UCHSTEPEN + "," + Const.USERS_UCHZVANIE
                + "," + Const.USERS_ADRES + "," + Const.USERS_TELEPHONE+ "," + Const.USERS_OBRAZOVANIE + "," + Const.USERS_GOD + "," + Const.USERS_PATH_IMAGE + ")"
                +"values (?,?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement prSt = null;
            prSt = getDbConnection(dbName).prepareStatement(insert);
            prSt.setString(1,lastname);
            prSt.setString(2,firstname);
            prSt.setString(3,thirdname);
            prSt.setString(4,dolzhnost);
            prSt.setString(5,uchstpen);
            prSt.setString(6,uchzvanie);
            prSt.setString(7,adres);
            prSt.setString(8,telephone);
            prSt.setString(9,obrazovanie);
            prSt.setString(10,god);
            prSt.setString(11,path_image);


            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public   void add_info1(String nazvanie,String avtory,String stranicy,String tip,String god,String izdatel)
    {
        String insert = "INSERT INTO "+ Const.TRUD_TABLE1 +"("+ Const.TRUD_NAME + "," + Const.TRUD_AVTOR +
                "," + Const.TRUD_STR + "," + Const.TRUD_TIP + "," + Const.TRUD_GOD + "," + Const.TRUD_IZDATEL + ")"
                +"values (?,?,?,?,?,?)";

        try {

            PreparedStatement prSt= null;
            prSt = getDbConnection(dbName1).prepareStatement(insert);
            prSt.setString(1,nazvanie);
            prSt.setString(2,avtory);
            prSt.setString(3,stranicy);
            prSt.setString(4,tip);
            prSt.setString(5,god);
            prSt.setString(6,izdatel);



            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public   void add_info2(String nazvanie_stat,String nazvanie_jour,String tom,String tip,String stranicy,String avtory,String checkbox_rinc,String checkbox_scopus,String nomer,String god)
    {
        String insert = "INSERT INTO "+ Const.NAUCH_TRUD_TABLE1 +"("+ Const.NAUCH_TRUD_STAT + "," + Const.NAUCH_TRUD_JOUR +
                "," + Const.NAUCH_TRUD_TOM + "," + Const.NAUCH_TRUD_TIP + "," + Const.NAUCH_TRUD_STRANICY + "," + Const.NAUCH_TRUD_AVTOR + "," + Const.NAUCH_TRUD_CHECK_RINC + "," + Const.NAUCH_TRUD_CHECK_SCOP + "," + Const.NAUCH_TRUD_NOMER +"," + Const.NAUCH_TRUD_GOD + ")"
                +"values (?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement prSt= null;
            prSt = getDbConnection(dbName2).prepareStatement(insert);
            prSt.setString(1,nazvanie_stat);
            prSt.setString(2,nazvanie_jour);
            prSt.setString(3,tom);
            prSt.setString(4,tip);
            prSt.setString(5,stranicy);
            prSt.setString(6,avtory);
            prSt.setString(7,checkbox_rinc);
            prSt.setString(8,checkbox_scopus);
            prSt.setString(9,nomer);
            prSt.setString(10,god);



            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public ResultSet getUser(String lastname, String firstname, String thirdname)
    {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE;
        try {
            Statement prSt = getDbConnection(dbName).createStatement();
            resultSet=prSt.executeQuery(select);
            while(resultSet.next())
            {
                String lastname1 = resultSet.getString("lastname");
                String firstname1 = resultSet.getString("firstname");
                String thirdname1 = resultSet.getString("thirdname");
                if ((lastname.equals(lastname1)) && (firstname.equals(firstname1)) && (thirdname.equals(thirdname1)))
                {
                    show_lastname=resultSet.getString("lastname");
                    show_firstname=resultSet.getString("firstname");
                    show_thirdname=resultSet.getString("thirdname");
                    show_dolzhnost=resultSet.getString("dolzhnost");
                    show_uchstpen=resultSet.getString("uchstpen");
                    show_uchzvanie=resultSet.getString("uchzvanie");
                    show_adres=resultSet.getString("adres");
                    show_telephone=resultSet.getString("telephone");
                    show_obrazovanie=resultSet.getString("obrazovanie");
                    show_god=resultSet.getString("god");
                    show_image=resultSet.getString("path_image");
                    error_show=true;
                }
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public ResultSet getrResult_uch()
    {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.TRUD_TABLE1;
        try {
            Statement prSt = getDbConnection(dbName1).createStatement();
            resultSet=prSt.executeQuery(select);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getrResult_nauch()
    {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.NAUCH_TRUD_TABLE1;
        try {
            Statement prSt = getDbConnection(dbName2).createStatement();
            resultSet=prSt.executeQuery(select);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


    public void clear() {
          show_lastname ="Фамилия";
           show_firstname ="Имя";
           show_thirdname="Отчество";
          show_dolzhnost="Должность";
          show_uchstpen="Учебная степень";
          show_uchzvanie="Учебное звание";
          show_adres="Адрес";
          show_telephone="Телефон";
          show_obrazovanie="Образование";
          show_god="Год рождения";
          show_image ="C:\\Users\\arina\\IdeaProjects\\kafedra_assoi\\src\\sample\\pictures\\avatar.png";
         error_show =false;

    }
}
