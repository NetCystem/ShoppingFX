package sample;

import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Models {

    public Models() {

    }

    public boolean check(TextField textField) {
        return textField.getText().matches("[A-Z a-z]+");
    }

    public static boolean checkEmail(TextField textField) {
        return textField.getText().matches("[a-z0-9._]+@[a-z0-9]+.[a-z]{2,4}");
    }

    public static boolean checkPhone(TextField textField) {
        return textField.getText().matches("[0-9]+");
    }

    public static boolean isSelected(ChoiceBox choiceBox) {
        return !choiceBox.getSelectionModel().isEmpty();
    }

    public boolean checkNumber(TextField textField) {
        return textField.getText().matches("[0-9]+");
    }

    public void clear(TextField textField) {
        if (!textField.getText().isEmpty())
            textField.clear();
    }

    public void clearBox(ChoiceBox choiceBox) {
        if (!choiceBox.getSelectionModel().isEmpty())
            choiceBox.getSelectionModel().clearSelection();
    }

    public boolean checkCVC(PasswordField passwordField) {
        return passwordField.getText().length() < 4 && passwordField.getText().matches("[0-9]+");
    }


    //Date Picker date formatting
    public void dateFormatting(DatePicker datePicker) {
        datePicker.setConverter(new StringConverter<LocalDate>() {
            private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/yy");

            @Override
            public String toString(LocalDate localDate) {
                if (localDate == null)
                    return "";
                return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if (dateString == null || dateString.trim().isEmpty()) {
                    return null;
                }
                return LocalDate.parse(dateString, dateTimeFormatter);
            }
        });
    }

    //Date picker is checked checking
    public boolean dateCheck(DatePicker datePicker) {
        return datePicker.getValue() != null;
    }

    //CVC  limit characters
    public EventHandler<KeyEvent> maxLength(final Integer i) {
        return arg0 -> {
            PasswordField pf = (PasswordField) arg0.getSource();
            if (pf.getText().length() >= i) {
                arg0.consume();
            }
        };
    }
}


