package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spittle;

import java.util.List;

/**
 * Created by jwlv on 2017/11/2.
 */
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }
}
