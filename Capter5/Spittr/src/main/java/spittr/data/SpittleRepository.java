package spittr.data;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import spittr.Spittle;
import java.util.List;
/**
 * Created by jwlv on 2017/11/2.
 */


public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);
}
