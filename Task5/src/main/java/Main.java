import antlr.LangLexer;
import antlr.LangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.FilenameUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename;
        if (args.length >= 1) {
            filename = args[0];
        } else {
            System.err.println("You must provide a script file");
            return;
        }

        String className = FilenameUtils.getBaseName(filename);

        LangLexer langLexer = new LangLexer(CharStreams.fromStream(new FileInputStream(filename)));
        LangParser langParser = new LangParser(new CommonTokenStream(langLexer));
        LangParser.CodeContext codeContext = langParser.code();

        ParseTreeWalker walker = new ParseTreeWalker();
        LangParseListenerImpl langParseListener = new LangParseListenerImpl(className);
        walker.walk(langParseListener, codeContext);

        Files.write(Paths.get(className + ".class"), langParseListener.getByteCode());
        System.out.println("Done!");
    }
}
