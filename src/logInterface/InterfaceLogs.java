package logInterface;

import logClasses.LogEntry;

import java.io.IOException;

import java.util.List;

public interface InterfaceLogs {
    public List<LogEntry> sendBackInformationLog() throws  IOException;
    public void createdLog(String nameBook, Integer page, Float zoom) throws IOException;
}
