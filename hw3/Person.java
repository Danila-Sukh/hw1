package hw3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person {
    private String lastname;
    private String firstname;
    private String farthername;
    private String birthDate;
    private Long phone;
    private char gender;
    List<Person> savedPersons;

    public Person(String lastname, String firstname, String farthername,
                String birthDate, Long phone, char gender) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.farthername = farthername;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
    }

    @Override
    public String toString() {
        String res = "Person [lastname=" + lastname + 
                "\n, firstname=" + firstname +
                "\n, farthername=" + farthername +
                "\n, birthDate=" + birthDate +
                "\n, phone=" + phone +
                "\n, gender=" + gender + "]";
        return res;
    }

    public String toStringForFile() {
        String res = "<" + lastname + 
                "><" + firstname +
                "><" + farthername +
                "><" + birthDate +
                "><" + phone +
                "><" + gender + ">";
        return res;
    }

    public boolean saveToFile(String folderToSave) {

        List<Person> filePersons = readFromFile(folderToSave + getLastname() + ".txt");


        for (Person curFilePerson : filePersons) {
            if (getLastname().equals(curFilePerson.getLastname()) &&
                    getFirstname().equals(curFilePerson.getFirstname()) &&
                    getFarthername().equals(curFilePerson.getFarthername()) &&
                    getBirthDate().equals(curFilePerson.getBirthDate())) {

                curFilePerson.setPhone(getPhone());
                curFilePerson.setGender(getGender());
                isAdded = true;
            }
        }

        if (isAdded == false) {
            filePersons.add(new Person(getLastname(), getFirstname(), getFarthername(), 
            getBirthDate(), getPhone(), getGender()));
        }

        try (FileWriter writer = new FileWriter(folderToSave + 
                                                getLastname() + ".txt")) {
            
            for (Person person : filePersons) {
                writer.write(person.toStringForFile() + "\n");
            }
        } catch(RuntimeException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
            return false;
        } catch(IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
            return false;
        }
        return true;
    }

    public List<Person> readFromFile(String fileName) {
        List<Person> persons = new LinkedList<Person>();
        
        File f = new File(fileName);
        if(!f.exists()) {
            return persons;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String fileString = reader.readLine();
            while (fileString != null) {
                String[] params = fileString.split("><");
                if (params.length != 6) {
                    throw new RuntimeException("Ошибка чтения файла данных " + fileName +
                                                "Количество полей в строке не равно 6");
                }
                for (int i=0; i < params.length; i++) {
                    params[i] = params[i].replace("<", "").replace(">", "").trim();
                }
                
                Long phone = Long.parseLong(params[4]);
                char gender = params[5].charAt(0);
                if (!(gender == 'f' || gender == 'm')) {
                    throw new RuntimeException("Ошибка чтения файла данных " + fileName +
                                                ". Поле <Пол> имеет недопустимое значение: " + Character.toString(gender));
                }
                
                Person newPerson = new Person(params[0], params[1], params[2],
                                            params[3], phone, gender);
                persons.add(newPerson);

                fileString = reader.readLine();
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла" + e.getMessage());
        }        
            
        return persons;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getFarthername() {
        return farthername;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Long getPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setFarthername(String farthername) {
        this.farthername = farthername;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

}
