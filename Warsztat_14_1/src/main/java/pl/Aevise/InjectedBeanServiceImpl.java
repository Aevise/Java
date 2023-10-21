package pl.Aevise;

public class InjectedBeanServiceImpl implements  InjectedBeanService{
    @Override
    public String anotherSampleMethod(String someStringValue){
        return someStringValue + "hehe";


    }

    @Override
    public String someOtherMethod() {
        return "some other value";
    }
}
