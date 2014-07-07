package org.stackexchange.dumps.importer.posts;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;import java.lang.String;

import static junit.framework.Assert.assertTrue;

public class PostUnmarshallerTest {

    @Test
    public void test() throws FileNotFoundException, JAXBException {
        String line = "<row Id=\"1\" " +
                "PostTypeId=\"1\" " +
                "AcceptedAnswerId=\"2\" " +
                "CreationDate=\"2010-07-28T19:04:21.300\" " +
                "Score=\"35\" " +
                "ViewCount=\"1086\" " +
                "Body=\"&lt;p&gt;Everytime I turn on my computer, I see a message saying something like:&lt;/p&gt;&#xA;&#xA;&lt;blockquote&gt;&#xA;  &lt;p&gt;Your battery may be old or broken. Etc...&lt;/p&gt;&#xA;&lt;/blockquote&gt;&#xA;&#xA;&lt;p&gt;I know my battery is not working. How can I make the message go away?&lt;/p&gt;&#xA;\" " +
                "OwnerUserId=\"5\" " +
                "LastActivityDate=\"2012-10-21T10:45:24.437\" " +
                "Title=\"How to get the &quot;Your battery is broken&quot; message to go away?\" " +
                "Tags=\"&lt;battery&gt;&lt;notification&gt;\" " +
                "AnswerCount=\"2\" " +
                "CommentCount=\"0\" " +
                "FavoriteCount=\"3\" />";
        Post post = new PostUnmarshaller().unmarshal(line);
        assertTrue(post.getId() == 1);
        assertTrue(post.getPostTypeId() == 1);
        assertTrue(post.getOwnerUserId() == 5);
        assertTrue(post.getAnswerCount() == 2);
        assertTrue(post.getCommentCount() == 0);
        assertTrue(post.getFavoriteCount() == 3);
        assertTrue(post.getScore() == 35);
        assertTrue(post.getViewCount() == 1086);
        assertTrue(post.getBody().contains("Everytime I turn on"));
    }

}
