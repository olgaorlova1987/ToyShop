import ru.gb.toyshop.model.writer.FileHandler;
import ru.gb.toyshop.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {

        ConsoleUI test = new ConsoleUI();
        test.setWritable(new FileHandler());
        test.start();

    }
}