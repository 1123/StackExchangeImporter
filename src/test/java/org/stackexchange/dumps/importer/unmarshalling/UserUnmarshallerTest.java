package org.stackexchange.dumps.importer.unmarshalling;

import org.junit.Test;
import org.stackexchange.dumps.importer.services.GenericUnmarshaller;
import org.stackexchange.dumps.importer.domain.SeUser;

import javax.xml.bind.JAXBException;

import static junit.framework.Assert.assertEquals;

public class UserUnmarshallerTest {

    // TODO: test parsing of dates.

    @Test
    public void test() throws JAXBException {
        final String line = "<row Id=\"-1\" " +
                "Reputation=\"1\" " +
                "CreationDate=\"2010-07-28T16:38:27.683\" " +
                "DisplayName=\"Community\" " +
                "LastAccessDate=\"2010-07-28T16:38:27.683\" " +
                "Location=\"on the server farm\" " +
                "AboutMe=\"&lt;p&gt;Hi, I'm not really a person.&lt;/p&gt;&#xD;&#xA;&lt;p&gt;I'm a background process that helps keep this site clean!&lt;/p&gt;&#xD;&#xA;&lt;p&gt;I do things like&lt;/p&gt;&#xD;&#xA;&lt;ul&gt;&#xD;&#xA;&lt;li&gt;Randomly poke old unanswered questions every hour so they get some attention&lt;/li&gt;&#xD;&#xA;&lt;li&gt;Own community questions and answers so nobody gets unnecessary reputation from them&lt;/li&gt;&#xD;&#xA;&lt;li&gt;Own downvotes on spam/evil posts that get permanently deleted&lt;/li&gt;&#xD;&#xA;&lt;li&gt;Own suggested edits from anonymous users&lt;/li&gt;&#xD;&#xA;&lt;/ul&gt;\" " +
                "Views=\"0\" " +
                "UpVotes=\"891\" " +
                "DownVotes=\"11395\" " +
                "EmailHash=\"a007be5a61f6aa8f3e85ae2fc18dd66e\" />";
        SeUser user = new GenericUnmarshaller<SeUser>(SeUser.class).unmarshal(line).get();
        assertEquals(user.id, -1);
        assertEquals(user.reputation, 1);
        assertEquals(user.displayName, "Community");
        assertEquals(user.location, "on the server farm");
        assertEquals(user.views, 0);
        assertEquals(user.upVotes, 891);
        assertEquals(user.downVotes, 11395);
    }

}
