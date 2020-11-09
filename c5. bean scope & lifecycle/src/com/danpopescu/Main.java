package com.danpopescu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("Initial # of tasks: " + Task.getNumberOfTasks());

        Task prototype1 = ctx.getBean("prototypeTask", Task.class);
        System.out.println("Created one prototype task. Total # of tasks: " + Task.getNumberOfTasks());
        Task prototype2 = ctx.getBean("prototypeTask", Task.class);
        System.out.println("Created one prototype task. Total # of tasks: " + Task.getNumberOfTasks());
        Task prototype3 = ctx.getBean("prototypeTask", Task.class);
        System.out.println("Created one prototype task. Total # of tasks: " + Task.getNumberOfTasks());

        prototype1.run();
        prototype2.run();
        prototype3.run();

        Task singleton = ctx.getBean("singletonTask", Task.class);
        singleton.run();

        ctx.close();

        System.out.println("Context closed. Number of tasks remained: " + Task.getNumberOfTasks());
    }
}
