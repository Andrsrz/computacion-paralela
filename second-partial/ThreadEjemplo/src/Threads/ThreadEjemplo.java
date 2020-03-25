package Threads;

public class ThreadEjemplo extends Thread 
{   
    public ThreadEjemplo(String str) 
    {
    super(str);   
    }
    public void run() 
    {     
        for(int i = 0; i < 10 ; i++) 
            System.out.println(i + " " + getName()); 
        System.out.println("Termina thread " + getName());  
    }
    public static void main(String [] args)
    {     
        new ThreadEjemplo("Hilo1.1").start();
        new ThreadEjemplo("Hilo1.2").start();      
        System.out.println("Termina thread main1");
        new Thread(new ThreadEjemplo2(), "Hilo2.1").start(); 
        new Thread (new ThreadEjemplo2(), "Hilo2.2").start();
        System.out.println("Termina thread main2");
    } 
    public static class ThreadEjemplo2 implements Runnable
    {   
        public void run()
        {
            for(int i = 0; i < 10 ; i++)    
                System.out.println(i + " " + Thread.currentThread().getName()); 
            System.out.println("Termina thread " + Thread.currentThread().getName());
        }
    }
} 
