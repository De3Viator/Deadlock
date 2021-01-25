package com.test.deadlock;

public class Deadlock implements Runnable {
    @Override
    public void run() {
        doSquare();
        doTriangle();
    }

    private static class Resource{

    }
    private final Resource pencil = new Resource();
    private final Resource ruler = new Resource();


    public void doTriangle(){
        synchronized (pencil) {
            System.out.println(Thread.currentThread().getName() + "взял карандаш для черчения треугольника");
            synchronized (ruler) {
                System.out.println(Thread.currentThread().getName() + "взял линейку для черчения треугольника");
                System.out.println(Thread.currentThread().getName() + "чертит треугольник");
            }
        }
    }

    public void doSquare() {
        synchronized (pencil) {
            System.out.println(Thread.currentThread().getName() + "взял карандаш для черчения квадрата");{
                synchronized (ruler) {
                    System.out.println(Thread.currentThread().getName() + "взял линейку для черчения треугольника");
                    System.out.println(Thread.currentThread().getName() + "чертит треугольник");

                }
            }
        }
    }

    public static void main (String [] Args){
        Deadlock job = new Deadlock();
        Thread pavel = new Thread(job,"Павел");
        Thread victor = new Thread(job, "Виктор");
        pavel.start();
        victor.start();
    }
}