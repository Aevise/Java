public class ParcelLockerStrategy implements DeliveryStrategy{
    @Override
    public void deliver(Parcel parcel) {
        System.out.printf("Parcel %s delivered to locker%n", parcel.getName());
    }
}
