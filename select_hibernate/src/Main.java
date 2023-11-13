import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {

    List<Owner> listAllOwners() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();
            String query = "FROM Owner";
            List<Owner> owners = session.createQuery(query, Owner.class).list();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Owner> listAllOwners2() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();
            String query = "SELECT ow FROM Owner as ow"; //'as' jest opcjonalne
            List<Owner> owners = session.createQuery(query, Owner.class)
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Object[]> selectIDAndName() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();
            String query = "SELECT ow.id, ow.name FROM Owner as ow"; //'as' jest opcjonalne
            List<Owner> owners = session.createQuery(query, Object[].class)
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<OwnerTemp> selectIDAndNameWithRecord() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();
            String query = "SELECT new pl.Aevise.onetomany.OwnerTemp(ow.id, ow.name) FROM Owner as ow"; //'as' jest opcjonalne
            List<OwnerTemp> owners = session.createQuery(query, OwnerTemp.class)
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    Owner selectByEmail(final String email) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();
            String query = "SELECT ow FROM OWNER ow WHERE ow.email = :email";
            Owner owner = session
                    .createQuery(query, Owner.class)
                    .setParameter("email", email)
                    .getResultList();
            session.getTransaction().commit();
            return owner;
        }
    }

    Owner selectByEmailWithLike(final String email) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();
            String query = "SELECT ow FROM OWNER ow WHERE ow.email LIKE :email";
            Owner owner = session
                    .createQuery(query, Owner.class)
                    .setParameter("email", email)
                    .getResultList();
            session.getTransaction().commit();
            return owner;
        }
    }

    List<Owner> selectAllAscEmailDescName() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();
            String query = "SELECT ow FROM OWNER ORDER BY ow.email ASC, ow.name DESC";
            List<Owner> owner = session
                    .createQuery(query, Owner.class)
                    .getResultList();
            session.getTransaction().commit();
            return owner;
        }
    }

    List<Owner> selectAllFirstResultOffset(Integer offset) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();
            String query = "SELECT ow FROM Owner ow ORDER BY ow.email DESC";
            List<Owner> owners = session.createQuery(query, Owner.class)
                    .setFirstResult(offset) //mozna to rozumiec, ze zwracamy obiekty dopiero od danego offsetu
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<Owner> selectAllMaxResultOffset(Integer offset) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();
            String query = "SELECT ow FROM Owner ow ORDER BY ow.email DESC";
            List<Owner> owners = session.createQuery(query, Owner.class)
                    .setMaxResults(offset) //mozna to rozumiec, ze zwracamy obiekty dopiero od danego offsetu
                    .getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    //----------inna baza danych(usunieto scisla zaleznosc pomiedzy pet a owner - pet moze istniec bez owner)----------

    Optional<Owner> selectOptionalUniqueOwner(String name) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();
            String query = "SELECT ow FROM Owner ow WHERE ow.name = :name";
            Optional<Owner> owner = session.createQuery(query, Owner.class)
                    .setParameter("name", name)
                    .uniqueResultOptional()
                    .getResultList();
            session.getTransaction().commit();
            return owner;
        }
    }

    void selectAllInnerJoin() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();

            String query = "SELECT ow FROM Owner ow INNER JOIN ow.pets pt";
//            String query = "SELECT ow FROM Owner ow JOIN FETCH ow.pets pt";
            List<Owner> owners = session.createQuery(query, Owner.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###Entity: " + entity));
            session.getTransaction().commit();
        }
    }

    void selectAllLeftJoin() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();

            String query = "SELECT ow FROM Owner ow LEFT JOIN FETCH ow.pets pt";
            List<Owner> owners = session.createQuery(query, Owner.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###Entity: " + entity));
            session.getTransaction().commit();
        }
    }

    void selectAllRightJoin() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();

            String query = "SELECT ow FROM Owner ow RIGHT JOIN FETCH ow.pets pt";
            List<Owner> owners = session.createQuery(query, Owner.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###Entity: " + entity));
            session.getTransaction().commit();
        }
    }

    void selectAllFullJoin() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();

            String query = "SELECT ow FROM Owner ow FULL JOIN FETCH ow.pets pt";
            List<Owner> owners = session.createQuery(query, Owner.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###Entity: " + entity));
            session.getTransaction().commit();
        }
    }

    void selectAllCrossJoin() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();

            String query = "SELECT ow.name, pt.name FROM Owner ow CROSS JOIN Pet pt";
            session.createQuery(query, Object[].class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###Entity: " + Arrays.asList(entity)));
            session.getTransaction().commit();
        }
    }

    //--------------inna baza danych - dodano toy -------------------------------------------
//    CREATE TABLE TOY(
//            toy_id SERIAL NOT NULL,
//            what VARCHAR(32) NOT NULL,
//        color VARCHAR(32) NOT NULL,
//            PRIMARY KEY(toy_id)
//    );
//    CREATE TABLE pet_toy(
//            pet_toy_id SERIAL NOT NULL,
//            pet_id NOT NULL,
//            toy_id NOT NULL,
//            PRIMARY KEY(pet_toy_id),
//            CONSTRAINT fk_pet_toy_pet
//                FOREIGN KEY (pet_id)
//                    REFERENCES pet(pet_id),
//            CONSTRAINT fk_pet_toy_toy
//                    FOREIGN KEY (toy_id)
//                        REFERENCES toy (toy_id)
//    )

    void selectAllDoubleJoin() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();

            String query = """
                    SELECT ow FROM Owner ow
                    INNER JOIN FETCH ow.pets pt
                    INNER JOIN FETCH pt.toys ts
                    """;
            session.createQuery(query, Owner.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###Entity: " + entity));
            session.getTransaction().commit();
        }
    }

    void selectCountToys() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();

            String query = """
                    SELECT COUNT(t.toyId) FROM Toy t
                    """;
            session.createQuery(query, Long.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###Entity: " + entity));
            session.getTransaction().commit();
        }
    }

    void selectCountToys() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("session is null");
            }
            session.beginTransaction();

            String query = """
                    SELECT new pl.Aevise.onetomany.ToyStat(
                        MAX(t.what),
                        SUM(t.toyId)/COUNT(t.toyId)
                    ) FROM Toy t
                    """;
            session.createQuery(query, ToyStat.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###Entity: " + entity));
            session.getTransaction().commit();
        }
    }
}
