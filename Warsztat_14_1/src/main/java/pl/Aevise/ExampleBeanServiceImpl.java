package pl.Aevise;

public class ExampleBeanServiceImpl implements ExampleBeanService {
   private InjectedBeanService injectedBeanService;
    @Override
    public void setInjectedBeanService(InjectedBeanService injectedBeanService) {
        this.injectedBeanService = injectedBeanService;
    }

    @Override
    public String sampleMethod(String someValue) {
        return injectedBeanService.someOtherMethod() + injectedBeanService.anotherSampleMethod(someValue);
    }
}
