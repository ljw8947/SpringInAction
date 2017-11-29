package spittr.data;

import spittr.Spitter;

/**
 * Created by jwlv on 2017/11/7.
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
