package ru.gb.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import ru.gb.model.InjectProductTitle;
import ru.gb.model.Product;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

@Component
public class InjectProductTitleBeanPostProcessor implements BeanPostProcessor {

    String[] items;

    @Autowired
    Environment environment;

    @PostConstruct
    public void init() {
        items = environment.getProperty("titleItems").split(",");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        for (Method method: bean.getClass().getDeclaredMethods()) {
            InjectProductTitle annotation = method.getAnnotation(InjectProductTitle.class);
            if (annotation != null) {
                Random random = new Random();
                for (int i = 1; i <= 5; i++) {
                    Product product = new Product(i, items[random.nextInt(items.length - 1)], costGenerator(i));
                    method.setAccessible(true);
                    try {
                        method.invoke(null, product);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }


    private String costGenerator(int number) {
        return String.format("%.2f", Math.random() * 1000 * number);
    }
}
