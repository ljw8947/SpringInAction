package spittr.data;

import spittr.Spitter;

/**
 * Created by jwlv on 2017/11/7.
 */
public class SpitterRepositoryImpl implements SpitterRepository {

    public Spitter save(Spitter spitter) {
        return new Spitter(24L,"mockUsername","mockPassword",
                "mockFirstName","mockLastName");
    }

    public Spitter findByUsername(String username) {
        return new Spitter(24L,"mockUsername","mockPassword",
                "mockFirstName","mockLastName");
    }
}
