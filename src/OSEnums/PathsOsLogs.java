package OSEnums;

public enum PathsOsLogs {
    PATH_LINUX{
        @Override
        public String pathEnvariomentSystem(){
             String LOG_LINUX = "/usr/local/configFiles-project-pdf";
            return LOG_LINUX;
        }
    },
    PATH_WINDOWS{
        @Override
        public String pathEnvariomentSystem(){
            String LOG_WINDOWS = "C:\\Program Files\\configFiles-project-pdf";
            return LOG_WINDOWS;
        }
    },
    PATH_MACOS{
        @Override
        public String pathEnvariomentSystem(){
            final String LOG_MAC_OS = "/Applications/configFiles-project-pdf";
            return LOG_MAC_OS;
        }
    };

    public abstract String pathEnvariomentSystem();
}
