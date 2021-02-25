import java.io.*;
import java.util.ArrayList;

public class Tasks {
    /** Цей метод визначає кількість всіх слів
     * та кількість унікальних слів з {@code text}
     * @param text любий набір символів
     */
    public static void taskOneOne(String text) {
        //Видаляєм всі розділові знаки
        text = text.replaceAll("[.!,?]", "");
        //Створюємо масив для всіх слів
        String[] words = text.split("[\\s]+");
        //Створюємо масив для унікальних слів
        String[] wordsWithoutClone = words;
        //Якщо розмір масива words > 1 , то ми викликаєм
        //метод на видалення клонів.
        //Якщо розмір масива words <= 1 , то сенсу викликати
        //метод немає , тому що там неможуть буди клони.
        if(words.length > 1) wordsWithoutClone = removeClone(words);
        //виводим полученні значення на екран
        System.out.println("К-ть всіх слів - " + words.length);
        System.out.println("К-ть унікальних слів - " + wordsWithoutClone.length);
    }
    /** Цей метод видаляє всі клони слів
     *  з масива {@code words}
     * @param words масив набіров символів
     * @return масив {@code words} без клонів
     */
    public static String[] removeClone(String[] words) {
        //Створюємо Arraylist для унікальних слів
        ArrayList<String> wordsWithoutClone = new ArrayList<>();
        //Проходим ввесь масив
        for (String word : words) {
            //Перевіряєм на наявність цього слова в Arraylist
            //і якщо такого слова немає то добавляєм.
            if(!wordsWithoutClone.contains(word)){
                wordsWithoutClone.add(word);
            }
        }
        //Повертаєм конвертований Arraylist в String[]
        return wordsWithoutClone.toArray(String[]::new);
    }

    /** Цей метод визначає кількість всіх символів
     * та кількість унікальних символів з {@code text}
     * @param text любий набір символів
     */
    public static void taskOneTwo(String text){
        //Конвертуєм String в char[]
        char[] chars = text.toCharArray();
        //викликаєм метод для видалення клонів символів.
        Character[] charsWithoutClone = removeClone(chars);
        //виводим полученні значення на екран
        System.out.println("К-ть всіх cимволів - " + text.length());
        System.out.println("К-ть унікальних cимволів - " + charsWithoutClone.length);
    }
    /** Цей метод видаляє всі клони символів
     *  з масива {@code chars}
     * @param chars масив символів
     * @return масив {@code words} без клонів
     */
    public static Character[] removeClone(char[] chars) {
        //Створюємо Arraylist для унікальних символів
        ArrayList<Character> charsWithoutClone = new ArrayList<>();
        //Проходим ввесь масив
        for (char symbol : chars) {
            //Перевіряєм на наявність цього символа в Arraylist
            //і якщо такого символа немає то добавляєм.
            if(!charsWithoutClone.contains(symbol)){
                charsWithoutClone.add(symbol);
            }
        }
        //Повертаєм конвертований Arraylist в Character[]
        return charsWithoutClone.toArray(Character[]::new);
    }

    /** Цей метод рахує кількість речень в якомусь файлі
     * вказаній за шляхом {@code path}
     * @param path шлях, де розташований файл
     * @throws IOException якщо по такому шляху {@code path} неіснує
     * файла , або помилки повязані з відкриванням/зчитуванням
     * данних з файла
     */
    public static void taskTwo(String path) throws IOException {
        //считуємо сюда данні з файла
        String text = fileReader(path);
        //рахуєм кількість речень
        int amountOfSentences = countSentences(text);
        //виводим полученні значення на екран
        System.out.println("К-ть речень = " + amountOfSentences);
    }
    /** Цей метод рахує кількість речент
     * в {@code text}
     * @param text любий набір символів
     * @return кількість речень
     */
    public static int countSentences(String text) {
        //розбиваєм текст на речення і рахуєм їхню кількість
        return text.split("[.?!]+").length;
    }

    /** Цей метод визначає кількість всіх символів
     * та кількість унікальних символів з файла
     * {@code fromPath}, та записує рузультат в
     * файл за шляхом {@code toPath}
     * @param fromPath шлях, де розташований файл звідки
     *                 считати текст
     * @param toPath шлях, де розташований файл куда
     *                 записати результат
     * @throws IOException якщо по такому шляху {@code path} неіснує
     * або помилки повязані з відкриванням/считуванням/запизування
     * данних з файла
     */
    public static void taskTree(String fromPath, String toPath) throws IOException {
        //считуємо сюда данні з файла
        String text = fileReader(fromPath);
        //Конвертуєм String в char[]
        char[] chars = text.toCharArray();
        //викликаєм метод для видалення клонів символів.
        Character[] charsWithoutClone = removeClone(chars);
        //записуєм результат
        String result =  "К-ть всіх cимволів - " + text.length();
        result += "\nК-ть унікальних cимволів - " + charsWithoutClone.length;
        //записуєм в файл
        FileWriter(toPath, result);
    }

    /** Цей метод считує з файла весь текст
     *  розташованим в {@code path}, якщо такого
     *  файла немає то викидається помилка IOException
     * @param path шлях, де розташований файл
     * @return весь зчитаний текст з файла
     * @throws IOException якщо по такому шляху {@code path} неіснує
     * файла , або помилки повязані з відкриванням/зчитуванням
     * данних з файла
     */
    private static String fileReader (String path) throws IOException {
        //створюємо обєкт File
        File isFile = new File(path);
        //перевіряєм на наявність цього файла на комп'ютері
        //якщо його немає, то викидається помилка IOException
        if(!isFile.isFile()) throw new IOException("Файл не знайдено!");
        //створюємо обєкт BufferedReader для зчитування данних з файла
        FileReader readerFile = new FileReader(path);
        BufferedReader reader = new BufferedReader(readerFile);
        //створюємо обєкт String для построкового считування данних з файла
        String line;
        //створюємо обєкт BufferedReader для швидкої контенентація строк
        StringBuilder lines = new StringBuilder();
        //построкове считування данних з файла
        while ((line = reader.readLine()) != null) {
            lines.append(line);
        }
        //закриваєм файл
        reader.close();
        //Повертаєм увесь считаний текст з файла
        return lines.toString();
    }
    /** Цей метод записує в файл весь переданий
     * текст {@code text}, якщо такого
     *  файла немає то викидається помилка IOException
     * @param path шлях, де розташований файл
     * @throws IOException якщо по такому шляху {@code path} неіснує
     * файла , або помилки повязані з відкриванням/записуванням
     * данних з файла
     */
    private static void FileWriter (String path, String text) throws IOException {
        //створюємо обєкт File
        File isFile = new File(path);
        //перевіряєм на наявність цього файла на комп'ютері
        //якщо його немає, то викидається помилка IOException
        if(!isFile.isFile()) throw new IOException("Файл не знайдено!");
        //створюємо обєкт BufferedWriter для запису данних з файла
        FileWriter inputFile = new FileWriter(path);
        BufferedWriter writer = new BufferedWriter(inputFile);
        //записуєм в файл
        writer.write(text);
        //очищаєм поток
        writer.flush();
        //закриваєм файл
        writer.close();
    }
}