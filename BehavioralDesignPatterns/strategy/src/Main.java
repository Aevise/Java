public class Main {
    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();
        onlineStore.addParcel(new Parcel("hehe"));
        onlineStore.addParcel(new Parcel("not hehe"));
        onlineStore.addParcel(new Parcel("ultra hehe"));

        onlineStore.deliverParcel(new CourierStrategy());
        System.out.println();
        onlineStore.deliverParcel(new ParcelLockerStrategy());
        System.out.println();
        onlineStore.deliverParcel(new PostStrategy());
        System.out.println();
//        onlineStore.deliverParcel((input)-> System.out.printf("Parcel delivered by %s using lambda", input.getName()));
    }
}
