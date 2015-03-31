package ru.kpfu.itis.group11408.zakirov.zipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Anvar on 24.03.2015.
 */
public class ZipStream {
    public static void main(String[] args) {
        ZipStream zip = new ZipStream();
        zip.unarchive("zip.zip");
        zip.archive("arch.zip", new String[]{"README.md", "exec_zipStream_Linux.sh", "exec_zipStream_Windows"});
    }

    public void unarchive(String archiveName){
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(archiveName))){

            ZipEntry entry = null;

            while((entry = zis.getNextEntry()) != null){

                System.out.println(entry.getName());

                try(FileOutputStream fos = new FileOutputStream(entry.getName())) {
                    int data = 0;

                    while ((data = zis.read()) != -1){
                        fos.write(data);
                    }

                    fos.close();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void archive(String archiveName, String[] fileNames){
        for(String fileName : fileNames) {
            try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("arch.zip"))) {

                FileInputStream fis = new FileInputStream(fileName);

                zos.putNextEntry(new ZipEntry(fileName));

                int data = 0;
                while ((data = fis.read()) != -1) {
                    zos.write(data);
                }

            } catch (IOException ioE) {
                ioE.printStackTrace();
            }
        }
    }
}
