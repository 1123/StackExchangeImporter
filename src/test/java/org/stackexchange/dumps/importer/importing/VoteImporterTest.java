package org.stackexchange.dumps.importer.importing;

import org.junit.Test;
import org.stackexchange.dumps.importer.GenericImporter;
import org.stackexchange.dumps.importer.domain.SeUser;
import org.stackexchange.dumps.importer.domain.Vote;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class VoteImporterTest {

    private static final String VOTES_FILE = "src/test/resources/Votes.xml";

    @Test
    public void test() throws FileNotFoundException, JAXBException {
        GenericImporter.importFile(100l, VOTES_FILE, Vote.class);
    }

}
