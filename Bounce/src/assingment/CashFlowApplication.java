package assingment;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CashFlowApplication extends Application<CashFlowConfiguration> {
    public static void main(String[] args) throws Exception {
        new CashFlowApplication().run(args);
    }

    @Override
    public String getName() {
        return "Cash -flow";
    }

    @Override
    public void initialize(Bootstrap<CashFlowConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(CashFlowConfiguration configuration,
                    Environment environment) {
        final CashFlowResource resource = new CashFlowResource();
        
            environment.jersey().register(resource);

    }

}