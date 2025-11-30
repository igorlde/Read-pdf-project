package logInterface;

import java.io.IOException;
import java.time.LocalDateTime;

public interface InterfaceLogs {
    public void logNewBook(String nameBook, Integer page, Float zoom) throws IOException;
    public void createLog(String name, Integer page, Float zoom) throws IOException;

}
