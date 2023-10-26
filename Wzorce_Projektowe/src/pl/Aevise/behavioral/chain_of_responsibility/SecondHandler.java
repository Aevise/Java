package pl.Aevise.behavioral.chain_of_responsibility;

public class SecondHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void handleRequest(Request request) {
        System.out.println("Second handler processing: " + request.getData());
        if(nextHandler != null){
            nextHandler.handleRequest(request);
        }

    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
