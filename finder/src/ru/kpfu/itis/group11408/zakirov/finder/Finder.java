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
        System.out.println();
        System.out.println();
        System.out.println("Type -help for some instructions");
        ArgsParser parser = new ArgsParser();
        parser.init(args);
        Finder finder = getFinder(parser);
        System.out.println();
        System.out.println("Matching filenames:");
        finder.find(finder.currentFile, 0);

    }

    public void printIfMatch(File fileItem){
        if (fileItem.getName().toLowerCase().matches(this.match)){
            if (fileItem.isDirectory() && this.isShowingDirs){
                System.out.println(fileItem.getAbsolutePath());
            }else if (!fileItem.isDirectory()){
                System.out.println(fileItem.getAbsolutePath());
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

    private static Finder getFinder(ArgsParser parser){
        return new Finder(new File(parser.dir), parser.rec, parser.showDirs, parser.depth, parser.searchingString);
    }

    static class ArgsParser {
        public static boolean rec = false;
        public static boolean showDirs = false;
        public static boolean dirNotExists = false;
        public static int depth = 0;
        public static String dir = System.getProperty("user.dir");
        public static String searchingString = "";

        public void init(String[] args){
            Option option_1 = new Option("r", "recursive", false, "Recursive find");
            Option option_2 = new Option("d", "depth", true, "Depth while finding");
            Option option_3 = new Option("v", "showdirs", false, "Show directories");
            Option option_4 = new Option("fp", "findingPath", true, "Start point path");
            Option option_5 = new Option("ss", "searchingString", true, "Searching file/folder");
            Option option_6 = new Option("help", "help", false, "Help instructions");
            option_1.setArgs(0); // число аргументов в опции
            option_3.setArgs(0); // число аргументов в опции
            option_6.setArgs(0); // число аргументов в опции

            option_2.setArgs(1); // число аргументов в опции
            option_2.setOptionalArg(true);// являются ли аргументы необязательными для ввода, по умолчанию аргументы обязательны для ввода, так что эту строчку можно было опутить
            option_2.setArgName("finding depth ");//имя аргумета, именно так аргумент будет отображатся в справка по использованию командной строки.

            option_4.setArgs(1); // число аргументов в опции
            option_4.setOptionalArg(true);// являются ли аргументы необязательными для ввода, по умолчанию аргументы обязательны для ввода, так что эту строчку можно было опутить
            //option_4.setRequired(true);
            option_4.setArgName("start path ");//имя аргумета, именно так аргумент будет отображатся в справка по использованию командной строки.

            option_5.setArgs(1); // число аргументов в опции
            option_5.setOptionalArg(true);// являются ли аргументы необязательными для ввода, по умолчанию аргументы обязательны для ввода, так что эту строчку можно было опутить
            //option_5.setRequired(true);
            option_5.setArgName("searching string ");//имя аргумета, именно так аргумент будет отображатся в справка по использованию командной строки.

            Options posixOptions = new Options();
            posixOptions.addOption(option_1);
            posixOptions.addOption(option_2);
            posixOptions.addOption(option_3);
            posixOptions.addOption(option_4);
            posixOptions.addOption(option_5);
            posixOptions.addOption(option_6);
            CommandLineParser cmdLinePosixParser = new PosixParser();// создаем Posix парсер

            try {
                CommandLine commandLine = cmdLinePosixParser.parse(posixOptions, args);// парсим командную строку
                if (commandLine.hasOption("help")) {
                    System.out.println("Help:");
                    System.out.println("[-v] - Printing folders which match searching string");
                    System.out.println("[-r] - Recursive finding that doesnt depend of Depth value. It goes deeper into every folder.");
                    System.out.println("[-d] - Setting searching Depth value. Default = 0. If there's [-r] option, Depth value dont do anything.");
                    System.out.println("[-fp] - Finding start Path. Folder from what point searching is starting.");
                    System.out.println("[-ss] - Searching String. String that matching while searching.");
                    return;
                }
                if (commandLine.hasOption("r")) {
                    rec = true;
                }
                if (commandLine.hasOption("d")) {
                    String[] arguments = commandLine.getOptionValues("d");

                    try {
                        depth= Integer.parseInt(arguments[0]);
                    }catch (NumberFormatException e){
                        System.out.println("Option depth is set to default VALUE 0! Because you typed not correct number.");
                        depth = 0;
                    }
                }
                if (commandLine.hasOption("v")) {
                    showDirs = true;
                }
                if (commandLine.hasOption("fp")) {
                    String[] arguments = commandLine.getOptionValues("fp");

                    if (arguments != null){
                        if (new File(arguments[0]).exists()){
                            dir = arguments[0];
                        }else{
                            dirNotExists = true;
                        }
                    }else{
                        //throw new IOException("You should type a correct START FINDING PATH if you are trying to use -fp option!");
                        dirNotExists = true;
                    }

                }else{
                    System.out.println("Finding start Path is CURRENT FOLDER by default");
                }
                if (commandLine.hasOption("ss")) {
                    String[] arguments = commandLine.getOptionValues("ss");

                    searchingString = arguments[0];
                }
                System.out.println("Option: [-fp PATH] Finding start Path = " + ((!dirNotExists) ? dir : "CURRENT FOLDER, because you type path that not exists!"));
                System.out.println("Option: [-ss MATCH] Searching String = '" + searchingString + "'");
                System.out.println("Option: [-r] Recursive call = " + rec);
                System.out.println("Option: [-d N] Depth call (Depth = " + depth + ") = " + ((rec == true) ? "false because it's recursive call" : "true"));
                System.out.println("Option: [-v] Show directories = " + showDirs);

            }catch (ParseException e){
                e.fillInStackTrace();
            }
        }
    }


}
