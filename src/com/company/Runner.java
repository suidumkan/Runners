package com.company;

import javax.swing.*;

public class Runner extends Thread {

    private Runner nextRunner;

    public Runner(String name, Runner nextRunner) {
        this.nextRunner = nextRunner;
        this.setName(name);
    }

    public Runner(String s) {
    }

    public void run() {
        try {
            this.sleep(5000);
        } catch (InterruptedException e) {
        }
        if (nextRunner != null) {
            nextRunner.start();
        }
        System.out.printf("\n%s берет палочку" + "\n и бежит к ", this.getName());
        if (nextRunner != null){
            System.out.println( nextRunner.getName() );
            try {
                nextRunner.join();
                this.sleep(5000);
                System.out.printf("\n%s берет палочку" +"\n и бежит к ", nextRunner.getName());
                System.out.println( this.getName() );
            } catch (InterruptedException e) {
            }
            }else{
                System.out.println(" финишу");

            }if (this.getName().equals("Runner 1 ")) {
                System.out.println(this.getName() + "берет палочку ");
            }


        }
    }

