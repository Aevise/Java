package pl.Aevise.behavioral.chain_of_responsibility;

public class Request {
    String data;

    public Request(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Request{" +
                "data='" + data + '\'' +
                '}';
    }
}
