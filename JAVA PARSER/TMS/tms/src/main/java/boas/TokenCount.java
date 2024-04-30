package boas;






import com.github.javaparser.JavaParser;
import com.github.javaparser.JavaToken;
import com.github.javaparser.JavaToken.Category;
import com.github.javaparser.ParseException;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class TokenCount {

    public static void main(String[] args) {

        // initialize a map to count token types
        Map<Category, Integer> tokenTypeCount = new HashMap<>();

        String sourceDirectory = "C:/Users/TRIBE OF MENTORS/Desktop/JAVA PARSER/TMS/tms/src/main/java/boas/TeamManagement.java";
        File projectDir = new File(sourceDirectory);

        try {
            // create a java parser object

            JavaParser javaParser = new JavaParser();

            // parse the file

            ParseResult<CompilationUnit> parseResult = javaParser.parse(projectDir);

            // Check if parsing was successful
            if (parseResult.isSuccessful()) {
                // Get the CompilationUnit from the ParseResult
                CompilationUnit cu = parseResult.getResult().get();

                // initialize variable to count tokens
                AtomicInteger tokenCount = new AtomicInteger(0);

                // Now you can work with the CompilationUnit
                cu.getTokenRange().ifPresent(tokenRange -> {
                    // For each token, print it and increment the count
                    for (JavaToken token : tokenRange) {
                        System.out.print(token.getText() + " ");
                        tokenCount.incrementAndGet();
                    }
                });

                System.out.println("Total number or tokens: " + tokenCount.get());

            } else {
                // If parsing failed, print the parse error
                System.err.println("Parsing failed: " + parseResult.getProblems());
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}