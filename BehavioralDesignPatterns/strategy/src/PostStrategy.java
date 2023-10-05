public class PostStrategy implements DeliveryStrategy{
    @Override
    public void deliver(Parcel parcel) {
        System.out.printf("Parcel %s delivered to post%n", parcel.getName());
    }
}
