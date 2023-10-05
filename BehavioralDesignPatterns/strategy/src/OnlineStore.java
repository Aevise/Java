import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class OnlineStore {
    private List<Parcel> parcelList = new ArrayList<>();

    public void addParcel(final Parcel parcel){
        parcelList.add(parcel);
    }

    public void deliverParcel(DeliveryStrategy deliveryStrategy){
        for (Parcel parcel : parcelList) {
            deliveryStrategy.deliver(parcel);
        }
    }

    public void deliverParcel(Consumer<Parcel> strategy){
        for (Parcel parcel : parcelList) {
            strategy.accept(parcel);
        }
    }
}
