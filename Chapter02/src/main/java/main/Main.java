package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        Parrot p2 = context.getBean("parrot2", Parrot.class);
        System.out.println(p2.getName());

        Parrot p3 = (Parrot) context.getBean("Riki");
        System.out.println(p3.getName());

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer n = context.getBean(Integer.class);
        System.out.println(n);


        Parrot parrot = new Parrot();
        parrot.setName("New Parrot");

        Supplier<Parrot> parrotSupplier = () -> parrot;

        context.registerBean("parrot1",
                Parrot.class,
                parrotSupplier,
                beanConfig -> beanConfig.setPrimary(true));

        Parrot newParrot = (Parrot) context.getBean("parrot1");
        System.out.println(newParrot.getName());
    }
}
