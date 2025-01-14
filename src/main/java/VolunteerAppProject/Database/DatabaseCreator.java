package VolunteerAppProject.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseCreator {

//    private static final String url = "jdbc:mysql://95.213.37.11:3306/VolunteerAppDatabase";
    private static final String url = "jdbc:mysql://demo11.alpha.vkhackathon.com:3306/VolunteerAppDatabase";
    private static final String user = "AppServer";
    private static final String password = "vol2019";

    private static Connection connection;
    private static Statement stmt;



    private static final String createVolunteersTable = "CREATE TABLE Volunteer (\n" +
            "    user_id INT primary key AUTO_INCREMENT,\n" +
            "    vk_id INT NOT NULL,\n" +
            "    surname TEXT,\n" +
            "    first_name TEXT,\n" +
            "    second_name TEXT,\n" +
            "    museum TEXT,\n" +
            "    birthday TEXT,\n" +
            "    sex TEXT,\n" +
            "    rating DOUBLE,\n" +
            "    email TEXT,\n" +
            "    phone TEXT,\n" +
            "    occupation TEXT,\n" +
            "    speciality TEXT,\n" +
            "    langs TEXT,\n" +
            "    volunteer_experience TEXT,\n" +
            "    children_work_experience TEXT,\n" +
            "    skills TEXT,\n" +
            "    expectations TEXT,\n" +
            "    medical_contraindications TEXT,\n" +
            "    food_preferences TEXT,\n" +
            "    clothes_size TEXT,\n" +
            "    information_source TEXT,\n" +
            "    mailing_agreement BOOL" +
            ")";

    private static final String createEventsTable = "CREATE TABLE Event (\n" +
            "    event_id INT primary key AUTO_INCREMENT,\n" +
            "    vk_id INT,\n" +
            "    organizer_id INT,\n" +
            "    name TEXT,\n" +
            "    description TEXT,\n" +
            "    date DATE,\n" +
            "    volunteers_task TEXT,\n" +
            "    volunteer_requirements TEXT,\n" +
            "    place TEXT" +
            ")";

    private static final String createVolunteersToEventsTable = "CREATE TABLE VolunteersToEvents (\n" +
            "    event_volunteer_id INT primary key AUTO_INCREMENT,\n" +
            "    FOREIGN KEY (event_id)  REFERENCES Event (event_id),\n" +
            "    FOREIGN KEY (volunteer_id)  REFERENCES Volunteer (user_id)" +
            ")";

    private static final String createTimeIntervalsToEvents = "CREATE TABLE TimeIntervalsToEvents (\n" +
            "    time_event_id INT primary key AUTO_INCREMENT,\n" +
            "    FOREIGN KEY (event_id)  REFERENCES Event (event_id),\n" +
            "    FOREIGN KEY (time_interval_id)  REFERENCES TimePeriodsTable (time_period_id)" +
            ")";

    private static final String createTimePeriodsTable = "CREATE TABLE TimePeriodsTable (\n" +
            "    time_period_id INT primary key AUTO_INCREMENT,\n" +
            "    event_id INT NOT NULL,\n" +
            "    time_period TEXT,\n" +
            "    people_count INT" +
            ")";

    public static void main(String[] args) {
        //initDB();

        DataBase.addNewEvent(
                "123534",
                "124983",
                "NameTest",
                "Description",
                "14.01.19980",
                "Task",
                "requirements",
                "place",
                "Период1%26$Период2%87"

        );

//        Boolean res = DataBase.addNewUser(
//                "123456",
//                "","","","","","","","","","","","","","","","","","","");
       // System.out.println(res);
    }

    public static void initDB(){

        Scanner in = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, user, password);
            stmt = connection.createStatement();


            PreparedStatement preparedCreateVolunteersTableStatement = connection.prepareStatement(createVolunteersTable);
            preparedCreateVolunteersTableStatement.executeUpdate();

            PreparedStatement preparedCreateEventsTableStatement = connection.prepareStatement(createEventsTable);
            preparedCreateEventsTableStatement.executeUpdate();


            PreparedStatement preparedCreateTimePeriodsTableStatement = connection.prepareStatement(createTimePeriodsTable);
            preparedCreateTimePeriodsTableStatement.executeUpdate();

            PreparedStatement preparedCreateTable4Statement = connection.prepareStatement(createVolunteersToEventsTable);
            preparedCreateTable4Statement.executeUpdate();

//            Boolean res = DataBase.addNewUser(
//                    "123456",
//                    "","","","","","","","","","","","","","","","","","","");
//            System.out.println(res);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
