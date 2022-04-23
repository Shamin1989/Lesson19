package ru.learnUp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.learnUp.events.EventListener;
import ru.learnUp.events.EventPublisher;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public final static Locale locale = Locale.getDefault();

    public final static int hiddenNumber = (int) (Math.random() * 1000);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");

        EventPublisher publisher = context.getBean(EventPublisher.class);

        Scanner scanner = new Scanner(System.in);
        int inputNumber;
        System.out.println(context.getMessage("hiMessage", null, locale));

        while (!EventListener.isFind()) {
            System.out.print(context.getMessage("inputMessage", null, locale));
            inputNumber = scanner.nextInt();
            publisher.publishEvent(inputNumber);
        }
    }
}
