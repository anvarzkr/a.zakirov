package ru.kpfu.itis.group11408.zakirov.finder;

import org.apache.commons.cli.*;
import java.io.File;

/**
 * Created by Anvar on 03.03.2015.
 */
public class Finder {
    public File currentFile = new File("C:/");
    public boolean isRecursive = false;
    public boolean isShowingDirs = false;
    public int depth = 0;
    public String searchingString = "";
    public String match = "";

    public Finder(File currentFile, boolean recursive, boolean showDirs, int depth, String searchingString) {
        this.currentFile = currentFile;
        this.isRecursive = recursive;
        this.isShowingDirs = showDirs;
        this.depth = depth;
        this.searchingString = searchingString;
        this.match = "(?i).*"+searchingString.toLowerCase()+".*";
    }

    public static void main(String[] args) {
        Finder finder = getFinder(args);

        System.out.println("Matching string = " + finder.match);
        finder.find(finder.currentFile, 0);

    }

    public void printIfMatch(File fileItem){
        if (fileItem.getName().toLowerCase().matches(this.match)){
            if (fileItem.isDirectory() && this.isShowingDirs){
                System.out.println(fileItem.getAbsoluteFile());
            }else if (!fileItem.isDirectory()){
                System.out.println(fileItem.getAbsoluteFile());
            }
        }
    }

    public void find(File file, int depth){
        if (file.listFiles() != null && file.listFiles().length > 0)
            for (File fileItem : file.listFiles()){
                printIfMatch(fileItem);
                if (fileItem.isDirectory() && (this.isRecursive || depth < this.depth))
                    find(fileItem, depth + 1);
            }
        printIfMatch(file);
    }

    private static Finder getFinder(String[] args){
        Option option_1 = new Option("r", "recursive", false, "Recursive find");
        Option option_2 = new Option("d", "depth", true, "Depth while finding");
        Option option_3 = new Option("v", "showdirs", false, "Show directories");
        Option option_4 = new Option("fp", "findingPath", true, "Start point path");
        Option option_5 = new Option("ss", "searchingString", true, "Searching file/folder");
        option_1.setArgs(0); // число аргументов в опции
        option_3.setArgs(0); // число аргументов в опции

        option_2.setArgs(1); // число аргументов в опции
        option_2.setOptionalArg(false);// являются ли аргументы необязательными для ввода, по умолчанию аргументы обязательны для ввода, так что эту строчку можно было опутить
        option_2.setArgName("finding depth ");//имя аргумета, именно так аргумент будет отображатся в справка по использованию командной строки.

        option_4.setArgs(1); // число аргументов в опции
        option_4.setOptionalArg(false);// являются ли аргументы необязательными для ввода, по умолчанию аргументы обязательны для ввода, так что эту строчку можно было опутить
        option_4.setArgName("start path ");//имя аргумета, именно так аргумент будет отображатся в справка по использованию командной строки.

        option_5.setArgs(1); // число аргументов в опции
        option_5.setOptionalArg(false);// являются ли аргументы необязательными для ввода, по умолчанию аргументы обязательны для ввода, так что эту строчку можно было опутить
        option_5.setArgName("searching string ");//имя аргумета, именно так аргумент будет отображатся в справка по использованию командной строки.

        Options posixOptions = new Options();
        posixOptions.addOption(option_1);
        posixOptions.addOption(option_2);
        posixOptions.addOption(option_3);
        posixOptions.addOption(option_4);
        posixOptions.addOption(option_5);
        CommandLineParser cmdLinePosixParser = new PosixParser();// создаем Posix парсер

        boolean rec = false;
        boolean showDirs = false;
        int depth = 0;
        String dir = "C:/";
        String searchingString = "";

        try {
            CommandLine commandLine = cmdLinePosixParser.parse(posixOptions, args);// парсим командную строку
            if (commandLine.hasOption("r")) {
                rec = true;
                System.out.println("Option: Recursive call - on");
            }
            if (commandLine.hasOption("d")) {
                String[] arguments = commandLine.getOptionValues("d");

                try {
                    depth= Integer.parseInt(arguments[0]);
                }catch (NumberFormatException e){
                    depth= 0;
                }

                System.out.println("Option: Depth call (Depth = " + depth + ") - on");
            }
            if (commandLine.hasOption("v")) {
                showDirs = true;
                System.out.println("Option: Show directories - on");
            }
            if (commandLine.hasOption("fp")) {
                String[] arguments = commandLine.getOptionValues("fp");

                if (new File(arguments[0]).exists())
                    dir = arguments[0];

                System.out.println("Option: Start path = " + dir);
            }
            if (commandLine.hasOption("ss")) {
                String[] arguments = commandLine.getOptionValues("ss");

                searchingString = arguments[0];

                System.out.println("Option: Searching string = " + searchingString);
            }
        }catch (ParseException e){
            e.fillInStackTrace();
        }

        return new Finder(new File(dir), rec, showDirs, depth, searchingString);
    }
}
