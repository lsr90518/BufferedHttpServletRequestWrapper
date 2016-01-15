import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

/**
 *
 * Created by ryu_shozen on 2016/01/13.
 */
public class BufferedServletInputStream extends ServletInputStream {

    private ByteArrayInputStream inputStream;
    private ServletInputStream servletInputStream;

    public BufferedServletInputStream(byte[] buffer, ServletInputStream servletInputStream) {
        this.inputStream = new ByteArrayInputStream(buffer);
        this.servletInputStream = servletInputStream;
    }

    @Override
    public int available() throws IOException {
        return inputStream.available();
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return inputStream.read(b, off, len);
    }

    @Override
    public boolean isFinished() {
        return servletInputStream.isFinished();
    }

    @Override
    public boolean isReady() {
        return servletInputStream.isReady();
    }

    @Override
    public void setReadListener(ReadListener listener) {
        servletInputStream.setReadListener(listener);
    }
}
