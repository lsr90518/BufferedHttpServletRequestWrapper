import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by ryu_shozen.
 */
public class BufferedHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private ServletInputStream is;
    private byte[] buffer;

    public BufferedHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);

        ServletInputStream is = request.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte buff[] = new byte[1024];
        int read;
        while ((read = is.read(buff)) > 0) {
            baos.write(buff, 0, read);
        }

        this.buffer = baos.toByteArray();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new BufferedServletInputStream(this.buffer, is);
    }
}
