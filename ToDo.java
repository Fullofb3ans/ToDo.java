package Severstal;

import java.sql.SQLException;
import java.util.Scanner;

public class ToDo {
    public static String command;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        System.out.println(Phrases.SEPARATOR.getText());
        System.out.println(Phrases.HELLO.getText());
        System.out.println(Phrases.SEPARATOR.getText());
        SqlConnect.connect();

        while (true) {
            System.out.println(Phrases.COMMAND.getText());
            System.out.println(Phrases.SEPARATOR.getText());
            command = scanner.nextLine();
            processing(command);
        }
    }
        private static void processing (String command) throws SQLException {
            String title;
            String text;

            switch (command) {
                case "ADD":
                    SqlConnect.connect();
                    System.out.println(Phrases.SEPARATOR.getText());
                    System.out.println(Phrases.ADD_COMMAND_TITLE.getText());
                    System.out.println(Phrases.SEPARATOR.getText());
                    Scanner scannerAddTitle = new Scanner(System.in);
                    title = scannerAddTitle.nextLine();

                    System.out.println(Phrases.SEPARATOR.getText());
                    System.out.println(Phrases.ADD_COMMAND_TEXT.getText());
                    Scanner scannerAddText = new Scanner(System.in);
                    text = scannerAddText.nextLine();

                    SqlConnect.insert(title, text);
                    System.out.println(Phrases.COMMIT.getText());
                    System.out.println(Phrases.SEPARATOR.getText());
                    SqlConnect.disconnect();
                    break;

                case "EDIT":
                    SqlConnect.connect();
                    System.out.println(Phrases.SEPARATOR.getText());
                    System.out.println(Phrases.EDIT_COMMAND_STEP1.getText());
                    Scanner scannerTitleEdit = new Scanner(System.in);
                    String titleEdit = scannerTitleEdit.nextLine();

                    System.out.println(Phrases.SEPARATOR.getText());
                    System.out.println(Phrases.EDIT_COMMAND_STEP2.getText());
                    Scanner scannerTextEdit = new Scanner(System.in);
                    String textEdit = scannerTextEdit.nextLine();

                    SqlConnect.update(titleEdit, textEdit);

                    System.out.println(Phrases.SEPARATOR.getText());
                    System.out.println(Phrases.COMMIT.getText());
                    SqlConnect.disconnect();
                    break;

                case "DEL":
                    SqlConnect.connect();
                    System.out.println(Phrases.SEPARATOR.getText());
                    System.out.println(Phrases.DEL_COMMAND.getText());
                    Scanner scannerForDel = new Scanner(System.in);
                    String delTitle = scannerForDel.nextLine();
                    SqlConnect.delete(delTitle);
                    System.out.println(Phrases.SEPARATOR.getText());
                    System.out.println(Phrases.COMMIT.getText());
                    SqlConnect.disconnect();
                    System.out.println(Phrases.SEPARATOR.getText());
                    break;

                case "CLEAR":
                    SqlConnect.connect();
                    SqlConnect.clear();
                    System.out.println(Phrases.SEPARATOR.getText());
                    System.out.println(Phrases.COMMIT.getText());
                    System.out.println(Phrases.SEPARATOR.getText());
                    SqlConnect.disconnect();
                    break;

                case "SHOW":
                    System.out.println(Phrases.SEPARATOR.getText());
                    SqlConnect.connect();
                    SqlConnect.find_all();
                    SqlConnect.disconnect();
                    System.out.println(Phrases.SEPARATOR.getText());
                    break;

                case "EXIT":
                    SqlConnect.connect();
                    System.out.println(Phrases.SEPARATOR.getText());
                    System.out.println(Phrases.EXIT_COMMAND.getText());
                    System.out.println(Phrases.SEPARATOR.getText());
                    SqlConnect.disconnect();
                    System.exit(0);
            }
        }
    }




