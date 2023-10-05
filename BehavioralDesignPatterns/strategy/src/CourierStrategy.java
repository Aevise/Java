public class CourierStrategy implements DeliveryStrategy{
    @Override
    public void deliver(Parcel parcel) {
        System.out.printf("Parcel %s delivered by courier%n", parcel.getName());
    }
}
