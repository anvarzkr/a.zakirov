package ru.kpfu.itis.group11408.zakirov.classwork.stream;

import java.io.*;

/**
 * Created by Anvar on 24.03.2015.
 */
public class Stream {
    public static void main(String[] args) {
        String str = "This is string";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(str.getBytes(), 0, str.getBytes().length);
        byte[] bytes = baos.toByteArray();

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("output.txt"))){
            dos.write(bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream("input.txt"))){
            baos = new ByteArrayOutputStream();

            while (true) {
                try{
                    byte data = dis.readByte();
                    baos.write(new byte[]{data}, 0, 1);
                }catch(Exception e){
                    e.printStackTrace();
                    break;
                }
            }

            String inputString = baos.toString();

            System.out.println(inputString);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
