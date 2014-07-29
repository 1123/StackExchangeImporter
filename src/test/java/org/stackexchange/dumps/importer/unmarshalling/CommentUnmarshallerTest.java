package org.stackexchange.dumps.importer.unmarshalling;

import org.junit.Test;
import org.stackexchange.dumps.importer.GenericUnmarshaller;
import org.stackexchange.dumps.importer.domain.Comment;
import org.stackexchange.dumps.importer.domain.SeUser;

import javax.xml.bind.JAXBException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class CommentUnmarshallerTest {

    // TODO: test parsing of dates.

    @Test
    public void test() throws JAXBException {
        final String line = "<row Id=\"57\" PostId=\"62\" " +
                "Score=\"3\" " +
                "Text=\"Marco, thank you for your answer, you seem to have an excellent grasp of home folder encryption. Just for the benefit of less technical users, can you spare me all the technical detail and answer the question as if I were asking as a computer-illiterate user?\" " +
                "CreationDate=\"2010-07-28T20:00:33.260\" UserId=\"56\" />";
        Comment comment = new GenericUnmarshaller<Comment>(Comment.class).unmarshal(line).get();
        assertEquals(comment.id, 57);
        assertEquals(comment.postId, 62);
        assertEquals(comment.score, 3);
        // TODO: check creationDate
        assertTrue(comment.text.contains("Marco, than"));
        assertEquals(comment.userId, 56);
    }

}
