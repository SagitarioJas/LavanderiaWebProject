package pe.com.overux.services;

public class FactoryService {

    private static FactoryService singleton = null;

    private FactoryService() {

    }

    public static synchronized FactoryService getInstance() {
        if (singleton == null) {
            singleton = new FactoryService();
        }
        return singleton;
    }





}
