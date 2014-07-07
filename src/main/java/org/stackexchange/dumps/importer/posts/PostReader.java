package org.stackexchange.dumps.importer.posts;

import org.stackexchange.dumps.importer.GenericUnmarshaller;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.Iterator;
import java.util.function.Consumer;

public class PostReader implements Iterator<Post> {

    BufferedReader bufferedReader;
    private Post nextPost;
    GenericUnmarshaller<Post> postUnmarshaller;

    public PostReader(String path) throws FileNotFoundException, JAXBException {
        File file = new File(path);
        this.postUnmarshaller = new GenericUnmarshaller<Post>(Post.class);
        this.bufferedReader = new BufferedReader(new FileReader(file));
        this.nextPost = this.nextInternal();
    }

    public void close() {
        try {
            this.bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Post nextInternal() {
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                Post post = this.postUnmarshaller.unmarshal(line);
                if (post != null) return post;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return (nextPost != null);
    }

    @Override
    public Post next() {
        Post result = nextPost;
        this.nextPost = this.nextInternal();
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer<? super Post> action) {
        throw new UnsupportedOperationException();
    }
}

