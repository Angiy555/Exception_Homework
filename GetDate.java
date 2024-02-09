import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Exception.InvalidDataException;
import Exception.InvalidGenderFormatException;
import Exception.InvalidNumberFormatException;

public class GetDate {

    public static void main(String[] args) {
        PersonalCard card = new PersonalCard();
        try{
            addOfConsole(card);
            createFile(card);
            System.out.println("Данные успешно обработаны и записаны в файл с фамилией пользователя.");
        }catch(InvalidDataException e){
            System.err.println(e.getMessage());
        }catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }catch(InvalidNumberFormatException e){
            System.err.println(e.getMessage());
        }catch(InvalidGenderFormatException e){
            System.err.println(e.getMessage());
        }catch(IOException e){
            System.err.println("Ошибка при создании файла");
        }
    }

    public static void addOfConsole(PersonalCard card) throws InvalidDataException, IllegalArgumentException, InvalidNumberFormatException, InvalidGenderFormatException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Фамилия Имя Отчество дата_рождения(dd.mm.yyyy) номер_телефона пол(f или m): ");
        String input = scanner.nextLine();
        String[] date = input.split(" ");

        if(date.length != 6){
            throw new InvalidDataException("Неверное количество данных. Требуется 6 значений.");
        }

        card.setSurname(date[0].toUpperCase());
        card.setName(date[1].toUpperCase());
        card.setPatronymic(date[2].toUpperCase());
        try{
            card.setDateOfBirth(date[3]);
            card.setNumPhone(Integer.parseInt(date[4]));
        }catch(ParseException e){
            throw new IllegalArgumentException("Неверный формат даты. Используйте дд.мм.гггг");
        }catch(NumberFormatException e){
            throw new InvalidNumberFormatException("Неверный формат телефона. Используйте только цифры");
        }
        card.setGender(date[5].charAt(0));
    }

    public static void createFile(PersonalCard card) throws IOException{
        try(FileWriter writer = new FileWriter(card.getSurname() + ".txt", true)){
            String s = " ";
            writer.write(card.getSurname() + s + card.getName() + s + card.getPatronymic() + s + card.getDateOfBirth() + s + card.getNumPhone() + s + card.getGender() + "\n");
        }
    }
}