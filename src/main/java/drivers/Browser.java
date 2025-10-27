package drivers;

public enum Browser {
    CHROME {
        @Override
        public AbstactDriver getDriverFactory() {
            return new ChromeFactory();
        }
    },
    EDGE {
        @Override
        public AbstactDriver getDriverFactory() {
            return new EdgeFactory();
        }
    },
    FIREFOX {
        @Override
        public AbstactDriver getDriverFactory() {
            return new FireFoxFactory();
        }
    },
    SAFARI {
        @Override
        public AbstactDriver getDriverFactory(){
            return new SafariFactory();
        }

    }
    ;




    public abstract AbstactDriver getDriverFactory();
}
