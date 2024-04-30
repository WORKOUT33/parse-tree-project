package boas;


import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.DotPrinter;
import com.github.javaparser.printer.YamlPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ASTPrinter {

    // Creating the path for the program to be parsed
    public static final String PATH = "C:/Users/TRIBE OF MENTORS/Desktop/JAVA PARSER/TMS/tms/src/main/java/boas/TeamManagement.java";

    public static void main(String[] args) throws Exception {

        File path = new File(PATH);

        CompilationUnit cu = StaticJavaParser.parse(path);

        // This method outputs the AST using pretty printing hence just like the written
        // program
        // System.out.println(cu);

        // This prints the AST
        YamlPrinter printer = new YamlPrinter(true);
        System.out.println(printer.output(cu));

        // This is the cool way to print thee AST.
        // it outputs the AST as a dot file which can be visualized as a graph with
        // Graphviz

        // Now comes the inspection code:
        DotPrinter astPrinter = new DotPrinter(true);

        try (FileWriter fileWriter = new FileWriter("ast.dot");
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(astPrinter.output(cu));

        }

    }

}
