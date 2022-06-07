package org.absorb.console;

import org.absorb.AbsorbManagers;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;

import java.util.List;
import java.util.SortedSet;

public class AbsorbLineCompleter implements Completer {
    @Override
    public void complete(LineReader lineReader, ParsedLine parsedLine, List<Candidate> list) {
        SortedSet<String> suggestions =
                AbsorbManagers.getCommandManager().getTabComplete(AbsorbManagers.getConsole(), parsedLine.line());
        list.addAll(suggestions.parallelStream().map(Candidate::new).toList());
    }
}
