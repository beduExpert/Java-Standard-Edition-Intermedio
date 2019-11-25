package org.bedu;

public class EventHandlerPersonalizado implements EventHandler {
    private double suma = 0;

    @Override
    public void procesarEvento(Object evento) {
        if(evento instanceof String){
            System.out.println("String recibido: " + evento);
        }
        else if(evento instanceof Number){
            System.out.println("Número recibido: " + evento);
            suma += ((Number) evento).doubleValue();
            System.out.println("Total de la suma: " + suma);
        }
        else{
            System.out.println("Recibido un objeto no identificado");
        }
    }
}
