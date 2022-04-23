package ru.learnUp.events;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import ru.learnUp.Main;

import java.util.Locale;


public class EventListener implements ApplicationListener<Event>, ApplicationContextAware {

    private static boolean find = false;

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static boolean isFind() {
        return find;
    }

    @Override
    public void onApplicationEvent(Event event) {
        Locale locale = Main.locale;
        int desiredNumber = Main.hiddenNumber;
        if (event.getInputNumber() < desiredNumber) {
            System.out.println(context.getMessage("moreMessage", null, locale));
        } else if (event.getInputNumber() > desiredNumber) {
            System.out.println(context.getMessage("lessMessage", null, locale));
        } else {
            System.out.println(context.getMessage("findMessage", new Object[]{desiredNumber}, locale));
            find = true;
        }
    }
}
