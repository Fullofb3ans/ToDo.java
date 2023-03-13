package Severstal;

public enum Phrases {
    HELLO ("Привет, это твой список задач"),
    COMMAND ("Введите одну из комманд: \n ADD \n EDIT \n DEL \n CLEAR \n SHOW \n EXIT"),
    ADD_COMMAND_TITLE("Введите заголовок дела, которое вы хотите добавить"),
    ADD_COMMAND_TEXT("Введите текст дела, которое вы хотите добавить"),
    EDIT_COMMAND_STEP1("Введите заголовок дела, которое вы хотите изменить"),
    EDIT_COMMAND_STEP2 ("Введите новое задание вместо старого"),
    COMMIT("Готово"),
    DEL_COMMAND("Введите заголовок дела, которое вы хотите удалить"),
    SEPARATOR("----------------------------------"),
    EXIT_COMMAND ("Удачи!");
private final String text;
    Phrases(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}

