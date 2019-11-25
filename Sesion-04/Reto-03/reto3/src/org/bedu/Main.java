package org.bedu;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        EventLoopSimple eventLoop = new EventLoopSimple(new EventHandlerPersonalizado());

        eventLoop.iniciar();
        eventLoop.registrarEvento("Hola mundo");

        try {
            TimeUnit.MILLISECONDS.sleep(500); //simulando acciones diferentes con un sleep
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eventLoop.registrarEvento(1);
        eventLoop.registrarEvento("Adiós");
        eventLoop.registrarEvento(10.0);
        eventLoop.registrarEvento(new Object());

        eventLoop.detener();
    }
}
