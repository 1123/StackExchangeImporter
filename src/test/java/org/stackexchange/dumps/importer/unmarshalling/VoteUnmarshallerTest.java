package org.stackexchange.dumps.importer.unmarshalling;

import org.junit.Test;
import org.stackexchange.dumps.importer.GenericUnmarshaller;
import org.stackexchange.dumps.importer.domain.SeUser;
import org.stackexchange.dumps.importer.domain.Vote;

import javax.xml.bind.JAXBException;

import static junit.framework.Assert.assertEquals;

public class VoteUnmarshallerTest {

    @Test
    public void test() throws JAXBException {
        final String line =
                "<row Id=\"87\" PostId=\"33\" VoteTypeId=\"2\" CreationDate=\"2010-07-28T00:00:00.000\" />";
        Vote vote = new GenericUnmarshaller<Vote>(Vote.class).unmarshal(line).get();
        assertEquals(vote.id, 87);
        assertEquals(vote.postId, 33);
        assertEquals(vote.voteTypeId, 2);
    }

}
