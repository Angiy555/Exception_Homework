import java.text.ParseException;
import java.text.SimpleDateFormat;

import Exception.InvalidGenderFormatException;

public class PersonalCard {

    private String surname, name, patronymic, dateOfBirth;
    private int numPhone;
    private char gender;

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public char getGender() {
        return gender;
    }
    public String getName() {
        return name;
    }
    public int getNumPhone() {
        return numPhone;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public String getSurname() {
        return surname;
    }
    public void setDateOfBirth(String dateOfBirth) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);
        sdf.parse(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }
    public void setGender(char gender) {
        if(gender == 'f' || gender == 'm'){
            this.gender = gender;
        }else{
            throw new InvalidGenderFormatException("Указан неверный пол. Поставце букву f или m.");
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumPhone(int numPhone) {
        this.numPhone = numPhone;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
