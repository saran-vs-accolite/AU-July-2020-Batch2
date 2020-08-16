import java.io.*;
import java.util.Scanner;
import java.util.UUID;

class ToBeSerialized implements Serializable {
    UUID u1, u2, u3;
    transient UUID u4, u5;

    public UUID getU1() {
        return u1;
    }

    public UUID getU2() {
        return u2;
    }

    public UUID getU3() {
        return u3;
    }

    public UUID getU4() {
        return u4;
    }

    public UUID getU5() {
        return u5;
    }

    public ToBeSerialized(UUID u1, UUID u2, UUID u3, UUID u4, UUID u5) {
        this.u1 = u1;
        this.u2 = u2;
        this.u3 = u3;
        this.u4 = u4;
        this.u5 = u5;
    }

    private void printStringFromUUIDUtil(UUID u, int id)
    {
        if(u != null)
            System.out.println("Field " + id + ": " + u.toString());
        else
            System.out.println("Field " + id + " cannot be serialized");
    }

    public void printStringFromUUID()
    {
        printStringFromUUIDUtil(u1, 1);
        printStringFromUUIDUtil(u2, 2);
        printStringFromUUIDUtil(u3, 3);
        printStringFromUUIDUtil(u4, 4);
        printStringFromUUIDUtil(u5, 5);
    }
}

public class Program4 {
    public static void main(String []args) {
        ToBeSerialized obj = new ToBeSerialized(UUID.fromString("e4f95724-cd00-4064-acab-24efb08e3e22"), UUID.fromString("b5c7462f-dedf-41fa-b8ea-e64a63040450"), UUID.fromString("f7548a9f-cbaf-401d-b19d-8b5f401c7b62"), UUID.fromString("4fad72f7-a80a-4671-a994-6444e4987d5a"),UUID.fromString("6326fb0d-cac7-4097-ad6d-06197c1a2e8f"));

        try
        {
            FileOutputStream fOut = new FileOutputStream("Serialized.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fOut);
            objOut.writeObject(obj);
            objOut.close();
            fOut.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        try
        {
            FileInputStream fIn = new FileInputStream("Serialized.ser");
            ObjectInputStream objIn = new ObjectInputStream(fIn);

            obj = (ToBeSerialized) objIn.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        obj.printStringFromUUID();
    }
}
