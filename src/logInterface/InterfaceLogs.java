package logInterface;

import logClasses.LogEntry;

import java.io.IOException;

import java.util.List;

public interface InterfaceLogs {
    public void logNewBook(String nameBook, Integer page, Float zoom) throws IOException;
    public void createLog(String name, Integer page, Float zoom) throws IOException;
    public List<LogEntry> sendBackInformationLog() throws  IOException;

}
